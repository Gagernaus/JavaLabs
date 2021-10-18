package Lab1;

import Lab1.List;
import Lab1.Map;

public class MapTest {
    public static void main(String[] args) {
        Map m1 = new Map();
        if (m1.isEmpty() && m1.size() == 0) {
            System.out.println("Empty constructor success");
        } else System.out.println("Empty constructor failure");
        m1.put(1, 11);
        m1.put(2, 22);
        m1.put(3, 33);
        if (m1.size() == 3) {
            System.out.println("Put resize success");
        } else System.out.println("Put resize failure");
        boolean flag = true;
        for (int i = 1; i <= 3; ++i) {
            if (i * 11 != (int) m1.get(i)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Put success");
        } else System.out.println("Put failure");
        Object[] k1 = {1, 2, 3};
        Object[] v1 = {11, 22, 33};
        Map m2 = new Map(k1, v1);
        if (m1.size() == 3) {
            System.out.println("Object[],Object[] constructor size success");
        } else System.out.println("Object[],Object[] constructor size failure");
        flag = true;
        for (int i = 0; i < 3; ++i) {
            if (!(m2.keyContains(k1[i])) && !((int) m2.get(k1[i]) == (int) v1[i])) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Object[],Object[] constructor success");
        } else System.out.println("Object[],Object[] constructor failure");
        if ((int) m1.get(1) == 11) {
            System.out.println("Get correct success");
        } else System.out.println("Get correct failure");
        if (m1.get("a") == null) {
            System.out.println("Get incorrect success");
        } else System.out.println("Get incorrect failure");
        Object a = m1.get(1, 123);
        if (a.equals(11) && m1.get(1).equals(11)) {
            System.out.println("Get byDeafult correct success");
        } else System.out.println("Get bydefault correct failure");
        a = m1.get(5, 444);
        if (m1.keyContains(5) && a.equals(444) && (m1.get(5).equals(444))) {
            System.out.println("Get byDefalut incorrect success");
        } else System.out.println("Get byDefalut incorrect failure");
        m1.put(5, null);
        a = m1.get(5, 55);
        if (m1.get(5).equals(55) && a.equals(55)) {
            System.out.println("Get byDefalut null success");
        } else System.out.println("Get byDefalut null failure");
        a = m1.remove(5);
        if (a.equals(55) && !m1.keyContains(5)) {
            System.out.println("Remove success");
        } else System.out.println("Remove failure");
        Lab1.List l1 = m1.getKeys();
        Lab1.List l2 = m1.getValues();
        List l3 = m1.getEntries();
        flag = true;
        for (int i = 0; i < 3; ++i) {
            if (!k1[i].equals(l1.get(i))) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Get keys success");
        } else System.out.println("Get keys failure");
        flag = true;
        for (int i = 0; i < 3; ++i) {
            if (!v1[i].equals(l2.get(i))) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Get values success");
        } else System.out.println("Get values failure");
        flag = true;
        Pair[] pairs = new Pair[3];
        for (int i = 0; i < 3; ++i) {
            pairs[i] = new Pair();
        }
        pairs[0].setFirst(1);
        pairs[0].setSecond(11);
        pairs[1].setFirst(2);
        pairs[1].setSecond(22);
        pairs[2].setFirst(3);
        pairs[2].setSecond(33);
        for (int i = 0; i < 3; ++i) {
            if (!pairs[i].equals((Pair) l3.get(i))) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Get entries success");
        } else System.out.println("Get entries failure");
    }
}
