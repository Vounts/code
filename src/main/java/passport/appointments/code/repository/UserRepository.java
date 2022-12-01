package passport.appointments.code.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import passport.appointments.code.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}