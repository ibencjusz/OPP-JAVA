import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// https://www.tutorialspoint.com/jsoup/jsoup_use_selector.htm
// https://www.youtube.com/watch?v=lZmuHyiKQdE&list=PL2k4Q1S5CYhHC0PIV5veJKMzLBO8I3ih3&index=1
// https://blog.peku33.net/jsoup-mini-tutorial-parsowanie-html-w-srodowisku-java/


import java.io.IOException;

import static sun.util.logging.LoggingSupport.log;

public class Main {

    public static void main(String[] args) throws Exception {

        Document d = Jsoup.connect("https://autokomis-piotr.otomoto.pl/").timeout(6000).get();
        Elements e = d.select("div.offer-item__content");

        int counter=0;

        for (Element element : e){
            String name = element.select("a.offer-title__link").text();
            System.out.println(name);
            counter++;
        }

        System.out.println("Number of cars: " + counter);


        System.out.println(d.title());

        
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

        /*
        Document doc;
        try {

            doc = Jsoup.connect("http://www.vogella.com").get();

            // get title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            // get all links
            Elements links = doc.select("a[href]");
            for (Element link : links) {

                // get the value from href attribute
                System.out.println("\nLink : " + link.attr("href"));
                System.out.println("Text : " + link.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*
        Document document = Jsoup.connect("http://en.wikipedia.org/").get();
        System.out.println((document.title()));
        Elements newsHeadlines = document.select("#mp-itn b a");


        for (Element headline : newsHeadlines) {
            System.out.println(headline.attr("title"));
            System.out.println(headline.absUrl("href"));
        }
        */
    }
}
