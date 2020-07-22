package practice10;

import java.util.Objects;

public class Student extends Person {
    private Klass klass;

    public Student(Integer id, String name, int age) {
        super(id, name, age);
    }

    public Student(Integer id, String name, int age, Klass klass) {
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
    public String introduce(){
        StringBuffer result=new StringBuffer(super.introduce()+" "+"I am a Student.");
        if(klass.getLeader()==this){
            result.append(" I am Leader of Class "+this.klass+".");
        }else{
            result.append(" I am at Class "+this.klass+".");
        }
        return result.toString();
    }

}
