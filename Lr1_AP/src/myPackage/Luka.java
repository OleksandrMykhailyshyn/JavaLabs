package myPackage;

/**
 * Клас чисел Люка з полями <b>data</b> і <b>number</b>
 * @author Михайлишин Олександр
 */
public class Luka
{
    /** Поле значення числа Люка */
    private long data;
    /** Поле номер числа Люка */
    private int number;

    /**
     * Функція отримання поля {@link Luka#data}
     * @return data - значення числа Люка
     */
    public long getData() {
        return data;
    }
    /**
     * Функція отримання поля {@link Luka#number}
     * @return number - номер числа Люка
     */
    public int getNumber() {
        return number;
    }

    /**
     * Функція задання поля {@link Luka#data}
     * @param data значення числа Люка
     */
    public void setData(long data) {
        this.data = data;
    }

    /**
     * Функція задання поля {@link Luka#number}
     * @param number номер числа Люка
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Конструктор за параметрами
     * @param data значення числа Люка
     * @param number номер числа Люка
     */
    Luka(long data, int number)
    {
        this.data = data;
        this.number = number;
    }

}
