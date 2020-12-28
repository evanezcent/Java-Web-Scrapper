package cermati;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import controller.jsoupController;
import models.Department;
import models.Solution;

public class solution {
    public static void main(String[] args) throws Exception {

        System.out.println("Please Wait . . .");
        System.out.println();
        Map<String, Object> toJson = new HashMap<String, Object>();
        List<Solution> solutions = new ArrayList<Solution>();

        Document document = Jsoup.connect("https://cermati.com/karir").get();
        Elements divElm = document.select("div.tab-pane");

        // Loop for each teams
        for (Element tab : divElm) {
            String teams = tab.select("h4").text();
            Elements elm = tab.select("div.clickable-row");

            // Loop for each job positions and get the link
            List<Department> departments = new ArrayList<Department>();
            for (Element link : elm) {
                String url = link.select("a").attr("href");
                Document doc = Jsoup.connect(url).get();
                Elements jobTitle = doc.select("h1.job-title");
                Elements location = doc.select("span[itemprop=address]");
                Elements author = doc.select("h3.details-title");
                Elements jobDescription = doc.select("section#st-jobDescription");
                Elements jobQualification = doc.select("section#st-qualifications");
                
                // Call controller that doing job for looping the "li"
                jsoupController controller = new jsoupController();
                List<String> jobDesc = controller.getArrayResult(jobDescription, "li");
                List<String> jobQualify = controller.getArrayResult(jobQualification, "li");

                Department department = new Department(
                    jobTitle.text(), 
                    location.text(), 
                    author.text(), 
                    jobDesc, 
                    jobQualify);
                departments.add(department);
            }
            // Add department into list
            // Solution solution = new Solution();
            // solution.setDepartments(teams, departments);
            // solutions.add(solution);
            toJson.put(teams, departments);

            System.out.println("On progress : "+teams);
        }

        //Convert to json
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(Paths.get("solution.json").toFile(), toJson);
    }
}
