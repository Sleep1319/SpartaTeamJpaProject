//package jpaSparta.jpaProject.repository;
//
//import jpaSparta.jpaProject.domain.board.Comment;
//import jpaSparta.jpaProject.domain.board.Review;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class CommentRepository {
//
//    private final EntityManager em;
//
//    public void save(Comment comment) {
//        if (comment.getId() == null) {
//            em.persist(comment);
//        } else {
//            em.merge(comment);
//        }
//    }
//
//    public Comment findOne(Long id) {
//        return em.find(Comment.class, id);
//    }
//
//    public List<Comment> findAll(Review review) {
//        return em.createQuery("SELECT c FROM Comment c WHERE c.review =:review ORDER BY C.date ASC", Comment.class)
//                .setParameter("review", review)
//                .getResultList();
//    }
//
//    public void delete(Comment comment) { em.remove(comment); }
//
//    public List<Comment> findByMemberId(Long memberId) {
//        return em.createQuery("SELECT c FROM Comment c WHERE c.member.id =:memberId", Comment.class)
//                .setParameter("memberId", memberId)
//                .getResultList();
//    }
//
//    public List<Comment> findByParentId(Long commentId) {
//        return em.createQuery("SELECT c FROM Comment c WHERE c.parent =:parentId", Comment.class)
//                .setParameter("parentId", commentId)
//                .getResultList();
//    }
//}
