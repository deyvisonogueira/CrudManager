package br.edu.ifsuldeminas.mch.webii.crudmanager;

import java.util.List;

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
	public void run(String... args) throws Exception {
		User deyvison = new User();
		deyvison.setName("Deyvison");
		deyvison.setEmail("deyvison@gmail.com");
		deyvison.setGender("M");

		User luiza = new User();
		luiza.setName("Luiza");
		luiza.setEmail("luiza@gmail.com");
		luiza.setGender("F");

		User nogueira = new User();
		nogueira.setName("Nogueira");
		nogueira.setEmail("nogueira@gmail.com");
		nogueira.setGender("M");

		userRepository.save(deyvison);
		userRepository.save(luiza);
		userRepository.save(nogueira);

		List<User> users = userRepository.findAll(); // disparou um select 

		for (User user : users) {
			System.err.println(user.getName());
			System.err.println(user.getEmail());
			System.err.println(user.getGender());
		}
	}
}

