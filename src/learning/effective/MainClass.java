package learning.effective;

import work.test.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chenstyle
 * @date 2016/10/20 0020
 * @time 14:15
 */
public class MainClass<T> {

    public static void main(String[] args) {
        int bean = 78547;
        long hehe = 14_524_175_242L;

        System.out.println(StrUtil.lotteryBeanFormat(bean));
    }

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
