package shop;

import java.util.Scanner;

public class Seller extends Human {
    private int salary; // Зарплата

    public Seller(){       // Конструктор без параметров
        this.salary = 0;
    };

    public Seller(String name, String phone, int salary) {    //С параметрами
        super(name, phone);
        this.salary = salary;
    }
    //Методы получения/установления зарплаты
    public int getSalary() {       // Метод для получения информации о зарплате
        return salary;
    }

    public void setSalary(int salary) {     // Метод для установки информации о зарплате
        this.salary = salary;
    }

    public Seller(Seller seller){
        super(seller.getName(), seller.getPhone());
        this.salary = seller.salary;
    }

    // Метод вывода информации о сотруднике
    public void outSeller(){
        System.out.print("Продавец: " + getName() + "  Телефон: " +getPhone()+"  Зарплата: "+getSalary());
    }

    // Метод ввода информации о сотруднике
    public void inSeller() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя сотрудника: ");
        setName(scanner.nextLine());

        System.out.print("Введите телефон сотрудника: ");
        setPhone(scanner.nextLine());

        System.out.print("Введите зарплату: ");
        setSalary(scanner.nextInt());
    }
}