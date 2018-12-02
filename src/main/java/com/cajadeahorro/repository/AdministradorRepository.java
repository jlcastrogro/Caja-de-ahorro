package com.cajadeahorro.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cajadeahorro.entity.Administrador;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdministradorRepository.
 */
@Repository("administradorRepository")
public interface AdministradorRepository extends JpaRepository<Administrador, Serializable> {
	
	/**
	 * Find by nombreusuario.
	 *
	 * @param nombreUusuario the nombre uusuario
	 * @return the administrador
	 */
	public abstract Administrador findByNombreusuario(String nombreUusuario);
	
	/**
	 * Delete by nombreusuario.
	 *
	 * @param nombreusuario the nombreusuario
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM Administrador WHERE nombreusuario = :nombreusuario")
	public abstract void deleteByNombreusuario(@Param("nombreusuario") String nombreusuario);
}
