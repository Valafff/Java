package com.jirbaza.health.repository;

import com.jirbaza.health.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository  extends JpaRepository<User, String>
{

}
