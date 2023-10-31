//package jpaSparta.jpaProject.domain.board;
//
//import jpaSparta.jpaProject.domain.Member;
//import jpaSparta.jpaProject.domain.item.Item;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Entity
//@Getter @Setter
//@EntityListeners(AuditingEntityListener.class)
//public class Review {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "review_id")
//    private Long id;
//
//    @Column(name = "user_name")
//    private String user_name; // 작성자
//
//    @OneToOne
//    @JoinColumn(name = "item_id")
//    private Item item;
//
//    @Column(name = "review_title")
//    @NotEmpty(message = "제목을 입력하셔야 합니다.")
//    private String title; // 제목
//
//    @Column(name = "review_contents", length = 500, nullable = false)
//    @NotEmpty(message = "내용을 입력하셔야 합니다.")
//    private String contents; // 내용
//
//    @Column(name = "review_score")
//    private String score; // 별점
//
////    @CreatedDate()
//    private LocalDateTime writeDate;  // 작성일
//
////    @LastModifiedDate
////    private LocalDateTime modifyDate; //수정일
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;
//
//    @OneToMany(mappedBy = "review")
//    private List<Comment> comments = new ArrayList<>();
//}
//
