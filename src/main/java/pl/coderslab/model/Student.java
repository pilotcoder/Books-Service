package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Setter
@Getter
@ToString
public class Student {

    String firstName;
    String lastName;
    String gender;
    String country;
    String notes;
    boolean mailingList;
    List<String> programmingSkills;
    List<String> hobbies;

}
