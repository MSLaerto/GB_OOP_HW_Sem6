package jobagency;

import java.util.ArrayList;
import java.util.List;


// Применяем принцип Dependency Inversion
public interface Publisher {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void sendOffer(String nameCompany, int salary);
}

// Применяем принцип Single Responsibility
public class JobAgency implements Publisher {
    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void sendOffer(String nameCompany, int salary) {
        for (Observer observer : observers){
            observer.receiveOffer(nameCompany, salary);
        }
    }
}
/*
 * Введен интерфейс Publisher для описания операций по управлению подписчиками, что соответствует принципу Dependency Inversion.
 * Класс JobAgency отвечает только за управление подписчиками и отправку предложения, что соответствует принципу Single Responsibility.
 */
