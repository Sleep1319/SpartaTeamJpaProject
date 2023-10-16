package jpaSparta.jpaProject.domain;

import jpaSparta.jpaProject.domain.board.Board;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "member")
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "user_pw")
    private String pw;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "user_birth")
    private Date birth;//타입 util인지 sql인지 구분 부탁

    @Column(name = "user_post")
    private String post;

    @Column(name = "user_addr")
    private String addr;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();
}
