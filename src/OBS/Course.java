package OBS;

public class Course {
    Teacher teacher;
    String name;
    String code;
    String prefix;
    double note;

    Course (String name, String code, String prefix){
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        int note = 0;
    }

    void addTeacher(Teacher teacher){
        if (teacher.branch.equals(prefix)) {
            this.teacher = teacher;
            System.out.println("Transaction successful");
            printTeacher();
        }
        else{
            System.out.println("Teacher and Course are incompatible");
        }
    }


    void printTeacher(){
        System.out.println("Teacher of " + this.name + " is: "+ this.teacher.name);
        //this.teacher.print();
    }
}
