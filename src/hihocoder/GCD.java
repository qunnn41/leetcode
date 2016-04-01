package hihocoder;

/**
 * Created by wyq on 4/1/16.
 */
public class GCD {
    int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    int gcd2(int x, int y) {
        if (x < y)
            return gcd2(y, x);
        return y == 0 ? x : gcd(x - y, y);
    }

    int gcd3(int x, int y) {
        if (x < y)
            return gcd3(y, x);
        if (y == 0)
            return x;
        if (isEven(x)) {
            if (isEven(y))
                return gcd3(x >> 1, y >> 1) << 1;
            else
                return gcd3(x >> 1, y);
        } else {
            if (isEven(y)) {
                return gcd3(x, y >> 1);
            } else {
                return gcd(y, x - y);
            }
        }
    }

    boolean isEven(int x) {
        return (x & 0x1) == 0;
    }
}
