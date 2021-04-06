package com.usingbean.demo.repostory;

import com.usingbean.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostory extends JpaRepository<User, Integer> {
}
