/*
11. Страхування. Визначити ієрархію страхових зобов’язань. Зібрати із зобов’язань
дериватив. Підрахувати вартість. Здійснити сортування зобов’язань у деривативі на
основі зменшення рівня ризику. Знайти зобов’язання у деривативі, що відповідає
заданому діапазону параметрів.
*/

import commands.*;
import menu.DoMenu;
import menu.StartMenu;
import solution.Solution;
import user.User;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.solve();

    }
}
