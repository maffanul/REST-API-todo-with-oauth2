package com.example.todo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.todo.model.User;

public interface UserDao extends CrudRepository<User, Long>{

	 User findByUsername(String username);
}
