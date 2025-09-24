package com.manning.sbip.ch02.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.ArrayList;
import java.util.List;

public class PasswordRuleValidator implements ConstraintValidator<Password, String> {

    private static final int MIN_COMPLEX_RULES = 2;
    private static final int MAX_REPETITIVE_CHARS = 3;
    private static final int MIN_SPECIAL_CASE_CHARS = 1;
    private static final int MIN_UPPER_CASE_CHARS = 1;
    private static final int MIN_LOWER_CASE_CHARS = 1;
    private static final int MIN_DIGIT_CASE_CHARS = 1;

    /* ConstraintValidaton 인터페이스를 구현함으로 isValid()메서드를 구현해야함
    *  isValid() 메서드는 유효성 검증 로직에 따라 true/false를 반환함
    * */
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        List<Rule> passwordRules = new ArrayList<>();
        passwordRules.add(new LengthRule(8,30));   //pwd 길이 최소3~ 최대30자
        CharacterCharacteristicsRule characterCharacteristicsRule =
                new CharacterCharacteristicsRule(MIN_COMPLEX_RULES,
                        new CharacterRule(EnglishCharacterData.Special, MIN_SPECIAL_CASE_CHARS),
                        new CharacterRule(EnglishCharacterData.UpperCase,MIN_UPPER_CASE_CHARS), //대문자 추가
                        new CharacterRule(EnglishCharacterData.LowerCase,MIN_LOWER_CASE_CHARS), //소문자 추가
                        new CharacterRule(EnglishCharacterData.Digit,MIN_DIGIT_CASE_CHARS));

        passwordRules.add(characterCharacteristicsRule);
        passwordRules.add(new RepeatCharacterRegexRule(MAX_REPETITIVE_CHARS)); //동일한 문자는 3번만 가능
        PasswordValidator validator = new PasswordValidator(passwordRules);
        PasswordData passwordData = new PasswordData(password);
        RuleResult ruleResult = validator.validate(passwordData);

        return ruleResult.isValid();
    }
}
