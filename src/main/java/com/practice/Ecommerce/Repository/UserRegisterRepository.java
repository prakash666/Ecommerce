package com.practice.Ecommerce.Repository;

import com.practice.Ecommerce.Entity.UserRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegisterEntity,Long> {
}
