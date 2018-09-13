package com.meretciel;


import java.util.Arrays;

public class Tuple {

    private final int _length;
    private final Object _singleElement;
    private final Pair<Tuple, Tuple> _data;

    private class Pair<A,B> {
        private final A _first;
        private final B _second;
        public A getFirst() {return _first;}
        public B getSecond() {return _second;}
        public Pair(A first, B second) {
            _first = first;
            _second = second;
        }
    }


    public Tuple(Object... args) {
        _length = args.length;

        if (_length == 0) {
            _data = null;
            _singleElement = null;
        }
        else if (_length == 1) {
            _data = null;
            _singleElement = args[0];
        }
        else {
            Tuple first    = new Tuple(args[0]);
            Tuple second   = new Tuple(Arrays.copyOfRange(args,1, _length));
            _data          = new Pair(first, second);
            _singleElement = null;
        }
    }

    public <V> V get(int n) {
        if (n >= _length) {throw new RuntimeException("Out of bound.");}

        if (n == 0) {
            return (_length > 1) ? _data.getFirst().get(0) : (V) _singleElement;

        } else {
            return _data.getSecond().get(n-1);
        }
    }
}
