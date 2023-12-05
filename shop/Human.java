package shop;

public abstract class Human {
    private String name; // Имя
    private String phone; // Телефон

    public Human(){     // Конструктор без параметров
        this.name = "name";
        this.phone = "80000000000";
    };

    public Human(String name, String phone){    //Конструтор с параметрами
        this.name = name;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
}