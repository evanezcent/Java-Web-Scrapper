package cermati;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import controller.jsoupController;
import models.Department;
import models.respons;

public class App {
    public static void main(String[] args) throws Exception {
        List<respons> res = new ArrayList<respons>();
        Document document = Jsoup.connect("https://cermati.com/karir").get();
        Elements divElm = document.select("div.tab-pane");

        // Loop for each teams
        for (Element tab : divElm) {
            String department = tab.select("h4").text();
            Elements elm = tab.select("div.clickable-row");

            // Loop for each job positions
            for (Element link : elm) {
                String url = link.select("a").attr("href");
                respons tempRes = new respons(department, url);
    
                res.add(tempRes);
            }
            System.out.println();
        }
        
        List<Department> departments = new ArrayList<Department>();
        // Loop for each job details
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).getUrl());

            Document doc = Jsoup.connect(res.get(i).getUrl()).get();
            Elements jobTitle = doc.select("h1.job-title");
            Elements location = doc.select("span[itemprop=address]");
            Elements author = doc.select("h3.details-title");
            Elements jobDescription = doc.select("section#st-jobDescription");
            Elements jobQualification = doc.select("section#st-qualifications");
            
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
            System.out.println(jobTitle.text());
            System.out.println(location.text());
            System.out.println(author.text());
            System.out.println(jobDesc.get(1));
            System.out.println(jobQualify.get(1));


            System.out.println();
        }
    }
}
