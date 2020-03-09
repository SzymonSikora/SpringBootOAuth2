package com.webservice.dexter_service.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webservice.dexter_service.Common.Enums.Enums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = Enums.TABLES.OAUTH_CLIENT.OAUTH_CLIENT, uniqueConstraints = {
        @UniqueConstraint(columnNames = Enums.TABLES.OAUTH_CLIENT.ID_CLIENT),
})
public class OAuthClient extends BaseEntity implements Serializable {

    @Transient
    @JsonIgnore
    Logger logger = LoggerFactory.getLogger(OAuthClient.class);

    public OAuthClient(@Size(max = 200, min = 5) String idClient, @Size(max = 200, min = 10) String clientSecret, Set<OAuthGrantType> grantTypes, Set<OAuthScope> scopes, Integer accessTokenValiditySecends, Integer refreshTokenValiditySecends) {
        this.idClient = idClient;
        this.clientSecret = clientSecret;
        this.grantTypes = grantTypes;
        this.scopes = scopes;
        this.accessTokenValiditySecends = accessTokenValiditySecends;
        this.refreshTokenValiditySecends = refreshTokenValiditySecends;
    }

    public OAuthClient() {}

    @Id
    @Column(name = Enums.TABLES.OAUTH_CLIENT.ID_CLIENT, unique = true, nullable = false)
    @Size(max = 200, min = 5)
    private String idClient;

    @Column(name = Enums.TABLES.OAUTH_CLIENT.CLIENT_SECRET, unique = false, nullable = false)
    @Size(max = 200, min = 10)
    private String clientSecret;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = Enums.TABLES.OAUTH_CLIENT.OAUTH_CLIENT_GRANT_TYPE,
            joinColumns = @JoinColumn(name = Enums.TABLES.OAUTH_CLIENT.ID_CLIENT, unique = false, nullable = false),
            inverseJoinColumns = @JoinColumn(name = Enums.TABLES.OAUTH_GRANT_TYPE.ID_GRANT_TYPE, unique = false, nullable = false))
    private Set<OAuthGrantType> grantTypes;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = Enums.TABLES.OAUTH_CLIENT.OAUTH_CLIENT_SCOPES,
            joinColumns = @JoinColumn(name = Enums.TABLES.OAUTH_CLIENT.ID_CLIENT, unique = false, nullable = false),
            inverseJoinColumns = @JoinColumn(name = Enums.TABLES.OAUTH_SCOPE.ID_SCOPE, unique = false, nullable = false))
    private Set<OAuthScope> scopes;

    @Column(name = Enums.TABLES.OAUTH_CLIENT.ACCESS_TOKEN_VALIDITY_SECENDS, unique = false, nullable = false)
    private Integer accessTokenValiditySecends;

    @Column(name = Enums.TABLES.OAUTH_CLIENT.REFRESH_TOKEN_VALIDITY_SECENDS, unique = false, nullable = false)
    private Integer refreshTokenValiditySecends;

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

    public Set<OAuthGrantType> getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(Set<OAuthGrantType> grantTypes) {
        this.grantTypes = grantTypes;
    }

    public Set<OAuthScope> getScopes() {
        return scopes;
    }

    public void setScopes(Set<OAuthScope> scopes) {
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
}