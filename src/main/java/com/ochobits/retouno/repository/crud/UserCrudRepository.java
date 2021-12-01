package com.retoDos.repository.crud;

import com.retoDos.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author estdiag
 */
public interface UserCrudRepository extends MongoRepository<User, Integer>{
    
    //Optional<User> findByEmail(String email);
    Optional<User> findEmailAndPassword(String email, String password); 
    
    User findByEmail(String email);
    //User findEmailAndPassword(String email, String password);    
}

