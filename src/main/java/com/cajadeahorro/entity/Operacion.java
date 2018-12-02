package com.cajadeahorro.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class Operacion.
 */
@Entity
@Table
public class Operacion {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;
	
	/** The cliente. */
	@Column
	private String cliente;
	
	/** The tipo. */
	@Column
	private String tipo;
	
	/** The monto. */
	@Column(scale = 3)
	private BigDecimal monto;
	
	/** The fecha. */
	@Column
	private Date fecha;
	
	/** The estado. */
	@Column
	private String estado;

	/**
	 * Instantiates a new operacion.
	 */
	public Operacion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new operacion.
	 *
	 * @param id the id
	 * @param cliente the cliente
	 * @param tipo the tipo
	 * @param monto the monto
	 * @param fecha the fecha
	 * @param estado the estado
	 */
	public Operacion(int id, String cliente, String tipo, BigDecimal monto, Date fecha, String estado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.tipo = tipo;
		this.monto = monto;
		this.fecha = fecha;
		this.estado = estado;
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
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the new fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado the new estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Operacion [id=" + id + ", cliente=" + cliente + ", tipo=" + tipo + ", monto=" + monto.toString() + ", fecha="
				+ fecha + ", estado=" + estado + "]";
	}

}
