package com.manning.sbip.ch02.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordRuleValidator.class)
public @interface Password {
    String message() default "Password  do not adhere to the specfifed rule";
    Class<?>[]groups() default {};
    Class<? extends Payload>[]payload() default {};

    /* @Target : @PassWord를 적용할 대상 타입을 지정함
       @Retention : @Password 어노테이션이 언제까지 효력을 살아남는지 지정함, RUNTIME지정시 런타임까지
       @Constraint : @Password 어노테이션이 빈 밸리데이션 제약사양에 포함하는 어노테이션임을 의미,
                     , validateBy 속성을 사용해서제약 사항이 구현된 클래스를 지정
       message() : 유효성 검증에 실패할 때 표시해야하는 문자열 지정
       Class<?>[] groups() : 이 메서드를 사용해 그룹을 지정하면 밸리데이션을 그룹 별로 적용가능.
       Class<? extends Payload>[]payload() : 밸리데이션 클라이언트가 사용하는 메타데이터를
                                             전달하기위해 사용. 여기서는 아무런 페이로드를 지정하지않음.
     */
}
