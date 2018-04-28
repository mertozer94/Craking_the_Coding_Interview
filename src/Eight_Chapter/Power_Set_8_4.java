package Eight_Chapter;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;

/**
 * @author Mert Ozer
 * Write a method to return all subsets of a set.
 */
public class Power_Set_8_4 {
    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        ArrayList<ArrayList<Integer>> array = getSubsets(arrayList,0);
        System.out.println("q");
    }
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
            ArrayList<ArrayList<Integer>> allsubsets;
            if (set.size() == index) { // Base case - add empty set
                allsubsets = new ArrayList<ArrayList<Integer>>();
                allsubsets.add(new ArrayList<Integer>()); // Empty set
            }
            else {
                allsubsets = getSubsets(set, index + 1);
                int item = set.get(index);
                ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
                for (ArrayList<Integer> subset : allsubsets) {
                    ArrayList<Integer> newsubset = new ArrayList<Integer>();
                    newsubset.addAll(subset); //
                    newsubset.add(item);
                    moresubsets.add(newsubset);
                }
                allsubsets.addAll(moresubsets);
            }
            return allsubsets;
    }
}
