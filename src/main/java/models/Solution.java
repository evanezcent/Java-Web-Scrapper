package models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Solution {
    Map<String, Object> details = new LinkedHashMap<>();

    @JsonAnySetter
    public void setDepartments(String key, List<Department> departments){
        this.details.put(key, departments);
    }

    public Map<String, Object> getData() {
        return this.details;
    }
}
