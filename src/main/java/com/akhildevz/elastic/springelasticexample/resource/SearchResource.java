package com.akhildevz.elastic.springelasticexample.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhildevz.elastic.springelasticexample.model.Users;
import com.akhildevz.elastic.springelasticexample.repository.UsersRepository;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {
	
	@Autowired
	UsersRepository usersRepository;
	
	@GetMapping("/name/{name}")
	public List<Users> searchName(@PathVariable final String name) {
		return usersRepository.findByName(name);
	}
	
	@GetMapping("/salary/{salary}")
	public List<Users> searchBySalary(@PathVariable final Long salary) {
		return usersRepository.findBySalary(salary);
	}
	
	@GetMapping("/all")
	public List<Users> getAll() {
		List<Users> usersList = new ArrayList<>();
		
		Iterable<Users> iterableList = usersRepository.findAll();
		
		iterableList.forEach(usersList::add);
		
		return usersList;
	}

}
