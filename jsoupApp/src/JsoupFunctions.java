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
    private ArrayList<String> listOfCars = new ArrayList<>();

    public void listOf(){
        for(int i = 0; i < listOfCars.size(); i++){
            System.out.println(listOfCars.get(i));
        }
    }

    public void addPage(String page){
        listOfCars.add(page);
    }

    private int numberCars(Elements e){
        int counter = 0;
        for (Element element : e) {
            String name = element.select("a.offer-title__link").text();
            counter++;
        }
        return counter;
    }

    private void setName(Document d,Elements e, int temp, Car[] carsTab){
        Elements nameDealer = d.select("h2.seller-box__seller-name");
        String dealerName = nameDealer.text();
        for (Element element : e) {
            String name = element.select("a.offer-title__link").text();
            String link = element.select("a.offer-title__link").attr("href");

            //USTAWIA NAZWE DEALERA
            carsTab[temp].setDealer(dealerName);

            int index = name.length();
            String car = name.substring(0,name.indexOf(" "));
            String model = name.substring(name.indexOf(" ") + 1, index);

            carsTab[temp].setName(car);
            carsTab[temp].setModel(model);

            //carsTab[temp].setName(name);
            carsTab[temp].setLink(link);
            temp++;
        }
    }

    private void setPrice(Document d,Elements e, int temp, Car[] carsTab){
        for (Element element : e) {
            String name = element.select("span.offer-price__number").text();
            name = name.substring(0,name.length()-4);
            carsTab[temp].setPrice(name);
            temp++;
        }
    }

    public void start() throws Exception{

        int increment=0;


        do {
            Document d = Jsoup.connect(listOfCars.get(increment)).timeout(6000).get();
            Elements e = d.select("div.offer-item__content");


            //LICZBA SAMOCHODOW NA STRONIE
            int temp = numberCars(e);


            //INICJALIZACJA TABLICY OBIEKTU SAMOCHOD
            Car[] carsTab = new Car[temp];
            for (int i = 0; i < carsTab.length; i++) {
                carsTab[i] = new Car();
            }


            //USTAWIENIE NAZWY DEALER'A, MODELU, LINNKA DO AUKCJI
            temp = 0;
            setName(d,e,temp,carsTab);

            //WSPISUJE CENE SAMOCHODU
            temp = 0;
            setPrice(d,e,temp,carsTab);



            //WSPISUJE ROK/DYSTANS/POJEMNOSC/RODZAJ PALIWA SAMOCHODU
            temp = 0;
            for (Element element : e) {
                String name = element.select("li.offer-item__params-item").text();

                String year, distance, capacity, engine;
                int lastOfIndex = name.length();


                //TUTAJ MUSI BYC ZABEZPEICZENIE PRZED NIE WPISANYMI DANYMI O POJEZDZIE PRZEZ DEALERA
                if(name.contains("cm3")){
                    year = name.substring(0, 5);
                    distance = name.substring(5, name.indexOf("km"));
                    capacity = name.substring(name.indexOf("km") + 2, name.indexOf("cm3"));
                    engine = name.substring(name.indexOf("cm3") + 3, lastOfIndex);
                }else{
                    year = name.substring(0, 5);
                    distance = name.substring(5, name.indexOf("km"));
                    capacity = "null";
                    engine = name.substring(name.indexOf("km") + 2, lastOfIndex);
                }

                carsTab[temp].setYear(year);
                carsTab[temp].setDistance(distance);
                carsTab[temp].setCapacity(capacity);
                carsTab[temp].setEngine(engine);
                temp++;
            }

            System.out.println(arrayList.size());



            //WARUNEK JESLI SAMOCHODOW W OFERCIE DEALERA BEDZIE ROWNO 25
            Elements newPage1 = d.select("a[href*=page=]");
            String naz1 = newPage1.attr("href");


            //JAK DEALER TO 25
            //JAK ZWYKLE TO 32
            if(naz1.length()!=0){
                if(temp==25){
                    try
                    {
                        //DEALER
                        Elements newPage = d.select("a[href*=page=]");
                        String naz = newPage.attr("href");
                        System.out.println(naz);
                        addPage(naz);

                        //ZWYKLE

                    }
                    catch (Exception ex)
                    {
                        ex.getMessage();
                    }
                }
            }


            //WPISYWANIE DO LISTY
            for(int i=0; i < temp;i++){
                arrayList.add(carsTab[i]);
            }

            increment++;
        }while(increment<listOfCars.size());

        System.out.println(arrayList.size());
        Excel.createExcel(arrayList);
    }
}