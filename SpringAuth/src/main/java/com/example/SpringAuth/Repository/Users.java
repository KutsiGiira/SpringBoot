package com.example.SpringAuth.Repository;

import com.example.SpringAuth.Model.Student;
import com.example.SpringAuth.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends JpaRepository<User, Integer> {
//    @Query("SELECT u.username FROM User u")
    User findByUsername(String username);
}
