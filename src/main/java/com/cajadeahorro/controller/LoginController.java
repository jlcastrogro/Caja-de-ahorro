package com.cajadeahorro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cajadeahorro.constant.ViewConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {

	/**
	 * Login form.
	 *
	 * @param model the model
	 * @param error the error
	 * @param logout the logout
	 * @return the string
	 */
	@GetMapping("/login")
	public String loginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);

		return ViewConstant.LOGIN_VIEW;
	}

	/**
	 * Login check.
	 *
	 * @return the string
	 */
	@GetMapping({ "/loginsuccess", "/" })
	public String loginCheck() {
		return "redirect:/home";
	}

}
