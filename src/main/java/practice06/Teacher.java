package practice06;

public class Teacher extends Person{
    private Integer Klass;

    public Integer getKlass() {
        return Klass;
    }

    public void setKlass(Integer klass) {
        Klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Integer klass) {
        super(name, age);
        Klass = klass;
    }
    @Override
    public String introduce(){
        if(this.Klass!=null)
        return super.introduce()+" "+new String("I am a Teacher. I teach Class "+this.Klass+".");
        return super.introduce()+" "+new String("I am a Teacher. I teach No Class.");
    }

}
