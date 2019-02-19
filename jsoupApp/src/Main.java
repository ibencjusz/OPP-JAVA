

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
                            "https://bmv.otomoto.pl/",
                            "https://kari.otomoto.pl/",
                            "https://autokaleta.otomoto.pl/",
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
