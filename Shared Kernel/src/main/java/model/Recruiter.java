package model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Builder
@Getter
public class Recruiter {
    private String id;
    private String name;
    private String firstName;
    private LocalDate dateOfBirth;
    private int experience;
    private List<String> skills;
    private String softSkills;
    private List<LocalDate> availabilities;
    private List<Candidate> candidates;
    private String iban;
    private int salary;
    private String address;
    private LocalDate seniority;
    private String idCart;
    private int interviews;
    private Map<String, Object> info;
}
