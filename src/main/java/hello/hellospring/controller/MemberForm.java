package hello.hellospring.controller;

public class MemberForm {
    // html의 name 값을 setName을 통해 name에 넣어줌
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
