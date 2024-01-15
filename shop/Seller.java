package shop;

import java.util.Scanner;

public class Seller extends Human implements PhoneCall{
    private int salary; // Зарплата
    static int sellers_cntr = 0;    //Счетчик
    private int id_seller;

    public Seller(){       // Конструктор без параметров
        salary = 0;
        sellers_cntr+=1;
        id_seller = sellers_cntr;
    };

    public Seller(String name, String phone, int salary) {    //С параметрами
        super(name, phone);
        this.salary = salary;
        sellers_cntr+=1;
        id_seller = sellers_cntr;
    }
    //Методы получения/установления зарплаты
    public int getSalary() {       // Метод для получения информации о зарплате
        return salary;
    }

    public void setSalary(int salary) {     // Метод для установки информации о зарплате
        this.salary = salary;
    }

    public int getId_seller(){ return id_seller;}

    public Seller(Seller seller){
        super(seller.getName(), seller.getPhone());
        this.salary = seller.salary;
    }

    // Метод вывода информации о сотруднике
    @Override
    public String toString() {
        return "Продавец: " + getName() + "  Телефон: " +getPhone()+"  Зарплата: "+getSalary()+"  id: "+ id_seller;
    }

    public String Call(){ return getPhone();}

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