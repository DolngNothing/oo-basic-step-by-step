package practice09;

public class Teacher extends Person{
    private Klass klass;

    public Teacher(Integer id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(Integer id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }


    @Override
    public String introduce() {
        if (this.klass != null)
            return super.introduce() + " " + new String("I am a Teacher. I teach Class " + this.klass + ".");
        return super.introduce() + " " + new String("I am a Teacher. I teach No Class.");
    }

    public String introduceWith(Student student){
        StringBuffer result=new StringBuffer("My name is "+this.name+". I am "+this.age+" years old. I am a Teacher.");
        if(student.getKlass()==this.klass){
            result.append(" I teach "+student.getName()+".");
        }else {
            result.append(" I don't teach "+student.getName()+".");
        }
        return result.toString();
    }
}
