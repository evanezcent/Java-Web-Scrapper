package cermati;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import controller.jsoupController;
import models.respons;

public class App {
    public static void main(String[] args) throws Exception {
        List<respons> res = new ArrayList<respons>();
        jsoupController jsoupC = new jsoupController("https://cermati.com/karir", "div.tab-pane");
        Elements divElm = jsoupC.getElementFromClass();
        for (Element tab : divElm) {
            String department = tab.select("h4").text();
            Elements elm = tab.select("div.clickable-row");

            for (Element link : elm) {
                String url = link.select("a").attr("href");
                respons tempRes = new respons(department, url);
    
                res.add(tempRes);
            }
            System.out.println();
        }
        
        // ObjectMapper 
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).getUrl());
            // System.out.println(res.get(i).getUrl());
            // System.out.println();

            Document doc = Jsoup.connect(res.get(i).getUrl()).get();
            Elements pageElm = doc.select("h1");
            System.out.println(pageElm.text());
            System.out.println();
        }
    }
}
