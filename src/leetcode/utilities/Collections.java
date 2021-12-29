package leetcode.utilities;

import java.util.ArrayList;
import java.util.List;

public class Collections {
    public <T> List<T> asList(T ... items) {
        List<T> list = new ArrayList<T>();
        for (T item : items) {
            list.add(item);
        }

        return list;
    }
}
