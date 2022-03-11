package model.interview;

import service.CandidateIdMissingException;
import use_case.ProfileIdMissingException;

public class ProfileValidator extends Validator<Profile> {

    public void check(Profile profile) {
        try {
            verifier.checkCandidate(profile.toCandidate());
        } catch (CandidateIdMissingException e) {
            throw new ProfileIdMissingException();
        }
    }

}
