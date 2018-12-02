package com.cajadeahorro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
@Entity
@Table
public class Usuario {
	
	/** The nombreusuario. */
	@Id
	@Column(nullable = false, unique = true, length = 45)
	private String nombreusuario;
	
	/** The contrasenia. */
	@Column(nullable = false)
	private String contrasenia;
	
	/** The nombres. */
	@Column(nullable = false)
	private String nombres;
	
	/** The apellidos. */
	@Column(nullable = false)
	private String apellidos;
	
	/** The rol. */
	@Column(nullable = false)
	private String rol;
	
	/** The disponible. */
	@Column(nullable = false)
	private boolean disponible;

	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
		this.disponible = true;
	}

	/**
	 * Instantiates a new usuario.
	 *
	 * @param nombreusuario the nombreusuario
	 * @param contrasenia the contrasenia
	 * @param nombres the nombres
	 * @param apellidos the apellidos
	 * @param rol the rol
	 */
	public Usuario(String nombreusuario, String contrasenia, String nombres, String apellidos, String rol) {
		super();
		this.nombreusuario = nombreusuario;
		this.contrasenia = contrasenia;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rol = rol;
	}

	/**
	 * Instantiates a new usuario.
	 *
	 * @param nombreusuario the nombreusuario
	 * @param contrasenia the contrasenia
	 * @param nombres the nombres
	 * @param apellidos the apellidos
	 * @param rol the rol
	 * @param disponible the disponible
	 */
	public Usuario(String nombreusuario, String contrasenia, String nombres, String apellidos, String rol,
			boolean disponible) {
		super();
		this.nombreusuario = nombreusuario;
		this.contrasenia = contrasenia;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rol = rol;
		this.disponible = disponible;
	}

	/**
	 * Gets the nombreusuario.
	 *
	 * @return the nombreusuario
	 */
	public String getNombreusuario() {
		return nombreusuario;
	}

	/**
	 * Sets the nombreusuario.
	 *
	 * @param nombreusuario the new nombreusuario
	 */
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	/**
	 * Gets the contrasenia.
	 *
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * Sets the contrasenia.
	 *
	 * @param contrasenia the new contrasenia
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * Gets the nombres.
	 *
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Sets the nombres.
	 *
	 * @param nombres the new nombres
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Gets the rol.
	 *
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Sets the rol.
	 *
	 * @param rol the new rol
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * Gets the disponible.
	 *
	 * @return the disponible
	 */
	public boolean getDisponible() {
		return disponible;
	}

	/**
	 * Sets the disponible.
	 *
	 * @param disponible the new disponible
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [nombreusuario=" + nombreusuario + ", contrasenia=" + contrasenia + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", rol=" + rol + ", disponible=" + disponible + "]";
	}

}
