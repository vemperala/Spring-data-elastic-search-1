package com.akhildevz.elastic.springelasticexample.builder;

import java.util.List;

import javax.management.Query;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import com.akhildevz.elastic.springelasticexample.model.Users;

@Component
public class SearchQueryBuilder {
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	
	public List<Users> getAll(String text){
		
		QueryBuilder query = QueryBuilders.boolQuery()
				.should(
					QueryBuilders.queryStringQuery(text)
					.lenient(true)
					.field("name")
					.field("teamName")
				).should(QueryBuilders.queryStringQuery("*"+text+"*")
						.lenient(true)
						.field("name")
						.field("teamName"));
		
		NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();
		
		return elasticsearchTemplate.queryForList(build, Users.class);
					
	}
}
