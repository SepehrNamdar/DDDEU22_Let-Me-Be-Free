package model.interview;

import model.Candidate;
import model.Recruiter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FakeRecruiterRepository implements RecruiterRepository {

    private final List<Recruiter> recruiters = new LinkedList<>();

    public FakeRecruiterRepository() {
        recruiters.add(Recruiter.builder()
                        .id("123")
                        .name("Doe")
                        .firstName("John")
                        .address("4 av. London, London")
                        .dateOfBirth(LocalDate.of(1987, 5, 11))
                        .candidates(List.of(
                                Candidate.builder()
                                        .id("951")
                                        .name("Lucas")
                                        .firstName("Lilly")
                                        .skills(List.of(".Net", "Python", "JS"))
                                        .coopter("Nicolas Moreno")
                                        .cooption(true)
                                        .softSkills("Speaker")
                                        .cvPath("C:\\Users\\sepeh\\Dropbox\\RIB")
                                        .source("LinkedIn")
                                        .dateOfBirth(LocalDate.of(1990, 7, 4))
                                        .build(),
                                Candidate.builder()
                                        .id("753")
                                        .name("Francois")
                                        .firstName("Tanguy")
                                        .skills(List.of("Java"))
                                        .softSkills("Social")
                                        .cvPath("C:\\Users\\CV\\all\\Cv")
                                        .source("Indeed")
                                        .dateOfBirth(LocalDate.of(1956, 8, 29))
                                        .build()))
                        .availabilities(new ArrayList<>(List.of(
                                LocalDate.of(2022, 12, 22),
                                LocalDate.of(2022, 12, 20))))
                        .skills(List.of("Java"))
                        .experience(5)
                        .iban("AL47 2121 1009 0000 0002 3569 87411")
                        .seniority(LocalDate.of(2012, 11, 10))
                        .salary(47)
                        .interviews(56)
                .build());
        recruiters.add(Recruiter.builder()
                        .id("456")
                        .name("Martin")
                        .firstName("Bob")
                        .address("Chapman 711-2880 Nulla St. Mankato Mississippi 96522")
                        .dateOfBirth(LocalDate.of(1995, 3, 3))
                        .availabilities(new ArrayList<>(List.of(
                                LocalDate.of(2022, 12, 21),
                                LocalDate.of(2022, 12, 22))))
                        .skills(List.of("PHP", "Java"))
                        .build());
        recruiters.add(Recruiter.builder()
                        .id("789")
                        .name("Jones")
                        .firstName("Sara")
                        .availabilities(new ArrayList<>(List.of(
                                LocalDate.of(2022, 12, 19))))
                        .candidates(List.of(
                                Candidate.builder()
                                        .id("654")
                                        .name("Sandro")
                                        .firstName("Paul")
                                        .skills(List.of("JS"))
                                        .coopter("Fabrice Vu")
                                        .cooption(true)
                                        .softSkills("Singer")
                                        .cvPath("C:\\Users\\CV\\Recruiter\\myCV")
                                        .dateOfBirth(LocalDate.of(1963, 5, 28))
                                        .build(),
                                Candidate.builder()
                                        .id("963")
                                        .name("Jim")
                                        .firstName("Jones")
                                        .skills(List.of(".Net"))
                                        .cvPath("C:\\Users\\Biz\\co\\Cv")
                                        .source("Indeed")
                                        .dateOfBirth(LocalDate.of(1980, 2, 29))
                                        .build()))
                        .skills(List.of("PHP"))
                        .experience(2)
                        .iban("AD1400080001001234567890")
                        .seniority(LocalDate.of(2015, 12, 26))
                        .salary(80)
                        .interviews(1)
                        .build());
        recruiters.add(Recruiter.builder()
                        .id("101").name("Steve").firstName("Emma")
                        .availabilities(new ArrayList<>(List.of(
                                LocalDate.of(2022, 12, 19),
                                LocalDate.of(2022, 12, 22))))
                        .skills(List.of("PHP", "Java"))
                        .build());
    }

    @Override
    public List<Recruiter> findAll() {
        return recruiters;
    }

}
