package com.webservice.dexter_service.Security.Unused;


//Klasa nieużywana
public class JWTResponseObject {

   private String token;
   private Long expirationDate;

    public JWTResponseObject(String token, Long expirationDate) {
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
    }
}
