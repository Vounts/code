
package passport.appointments.code;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cool.graph.cuid.Cuid;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import passport.appointments.code.model.Mail;
import passport.appointments.code.model.Passport;
import passport.appointments.code.model.PostPassport;
import passport.appointments.code.model.PostSchedule;
import passport.appointments.code.model.PostUser;
import passport.appointments.code.model.Schedule;
import passport.appointments.code.model.User;

import passport.appointments.code.service.MailService;
import passport.appointments.code.service.PassportService;
import passport.appointments.code.service.ScheduleService;
import passport.appointments.code.service.UserService;
import utils.Encryption;
import utils.JwtBuilder;


@Controller
public class MainController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private PassportService passportService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
	private MailService mailService;


    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        if (userService.isLoggedIn(request)) {
            return "redirect:/";
        }
        else {
            return "login";
        }
    }

     @GetMapping("/confirm")
     public String confirm(HttpServletRequest request) {
        if (!userService.isLoggedIn(request)) {
            return "redirect:/login";
        }
         return "confirm";
     }
    
    @GetMapping("/schedule")
    public String schedule(HttpServletRequest request, RedirectAttributes redirAttrs) {
        if (!userService.isLoggedIn(request)) {
            return "redirect:/login";
        }
        else if (userService.getScheduleByUserId(userService.getSessionUsername(request)) == null) {
            return "schedule";
        }
        else {
            redirAttrs.addFlashAttribute("response", "Schedule is existing in our system");
           return "redirect:/confirm";
        }
    
    }

     @GetMapping("/")
     public String index(HttpServletRequest request, Model model, RedirectAttributes redirAttrs) {
         if (!userService.isLoggedIn(request)) {
             return "redirect:/login";
         }

         model.addAttribute("username", userService.getSessionUsername(request));
         return "index";
     }
     
      @GetMapping("/logout")
     public String logout(HttpServletRequest request,  HttpServletResponse response) {
         if (!userService.isLoggedIn(request)) {
             return "redirect:/login";
         }
        
        userService.clearSession(response);
        return "redirect:/login";
     }

      @GetMapping("/renew")
      public String renew(HttpServletRequest request, RedirectAttributes redirAttrs) {
          if (!userService.isLoggedIn(request)) {
              return "redirect:/login";
          }
          else if (userService.getPassportByUserId(userService.getSessionId(request)) == null) {
              return "renew";
          }
          else {
            redirAttrs.addFlashAttribute("response", "An existing personal details found in our system");
            return "redirect:/schedule";
          }
          
      }
    
    @GetMapping("/apply")
    public String apply(HttpServletRequest request, RedirectAttributes redirAttrs) {
        if (!userService.isLoggedIn(request)) {
            return "redirect:/login";
        }
          else if (userService.getPassportByUserId(userService.getSessionId(request)) == null) {
              return "apply";
          }
          else {
            redirAttrs.addFlashAttribute("response", "An existing personal details found in our system");
            return "redirect:/schedule";
          }
      
    }

    @GetMapping("/register")
    public String register(HttpServletRequest request) {
         if (userService.isLoggedIn(request)) {
            return "redirect:/";
        }
        else {
           return "register";
        }
        
    }

    @GetMapping("/showUsers")
    public String findUsers(Model model) {
        var users = (List<User>) userService.findAll();
        model.addAttribute("users", users);
        return "showUsers";
    }

   
    
    @PostMapping("/registerUser") 
    String createUser(@ModelAttribute("data") PostUser data, RedirectAttributes redirAttrs) {
        try {

            if (data.password.length() < 8) {
                redirAttrs.addFlashAttribute("error", "Password must be greater than 8");
                return "redirect:/register";
            }

            if (userService.isUserExisting(data.username)) {
                redirAttrs.addFlashAttribute("error", "Username is existing in our system");
                return "redirect:/register";
            }
            
            Encryption crypt = new Encryption();
            String salt = crypt.generateSalt(53);
            String cuid = Cuid.createCuid();
            System.out.print("cuid:" + cuid);
            User newUser = new User(cuid, data.username, crypt.convertStringToHash(data.password, salt), salt);
            System.out.print("NEWUSER: " + newUser);
            var user = (User) userService.save(newUser);
            System.out.print("USER SAVE:" + user);
            if (user != null) {
                System.out.println("user: " + user.getUsername() + "pass: " + user.getPassword());
                redirAttrs.addFlashAttribute("response", "Successfully registered please login");
                return "redirect:/login";
            } else {
                redirAttrs.addFlashAttribute("error", "Failed to register user");
                return "redirect:/login";
            }
    
        } catch (Exception e) {
            e.printStackTrace();
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("error", e.toString());
            return "redirect:/error";
        }
    }

    
     @PostMapping("/loginUser") 
     String loginUser(@ModelAttribute("data") PostUser data, RedirectAttributes redirAttrs,
             HttpServletResponse response) {
         JwtBuilder jwt = new JwtBuilder();
         try {
             var user = (User) userService.findUser(data.username);
             System.out.print(user);
             if (user != null && userService.validatePassword(user, data.password)) {

                 System.out.print(" user.getId(): " + user.getId());
                 //generate our JWT
                 String token = jwt.generateToken(user.getUsername(), user.getId());

                 if (token != null) {
                     Cookie cookie = new Cookie("passport_session", token);
                     response.addCookie(cookie);
                     return "redirect:/";
                 }
                 throw new Exception("Failed to login: error generating token");

             }
             redirAttrs.addFlashAttribute("error", "Invalid password or no user found in our system");
             return "redirect:/login";
         } catch (Exception e) {
             redirAttrs.addFlashAttribute("error", e.toString());
             return "redirect:/error";
         }
     }
    

     @PostMapping("/createPassport") 
     String createPassport(@ModelAttribute("data") PostPassport data, RedirectAttributes redirAttrs,
             HttpServletResponse response, HttpServletRequest request) {
         try {
             System.out.println("CALLED");
             /* 
              if (Stream.of(data).allMatch(Objects::isNull)) {
                  redirAttrs.addFlashAttribute("error", "Null value is present");
                  return "redirect:/error";
              }
              */

             Passport passport = new Passport(Cuid.createCuid(), data.lastName, data.firstName, data.middleName,
                     data.placebirth, passportService.stringToDate(data.datebirth), data.email, data.phone,
                     data.addressone + " " + data.addresstwo, data.occupation, data.relationship, data.emergency,
                     data.erelationship, data.ephone, data.ffirstName, data.flastName, data.mfirstName, data.mlastName,
                     null, null, userService.getSessionId(request));

             System.out.println("PASSPORT: " + passport);
             passportService.save(passport);

             return "redirect:/schedule";
         } catch (Exception e) {
             redirAttrs.addFlashAttribute("error", e.toString());
             return "redirect:/error";
         }
     }
  

     @PostMapping("/createSchedule") 
     String createSchedule(@ModelAttribute("data") PostSchedule data, RedirectAttributes redirAttrs,
             HttpServletResponse response, HttpServletRequest request) {
         try {
             System.out.println("CALLED SCHEDULE" + data.scheduledate + " " + data.scheduletime);
             /* 
              if (Stream.of(data).allMatch(Objects::isNull)) {
                  redirAttrs.addFlashAttribute("error", "Null value is present");
                  return "redirect:/error";
              }
              */

             Schedule schedule = new Schedule(Cuid.createCuid(), scheduleService.stringToDate(data.scheduledate),
                     data.scheduletime, userService.getPassportByUserId(userService.getSessionId(request)).getId());
             System.out.println("schedule: " + schedule);
             scheduleService.save(schedule);

             //sendEmail here
             String message = "Appointment confirmed by PassMe";
             String subject = "PassMe: Appointment Confirmed";
             String email = userService.getPassportByUserId(userService.getSessionId(request)).getEmail();
             Mail mail = new Mail();
             mail.setMailFrom("icheckit.v2@gmail.com");
             mail.setMailTo(email);
             mail.setMailSubject(subject);
             mail.setMailContent(message); //CHANGE BODY HERE
             String success = mailService.sendEmail(mail);

             System.out.print(success);
             return "redirect:/confirm";
         } catch (Exception e) {
             redirAttrs.addFlashAttribute("error", e.toString());
             return "redirect:/error";
         }
     }
    
     //JUST TEST
     @PostMapping("/sendMail") 
     String sendMail(@ModelAttribute("data") PostPassport data, RedirectAttributes redirAttrs, HttpServletResponse response, HttpServletRequest request) {
         try {
             
            //sendEmail here
             String message = "Appointment confirmed by PassMe";
             String subject = "PassMe: Appointment Confirmed";
             String email = userService.getPassportByUserId(userService.getSessionId(request)).getEmail();
             Mail mail = new Mail();
             mail.setMailFrom("icheckit.v2@gmail.com");
             mail.setMailTo(email);
             mail.setMailSubject(subject);
             mail.setMailContent(message); //CHANGE BODY HERE
		     String success = mailService.sendEmail(mail);

             System.out.print(success);
            return "redirect:/confirm";
    } catch (Exception e) {
        redirAttrs.addFlashAttribute("error", e.toString());
        return "redirect:/error";
    }
    }
}
