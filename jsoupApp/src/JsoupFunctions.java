import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupFunctions
{
    private String[][] tempTab = new String[23][7];
    private int numberOfCars = 0;

    public void writeIntoTable(Car[] car){


        for(int i =0; i < 23; i++){
            for(int j=0;j<7;j++){
                if(j==0) tempTab[i][j] = car[i].getName();
                if(j==1) tempTab[i][j] = car[i].getPrice();
                if(j==2) tempTab[i][j] = car[i].getYear();
                if(j==3) tempTab[i][j] = car[i].getDistance();
                if(j==4) tempTab[i][j] = car[i].getCapacity();
                if(j==5) tempTab[i][j] = car[i].getEngine();
                if(j==6) tempTab[i][j] = car[i].getLink();
            }
        }
    }

    public void showTable(){
        for(int i =0; i < 23; i++){
            System.out.println(tempTab[i][0] + " " + tempTab[i][1]+" "+tempTab[i][2]+" "+ tempTab[i][3]+" "+tempTab[i][4]+" "+ tempTab[i][5]+" "+tempTab[i][6]);
        }
    }


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

            numberOfCars += counter;

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
                writeIntoTable(carsTab);
            }



            //WYPISUJE NAZYW SAMOCHODU
            for (int i = 0; i < carsTab.length; i++) {
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

            Excel.createExcel(carsTab);


            System.out.println("=======================================================");
            System.out.println("=======================================================");
            System.out.println("=======================================================");
            System.out.println("Number of cars: " + counter);
            System.out.println(d.title());
            System.out.println("=======================================================");
            System.out.println("=======================================================");
            System.out.println("=======================================================");
            System.out.println("ALL: "+ numberOfCars);
            showTable();

        }
    }

}
