package service;

import dto.CASUser;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.springframework.stereotype.Service;

/**
 * Created by User on 20.08.2016.
 */
@Service
public class CASUserServiceImpl implements CASUserService {

    @Override
    public CASUser getByCredential(UsernamePasswordCredential credential) {
        String usernameMock = "test";
        String passwordMock = "test";
        CASUser user = null;
        if(credential.getUsername().equals(usernameMock) && credential.getPassword().equals(passwordMock)) {
            user = new CASUser(usernameMock, passwordMock);
        }

        return user;
    }

}