package com.cajadeahorro.component;

import org.springframework.stereotype.Component;

import com.cajadeahorro.entity.Administrador;
import com.cajadeahorro.model.AdministradorModel;

// TODO: Auto-generated Javadoc
/**
 * The Class AdministradorConverter.
 */
@Component("administradorConverter")
public class AdministradorConverter {

	/**
	 * Model 2 entity.
	 *
	 * @param administradorModel the administrador model
	 * @return the administrador
	 */
	public Administrador model2Entity(AdministradorModel administradorModel) {
		Administrador administrador = new Administrador();

		administrador.setNombres(administradorModel.getNombres());
		administrador.setApellidos(administradorModel.getApellidos());
		administrador.setNombreusuario(administradorModel.getNombreusuario());
		administrador.setContrasenia(administradorModel.getContrasenia());
		administrador.setRol(administradorModel.getRol());
		administrador.setDisponible(administrador.getDisponible());

		return administrador;
	}

	/**
	 * Entity 2 model.
	 *
	 * @param administrador the administrador
	 * @return the administrador model
	 */
	public AdministradorModel entity2Model(Administrador administrador) {
		AdministradorModel administradorModel = new AdministradorModel();

		administradorModel.setNombres(administrador.getNombres());
		administradorModel.setApellidos(administrador.getApellidos());
		administradorModel.setNombreusuario(administrador.getNombreusuario());
		administradorModel.setContrasenia(administrador.getContrasenia());
		administradorModel.setRol(administrador.getRol());
		administradorModel.setDisponible(administrador.getDisponible());

		return administradorModel;
	}
}
