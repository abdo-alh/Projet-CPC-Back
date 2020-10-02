package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Role;
import com.example.demo.dao.RoleDao;
import com.example.demo.service.facade.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleRepository;

	@Override
	public Role save(Role role) {
		Role loadedRole=roleRepository.findByAuthority(role.getAuthority());
		if(loadedRole==null) {
			roleRepository.save(role);
			return role;
		}
		return loadedRole;
	}
	
}
