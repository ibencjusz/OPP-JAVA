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

        int numberOfCars = 0;

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

        String[] dealers = {"https://joker-cars.otomoto.pl/"};

        for(int j=0; j<dealers.length;j++){



            Document d = Jsoup.connect(dealers[j]).timeout(6000).get();
            Elements e = d.select("div.offer-item__content");

            int counter=0;

            for (Element element : e){
                String name = element.select("a.offer-title__link").text();
                counter++;
            }

            Car[] carsTab = new Car[counter];
            for(int i=0; i < carsTab.length; i++){
                carsTab[i] = new Car();
            }

            numberOfCars += counter;

            //WPISUJE NAZWE SAMOCHODU
            int temp = 0;
            for(Element element : e){
                String name = element.select("a.offer-title__link").text();
                String link = element.select("a.offer-title__link").attr("href");
                carsTab[temp].setName(name);
                carsTab[temp].setLink(link);
                temp++;
            }



            //WPISUJE KRÓTKI OPIS SAMOCHODU
            temp = 0;
            for(Element element : e){
                String name = element.select("offer-item__subtitle offer-item__subtitle--short").text();
                carsTab[temp].setShortDescription(name);
                temp++;
            }


            //WSPISUJE CENE SAMOCHODU
            temp = 0;
            for(Element element : e){
                String name = element.select("span.offer-price__number").text();
                carsTab[temp].setPrice(name);
                temp++;
            }

            //WSPISUJE ROK/DYSTANS/POJEMNOSC/RODZAJ PALIWA SAMOCHODU
            temp = 0;
            for(Element element : e){
                String name = element.select("li.offer-item__params-item").text();

                String year,distance,capacity,engine;
                int lastOfIndex = name.length();

                year = name.substring(0,5);
                distance = name.substring(5,15);
                capacity = name.substring(16,26);
                engine = name.substring(26,lastOfIndex);

                //2012 181 000 km 2 000 cm3 Diesel
                carsTab[temp].setYear(year);
                carsTab[temp].setDistance(distance);
                carsTab[temp].setCapacity(capacity);
                carsTab[temp].setEngine(engine);

                temp++;
            }




            //WYPISUJE NAZYW SAMOCHODU
            for(int i=0; i < carsTab.length; i++){
                System.out.println(carsTab[i].getName());
                //System.out.println(carsTab[i].getShortDescription());
                System.out.println(carsTab[i].getPrice());
                System.out.println(carsTab[i].getYear());
                System.out.println(carsTab[i].getDistance());
                System.out.println(carsTab[i].getCapacity());
                System.out.println(carsTab[i].getEngine());
                System.out.println((carsTab[i].getLink()));
                System.out.println("=======================================================");
            }

            System.out.println("=======================================================");
            System.out.println("=======================================================");
            System.out.println("=======================================================");
            System.out.println("Number of cars: " + counter);
            System.out.println(d.title());
            System.out.println("=======================================================");
            System.out.println("=======================================================");
            System.out.println("=======================================================");
        }
        System.out.println("Liczba samochodow na sprzedaz: " + numberOfCars);



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
