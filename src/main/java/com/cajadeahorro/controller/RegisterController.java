package com.cajadeahorro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cajadeahorro.constant.ViewConstant;
import com.cajadeahorro.model.AdministradorModel;
import com.cajadeahorro.model.ClienteModel;
import com.cajadeahorro.model.UsuarioModel;
import com.cajadeahorro.service.AdministradorService;
import com.cajadeahorro.service.ClienteService;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterController.
 */
@Controller
public class RegisterController {
	
	/** The cliente service. */
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;
	
	/** The administrador service. */
	@Autowired
	@Qualifier("administradorServiceImpl")
	private AdministradorService administradorService;

	/**
	 * Register.
	 *
	 * @param model the model
	 * @param success the success
	 * @param error the error
	 * @return the string
	 */
	@GetMapping("/register")
	public String register(Model model, @RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "error", required = false) String error) {
		model.addAttribute("usuarioModel", new UsuarioModel());
		model.addAttribute("error", error);
		
		return ViewConstant.REGISTER_FORM;
	}

	/**
	 * Register check.
	 *
	 * @param model the model
	 * @param usuarioModel the usuario model
	 * @return the string
	 */
	@PostMapping("/registercheck")
	public String registerCheck(Model model, @ModelAttribute(name = "usuarioModel") UsuarioModel usuarioModel) {
		if (usuarioModel.getRol().equals("ROLE_CLIENTE")) {
			ClienteModel clienteModel = new ClienteModel();
			clienteModel.setNombres(usuarioModel.getNombres());
			clienteModel.setApellidos(usuarioModel.getApellidos());
			clienteModel.setNombreusuario(usuarioModel.getNombreusuario());
			clienteModel.setContrasenia(usuarioModel.getContrasenia());
			if (clienteService.add(clienteModel) != null) {
				return "redirect:/login";
			}
		} else {
			AdministradorModel administradorModel = new AdministradorModel();
			administradorModel.setNombres(usuarioModel.getNombres());
			administradorModel.setApellidos(usuarioModel.getApellidos());
			administradorModel.setNombreusuario(usuarioModel.getNombreusuario());
			administradorModel.setContrasenia(usuarioModel.getContrasenia());
			if (administradorService.add(administradorModel) != null) {
				return "redirect:/login";
			}
		}
		
		return "redirect:/register?error";
	}
}
