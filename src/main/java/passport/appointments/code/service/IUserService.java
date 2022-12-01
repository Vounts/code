package passport.appointments.code.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



import passport.appointments.code.model.User;
public interface IUserService {
    List<User> findAll();
    Optional<User> findById(String id);
    User save(User user);
}
