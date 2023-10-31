//package jpaSparta.jpaProject.service;
//
//import jpaSparta.jpaProject.domain.Member;
//import jpaSparta.jpaProject.domain.Role;
//import jpaSparta.jpaProject.domain.board.Review;
//import jpaSparta.jpaProject.repository.MemberRepository;
//import jpaSparta.jpaProject.repository.ReviewRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.servlet.http.HttpSession;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class ReviewService {
//
//    private final ReviewRepository reviewRepository;
//
//
//    @Transactional
//    public void saveReview(Review review){ reviewRepository.save(review); }
//
//    @Transactional
//    public List<Review> findByMemberId(Long memberId) { return reviewRepository.findByMemberId(memberId); }
//
//    @Transactional
//    public void updateReview(Long id, String contents) {
//        Review review = reviewRepository.findOne(id);
//        review.setContents(contents);
//        review.setWriteDate(LocalDateTime.now());
//    }
//
//    public Review findOne(Long reviewId) { return reviewRepository.findOne(reviewId); }
//
//    public List<Review> findByItemId(Long itemId) { return reviewRepository.findByItemId(itemId); }
//
//
//}
