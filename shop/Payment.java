package shop;

public class Payment<T>
{
    private T accaunt_id;       // id счета
    private int sum;            // сумма
    Payment(T accaunt_id, int sum) {
        this.accaunt_id = accaunt_id;
        this.sum = sum;
    }
    public void setPayment(T accaunt_id, int sum){
        this.accaunt_id = accaunt_id;
        this.sum = sum;
    }


    @Override
    public String toString() {
        return "id счета: " + accaunt_id + "  Сумма: " +sum;
    }
};
