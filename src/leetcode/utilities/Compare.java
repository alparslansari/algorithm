package leetcode.utilities;

import java.util.List;

public class Compare {

    public boolean compareIntArrayWithList(int[] expected, List<Integer> result){
        if(expected.length != result.size())
        {
            return false;
        }
        boolean isEqual = true;
        for(int i=0;i<expected.length;i++)
        {
            if(expected[i] != result.get(i))
            {
                isEqual = false;
                break;
            }
        }
        return isEqual;
    }
}
