//https://www.w3schools.com/cssref/css_selectors.asp


//https://www.w3schools.com/cssref/css_selectors.asp

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        JsoupFunctions jsoupFunctions = new JsoupFunctions();

        String tucson = "https://www.otomoto.pl/osobowe/hyundai/tucson/od-2004/zawiercie/?search%5Bfilter_float_year%3Ato%5D=2006&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=75&search%5Bcountry%5D=";
        String verso = "https://www.otomoto.pl/osobowe/toyota/corolla-verso/od-2004/zawiercie/?search%5Bfilter_float_year%3Ato%5D=2006&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=75&search%5Bcountry%5D=";
        String bravo = "https://www.otomoto.pl/osobowe/fiat/bravo/od-2008/zawiercie/?search%5Bfilter_float_year%3Ato%5D=2010&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=75&search%5Bcountry%5D=";
        String cc207 = "https://www.otomoto.pl/osobowe/peugeot/307-cc/od-2006/zawiercie/?search%5Bfilter_float_year%3Ato%5D=2010&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=75&search%5Bcountry%5D=";
        String tigra = "https://www.otomoto.pl/osobowe/opel/tigra/od-2004/zawiercie/?search%5Bfilter_float_year%3Ato%5D=2006&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=75&search%5Bcountry%5D=";
        String bmw ="https://www.otomoto.pl/osobowe/bmw/seria-1/od-2004/zawiercie/?search%5Bfilter_float_year%3Ato%5D=2007&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=75&search%5Bcountry%5D=";
        String croma = "https://www.otomoto.pl/osobowe/fiat/croma/od-2004/zawiercie/?search%5Bfilter_float_year%3Ato%5D=2007&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=75&search%5Bcountry%5D=";
        String calibra = "https://www.otomoto.pl/osobowe/opel/calibra/?search%5Bbrand_program_id%5D%5B0%5D=&search%5Bcountry%5D=0";
        String p407 = "https://www.otomoto.pl/osobowe/peugeot/407/od-2004/zawiercie/?search%5Bfilter_float_year%3Ato%5D=2009&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=75&search%5Bcountry%5D=";
        String astra = "https://www.otomoto.pl/osobowe/opel/astra/od-2004/zawiercie/?search%5Bfilter_float_year%3Ato%5D=2009&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=75&search%5Bcountry%5D=";
        String signum = "https://www.otomoto.pl/osobowe/opel/signum/od-2004/zawiercie/?search%5Bfilter_float_year%3Ato%5D=2009&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=75&search%5Bcountry%5D=";
        //LINK https://www.otomoto.pl/osobowe/?search%5Bnew_used%5D=on

        String focusCzewa = "https://www.otomoto.pl/osobowe/ford/focus/od-1999/czestochowa/?search%5Bfilter_float_year%3Ato%5D=2004&search%5Bfilter_enum_fuel_type%5D%5B0%5D=diesel&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bdist%5D=100&search%5Bcountry%5D=";

        //jsoupFunctions.addPage(astra);
        jsoupFunctions.start();
    }
}