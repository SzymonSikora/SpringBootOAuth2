package com.webservice.dexter_service.Model.DTO;

import com.webservice.dexter_service.Model.Entity.OAuthScope;
import com.webservice.dexter_service.Model.Interface.IMapperDto;

public class OAuthScopeDTO extends BaseDTO implements IMapperDto<OAuthScopeDTO, OAuthScope> {

    private Integer idScope;
    private String scope;

    public OAuthScopeDTO(Integer idScope, String scope) {
        this.idScope = idScope;
        this.scope = scope;
    }

    public OAuthScopeDTO() {
    }

    public Integer getIdScope() {
        return idScope;
    }

    public void setIdScope(Integer idScope) {
        this.idScope = idScope;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public OAuthScope getEntityObject(Object... args) {
        return new OAuthScope(idScope, scope);
    }
}
