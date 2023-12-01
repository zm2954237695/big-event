package com.guo.event.anno;


import com.guo.event.validation.StateValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StateValidation.class})
public @interface State {

    String message() default "state参数的值只能是已发布或者草稿";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
