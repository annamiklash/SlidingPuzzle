package mi.mi.miklash.slidingpuzzle;

import java.util.Optional;

public class Test {

    public static void main(String[] args) {

        Optional<String> optionalString = getValue();

        if (optionalString.isPresent()) {
            System.out.println("optionalString contains: " + optionalString.get());
        } else {
            System.out.println("Optional is empty");
        }


    }

    private static Optional<String> getValue() {

        return Optional.empty();
//        return Optional.of("Ania");
    }
}
