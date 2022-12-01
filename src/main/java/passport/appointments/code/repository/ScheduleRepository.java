package passport.appointments.code.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import passport.appointments.code.model.Passport;
import passport.appointments.code.model.Schedule;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, String> {

}