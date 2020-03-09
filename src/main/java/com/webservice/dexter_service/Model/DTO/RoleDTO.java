package com.webservice.dexter_service.Model.DTO;

import com.webservice.dexter_service.Model.Entity.Role;
import com.webservice.dexter_service.Model.Interface.IMapperDto;

import java.io.Serializable;

public class RoleDTO extends BaseDTO implements Serializable, IMapperDto<RoleDTO, Role> {

    private Integer idRole;
    private String name;

    public RoleDTO(Integer idRole, String name) {
        this.idRole = idRole;
        this.name = name;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Role getEntityObject(Object... args) {
        return new Role(idRole, name);
    }
}
