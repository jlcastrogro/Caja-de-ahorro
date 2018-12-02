package com.cajadeahorro.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

// TODO: Auto-generated Javadoc
/**
 * The Class Caja.
 */
@Entity
@Table
public class Caja {
	
	/** The tipo. */
	@Id
	@Column(unique = true, length = 45)
	private String tipo;
	
	/** The cantidad. */
	@Column(scale = 3)
	@ColumnDefault(value = "0")
	private BigDecimal cantidad;

	/**
	 * Instantiates a new caja.
	 */
	public Caja() {
		super();
	}

	/**
	 * Instantiates a new caja.
	 *
	 * @param tipo the tipo
	 * @param cantidad the cantidad
	 */
	public Caja(String tipo, BigDecimal cantidad) {
		super();
		this.tipo = tipo;
		this.cantidad = cantidad;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the cantidad.
	 *
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}

	/**
	 * Sets the cantidad.
	 *
	 * @param cantidad the new cantidad
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Adds the monto.
	 *
	 * @param monto the monto
	 */
	public void addMonto(BigDecimal monto) {
		this.cantidad = this.cantidad.add(monto);
	}

	/**
	 * Sub monto.
	 *
	 * @param monto the monto
	 */
	public void subMonto(BigDecimal monto) {
		this.cantidad = this.cantidad.subtract(monto);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Caja [tipo=" + tipo + ", cantidad=" + cantidad.toString() + "]";
	}
}
