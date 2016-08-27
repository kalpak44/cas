package handler;

import dto.CASUser;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import service.CASUserService;
import service.CASUserServiceImpl;

import javax.security.auth.login.AccountNotFoundException;
import java.security.GeneralSecurityException;

/**
 * Created by User on 20.08.2016.
 */
public class ServerUsernamePasswordAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

    private CASUserService casUserService;

    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential)
            throws GeneralSecurityException, PreventedException {

        casUserService = new CASUserServiceImpl();

        CASUser user = casUserService.getByCredential(credential);
        if(credential.getUsername().equals(user.getUsername()) && credential.getPassword().equals(user.getPassword())) {
            user = new CASUser(user.getUsername(), user.getPassword());
        }

        if (user == null) {
            throw new AccountNotFoundException(user.getUsername() + " not found.");
        }

        return createHandlerResult(credential, new SimplePrincipal(user.getUsername()), null);
    }
}