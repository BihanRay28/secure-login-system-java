class Validator{ //Validator class to validate email and password
    public static boolean isValidEmail(String email){
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";   // Regular expression for validating email format 
        return email.matches(emailRegex);
    }
    
    public static boolean isValidPassword(String password){
        if (password.length() < 6){ // Check if password is at least 6 characters long
            return false;
        }

        if (!password.matches(".*\\d.*")){ // Check if password contains at least one digit
            return false;
        }
        return true; // If both conditions are satisfied, return true

    } 
}
