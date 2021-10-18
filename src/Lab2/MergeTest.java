package Lab2;

import Lab2.LList;

public class MergeTest {
    public static void main(String[] args) {
        LList a = new LList();
        for (int i = 0; i < 4; ++i) {
            a.add(i);
        }
        LList b = new LList();
        for (int i = 4; i < 10; ++i) {
            b.add(i);
        }
        System.out.println(a.toString());
        System.out.println(b.toString());
        LList c = new LList(LList.merge(a.getHead(), b.getHead()));
        System.out.println(c.toString());
    }
}
