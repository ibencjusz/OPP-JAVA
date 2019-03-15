import java.util.ArrayList;


class IntClass {
    private int myValue;

    public IntClass(int myValue){
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}
public class Main
{
    public static void main(String[] args)
    {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Tim");


        //ArrayList nie przechowuje wartosci INT
        ArrayList<IntClass> intArrayList = new ArrayList<IntClass>();
        ArrayList<IntClass> intClassArrayList = new ArrayList<>();
        intClassArrayList.add(new IntClass(54));

        Integer integer = new Integer(54);
        Double doubleValue = new Double(12.25);

        ArrayList<Integer> intArratList = new ArrayList<>();
        for(int i=0; i < 10; i++){
            intArratList.add(Integer.valueOf(i));
        }

        for(int i=0; i < 10; i++){
            System.out.println(i + " --> " + intArratList.get(i).intValue());
        }

        Integer myIntValue = 56; //Integer.valueOf(56);
    }
}
