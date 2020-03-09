package com.webservice.dexter_service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservice.dexter_service.Model.Entity.*;
import com.webservice.dexter_service.TestModel.RequestExecutor;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Request;

import java.io.*;
import java.util.*;

import static org.mockito.Mockito.mock;

public class AccountControllerTest {

    @Test
    public void createAccount() {
        try {
            RequestExecutor requestExecutor = new RequestExecutor();
            Account accountToSave = new Account();
            accountToSave.setUsername("Topor95");
            accountToSave.setEmail("szymon466@gmail.com");
            accountToSave.setPassword("Szymon_12");
            Role r = new Role();
            r.setName("Habababa");
            accountToSave.setRoles(new HashSet<>(Arrays.asList(r)));

            //accountToSave.setDataTypes(new HashMap<>(Maps.newHashMap(dt, "")));
            //accountToSave.setDataTypes(new HashMap<>(Maps.newHashMap(dt, "123")));

            HttpEntity httpEntity = new StringEntity(new ObjectMapper().writeValueAsString(accountToSave));
            HttpUriRequest request = RequestBuilder.get()
                    .setUri("http://localhost:8080/api/open/account/create")
                    .setEntity(httpEntity)
                    .build();

            Map.Entry<HttpEntity, StatusLine> entity = requestExecutor.executeRequest(request);


            String str = EntityUtils.toString(entity.getKey());
            Account account = new ObjectMapper().readValue(str, Account.class);

            Assert.assertNotNull(account);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    @Test
    public void getLangs() {
        try {
            RequestExecutor requestExecutor = new RequestExecutor();
            HttpUriRequest request = RequestBuilder.get()
                    .setUri("http://localhost:8080/api/admin/lang/getAll")
                    .build();

            Map.Entry<HttpEntity, StatusLine> entity = requestExecutor.executeRequest(request);


            String str = EntityUtils.toString(entity.getKey());
            System.out.println(str);
            ObjectMapper mapper = new ObjectMapper();
            //langs = mapper.readValue(str, mapper.getTypeFactory().constructCollectionType(List.class, Lang.class));
        } catch (Exception e) {

        }

        Assert.assertNotNull(null);
    }

    /*private OAuth2Request getOauth2Request() {
        String clientId = "client1";
        Map<String, String> requestParameters = Collections.emptyMap();
        boolean approved = true;
        String redirectUrl = "localhost:8080";
        Set<String> responseTypes = Collections.emptySet();
        Set<String> scopes = Collections.emptySet();
        Set<String> resourceIds = Collections.emptySet();
        Map<String, Serializable> extensionProperties = Collections.emptyMap();
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ADMIN");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Authorization", "Basic Y2xpZW50MTpwYXNzd29yZA==");
        parameters.put("grant_type", "password");
        parameters.put("username", "Username1");
        parameters.put("password", "Szymon_12");

        OAuth2Request oAuth2Request = new OAuth2Request(requestParameters, clientId, authorities,
                approved, scopes, resourceIds, redirectUrl, responseTypes, extensionProperties);

        return oAuth2Request;
    }*/
}
