package com.cajadeahorro.service;

import java.util.List;

import com.cajadeahorro.entity.Caja;
import com.cajadeahorro.model.CajaModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface CajaService.
 */
public interface CajaService {
	
	/**
	 * Find by tipo.
	 *
	 * @param tipo the tipo
	 * @return the caja
	 */
	public abstract Caja findByTipo(String tipo);
	
	/**
	 * Find by tipo model.
	 *
	 * @param tipo the tipo
	 * @return the caja model
	 */
	public abstract CajaModel findByTipoModel(String tipo);
	
	/**
	 * Find by all.
	 *
	 * @return the list
	 */
	public abstract List<CajaModel> findByAll();
}
