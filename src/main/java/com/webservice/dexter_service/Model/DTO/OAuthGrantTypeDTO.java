package com.webservice.dexter_service.Model.DTO;

import com.webservice.dexter_service.Model.Entity.OAuthGrantType;
import com.webservice.dexter_service.Model.Interface.IMapperDto;

public class OAuthGrantTypeDTO extends BaseDTO implements IMapperDto<OAuthGrantTypeDTO, OAuthGrantType> {

    private Integer idGrantType;
    private String grantType;

    public OAuthGrantTypeDTO(Integer idGrantType, String grantType) {
        this.idGrantType = idGrantType;
        this.grantType = grantType;
    }

    public OAuthGrantTypeDTO() {
    }

    public Integer getIdGrantType() {
        return idGrantType;
    }

    public void setIdGrantType(Integer idGrantType) {
        this.idGrantType = idGrantType;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    @Override
    public OAuthGrantType getEntityObject(Object... args) {
        return new OAuthGrantType(idGrantType, grantType);
    }
}
