import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class JsoupFunctions
{
    private ArrayList<Car> arrayList = new ArrayList<>();

    public void start(String[] dealers) throws Exception{

        for (int j = 0; j < dealers.length; j++) {
            Document d = Jsoup.connect(dealers[j]).timeout(6000).get();
            Elements e = d.select("div.offer-item__content");

            int counter = 0;

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
                distance = name.substring(5, 15);
                capacity = name.substring(16, 26);
                engine = name.substring(26, lastOfIndex);

                //2012 181 000 km 2 000 cm3 Diesel
                carsTab[temp].setYear(year);
                carsTab[temp].setDistance(distance);
                carsTab[temp].setCapacity(capacity);
                carsTab[temp].setEngine(engine);

                temp++;
            }

            /*
            //WYPISUJE NAZYW SAMOCHODU
            for (int i = 0; i < carsTab.length; i++) {
                System.out.println(carsTab[i].getName());
                System.out.println(carsTab[i].getPrice());
                System.out.println(carsTab[i].getYear());
                System.out.println(carsTab[i].getDistance());
                System.out.println(carsTab[i].getCapacity());
                System.out.println(carsTab[i].getEngine());
                System.out.println((carsTab[i].getLink()));
                System.out.println("=======================================================");
            }
            */

            //WPISYWANIE DO LISTY
            for(int i=0; i < counter;i++){
                arrayList.add(carsTab[i]);
            }
        }

        System.out.println(arrayList.size());
        Excel.createExcel(arrayList);
    }

}
