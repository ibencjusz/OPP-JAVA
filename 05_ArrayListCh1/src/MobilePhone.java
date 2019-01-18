import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    /**
     * Konstruktor inicjujacy numer wlasciciela wraz z lista kontaktow
     * @param myNumber numer uzytkownika
     */
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    /**
     * Metoda dodawania nowego kontaktu do listy
     * @param contact obiekt nowego kontaktu
     * @return zwracana jest wartość true badz false
     * w zaleznosci czy wprowadzony kontakt istnieje juz w systemie
     */
    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    /**
     * Metoda aktualizuje dane kontaktowe
     * @param oldContact kontakt do edycji
     * @param newContact kontakt po edycji
     * @return
     */
    public boolean updateContact(Contact oldContact, Contact newContact){
        //sprawdzana jest pozycja kontaktu w tablicy, jesli zwrocona zostanie wartosc -1
        //oznacza to ze nie ma kontaktu ktory mialby byc edytowany
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0) {
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        }

        //jesli wartosc zwrocona byla wieksza od -1 to stary kontakt zostanie zastapiony przez nowy
        this.myContacts.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0) {
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    /**
     * Metoda sprawdza czy obiekt kontaktu istenieje juz w programie
     * @param contact
     * @return
     */
    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    /**
     * Metoda sprawdza czy nazwa kontaktu istnieje juz w programie
     * @param contactName nazwa szukanego kontaktu
     * @return jesli zwróci -1 to znaczy ze kontaktu nie ma w programie
     */
    private int findContact(String contactName){
        for(int i=0; i<this.myContacts.size(); i++){

            //Do obiektu kontakt wpisuje zawartości znajdujące się w arrayList a nastepnie porownuje je
            //z nazwa nowego kontaktu
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public String queryContact(Contact contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    //wyświetla listę wszystkich kontaktów
    public void printContacts(){
        System.out.println("Contact list:");
        for(int i=0; i<this.myContacts.size(); i++){
            System.out.println((i+1)+"."+this.myContacts.get(i).getName() + " -> " + this.myContacts.get(i).getPhoneNumber());
        }
    }
}
