import oracle.jrockit.jfr.StringConstantPool;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> listOfNames = new ArrayList<>();

        for(int i=0; i < 3; i++){
            addToList(listOfNames,in.next());
        }

        for(int i=0; i<listOfNames.size();i++){
            System.out.println(listOfNames.get(i));
        }

        System.out.println("Rozmiar: " + listOfNames.size());
        modifyList(2,"TUTAJ NASTĄPIŁA ZMIANA", listOfNames);
        System.out.println(arrayList(listOfNames));
    }

    public static void addToList(ArrayList<String> temp, String name){
        temp.add(name);
    }

    public static ArrayList arrayList(ArrayList<String> temp){
        return temp;
    }

    public static void modifyList(int position, String name, ArrayList<String> temp){
        temp.set(position,name);
    }
}
