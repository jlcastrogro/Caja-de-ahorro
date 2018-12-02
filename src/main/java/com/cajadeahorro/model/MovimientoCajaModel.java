package com.cajadeahorro.model;

// TODO: Auto-generated Javadoc
/**
 * The Class MovimientoCajaModel.
 */
public class MovimientoCajaModel {
	
	/** The tipo. */
	private String tipo;
	
	/** The cantidad. */
	private String cantidad;
	
	/** The modo. */
	private String modo;

	/**
	 * Instantiates a new movimiento caja model.
	 */
	public MovimientoCajaModel() {
		super();
	}

	/**
	 * Instantiates a new movimiento caja model.
	 *
	 * @param tipo the tipo
	 * @param cantidad the cantidad
	 * @param modo the modo
	 */
	public MovimientoCajaModel(String tipo, String cantidad, String modo) {
		super();
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.modo = modo;
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
	public String getCantidad() {
		return cantidad;
	}

	/**
	 * Sets the cantidad.
	 *
	 * @param cantidad the new cantidad
	 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Gets the modo.
	 *
	 * @return the modo
	 */
	public String getModo() {
		return modo;
	}

	/**
	 * Sets the modo.
	 *
	 * @param modo the new modo
	 */
	public void setModo(String modo) {
		this.modo = modo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MovimientoCajaModel [tipo=" + tipo + ", cantidad=" + cantidad + ", modo=" + modo + "]";
	}

}
