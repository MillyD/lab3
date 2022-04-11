package pl.lublin.wsei.java.cwiczenia.lab2.test;

import pl.lublin.wsei.java.cwiczenia.lab2.GusInfographicList;
import pl.lublin.wsei.java.cwiczenia.lab2.Infografika;

public class testInfografika {
    public static void main(String[] args) {
        GusInfographicList gusClass = new GusInfographicList("src/main/java/pl/lublin/wsei/java/cwiczenia/lab2/gusInfoGraphic.xml");
        String exItem = gusClass.getRandomItem();

        Infografika infografika = new Infografika(exItem);
        System.out.println(infografika);
    }
}
