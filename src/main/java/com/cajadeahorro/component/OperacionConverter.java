package com.cajadeahorro.component;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cajadeahorro.entity.Operacion;
import com.cajadeahorro.model.OperacionModel;
import com.cajadeahorro.repository.ClienteRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class OperacionConverter.
 */
@Component("operacionConverter")
public class OperacionConverter {
	
	/** The cliente repository. */
	@Autowired
	@Qualifier("clienteRepository")
	private ClienteRepository clienteRepository;

	/**
	 * Model 2 entity.
	 *
	 * @param operacionModel the operacion model
	 * @return the operacion
	 */
	public Operacion model2Entity(OperacionModel operacionModel) {
		Operacion operacion = new Operacion();

		operacion.setId(operacionModel.getId());
		operacion.setCliente(operacionModel.getCliente());
		operacion.setEstado(operacionModel.getEstado());
		operacion.setFecha(operacionModel.getFecha());
		operacion.setMonto(new BigDecimal(operacionModel.getMonto()));
		operacion.setTipo(operacionModel.getTipo());

		return operacion;
	}

	/**
	 * Entity 2 model.
	 *
	 * @param operacion the operacion
	 * @return the operacion model
	 */
	public OperacionModel entity2Model(Operacion operacion) {
		OperacionModel operacionModel = new OperacionModel();

		operacionModel.setId(operacion.getId());
		operacionModel.setCliente(operacion.getCliente());
		operacionModel.setMonto(String.valueOf(operacion.getMonto()));
		operacionModel.setFecha(operacion.getFecha());
		operacionModel.setTipo(operacion.getTipo());
		operacionModel.setEstado(operacion.getEstado());

		return operacionModel;
	}
}
