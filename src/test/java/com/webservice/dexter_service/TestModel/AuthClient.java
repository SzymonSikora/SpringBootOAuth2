package com.webservice.dexter_service.TestModel;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;


public abstract class AuthClient {

    public AuthClient(){}

    private static String url = "http://localhost:8080/oauth/token";
    private static String contentType = "application/x-www-form-urlencoded";
    private static String accept = "application/json";
    private static String authorization = "Basic Y2xpZW50MTpwYXNzd29yZA==";
    private static String username = "Username1";
    private static String password = "Szymon_12";
    private static String grantTypePassword = "password";
    private static String grantTypeRefreshToken = "refresh_token";

    public static String getUrl() {
        return url;
    }

    public static String getContentType() {
        return contentType;
    }

    public static String getAccept() {
        return accept;
    }

    public static String getAuthorization() {
        return authorization;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getGrantTypePassword() {
        return grantTypePassword;
    }

    public static String getGrantTypeRefreshToken() {
        return grantTypeRefreshToken;
    }

    public static HttpUriRequest getNewAuthorizeHttpRequest() {

        final HttpUriRequest request = RequestBuilder.post()
                .setUri(url)
                .setHeader("Content-Type", contentType)
                .setHeader("Accept", accept)
                .setHeader("Authorization", authorization)
                .addParameter("username", username)
                .addParameter("password", password)
                .addParameter("grant_type", grantTypePassword)
                .build();

        return request;
    }

    public static HttpUriRequest getRefreshTokenHttpRequest(String refreshToken) {

        final HttpUriRequest request = RequestBuilder.post()
                .setUri(url)
                .setHeader("Content-Type", contentType)
                .addParameter("refresh_token", refreshToken)
                .addParameter("grant_type", grantTypeRefreshToken)
                .build();

        return request;
    }
}
