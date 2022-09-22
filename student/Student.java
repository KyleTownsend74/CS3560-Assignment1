package student;

public class Student implements IStudent {
    
    public static int idCounter = 0;

    private int id;

    public Student() {
        id = idCounter;
        idCounter++;
    }

    public int getId() {
        return id;
    }

}
