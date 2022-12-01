package passport.appointments.code.model;



public class PostSchedule {
    public String id;
    public String scheduledate;
    public String scheduletime;
    public String passportid;

    public PostSchedule(String id, String scheduledate, String scheduletime, String passportid) {
        this.id = id;
        this.scheduledate = scheduledate;
        this.scheduletime = scheduletime;
        this.passportid = passportid;
}

   

}
