package com.example.demo;

import com.example.demo.Models.*;
import com.example.demo.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseInit implements CommandLineRunner{
	@Autowired 
	private UserRepository userRepository;

	@Autowired
	private ProduceRepository produceRepository;

	
	@Override
	 public void run(String... args) throws Exception {
		userRepository.deleteAll();
		produceRepository.deleteAll();
		
		
		User user1 = new User("Bob","bob@sample.com", "bob_pass", UserType.BUYER);
		userRepository.save(user1);
		User user2 = new User("Prapanch","prapanch@sample.com", "bob_pass", UserType.SELLER);
		userRepository.save(user2);
		User user3 = new User("Ademola","ademola@sample.com", "bob_pass", UserType.BOTH);
		userRepository.save(user3);
		User user4 = new User("Zhixian","zhixian@sample.com", "bob_pass", UserType.BUYER);
		userRepository.save(user4);
		
		Produce produce1 = new Produce("Apples");
		produceRepository.save(produce1);
		Produce produce2 = new Produce("Lettuce");
		produceRepository.save(produce2);
		Produce produce3 = new Produce("Potatoes");
		produceRepository.save(produce3);
		
	}
}
