package models;

import java.util.List;

public class Department {
    String title, location, posted_by;
    List<String> description;
    List<String> qualifications;

    public Department(String title, String location, String posted, List<String> desc, List<String> qualif){
        this.title = title;
        this.location = location;
        this.description = desc;
        this.qualifications = qualif;
        this.posted_by = posted;
    }

    public void setJobDesc(List<String> desc){
        this.description = desc;
    }

    public void setQualification(List<String> qualif){
        this.qualifications = qualif;
    }

    public String getTitle(){
        return this.title;
    }

    public String getLocation(){
        return this.location;
    }

    public String getPosted_By(){
        return this.posted_by;
    }

    public List<String> getDescription(){
        return this.description;
    }

    public List<String> getQualification(){
        return this.qualifications;
    }
}
