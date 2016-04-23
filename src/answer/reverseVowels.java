package answer;

/**
 * Created by wyq on 4/23/16.
 */
public class reverseVowels {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int begin = 0, end = array.length - 1;
        while (begin < end) {
            while (begin < end && !isVowel(array[begin]))
                begin ++;
            while (begin < end && !isVowel(array[end]))
                end --;
            if (begin < end) {
                char temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
                begin ++;
                end --;
            } else {
                break;
            }
        }
        return new String(array);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
