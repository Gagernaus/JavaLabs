package Lab2;

import Lab2.LList;

public class MergeTest {
    public static void main(String[] args) {
        LList a = new LList();
//        for (int i = 4; i < 10; ++i) {
//            a.add(i);
//        }
        a.add(-10);
        a.add(3);
        a.add(5);
        a.add(34);
        LList b = new LList();
        for (int i = -3; i < 2; ++i) {
            b.add(i);
        }
        System.out.println(a.toString());
        System.out.println(b.toString());
        LList c = new LList(LList.merge(a.getHead(), b.getHead()));
        System.out.println(c.toString());
    }
}
