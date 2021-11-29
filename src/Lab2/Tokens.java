package Lab2;

import Lab1.List;
import Lab2.LList;

public class Tokens {

    public static void main(String[] args) {
        String str = args[0];
        List tokens = new List();
        List count = new List();
        int i = 0;
        String tmp = "";
        char ch;
        char space = " ".charAt(0);
        do {
            ch = str.charAt(i);
            if (ch != space) {
                tmp += ch;
            } else {
                int index = tokens.indexOf(tmp);
                if (index == -1) {
                    tokens.add(tmp);
                    count.add(1);
                } else {
                    count.set((int) count.get(index) + 1, index);
                }
                tmp = "";
            }
            ++i;
        } while (i < str.length());
        i = tokens.indexOf(tmp);
        if (i == -1) {
            tokens.add(tmp);
            count.add(1);
        } else {
            count.set((int) count.get(i) + 1, i);
        }
        for (int j = 0; j < tokens.size(); ++j) {
            System.out.println(tokens.get(j) + ":" + count.get(j));
        }
        String str1 = "";
        for (int j = 0; j < tokens.size(); ++j) {
            str1 += (String) tokens.get(j);
            if (j != (int) tokens.size() - 1) {
                str1 += " ";
            }
        }
        System.out.println(str);
        System.out.println(str1);

    }

}
