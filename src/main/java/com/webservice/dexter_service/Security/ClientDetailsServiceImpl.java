package com.webservice.dexter_service.Security;

import com.webservice.dexter_service.Model.Entity.OAuthClient;
import com.webservice.dexter_service.Services.Implementations.OAuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {
    static final String CLIENT_ID = "client";
    static final String CLIENT_SECRET = "$2a$04$cOxgEE2ZxDYXx0mMqELJa./n5M82.zppmLGz33HL2nPeW10luLGlq";//password
    //Grant types
    static final String GRANT_TYPE = "password";
    static final String AUTHORIZATION_CODE = "authorization_code";
    static final String REFRESH_TOKEN = "refresh_token";
    static final String IMPLICIT = "implicit";
    //end

    //scopes
    static final String SCOPE_READ = "read";
    static final String SCOPE_WRITE = "write";
    static final String TRUST = "trust";
    //end
    static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
    static final int REFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;

    @Autowired
    private OAuthServiceImpl oAuthService;

    @Bean
    public ClientDetailsService clientDetailsService(){
        return new ClientDetailsServiceImpl();
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails clientDetails = new BaseClientDetails();

        OAuthClient oAuthClient = oAuthService.getOneByClientId(clientId);
        if(oAuthClient == null){
            throw new ClientRegistrationException("Client does not exist");
        }

        clientDetails.setClientId(oAuthClient.getIdClient());
        clientDetails.setClientSecret(oAuthClient.getClientSecret());
        clientDetails.setAuthorizedGrantTypes(oAuthClient.getGrantTypes().stream().map(q -> q.getGrantType()).collect(Collectors.toList()));
        clientDetails.setScope(oAuthClient.getScopes().stream().map(q -> q.getScope()).collect(Collectors.toList()));
        clientDetails.setAccessTokenValiditySeconds(oAuthClient.getAccessTokenValiditySecends());
        clientDetails.setRefreshTokenValiditySeconds(oAuthClient.getRefreshTokenValiditySecends());
        return (ClientDetails)clientDetails;
    }
}
