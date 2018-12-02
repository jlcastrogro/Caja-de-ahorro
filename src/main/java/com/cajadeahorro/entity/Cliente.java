package com.cajadeahorro.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

// TODO: Auto-generated Javadoc
/**
 * The Class Cliente.
 */
@Entity
@Table
public class Cliente extends Usuario {

	/** The dineroahorro. */
	@Column(scale = 3)
	@ColumnDefault(value = "0")
	private BigDecimal dineroahorro;

	/** The dineroretenido. */
	@Column(scale = 3)
	@ColumnDefault(value = "0")
	private BigDecimal dineroretenido;

	/** The dineroprestamo. */
	@Column(scale = 3)
	@ColumnDefault(value = "0")
	private BigDecimal dineroprestamo;

	/**
	 * Instantiates a new cliente.
	 */
	public Cliente() {
		// TODO Auto-generated constructor stub
		super();
		this.setRol("ROLE_CLIENTE");
	}

	/**
	 * Instantiates a new cliente.
	 *
	 * @param nombreusuario the nombreusuario
	 * @param contrasenia   the contrasenia
	 * @param nombres       the nombres
	 * @param apellidos     the apellidos
	 * @param rol           the rol
	 */
	public Cliente(String nombreusuario, String contrasenia, String nombres, String apellidos, String rol) {
		super(nombreusuario, contrasenia, nombres, apellidos, rol);
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
	 * Adds the dinero ahorro.
	 *
	 * @param monto the monto
	 */
	public void addDineroAhorro(BigDecimal monto) {
		this.dineroahorro = this.dineroahorro.add(monto);
	}

	/**
	 * Sub dinero ahorro.
	 *
	 * @param monto the monto
	 */
	public void subDineroAhorro(BigDecimal monto) {
		this.dineroahorro = this.dineroahorro.subtract(monto);
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
	 * Adds the dineroretenido.
	 *
	 * @param monto the monto
	 */
	public void addDineroretenido(BigDecimal monto) {
		this.dineroretenido = this.dineroretenido.add(monto);
	}

	/**
	 * Sub dineroretenido.
	 *
	 * @param monto the monto
	 */
	public void subDineroretenido(BigDecimal monto) {
		this.dineroretenido = this.dineroretenido.subtract(monto);
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

	/**
	 * Adds the dineroprestamo.
	 *
	 * @param monto the monto
	 */
	public void addDineroprestamo(BigDecimal monto) {
		this.dineroprestamo = this.dineroprestamo.add(monto);
	}

	/**
	 * Sub dineroprestamo.
	 *
	 * @param monto the monto
	 */
	public void subDineroprestamo(BigDecimal monto) {
		this.dineroprestamo = this.dineroprestamo.subtract(monto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cajadeahorro.entity.Usuario#toString()
	 */
	@Override
	public String toString() {
		return "Cliente [nombreusuario=" + getNombreusuario() + ", contrasenia=" + getContrasenia() + ", nombre="
				+ getNombres() + ", apellidos=" + getApellidos() + ", rol=" + getRol() + ", dineroahorro="
				+ dineroahorro.toString() + ", dineroretenido=" + dineroretenido.toString() + ", dineroprestamo="
				+ dineroprestamo.toString() + ", disponible=" + getDisponible() + "]";
	}

}
