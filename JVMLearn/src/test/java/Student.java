public class Student extends People {
    String name;
    People people;
    public Student() {
        System.out.println("Student无参构造");
    }

    public Student(String name) {
//        super(name);
        System.out.println("Student有参构造");
        People p = new Student();
    }

    public static void main(String[] args) {
        Student name = new Student("name");
    }
}
