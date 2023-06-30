package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message = "Preencha um modelo de veículo.")
    private String model;
    
    @NotBlank(message = "Preencha uma cor.")
    private String color;
    
    @NotBlank(message = "Ano não pode ser vazio.")
    private String manufacture_year;

    @ManyToMany(mappedBy = "vehicles", fetch = FetchType.EAGER)
    private List<Dealership> dealership = new ArrayList<>();

    public Vehicle() {}

    public Vehicle(Integer id) {
    	 this.id = id;
         setModel("");
         setColor("");
         setManufacture_year("");
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getManufacture_year() {
		return manufacture_year;
	}

	public void setManufacture_year(String manufacture_year) {
		this.manufacture_year = manufacture_year;
	}

	public List<Dealership> getDealership() {
		return dealership;
	}

	public void setDealership(List<Dealership> dealership) {
		this.dealership = dealership;
	}

    
}