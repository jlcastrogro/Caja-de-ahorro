package com.cajadeahorro.model;

// TODO: Auto-generated Javadoc
/**
 * The Class AdministradorModel.
 */
public class AdministradorModel extends UsuarioModel {

	/**
	 * Instantiates a new administrador model.
	 */
	public AdministradorModel() {
		// TODO Auto-generated constructor stub
		super();
		this.setRol("ROLE_ADMIN");
	}

	/**
	 * Instantiates a new administrador model.
	 *
	 * @param nombreusuario the nombreusuario
	 * @param contrasenia the contrasenia
	 * @param nombres the nombres
	 * @param apellidos the apellidos
	 * @param rol the rol
	 */
	public AdministradorModel(String nombreusuario, String contrasenia, String nombres, String apellidos, String rol) {
		super(nombreusuario, contrasenia, nombres, apellidos, rol, true);
	}
}
