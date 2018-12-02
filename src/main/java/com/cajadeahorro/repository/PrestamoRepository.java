package com.cajadeahorro.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cajadeahorro.entity.Prestamo;

// TODO: Auto-generated Javadoc
/**
 * The Interface PrestamoRepository.
 */
@Repository("prestamoRepository")
public interface PrestamoRepository extends JpaRepository<Prestamo, Serializable> {
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the prestamo
	 */
	public abstract Prestamo findById(int id);
	
	/**
	 * Find by cliente.
	 *
	 * @param cliente the cliente
	 * @return the list
	 */
	public abstract List<Prestamo> findByCliente(String cliente);
}
