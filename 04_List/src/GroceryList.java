import java.util.ArrayList;

public class GroceryList
{
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    public void printGroceryList(){
        System.out.println("Size: " + groceryList.size());
        for(int i=0; i < groceryList.size(); i++){
            System.out.println((i+1) + " " + groceryList.get(i));
        }
    }

    public void modifyGroceryList(int position, String newItem){
        groceryList.set(position,newItem);
        System.out.println("The element was modified");
    }

    public void removeGroceryItem(int position){
        groceryList.remove(position);
        System.out.println("The element was removed");
    }

    public String findItem(String searchItem){
        //boolean exists = groceryList.contains(searchItem);
        int position = groceryList.indexOf(searchItem);
        if(position >= 0){
            return groceryList.get(position);
        } else return null;
    }
}
