package com.pollakesport.backend.domain_model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "team_id")
    private UUID id;

    @Column(name = "team_name")
    private String Name;

    @Column(name = "member_0")
    private String member0;

    @Column(name = "member_1")
    private String member1;

    @Column(name = "member_2")
    private String member2;

    @Column(name = "member_3")
    private String member3;

    @Column(name = "member_4")
    private String member4;

    public Team() { }
}
