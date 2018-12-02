package com.cajadeahorro.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cajadeahorro.component.UsuarioConverter;
import com.cajadeahorro.entity.Usuario;
import com.cajadeahorro.model.UsuarioModel;
import com.cajadeahorro.repository.UsuarioRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioService.
 */
@Service("usuarioService")
public class UsuarioService implements UserDetailsService {
	
	/** The usuario repository. */
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	/** The usuario converter. */
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String nombreusuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNombreusuario(nombreusuario);
		List<GrantedAuthority> authorities = buildAuthorities(usuario.getRol());
		return buildUser(usuario, authorities);
	}

	/**
	 * Builds the user.
	 *
	 * @param usuario the usuario
	 * @param authorities the authorities
	 * @return the user
	 */
	private User buildUser(Usuario usuario, List<GrantedAuthority> authorities) {
		return new User(usuario.getNombreusuario(), usuario.getContrasenia(), usuario.getDisponible(), true, true, true,
				authorities);
	}

	/**
	 * Builds the authorities.
	 *
	 * @param rol the rol
	 * @return the list
	 */
	private List<GrantedAuthority> buildAuthorities(String rol) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority(rol));

		return new ArrayList<GrantedAuthority>(authorities);
	}

	/**
	 * Find by nombreusuario model.
	 *
	 * @param nombreusuario the nombreusuario
	 * @return the usuario model
	 */
	public UsuarioModel findByNombreusuarioModel(String nombreusuario) {
		Usuario usuario = usuarioRepository.findByNombreusuario(nombreusuario);
		
		return usuario != null ? usuarioConverter.entity2Model(usuario) : null;
	}
	
	/**
	 * Find by nombreusuario.
	 *
	 * @param nombreusuario the nombreusuario
	 * @return the usuario
	 */
	public Usuario findByNombreusuario(String nombreusuario) {
		return usuarioRepository.findByNombreusuario(nombreusuario);
	}

}
