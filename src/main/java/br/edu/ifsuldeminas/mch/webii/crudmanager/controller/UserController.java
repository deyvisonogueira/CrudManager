package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")               
	public String usuarios(Model model) { //Quem chama usuarios(objeto) é o Spring
		
		List<User> users = userRepository.findAll(); //Select em todos dados da tabela
		model.addAttribute("usuariosDB",users);
		
		return "index";
	}

}
