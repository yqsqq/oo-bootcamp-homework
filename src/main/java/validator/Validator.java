package validator;

public abstract class Validator {

    public boolean validateInput(String input) {
        return !isInputEmpty(input) && isInputLegal(input);
    }

    protected boolean isInputEmpty(String input) {
        return input.isEmpty();
    }

    protected abstract boolean isInputLegal(String input);
}
