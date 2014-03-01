package cn.yixblog.validation.validators;

import cn.yixblog.validation.constraints.DateTimeString;
import org.apache.commons.lang.time.DateUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.util.Date;

/**
 * validator to check the @DateTimeString validation
 * Created by Yixian on 14-3-1.
 */
public class DateTimeStringValidator implements ConstraintValidator<DateTimeString, String> {
    private String pattern;

    @Override
    public void initialize(DateTimeString constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        try {
            Date date = DateUtils.parseDateStrictly(value, new String[]{pattern});
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
