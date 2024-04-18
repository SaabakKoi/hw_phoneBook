import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        PhoneBook phoneBook = new PhoneBook();


        phoneBook.add("Max", 121212);

        phoneBook.add("Sam", 232323);
        phoneBook.add("Sam", 131313);
        phoneBook.add("Sam", 171717);

        phoneBook.add("John", 141414);
        phoneBook.add("John", 151515);



        phoneBook.sortPhoneBook();

    }
}

class PhoneBook{
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    private ArrayList<Integer> numy = new ArrayList<>();

    public void add(String name, Integer phoneNum) {
        ArrayList<Integer> numbers = new ArrayList<>();
        if(phoneBook.containsKey(name)){
            numy = phoneBook.get(name);

            numy.add(phoneNum);
            phoneBook.put(name, numy);

        } else {
            numbers.add(phoneNum);
            phoneBook.put(name, numbers);

        }

    }

    public ArrayList<Integer> find(String name) {
        ArrayList<Integer> phones = new ArrayList<>();
        if(phoneBook.containsKey(name)){
            phones.addAll(phoneBook.get(name));
            return phones;}

        return phones;

    }

    public void sortPhoneBook(){
        ArrayList<String> listOfNames = new ArrayList<>();
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>();

        for (String key : phoneBook.keySet()) {

            ArrayList<Integer> list = phoneBook.get(key);
            listOfLists.add(list);
            listOfNames.add(key);
        }

        for (int i = 0; i < listOfLists.size(); i++) {
            for (int j = 0; j < listOfNames.size(); j++) {
                if(j+1< listOfNames.size()) {
                    if (listOfLists.get(j).size() > listOfLists.get(j + 1).size()) {
                        ArrayList<Integer> list = new ArrayList<>(listOfLists.get(j));
                        String name = listOfNames.get(j);
                        listOfLists.add(j, listOfLists.get(j + 1));
                        listOfNames.add(j, listOfNames.get(j + 1));

                        listOfLists.add(j + 1, list);
                        listOfNames.add(j + 1, name);
                    }
                }
            }
        }
        for (int i = listOfNames.size()-1; i >= 0; i--) {

            System.out.println(listOfNames.get(i) + "=" + listOfLists.get(i));
        }

    }

}

