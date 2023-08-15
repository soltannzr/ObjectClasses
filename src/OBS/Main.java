package OBS;

public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Carl", "111", "MATH");
        Teacher t2 = new Teacher ("Jack", "222", "PHY");
        Teacher t3 = new Teacher("Tim", "333", "CHEM");
        Course mat = new Course("History", "101", "MATH");
        Course phy = new Course("Physics", "101", "PHY");
        Course chem = new Course("Chemistry", "101", "CHEM");

        mat.addTeacher(t1);
        phy.addTeacher(t2);
        chem.addTeacher(t3);
        Student s1 = new Student("Soltan", "1000", "5", mat, phy, chem);
        s1.addBulkExamNote(50, 50, 50, 70, 80, 90);
        s1.isPass();
    }
}
