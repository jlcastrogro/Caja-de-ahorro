package com.cajadeahorro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cajadeahorro.constant.ViewConstant;
import com.cajadeahorro.model.ClienteModel;
import com.cajadeahorro.model.UsuarioModel;
import com.cajadeahorro.service.CajaService;
import com.cajadeahorro.service.ClienteService;
import com.cajadeahorro.service.impl.OperacionServiceImpl;
import com.cajadeahorro.service.impl.UsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeController.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	/** The usuario service. */
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	/** The cliente service. */
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;
	
	/** The operacion service impl. */
	@Autowired
	@Qualifier("operacionServiceImpl")
	private OperacionServiceImpl operacionServiceImpl;
	
	/** The caja service. */
	@Autowired
	@Qualifier("cajaServiceImpl")
	private CajaService cajaService;

	/**
	 * Home.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("home")
	public String home(Model model) {
		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UsuarioModel usuarioModel = usuarioService.findByNombreusuarioModel(usuario.getUsername());

		if (usuarioModel.getRol().equals("ROLE_CLIENTE")) {
			ClienteModel cliente = clienteService.findByNombreusuarioModel(usuario.getUsername());
			model.addAttribute("cliente", cliente);
			model.addAttribute("operaciones", operacionServiceImpl.findByCliente(cliente.getNombreusuario()));

			return ViewConstant.HOME_VIEW;
		}
		model.addAttribute("ahorro", cajaService.findByTipo("ahorro").getCantidad());
		model.addAttribute("prestamo", cajaService.findByTipo("prestamo").getCantidad());
		model.addAttribute("retencion", cajaService.findByTipo("retencion").getCantidad());
		model.addAttribute("operaciones", operacionServiceImpl.findAll());

		return ViewConstant.HOME_VIEW_ADMIN;
	}
}
