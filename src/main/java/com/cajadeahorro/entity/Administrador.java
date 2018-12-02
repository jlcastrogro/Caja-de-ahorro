package com.cajadeahorro.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Administrador.
 */
@Entity
@Table
public class Administrador extends Usuario {

	/**
	 * Instantiates a new administrador.
	 */
	public Administrador() {
		// TODO Auto-generated constructor stub
		super();
		this.setRol("ROLE_ADMIN");
	}

	/**
	 * Instantiates a new administrador.
	 *
	 * @param nombreusuario the nombreusuario
	 * @param contrasenia the contrasenia
	 * @param nombres the nombres
	 * @param apellidos the apellidos
	 * @param rol the rol
	 */
	public Administrador(String nombreusuario, String contrasenia, String nombres, String apellidos, String rol) {
		super(nombreusuario, contrasenia, nombres, apellidos, rol);
	}
}
