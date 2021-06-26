import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MergeSortedLists {

    public static void main(String[] args) {

        ArrayList<LinkedList> lists = new ArrayList<>();

        // Adding elements in LinkedList and adding that LinkedList to Array 'lists'.
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(5);
        lists.add(linkedList);

        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);
        lists.add(linkedList);

        linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(6);
        lists.add(linkedList);

        System.out.println("Original array of LinkedLists: " + lists);

        LinkedList<Integer> result = new LinkedList<>();

        for (LinkedList linkedList1 : lists) { // looping through original Array 'lists'.
            for (Object i : linkedList1) { // looping through each element of LinkedList.
                result.add((Integer) i); // adding each element to new LinkedList 'result'.
            }
        }

        Collections.sort(result); // sorting LinkedList 'result'.
        System.out.println("Merged sorted LinkedList: " + result);
    }
}
