package hw3;
/*
Данный класс описывает работника (handyman) с фиксированной ставкой оплаты труда.
 */
public class Engineer extends Worker{


    public Engineer(String name, int age, int fee) {
        super(name, age, fee);
    }

    @Override
    public int calculationSalary() {
        return fee;
    }
}
