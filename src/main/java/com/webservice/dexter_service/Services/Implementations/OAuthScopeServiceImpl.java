package com.webservice.dexter_service.Services.Implementations;

import com.webservice.dexter_service.Model.Entity.OAuthScope;
import com.webservice.dexter_service.Repository.IOAuthScopeRepository;
import com.webservice.dexter_service.Services.Interfaces.IOAuthScopeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class OAuthScopeServiceImpl implements IOAuthScopeService {

    private static final Logger logger = LoggerFactory.getLogger(OAuthScopeServiceImpl.class);

    @Autowired
    private IOAuthScopeRepository ioAuthScopeRepository;

    @Override
    public IOAuthScopeRepository getRepository() {
        return ioAuthScopeRepository;
    }

    @Override
    public OAuthScope saveOrUpdate(OAuthScope entity) {
        try {
            return ioAuthScopeRepository.save(entity);
        } catch (Exception e) {
            logger.error(String.format("SaveOrUpdate OAuthScope failed. OAuthScope: idScope: %s, scope: %s", entity.getIdScope(), entity.getScope()));
            return null;
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            ioAuthScopeRepository.delete(ioAuthScopeRepository.getOne(id));
        } catch (Exception e) {
            logger.error(String.format("An error occurred while deleting OAuthScope by id: %s", id));
            return false;
        }
        return true;
    }

    @Override
    public List<OAuthScope> getAll() {
        try {
            return ioAuthScopeRepository.findAll();
        } catch (Exception e) {
            logger.error("An error occurred while getting all OAuthScopes");
            return new ArrayList<OAuthScope>();
        }
    }

    @Override
    public OAuthScope getOne(Integer id) {
        try {
            return ioAuthScopeRepository.getOne(id);
        } catch (Exception e) {
            logger.error(String.format("An error occurred while getting OAuthScopes by id: %s", id));
            return null;
        }
    }
}
