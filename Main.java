import shop.*;

import java.util.ArrayList;
import java.util.Scanner;

class Input{        //ввод пункта из списка
    static int inInt(int lower_limit, int upper_limit){
        Scanner scanner = new Scanner(System.in);
        int selection;
        do
        {
            selection = scanner.nextInt();
            if (selection < lower_limit || selection > upper_limit)
                System.out.println("Ошибка. Введите пункт списка.");
        } while (selection < lower_limit || selection > upper_limit);
        return selection;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producer[] producers = new Producer[10];
        Seller[] sellers = new Seller[10];
        Buyer[] buyers = new Buyer[10];
        Product[] products = new Product[10];
        Order[] orders = new Order[10];
        ArrayList<Order> orders_complete = new ArrayList<Order>(); int orders_complete_cntr = 0;
        ArrayList<Seller> sellers_dismissed = new ArrayList<Seller>(); int sellers_dismissed_cntr = 0;
        int selection = 0; boolean exit = true;

        //меню
        do
        {
            System.out.println("1.Добавление\n2.Вывод\n3.Сумма заказа\n4.Выполнить заказ\n5.Уволить продавца\n6.Выход");

            selection = Input.inInt(1, 6);

            boolean exit1;
            switch (selection)
            {
                case 1:
                    do {
                        exit1 = true;
                        System.out.println("1.Добавление производителя \n2.Добавление продавца\n3.Добавление покупателя\n4.Добавление товара\n5.Добавление заказа\n6.Выход к прошлому меню");
                        System.out.print("Выберете дальнейшее действие: ");

                        selection = Input.inInt(1, 6);

                        switch (selection) {
                            case 1:
                                producers[Producer.getProducer_cntr()] = new Producer();
                                producers[Producer.getProducer_cntr()-1].inProducer();
                                break;
                            case 2:
                                sellers[Seller.getSellers_Cntr()] = new Seller();
                                sellers[Seller.getSellers_Cntr()-1].inSeller();
                                break;
                            case 3:
                                buyers[Buyer.getBuyers_cntr()] = new Buyer();
                                buyers[Buyer.getBuyers_cntr()-1].inBuyer();
                                break;
                            case 4: if (Producer.getProducer_cntr()>0){
                                for(int i=0; i<Producer.getProducer_cntr();i++)
                                {
                                    System.out.print(i+1+"|");
                                    producers[i].outProducer();
                                }

                                System.out.print("Выберите производителеля ");
                                selection = Input.inInt(1, Producer.getProducer_cntr());

                                products[Product.getProducts_cntr()] = new Product();
                                products[Product.getProducts_cntr()-1].inProduct(producers[selection-1]);

                            } else { System.out.println("Нет производителей");} break;
                            case 5:if (Seller.getSellers_Cntr() != 0 && Product.getProducts_cntr() != 0 && Buyer.getBuyers_cntr() !=0) {

                                orders[Order.getOrders_cntr()] = new Order();

                                for(int i=0; i<Product.getProducts_cntr();i++)
                                {
                                    System.out.print(i+1+"|");
                                    products[i].outProduct();
                                }
                                System.out.print("Выберите продукт ");
                                selection = Input.inInt(1, Producer.getProducer_cntr());

                                orders[Order.getOrders_cntr()-1].inOrder(products[selection-1]);

                                for(int i=0; i<Seller.getSellers_Cntr();i++)
                                {
                                    System.out.print(i+1+"|");
                                    sellers[i].outSeller();
                                }
                                System.out.print("Выберите продавца ");
                                selection = Input.inInt(1, Seller.getSellers_Cntr());

                                orders[Order.getOrders_cntr()-1].inOrder(sellers[selection-1]);

                                for(int i=0; i<Buyer.getBuyers_cntr();i++)
                                {
                                    System.out.print(i+1+"|");
                                    buyers[i].outBuyer();
                                }
                                System.out.print("Выберите покупателя ");
                                selection = Input.inInt(1, Buyer.getBuyers_cntr());

                                orders[Order.getOrders_cntr()-1].inOrder(buyers[selection-1]);

                                orders[Order.getOrders_cntr()-1].inOrder();

                            } else {System.out.println("Сначала добавьте товар, покупателя и продавца");}
                                break;
                            case 6: exit1 = false; break;
                        }
                    } while (exit1);break;
                case 2:
                    do {
                        exit1 = true;
                        System.out.println("1.Вывод производителя \n2.Вывод продавца\n3.Вывод покупателя\n4.Вывод товара\n5.Вывод заказа\n6.Вывод выполненных заказов\n7.Вывод уволенных продавцов\n8.Выход к прошлому меню");
                        System.out.print("Выберете дальнейшее действие: ");
                        selection = Input.inInt(1, 8);

                        switch (selection) {
                            case 1: if(Producer.getProducer_cntr()>0) {
                                for (int i = 0; i < Producer.getProducer_cntr(); i++) {
                                    System.out.print(i+1 + "|");
                                    producers[i].outProducer();
                                }
                            }else System.out.println("Нет производителей"); break;
                            case 2: if(Seller.getSellers_Cntr()>0) {
                                for (int i = 0; i < Seller.getSellers_Cntr(); i++) {
                                    System.out.print(i+1 + "|");
                                    sellers[i].outSeller();
                                }
                            }else System.out.println("Нет продавцов"); break;
                            case 3: if(Buyer.getBuyers_cntr()>0) {
                                for (int i = 0; i < Buyer.getBuyers_cntr(); i++) {
                                    System.out.print(i+1 + "|");
                                    buyers[i].outBuyer();
                                }
                            }else System.out.println("Нет покупателей"); break;
                            case 4: if(Product.getProducts_cntr()>0) {
                                for (int i = 0; i < Product.getProducts_cntr(); i++) {
                                    System.out.print(i+1 + "|");
                                    products[i].outProduct();
                                }
                            }else System.out.println("Нет товаров"); break;
                            case 5: if(Order.getOrders_cntr()>0) {
                                for (int i = 0; i < Order.getOrders_cntr(); i++) {
                                    System.out.print(i+1 + "|");
                                    orders[i].outOrder();
                                }
                            }else System.out.println("Нет заказов"); break;
                            case 6: if(orders_complete_cntr>0) {
                                for (int i = 0; i < orders_complete_cntr; i++) {
                                    System.out.print(i+1 + "|");
                                    orders_complete.get(i).outOrder();
                                }
                            }else System.out.println("Нет выполненных заказов"); break;
                            case 7:if(sellers_dismissed_cntr>0) {
                                for (int i = 0; i < sellers_dismissed_cntr; i++) {
                                    System.out.print(i+1 + "|");
                                    sellers_dismissed.get(i).outSeller();
                                }
                            }else System.out.println("Нет продавцов"); break;
                            case 8: exit1 = false; break;
                        }
                    } while (exit1);
                    break;
                case 3:
                    if(Order.getOrders_cntr()>0) {
                        for (int i = 0; i < Order.getOrders_cntr(); i++) {
                            System.out.print(i+1 + "|");
                            orders[i].outOrder();
                        }
                        System.out.print("Выберите номер заказа для посчета суммы ");
                        selection = Input.inInt(1, Order.getOrders_cntr());

                        orders[selection-1].sum();

                    }else System.out.println("Нет заказов"); break;
                case 4:
                    if(Order.getOrders_cntr()>0) {
                        for (int i = 0; i < Order.getOrders_cntr(); i++) {
                            System.out.print(i+1 + "|");
                            orders[i].outOrder();
                        }
                        System.out.print("Выберите номер заказа для выполнения ");
                        selection = Input.inInt(1, Order.getOrders_cntr());

                        if(!orders[selection-1].getStatus()){   //проверка статуса
                            orders[selection-1].setStatus(true);

                            orders_complete.add(orders[selection-1]);
                            orders_complete_cntr += 1;

                        }else {System.out.println("Заказ уже выполнен");}
                    }else System.out.println("Нет заказов"); break;
                case 5:if(Seller.getSellers_Cntr()>0) {
                    for (int i = 0; i < Seller.getSellers_Cntr(); i++) {
                        System.out.print(i+1 + "|");
                        sellers[i].outSeller();
                    }
                }else System.out.println("Нет продавцов");

                    System.out.print("Выберите номер продавца для увольнения ");
                    selection = Input.inInt(1, Seller.getSellers_Cntr());

                    sellers_dismissed.add(sellers[selection-1]);
                    sellers_dismissed_cntr += 1;

                    Seller.fire();
                    for (int i =selection-1; i<Seller.getSellers_Cntr();i++){
                        sellers[i]=sellers[i+1];
                    }
                    break;
                case 6: exit = false; break;
            }
        } while (exit);
    }
}