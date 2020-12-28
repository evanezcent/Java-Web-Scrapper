package models;

import java.util.List;

public class Department {
    String title, location, posted_by;
    List<String> description;
    List<String> qualifications;

    public Department(String title, String location, String posted, List<String> desc, List<String> qualif){
        this.title = title;
        this.location = location;
        this.posted_by = posted;
        this.description = desc;
        this.qualifications = qualif;
    }

    public void setJobDesc(List<String> desc){
        this.description = desc;
    }

    public void setQualification(List<String> qualif){
        this.qualifications = qualif;
    }
}
