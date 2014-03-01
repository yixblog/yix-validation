package cn.yixblog.validation.constraints;

import cn.yixblog.validation.validators.DateTimeStringValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * date&time format validation
 * the annotated item must be a String that matches the DateFormat pattern and should be a legal date/time string
 * Created by Yixian on 14-3-1.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {DateTimeStringValidator.class})
public @interface DateTimeString {
    String message() default "{cn.yixblog.validation.contraints.DateTimeString}";
    String pattern() default "yyyy-MM-dd HH:mm:ss";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
