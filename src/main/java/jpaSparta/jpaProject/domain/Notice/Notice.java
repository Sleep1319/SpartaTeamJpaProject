package jpaSparta.jpaProject.domain.Notice;

import jpaSparta.jpaProject.domain.Member;
import jpaSparta.jpaProject.dto.MemberDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.security.PrivateKey;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Notice {


    @Id
    @GeneratedValue
    @Column(name = "idx")
    private int idx;

    @Column(name = "nTitle")
    private String nTitle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Member member;

    @Column(name = "content")
    private String content;

    @CreationTimestamp
    @Column(updatable = true)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}

