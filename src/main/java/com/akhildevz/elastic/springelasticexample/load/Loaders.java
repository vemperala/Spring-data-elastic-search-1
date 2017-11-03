package com.akhildevz.elastic.springelasticexample.load;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.akhildevz.elastic.springelasticexample.model.Users;
import com.akhildevz.elastic.springelasticexample.repository.UsersRepository;

@Component
public class Loaders {

	@Autowired
	ElasticsearchOperations operations;
	
	@Autowired
	UsersRepository usersRepository;
	
	
	
	@PostConstruct
	@Transactional
	public void loadAll() {
		operations.putMapping(Users.class);
		System.out.println("loading data");
		
		usersRepository.save(getData());
		System.out.println("loading completed");
	}

	private List<Users> getData() {
		// TODO Auto-generated method stub
		List<Users> list = new ArrayList<Users>();
		
		list.add(new Users( "Akhilesh",12L, "Web Developer", 90000L));
		list.add(new Users(  "Chinni", 13L,"Admin", 100000L));
		list.add(new Users( "Anvitha", 14L, "Developer", 95000L));
		
		return list;
	}
}
