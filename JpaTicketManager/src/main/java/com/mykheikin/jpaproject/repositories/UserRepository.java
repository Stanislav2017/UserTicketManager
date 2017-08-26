package com.mykheikin.jpaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mykheikin.jpaproject.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
