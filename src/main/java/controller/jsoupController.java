package controller;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoupController {

    public List<String> getArrayResult(Elements elements, String target){
        List<String> result = new ArrayList<String>();
        
        Elements childElements = elements.select(target);
        for (Element elm : childElements) {
            result.add(elm.text());
        }

        return result;
    }
}
