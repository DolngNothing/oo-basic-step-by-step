package practice11;

import java.util.LinkedList;

public class Teacher extends Person implements JoinListener,AssignListener{
    private LinkedList<Klass> klasses;

    public Teacher(Integer id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(Integer id, String name, int age, LinkedList<Klass> klasses) {
        super(id, name, age);
        this.klasses = klasses;
        klasses.forEach(klass -> {
            klass.getJoinListeners().add(this);
            klass.getAssignListeners().add(this);
        });
    }

    public LinkedList<Klass> getClasses() {
        return klasses;
    }

    public void setKlasses(LinkedList<Klass> klasses) {
        this.klasses = klasses;
    }

    @Override
    public String introduce() {
        StringBuffer result = new StringBuffer(super.introduce() + " "+"I am a Teacher. I teach Class ");
        if (this.klasses!=null&&!this.klasses.isEmpty()){
            for(int i=0;i<klasses.size();i++) {
                if (i != klasses.size() - 1)
                    result.append(klasses.get(i) + ", ");
                else result.append(klasses.get(i));
            }
            result.append(".");
            return result.toString();
        }
        return super.introduce() + " " + new String("I am a Teacher. I teach No Class.");
    }

    public String introduceWith(Student student){
        StringBuffer result=new StringBuffer("My name is "+this.name+". I am "+this.age+" years old. I am a Teacher.");
        if(klasses.contains(student.getKlass())){
            result.append(" I teach "+student.getName()+".");
        }else {
            result.append(" I don't teach "+student.getName()+".");
        }
        return result.toString();
    }

    public boolean isTeaching(Student student){
        if(klasses.contains(student.getKlass())){
            return true;
        }
        return false;
    }

    @Override
    public void update(Student student) {
        System.out.print("I am "+this.name+". I know "+student.getName()+" has joined Class "+student.getKlass()+".\n");
    }

    @Override
    public void updateAssignMessage(Student leader) {
        System.out.printf(String.format("I am %s. I know %s become Leader of Class %s.\n",this.name,leader.getName(),leader.getKlass()));
    }
}
