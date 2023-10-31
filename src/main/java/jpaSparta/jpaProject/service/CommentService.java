//package jpaSparta.jpaProject.service;
//
//import jpaSparta.jpaProject.domain.board.Comment;
//import jpaSparta.jpaProject.domain.board.Review;
//import jpaSparta.jpaProject.repository.CommentRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class CommentService {
//
//    private final CommentRepository commentRepository;
//
//    @Transactional
//    public void saveComment(Comment comment) {
//        commentRepository.save(comment);
//    }
//
//    @Transactional
//    public List<Comment> findByMemberId(Long memberId) {
//        return commentRepository.findByMemberId(memberId);
//    }
//
//    @Transactional
//    public void updateComment(Long id, String contents) {
//        Comment comment = commentRepository.findOne(id);
//        comment.setContents(contents);
//        comment.setDate(LocalDateTime.now());
//    }
//
//    public List<Comment> findComments(Review review) { return commentRepository.findAll(review); }
//
//    public Comment findOne(Long parentId) { return commentRepository.findOne(parentId); }
//
//    @Transactional
//    public Review deleteComments(Long commentId) {
//
//        Comment comment = commentRepository.findOne(commentId);
//        Comment parent = commentRepository.findOne(comment.getParent());
//
//        Review review = comment.getReview();
//
//        // 부모 댓글이 삭제되면 자식댓글까지 삭제
//        if (comment.getParent() != 0) {
//            try {
//                parent.getContents();
//            } catch (NullPointerException e) {
//                e.printStackTrace();
//
//                commentRepository.delete(parent);
//                commentRepository.delete(comment);
//                throw e;
//            }
//        }
//
//        // 자식 없는 댓글 삭제
//        if (commentRepository.findByParentId(commentId).isEmpty()) {
//            commentRepository.delete(commentRepository.findOne(commentId));
//        } else {
//            // 자식이 있는 댓글이면 값을 null로 반환
//            comment.setContents(null);
//            commentRepository.save(comment);
//        }
//        return review;
//    }
//
//}
