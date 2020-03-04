package officeHours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SeleniumOH1 {

    /*
    -ITERATOR
        -List , set, map and other types of collections can use iterator class to iterate over that collection
        - List has indexes (for i, for each, while, iterator)
        -map(for each, iterator -to loop through keys)

     -BASIC SELENIUM NAVIGATIONS


     */

    public static void main(String[] args) {
        //create arraylist of strings -iterate over it
        ArrayList<String > keysToSearch =new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");
        Iterator <String> iterator=keysToSearch.iterator();

        //iterator() -return iterator type which we can use with all iterator methods
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            //print before modification and
            //add * to each string and print again

            Iterator <String> iterator1= keysToSearch.iterator();

            while (iterator1.hasNext()){
                String item=iterator1.next();
                System.out.println(item);
                System.out.println("*" + item);
            }


            HashMap<String, String > personalInfo =new HashMap<>();
            personalInfo.put("name", "Bryan");
            personalInfo.put("studentId" , "2267222");
            personalInfo.put("major" , "computer science");

            Iterator <String> mapIterator = personalInfo.keySet().iterator();
            while (mapIterator.hasNext()){
                String key=mapIterator.next();
                System.out.println(key+":" + personalInfo.get(key));
            }





        }

    }


}
