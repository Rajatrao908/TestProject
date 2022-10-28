package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.pojo.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
