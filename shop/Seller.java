package shop;

import java.util.Scanner;

public class Seller extends Human {
    private int salary; // Зарплата
    static int sellers_cntr = 0;    //Счетчик

    public Seller(){       // Конструктор без параметров
        salary = 0;
        sellers_cntr+=1;
    };

    public Seller(String name, String phone, int salary) {    //С параметрами
        super(name, phone);
        this.salary = salary;
        sellers_cntr+=1;
    }
    //Методы получения/установления зарплаты
    public int getSalary() {       // Метод для получения информации о зарплате
        return salary;
    }

    public void setSalary(int salary) {     // Метод для установки информации о зарплате
        this.salary = salary;
    }

    public static int getSellers_Cntr(){return sellers_cntr;}   //получение счетчика
    public static void fire(){sellers_cntr-=1;}     //изм-е счетчика при увольнении

    public Seller(Seller seller){
        super(seller.getName(), seller.getPhone());
        this.salary = seller.salary;
    }

    // Метод вывода информации о сотруднике
    public void outSeller(){
        System.out.println("Продавец: " + getName() + "  Телефон: " +getPhone()+"  Зарплата: "+getSalary());
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