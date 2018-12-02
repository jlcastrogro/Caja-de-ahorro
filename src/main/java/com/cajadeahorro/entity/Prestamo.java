package com.cajadeahorro.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class Prestamo.
 */
@Entity
@Table
public class Prestamo {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;
	
	/** The cliente. */
	@Column
	private String cliente;
	
	/** The monto. */
	@Column(scale = 3)
	private BigDecimal monto;
	
	/** The saldo. */
	@Column(scale = 3)
	private BigDecimal saldo;
	
	/** The dineroretenido. */
	@Column(scale = 3)
	private BigDecimal dineroretenido;
	
	/** The plazo. */
	@Column
	private int plazo;

	/**
	 * Instantiates a new prestamo.
	 */
	public Prestamo() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	/**
	 * Instantiates a new prestamo.
	 *
	 * @param monto the monto
	 * @param cliente the cliente
	 * @param dineroretenido the dineroretenido
	 * @param plazo the plazo
	 */
	public Prestamo(BigDecimal monto, BigDecimal saldo, String cliente, BigDecimal dineroretenido, int plazo) {
		this.monto = monto;
		this.cliente = cliente;
		this.dineroretenido = dineroretenido;
		this.saldo = saldo;
		this.plazo = plazo;
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
	public BigDecimal getMonto() {
		return monto;
	}

	/**
	 * Sets the monto.
	 *
	 * @param monto the new monto
	 */
	public void setMonto(BigDecimal monto) {
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
		this.saldo = this.saldo.subtract(monto);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", cliente=" + cliente + ", monto=" + monto + ", saldo=" + saldo
				+ ", dineroretenido=" + dineroretenido + ", plazo=" + plazo + "]";
	}

}
