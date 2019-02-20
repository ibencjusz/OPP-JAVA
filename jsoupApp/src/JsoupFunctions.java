import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/*
        String[] dealers = {"https://gocar.otomoto.pl/",
                            "https://deutchemark.otomoto.pl/",
                            "https://uzywane-z-niemiec.otomoto.pl/",
                            "https://joker-cars.otomoto.pl/",
                            "https://sevgalcars.otomoto.pl/",
                            "https://autohousekomis.otomoto.pl/",
                            "https://spdancar.otomoto.pl/",
                            "https://autoparkwojcik.otomoto.pl/",
                            "https://kari.otomoto.pl/",
                            "https://artur-auto.otomoto.pl/"};
        */

public class JsoupFunctions
{
    private ArrayList<Car> arrayList = new ArrayList<>();
    private ArrayList<String> listOfCars = new ArrayList<>();
    private int v = 0;

    public void listOf(){
        for(int i = 0; i < listOfCars.size(); i++){
            System.out.println(listOfCars.get(i));
        }
    }



    public void start() throws Exception{

        listOfCars.add("https://vw-plichta.otomoto.pl/");
        //listOfCars.add("https://gocar.otomoto.pl/");



        for (int j = 0; j < listOfCars.size(); j++) {
            Document d = Jsoup.connect(listOfCars.get(j)).timeout(6000).get();
            Elements e = d.select("div.offer-item__content");

            int counter = 0;

            //System.out.println("TITLE: " + d.title());

            for (Element element : e) {
                String name = element.select("a.offer-title__link").text();
                counter++;
            }

            Car[] carsTab = new Car[counter];
            for (int i = 0; i < carsTab.length; i++) {
                carsTab[i] = new Car();
            }

            //WPISUJE NAZWE SAMOCHODU
            int temp = 0;
            for (Element element : e) {
                String name = element.select("a.offer-title__link").text();
                String link = element.select("a.offer-title__link").attr("href");
                carsTab[temp].setName(name);
                carsTab[temp].setLink(link);
                temp++;
            }

            //WSPISUJE CENE SAMOCHODU
            temp = 0;
            for (Element element : e) {
                String name = element.select("span.offer-price__number").text();
                name = name.substring(0,name.length()-4);
                carsTab[temp].setPrice(name);
                temp++;
            }

            //WSPISUJE ROK/DYSTANS/POJEMNOSC/RODZAJ PALIWA SAMOCHODU
            temp = 0;
            for (Element element : e) {
                String name = element.select("li.offer-item__params-item").text();

                String year, distance, capacity, engine;
                int lastOfIndex = name.length();

                year = name.substring(0, 5);
                distance = name.substring(5,name.indexOf("km"));
                capacity = name.substring(name.indexOf("km")+2, name.indexOf("cm3"));
                engine = name.substring(name.indexOf("cm3")+3,lastOfIndex);

                //System.out.println("KM: " + name.indexOf("km"));
                //System.out.println("CM: " + name.indexOf("cm3"));

                //2012 181 000 km 2 000 cm3 Diesel
                carsTab[temp].setYear(year);
                carsTab[temp].setDistance(distance);
                carsTab[temp].setCapacity(capacity);
                carsTab[temp].setEngine(engine);

                temp++;
            }

            System.out.println(arrayList.size());

            /*
            temp = 0;
            for (Element element : e) {
                temp++;
                if(temp==25){
                    //String name = element.select("span.page").text();
                    //String name = element.getElementsByClass("next abs").attr("href");
                    String name = element
                    System.out.println("html: " + name);

                    //Elements pngs = document.select("img[src$=.png]");
                }
            */


            //PRZECHWYTUJE LINK DO NASTEPNEJ STRONY
            if(temp==25) {
                v++;
                System.out.println("TEMP: " + temp + " COUNTER: " + v);
                Elements newPage = d.select("a[href*=page=]");
                String naz = newPage.attr("href");
                System.out.println(naz);
                listOfCars.add(naz);
                temp++;
            }





            //WPISYWANIE DO LISTY
            for(int i=0; i < counter;i++){
                arrayList.add(carsTab[i]);
            }
        }

        System.out.println(arrayList.size());
        Excel.createExcel(arrayList);
    }

}
