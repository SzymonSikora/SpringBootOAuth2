package com.webservice.dexter_service.Services.Implementations;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.webservice.dexter_service.Model.Entity.Role;
import com.webservice.dexter_service.Repository.IRoleRepository;
import com.webservice.dexter_service.Services.Interfaces.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    IRoleRepository roleRepository;

    @Override
    public IRoleRepository getRepository() {
        return roleRepository;
    }

    @Override
    public Role saveOrUpdate(Role entity) {
        try {
            return roleRepository.save(entity);
        } catch (Exception e) {
            logger.error(String.format("SaveOrUpdate role failed. Role: idRole: %s, name: %s", entity.getIdRole(), entity.getName()));
            return null;
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            Integer countRoleUsed = roleRepository.isRoleUsed(id);
            if (countRoleUsed > 0) {
                throw new Exception("This role is used. Before delete role, no account can have this role. IdRole: " + id);
            }
            roleRepository.delete(roleRepository.getOne(id));
        } catch (Exception e) {
            logger.error(String.format("An error occurred while deleting role by id: %s", id));
            return false;
        }
        return true;
    }

    @Override
    public List<Role> getAll() {
        try {
            return roleRepository.findAll();
        } catch (Exception e) {
            logger.error("An error occurred while getting all Roles");
            return new ArrayList<Role>();
        }
    }

    @Override
    public Set<Role> getDefault() {
        List<String> defaultRolesName = Arrays.asList("USER");
        Set<Role> defaultRoles = roleRepository.getRolesByNames(defaultRolesName);
        if (defaultRoles == null || defaultRoles.isEmpty()) {
            return null;
        }

        return defaultRoles;
    }

    @Override
    public Role getOne(Integer id) {
        try {
            return roleRepository.getOne(id);
        } catch (Exception e) {
            logger.error(String.format("An error occurred while getting Role by id: %s", id));
            return null;
        }
    }

}
