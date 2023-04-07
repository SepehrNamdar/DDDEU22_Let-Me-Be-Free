package model.interview;

import service.CandidateIdMissingException;
import service.Verification;
import service.Verifier;
import use_case.ProfileIdMissingException;

public class ProfileValidator {

    public void check(Profile profile) {
        Verification verifier = new Verifier();
        try {
            verifier.checkCandidate(profile.toCandidate());
        } catch (CandidateIdMissingException e) {
            throw new ProfileIdMissingException();
        }
    }
    
}
