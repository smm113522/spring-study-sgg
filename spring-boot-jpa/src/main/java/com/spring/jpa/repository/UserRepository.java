package com.spring.jpa.repository;

import com.spring.jpa.bean.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SysUser, Long> {


}
