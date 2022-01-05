package leetcode.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DynamicArray {
    public static void main(String[] args) {
        // 1. initialize
        List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;
        // 2. Cast an array to vector
        Integer[] a = {0, 1, 2, 3, 4};
        v1 = new ArrayList<>(Arrays.asList(a));

        // 3. Make a copy of array
        List<Integer> v2 = v1; // another reference to v1 - shallow copy
        List<Integer> v3 = new ArrayList<>(v1); // Make an actual copy v1 - deep copy

        // 4. get length
        System.out.println("The size of v1 is: "+v1.size());

        // 5. access element
        System.out.println("The first element in v1 is: "+v1.get(0));

        // 6. iterate the vector
        System.out.print("[Version 1] The contents of v1 are: ");
        for(int i=0;i<v1.size();i++)
        {
            System.out.print(" "+v1.get(i));
        }
        System.out.println();
        // 7. modify element
        v2.set(0, 5); // modify v2 will actually modify v1
        System.out.println("The first element in v1 is:"+v1.get(0));
        v3.set(0, -1);
        System.out.println("The first element in v1 is:"+v1.get(0));

        // 8. Add new element to the vector
        v1.add(-1); // to the end
        v1.add(1, 6); // insert to a specific index

        // 9. delete
        v1.remove(v1.size()-1); // the last element
        v1.remove(0); // delete specific index

        // 10. sort
        Collections.sort(v1);

        // another iterate example
        System.out.println("[Version 2] The contents of v1 are:" );
        for (int item: v1){
            System.out.print(" "+item);
        }

    }
}
