package com.jaconda.usercrud.repository;

import com.jaconda.usercrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
