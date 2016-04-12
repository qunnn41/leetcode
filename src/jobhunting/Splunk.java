
import java.math.BigInteger;

class Splunk {
    public boolean solution(String S, String T) {
        char[] s_arr = S.toCharArray();
        char[] t_arr = T.toCharArray();

        int s_pointer = 0, t_pointer = 0;
        while (s_pointer < s_arr.length && t_pointer < t_arr.length) {
//            System.out.println(S.substring(s_pointer) + "\t" + T.substring(t_pointer));
            if (Character.isLetter(s_arr[s_pointer]) && Character.isLetter(t_arr[t_pointer])) {
                if (s_arr[s_pointer] != t_arr[t_pointer])
                    return false;
                s_pointer ++;
                t_pointer ++;
            } else if (Character.isDigit(s_arr[s_pointer]) && Character.isDigit(t_arr[t_pointer])) {
                int s_p = s_pointer, t_p = t_pointer;
                while (s_p < s_arr.length && Character.isDigit(s_arr[s_p]))
                    s_p++;
                BigInteger s_int = new BigInteger(S.substring(s_pointer, s_p));
                while (t_p < t_arr.length && Character.isDigit(t_arr[t_p]))
                    t_p ++;
                BigInteger t_int = new BigInteger(T.substring(t_pointer, t_p));
                BigInteger diff = s_int.add(t_int.negate());
                if (diff.equals(BigInteger.ZERO)) {
                    s_pointer = s_p;
                    t_pointer = t_p;
                } else if (diff.equals(diff.abs())) {//s > t
                    S = diff + S.substring(s_p);
                    s_arr = S.toCharArray();
                    s_pointer = 0;
                    t_pointer = t_p;
                } else {
                    T = diff.abs() + T.substring(t_p);
                    t_arr = T.toCharArray();
                    t_pointer = 0;
                    s_pointer = s_p;
                }
            } else if (Character.isDigit(s_arr[s_pointer]) && Character.isLetter(t_arr[t_pointer])){
                int t_p = t_pointer, s_p = s_pointer;
                BigInteger num = new BigInteger("0");
                while (t_p < t_arr.length && Character.isLetter(t_arr[t_p])) {
                    t_p++;
                    num = num.add(BigInteger.ONE);
                }
                while (s_p < s_arr.length && Character.isDigit(s_arr[s_p]))
                    s_p++;
                BigInteger s_int = new BigInteger(S.substring(s_pointer, s_p));
                BigInteger diff = s_int.add(num.negate());
                if (diff.equals(BigInteger.ZERO)) {
                    s_pointer = s_p;
                    t_pointer = t_p;
                } else if (diff.equals(diff.abs())) {//s > t
                    S = diff + S.substring(s_p);
                    s_arr = S.toCharArray();
                    s_pointer = 0;
                    t_pointer = t_p;
                } else {
                    while (!s_int.equals(BigInteger.ZERO)) {
                        s_int = s_int.add(BigInteger.ONE.negate());
                        t_pointer ++;
                    }
                    s_pointer = s_p;
                }
            } else {//switch
                String temp = S;
                S = T;
                T = temp;
                s_arr = S.toCharArray();
                t_arr = T.toCharArray();
                int t = s_pointer;
                s_pointer = t_pointer;
                t_pointer = t;
            }
        }

        return s_pointer == s_arr.length && t_pointer == t_arr.length;
    }
    public static void main(String[] args) {
        System.out.println(new Splunk().solution("a2le", "2pl"));
        System.out.println(new Splunk().solution("1020", "dc1008u9"));
    }
}