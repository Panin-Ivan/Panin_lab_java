package shop;

import java.util.Scanner;

public class Order extends Product {
    private int id;                 //номер заказа
    private String date;            //дата заказа
    private int quantityOrder;           //кол-во товара
    private boolean status;         //статус заказа
    private String name_buyer;      //имя покупателя
    private String name_seller;     //имя продавца

    public Order(){         // Пустой конструктор
        id = 0;
        date = "10.10.2023";
        quantityOrder = 0;
        status = false;
        name_buyer = "name_buyer";
        name_seller = "name_seller";
    }

    //Сетеры
    public void setId(int id) {this.id = id; }
    public void setDate(String date) {this.date = date;}
    public void setQuantityOrder(int quantity) { this.quantityOrder = quantity; }
    public void setStatus(boolean status) {this.status = status;}
    public void setName_buyer(String name_buyer) {this.name_buyer = name_buyer;}
    public void setName_seller(String name_seller) {this.name_seller = name_seller;}
    //Гетеры
    public int getId() {return id;}
    public String getDate() {return date;}
    public int getQuantityOrder() {return quantityOrder;}
    public boolean getStatus() {return status;}
    public String getName_buyer() {return name_buyer;}
    public String getName_seller() {return name_seller;}

    public void outOrder() {       //Вывод заказа
        System.out.println("id:"+id + "  Дата:" + date + "  Кол-во:" + quantityOrder + "  Статус заказа:" + status +"  Покупатель:"+ name_buyer +"  Продавец:" +name_seller);
    }

    //Добавление заказа по частям
    public void inOrder(Seller seller){
        setName_seller(seller.getName());
    }
    public void inOrder(Buyer buyer){
        setName_buyer(buyer.getName());
    }
    public void inOrder(Product product){
        setName(product.getName());
        setPhone(product.getPhone());
        setName_Product(product.getName_Product());
        setQuantity(product.getQuantity());
        setPrice(product.getPrice());
    }
    public void inOrder() {
        Scanner scanner = new Scanner(System.in);
        int qua;

        System.out.print("Введите дату: ");
        setDate(scanner.nextLine());

        System.out.print("Введите id: ");
        setId(scanner.nextInt());

        System.out.print("Введите кол-во: ");
        do {
            qua = scanner.nextInt();
            if (qua > getQuantity()) System.out.println("Столько товара нет на складе, введите меньшее число");
        } while (qua > getQuantity());
        setQuantityOrder(scanner.nextInt());

        status = false;
    }

    //Сумма заказа и ее вывод
    public void sum() {
        int sum;
        sum = quantityOrder * this.getPrice();
        System.out.println("Сумма заказа id"+id+": " + sum);
    }

}
