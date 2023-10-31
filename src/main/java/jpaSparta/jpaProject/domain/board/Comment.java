//package jpaSparta.jpaProject.domain.board;
//
//import jpaSparta.jpaProject.domain.Member;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import java.time.LocalDateTime;
//
//@Entity
//@Getter @Setter
//public class Comment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "comment_id")
//    private Long id;
//
//    @NotEmpty(message = "내용을 입력하셔야 합니다.")
//    private String contents; // 댓글 내용
//
//    private Long parent;
//
//    private LocalDateTime date; // 댓글 작성일
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "review_id")
//    private Review review;
//
//
//}
