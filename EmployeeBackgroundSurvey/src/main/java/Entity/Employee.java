package Entity;

import java.util.List;

public class Employee {
    public String name;
    public String surname;
    public int age;
    public LivingPlace livingPlace;
    public List<ProgrammingSkill> programmingSkill;

    public Employee() {
    }

    public Employee(String name, String surname, int age, LivingPlace livingPlace, List<ProgrammingSkill> programmingSkill) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.livingPlace = livingPlace;
        this.programmingSkill = programmingSkill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LivingPlace getLivingPlace() {
        return livingPlace;
    }

    public void setLivingPlace(LivingPlace livingPlace) {
        this.livingPlace = livingPlace;
    }

    public List<ProgrammingSkill> getProgrammingSkill() {
        return programmingSkill;
    }

    public void setProgrammingSkill(List<ProgrammingSkill> programmingSkill) {
        this.programmingSkill = programmingSkill;
    }
}
