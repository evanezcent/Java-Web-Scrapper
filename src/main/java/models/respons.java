package models;

public class respons {
    String departmentType, urlJob;

    public respons(String department, String url){
        this.departmentType = department;
        this.urlJob = url;
    }


    public String getDepartment() {
        return departmentType;
    }

    public String getUrl() {
        return urlJob;
    }
}
