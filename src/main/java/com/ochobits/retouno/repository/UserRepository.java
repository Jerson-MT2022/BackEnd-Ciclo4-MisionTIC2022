package com.retoDos.repository;

import com.retoDos.model.User;
import com.retoDos.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author estdiazg
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository crudInterface;

    public Optional<User> getUser(int id) {
        return crudInterface.findById(id);
    }

    public User create(User user) {
        return crudInterface.save(user);
    }

    public void update(User user) {
        crudInterface.save(user);
    }

    public List<User> listar() {
        return crudInterface.findAll();
    }

    public boolean existeEmail(String email) {
        //Optional<User> usuario = crudInterface.findByEmail(email);

        //return !usuario.isEmpty();
        return false;
    }

    public Optional<User> autenticaUser(String email, String password) {
        return crudInterface.findEmailAndPassword(email, password);
    }
    
    public void delete(User user) {
        crudInterface.delete(user);
    }
}
