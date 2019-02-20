

public class Main {

    public static void main(String[] args) throws Exception {


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


        //String[] dealers = {"https://artur-auto.otomoto.pl/"};

        JsoupFunctions jsoupFunctions = new JsoupFunctions();

        try{
            jsoupFunctions.start(dealers);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Finish");
        }
    }
}
