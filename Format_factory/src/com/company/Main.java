package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {
       // System.out.println(Util.getInfo());
       // System.out.println("int size: " + Util.getMemInt());
       // System.out.println(Util.getInfo());
       // System.out.println("Long size: " + Util.getMemLong());
       // System.out.println(Util.getInfo());
       // System.out.println("Boolean size: " + Util.getMemBoolean());
       // System.out.println(Util.getInfo());
       // System.out.println("Char size: " + Util.getMemChar());
       // System.out.println(Util.getInfo());
       // System.out.println("Byte size: " + Util.getMemByte());
       // System.out.println(Util.getInfo());
       // System.out.println("Short size: " + Util.getMemShort());
       // System.out.println(Util.getInfo());
       // System.out.println("Float size: " + Util.getMemFloat());
       // System.out.println(Util.getInfo());
       // System.out.println("Double size: " + Util.getMemDouble());
       // System.out.println(Util.getInfo());
       // System.out.println("String char:" + Util.StringObjects(() -> new String(new char[0])));
       // System.out.println(Util.getInfo());
       // System.out.println("String byte:" + Util.StringObjects(() -> new String(new byte[0])));
       // System.out.println(Util.getInfo());
       // System.out.println("Object size:" + Util.getMemObject(1));
       // System.out.println(Util.getInfo());
       // System.out.println("Integer byte:" + Util.mem(() -> new Integer(4)));
       // System.out.println(Util.getInfo());
       // System.out.println("Boolean byte:" + Util.mem(() -> new Boolean(true)));
       // System.out.println(Util.getInfo());
       // System.out.println("ArrayList byte:" + Util.mem(() -> new ArrayList()));
       // System.out.println(Util.getInfo());
       // System.out.println("ArrayList10 byte:" + Util.mem(() -> new ArrayList(10)));
       // System.out.println(Util.getInfo());
       // System.out.println("HashMap byte:" + Util.mem(() -> new HashMap()));
       // System.out.println(Util.getInfo());
       // System.out.println("Class byte:" + Util.mem(() -> new Character('s')));
        System.out.println(Util.getInfo());
        System.out.println("String byte:" + Util.StringObjects(() -> new String(new byte[0])));
        System.out.println(Util.getInfo());
        System.out.println("String byte:" + Util.mem(() -> new String(new byte[0])));


    }

}
