package pl.lublin.wsei.java.cwiczenia.lab2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {
    private String title;
    private String addressUrl;
    private String graphicUrl;
    private String thumbNailUrl;
    private String GraphicWidth;
    private String GraphicHeight;

    public Infografika(String item) {
        Matcher tittleMatcher = Pattern.compile("<title><!\\[CDATA\\[com.example.lab2.Infografika - (.*)]]").matcher(item);
        Matcher addressUrlMatcher = Pattern.compile("<link>(https://stat.gov.pl/infografiki.*)</link>").matcher(item);
        Matcher graphicUrlMatcher = Pattern.compile("media:content url=\"(.*)\" type").matcher(item);
        Matcher thumbNailUrlMatcher = Pattern.compile("<media:thumbnail url=\"(.*(?:png|jpeg|jpg))").matcher(item);
        Matcher GraphicWidthMatcher = Pattern.compile("type=\"image/(?:png|jpeg)\" width=\"(\\d+)").matcher(item);
        Matcher GraphicHeightMatcher = Pattern.compile("type=\"image/(?:png|jpeg)\" width=\"\\d+\" height=\"(\\d+)\">").matcher(item);

        this.title = (tittleMatcher.find()) ? tittleMatcher.group(1) : "";
        this.addressUrl = (addressUrlMatcher.find()) ? addressUrlMatcher.group(1) : "";
        this.graphicUrl = (graphicUrlMatcher.find()) ? graphicUrlMatcher.group(1) : "";
        this.thumbNailUrl = (thumbNailUrlMatcher.find()) ? thumbNailUrlMatcher.group(1) : "";
        this.GraphicWidth = (GraphicWidthMatcher.find()) ? GraphicWidthMatcher.group(1) : "";
        this.GraphicHeight = (GraphicHeightMatcher.find()) ? GraphicHeightMatcher.group(1) : "";
    }

    @Override
    public String toString() {
        return "\nInfografika: "
                + "\ntytuł: " + title
                + "\nadres strony: " + addressUrl
                + "\nadres grafiki: " + graphicUrl
                + "\nadres miniatury: " + thumbNailUrl
                + "\nwymiary: "  + GraphicWidth + " x " + GraphicHeight;
    }


}
