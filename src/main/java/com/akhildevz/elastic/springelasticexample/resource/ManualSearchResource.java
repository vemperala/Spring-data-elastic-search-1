package com.akhildevz.elastic.springelasticexample.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhildevz.elastic.springelasticexample.builder.SearchQueryBuilder;
import com.akhildevz.elastic.springelasticexample.model.Users;

@RestController
@RequestMapping("/rest/manual/search")
public class ManualSearchResource {
	
	@Autowired
	private SearchQueryBuilder searchQueryBuilder;
	
	@GetMapping("/{text}")
	public List<Users> getAll(@PathVariable final String text) {
		return searchQueryBuilder.getAll(text);
	}
}
