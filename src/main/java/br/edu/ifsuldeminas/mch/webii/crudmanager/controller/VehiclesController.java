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
public class VehiclesController {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private DealershipRepository dealershipRepository;
	
	@GetMapping("/vehicles")
	public String vehicle(Model model) {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		model.addAttribute("vehicles", vehicles);
		return "vehicle";
	}

	@GetMapping("/vehicles/form")
	public String vehicleForm(Model model) {
		Vehicle vehicle = new Vehicle();
		List<Dealership> dealerships = dealershipRepository.findAll();
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("dealerships", dealerships);
		return "vehicle_form";
	}

	@PostMapping("/vehicles/new")
	public String vehicleNew(@ModelAttribute("vehicle") Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		return "redirect:/vehicles";
	}

	@GetMapping("/vehicles/update/{id}")
	public String vehicleUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Vehicle> optVehicle = vehicleRepository.findById(id);
		if (!optVehicle.isPresent()) {
			// Gerar erro ou redirecionar para uma página de erro
			return "redirect:/vehicles";
		}
		Vehicle vehicle = optVehicle.get();
		List<Dealership> dealerships = dealershipRepository.findAll();
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("dealerships", dealerships);
		return "vehicle_form";
	}
	
	@GetMapping("/vehicles/delete/{id}")
	public String vehicleDelete(@PathVariable("id") Integer id) {
		Optional<Vehicle> optVehicle = vehicleRepository.findById(id);
		if (!optVehicle.isPresent()) {
			// Gerar erro ou redirecionar para uma página de erro
			return "redirect:/vehicles";
		}
		Vehicle vehicle = optVehicle.get();
		vehicleRepository.delete(vehicle);
		return "redirect:/vehicles";
	}
}
