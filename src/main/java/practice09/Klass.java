package practice09;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private Integer klass;

    private Student leader;

    private List<Student> members =new ArrayList<Student>();

    public Integer getKlass() {
        return klass;
    }

    public void setKlass(Integer klass) {
        this.klass = klass;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public Klass(Integer klass) {
        this.klass = klass;
    }

    public List<Student> getMembers() {
        return members;
    }

    public void setMembers(List<Student> members) {
        this.members = members;
    }

    public void appendMember(Student student){
        members.add(student);
    }

    @Override
    public String toString() {
        return klass.toString();
    }

    public Integer getNumber(){
        return klass;
    }

    public String getDisplayName(){
        if(klass!=null){
            return "Class "+klass;
        }
        return "No Class";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass1 = (Klass) o;
        return Objects.equals(klass, klass1.klass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(klass);
    }

    public void assignLeader(Student leader){
        if(members.contains(leader))
        this.leader=leader;
        else {
            System.out.print("It is not one of us.\n");
        }
    }
}
