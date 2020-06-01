package lx.renthouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(getStrReverse(str, 3));
        System.out.println(getStrLength(str));
    }
    /* 反转指定长度字符串 Reverses the specified length string*/
    public static String getStrReverse(String str,int len){
        // 检查输入长度len是否合法  Check whether the input length len is legal
        if (len>getStrLength(str)){
            return "error";
        }
        String reverse="";
        List<Character> charList = new ArrayList<>();
        //反转0-len之间的字符串 Invert string between 0-len
        for(int i=len-1; i>=0; i--){
            reverse+=str.charAt(i);
        }
        for (int j=len;j<getStrLength(str);j++){

            reverse+=str.charAt(j);
        }
        return reverse;
    }
    public static int getStrLength(String str) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);
            if (temp.matches(chinese)) {
                valueLength += 2;
            } else {
                valueLength += 1;
            }
        }
        return valueLength;
    }
}

