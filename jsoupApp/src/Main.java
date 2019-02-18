import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// https://www.tutorialspoint.com/jsoup/jsoup_use_selector.htm
// https://www.youtube.com/watch?v=lZmuHyiKQdE&list=PL2k4Q1S5CYhHC0PIV5veJKMzLBO8I3ih3&index=1
// https://blog.peku33.net/jsoup-mini-tutorial-parsowanie-html-w-srodowisku-java/

//SELEKTORY
//https://www.w3schools.com/cssref/css_selectors.asp


import java.io.IOException;

import static sun.util.logging.LoggingSupport.log;

public class Main {

    public static void main(String[] args) throws Exception {

        //https://renaultwarszawa.otomoto.pl/
        //https://autokomis-piotr.otomoto.pl/
        //https://top-cars.otomoto.pl/

        //https://gocar.otomoto.pl/
        //https://deutchemark.otomoto.pl/
        //https://uzywane-z-niemiec.otomoto.pl/
        //https://joker-cars.otomoto.pl/
        //https://sevgalcars.otomoto.pl/
        //https://autohousekomis.otomoto.pl/
        //https://spdancar.otomoto.pl/
        //https://autoparkwojcik.otomoto.pl/
        //https://bmv.otomoto.pl/
        //https://kari.otomoto.pl/
        //https://autokaleta.otomoto.pl/



        /*
        String[] dealers = {"https://gocar.otomoto.pl/",
                            "https://deutchemark.otomoto.pl/",
                            "https://uzywane-z-niemiec.otomoto.pl/",
                            "https://joker-cars.otomoto.pl/",
                            "https://sevgalcars.otomoto.pl/",
                            "https://autohousekomis.otomoto.pl/",
                            "https://spdancar.otomoto.pl/",
                            "https://autoparkwojcik.otomoto.pl/",
                            "https://bmv.otomoto.pl/",
                            "https://kari.otomoto.pl/",
                            "https://autokaleta.otomoto.pl/"};
        */

        String[] dealers = {"https://deutchemark.otomoto.pl/"};

        JsoupFunctions jsoupFunctions = new JsoupFunctions();
        jsoupFunctions.start(dealers);




        //a with href

        /*

        String html =
                "<html><head><title>Sample Title</title></head>"
                + "<body>"
                + "<p>Sample Content</p>"
                + "<div id='sampleDiv'><a href='www.google.com'>Google</a>"
                + "<h3><a>Sample</a><h3>"
                +"</div>"
                + "<div id='imageDiv' class='header'><img name='google' src='google.png' />"
                + "<img name='yahoo' src='yahoo.jpg' />"
                +"</div>"
                +"</body></html>";
        Document document = Jsoup.parse(html);

        Elements links = document.select("a[href]");

        for (Element link : links) {
            System.out.println("Href: " + link.attr("href"));
            System.out.println("Text: " + link.text());
        }

        // img with src ending .png
        Elements pngs = document.select("img[src$=.png]");

        for (Element png : pngs) {
            System.out.println("Name: " + png.attr("name"));
        }

        // div with class=header
        Element headerDiv = document.select("div.header").first();
        System.out.println("Id: " + headerDiv.id());

        // direct a after h3
        Elements sampleLinks = document.select("h3 > a");

        for (Element link : sampleLinks) {
            System.out.println("Text: " + link.text());
        }

        */

    }
}
