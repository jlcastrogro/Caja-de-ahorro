package com.cajadeahorro.component;

import org.springframework.stereotype.Component;

import com.cajadeahorro.entity.Usuario;
import com.cajadeahorro.model.UsuarioModel;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioConverter.
 */
@Component("usuarioConverter")
public class UsuarioConverter {

	/**
	 * Model 2 entity.
	 *
	 * @param usuarioModel the usuario model
	 * @return the usuario
	 */
	public Usuario model2Entity(UsuarioModel usuarioModel) {
		Usuario usuario = new Usuario();

		usuario.setNombres(usuarioModel.getNombres());
		usuario.setApellidos(usuarioModel.getApellidos());
		usuario.setNombreusuario(usuarioModel.getNombreusuario());
		usuario.setContrasenia(usuarioModel.getContrasenia());
		usuario.setRol(usuarioModel.getRol());
		usuario.setDisponible(usuarioModel.getDisponible());

		return usuario;
	}

	/**
	 * Entity 2 model.
	 *
	 * @param usuario the usuario
	 * @return the usuario model
	 */
	public UsuarioModel entity2Model(Usuario usuario) {
		UsuarioModel usuarioModel = new UsuarioModel();

		usuarioModel.setNombres(usuario.getNombres());
		usuarioModel.setApellidos(usuario.getApellidos());
		usuarioModel.setNombreusuario(usuario.getNombreusuario());
		usuarioModel.setContrasenia(usuario.getContrasenia());
		usuarioModel.setRol(usuario.getRol());
		usuarioModel.setDisponible(usuario.getDisponible());

		return usuarioModel;
	}
}
