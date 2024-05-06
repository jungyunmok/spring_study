package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id // pk설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id값 알아서 생성해줌
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
