package com.mykheikin.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mykheikin.manager.model.Ticket;
import com.mykheikin.manager.model.User;
import com.mykheikin.manager.service.TicketService;
import com.mykheikin.manager.service.UserService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	private UserService userService;

	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String Userlist( ModelMap model) {
			
		model.addAttribute("users", userService.findAllUser());

		return "list";
	}

	// ==================================================================

	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {

		model.addAttribute("user", new User());
		model.addAttribute("edit", false);

		return "userform";
	}

	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {

		userService.save(user);

		return "redirect:/list";
	}

	// ===================================================================

	@RequestMapping(value = { "/ticket/{id}" }, method = RequestMethod.GET)
	public String newTicket(@PathVariable int id, ModelMap model) {

		model.addAttribute("ticket", new Ticket());
		model.addAttribute("edit", false);

		return "ticketform";
	}

	@RequestMapping(value = { "/ticket/{id}" }, method = RequestMethod.POST)
	public String saveTicket(@PathVariable int id, @ModelAttribute("ticket") Ticket ticket) {
		
		/*User user = userService.findById(id);
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket);
		user.setTickets(tickets);
		
		Ticket entity = ticket;
		
		entity.setUser(user);
		
		userService.update(user);*/
		
		User user = userService.findById(id);
		Ticket entity = ticket;
		entity.setUser(user);

		ticketService.save(entity);

		return "redirect:/list";
	}

	// ===================================================================
	
	@RequestMapping(value = { "/userinfo/{id}" }, method = RequestMethod.GET)
	public String userInfo(@PathVariable int id, ModelMap model) {

		model.addAttribute("user", userService.findById(id));

		return "userinfo";
	}

	@RequestMapping(value = { "/edit-user/{id}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable int id, ModelMap model) {

		model.addAttribute("user", userService.findById(id));
		model.addAttribute("edit", true);

		return "userform";
	}

	@RequestMapping(value = { "/edit-user/{id}" }, method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user) {

		userService.update(user);

		return "redirect:/list";
	}

	// ===================================================================

	@RequestMapping(value = { "/edit-ticket/{id}" }, method = RequestMethod.GET)
	public String editTicket(@PathVariable int id, ModelMap model) {

		model.addAttribute("ticket", ticketService.findById(id));
		model.addAttribute("edit", true);

		return "ticketform";
	}

	@RequestMapping(value = { "/edit-ticket/{id}" }, method = RequestMethod.POST)
	public String updateTicket(@ModelAttribute("ticket") Ticket ticket) {

		ticketService.update(ticket);

		return "redirect:/list";
	}

	// ===================================================================

	@RequestMapping(value = { "/delete-user/{id}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id) {

		userService.deleteById(id);

		return "redirect:/list";
	}

	// ===================================================================

	@RequestMapping(value = { "/delete-ticket/{id}" }, method = RequestMethod.GET)
	public String deleteTicket(@PathVariable int id) {

		ticketService.deleteById(id);

		return "redirect:/list";
	}
}
