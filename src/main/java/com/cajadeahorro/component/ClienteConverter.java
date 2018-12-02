package com.cajadeahorro.component;

import org.springframework.stereotype.Component;

import com.cajadeahorro.entity.Cliente;
import com.cajadeahorro.model.ClienteModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteConverter.
 */
@Component("clienteConverter")
public class ClienteConverter {
	
	/**
	 * Model 2 entity.
	 *
	 * @param clienteModel the cliente model
	 * @return the cliente
	 */
	public Cliente model2Entity(ClienteModel clienteModel) {
		Cliente cliente = new Cliente();

		cliente.setNombres(clienteModel.getNombres());
		cliente.setApellidos(clienteModel.getApellidos());
		cliente.setNombreusuario(clienteModel.getNombreusuario());
		cliente.setContrasenia(clienteModel.getContrasenia());
		cliente.setDineroahorro(clienteModel.getDineroahorro());
		cliente.setDineroprestamo(clienteModel.getDineroprestamo());
		cliente.setDineroretenido(clienteModel.getDineroretenido());
		cliente.setRol(clienteModel.getRol());
		cliente.setDisponible(clienteModel.getDisponible());

		return cliente;
	}

	/**
	 * Entity 2 model.
	 *
	 * @param cliente the cliente
	 * @return the cliente model
	 */
	public ClienteModel entity2Model(Cliente cliente) {
		ClienteModel clienteModel = new ClienteModel();

		clienteModel.setNombres(cliente.getNombres());
		clienteModel.setApellidos(cliente.getApellidos());
		clienteModel.setNombreusuario(cliente.getNombreusuario());
		clienteModel.setContrasenia(cliente.getContrasenia());
		clienteModel.setDineroahorro(cliente.getDineroahorro());
		clienteModel.setDineroprestamo(cliente.getDineroprestamo());
		clienteModel.setDineroretenido(cliente.getDineroretenido());
		clienteModel.setRol(cliente.getRol());
		clienteModel.setDisponible(cliente.getDisponible());

		return clienteModel;
	}
}
