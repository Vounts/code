package passport.appointments.code.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import passport.appointments.code.model.Schedule;
import passport.appointments.code.model.User;
public interface IScheduleService {
    List<Schedule> findAll();
    Optional<Schedule> findById(String id);
    Schedule save(Schedule user);
}
