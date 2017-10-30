package com.akhildevz.elastic.springelasticexample.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.akhildevz.elastic.springelasticexample.model.Users;

@Repository
public interface UsersRepository extends ElasticsearchRepository<Users, Long>{

	void save(List<Users> data);

	List<Users> findByName(String name);

	List<Users> findBySalary(Long salary);

}
