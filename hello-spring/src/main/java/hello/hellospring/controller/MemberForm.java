package hello.hellospring.controller;

import org.springframework.web.bind.annotation.PostMapping;

public class MemberForm {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
