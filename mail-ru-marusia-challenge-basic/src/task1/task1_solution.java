package task1;

import java.util.Scanner;

/**
 *  created by malevinsky
 *  email: malevinskaya2000@gmail.com
 *  telegram: @theos_deus
 *  date: 25.08.2020
 */


public class task1_solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String value = scanner.next();
        String result = value.replaceAll("[а-яА-Я]+", "");
        int n = Integer.parseInt(result.trim());

        char[][] table = new char[n][n];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = scanner.next().charAt(0);
            }
        }

        final char X = 'x';
        final char ZERO = '0';

        Solution solver = new Solution();

        while (true) {
            if (solver.solve(X, n, table)) {
                System.out.println("x");
                break;
            }
            if (solver.solve(ZERO, n, table)) {
                System.out.println("0");
                break;
            }
            else
                System.out.println("x0");
            break;
        }
    }

    static class Solution {

        public boolean solve(int dot, int n, char[][] table) {
            int count = 0;

            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (table[i][j] == dot) {
                        while (i + 1 < n && table[i + 1][j] == dot) {
                            count++;
                            i++;
                        }
                        boolean result = check(count, n);
                        count = 0;
                        if (result)
                            return true;

                        while (i + 1 < n && j + 1 < n && table[i + 1][j + 1] == dot) {
                            count++;
                            i++;
                            j++;
                        }
                        boolean sw = check(count, n);
                        count = 0;
                        if (sw)
                            return true;

                        while (i + 1 < n && j + 1 < n && table[i][j + 1] == dot) {
                            count++;
                            j++;
                        }
                        boolean west = check(count, n);
                        count = 0;
                        if (west)
                            return true;

                        while (i + 1 <= n && j - 1 >= 0 && table[i + 1][j - 1] == dot) {
                            count++;
                            j--;
                            i++;
                        }
                        boolean se = check(count, n);
                        count = 0;
                        if (se)
                            return true;
                    }
                }
            }
            return false;
        }
        public boolean check(int count, int n) {
            return count + 1 == n;
        }
    }
}