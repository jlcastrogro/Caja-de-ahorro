package com.cajadeahorro.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cajadeahorro.entity.Operacion;

// TODO: Auto-generated Javadoc
/**
 * The Interface OperacionRepository.
 */
@Repository("operacionRepository")
public interface OperacionRepository extends JpaRepository<Operacion, Serializable> {
	
	/**
	 * Find by cliente.
	 *
	 * @param cliente the cliente
	 * @return the list
	 */
	public abstract List<Operacion> findByCliente(String cliente);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the operacion
	 */
	public abstract Operacion findById(int id);
}
