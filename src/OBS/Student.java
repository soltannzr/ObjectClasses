package OBS;
import java.util.Scanner;
public class Student {
    Course mat;
    Course phy;
    Course chem;
    String name;
    String stuNo;
    String classes;
    float verbpercent = 0.2f;
    float expercent = 0.8f;
    double average;
    boolean isPass;

    Student(String name, String stuNo, String classes, Course mat, Course phy, Course chem){
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.mat = mat;
        this.phy = phy;
        this.chem = chem;
        this.average = 0.0;
    }

    void addBulkExamNote(int matverb,int matexam, int phyverb, int phyexam, int chemverb, int chemexam ){
        if (matverb>=0 && matverb <=100 && matexam>=0 && matexam<= 100)
            this.mat.note = matverb * verbpercent + matexam * expercent;
        if (phyverb>=0 && phyverb<= 100 && phyexam>=0 && phyexam<= 100)
            this.phy.note = phyverb * verbpercent + phyexam * expercent;
        if (chemverb>=0 && chemverb<=100 && chemexam>=0 && chemexam<= 100 )
            this.chem.note = chemverb * verbpercent + chemexam * expercent;
    }

    void calcAverage(){this.average = (this.mat.note + this.phy.note + this.chem.note)/3.0;
    }

    void isPass(){
        calcAverage();
        if (this.average<55) {
            printNote();
            System.out.println("Failed!");
        }
        if (this.average>=55) {
            printNote();
            System.out.println("Passed!");
        }
    }

    void printNote(){
        System.out.println("Student: " + this.name);
        System.out.println("Mathematics note: " + this.mat.note);
        System.out.println("Physics note: " + this.phy.note);
        System.out.println("Chemistry note: "+ this.chem.note);
        System.out.println("Average is: " + this.average);
    }

}
