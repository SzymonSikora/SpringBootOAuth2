package com.webservice.dexter_service.Controller;

import com.webservice.dexter_service.Common.Enums.IREQUESTS;
import com.webservice.dexter_service.Model.Entity.OAuthGrantType;
import com.webservice.dexter_service.Services.Implementations.OAuthGrantTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OAuthGrantTypeController {

    private static final Logger logger = LoggerFactory.getLogger(OAuthGrantTypeController.class);

    @Autowired
    private OAuthGrantTypeServiceImpl oAuthGrantTypeService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = IREQUESTS.REQUESTS.OAUTH_GRANT_TYPE.GET_ALL, method = RequestMethod.GET)
    private ResponseEntity<List<OAuthGrantType>> getAll() {
        List<OAuthGrantType> grantTypesResult = oAuthGrantTypeService.getAll();
        return new ResponseEntity<>(grantTypesResult, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = IREQUESTS.REQUESTS.OAUTH_GRANT_TYPE.GET_ONE_BY_ID, method = RequestMethod.GET)
    private ResponseEntity<OAuthGrantType> getOne(@RequestParam Integer id) {
        OAuthGrantType oAuthGrantTypeResult = oAuthGrantTypeService.getOne(id);

        if (oAuthGrantTypeResult == null) {
            return new ResponseEntity<OAuthGrantType>(oAuthGrantTypeResult, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<OAuthGrantType>(oAuthGrantTypeResult, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = IREQUESTS.REQUESTS.OAUTH_GRANT_TYPE.CREATE_OR_UPDATE, method = RequestMethod.POST)
    private ResponseEntity<OAuthGrantType> createOrUpdate(@RequestBody OAuthGrantType oAuthClient) {

        OAuthGrantType oAuthGrantTypeResult = oAuthGrantTypeService.saveOrUpdate(oAuthClient);
        if (oAuthGrantTypeResult == null) {
            return new ResponseEntity<OAuthGrantType>(oAuthGrantTypeResult, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<OAuthGrantType>(oAuthGrantTypeResult, HttpStatus.OK);
    }
}
