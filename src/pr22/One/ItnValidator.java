package pr22.One;



public class ItnValidator implements Validator<String> {

    @Override
    public void validate(String value) {
        if (value.length() != 10) {
            throw new IllegalArgumentException("Value must consist of ten numbers.");
        }
        if (value.charAt(0) == '0') {
            throw new IllegalArgumentException("Value can't start with zero.");
        }
        for (int i = 1; i < 10; i++) {
            if (!Character.isDigit(value.charAt(i))) {
                throw new IllegalArgumentException("Value can't have non digit symbols.");
            }
        }
    }
}