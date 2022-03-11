package model.interview;

import model.Recruiter;

import java.util.List;

public interface RecruiterRepository {
    List<HRRecruiter> findAll();
}
