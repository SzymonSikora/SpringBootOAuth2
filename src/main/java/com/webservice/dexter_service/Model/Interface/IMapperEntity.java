package com.webservice.dexter_service.Model.Interface;

import com.webservice.dexter_service.Model.DTO.BaseDTO;
import com.webservice.dexter_service.Model.Entity.BaseEntity;

import java.io.Serializable;

public interface IMapperEntity<T extends BaseEntity, R extends BaseDTO> {

    public R getDtoObject(Object... args);

}
