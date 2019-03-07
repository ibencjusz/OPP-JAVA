//https://www.w3schools.com/cssref/css_selectors.asp

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

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


        JsoupFunctions jsoupFunctions = new JsoupFunctions();


        /*
        jsoupFunctions.addPage("https://kari.otomoto.pl/");
        jsoupFunctions.addPage("https://artur-auto.otomoto.pl/");
        jsoupFunctions.addPage("https://gocar.otomoto.pl/");
        jsoupFunctions.addPage("https://deutchemark.otomoto.pl/");
        jsoupFunctions.addPage("https://joker-cars.otomoto.pl/");
        jsoupFunctions.addPage("https://deutchemark.otomoto.pl/");
        jsoupFunctions.addPage("https://autoparkwojcik.otomoto.pl/");
        jsoupFunctions.addPage("https://spdancar.otomoto.pl/");
        jsoupFunctions.addPage("https://autohousekomis.otomoto.pl/");
        jsoupFunctions.addPage("https://sevgalcars.otomoto.pl/");
        jsoupFunctions.addPage("https://uzywane-z-niemiec.otomoto.pl/");
        jsoupFunctions.addPage("https://autokaleta.otomoto.pl/");
        jsoupFunctions.addPage("https://drive-cars.otomoto.pl/");
        jsoupFunctions.addPage("https://marix.otomoto.pl/");
        jsoupFunctions.addPage("https://ac.otomoto.pl/");
        jsoupFunctions.addPage("https://endy-car.otomoto.pl/");
        */


        jsoupFunctions.addPage("https://autokaleta.otomoto.pl/");
        jsoupFunctions.addPage("https://endy-car.otomoto.pl/");
        jsoupFunctions.addPage("https://auto-garaz.otomoto.pl/");
        //jsoupFunctions.addPage("https://mat-mar.otomoto.pl/");

        //jsoupFunctions.addPage("https://www.otomoto.pl/osobowe/audi/a4/zawiercie/?search%5Bfilter_enum_fuel_type%5D%5B0%5D=petrol&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=50&search%5Bcountry%5D=");
        try{
            jsoupFunctions.start();
            //jsoupFunctions.listOf();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Finish");
        }
    }
}
