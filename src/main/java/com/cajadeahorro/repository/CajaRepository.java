package com.cajadeahorro.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cajadeahorro.entity.Caja;

// TODO: Auto-generated Javadoc
/**
 * The Interface CajaRepository.
 */
@Repository("cajaRepository")
public interface CajaRepository extends JpaRepository<Caja, Serializable> {
	
	/**
	 * Find by tipo.
	 *
	 * @param tipo the tipo
	 * @return the caja
	 */
	public abstract Caja findByTipo(String tipo);
}
