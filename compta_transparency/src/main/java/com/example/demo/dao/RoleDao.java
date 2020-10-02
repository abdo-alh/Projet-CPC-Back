package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Role;


public interface RoleDao extends JpaRepository<Role, Long> {

	public Role findByAuthority(String authority);

}
