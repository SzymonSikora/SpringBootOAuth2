package com.webservice.dexter_service.Controller;

import com.webservice.dexter_service.Common.Enums.Enums;
import com.webservice.dexter_service.Model.Entity.Role;
import com.webservice.dexter_service.Repository.IRoleRepository;
import com.webservice.dexter_service.Services.Implementations.RoleServiceImpl;
import com.webservice.dexter_service.Services.Interfaces.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleServiceImpl roleService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Enums.REQUESTS.ROLE.GET_ALL, method = RequestMethod.GET)
    private ResponseEntity<List<Role>> getAll() {
        List<Role> roles = roleService.getAll();
        return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Enums.REQUESTS.ROLE.GET_ONE_BY_ID, method = RequestMethod.GET)
    private ResponseEntity<Role> getOne(@RequestParam Integer id) {
        Role roleResult = roleService.getOne(id);

        if (roleResult == null) {
            return new ResponseEntity<Role>(roleResult, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Role>(roleResult, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Enums.REQUESTS.ROLE.CREATE_OR_UPDATE, method = RequestMethod.POST)
    private ResponseEntity<Role> createOrUpdate(@RequestBody Role role) {

        Role roleResult = roleService.saveOrUpdate(role);
        if (roleResult == null) {
            return new ResponseEntity<Role>(roleResult, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Role>(roleResult, HttpStatus.OK);
    }
}
