package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Dealership;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Vehicle;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.DealershipRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.VehicleRepository;

@Controller
public class DealershipsController {

	@Autowired
	private DealershipRepository dealershipRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@GetMapping("/dealerships")
	public String dealerships(Model model) {
		List<Dealership> dealerships = dealershipRepository.findAll();
		model.addAttribute("dealerships", dealerships);
		return "dealership";
	}

	@GetMapping("/dealerships/form")
	public String dealershipForm(@ModelAttribute("dealership") Dealership dealership, Model model) {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		model.addAttribute("vehicles", vehicles);
		return "dealership_form";
	}

	@PostMapping("/dealerships/new")
	public String dealershipNew(@ModelAttribute("dealership") Dealership dealership) {

		dealershipRepository.save(dealership);

		return "redirect:/dealerships";
	}

	@GetMapping("/dealerships/update/{id}")
	public String dealershipUpdate(@PathVariable("id") Integer id, Model model) {
		
		//List<Vehicle> vehicles = vehicleRepository.findAll();
		//model.addAttribute("vehicle", vehicles);


		Optional<Dealership> optDealership = dealershipRepository.findById(id);
		
		if (!optDealership.isPresent()) { // Recupera no banco de dados quando clica em alterar
			// Gerar erro
		}
		
		Dealership dealership = optDealership.get();
		
		model.addAttribute("dealership", dealership);

		return "dealership_form";
	}
	
	@GetMapping("/dealerships/delete/{id}")
	public String dealershipDelete(@PathVariable("id") Integer id) {

		Optional<Dealership> optDealership = dealershipRepository.findById(id);
		
		if (!optDealership.isPresent()) { // Recupera no banco de dados quando clica em alterar
			// Gerar erro
		}
		
		Dealership dealership = optDealership.get();
		
		dealershipRepository.delete(dealership);

		return "redirect:/dealerships";
	}
}
