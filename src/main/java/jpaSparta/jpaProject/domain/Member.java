package jpaSparta.jpaProject.domain;

//import jpaSparta.jpaProject.domain.board.Comment;
//import jpaSparta.jpaProject.domain.board.Review;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@DynamicUpdate
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "user_id", unique = true)
    private String user_id;

    @Column(name = "user_pw")
    private String pw;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_phone")
    private String phone;

//    @Column(name = "user_birth")
//    private Date birth;//타입 util인지 sql인지 구분 부탁

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

//    @Enumerated(EnumType.STRING)
//    private Role role;

//    @OneToMany(mappedBy = "member")
//    private List<Review> reviews = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<Comment> comments = new ArrayList<>();
}
