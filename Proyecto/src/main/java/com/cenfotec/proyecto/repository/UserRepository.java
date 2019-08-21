package com.cenfotec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.proyecto.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
