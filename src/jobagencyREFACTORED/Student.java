package jobagency;

// Применяем принцип инкапсуляции
public class Student implements Observer {
    String name;
    int currentBestOffer; // Изменение названия переменной для отражения ее сути

    public Student(String name){
        this.name = name;
        currentBestOffer = 0; // Изменение инициализации переменной на более осмысленное значение
    }

    @Override
    public void update(String nameCompany, int salary) { // Изменение метода в соответствии с обновленным интерфейсом
        if (this.currentBestOffer < salary) {
            System.out.println(String.format("Student %s: I need this work! (company, salary) = %s, %d", name, nameCompany, salary));
            this.currentBestOffer = salary;
        }
        else{
            System.out.println(String.format("Student %s: I got a better job! (company, salary) = %s, %d", name, nameCompany, salary));
        }
    }
}
/*
 * Изменил название метода в классе Student на более общее, что соответствует принципу инкапсуляции.
 * Изменил название переменной и ее инициализацию для лучшего отражения сути, что также соответствует принципу инкапсуляции.
 */