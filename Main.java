import shop.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    static class Input{        //ввод пункта из списка
        static int inInt(int lower_limit, int upper_limit) {
            Scanner scanner = new Scanner(System.in);
            int selection;
            try {       // Исключение, если вводится не число
                do {
                    selection = scanner.nextInt();
                    if (selection < lower_limit || selection > upper_limit) {
                        System.out.println("Ошибка. Введите пункт списка.");
                    }
                } while (selection < lower_limit || selection > upper_limit);
            }catch(InputMismatchException e){
                selection =-1;
                System.out.println("Ошибка. Введите число.");
                return selection;
            }
                return selection;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producer[] producers = new Producer[10];
        Seller[] sellers = new Seller[10]; int sellers_cntr =0;
        Buyer[][] buyers = new Buyer[2][5];
        Product[] products = new Product[10];
        Order[] orders = new Order[10];
        ArrayList<Order> orders_complete = new ArrayList<Order>(); int orders_complete_cntr = 0;
        ArrayList<Seller> sellers_dismissed = new ArrayList<Seller>(); int sellers_dismissed_cntr = 0;
        int selection = 0; boolean exit = true;

        //меню
        do
        {
            System.out.println("1.Добавление\n2.Вывод\n3.Сумма заказа\n4.Выполнить заказ\n5.Уволить продавца\n6.Выход");

            do {
                selection = Input.inInt(1, 6);
            }while(selection<0);

            boolean exit1; int j,k;
            switch (selection)
            {
                case 1:
                    do {
                        exit1 = true;
                        System.out.println("1.Добавление производителя \n2.Добавление продавца\n3.Добавление покупателя\n4.Добавление товара\n5.Добавление заказа\n6.Выход к прошлому меню");
                        System.out.print("Выберете дальнейшее действие: ");

                        do{
                        selection = Input.inInt(1, 6);
                        }while(selection<0);

                        switch (selection) {
                            case 1:
                                producers[Producer.getProducer_cntr()] = new Producer();
                                producers[Producer.getProducer_cntr()-1].inProducer();
                                break;
                            case 2:
                                sellers[sellers_cntr] = new Seller();
                                sellers[sellers_cntr].inSeller();
                                sellers_cntr++;
                                break;
                            case 3:
                                j = Buyer.getBuyers_cntr()/5;
                                k = Buyer.getBuyers_cntr()%5;
                                buyers[j][k] = new Buyer();
                                buyers[j][k].inBuyer();
                                break;
                            case 4: if (Producer.getProducer_cntr()>0){
                                for(int i=0; i<Producer.getProducer_cntr();i++)
                                {
                                    System.out.print(i+1+"|");
                                    producers[i].outProducer();
                                }

                                System.out.print("Выберите производителеля ");
                                do{
                                selection = Input.inInt(1, Producer.getProducer_cntr());
                                }while(selection<0);

                                products[Product.getProducts_cntr()] = new Product();
                                products[Product.getProducts_cntr()-1].inProduct(producers[selection-1]);

                            } else { System.out.println("Нет производителей");} break;
                            case 5:if (sellers_cntr != 0 && Product.getProducts_cntr() != 0 && Buyer.getBuyers_cntr() !=0) {

                                orders[Order.getOrders_cntr()] = new Order();

                                for(int i=0; i<Product.getProducts_cntr();i++)
                                {
                                    System.out.print(i+1+"|");
                                    products[i].outProduct();
                                }
                                System.out.print("Выберите продукт ");
                                do{
                                selection = Input.inInt(1, Producer.getProducer_cntr());
                                }while(selection<0);

                                orders[Order.getOrders_cntr()-1].inOrder(products[selection-1]);

                                for(int i=0; i<sellers_cntr;i++)
                                {
                                    System.out.print(i+1+"|");
                                    sellers[i].outSeller();
                                }
                                System.out.print("Выберите продавца ");
                                do{
                                selection = Input.inInt(1, sellers_cntr);
                                }while(selection<0);

                                orders[Order.getOrders_cntr()-1].inOrder(sellers[selection-1]);

                                for(int i=0; i<Buyer.getBuyers_cntr();i++) {
                                    j = i/5;
                                    k = i%5;
                                    System.out.print(i + 1 + "|");
                                    buyers[j][k].outBuyer();
                                }
                                System.out.print("Выберите покупателя ");
                                do{
                                selection = Input.inInt(1, Buyer.getBuyers_cntr());
                                }while(selection<0);

                                j = (selection-1)/5;
                                k = (selection-1)%5;
                                orders[Order.getOrders_cntr()-1].inOrder(buyers[j][k]);

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
                        do{
                        selection = Input.inInt(1, 8);
                        }while(selection<0);

                        switch (selection) {
                            case 1: if(Producer.getProducer_cntr()>0) {
                                for (int i = 0; i < Producer.getProducer_cntr(); i++) {
                                    System.out.print(i+1 + "|");
                                    producers[i].outProducer();
                                }
                            }else System.out.println("Нет производителей"); break;
                            case 2: if(sellers_cntr>0) {
                                for (int i = 0; i < sellers_cntr; i++) {
                                    System.out.print(i+1 + "|");
                                    sellers[i].outSeller();
                                }
                            }else System.out.println("Нет продавцов"); break;
                            case 3: if(Buyer.getBuyers_cntr()>0) {
                                    for(int i=0; i<Buyer.getBuyers_cntr();i++) {
                                        j = i/5;
                                        k = i%5;
                                        System.out.print(i + 1 + "|");
                                        buyers[j][k].outBuyer();
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
                        do{
                        selection = Input.inInt(1, Order.getOrders_cntr());
                        }while(selection<0);

                        orders[selection-1].sum();

                    }else System.out.println("Нет заказов"); break;
                case 4:
                    if(Order.getOrders_cntr()>0) {
                        for (int i = 0; i < Order.getOrders_cntr(); i++) {
                            System.out.print(i+1 + "|");
                            orders[i].outOrder();
                        }
                        System.out.print("Выберите номер заказа для выполнения ");
                        do{
                        selection = Input.inInt(1, Order.getOrders_cntr());
                        }while(selection<0);

                        if(!orders[selection-1].getStatus()){   //проверка статуса
                            orders[selection-1].setStatus(true);

                            orders_complete.add(orders[selection-1]);
                            orders_complete_cntr += 1;

                        }else {System.out.println("Заказ уже выполнен");}
                    }else System.out.println("Нет заказов"); break;
                case 5:if(sellers_cntr>0) {
                    for (int i = 0; i < sellers_cntr; i++) {
                        System.out.print(i+1 + "|");
                        sellers[i].outSeller();
                    }
                }else System.out.println("Нет продавцов");

                    System.out.print("Выберите номер продавца для увольнения ");
                    do{
                    selection = Input.inInt(1, sellers_cntr);
                    }while(selection<0);

                    sellers_dismissed.add(sellers[selection-1]);
                    sellers_dismissed_cntr += 1;

                    if (selection == sellers_cntr){ sellers_cntr--;}
                    else {
                        for (int i = selection - 1; i < sellers_cntr-1; i++) {
                            sellers[i] = sellers[i + 1];
                        }
                        sellers_cntr--;
                    }

                    break;
                case 6: exit = false; break;
            }
        } while (exit);
    }
}