/*
1. Створіть базовий клас droid.Droid, від якого будуть походити інші підкласи (види дроїдів),
які будуть відрізнятися різними характеристиками. Мінімальний набір характеристик: name, health, damage.
2. Додайте можливість різних видів бою: 1 на 1, або команда на команду.
3. Класи потрібно грамотно розкласти по пакетах.
4. У програмі має бути консольне меню. Мінімальний набір команд:
− створити дроїда (обраного виду);
− показати список створених дроїдів;
− запустити бій 1 на 1 (вибрати дроїдів, які будуть змагатися);
− запустити бій команда на команду (сформувати команди суперників з дроїдів, яких ви створили у першому пункті);
− записати проведений бій у файл;
− відтворити  проведений бій зі збереженого файлу;
− вийти з програми.

*/
import area.BattleArea;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter the number of members in your team: ");
        final int inNumb = myScanner.nextInt();
        BattleArea.FN(inNumb);
        /*if (inNumb == 1)
        {
            area.BattleArea.F1();
        } else if (inNumb>1) {
            area.BattleArea.FN(inNumb);
        } else {
            System.out.println("Error!");
        }*/


    }
}