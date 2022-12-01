package passport.appointments.code.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import passport.appointments.code.model.Passport;
import passport.appointments.code.model.Schedule;
import passport.appointments.code.model.User;
import passport.appointments.code.repository.PassportRepository;
import passport.appointments.code.repository.UserRepository;
import utils.Encryption;
import utils.JwtBuilder;




@Service
public class UserService implements IUserService {
    
    @Autowired
    private UserRepository repository;


    @Autowired
    private PassportService passportService;

    @Autowired
    private ScheduleService scheduleService;

    @Override
    public List<User> findAll() {
        var users = (List<User>) repository.findAll();
        System.out.print("USER[]: " + users.toString());
        return users;
    }
    

    @Override
    public Optional<User> findById(String id) {
        var user = (Optional<User>) repository.findById(id);
        return user;
    }
    
    @Override
    public User save(User user) {
        var saveUser = (User) repository.save(user);
        return saveUser;
    }
    
    public Boolean isUserExisting(String username) {
        var users = (List<User>) repository.findAll();
        Boolean userFound = false;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                userFound = true;
            } 
        }
        return userFound;
    }


    public User findUser(String username) {
        var users = (List<User>) repository.findAll();
        
        for (User user : users) {
            System.out.print("USER" + user);
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    public Boolean validatePassword(User user, String password) {
        try {
            Encryption crypt = new Encryption();
            String salt = user.getSalt();

            String hash = crypt.convertStringToHash(password, salt);

            if (hash.equals(user.getPassword())) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    

    public Boolean isLoggedIn(HttpServletRequest request) {
        try {
            JwtBuilder jwt = new JwtBuilder();
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {

                for (Cookie c : cookies) {
                    if (c.getName().equals("passport_session")) {
                        Jws<Claims> raw = ((JwtBuilder) jwt).parseJwt(c.getValue());
                        if (raw != null) {
                            String username = raw.getBody().get("username").toString();
                            if (username != null) {
                                return true;
                            }
                        }
                    }
                }
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    

    public String getSessionUsername(HttpServletRequest request) {
        try {
            JwtBuilder jwt = new JwtBuilder();
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {

                for (Cookie c : cookies) {
                    if (c.getName().equals("passport_session")) {
                        Jws<Claims> raw = ((JwtBuilder) jwt).parseJwt(c.getValue());
                        if (raw != null) {
                            String username = raw.getBody().get("username").toString();
                            if (username != null) {
                                return username;
                            }
                        }
                    }
                }
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getSessionId(HttpServletRequest request) {
        try {
            JwtBuilder jwt = new JwtBuilder();
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {

                for (Cookie c : cookies) {
                    if (c.getName().equals("passport_session")) {
                        Jws<Claims> raw = ((JwtBuilder) jwt).parseJwt(c.getValue());
                        if (raw != null) {
                            String userId = raw.getBody().get("userId").toString();
                            System.out.print("USERID: "+ userId);
                            if (userId != null) {
                                return userId;
                            }
                        }
                    }
                }
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    public Boolean clearSession(HttpServletResponse response) {
        try {
            Cookie cookie = new Cookie("passport_session", null);
            cookie.setMaxAge(0);
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            response.addCookie(cookie);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public Passport getPassportByUserId(String userId) {
        try {
            List<Passport> passports = passportService.findAll();
            for (Passport passport : passports) {
                if (passport.getUserid().equals(userId)) {
                    return passport;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Schedule getScheduleByUserId(String userId) {
        try {
            List<Schedule> schedules = scheduleService.findAll();

            Passport passport = getPassportByUserId(userId);
            if (passport != null) {
                for (Schedule schedule : schedules) {
                    if (schedule.getPassportid().equals(passport.getId())) {
                        return schedule;
                    }
                }
            }
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
