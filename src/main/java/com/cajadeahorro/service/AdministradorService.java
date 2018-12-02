package com.cajadeahorro.service;

import com.cajadeahorro.entity.Administrador;
import com.cajadeahorro.model.AdministradorModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdministradorService.
 */
public interface AdministradorService {
	
	/**
	 * Find by nombreusuario model.
	 *
	 * @param nombreusuario the nombreusuario
	 * @return the administrador model
	 */
	public abstract AdministradorModel findByNombreusuarioModel(String nombreusuario);
	
	/**
	 * Find by nombreusuario.
	 *
	 * @param nombreusuario the nombreusuario
	 * @return the administrador
	 */
	public abstract Administrador findByNombreusuario(String nombreusuario);

	/**
	 * Adds the.
	 *
	 * @param administradorModel the administrador model
	 * @return the administrador model
	 */
	public abstract AdministradorModel add(AdministradorModel administradorModel);

	/**
	 * Delete.
	 *
	 * @param nombreusuario the nombreusuario
	 */
	public abstract void delete(String nombreusuario);
}
