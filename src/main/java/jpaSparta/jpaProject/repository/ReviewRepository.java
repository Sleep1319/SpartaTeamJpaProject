//package jpaSparta.jpaProject.repository;
//
//import jpaSparta.jpaProject.domain.Member;
//import jpaSparta.jpaProject.domain.board.Review;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class ReviewRepository {
//
//    private final EntityManager em;
//
//    public void save(Review review) {
//        if (review.getId() == null) {
//            em.persist(review);
//        } else {
//            em.merge(review);
//        }
//    }
//
//    public Review findOne(Long id) { return em.find(Review.class, id); }
//
//    public List<Review> findAll() {
//        return em.createQuery("SELECT r FROM Review r", Review.class)
//                .getResultList();
//    }
//
//    public List<Review> findByItemId(Long itemId) {
//        return em.createQuery("SELECT r FROM Review r WHERE r.item.id =:itemId", Review.class)
//                .setParameter("itemId", itemId)
//                .getResultList();
//    }
//
//    public List<Review> findByMemberId(Long memberId) {
//        return em.createQuery("SELECT r FROM Review r WHERE r.member.id =:memberId", Review.class)
//                .setParameter("memberId", memberId)
//                .getResultList();
//    }
//
//
//}
