package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dealerships")
public class Dealership {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Preencha um nome.")
	private String name;
	
	@NotBlank(message = "Endereo não pode ser vazio.")
	private String address;
	
	@NotBlank(message = "Descreva sobre a concessionária.")
	@Column(length = 800)
	private String about;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dealerships_vehicles",
            joinColumns = @JoinColumn(name = "dealership_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
        )
    private List<Vehicle> vehicles = new ArrayList<>();

    public Dealership() {}

    public Dealership(Integer id) {
    	this.id = id;
		setName("");
		setAddress("");
		setAbout("");
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
    
}