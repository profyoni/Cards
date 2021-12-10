package edu.touro.cs.mcon264;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class HashFun
{
    byte b;  int x; short s; long l; // int types
    char c;
    double d;   float f; // floating
    boolean bo;
    String st;
// var args for any class T that implements Comparable<T>
    // implement hashSet
    // add call hashCode % bs.length imnsert into LinkedList in that location
    // contains hash and then conatins method in LL

    static int maximum(int a, int b)
    {
        return a > b ? a : b;
    }


    static int maximum(int... list) {  // var args, variable number of args
                                        // list is same as int list[]
        int max = list[0];
        for (int i=1;i<list.length;i++)
        {
            if (list[i] > max)
                max=list[i];
        }
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashFun hashFun = (HashFun) o;
        return b == hashFun.b && x == hashFun.x && s == hashFun.s && l == hashFun.l && c == hashFun.c && Double.compare(hashFun.d, d) == 0 && Float.compare(hashFun.f, f) == 0 && bo == hashFun.bo && Objects.equals(s, hashFun.s);
    }

    @Override
    public int hashCode() {
        int ret = 1;
        ret = ret * 37 + b;
        ret = ret * 37 + s;
        ret = ret * 37 + x;
        ret = ret * 37 + (int)l; // low order 32 bits
        ret = ret * 37 + (int) (l >> 32); // high order 32 bits shifted to right 32
        //  ret = ret * 37 + (int)l ^ (int) (l >> 32); Effective Java
        ret = ret * 37 + (bo ? 1 : 0);
        ret = ret * 37 + c;

        ret = ret * 37 +  Float.floatToIntBits(f);
        ret = ret * 37 +  (int) Double.doubleToLongBits(d) ^ (int) (Double.doubleToLongBits(d) >> 32) ;

        ret = ret * 37 + (st == null ? 0 : st.hashCode()); // delegate

        return ret;
    }
}

class MyString
{
    char chars[]; // ABBA




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString = (MyString) o;
        return Arrays.equals(chars, myString.chars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(chars);
    }
}
class Card{
    public Card(Weekday w, DreidelSpin ds)
    {

    }
}
class Telephone
{
    Telephone(String n)
    {
        this.number = n;
    }
    public String number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telephone telephone = (Telephone) o;
        return Objects.equals(number, telephone.number);
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(number);
//    }
}
public class Main {

    // static factory
    public static List<Card> createDeck()
    {
        return null;
    }

    public static void main(String[] args) {



        Weekday w = null;
        w = Weekday.Monday;
        System.out.println(w);



        int pot = 10, p1 = 5, p2 = 5;
        for (int i=0;i<5;i++)
        {
            int r = (int)(Math.random() * 4);
            DreidelSpin ds = DreidelSpin.values()[r];
            System.out.println(ds);
            switch(ds)
            {
                case Gimmel:
                    p1 += pot;
                    pot = 0;
                    break;
                case Shin:

            }
        }
    }
}
