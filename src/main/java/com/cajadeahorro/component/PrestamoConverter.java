package com.cajadeahorro.component;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cajadeahorro.entity.Prestamo;
import com.cajadeahorro.model.PrestamoModel;
import com.cajadeahorro.repository.ClienteRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PrestamoConverter.
 */
@Component("prestamoConverter")
public class PrestamoConverter {

	/** The cliente repository. */
	@Autowired
	@Qualifier("clienteRepository")
	private ClienteRepository clienteRepository;

	/**
	 * Model 2 entity.
	 *
	 * @param prestamoModel the prestamo model
	 * @return the prestamo
	 */
	public Prestamo model2Entity(PrestamoModel prestamoModel) {
		Prestamo prestamo = new Prestamo();

		prestamo.setId(prestamoModel.getId());
		prestamo.setCliente(prestamoModel.getCliente());
		prestamo.setMonto(new BigDecimal(prestamoModel.getMonto()));
		prestamo.setSaldo(prestamoModel.getSaldo());
		prestamo.setPlazo(prestamoModel.getPlazo());
		prestamo.setDineroretenido(prestamoModel.getDineroretenido());

		return prestamo;
	}

	/**
	 * Entity 2 model.
	 *
	 * @param prestamo the prestamo
	 * @return the prestamo model
	 */
	public PrestamoModel entity2Model(Prestamo prestamo) {
		PrestamoModel prestamoModel = new PrestamoModel();

		prestamoModel.setId(prestamo.getId());
		prestamoModel.setCliente(prestamo.getCliente());
		prestamoModel.setMonto(String.valueOf(prestamo.getMonto()));
		prestamoModel.setSaldo(prestamo.getSaldo());
		prestamoModel.setPlazo(prestamo.getPlazo());
		prestamoModel.setDineroretenido(prestamo.getDineroretenido());

		return prestamoModel;
	}

}
