import shop.*;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producer[] producers = new Producer[10]; int producers_cntr = 0;
        Seller[] sellers = new Seller[10]; int sellers_cntr = 0;
        Buyer[] buyers = new Buyer[10]; int buyers_cntr = 0;
        Product[] products = new Product[10]; int products_cntr = 0;
        Order[] orders = new Order[10]; int orders_cntr = 0;
        ArrayList<Order> orders_complete = new ArrayList<Order>(); int orders_complete_cntr = 0;
        ArrayList<Seller> sellers_dismissed = new ArrayList<Seller>(); int sellers_dismissed_cntr = 0;
        int selection = 0; boolean exit = true;

        //меню
        do
        {
            System.out.println("1.Добавление\n2.Вывод\n3.Сумма заказа\n4.Выполнить заказ\n5.Уволить продавца\n6.Выход");
            do  //ввод пунтка меню с проверкой
            {
                selection = scanner.nextInt();
                if (selection < 1 || selection > 6)
                    System.out.println("Ошибка. Введите пункт списка.");
            } while (selection < 1 || selection > 6);

            boolean exit1 = true;
            switch (selection)
            {
                case 1:
                    do {
                        System.out.println("1.Добавление производителя \n2.Добавление продавца\n3.Добавление покупателя\n4.Добавление товара\n5.Добавление заказа\n6.Выход к прошлому меню");
                        System.out.print("Выберете дальнейшее действие: ");
                        do  //ввод пунтка меню с проверкой
                        {
                            selection = scanner.nextInt();
                            if (selection < 1 || selection > 6)
                                System.out.println("Ошибка. Введите пункт списка.");
                        } while (selection < 1 || selection > 6);
                        switch (selection) {
                            case 1:
                                producers[producers_cntr] = new Producer();
                                producers[producers_cntr].inProducer();
                                producers_cntr += 1;
                                break;
                            case 2:
                                sellers[sellers_cntr] = new Seller();
                                sellers[sellers_cntr].inSeller();
                                sellers_cntr += 1;
                                break;
                            case 3:
                                buyers[buyers_cntr] = new Buyer();
                                buyers[buyers_cntr].inBuyer();
                                buyers_cntr += 1;
                                break;
                            case 4: if (producers_cntr>0){
                                for(int i=0; i<producers_cntr;i++)
                            {producers[i].outProducer();}

                                System.out.println("Выберите производителеля");
                                do
                                {
                                    selection = scanner.nextInt();
                                    if (selection < 1 || selection > producers_cntr)
                                        System.out.println("Ошибка. Введите производителеля.");
                                } while (selection < 1 || selection > producers_cntr);

                            products[products_cntr] = new Product();
                            products[products_cntr].inProduct(producers[selection-1]);
                            products_cntr += 1;

                            } else { System.out.println("Нет производителей");} break;
                            case 5:if (sellers_cntr == 0 || products_cntr == 0 || buyers_cntr ==0) {

                                orders[orders_cntr] = new Order();

                                for(int i=0; i<products_cntr;i++)
                                {
                                    System.out.print(i+"|");
                                    products[i].outProduct();
                                }
                                System.out.println("Выберите продукт");
                                do
                                {
                                    selection = scanner.nextInt();
                                    if (selection < 1 || selection > products_cntr)
                                        System.out.println("Ошибка. Введите продукт.");
                                } while (selection < 1 || selection > products_cntr);
                                orders[orders_cntr].inOrder(products[selection-1]);

                                for(int i=0; i<sellers_cntr;i++)
                                {
                                    System.out.print(i+"|");
                                    sellers[i].outSeller();
                                }
                                System.out.println("Выберите продавца");
                                do
                                {
                                    selection = scanner.nextInt();
                                    if (selection < 1 || selection > sellers_cntr)
                                        System.out.println("Ошибка. Введите продавца.");
                                } while (selection < 1 || selection > sellers_cntr);
                                orders[orders_cntr].inOrder(sellers[selection-1]);

                                for(int i=0; i<buyers_cntr;i++)
                                {
                                    System.out.print(i+"|");
                                    sellers[i].outSeller();
                                }
                                System.out.println("Выберите покупателя");
                                do
                                {
                                    selection = scanner.nextInt();
                                    if (selection < 1 || selection > buyers_cntr)
                                        System.out.println("Ошибка. Введите покупателя.");
                                } while (selection < 1 || selection > buyers_cntr);
                                orders[orders_cntr].inOrder(buyers[selection-1]);

                                orders[orders_cntr].inOrder();
                                orders_cntr +=1;
                            } else {System.out.println("Сначала добавьте товар, покупателя и продавца");}
                                break;
                            case 6: exit1 = false; break;
                        }
                    } while (exit1);
                case 2:
                    do {
                        System.out.println("1.Вывод производителя \n2.Вывод продавца\n3.Вывод покупателя\n4.Вывод товара\n5.Вывод заказа\n6.Вывод выполненных заказов\n7.Вывод уволенных продавцов\n8.Выход к прошлому меню");
                        System.out.print("Выберете дальнейшее действие: ");
                        do
                        {
                            selection = scanner.nextInt();
                            if (selection < 1 || selection > 8)
                                System.out.println("Ошибка. Введите пункт списка.");
                        } while (selection < 1 || selection > 8);
                        switch (selection) {
                            case 1: if(producers_cntr>0) {
                                for (int i = 0; i < producers_cntr; i++) {
                                    System.out.print(i + "|");
                                    producers[i].outProducer();
                                }
                            }else System.out.println("Нет производителей"); break;
                            case 2: if(sellers_cntr>0) {
                                for (int i = 0; i < sellers_cntr; i++) {
                                    System.out.print(i + "|");
                                    sellers[i].outSeller();
                                }
                            }else System.out.println("Нет продавцов"); break;
                            case 3: if(buyers_cntr>0) {
                                for (int i = 0; i < buyers_cntr; i++) {
                                    System.out.print(i + "|");
                                    buyers[i].outBuyer();
                                }
                            }else System.out.println("Нет покупателей"); break;
                            case 4: if(products_cntr>0) {
                                for (int i = 0; i < products_cntr; i++) {
                                    System.out.print(i + "|");
                                    products[i].outProduct();
                                }
                            }else System.out.println("Нет товаров"); break;
                            case 5: if(orders_cntr>0) {
                                for (int i = 0; i < orders_cntr; i++) {
                                    System.out.print(i + "|");
                                    orders[i].outOrder();
                                }
                            }else System.out.println("Нет заказов"); break;
                            case 6: if(orders_complete_cntr>0) {
                                for (int i = 0; i < orders_complete_cntr; i++) {
                                    System.out.print(i + "|");
                                    orders_complete.get(i).outOrder();
                                }
                            }else System.out.println("Нет выполненных заказов"); break;
                            case 7:if(sellers_dismissed_cntr>0) {
                                for (int i = 0; i < sellers_dismissed_cntr; i++) {
                                    System.out.print(i + "|");
                                    sellers_dismissed.get(i).outSeller();
                                }
                            }else System.out.println("Нет продавцов"); break;
                            case 8: exit1 = false; break;
                        }
                    } while (exit1);
                    break;
                case 3:
                    if(orders_cntr>0) {
                        for (int i = 0; i < orders_cntr; i++) {
                            System.out.print(i + "|");
                            orders[i].outOrder();
                        }
                        System.out.println("Выберите номер заказа для посчета суммы");
                        do
                        {
                            selection = scanner.nextInt();
                            if (selection < 1 || selection > orders_cntr)
                                System.out.println("Ошибка. Введите номер заказа.");
                        } while (selection < 1 || selection > orders_cntr);

                        orders[selection].sum();

                    }else System.out.println("Нет заказов"); break;
                case 4:
                    if(orders_cntr>0) {
                        for (int i = 0; i < orders_cntr; i++) {
                            System.out.print(i + "|");
                            orders[i].outOrder();
                        }
                        System.out.println("Выберите номер заказа для выполнения");
                        do
                        {
                            selection = scanner.nextInt();
                            if (selection < 1 || selection > orders_cntr)
                                System.out.println("Ошибка. Введите номер заказа.");
                        } while (selection < 1 || selection > orders_cntr);

                        orders[selection].setStatus(true);

                        orders_complete.add(orders[selection]);
                        orders_complete_cntr += 1;
                    }else System.out.println("Нет заказов"); break;
                case 5:if(sellers_cntr>0) {
                    for (int i = 0; i < sellers_cntr; i++) {
                        System.out.print(i + "|");
                        sellers[i].outSeller();
                    }
                }else System.out.println("Нет продавцов");

                System.out.println("Выберите номер продавца для увольнения");
                do
                {
                    selection = scanner.nextInt();
                    if (selection < 1 || selection > sellers_cntr)
                        System.out.println("Ошибка. Введите номер продавца.");
                } while (selection < 1 || selection > sellers_cntr);

                sellers_dismissed.add(sellers[selection]);
                sellers_dismissed_cntr += 1;

                sellers_cntr -= 1;
                for (int i =selection-1; i<sellers_cntr;i++){
                    sellers[i]=sellers[i+1];
                }
                    break;
                case 6: exit = false; break;
            }
        } while (exit);
    }
}