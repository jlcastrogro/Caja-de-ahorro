package com.cajadeahorro.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cajadeahorro.constant.ViewConstant;
import com.cajadeahorro.model.OperacionModel;
import com.cajadeahorro.model.PrestamoModel;
import com.cajadeahorro.service.CajaService;
import com.cajadeahorro.service.ClienteService;
import com.cajadeahorro.service.PrestamoService;
import com.cajadeahorro.service.impl.OperacionServiceImpl;
import com.cajadeahorro.service.impl.UsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class OperationController.
 */
@Controller
@RequestMapping("/operation")
@PreAuthorize("hasRole('ROLE_CLIENTE')")
public class OperationController {
	
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
	
	/** The prestamo service. */
	@Autowired
	@Qualifier("prestamoServiceImpl")
	private PrestamoService prestamoService;

	/**
	 * Deposit account.
	 *
	 * @param success the success
	 * @return the model and view
	 */
	@GetMapping("/depositaccount")
	public ModelAndView depositAccount(@RequestParam(name = "success", required = false) String success) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("operacionModel", new OperacionModel());
		modelAndView.addObject("success", success);
		modelAndView.setViewName(ViewConstant.DEPOSITO_CUENTA_FORM);

		return modelAndView;
	}

	/**
	 * Deposit account validation.
	 *
	 * @param operacionModel the operacion model
	 * @return the string
	 */
	@PostMapping("/depositaccount")
	public String depositAccountValidation(@ModelAttribute(name = "operacionModel") OperacionModel operacionModel) {
		operacionServiceImpl.realizarDepositoCuenta(operacionModel);

		return "redirect:/operation/depositaccount?success";
	}

	/**
	 * Account withdrawal.
	 *
	 * @param success the success
	 * @param error the error
	 * @return the model and view
	 */
	// Retirar de cuenta
	@GetMapping("/accountwithdrawal")
	public ModelAndView accountWithdrawal(@RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("operacionModel", new OperacionModel());
		modelAndView.addObject("success", success);
		modelAndView.addObject("error", error);
		modelAndView.setViewName(ViewConstant.RETIRO_CUENTA_FORM);

		return modelAndView;
	}

	/**
	 * Account withdrawal validation.
	 *
	 * @param operacionModel the operacion model
	 * @return the string
	 */
	@PostMapping("/accountwithdrawal")
	public String accountWithdrawalValidation(@ModelAttribute(name = "operacionModel") OperacionModel operacionModel) {
		if (operacionServiceImpl.realizarRetiro(operacionModel) != null) {
			return "redirect:/operation/accountwithdrawal?success";
		}

		return "redirect:/operation/accountwithdrawal?error";
	}

	/**
	 * Pay loan.
	 *
	 * @param success the success
	 * @param error the error
	 * @return the model and view
	 */
	// Pago préstamo
	@GetMapping("/payloan")
	public ModelAndView payLoan(@RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "error", required = false) String error) {
		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("prestamos", prestamoService.findByCliente(usuario.getUsername()));
		modelAndView.addObject("operacionModel", new OperacionModel());
		modelAndView.addObject("success", success);
		modelAndView.addObject("error", error);
		modelAndView.setViewName(ViewConstant.PAGO_PRESTAMO_FORM);

		return modelAndView;
	}

	/**
	 * Pay loan validation.
	 *
	 * @param operacionModel the operacion model
	 * @return the string
	 */
	@PostMapping("/payloan")
	public String payLoanValidation(@ModelAttribute(name = "operacionModel") OperacionModel operacionModel) {
		if (operacionServiceImpl.realizarDepositoPrestamo(operacionModel) != null) {
			return "redirect:/operation/payloan?success";
		}
		return "redirect:/operation/payloan?error";
	}

	/**
	 * Apply loan.
	 *
	 * @param success the success
	 * @param error the error
	 * @return the model and view
	 */
	// Solicitar préstamo
	@GetMapping("/applyloan")
	public ModelAndView applyLoan(@RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("prestamoModel", new PrestamoModel());
		modelAndView.addObject("success", success);
		modelAndView.addObject("error", error);
		modelAndView.setViewName(ViewConstant.SOLICITAR_PRESTAMO_FORM);

		return modelAndView;
	}

	/**
	 * Apply loan validation.
	 *
	 * @param prestamoModel the prestamo model
	 * @return the string
	 */
	@PostMapping("/applyloan")
	public String applyLoanValidation(@ModelAttribute(name = "prestamosModel") PrestamoModel prestamoModel) {
		if (operacionServiceImpl.solicitarPrestamo(prestamoModel) != null) {
			return "redirect:/operation/applyloan?success";
		}

		return "redirect:/operation/applyloan?error";
	}

	/**
	 * Contribution.
	 *
	 * @param success the success
	 * @param error the error
	 * @return the model and view
	 */
	// Aportación
	@GetMapping("/contribution")
	public ModelAndView contribution(@RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 1);
		Date fecha = calendar.getTime();

		modelAndView.addObject("operacionModel", new OperacionModel());
		modelAndView.addObject("fecha", new SimpleDateFormat("yyyy-MM-dd").format(fecha));
		modelAndView.addObject("success", success);
		modelAndView.addObject("error", error);
		modelAndView.setViewName(ViewConstant.APORTACION_FORM);

		return modelAndView;
	}

	/**
	 * Contribution validation.
	 *
	 * @param operacionModel the operacion model
	 * @return the string
	 */
	@PostMapping("/contribution")
	public String contributionValidation(@ModelAttribute(name = "operacionModel") OperacionModel operacionModel) {
		if (operacionServiceImpl.realizarAportacion(operacionModel) != null) {
			return "redirect:/operation/contribution?success";
		}

		return "redirect:/operation/contribution?error";
	}
}
