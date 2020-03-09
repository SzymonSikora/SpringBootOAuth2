package com.webservice.dexter_service.Controller.Test;


import java.util.*;

import com.webservice.dexter_service.Common.Enums.Enums;
import com.webservice.dexter_service.Model.DTO.AccountDTO;
import com.webservice.dexter_service.Model.Entity.*;
import com.webservice.dexter_service.Security.CustomUserDetail;
import com.webservice.dexter_service.Security.UserSession;
import com.webservice.dexter_service.Services.Interfaces.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
public class TestController {
    private final static String REQUEST_PREFIX = "/test";

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IOAuthService ioAuthService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Enums.REQUESTS.TEST.CONNECTION1, method = RequestMethod.GET, consumes = {"application/json"})
    public ResponseEntity<String> testConnection()  {
        //CustomUserDetail userSession = UserSession.getUserSession();
        //System.out.println(userSession.getPermissions().toArray()[0]);
        ArrayList<String> funnyText = new ArrayList<>();

        funnyText.add("Potato");
        funnyText.add("Banana");
        funnyText.add("Strawberry");
        funnyText.add("Habababa");
        funnyText.add("Kebab");
        funnyText.add("Strawberry");
        funnyText.add("Well done, you came to the normal text");
        funnyText.add("Egg");
        funnyText.add("Ham");
        funnyText.add("Nothing :(");

        return new ResponseEntity<String>(
                funnyText.get(new Random().nextInt(funnyText.size())),
                HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Enums.REQUESTS.TEST.CONNECTION2, method = RequestMethod.GET)
    public ResponseEntity<String> testConnection1()  {

        ArrayList<String> funnyText = new ArrayList<>();
        funnyText.add("Potato");
        funnyText.add("Banana");
        funnyText.add("Strawberry");
        funnyText.add("Habababa");
        funnyText.add("Kebab");
        funnyText.add("Strawberry");
        funnyText.add("Well done, you came to the normal text");
        funnyText.add("Egg");
        funnyText.add("Ham");
        funnyText.add("Nothing :(");

        return new ResponseEntity<String>(
                funnyText.get(new Random().nextInt(funnyText.size())),
                HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Enums.REQUESTS.TEST.CONNECTION3, method = RequestMethod.GET)
    public ResponseEntity<String> testConnection3()  {
        ArrayList<String> funnyText = new ArrayList<>();
        funnyText.add("Potato");
        funnyText.add("Banana");
        funnyText.add("Strawberry");
        funnyText.add("Habababa");
        funnyText.add("Kebab");
        funnyText.add("Strawberry");
        funnyText.add("Well done, you came to the normal text");
        funnyText.add("Egg");
        funnyText.add("Ham");
        funnyText.add("Nothing :(");

        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
        auth1.setAuthenticated(false);

        return new ResponseEntity<String>(
                funnyText.get(new Random().nextInt(funnyText.size())),
                HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Enums.REQUESTS.TEST.CONNECTION4, method = RequestMethod.GET)
    public ResponseEntity<String> testConnection4()  {
        ArrayList<String> funnyText = new ArrayList<>();
        funnyText.add("Potato");
        funnyText.add("Banana");
        funnyText.add("Strawberry");
        funnyText.add("Habababa");
        funnyText.add("Kebab");
        funnyText.add("Strawberry");
        funnyText.add("Well done, you came to the normal text");
        funnyText.add("Egg");
        funnyText.add("Ham");
        funnyText.add("Nothing :(");

        return new ResponseEntity<String>(
                funnyText.get(new Random().nextInt(funnyText.size())),
                HttpStatus.OK);
    }
}
