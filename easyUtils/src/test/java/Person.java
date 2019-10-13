public class Person implements Student{

    @Override
    public void learn() {
        System.out.println("普通的学习");
    }

    @Override
    public void play() {
        System.out.println("普通的嗨皮");
    }
}
