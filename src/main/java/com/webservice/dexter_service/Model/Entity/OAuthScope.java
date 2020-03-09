package com.webservice.dexter_service.Model.Entity;

import com.webservice.dexter_service.Common.Enums.Enums;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Entity
@Table(name = Enums.TABLES.OAUTH_SCOPE.OAUTH_SCOPE, uniqueConstraints = {
        @UniqueConstraint(columnNames = Enums.TABLES.OAUTH_SCOPE.ID_SCOPE)
})
public class OAuthScope extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Enums.TABLES.OAUTH_SCOPE.ID_SCOPE, unique = true, nullable = false)
    private Integer idScope;

    @Column(name = Enums.TABLES.OAUTH_SCOPE.SCOPE, nullable = false)
    private String scope;

    public OAuthScope(Integer idScope, String scope) {
        this.idScope = idScope;
        this.scope = scope;
    }

    public OAuthScope() {
        this.idScope = 0;
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
}
