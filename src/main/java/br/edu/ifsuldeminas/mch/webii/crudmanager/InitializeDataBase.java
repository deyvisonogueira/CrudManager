package br.edu.ifsuldeminas.mch.webii.crudmanager;

import javax.transaction.Transactional;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Vehicle;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.DealershipRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.VehicleRepository;


@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private DealershipRepository dealershipRepository;

    @Override
    public void run(String... args) throws Exception {
        // Abaixo foi simulado um banco de dados.

    	Vehicle bmw = new Vehicle();
    	bmw.setModel("BMW X1");
    	bmw.setColor("Branco");
    	bmw.setManufacture_year("2020");

        Vehicle honda = new Vehicle();
        honda.setModel("Honda Civic");
        honda.setColor("Preto");
        honda.setManufacture_year("2022");

        Vehicle fiat = new Vehicle();
    	fiat.setModel("Fiat Argo");
    	fiat.setColor("Vermelho");
    	fiat.setManufacture_year("2021");

    	Vehicle mercedes = new Vehicle();
    	mercedes.setModel("Mercedez Glasse G");
    	mercedes.setColor("Cinza");
    	mercedes.setManufacture_year("2023");

    	Vehicle ford = new Vehicle();
    	ford.setModel("Ford F-150");
    	ford.setColor("Preto Orvalho");
    	ford.setManufacture_year("2023");

    	vehicleRepository.save(bmw);
    	vehicleRepository.save(honda);
    	vehicleRepository.save(fiat);
    	vehicleRepository.save(mercedes);
    	vehicleRepository.save(ford);
    	
    	Dealership dealership = new Dealership();
        dealership.setName("Concessionária Dois Irmãos");
        dealership.setAddress("Avenida dos Irmãos, 100");
        dealership.setAbout("A Concessionária Dois Irmãos é uma empresa especializada na venda de veículos novos e usados. "
        		+ "Com uma ampla variedade de modelos e marcas, a Dois Irmãos oferece opções para todos os gostos e necessidades. "
        		+ "Além disso, contamos com uma equipe dedicada e experiente, pronta para auxiliar os clientes em cada etapa da compra, "
        		+ "proporcionando uma experiência personalizada e satisfatória."); 
    	
    	dealership.getVehicles().add(bmw);
    	dealership.getVehicles().add(honda);
    	dealership.getVehicles().add(fiat);
    	dealership.getVehicles().add(mercedes);
    	dealership.getVehicles().add(ford);
    	
    	dealershipRepository.save(dealership);
    }
}
