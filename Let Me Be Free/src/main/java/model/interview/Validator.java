package model.interview;

import service.Verification;
import service.Verifier;

public abstract class Validator<T> {

    abstract void check(T t);

    Verification verifier = new Verifier();
}
