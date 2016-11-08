package validator;

public abstract class Validator {

    public boolean validatePostcode(String input) {
        return !isEmptyPostcode(input) && isLegalPostcode(input);
    }

    protected boolean isEmptyPostcode(String input) {
        return input.isEmpty();
    }

    protected abstract boolean isLegalPostcode(String input);
}
