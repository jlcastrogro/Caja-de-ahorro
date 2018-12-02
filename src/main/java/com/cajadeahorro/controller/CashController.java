package com.cajadeahorro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cajadeahorro.constant.ViewConstant;
import com.cajadeahorro.model.MovimientoCajaModel;
import com.cajadeahorro.service.OperacionService;

// TODO: Auto-generated Javadoc
/**
 * The Class CashController.
 */
@Controller
@RequestMapping("/cash")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class CashController {
	
	/** The operacion service. */
	@Autowired
	@Qualifier("operacionServiceImpl")
	private OperacionService operacionService;

	/**
	 * Cash.
	 *
	 * @param success the success
	 * @param error the error
	 * @return the model and view
	 */
	@GetMapping
	public ModelAndView cash(@RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("movimientoCajaModel", new MovimientoCajaModel());
		modelAndView.addObject("error", error);
		modelAndView.addObject("success", success);
		modelAndView.setViewName(ViewConstant.MOVIMIENTO_CAJA_FORM);

		return modelAndView;
	}

	/**
	 * Cash validation.
	 *
	 * @param movimientoCajaModel the movimiento caja model
	 * @return the string
	 */
	@PostMapping
	public String cashValidation(@ModelAttribute(name = "movimientoCajaModel") MovimientoCajaModel movimientoCajaModel) {
		if (operacionService.movimientoCaja(movimientoCajaModel) != null) {
			return "redirect:/cash?success";
		}
		
		return "redirect:/cash?error";
	}
}
