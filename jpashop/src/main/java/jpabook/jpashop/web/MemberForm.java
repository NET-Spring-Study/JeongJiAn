package jpabook.jpashop.web;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message="Member name is essential")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
