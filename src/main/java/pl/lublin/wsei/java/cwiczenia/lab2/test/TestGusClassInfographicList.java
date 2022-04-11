package pl.lublin.wsei.java.cwiczenia.lab2.test;

import pl.lublin.wsei.java.cwiczenia.lab2.GusInfographicList;

public class TestGusClassInfographicList {
    public static void main(String[] args) {
        GusInfographicList gusInfographicList = new GusInfographicList("src/main/java/pl/lublin/wsei/java/cwiczenia/lab2/gusInfoGraphic.xml");
        gusInfographicList.getInfographicsList();
    }

}
