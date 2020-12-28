package models;

import java.util.List;

public class Solution {
    String departmentType;
    List<Department> departments;

    public Solution(String department, List<Department> departments){
        this.departmentType = department;
        this.departments = departments;
    }

    public void setDepartments(List<Department> departments){
        this.departments = departments;
    }

    public String getDepartment() {
        return departmentType;
    }

    public List<Department> getPositionEachDepartment() {
        return departments;
    }

}
