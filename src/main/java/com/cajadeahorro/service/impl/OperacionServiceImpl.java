package com.cajadeahorro.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.cajadeahorro.component.OperacionConverter;
import com.cajadeahorro.entity.Caja;
import com.cajadeahorro.entity.Cliente;
import com.cajadeahorro.entity.Operacion;
import com.cajadeahorro.entity.Prestamo;
import com.cajadeahorro.model.MovimientoCajaModel;
import com.cajadeahorro.model.OperacionModel;
import com.cajadeahorro.model.PrestamoModel;
import com.cajadeahorro.repository.OperacionRepository;
import com.cajadeahorro.repository.PrestamoRepository;
import com.cajadeahorro.service.CajaService;
import com.cajadeahorro.service.ClienteService;
import com.cajadeahorro.service.OperacionService;
import com.cajadeahorro.service.PrestamoService;

/**
 * The Class OperacionServiceImpl.
 */
@Service("operacionServiceImpl")
public class OperacionServiceImpl implements OperacionService {

	/** The prestamo repository. */
	@Autowired
	@Qualifier("prestamoRepository")
	private PrestamoRepository prestamoRepository;

	/** The operacion repository. */
	@Autowired
	@Qualifier("operacionRepository")
	private OperacionRepository operacionRepository;

	/** The operacion converter. */
	@Autowired
	@Qualifier("operacionConverter")
	private OperacionConverter operacionConverter;

	/** The cliente service. */
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;

	/** The caja service. */
	@Autowired
	@Qualifier("cajaServiceImpl")
	private CajaService cajaService;

	/** The prestamo service. */
	@Autowired
	@Qualifier("prestamoServiceImpl")
	private PrestamoService prestamoService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cajadeahorro.service.OperacionService#realizarDepositoCuenta(com.
	 * cajadeahorro.model.OperacionModel)
	 */
	@Override
	public OperacionModel realizarDepositoCuenta(OperacionModel operacionModel) {
		Cliente cliente = getCliente();
		Caja cajaAhorro = cajaService.findByTipo("ahorro");
		BigDecimal monto = new BigDecimal(operacionModel.getMonto());
		
		cliente.addDineroAhorro(monto);
		cajaAhorro.addMonto(monto);

		operacionModel = poblarModelo(operacionModel, cliente.getNombreusuario(), "Depósito a cuenta", "Éxito");
		Operacion deposito = operacionRepository.save(operacionConverter.model2Entity(operacionModel));

		return operacionConverter.entity2Model(deposito);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cajadeahorro.service.OperacionService#realizarDepositoPrestamo(com.
	 * cajadeahorro.model.OperacionModel)
	 */
	@Override
	public OperacionModel realizarDepositoPrestamo(OperacionModel operacionModel) {
		Cliente cliente = getCliente();
		OperacionModel deposito = new OperacionModel();
		BigDecimal montoDeposito = new BigDecimal(operacionModel.getMonto());
		Caja cajaAhorro = cajaService.findByTipo("ahorro");
		Caja cajaRetenido = cajaService.findByTipo("retencion");
		Caja cajaPrestamo = cajaService.findByTipo("prestamo");
		int idPrestamo = operacionModel.getId();
		Prestamo prestamo = prestamoService.findById(idPrestamo);
		BigDecimal saldo = prestamo.getSaldo();
		BigDecimal retenido = prestamo.getDineroretenido();

		if (prestamo.getSaldo().compareTo(montoDeposito) == 1) {
			prestamo.subSaldo(montoDeposito);
			deposito.setMonto(operacionModel.getMonto());
			cliente.subDineroprestamo(montoDeposito);
			cajaAhorro.addMonto(montoDeposito);
			cajaPrestamo.subMonto(montoDeposito);
		} else {
			prestamoService.delete(idPrestamo);
			deposito.setMonto(String.valueOf(saldo));
			cliente.subDineroprestamo(saldo);
			cliente.subDineroretenido(retenido);
			cajaRetenido.subMonto(retenido);
			cajaPrestamo.subMonto(saldo);
			cajaAhorro.addMonto(saldo);
		}

		deposito = poblarModelo(deposito, cliente.getNombreusuario(), "Depósito a préstamo", "Éxito");
		Operacion operacion = operacionRepository.save(operacionConverter.model2Entity(deposito));

		return operacionConverter.entity2Model(operacion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cajadeahorro.service.OperacionService#realizarRetiro(com.cajadeahorro.
	 * model.OperacionModel)
	 */
	@Override
	public OperacionModel realizarRetiro(OperacionModel operacionModel) {
		Operacion retiro;
		String estadoRetiro;
		Cliente cliente = getCliente();
		Caja cajaAhorro = cajaService.findByTipo("ahorro");
		BigDecimal ahorroCliente = cliente.getDineroahorro();
		BigDecimal dineroRetenidoCliente = cliente.getDineroretenido();
		BigDecimal montoRetiro = new BigDecimal(operacionModel.getMonto());

		if (cajaAhorro.getCantidad().compareTo(montoRetiro) >= 0
				&& (ahorroCliente.subtract(dineroRetenidoCliente).compareTo(montoRetiro) >= 0)) {
			estadoRetiro = "Éxito";
			cliente.subDineroAhorro(montoRetiro);
			cajaAhorro.subMonto(montoRetiro);
		} else {
			estadoRetiro = "Error";
		}

		operacionModel = poblarModelo(operacionModel, cliente.getNombreusuario(), "Retiro de cuenta", estadoRetiro);
		retiro = operacionRepository.save(operacionConverter.model2Entity(operacionModel));

		return estadoRetiro.equals("Error") ? null : operacionConverter.entity2Model(retiro);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cajadeahorro.service.OperacionService#solicitarPrestamo(com.cajadeahorro.
	 * model.PrestamoModel)
	 */
	@Override
	public OperacionModel solicitarPrestamo(PrestamoModel prestamoModel) {
		String estado;
		BigDecimal interes = BigDecimal.ZERO;
		Cliente cliente = getCliente();
		BigDecimal montoPrestamo = new BigDecimal(prestamoModel.getMonto());
		int plazoPrestamo = prestamoModel.getPlazo();
		Caja cajaAhorro = cajaService.findByTipo("ahorro");
		Caja cajaPrestamo = cajaService.findByTipo("prestamo");
		Caja cajaRetenido = cajaService.findByTipo("retencion");
		BigDecimal montoARetener = montoPrestamo.multiply(new BigDecimal(0.2));
		OperacionModel operacionModel = new OperacionModel();

		if (montoPrestamo.compareTo(cajaAhorro.getCantidad()) <= 0
				&& (montoARetener.compareTo(cliente.getDineroahorro().subtract(cliente.getDineroretenido()))) <= 0) {
			estado = "Exito";
			switch (plazoPrestamo) {
			case 3:
				interes = new BigDecimal(0.08);
				break;
			case 6:
				interes = new BigDecimal(0.04);
				break;
			case 9:
				interes = new BigDecimal(0.02);
				break;
			}
			cliente.addDineroprestamo(montoPrestamo.multiply(BigDecimal.ONE.add(interes)));
			cliente.addDineroretenido(montoARetener);
			cajaAhorro.subMonto(montoPrestamo);
			cajaPrestamo.addMonto(montoPrestamo);
			cajaRetenido.addMonto(montoARetener);
			Prestamo prestamo = new Prestamo(montoPrestamo, montoPrestamo.multiply(BigDecimal.ONE.add(interes)),
					cliente.getNombreusuario(), montoARetener, plazoPrestamo);
			prestamoRepository.save(prestamo);
		} else {
			estado = "Error";
		}

		operacionModel.setMonto(String.valueOf(montoPrestamo));
		operacionModel = poblarModelo(operacionModel, cliente.getNombreusuario(), "Préstamo", estado);

		Operacion operacion = operacionRepository.save(operacionConverter.model2Entity(operacionModel));

		return estado.equals("Error") ? null : operacionConverter.entity2Model(operacion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cajadeahorro.service.OperacionService#realizarAportacion(com.cajadeahorro
	 * .model.OperacionModel)
	 */
	@Override
	public OperacionModel realizarAportacion(OperacionModel operacionModel) {
		operacionModel = poblarModelo(operacionModel, getCliente().getNombreusuario(), "Aportación", "Éxito");

		Operacion aportacion = operacionRepository.save(operacionConverter.model2Entity(operacionModel));

		return operacionConverter.entity2Model(aportacion);
	}

	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	private Cliente getCliente() {
		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return clienteService.findByNombreusuario(usuario.getUsername());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cajadeahorro.service.OperacionService#findByCliente(java.lang.String)
	 */
	@Override
	public List<OperacionModel> findByCliente(String cliente) {
		List<Operacion> operacionEntities = operacionRepository.findByCliente(cliente);

		return listConverter(operacionEntities);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cajadeahorro.service.OperacionService#findAll()
	 */
	@Override
	public List<OperacionModel> findAll() {
		List<Operacion> operacionEntities = operacionRepository.findAll();

		return listConverter(operacionEntities);
	}

	/**
	 * List converter.
	 *
	 * @param operacionEntities the operacion entities
	 * @return the list
	 */
	private List<OperacionModel> listConverter(List<Operacion> operacionEntities) {
		List<OperacionModel> operacionModels = new ArrayList<>();

		for (Operacion operacion : operacionEntities) {
			operacionModels.add(operacionConverter.entity2Model(operacion));
		}

		return operacionModels;
	}

	/**
	 * Poblar modelo.
	 *
	 * @param operacionModel the operacion model
	 * @param cliente        the cliente
	 * @param tipo           the tipo
	 * @param estado         the estado
	 * @return the operacion model
	 */
	private OperacionModel poblarModelo(OperacionModel operacionModel, String cliente, String tipo, String estado) {
		operacionModel.setCliente(cliente);
		operacionModel.setTipo(tipo);
		operacionModel.setEstado(estado);
		operacionModel.setFecha(new Date());

		return operacionModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cajadeahorro.service.OperacionService#movimientoCaja(com.cajadeahorro.
	 * model.MovimientoCajaModel)
	 */
	@Override
	public MovimientoCajaModel movimientoCaja(MovimientoCajaModel movimientoCajaModel) {		
		String tipoMovimiento = movimientoCajaModel.getTipo();
		BigDecimal montoMovimiento = new BigDecimal(movimientoCajaModel.getCantidad());
		String modoMovimiento = movimientoCajaModel.getModo();
		Caja caja = cajaService.findByTipo(tipoMovimiento);

		if (modoMovimiento.equals("sumar")) {
			caja.addMonto(montoMovimiento);
		} else {
			if (montoMovimiento.compareTo(caja.getCantidad()) <= 0) {
				caja.subMonto(montoMovimiento);
			} else {
				return null;
			}
		}

		return movimientoCajaModel;
	}

}