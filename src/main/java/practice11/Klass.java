package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private Integer klass;

    private Student leader;

    private List<Student> members =new ArrayList<Student>();

    private final List<JoinListener> joinListeners = new ArrayList<JoinListener>();

    private final List<AssignListener> assignListeners = new ArrayList<AssignListener>();

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
        student.setKlass(this);
        this.joinListeners.forEach(listener ->{
            listener.update(student);
        });
    }

    public List<JoinListener> getJoinListeners() {
        return joinListeners;
    }

    public List<AssignListener> getAssignListeners() {
        return assignListeners;
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
        if(this==leader.getKlass()){
            this.leader=leader;
            this.leader.setKlass(this);
            this.assignListeners.forEach(assignListener -> {
                assignListener.updateAssignMessage(this);
            });
        }
        else {
            System.out.print("It is not one of us.\n");
        }
    }
}
