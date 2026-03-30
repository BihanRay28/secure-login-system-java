class InvalidUserException extends Exception{ // Custom exception for invalid user input
    public InvalidUserException(String message){
        super(message);
    }
}