package SalaryCalculator;

public class Employee {

    String name;
    int salary;
    int workHours;
    int hireYear;
    int currentYear=2023;

    Employee (String name, int salary, int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    double tax(){
        if (this.salary<1000)
            return 0;
        return (salary * 0.03);
    }

    int bonus(){
        if (this.workHours>40)
            return (this.workHours - 40)*30;
        return 0;
    }

    double raiseSalary(){
        if(currentYear - this.hireYear >=20){
            return (this.salary*0.15);
        }
        if ((currentYear - this.hireYear)<20 && (currentYear - this.hireYear)>=10)
            return (this.salary*0.1);
        return this.salary*0.05;
    }

      public String toString(){
        double totalSalary = this.salary + bonus() + raiseSalary() - tax();
        return "Name: " + this.name +
                "\nWork Hours: " + this.workHours+
                "\nHire Year: " + this.hireYear+
                "\nTax: " + tax() +
                "\nBonus: " + bonus() +
                "\nSalary increase: " + raiseSalary() +
                "\nSalary with taxes and bonuses: " + totalSalary +
                "\nSalary without taxes and bonuses: " + (this.salary + raiseSalary());
     }
}
