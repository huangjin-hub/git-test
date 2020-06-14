package com.jin.utils;

import com.jin.pojo.Content;
import org.apache.catalina.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {
    public List<Content> parseJD(String keywords) throws IOException {
        //https://search.jd.com/Search?keyword=java
        String url = "https://search.jd.com/Search?keyword="+keywords;
        Document document = Jsoup.parse(new URL(url), 3000);
        Element element = document.getElementById("J_goodsList");
        Elements lis = element.getElementsByTag("li");
        List<Content> contents = new ArrayList<>();
        for (Element li : lis) {
            String img = li.getElementsByTag("img").eq(0).attr("source-data-lazy-img");
            String price = li.getElementsByClass("p-price").eq(0).text();
            String title = li.getElementsByClass("p-name").eq(0).text();
            contents.add(new Content(title, img, price));
        }
        return contents;
    }
}
