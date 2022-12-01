package passport.appointments.code.model;

import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.*;

@Entity
@Table(name = "schedule")   
public class Schedule {
    @Id
    private String id;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date scheduledate;
    private String scheduletime;
    private String passportid;

    public Schedule() {
    }

    public Schedule(String id, java.util.Date scheduledate, String scheduletime, String passportid) {
        this.id = id;
        this.scheduledate = scheduledate;
        this.scheduletime = scheduletime;
        this.passportid = passportid;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.util.Date getScheduledate() {
        return this.scheduledate;
    }

    public void setScheduledate(java.util.Date scheduledate) {
        this.scheduledate = scheduledate;
    }

    public String getScheduletime() {
        return this.scheduletime;
    }

    public void setScheduletime(String scheduletime) {
        this.scheduletime = scheduletime;
    }

    public String getPassportid() {
        return this.passportid;
    }

    public void setPassportid(String passportid) {
        this.passportid = passportid;
    }

    public Schedule id(String id) {
        setId(id);
        return this;
    }

    public Schedule scheduledate(java.util.Date scheduledate) {
        setScheduledate(scheduledate);
        return this;
    }

    public Schedule scheduletime(String scheduletime) {
        setScheduletime(scheduletime);
        return this;
    }

    public Schedule passportid(String passportid) {
        setPassportid(passportid);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Schedule)) {
            return false;
        }
        Schedule schedule = (Schedule) o;
        return Objects.equals(id, schedule.id) && Objects.equals(scheduledate, schedule.scheduledate) && Objects.equals(scheduletime, schedule.scheduletime) && Objects.equals(passportid, schedule.passportid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scheduledate, scheduletime, passportid);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", scheduledate='" + getScheduledate() + "'" +
            ", scheduletime='" + getScheduletime() + "'" +
            ", passportid='" + getPassportid() + "'" +
            "}";
    }

   
 

   


}
