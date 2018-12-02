package com.cajadeahorro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cajadeahorro.component.AdministradorConverter;
import com.cajadeahorro.entity.Administrador;
import com.cajadeahorro.model.AdministradorModel;
import com.cajadeahorro.repository.AdministradorRepository;
import com.cajadeahorro.service.AdministradorService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdministradorServiceImpl.
 */
@Service("administradorServiceImpl")
public class AdministradorServiceImpl implements AdministradorService {
	
	/** The administrador repository. */
	@Autowired
	@Qualifier("administradorRepository")
	private AdministradorRepository administradorRepository;
	
	/** The administrador converter. */
	@Autowired
	@Qualifier("administradorConverter")
	private AdministradorConverter administradorConverter;
	
	/** The usuario service. */
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.AdministradorService#add(com.cajadeahorro.model.AdministradorModel)
	 */
	@Override
	public AdministradorModel add(AdministradorModel administradorModel) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String contrasenia = administradorModel.getContrasenia();
		administradorModel.setContrasenia(passwordEncoder.encode(contrasenia));

		if (usuarioService.findByNombreusuario(administradorModel.getNombreusuario()) != null) {
			return null;
		}
		administradorRepository.save(administradorConverter.model2Entity(administradorModel));
		
		return administradorModel;
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.AdministradorService#findByNombreusuarioModel(java.lang.String)
	 */
	@Override
	public AdministradorModel findByNombreusuarioModel(String nombreusuario) {
		Administrador administrador = administradorRepository.findByNombreusuario(nombreusuario);

		return administrador != null ? administradorConverter.entity2Model(administrador) : null;
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.AdministradorService#delete(java.lang.String)
	 */
	public void delete(String nombreusuario) {
		if (findByNombreusuario(nombreusuario) != null) {
			administradorRepository.deleteByNombreusuario(nombreusuario);
		}
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.AdministradorService#findByNombreusuario(java.lang.String)
	 */
	@Override
	public Administrador findByNombreusuario(String nombreusuario) {
		return administradorRepository.findByNombreusuario(nombreusuario);
	}

}
