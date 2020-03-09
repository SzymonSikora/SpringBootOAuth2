package com.webservice.dexter_service.Services.Implementations;

import com.webservice.dexter_service.Model.Entity.OAuthClient;
import com.webservice.dexter_service.Repository.IOAuthRepository;
import com.webservice.dexter_service.Services.Interfaces.IOAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OAuthServiceImpl implements IOAuthService {

    private static final Logger logger = LoggerFactory.getLogger(OAuthServiceImpl.class);

    @Autowired
    private IOAuthRepository ioAuthRepository;

    @Override
    public IOAuthRepository getRepository() {
        return ioAuthRepository;
    }

    @Override
    public OAuthClient saveOrUpdate(OAuthClient entity) {
        try {
            return ioAuthRepository.save(entity);
        } catch (Exception e) {
            logger.error(String.format("SaveOrUpdate OAuthClient failed. lang: idClient: %s", entity.getIdClient()));
            return null;
        }
    }

    @Override
    public Boolean delete(String id) {
        try {
            OAuthClient client = ioAuthRepository.getOne(id);
            if(client != null){
                ioAuthRepository.delete(client);
            }
        } catch (Exception e) {
            logger.error("An error occurred while deleting the OAuthClient");
            return false;
        }
        return true;
    }

    @Override
    public List<OAuthClient> getAll() {
        try {
            return ioAuthRepository.findAll();
        } catch (Exception e) {
            logger.error("An error occurred while getting all OAuthClients");
            return new ArrayList<OAuthClient>();
        }
    }

    @Override
    public OAuthClient getOneByClientId(String clientId) {
        try {
            return ioAuthRepository.getOneByClientId(clientId);
        } catch (Exception e) {
            logger.error(String.format("An error occurred while getting OAuthClient by clientId: %s", clientId));
            return null;
        }
    }
}
