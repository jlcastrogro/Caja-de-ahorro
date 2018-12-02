package com.cajadeahorro.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cajadeahorro.entity.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioRepository.
 */
@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {
	
	/**
	 * Find by nombreusuario.
	 *
	 * @param nombreusuario the nombreusuario
	 * @return the usuario
	 */
	public abstract Usuario findByNombreusuario(String nombreusuario);
}
