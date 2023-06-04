package hw3;
/*
Данный класс описывает работника (handyman) с почасовой оплатой труда.
 */
public class Handyman extends Worker{


    public Handyman(String name, int age, int fee) {
        super(name, age, fee);
    }

    @Override
    public int calculationSalary() {
        return (int) (getFee() * 20.8 * 8);
    }

}
