package service;

import dto.CASUser;
import org.jasig.cas.authentication.UsernamePasswordCredential;

/**
 * Created by User on 20.08.2016.
 */
public interface CASUserService {
    CASUser getByCredential(UsernamePasswordCredential credential);
}