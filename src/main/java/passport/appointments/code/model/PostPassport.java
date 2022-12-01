package passport.appointments.code.model;

import java.util.UUID;

public class PostPassport {
    public String lastName;
    public String firstName;
    public String middleName;
    public String placebirth;
    public String datebirth;
    public String email;
    public String phone;
    public String addressone;
    public String addresstwo;
    public String occupation;
    public String relationship;
    public String emergency;
    public String erelationship;
    public String ephone;
    public String ffirstName;
    public String flastName;
    public String mfirstName;
    public String mlastName;
    public String branch;
    public String passport;
    public UUID userId;
    public String scheduleDate;
    public String scheduleTime;
    public UUID passportId;

    public PostPassport(String lastName, String firstName, String middleName, String placebirth, String datebirth, String email, String phone, String addressone, String addresstwo, String occupation, String relationship, String emergency, String erelationship, String ephone, String ffirstName, String flastName, String mfirstName, String mlastName, String branch, String passport, UUID userId, String scheduleDate, String scheduleTime, UUID passportId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.placebirth = placebirth;
        this.datebirth = datebirth;
        this.email = email;
        this.phone = phone;
        this.addressone = addressone;
        this.addresstwo = addresstwo;
        this.occupation = occupation;
        this.relationship = relationship;
        this.emergency = emergency;
        this.erelationship = erelationship;
        this.ephone = ephone;
        this.ffirstName = ffirstName;
        this.flastName = flastName;
        this.mfirstName = mfirstName;
        this.mlastName = mlastName;
        this.branch = branch;
        this.passport = passport;
        this.userId = userId;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
        this.passportId = passportId;
    }

   

  
}
