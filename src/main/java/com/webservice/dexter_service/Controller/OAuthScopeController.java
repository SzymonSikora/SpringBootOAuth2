package com.webservice.dexter_service.Controller;

import com.webservice.dexter_service.Common.Enums.IREQUESTS;
import com.webservice.dexter_service.Model.Entity.OAuthScope;
import com.webservice.dexter_service.Services.Implementations.OAuthScopeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OAuthScopeController {

    private static final Logger logger = LoggerFactory.getLogger(OAuthGrantTypeController.class);

    @Autowired
    private OAuthScopeServiceImpl oAuthScopeService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = IREQUESTS.REQUESTS.OAUTH_SCOPE.GET_ALL, method = RequestMethod.GET)
    private ResponseEntity<List<OAuthScope>> getAll() {
        List<OAuthScope> scopesResult = oAuthScopeService.getAll();
        return new ResponseEntity<>(scopesResult, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = IREQUESTS.REQUESTS.OAUTH_SCOPE.GET_ONE_BY_ID, method = RequestMethod.GET)
    private ResponseEntity<OAuthScope> getOne(@RequestParam Integer id) {
        OAuthScope oAuthScopeResult = oAuthScopeService.getOne(id);

        if (oAuthScopeResult == null) {
            return new ResponseEntity<OAuthScope>(oAuthScopeResult, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<OAuthScope>(oAuthScopeResult, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = IREQUESTS.REQUESTS.OAUTH_SCOPE.CREATE_OR_UPDATE, method = RequestMethod.POST)
    private ResponseEntity<OAuthScope> createOrUpdate(@RequestBody OAuthScope oAuthScope) {

        OAuthScope oAuthScopeResult = oAuthScopeService.saveOrUpdate(oAuthScope);
        if (oAuthScopeResult == null) {
            return new ResponseEntity<OAuthScope>(oAuthScopeResult, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<OAuthScope>(oAuthScopeResult, HttpStatus.OK);
    }

}
