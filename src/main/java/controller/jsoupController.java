package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoupController {
    String url, htmlElm;

    public jsoupController(String url, String element) {
        this.url = url;
        this.htmlElm = element;
    }

    public Elements getElementFromClass() throws IOException {
        Document doc = Jsoup.connect(this.url).get();
        Elements elements = doc.select(this.htmlElm);
        return elements;
    }

    List<String> getArrayResult(Elements elements, String target){
        List<String> result = new ArrayList<String>();
        for (Element elm : elements) {
            result.add(elm.select(target).text());
        }

        return result;
    }
}
