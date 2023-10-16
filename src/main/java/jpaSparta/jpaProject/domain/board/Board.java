package jpaSparta.jpaProject.domain.board;

import jpaSparta.jpaProject.domain.Member;
import jpaSparta.jpaProject.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "board")
@Getter @Setter
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "board_date")
    private LocalDateTime localDateTime;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "board_name")
    private String name;

    @Column(name = "board_contents")
    private String contents;

    @Column(name = "board_score")
    private String score;
}
