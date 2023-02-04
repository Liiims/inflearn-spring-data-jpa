package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    @ToString.Exclude
    private List<Member> members = new ArrayList<>();

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Team(String name) {
        this.name = name;
    }
}
