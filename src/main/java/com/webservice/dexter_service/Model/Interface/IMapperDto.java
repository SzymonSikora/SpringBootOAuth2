package com.webservice.dexter_service.Model.Interface;

import com.webservice.dexter_service.Model.DTO.BaseDTO;
import com.webservice.dexter_service.Model.Entity.BaseEntity;
import com.webservice.dexter_service.Services.Implementations.RoleServiceImpl;
import com.webservice.dexter_service.Services.Interfaces.IRoleService;

import java.io.Serializable;

public interface IMapperDto<T extends BaseDTO, R extends BaseEntity> {

    public R getEntityObject(Object... args);
}
