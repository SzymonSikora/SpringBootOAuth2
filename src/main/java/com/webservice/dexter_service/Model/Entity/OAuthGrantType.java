package com.webservice.dexter_service.Model.Entity;

import com.webservice.dexter_service.Common.Enums.Enums;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = Enums.TABLES.OAUTH_GRANT_TYPE.OAUTH_GRANT_TYPE, uniqueConstraints = {
        @UniqueConstraint(columnNames = Enums.TABLES.OAUTH_GRANT_TYPE.ID_GRANT_TYPE)
})
public class OAuthGrantType extends BaseEntity implements Serializable {

    public OAuthGrantType(Integer idGrantType, String grantType) {
        this.idGrantType = idGrantType;
        this.grantType = grantType;
    }

    public OAuthGrantType() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Enums.TABLES.OAUTH_GRANT_TYPE.ID_GRANT_TYPE, unique = true, nullable = false)
    private Integer idGrantType;

    @Column(name = Enums.TABLES.OAUTH_GRANT_TYPE.GRANT_TYPE, nullable = false)
    private String grantType;

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
}
