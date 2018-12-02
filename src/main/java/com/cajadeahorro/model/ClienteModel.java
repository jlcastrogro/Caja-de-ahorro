package com.cajadeahorro.model;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteModel.
 */
public class ClienteModel extends UsuarioModel {

	/** The dineroahorro. */
	private BigDecimal dineroahorro;

	/** The dineroretenido. */
	private BigDecimal dineroretenido;

	/** The dineroprestamo. */
	private BigDecimal dineroprestamo;

	/**
	 * Instantiates a new cliente model.
	 */
	public ClienteModel() {
		// TODO Auto-generated constructor stub
		super();
		this.setRol("ROLE_CLIENTE");
		this.setDineroahorro(BigDecimal.ZERO);
		this.setDineroretenido(BigDecimal.ZERO);
		this.setDineroprestamo(BigDecimal.ZERO);
	}

	/**
	 * Instantiates a new cliente model.
	 *
	 * @param nombreusuario the nombreusuario
	 * @param contrasenia   the contrasenia
	 * @param nombres       the nombres
	 * @param apellidos     the apellidos
	 * @param rol           the rol
	 */
	public ClienteModel(String nombreusuario, String contrasenia, String nombres, String apellidos, String rol) {
		super(nombreusuario, contrasenia, nombres, apellidos, rol, true);
		this.dineroahorro = BigDecimal.ZERO;
		this.dineroretenido = BigDecimal.ZERO;
		this.dineroprestamo = BigDecimal.ZERO;
	}

	/**
	 * Gets the dineroahorro.
	 *
	 * @return the dineroahorro
	 */
	public BigDecimal getDineroahorro() {
		return dineroahorro;
	}

	/**
	 * Sets the dineroahorro.
	 *
	 * @param dineroahorro the new dineroahorro
	 */
	public void setDineroahorro(BigDecimal dineroahorro) {
		this.dineroahorro = dineroahorro;
	}

	/**
	 * Gets the dineroretenido.
	 *
	 * @return the dineroretenido
	 */
	public BigDecimal getDineroretenido() {
		return dineroretenido;
	}

	/**
	 * Sets the dineroretenido.
	 *
	 * @param dineroretenido the new dineroretenido
	 */
	public void setDineroretenido(BigDecimal dineroretenido) {
		this.dineroretenido = dineroretenido;
	}

	/**
	 * Gets the dineroprestamo.
	 *
	 * @return the dineroprestamo
	 */
	public BigDecimal getDineroprestamo() {
		return dineroprestamo;
	}

	/**
	 * Sets the dineroprestamo.
	 *
	 * @param dineroprestamo the new dineroprestamo
	 */
	public void setDineroprestamo(BigDecimal dineroprestamo) {
		this.dineroprestamo = dineroprestamo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cajadeahorro.model.UsuarioModel#toString()
	 */
	@Override
	public String toString() {
		return "Cliente [nombreusuario=" + getNombreusuario() + ", contrasenia=" + getContrasenia() + ", nombre="
				+ getNombres() + ", apellidos=" + getApellidos() + ", rol=" + getRol() + ", dineroahorro="
				+ dineroahorro.toString() + ", dineroretenido=" + dineroretenido.toString() + ", dineroprestamo="
				+ dineroprestamo.toString() + ", disponible=" + getDisponible() + "]";
	}

}
