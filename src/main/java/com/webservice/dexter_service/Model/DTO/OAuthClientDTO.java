package com.webservice.dexter_service.Model.DTO;

import com.webservice.dexter_service.Model.Entity.OAuthClient;
import com.webservice.dexter_service.Model.Entity.OAuthGrantType;
import com.webservice.dexter_service.Model.Entity.OAuthScope;
import com.webservice.dexter_service.Model.Interface.IMapperDto;

import java.util.Set;
import java.util.stream.Collectors;

public class OAuthClientDTO extends BaseDTO implements IMapperDto<OAuthClientDTO, OAuthClient> {

    private String idClient;
    private String clientSecret;
    private Set<OAuthGrantTypeDTO> grantTypes;
    private Set<OAuthScopeDTO> scopes;
    private Integer accessTokenValiditySecends;
    private Integer refreshTokenValiditySecends;

    public OAuthClientDTO(String idClient, String clientSecret, Set<OAuthGrantTypeDTO> grantTypes, Set<OAuthScopeDTO> scopes, Integer accessTokenValiditySecends, Integer refreshTokenValiditySecends) {
        this.idClient = idClient;
        this.clientSecret = clientSecret;
        this.grantTypes = grantTypes;
        this.scopes = scopes;
        this.accessTokenValiditySecends = accessTokenValiditySecends;
        this.refreshTokenValiditySecends = refreshTokenValiditySecends;
    }

    public OAuthClientDTO() {
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public Set<OAuthGrantTypeDTO> getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(Set<OAuthGrantTypeDTO> grantTypes) {
        this.grantTypes = grantTypes;
    }

    public Set<OAuthScopeDTO> getScopes() {
        return scopes;
    }

    public void setScopes(Set<OAuthScopeDTO> scopes) {
        this.scopes = scopes;
    }

    public Integer getAccessTokenValiditySecends() {
        return accessTokenValiditySecends;
    }

    public void setAccessTokenValiditySecends(Integer accessTokenValiditySecends) {
        this.accessTokenValiditySecends = accessTokenValiditySecends;
    }

    public Integer getRefreshTokenValiditySecends() {
        return refreshTokenValiditySecends;
    }

    public void setRefreshTokenValiditySecends(Integer refreshTokenValiditySecends) {
        this.refreshTokenValiditySecends = refreshTokenValiditySecends;
    }

    @Override
    public OAuthClient getEntityObject(Object... args) {
        return new OAuthClient(
                idClient,
                clientSecret,
                grantTypes.stream().map(q -> new OAuthGrantType(q.getIdGrantType(), q.getGrantType())).collect(Collectors.toSet()),
                scopes.stream().map(q -> new OAuthScope(q.getIdScope(), q.getScope())).collect(Collectors.toSet()),
                accessTokenValiditySecends,
                refreshTokenValiditySecends
                );
    }
}
