package com.webservice.dexter_service.Model.Entity;

import java.io.Serializable;

import javax.persistence.*;

import com.webservice.dexter_service.Common.Enums.Enums;
import com.webservice.dexter_service.Model.DTO.RoleDTO;
import com.webservice.dexter_service.Model.Interface.IMapperEntity;

@Entity
@Table(name = Enums.TABLES.ROLE.ROLE, uniqueConstraints = {
        @UniqueConstraint(columnNames = Enums.TABLES.ROLE.ID_ROLE),
        @UniqueConstraint(columnNames = Enums.TABLES.ROLE.NAME)
})
public class Role extends BaseEntity implements Serializable, IMapperEntity<Role, RoleDTO> {

    private static final long serialVersionUID = 1L;

    public Role(Integer idRole, String name) {
        this.idRole = idRole;
        this.name = name;
    }

    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Enums.TABLES.ROLE.ID_ROLE)
    private Integer idRole;

    @Column(name = Enums.TABLES.ROLE.NAME)
    private String name;

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
    public RoleDTO getDtoObject(Object... args) {
        return new RoleDTO(idRole, name);
    }
}
