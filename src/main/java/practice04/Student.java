package practice04;

public class Student extends Person{
    private int Klass;

    public int getKlass() {
        return Klass;
    }

    public void setKlass(int klass) {
        Klass = klass;
    }

    public Student(String name, int age, int klass) {
        super(name, age);
        Klass = klass;
    }

    @Override
    public String introduce(){
        return super.introduce()+" "+new String("I am a Student. I am at Class "+this.Klass +".");
    }

}
