package pl.lublin.wsei.java.cwiczenia.lab2.test;

import pl.lublin.wsei.java.cwiczenia.lab2.GusInfographicList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegEx {
    public static void main(String[] args) {

        GusInfographicList gusClass = new GusInfographicList("src/main/java/pl/lublin/wsei/java/cwiczenia/lab2/gusInfoGraphic.xml");
        String exItem = gusClass.getRandomItem();

        Matcher tittleMatcher = Pattern.compile("<title><!\\[CDATA\\[com.example.lab2.Infografika - (.*)]]").matcher(exItem);
        Matcher addressUrlMatcher = Pattern.compile("<link>(https://stat.gov.pl/infografiki.*)</link>").matcher(exItem);
        Matcher graphicUrlMatcher = Pattern.compile("media:content url=\"(.*)\" type").matcher(exItem);
        Matcher thumbNailUrlMatcher = Pattern.compile("<media:thumbnail url=\"(.*(?:png|jpeg|jpg))").matcher(exItem);
        Matcher GraphicWidthMatcher = Pattern.compile("type=\"image/(?:png|jpeg)\" width=\"(\\d+)").matcher(exItem);
        Matcher GraphicHeightMatcher = Pattern.compile("type=\"image/(?:png|jpeg)\" width=\"\\d+\" height=\"(\\d+)\">").matcher(exItem);

        System.out.println((tittleMatcher.find()) ? tittleMatcher.group(1) : "tittleMatcher");
        System.out.println((addressUrlMatcher.find()) ? addressUrlMatcher.group(1) : "addressUrlMatcher");
        System.out.println((graphicUrlMatcher.find()) ? graphicUrlMatcher.group(1) : "graphicUrlMatcher");
        System.out.println((thumbNailUrlMatcher.find()) ? thumbNailUrlMatcher.group(1) : "thumbNailUrlMatcher");
        System.out.println((GraphicWidthMatcher.find()) ? GraphicWidthMatcher.group(1) : "GraphicWidthMatcher");
        System.out.println((GraphicHeightMatcher.find()) ? GraphicHeightMatcher.group(1) : "GraphicHeightMatcher");
    }
}
