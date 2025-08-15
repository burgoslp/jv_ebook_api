package validations;

import org.springframework.beans.factory.annotation.Autowired;

import com.leopoldo.ebook.ebook.repositories.IUserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUserUsernameValidator implements ConstraintValidator<UniqueUserUsername, String> {

    @Autowired
    private IUserRepository userRepository;
   
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      
        if (value == null || value.isBlank()) {
            return true; // Skip validation for null or blank values
        }

        // Check if the username already exists in the repository
        return !userRepository.existsByUsername(value);
    }

}
