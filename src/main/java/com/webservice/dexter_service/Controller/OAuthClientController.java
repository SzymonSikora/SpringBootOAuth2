package com.webservice.dexter_service.Controller;

import com.webservice.dexter_service.Common.Enums.Enums;
import com.webservice.dexter_service.Common.Enums.IENUMS;
import com.webservice.dexter_service.Common.Enums.IREQUESTS;
import com.webservice.dexter_service.Common.Utils.Permission;
import com.webservice.dexter_service.Model.Entity.OAuthClient;
import com.webservice.dexter_service.Security.CustomUserDetail;
import com.webservice.dexter_service.Security.UserSession;
import com.webservice.dexter_service.Services.Implementations.OAuthServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OAuthClientController {

    private static final Logger logger = LoggerFactory.getLogger(OAuthClientController.class);

    @Autowired
    private OAuthServiceImpl oAuthService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = IREQUESTS.REQUESTS.OAUTH_CLIENT.GET_ALL, method = RequestMethod.GET)
    private ResponseEntity<List<OAuthClient>> getAll() {
        Permission.hasPermission(Enums.PERMISSION.ROLE);
        List<OAuthClient> langs = oAuthService.getAll();
        return new ResponseEntity<List<OAuthClient>>(langs, HttpStatus.OK);
}

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = IREQUESTS.REQUESTS.OAUTH_CLIENT.GET_ONE_BY_CLIENT_ID, method = RequestMethod.GET)
    private ResponseEntity<OAuthClient> getOne(@RequestParam String cliendId) {
        OAuthClient oAuthResult = oAuthService.getOneByClientId(cliendId);

        if (oAuthResult == null) {
            return new ResponseEntity<OAuthClient>(oAuthResult, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<OAuthClient>(oAuthResult, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = IREQUESTS.REQUESTS.OAUTH_CLIENT.CREATE_OR_UPDATE, method = RequestMethod.POST)
    private ResponseEntity<OAuthClient> createOrUpdate(@RequestBody OAuthClient oAuthClient) {

        OAuthClient oAuthClientResult = oAuthService.saveOrUpdate(oAuthClient);
        if (oAuthClientResult == null) {
            return new ResponseEntity<OAuthClient>(oAuthClientResult, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<OAuthClient>(oAuthClientResult, HttpStatus.OK);
    }
}
