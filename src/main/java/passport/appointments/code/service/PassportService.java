package passport.appointments.code.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import passport.appointments.code.model.Passport;

import passport.appointments.code.repository.PassportRepository;
import passport.appointments.code.repository.UserRepository;


@Service
public class PassportService implements IPassportService {
    
    @Autowired
    private PassportRepository repository;

    @Override
    public List<Passport> findAll() {
        var passports = (List<Passport>) repository.findAll();
        return passports;
    }
    

    @Override
    public Optional<Passport> findById(String id) {
        var passport = (Optional<Passport>) repository.findById(id);
        return passport;
    }
    
    @Override
    public Passport save(Passport passport) {
        var savePassport = (Passport) repository.save(passport);
        return savePassport;
    }


    public Timestamp stringToDate(String date) {
        try {
    Date finalDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
     Timestamp timestamp = new java.sql.Timestamp(finalDate.getTime());
    return timestamp;
} catch (Exception e) {
    e.printStackTrace();
    return null;
}
    }

  
    
   
}
