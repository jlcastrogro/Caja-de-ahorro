package com.cajadeahorro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cajadeahorro.component.ClienteConverter;
import com.cajadeahorro.entity.Cliente;
import com.cajadeahorro.model.ClienteModel;
import com.cajadeahorro.repository.ClienteRepository;
import com.cajadeahorro.service.ClienteService;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteServiceImpl.
 */
@Service("clienteServiceImpl")
public class ClienteServiceImpl implements ClienteService {
	
	/** The cliente repository. */
	@Autowired
	@Qualifier("clienteRepository")
	private ClienteRepository clienteRepository;
	
	/** The cliente converter. */
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	
	/** The usuario service. */
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.ClienteService#add(com.cajadeahorro.model.ClienteModel)
	 */
	@Override
	public ClienteModel add(ClienteModel clienteModel) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String contrasenia = clienteModel.getContrasenia();
		clienteModel.setContrasenia(passwordEncoder.encode(contrasenia));

		if (usuarioService.findByNombreusuario(clienteModel.getNombreusuario()) != null) {
			return null;
		}
		Cliente cliente = clienteRepository.save(clienteConverter.model2Entity(clienteModel));

		return clienteConverter.entity2Model(cliente);
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.ClienteService#findByNombreusuarioModel(java.lang.String)
	 */
	@Override
	public ClienteModel findByNombreusuarioModel(String nombreusuario) {
		Cliente cliente = clienteRepository.findByNombreusuario(nombreusuario);

		return cliente != null ? clienteConverter.entity2Model(cliente) : null;
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.ClienteService#delete(java.lang.String)
	 */
	public void delete(String nombreusuario) {
		if (findByNombreusuario(nombreusuario) != null) {
			clienteRepository.deleteByNombreusuario(nombreusuario);
		}
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.ClienteService#findByNombreusuario(java.lang.String)
	 */
	public Cliente findByNombreusuario(String nombreusuario) {
		return clienteRepository.findByNombreusuario(nombreusuario);
	}

}
