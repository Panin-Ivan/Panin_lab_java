package shop;

import java.util.Scanner;

public class Product {
    private Producer producer;  //производитель
    private String Name_Product; // Наименование товара
    private int price; // Цена товара
    private int quantity; // Кол-во товара
    static int products_cntr = 0;  //счетчик

    public String getName_Product(){return Name_Product;}
    public int getPrice(){return price;}
    public int getQuantity(){return quantity;}
    public static int getProducts_cntr(){return products_cntr;}   //получение счетчика
    public Producer getProducer(){return producer;}

    public void setName_Product(String Name_Product){ this.Name_Product=Name_Product;}
    public void setPrice(int price){ this.price=price;}
    public void setQuantity(int quantity){ this.quantity=quantity;}

    // Конструктор без параметров
    public Product(){
        this.Name_Product = "product_name";
        this.price = 0;
        this.quantity = 0;
        products_cntr += 1;
    };

    //с параметрами
    public Product(String name, String phone, String Name_product, int price, int quantity){
        this.producer.setName(name);
        this.producer.setName(phone);
        this.Name_Product = Name_product;
        this.price = price;
        this.quantity = quantity;
        products_cntr += 1;
    }

    public Product(Product product){
        this.producer.setName(product.producer.getName());
        this.producer.setPhone(product.producer.getPhone());
        this.Name_Product = product.getName_Product();
        this.price = getPrice();
        this.quantity = getQuantity();
        products_cntr += 1;
    }

    public void inProduct(Producer producer){
        this.producer.setName(producer.getName());
        this.producer.setPhone(producer.getPhone());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите наименование: ");
        setName_Product(scanner.nextLine());

        System.out.print("Введите цену: ");
        setPrice(scanner.nextInt());

        System.out.print("Введите кол-во: ");
        setQuantity(scanner.nextInt());
    }

    public void outProduct(){
        System.out.println("Наименование: "+ getName_Product()+"  Цена: "+getPrice() +"  Кол-во: "+getQuantity()+ "  Имя производителя: " +this.producer.getName() + "  Телефон: "+this.producer.getPhone());
    }
}