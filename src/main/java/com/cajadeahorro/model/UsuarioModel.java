package com.cajadeahorro.model;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioModel.
 */
public class UsuarioModel {
	
	/** The nombreusuario. */
	private String nombreusuario;
	
	/** The contrasenia. */
	private String contrasenia;
	
	/** The nombres. */
	private String nombres;
	
	/** The apellidos. */
	private String apellidos;
	
	/** The rol. */
	private String rol;
	
	/** The disponible. */
	private boolean disponible;

	/**
	 * Instantiates a new usuario model.
	 */
	public UsuarioModel() {
		// TODO Auto-generated constructor stub
		this.disponible = true;
	}

	/**
	 * Instantiates a new usuario model.
	 *
	 * @param nombreusuario the nombreusuario
	 * @param contrasenia the contrasenia
	 * @param nombres the nombres
	 * @param apellidos the apellidos
	 * @param rol the rol
	 * @param disponible the disponible
	 */
	public UsuarioModel(String nombreusuario, String contrasenia, String nombres, String apellidos, String rol,
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
		return "UsuarioModel [nombreusuario=" + nombreusuario + ", contrasenia=" + contrasenia + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", rol=" + rol + ", disponible=" + disponible + "]";
	}

}
