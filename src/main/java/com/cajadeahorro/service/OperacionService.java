package com.cajadeahorro.service;

import java.util.List;

import com.cajadeahorro.model.MovimientoCajaModel;
import com.cajadeahorro.model.OperacionModel;
import com.cajadeahorro.model.PrestamoModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface OperacionService.
 */
public interface OperacionService {
	
	/**
	 * Realizar deposito cuenta.
	 *
	 * @param depositoCuenta the deposito cuenta
	 * @return the operacion model
	 */
	public abstract OperacionModel realizarDepositoCuenta(OperacionModel depositoCuenta);
	
	/**
	 * Realizar deposito prestamo.
	 *
	 * @param depositoPrestamo the deposito prestamo
	 * @return the operacion model
	 */
	public abstract OperacionModel realizarDepositoPrestamo(OperacionModel depositoPrestamo);
	
	/**
	 * Realizar retiro.
	 *
	 * @param retiro the retiro
	 * @return the operacion model
	 */
	public abstract OperacionModel realizarRetiro(OperacionModel retiro);
	
	/**
	 * Solicitar prestamo.
	 *
	 * @param prestamoModel the prestamo model
	 * @return the operacion model
	 */
	public abstract OperacionModel solicitarPrestamo(PrestamoModel prestamoModel);
	
	/**
	 * Realizar aportacion.
	 *
	 * @param aportacion the aportacion
	 * @return the operacion model
	 */
	public abstract OperacionModel realizarAportacion(OperacionModel aportacion);
	
	/**
	 * Find by cliente.
	 *
	 * @param cliente the cliente
	 * @return the list
	 */
	public abstract List<OperacionModel> findByCliente(String cliente);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public abstract List<OperacionModel> findAll();
	
	/**
	 * Movimiento caja.
	 *
	 * @param movimientoCajaModel the movimiento caja model
	 * @return the movimiento caja model
	 */
	public abstract MovimientoCajaModel movimientoCaja(MovimientoCajaModel movimientoCajaModel);
}
