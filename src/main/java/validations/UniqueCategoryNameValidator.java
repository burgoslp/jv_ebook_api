package validations;

import org.springframework.beans.factory.annotation.Autowired;

import com.leopoldo.ebook.ebook.repositories.ICategoryRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueCategoryNameValidator implements ConstraintValidator<UniqueCategoryName,String> {

    @Autowired
    private ICategoryRepository cr;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        if(name == null || name.isBlank()){
            return true;
        }

        return !cr.existsByName(name);
    }

}
