package shop;

import java.util.Scanner;

public class Producer extends Human {
    static int producers_cntr = 0;   //счетчик

    public Producer(){ producers_cntr += 1; };// Конструктор без параметров

    public Producer(String name, String phone) {    //С параметрами
        super(name, phone);
        producers_cntr += 1;
    }

    public static int getProducer_cntr(){return producers_cntr;}   //получение счетчика

    // Метод вывода информации о производителе
    @Override
    public String toString() {
        return "Производитель: " + getName() + "  Телефон: " +getPhone();}

    // Метод ввода информации о производителе
    public void inProducer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        setName(scanner.nextLine());

        System.out.print("Введите телефон: ");
        setPhone(scanner.nextLine());
    }
}