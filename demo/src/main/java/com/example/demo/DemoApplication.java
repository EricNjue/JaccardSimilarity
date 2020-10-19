package com.example.demo;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.JaccardSimilarity;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        Person eric = new Person("Eric", "Gitonga", "Njue");


        JaccardSimilarity jaccardSimilarity = new JaccardSimilarity();
        Double applyJaccard = Math.ceil(jaccardSimilarity.apply(eric.toString(), "Eric Gitonga") * 100);

        System.out.printf("JaccardSimilarity: %s%n", applyJaccard);


        SpringApplication.run(DemoApplication.class, args);
    }


    static class Person {
        private String firstName;
        private String middleName;
        private String lastName;

        public Person(String firstName, String middleName, String lastName) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return String.format("%s %s %s", firstName, middleName, lastName);
        }

        public String middleFirstLastString() {
            return String.format("%s  %s", middleName, lastName);
        }

        public String middleLastFirstString() {
            return String.format("%s %s %s", middleName, lastName, firstName);
        }
    }

}
