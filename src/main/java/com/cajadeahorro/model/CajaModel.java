package com.cajadeahorro.model;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class CajaModel.
 */
public class CajaModel {
	
	/** The tipo. */
	private String tipo;
	
	/** The cantidad. */
	private BigDecimal cantidad;

	/**
	 * Instantiates a new caja model.
	 */
	public CajaModel() {
		super();
	}

	/**
	 * Instantiates a new caja model.
	 *
	 * @param tipo the tipo
	 * @param cantidad the cantidad
	 */
	public CajaModel(String tipo, BigDecimal cantidad) {
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
		this.cantidad.add(monto);
	}

	/**
	 * Sub monto.
	 *
	 * @param monto the monto
	 */
	public void subMonto(BigDecimal monto) {
		this.cantidad.subtract(monto);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Caja [tipo=" + tipo + ", cantidad=" + cantidad.toString() + "]";
	}
}
