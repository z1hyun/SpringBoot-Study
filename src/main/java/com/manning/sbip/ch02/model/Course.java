package com.manning.sbip.ch02.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

    private long id;
    private String name;
    private String category;

    //비즈니스 제약사항 : 최소 1점  ~ 최소 5점까지 부여할 수 음. 이 제약사항이 충족되지 않으면 어노테이션이 지정한 에러메시지가 표시됨.
    @Min(value = 1, message = "A course should have a minimum of 1 rating")
    @Max(value = 5, message = "A course should have a maximum of 5 rating")
    private int rating;

    private String description;

    public Course() {
    }

    /* 위 @Min, @Max 외에도 필드에 붙여 사용하는 하이버네이트 밸리데이터 애너테이션이 존재한다.
        @NotBlank : CharSequence 타입 필드에 사용되어 문자여링 null이 아니고, 앞뒤 공백 문자를 제거한 후 문자열 길이가 0보다 크다는 것을 검사
        @NotEmpty : CharSequence,Collection,Map 타입과 배열에 사용되어 null이 아니고 비어있지 않음을 검사한다.
        @NotNull : 모든 타입에 사용할 수 있으며 null이 아님을 검사한다.
        @Email : 문자열이 유효한 이메일 주소를 나타내는지 검사
        @Size(min=, max=) : 개수의 최솟값,최댓값을 준수하는지 검사
        @Pattern(regex= , flags) : regex로 지정한 정규 표현식을 준수하는지 검사함. 정규표현식의 flag도 사용가능.


        @Min : 최솟값을 지정해서 이 값보다 크거나 같은지 검사
        @Max : 최댓값을 지정해서 이 값보다 작거나 같은지 검사

     */

}
