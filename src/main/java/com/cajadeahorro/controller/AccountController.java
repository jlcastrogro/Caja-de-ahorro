package com.cajadeahorro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cajadeahorro.constant.ViewConstant;
import com.cajadeahorro.model.UsuarioModel;
import com.cajadeahorro.service.AdministradorService;
import com.cajadeahorro.service.ClienteService;
import com.cajadeahorro.service.PrestamoService;
import com.cajadeahorro.service.impl.UsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountController.
 */
@Controller
public class AccountController {
	
	/** The prestamo service. */
	@Autowired
	@Qualifier("prestamoServiceImpl")
	private PrestamoService prestamoService;
	
	/** The usuario service. */
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	/** The cliente service. */
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;
	
	/** The administrador service. */
	@Autowired
	@Qualifier("administradorServiceImpl")
	private AdministradorService administradorService;

	/**
	 * Account.
	 *
	 * @param error the error
	 * @return the model and view
	 */
	@GetMapping("/account")
	public ModelAndView account(@RequestParam(name = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView();
		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UsuarioModel usuarioModel = usuarioService.findByNombreusuarioModel(usuario.getUsername());
		
		if (usuarioModel.getRol().equals("ROLE_CLIENTE")) {
			modelAndView.addObject("usuario", clienteService.findByNombreusuario(usuario.getUsername()));
			modelAndView.setViewName(ViewConstant.ACCOUNT_VIEW);
		} else {
			modelAndView.addObject("usuario", administradorService.findByNombreusuario(usuario.getUsername()));
			modelAndView.setViewName(ViewConstant.ACCOUNT_VIEW_ADMIN);
		}
		modelAndView.addObject("error", error);
		
		return modelAndView;
	}

	/**
	 * Delete account.
	 *
	 * @param nombreusuario the nombreusuario
	 * @return the string
	 */
	@GetMapping("/account/delete")
	public String deleteAccount(@RequestParam(name = "nombreusuario", required = true) String nombreusuario) {
		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UsuarioModel usuarioModel = usuarioService.findByNombreusuarioModel(usuario.getUsername());

		if (usuarioModel.getRol().equals("ROLE_CLIENTE")) {
			if (prestamoService.findByCliente(usuarioModel.getNombreusuario()).size() == 0) {
				clienteService.delete(nombreusuario);
			} else {
				return "redirect:/account?error";
			}
		} else {
			administradorService.delete(nombreusuario);
		}

		return "redirect:/login";
	}
}
