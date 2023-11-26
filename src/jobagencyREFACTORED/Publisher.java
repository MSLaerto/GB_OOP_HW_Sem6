package jobagency;

// Применяем принцип единственной ответственности
public interface Publisher {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String nameCompany, int salary); // Изменили название метода для отражения его основной ответственности
}

// Применяем принцип единственной ответственности
public class JobAgency implements Publisher {
    private List<Observer> observers;

    public JobAgency() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String nameCompany, int salary) { // Изменили название метода для отражения его основной ответственности
        for (Observer observer : observers) {
            observer.update(nameCompany, salary);
        }
    }

    public void sendOffer(String nameCompany, int salary) {
        notifyObservers(nameCompany, salary);
    }
}
/*
 * Изменил интерфейс Publisher, чтобы он соответствовал принципу единственной ответственности, отделенной от деталей регистрации и удаления наблюдателей.
 * Изменил класс JobAgency так, чтобы методы регистрации, удаления наблюдателей и отправки уведомлений соответствовали принципу единственной ответственности.
 */
