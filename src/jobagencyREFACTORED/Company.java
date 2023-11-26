package jobagency;

import java.util.Random;


// Используем принцип Dependency Inversion
public interface JobProvider {
    void sendOffer(String companyName, int salary);
}

// Используем принцип Single Responsibility
public class JobAgency implements JobProvider {
    @Override
    public void sendOffer(String companyName, int salary) {
        // Реализация отправки предложения о работе
    }
}

public class Company {
    JobProvider jobProvider;
    String nameCompany;
    Random rnd;
    int maxSalary;

    // компания работает с определенным агенством
    public Company(JobProvider jobProvider, String nameCompany, int maxSalary){
        this.jobProvider = jobProvider;
        this.nameCompany = nameCompany;
        rnd = new Random();
        this.maxSalary = maxSalary;
    }

    public void needEmpoyee(){
        int salary = rnd.nextInt(maxSalary);
        jobProvider.sendOffer(nameCompany, salary);
    }
}
/*
 * Введен интерфейс JobProvider для абстрагирования отправки предложения о работе, что соответствует принципу Dependency Inversion.
 *  Класс JobAgency отвечает только за отправку предложения о работе, что соответствует принципу Single Responsibility.
 */