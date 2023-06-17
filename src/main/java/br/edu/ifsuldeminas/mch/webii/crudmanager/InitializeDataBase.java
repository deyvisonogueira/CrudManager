package br.edu.ifsuldeminas.mch.webii.crudmanager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.UserRepository;

@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String...args) throws Exception{
		
		User deyvison = new User();
		deyvison.setName("Deyvison");
		deyvison.setEmail("deyvison@mail.com");
		deyvison.setGender("M");
		
		User luiza = new User();
		luiza.setName("Luiza");
		luiza.setEmail("luiza@mail.com");
		luiza.setGender("F");
		
		User le = new User();
		le.setName("Le");
		le.setEmail("le@mail.com");
		le.setGender("F");
		
		userRepository.save(deyvison);
		userRepository.save(luiza);
		userRepository.save(le);		
	}
}
