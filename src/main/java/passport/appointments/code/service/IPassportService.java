package passport.appointments.code.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



import passport.appointments.code.model.Passport;
public interface IPassportService {
    List<Passport> findAll();
    Optional<Passport> findById(String id);
    Passport save(Passport user);
}
