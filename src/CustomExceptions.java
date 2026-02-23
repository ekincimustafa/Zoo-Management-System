public class CustomExceptions {
    // Exception for unknown animal type
    public static class UnknownAnimalTypeException extends Exception {
        public UnknownAnimalTypeException(String name) {
            super("There are no animals with the name " + name + ".");
        }
    }
    // Exception for person not found
    public static class PersonNotFoundException extends Exception {
        public PersonNotFoundException(int id) {
            super(" There are no visitors or personnel with the id " + id);
        }
    }
    // Exception for insufficient food
    public static class InsufficientFoodException extends Exception {
        public InsufficientFoodException(String type) {
            super(" Not enough " + type);
        }
    }
    // Exception for unauthorized action
    public static class UnauthorizedActionException extends Exception {
        public UnauthorizedActionException() {
            super(" Visitors do not have the authority to feed animals.");
        }
    }
}
