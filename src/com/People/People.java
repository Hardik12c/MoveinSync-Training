package com.People;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


enum Gender {
    MAN,
    WOMEN
}
public class People {
    private String name;
    private Integer age;
    private Gender gender;

    public People(String name, Integer age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}


class PeopleImplementation {

    public Integer minimumAgeContainingE(Collection<People> peoples) {
        Optional<Integer> result = peoples.stream()
                .filter(p -> p.getName().contains("e"))
                .map(People::getAge)
                .min(Integer::compareTo);

        return result.orElse(null);
    }

    public Integer getAgeOfOldestMan(Collection<People> peoples) {
        Optional<Integer> result = peoples.stream()
                .filter(p -> p.getGender() == Gender.MAN)
                .map(People::getAge)
                .max(Integer::compareTo);

        return result.orElse(null);
    }
    public static void main(String[] args) {
        Collection<People> peopleList = new ArrayList<>();

        peopleList.add(new People("John", 30, Gender.MAN));
        peopleList.add(new People("Mary", 25, Gender.WOMEN));
        peopleList.add(new People("David", 28, Gender.MAN));
        peopleList.add(new People("Emma", 22, Gender.WOMEN));
        peopleList.add(new People("George", 35, Gender.MAN));
        peopleList.add(new People("Sophie", 29, Gender.WOMEN));

        PeopleImplementation implementation = new PeopleImplementation();

        Integer minimumAgeContainingE = implementation.minimumAgeContainingE(peopleList);
        System.out.println("Minimum age of a person containing 'e' in their name: " + minimumAgeContainingE);

        Integer ageOfOldestMan = implementation.getAgeOfOldestMan(peopleList);
        System.out.println("Age of the oldest man: " + ageOfOldestMan);
    }
}
