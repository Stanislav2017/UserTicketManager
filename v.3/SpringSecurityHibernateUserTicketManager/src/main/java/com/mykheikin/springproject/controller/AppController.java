package com.mykheikin.springproject.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mykheikin.springproject.model.Ticket;
import com.mykheikin.springproject.model.User;
import com.mykheikin.springproject.service.RoleService;
import com.mykheikin.springproject.service.TicketService;
import com.mykheikin.springproject.service.UserService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;
	
	@Autowired
	TicketService ticketService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("user", userService.findByUsername(getPrincipal()));
		return "welcome";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/welcome";  
	    }
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		model.addAttribute("user", new User());
		model.addAttribute("message", "Sign In");
		return "registration";
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		if (!userService.isUsernameUnique(user.getId(), user.getUsername())) {
			FieldError ssoError = new FieldError("user", "username", messageSource.getMessage("non.unique.username",
					new String[] { user.getUsername() }, Locale.getDefault()));
			result.addError(ssoError);
			return "registration";
		}

		userService.save(user);

		model.addAttribute("user", user);

		return "welcome";
	}
	
	// ===================================================================

		@RequestMapping(value = { "/ticket" }, method = RequestMethod.GET)
		public String newTicket(ModelMap model) {

			model.addAttribute("ticket", new Ticket());
			model.addAttribute("message", "Create new ticket");

			return "ticketform";
		}

		@RequestMapping(value = { "/ticket" }, method = RequestMethod.POST)
		public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
			
			User user = userService.findByUsername(getPrincipal());
			Ticket entity = ticket;
			entity.setUser(user);

			ticketService.save(entity);

			return "redirect:/welcome";
		}

		// ===================================================================

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}
}
