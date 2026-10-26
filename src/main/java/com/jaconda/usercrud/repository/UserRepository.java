package com.jaconda.usercrud.repository;

import com.jaconda.usercrud.dto.UserDTO;
import com.jaconda.usercrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //нативный запрос
//    @Query(value = "select * from users where email = :email", nativeQuery = true)
//    User findByEmail(String email);

    //JPQL нативный запрос
//    @Query(value = "select u from user u where u.email = :email")
//    User findByEmail(String email);

    Optional<User> findByEmail(String email);
}
