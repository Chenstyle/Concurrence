package work.test.bean;

import java.util.ArrayList;
import java.util.List;

public class LabList<T> {
    public List<T> getList(List<T> list, int index) {
        List<T> labList = new ArrayList<T>();
        int count = index * 20;
        if (list.size() < 20 || index > 5) {
            return list;
        } else {
            for (int i = 0; i < count; i++) {
                labList.add(list.get(i));
            }
            return labList;
        }
    }
}