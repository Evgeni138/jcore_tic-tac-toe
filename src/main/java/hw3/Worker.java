package hw3;
/*
Данный класс Worker является абстрактным и служит для описания работника.

Основные поля класса:
- name (имя работника);
- age (возраст работника);
- fee (ставка работника).


Отметим, что класс Worker является абстрактным, так как метод calculationSalary() объявлен абстрактным. Это значит,
что каждый подкласс класса Worker должен реализовать свою версию этого метода, чтобы иметь возможность вычислять
заработную плату работника. Метод toString() переопределен для удобства вывода информации о работнике на экран.


 */
public abstract class Worker{
    protected String name;
    protected int age;

    protected int fee;

    public String getName() {
        return name;
    }

    public int getFee() {
        return fee;
    }

    public int getAge() {
        return age;
    }

    public Worker(String name, int age, int fee) {
        this.name = name;
        this.age = age;
        this.fee = fee;
    }

    public abstract int calculationSalary();

    @Override
    public String toString() {
        return "\nWorker{" +
                "name='" + name + '\'' +
                ", position=" + getClass().getSimpleName() +
                ", age=" + age +
                ", fee=" + fee +
                ", monthly salary=" + calculationSalary() +
                '}';
    }
}
