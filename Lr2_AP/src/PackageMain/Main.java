package PackageMain;

import PackageCar.*;
/*
* 1. Створити проект, що складається з двох класів: основного (PackageMain.Main) та класу для представлення об’єкта відповідно специфікації,
* що наведена у варіанті індивідуального завдання. Кожний клас повинен бути розміщений у окремому пакеті.
* У створеному класі визначити приватні поля для зберігання указаних даних,
* конструктори для створення об’єктів та відкриті методи setValue(), getValue(), toString() для доступу до полів об’єкту.
2. В основному класі програми визначити методи, що створюють масив об'єктів.
* Задати критерії вибору даних та вивести ці дані на консоль ( використати метод toString() ).
* Для кожного критерію створити окремий метод.
3. Виконати програму, та пересвідчитись, що дані зберігаються та коректно виводяться на екран відповідно до вказаних критеріїв.
*
Car: id, Модель, Рік випуску, Ціна, Реєстраційний номер.
Скласти масив об'єктів. Вивести:
a) список автомобілів заданої моделі;
b) список автомобілів заданої моделі, які експлуатуються більше n років;
c) список автомобілів заданого року випуску, ціна яких більше вказаної.

* */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;
public class Main
{
    /**
     * Створення масиву автомобілів
     * @param size - кількість автомобілів
     * @return Array - масив автомобілів
     * @throws Exception
     */
    static Car[] CreateArrayOfObjects(int size) throws Exception
    {
        File file = new File("D:\\Data1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Car[] Array = new Car[size];
        for (int i = 0; i < size; i++) // заповнення масиву даними
        {
            Array[i] = new Car();
            Array[i].setId(br.readLine());
            Array[i].setModel(br.readLine());
            Array[i].setYear(Integer.parseInt(br.readLine()));
            Array[i].setPrice(Integer.parseInt(br.readLine()));
            Array[i].setReg_Numb(br.readLine());
        }
        for (int i = 0; i < size; i++) // вивід всіх машин
        {
            System.out.println(Array[i]);
        }
        br.close();
        return Array;
    }
    /**
     * Пошук списку автомобілів заданої моделі
     * @param scanner - сканер вводу
     * @param size - кількість автомобілів
     * @param Array - масив автомобілів
     */
    static void SearchModel(Scanner scanner, int size, Car[] Array)
    {
        System.out.print("\nSearch 1:\nEnter the model: ");
        String model = scanner.nextLine(); // ввід моделі
        for (int i = 0; i < size; i++) // пошук моделі
        {
            if (Objects.equals(model, Array[i].getModel())) // умова на вивід
            {
                System.out.println(Array[i]);
            }
        }
    }

    /**
     * Пошук списку автомобілів заданої моделі, які експлуатуються більше n років
     * @param scanner - сканер вводу
     * @param size - кількість автомобілів
     * @param Array - масив автомобілів
     */
    static void SearchModelN(Scanner scanner, int size, Car[] Array)
    {

        System.out.print("\nSearch 2:\nEnter the model: ");
        String model = scanner.nextLine(); // ввід моделі
        System.out.print("Enter the age of the car: ");
        int n = scanner.nextInt(); // ввід кількості років експлуатації
        for (int i = 0; i < size; i++)
        {
            if (Objects.equals(model, Array[i].getModel()) && (2022 - Array[i].getYear() > n)) // умова на вивід
            {
                System.out.println(Array[i]);
            }
        }
    }



    /**
     * Пошук списку автомобілів заданого року випуску, ціна яких більше вказаної.
     * @param scanner - сканер вводу
     * @param size - кількість автомобілів
     * @param Array - масив автомобілів
     */
    static void SearchYearPrice(Scanner scanner, int size, Car[] Array)
    {
        System.out.print("\nSearch 3:\nEnter the year: ");
        int year = scanner.nextInt(); // ввід року випуску авто
        System.out.print("Enter the price: ");
        int price = scanner.nextInt(); // ввід вартості машини
        for (int i = 0; i < size; i++)
        {
            if (Array[i].getPrice()>price && Array[i].getYear() == year) // умова на вивід
            {
                System.out.println(Array[i]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int size = 6;
        Car[] Array = CreateArrayOfObjects(size);
        Scanner scanner = new Scanner(System.in);
        SearchModel(scanner, size, Array);
        SearchModelN(scanner, size, Array);
        SearchYearPrice(scanner, size, Array);
    }
}