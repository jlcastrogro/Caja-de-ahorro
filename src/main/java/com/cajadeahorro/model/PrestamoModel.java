package com.cajadeahorro.model;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class PrestamoModel.
 */
public class PrestamoModel {

	/** The id. */
	private int id;

	/** The cliente. */
	private String cliente;

	/** The monto. */
	private String monto;

	/** The saldo. */
	private BigDecimal saldo;

	/** The dineroretenido. */
	private BigDecimal dineroretenido;

	/** The plazo. */
	private int plazo;

	/**
	 * Instantiates a new prestamo model.
	 */
	public PrestamoModel() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Sets the cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * Gets the monto.
	 *
	 * @return the monto
	 */
	public String getMonto() {
		return monto;
	}

	/**
	 * Sets the monto.
	 *
	 * @param monto the new monto
	 */
	public void setMonto(String monto) {
		this.monto = monto;
	}

	/**
	 * Gets the saldo.
	 *
	 * @return the saldo
	 */
	public BigDecimal getSaldo() {
		return saldo;
	}

	/**
	 * Sets the saldo.
	 *
	 * @param saldo the new saldo
	 */
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	/**
	 * Sub saldo.
	 *
	 * @param monto the monto
	 */
	public void subSaldo(BigDecimal monto) {
		this.saldo.subtract(monto);
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
	 * Gets the plazo.
	 *
	 * @return the plazo
	 */
	public int getPlazo() {
		return plazo;
	}

	/**
	 * Sets the plazo.
	 *
	 * @param plazo the new plazo
	 */
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrestamoModel [id=" + id + ", cliente=" + cliente + ", monto=" + monto + ", saldo=" + saldo.toString()
				+ ", dineroretenido=" + dineroretenido.toString() + ", plazo=" + plazo + "]";
	}

}
