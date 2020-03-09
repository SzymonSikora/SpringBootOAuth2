package com.webservice.dexter_service.TestModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

public class RequestExecutor {

    private static AuthorizationToken authorizationToken;
    private String contentType = "application/json";

    public static AuthorizationToken getAuthorizationToken() {
        return authorizationToken;
    }

    public static void setAuthorizationToken(AuthorizationToken authorizationToken) {
        RequestExecutor.authorizationToken = authorizationToken;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public RequestExecutor() {
        try {
            authorize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map.Entry<HttpEntity, StatusLine> executeRequest(HttpUriRequest request) {
        if (authorizationToken == null || StringUtils.isEmpty(authorizationToken.getAccess_token())) {
            try {
                this.authorize();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        request.addHeader("Authorization", String.format("Bearer %s", authorizationToken.getAccess_token()));
        request.addHeader("Content-Type", contentType);

        final HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = null;
        HttpEntity entity = null;
        try {
            response = client.execute(request);
            entity = response.getEntity();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map.Entry<HttpEntity, StatusLine> entryResult = new AbstractMap.SimpleEntry<HttpEntity, StatusLine>(entity, response.getStatusLine());
        return entryResult;
    }

    private Boolean refreshToken() throws IOException {
        if(authorizationToken == null){
            authorize();
            return true;
        }

        HttpUriRequest httpRefreshToken = AuthClient.getRefreshTokenHttpRequest(authorizationToken.getRefresh_token());
        final HttpClient client = HttpClientBuilder.create().build();
        final HttpResponse response = client.execute(httpRefreshToken);
        final HttpEntity entity = response.getEntity();

        String str = EntityUtils.toString(entity);
        try {
            authorizationToken = new ObjectMapper().readValue(str, AuthorizationToken.class);
        } catch (Exception e) {

        }
        return true;
    }

    public void authorize() throws IOException {
        HttpUriRequest httpRequestAuth = AuthClient.getNewAuthorizeHttpRequest();

        final HttpClient client = HttpClientBuilder.create().build();
        final HttpResponse response = client.execute(httpRequestAuth);
        final HttpEntity entity = response.getEntity();

        String str = EntityUtils.toString(entity);
        try {
            authorizationToken = new ObjectMapper().readValue(str, AuthorizationToken.class);
        } catch (Exception e) {

        }
    }
}
