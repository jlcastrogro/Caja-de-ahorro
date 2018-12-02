package com.cajadeahorro.service;

import java.util.List;

import com.cajadeahorro.entity.Prestamo;
import com.cajadeahorro.model.PrestamoModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface PrestamoService.
 */
public interface PrestamoService {
	
	/**
	 * Find by id model.
	 *
	 * @param id the id
	 * @return the prestamo model
	 */
	public abstract PrestamoModel findByIdModel(int id);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the prestamo
	 */
	public abstract Prestamo findById(int id);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public abstract void delete(int id);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public abstract List<PrestamoModel> findAll();
	
	/**
	 * Find by cliente.
	 *
	 * @param cliente the cliente
	 * @return the list
	 */
	public abstract List<PrestamoModel> findByCliente(String cliente);
}
