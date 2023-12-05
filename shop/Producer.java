package shop;

import shop.Human;

import java.util.Scanner;

public class Producer extends Human {
    public Producer(){ };// Конструктор без параметров

    public Producer(String name, String phone) {    //С параметрами
        super(name, phone);
    }

    // Метод вывода информации о производителе
    public void outProducer(){
        System.out.println("Производитель: " + getName() + "  Телефон: " +getPhone());}

    // Метод ввода информации о производителе
    public void inProducer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        setName(scanner.nextLine());

        System.out.print("Введите телефон: ");
        setPhone(scanner.nextLine());
    }
}