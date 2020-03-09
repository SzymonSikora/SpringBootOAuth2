package com.webservice.dexter_service.Services.Implementations;

import com.webservice.dexter_service.Model.Entity.OAuthGrantType;
import com.webservice.dexter_service.Repository.IOAuthGrantTypeRepository;
import com.webservice.dexter_service.Services.Interfaces.IOAuthGrantTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class OAuthGrantTypeServiceImpl implements IOAuthGrantTypeService {

    private static final Logger logger = LoggerFactory.getLogger(OAuthGrantTypeServiceImpl.class);

    @Autowired
    IOAuthGrantTypeRepository ioAuthGrantTypeRepository;

    @Override
    public IOAuthGrantTypeRepository getRepository() {
        return ioAuthGrantTypeRepository;
    }

    @Override
    public OAuthGrantType saveOrUpdate(OAuthGrantType entity) {
        try {
            return ioAuthGrantTypeRepository.save(entity);
        } catch (Exception e) {
            logger.error(String.format("SaveOrUpdate OAuthGrantType failed. OAuthScope: idGrantType: %s, grantType: %s", entity.getIdGrantType(), entity.getGrantType()));
            return null;
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            ioAuthGrantTypeRepository.delete(ioAuthGrantTypeRepository.getOne(id));
        } catch (Exception e) {
            logger.error(String.format("An error occurred while deleting OAuthGrantType by id: %s", id));
            return false;
        }
        return true;
    }

    @Override
    public List<OAuthGrantType> getAll() {
        try {
            return ioAuthGrantTypeRepository.findAll();
        } catch (Exception e) {
            logger.error("An error occurred while getting all OAuthGrantType");
            return new ArrayList<OAuthGrantType>();
        }
    }

    @Override
    public OAuthGrantType getOne(Integer id) {
        try {
            return ioAuthGrantTypeRepository.getOne(id);
        } catch (Exception e) {
            logger.error(String.format("An error occurred while getting OAuthGrantType by id: %s", id));
            return null;
        }
    }
}
