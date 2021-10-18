package Lab1;

import Lab1.List;

public class ListTest {

    public static void main(String[] args) {
        Object[] arr1 = {1, 2, 3, 4, 5};
        List l1 = new List(arr1);
        boolean flag = true;
        if (l1.size() != 5) {
            System.out.println("Object[] constructor size failure");
        } else System.out.println("Object[] constructor size success");
        for (int i = 0; i < l1.size(); ++i) {
            if (!arr1[i].equals(l1.get(i))) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println("Object[] constructor container failure");
        } else System.out.println("Object[] constructor container success");

        /////////////////////////////////////////////////////////////////////

        flag = true;
        int index = -1;
        for (int i = 0; i < l1.size(); ++i) {
            if (!l1.contains(arr1[i])) {
                index = i;
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println("Contains failure at " + index);
        } else System.out.println("Contains success");

        /////////////////////////////////////////////////////////////////////

        l1.add(6);
        if (l1.size() != 6) {
            System.out.println("Add size change failure");
        } else System.out.println("Add size change success");
        if (!l1.contains(6)) {
            System.out.println("Add failure 1");
        } else System.out.println("Add success 1");
        if (!l1.get(5).equals(6)) {
            System.out.println("Add failure 2");
        } else System.out.println("Add success 2");

        List l2 = new List(l1);
        if (l2.size() != 6) {
            System.out.println("Copy constructor size failure");
        } else System.out.println("Copy constructor size success");
        flag = true;
        for (int i = 0; i < l1.size(); ++i) {
            if (!l1.get(i).equals(l2.get(i))) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println("Copy constructor container failure");
        } else System.out.println("Copy constructor container success");

        /////////////////////////////////////////////////////////////////////

        flag = true;
        Object a = l1.remove(12);
        if (!a.equals(6)) {
            System.out.println("Remove return failure");
        } else System.out.println("Remove return success");
        for (int i = 0; i < l1.size(); ++i) {
            if (!arr1[i].equals(l1.get(i))) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println("Remove index>=size-1 failure");
        } else System.out.println("Remove index>=size-1 success");
        l1.remove(-236324);
        flag = true;
        for (int i = 1; i < l1.size() + 1; ++i) {
            if (!arr1[i].equals(l1.get(i - 1))) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println("Remove index<=0 failure");
        } else System.out.println("Remove index<=0 success");
        l1.remove(1);
        if (l1.contains(3) && !l1.contains(2) && !l1.contains(4) && !l1.contains(5)) {
            System.out.println("Remove 0<index<length failure");
        } else System.out.println("Remove 0<index<length success");

        /////////////////////////////////////////////////////////////////////

        l1.add(1, -12);
        if (l1.size() != 4) {
            System.out.println("Add at resize failure");
        } else System.out.println("Add at resize success");
        if (!l1.contains(1) && !l1.contains(2) && !l1.contains(4) && !l1.contains(5) || l1.contains(3)) {
            System.out.println("Add at index<=0 failure");
        } else System.out.println("Add at index<=0 success");
        l1.add(3, 2);
        flag = true;
        for (int i = 0; i < l1.size(); ++i) {
            if (!arr1[i].equals(l1.get(i))) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println("Add at 0<index<length failure");
        } else System.out.println("Add at 0<index<length success");
        l1.add(6, 999);
        flag = true;
        for (int i = 0; i < l1.size(); ++i) {
            if (!l1.get(i).equals(l2.get(i))) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println("Add at index>=length failure");
        } else System.out.println("Add at index>=length success");

        /////////////////////////////////////////////////////////////////////

        int b = l1.indexOf(6);
        if (b != 5) {
            System.out.println("Index of correct failure");
        } else System.out.println("Index of correct success");
        int c = l1.indexOf(123);
        if (c != -1) {
            System.out.println("Index of incorrect failure");
        } else System.out.println("Index of incorrect success");

        /////////////////////////////////////////////////////////////////////

        a = l1.set(7, -1);
        if (!a.equals(1)) {
            System.out.println("Set index<=0 return failure");
        } else System.out.println("Set index<=0 return success");
        if (!l1.get(0).equals(7)) {
            System.out.println("Set index<=0 failure");
        } else System.out.println("Set index<=0 success");
        a = l1.set(7, 3);
        if (!a.equals(4)) {
            System.out.println("Set 0<index<length return failure");
        } else System.out.println("Set 0<index<length return success");
        if (!l1.get(3).equals(7)) {
            System.out.println("Set 0<index<length failure");
        } else System.out.println("Set 0<index<length success");
        a = l1.set(7, 999);
        if (!a.equals(6)) {
            System.out.println("Set index>=length return failure");
        } else System.out.println("Set index>=length return success");
        if (!l1.get(5).equals(7)) {
            System.out.println("Set index>=length failure");
        } else System.out.println("Set index>=length success");

        /////////////////////////////////////////////////////////////////////

        List l3 = new List();
        if (!l3.isEmpty()) {
            System.out.println("Empty constructor failure");
        } else System.out.println("Empty constructor success");
    }
}

