package shop;

import java.util.Scanner;

public class Buyer extends Human {
    public Buyer(){ };  // Конструктор без параметров

    public Buyer(String name, String phone){     //с параметрами
        super(name,phone);
    }

    // Метод ввода информации о покупателе
    public void inBuyer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        setName(scanner.nextLine());

        System.out.print("Введите телефон: ");
        setPhone(scanner.nextLine());
    }

    // Метод вывода информации о покупателе
    public void outBuyer() {
        System.out.println("Покупатель:" + getName() + "  Телефон: " + getPhone());
    }
}