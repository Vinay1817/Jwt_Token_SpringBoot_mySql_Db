package com.task.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.task.model.User;

@Repository
public interface SignUpRepository extends CrudRepository<User, Long> {

	User findByEmailIgnoreCaseAndPassword(String email, String password);

}
