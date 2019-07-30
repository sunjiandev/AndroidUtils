package com.sunkaisens.androidutils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:sjy
 * @date:2019-07-26
 * @email:sjy_mail@163.com
 * @Description:
 */
public class TestJsoup {

    private static Map<String, String> titleMap = new HashMap<>();

    public static void main(String[] args) {

        String baseUri = "https://www.qiushibaike.com/";

        try {
            Connection connect = Jsoup.connect("https://www.qiushibaike.com/text");
            connect.timeout(10 * 1000);
            connect.ignoreContentType(true);
            connect.ignoreHttpErrors(true);
            Document document = connect.get();

            String title = document.title();

            Elements main = document.getElementsByClass("main");

            Element element = main.get(0);

            Elements elementsByClass = element.getElementsByClass("content-block clearfix");

            Elements element1 = elementsByClass.get(0).getElementsByClass("col1");

            System.out.println("element1 = " + element1.get(0).getElementsMatchingText("article block untagged mb15(.*?)").size());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void getContent(Element body) {


    }

    /**
     * 获取title 的信息
     *
     * @param body 标签
     */
    private static void getTitleInfo(Element body) {
        Element menu = body.getElementById("menu");

        Elements titleElements = menu.select("a");

        for (Element titleElement : titleElements) {
            String text = titleElement.text();
            System.out.println("text = " + text);
            String href = titleElement.attr("href");
            System.out.println("href = " + href);
            titleMap.put(text, href);
        }
    }

}
