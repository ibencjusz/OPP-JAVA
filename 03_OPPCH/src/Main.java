import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        int[] tab = getIntegers(4);
        startApp(tab);
    }


    public static int[] getIntegers(int numbers){
        int[] values = new int[numbers];

        System.out.println("Wpisz " + numbers + " liczb typu int");

        for(int i=0; i < numbers; i++){
            values[i] = in.nextInt();
        }
        return values;
    }

    public static void showTab(int[] array){
        for(int i=0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void showMenu(){
        System.out.println("===============================");
        System.out.println("1. Pokaz liczbe z tablicy: ");
        System.out.println("2. Wyswietl tablice");
        System.out.println("3. Sortuj tablice");
        System.out.println("4. Wyswietl min w tablicy");
        System.out.println("===============================");
    }

    public static void startApp(int[] array){
        showMenu();
        System.out.println("Wybierz opcje: ");
        int option = in.nextInt();

        switch (option){
            case 1:
            {
                getNumberFromTable(array);
                break;
            }
            case 2:
                showTab(array);
                break;

            case 3:
                Arrays.sort(array);
                showTab(array);
                break;

            case 4:
                System.out.println("Min: " + minElement(array));
                break;

             default:
                 System.out.println("Nie ma takiej opcji...");
        }
    }

    public static void getNumberFromTable(int[] array){
        int temp;
        System.out.println("Wpisz liczbe: ");
        temp = in.nextInt();
        for(int i=0; i<array.length; i++){
            if(temp==array[i]){
                System.out.println("Podana liczba znajduje sie pod indeksem: " + i);
            }
            else System.out.println("Podanej liczby nie ma w tablicy");
        }
    }

    public static double getAverage(int[] array){
        double sum=0;
        for(int i=0; i < array.length;i++){
            sum+=array[i];
        }
        return sum/array.length;
    }

    public static int minElement(int[] array){
        int min=array[0];
        for(int i=0; i < array.length;i++){
            if(min>array[i]) min = array[i];
        }
        return min;
    }
}
