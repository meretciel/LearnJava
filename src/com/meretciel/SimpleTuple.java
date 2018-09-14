package com.meretciel;

public class SimpleTuple {
    private Object[] _data;
    public SimpleTuple(Object... data) {_data = data;}
    public <T> T get(int n ) {return (T) _data[n];}

    public static void main(String[] args) {
        SimpleTuple t0 = new SimpleTuple();

        SimpleTuple t1 = new SimpleTuple("string argument");
        String s1 = t1.get(0);
        System.out.println("s1 = " + s1);

        SimpleTuple t2 = new SimpleTuple("string argument", 20);
        String s2 = t2.get(0);
        int i2 = t2.get(1);
        System.out.println("s2 = " + s2);
        System.out.println("i2 = " + i2);
    }
}
