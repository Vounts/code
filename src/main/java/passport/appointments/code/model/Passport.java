package passport.appointments.code.model;
import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    private String id;
    private String lastname;
    private String firstname;
    private String middlename;
    private String placebirth;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date datebirth;
    private String email;
    private String phone;
    private String address;
    private String occupation;
    private String relationship;
    private String emergency;
    private String erelationship;
    private String ephone;
    private String ffirstname;
    private String flastname;
    private String mfirstname;
    private String mlastname;
    private String branch;
    private String passport;
    private String userid;

    public Passport() {
    }

    public Passport(String id, String lastname, String firstname, String middlename, String placebirth, java.util.Date datebirth, String email, String phone, String address, String occupation, String relationship, String emergency, String erelationship, String ephone, String ffirstname, String flastname, String mfirstname, String mlastname, String branch, String passport, String userid) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.placebirth = placebirth;
        this.datebirth = datebirth;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.occupation = occupation;
        this.relationship = relationship;
        this.emergency = emergency;
        this.erelationship = erelationship;
        this.ephone = ephone;
        this.ffirstname = ffirstname;
        this.flastname = flastname;
        this.mfirstname = mfirstname;
        this.mlastname = mlastname;
        this.branch = branch;
        this.passport = passport;
        this.userid = userid;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return this.middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPlacebirth() {
        return this.placebirth;
    }

    public void setPlacebirth(String placebirth) {
        this.placebirth = placebirth;
    }

    public java.util.Date getDatebirth() {
        return this.datebirth;
    }

    public void setDatebirth(java.util.Date datebirth) {
        this.datebirth = datebirth;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getRelationship() {
        return this.relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getEmergency() {
        return this.emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public String getErelationship() {
        return this.erelationship;
    }

    public void setErelationship(String erelationship) {
        this.erelationship = erelationship;
    }

    public String getEphone() {
        return this.ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public String getFfirstname() {
        return this.ffirstname;
    }

    public void setFfirstname(String ffirstname) {
        this.ffirstname = ffirstname;
    }

    public String getFlastname() {
        return this.flastname;
    }

    public void setFlastname(String flastname) {
        this.flastname = flastname;
    }

    public String getMfirstname() {
        return this.mfirstname;
    }

    public void setMfirstname(String mfirstname) {
        this.mfirstname = mfirstname;
    }

    public String getMlastname() {
        return this.mlastname;
    }

    public void setMlastname(String mlastname) {
        this.mlastname = mlastname;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPassport() {
        return this.passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Passport id(String id) {
        setId(id);
        return this;
    }

    public Passport lastname(String lastname) {
        setLastname(lastname);
        return this;
    }

    public Passport firstname(String firstname) {
        setFirstname(firstname);
        return this;
    }

    public Passport middlename(String middlename) {
        setMiddlename(middlename);
        return this;
    }

    public Passport placebirth(String placebirth) {
        setPlacebirth(placebirth);
        return this;
    }

    public Passport datebirth(java.util.Date datebirth) {
        setDatebirth(datebirth);
        return this;
    }

    public Passport email(String email) {
        setEmail(email);
        return this;
    }

    public Passport phone(String phone) {
        setPhone(phone);
        return this;
    }

    public Passport address(String address) {
        setAddress(address);
        return this;
    }

    public Passport occupation(String occupation) {
        setOccupation(occupation);
        return this;
    }

    public Passport relationship(String relationship) {
        setRelationship(relationship);
        return this;
    }

    public Passport emergency(String emergency) {
        setEmergency(emergency);
        return this;
    }

    public Passport erelationship(String erelationship) {
        setErelationship(erelationship);
        return this;
    }

    public Passport ephone(String ephone) {
        setEphone(ephone);
        return this;
    }

    public Passport ffirstname(String ffirstname) {
        setFfirstname(ffirstname);
        return this;
    }

    public Passport flastname(String flastname) {
        setFlastname(flastname);
        return this;
    }

    public Passport mfirstname(String mfirstname) {
        setMfirstname(mfirstname);
        return this;
    }

    public Passport mlastname(String mlastname) {
        setMlastname(mlastname);
        return this;
    }

    public Passport branch(String branch) {
        setBranch(branch);
        return this;
    }

    public Passport passport(String passport) {
        setPassport(passport);
        return this;
    }

    public Passport userid(String userid) {
        setUserid(userid);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Passport)) {
            return false;
        }
        Passport passport = (Passport) o;
        return Objects.equals(id, passport.id) && Objects.equals(lastname, passport.lastname) && Objects.equals(firstname, passport.firstname) && Objects.equals(middlename, passport.middlename) && Objects.equals(placebirth, passport.placebirth) && Objects.equals(datebirth, passport.datebirth) && Objects.equals(email, passport.email) && Objects.equals(phone, passport.phone) && Objects.equals(address, passport.address) && Objects.equals(occupation, passport.occupation) && Objects.equals(relationship, passport.relationship) && Objects.equals(emergency, passport.emergency) && Objects.equals(erelationship, passport.erelationship) && Objects.equals(ephone, passport.ephone) && Objects.equals(ffirstname, passport.ffirstname) && Objects.equals(flastname, passport.flastname) && Objects.equals(mfirstname, passport.mfirstname) && Objects.equals(mlastname, passport.mlastname) && Objects.equals(branch, passport.branch) && Objects.equals(passport, passport.passport) && Objects.equals(userid, passport.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, middlename, placebirth, datebirth, email, phone, address, occupation, relationship, emergency, erelationship, ephone, ffirstname, flastname, mfirstname, mlastname, branch, passport, userid);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", firstname='" + getFirstname() + "'" +
            ", middlename='" + getMiddlename() + "'" +
            ", placebirth='" + getPlacebirth() + "'" +
            ", datebirth='" + getDatebirth() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone='" + getPhone() + "'" +
            ", address='" + getAddress() + "'" +
            ", occupation='" + getOccupation() + "'" +
            ", relationship='" + getRelationship() + "'" +
            ", emergency='" + getEmergency() + "'" +
            ", erelationship='" + getErelationship() + "'" +
            ", ephone='" + getEphone() + "'" +
            ", ffirstname='" + getFfirstname() + "'" +
            ", flastname='" + getFlastname() + "'" +
            ", mfirstname='" + getMfirstname() + "'" +
            ", mlastname='" + getMlastname() + "'" +
            ", branch='" + getBranch() + "'" +
            ", passport='" + getPassport() + "'" +
            ", userid='" + getUserid() + "'" +
            "}";
    }

   
    
  

   
}
