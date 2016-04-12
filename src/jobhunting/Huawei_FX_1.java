import java.util.Scanner;

/**
 * Created by wyq on 4/7/16.
 */
public class Huawei_FX_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] str = input.nextLine().split(" ");
        for (int i = 0; i < str.length; ++i) {
            boolean[] visited = new boolean[str.length];
            if (dfs(str, visited, str[i], i, 1)) {
                return;
            }
        }
        System.out.println("ERROR");
    }

    private static boolean dfs(String[] str, boolean[] visited, String sb, int index, int length) {
        if (length == str.length) {
            if (sb.charAt(0) == sb.charAt(sb.length() - 1))
                System.out.println("CIRCLE");
            else
                System.out.println(sb);
            return true;
        }
        char end = str[index].charAt(3);
        visited[index] = true;
        for (int i = 0; i < str.length; ++i) {
            if (!visited[i] && i != index && str[i].charAt(0) == end) {
                if (dfs(str, visited, sb + " " + str[i], i, length + 1))
                    return true;
            }
        }

        return false;
    }
}
