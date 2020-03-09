package com.webservice.dexter_service.Services.Interfaces;

import java.util.Collection;
import java.util.Set;

import com.webservice.dexter_service.Model.Entity.Role;
import com.webservice.dexter_service.Repository.IRoleRepository;

public interface IRoleService {

    IRoleRepository getRepository();

    Role saveOrUpdate(Role entity);

    Boolean delete(Integer id);

    Collection<Role> getAll();

    Role getOne(Integer id);

    Set<Role> getDefault();
}
