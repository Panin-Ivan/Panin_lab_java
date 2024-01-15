package shop;

import java.util.Scanner;

public class Buyer extends Human {
    static int buyers_cntr = 0;   //счетчик
    public Buyer(){ buyers_cntr += 1;};  // Конструктор без параметров

    public Buyer(String name, String phone){     //с параметрами
        super(name,phone);
        buyers_cntr += 1;
    }

    @Override               //переопределение
    public void setName(String name) {
        super.setName(name);
    }

    public static int getBuyers_cntr(){return buyers_cntr;};   //счетчик

    // Метод ввода информации о покупателе
    public void inBuyer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        setName(scanner.nextLine());

        System.out.print("Введите телефон: ");
        setPhone(scanner.nextLine());
    }

    // Метод вывода информации о покупателе
    @Override
    public String toString() {
        return "Покупатель: " + getName() + "  Телефон: " + getPhone();
    }
}