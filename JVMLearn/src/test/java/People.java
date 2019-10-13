public class People {
    String name;

    public People() {
        System.out.println("People无参构造");
    }

    public People(String name) {
        this.name = name;
        System.out.println("People有参构造");
    }
}
