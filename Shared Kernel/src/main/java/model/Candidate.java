package model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Builder
@Getter
public class Candidate {
    private String id;
    private String name;
    private String firstName;
    private LocalDate dateOfBirth;
    private int experience;
    private List<String> skills;
    private String softSkills;
    private String cvPath;
    private Recruiter interviewer;
    private String source;
    private boolean cooption;
    private String coopter;
    private Map<String, Object> info;
}
