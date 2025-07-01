package org.top;


import org.top.strings.CustomText;

public class Main {


    public static void main(String[] args) {
        CustomText text = new CustomText("привет мир", " ");

        System.out.println(text.getTextToken(0)); // привет
        System.out.println(text.getTextToken(1)); // мир

        text.insertStr("hello world", 0);

        System.out.println(text.getTextToken(0)); // hello
        System.out.println(text.getTextToken(1)); // worldпривет
    }
}
