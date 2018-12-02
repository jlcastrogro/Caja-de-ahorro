package com.cajadeahorro.service;

import com.cajadeahorro.entity.Cliente;
import com.cajadeahorro.model.ClienteModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClienteService.
 */
public interface ClienteService {
	
	/**
	 * Find by nombreusuario model.
	 *
	 * @param nombreusuario the nombreusuario
	 * @return the cliente model
	 */
	public abstract ClienteModel findByNombreusuarioModel(String nombreusuario);

	/**
	 * Find by nombreusuario.
	 *
	 * @param nombreusuario the nombreusuario
	 * @return the cliente
	 */
	public abstract Cliente findByNombreusuario(String nombreusuario);

	/**
	 * Adds the.
	 *
	 * @param clienteModel the cliente model
	 * @return the cliente model
	 */
	public abstract ClienteModel add(ClienteModel clienteModel);

	/**
	 * Delete.
	 *
	 * @param nombreusuario the nombreusuario
	 */
	public abstract void delete(String nombreusuario);
}
