package spring.tdd.sample;

public class Person {
    private String name;
    private Integer born;
    private Gender gender;

    enum Gender {
        F, M
    }

    public Person(String name, Integer born){
        this.name = name;
        this.born = born;
    }

    public Person(String name, Integer born, Gender gender) {
        this(name,born);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBorn() {
        return born;
    }

    public void setBorn(Integer born) {
        this.born = born;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
