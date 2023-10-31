//package jpaSparta.jpaProject.controller;
//
//import jpaSparta.jpaProject.domain.Member;
//import jpaSparta.jpaProject.domain.board.Comment;
//import jpaSparta.jpaProject.domain.board.Review;
//import jpaSparta.jpaProject.dto.CommentDTO;
//import jpaSparta.jpaProject.dto.ReviewDTO;
//import jpaSparta.jpaProject.service.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.HttpSession;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.time.format.DateTimeFormatter;
///**
// *   리뷰 관련
// * */
//
//@Controller
//@RequiredArgsConstructor
//public class ReviewController {
//
//    private final ReviewService reviewService;
//    private final CommentService commentService;
//    private final PagingService pagingService;
//    private final ItemService itemService;
//    private final MemberService memberService;
//
//
//    /**
//     *         상품 리뷰
//     * */
//
//    // 리뷰 목록
//    @GetMapping(value = "/{itemId}/reviews/{page}")
//    public String reviews(@PathVariable("itemId") Long itemId, @PathVariable("page") int page, Model model, HttpSession session) {
//        List<Review> reviews = reviewService.findByItemId(itemId);
//        pagingService.getBoardPage(reviews, page, 10, 5, model);
//        model.addAttribute("reviewCount", reviews.size());
//
//        return "itemReview";    // 아이템리뷰페이지
//    }
//
//    // 리뷰 등록 폼
//    @GetMapping(value = "/{itemId}/review/new")
//    public String createReviewForm(@PathVariable("itemId") Long itemId, Model model, HttpSession session) {
//        if (memberService.getLoginMember(session) == null) {
//            return "member/login"; // 로그인이 안되어 있을 경우 로그인 페이지로
//        }
//        ReviewDTO form = new ReviewDTO();
//        form.setItemId(itemId);
//
//        model.addAttribute("form", form);
//
//        return "review/createReview"; // 리뷰 등록 페이지로
//    }
//
//    // 리뷰 등록
//    @PostMapping(value = "/{itemId}/review//new")
//    public String createReview(@PathVariable("itemId") Long itemId, @ModelAttribute("form") ReviewDTO form, Model model, HttpSession session) {
//        if (memberService.getLoginMember(session) == null) {
//            return "member/login"; // 로그인이 안되어 있을 경우 로그인 페이지로
//        }
//        Long memberId = memberService.getLoginMemberId(session);
//        Review review = new Review();
//
//        review.setUser_name(review.getUser_name());
//        review.setItem(itemService.findOne(form.getItemId()));
//        review.setTitle(review.getTitle());
//        review.setContents(review.getContents());
//        review.setScore(review.getScore());
//        review.setWriteDate(LocalDateTime.now());
//        review.setMember(memberService.findOne(memberId));
//
//        reviewService.saveReview(review);
//
//        return "redirect:/상품페이지/{itemId}"; // 리뷰 등록 후 어디로 갈건지 상의 해야함
//    }
//
//    // 리뷰 수정 폼
//    @GetMapping(value = "/update/review/{reviewId}")
//    public String updateReviewForm(@PathVariable("reviewId") Long reviewId, Model model, HttpSession session) {
//        if (memberService.getLoginMember(session) == null) {
//            return "member/login";
//        }
//
//        Long memberId = memberService.getLoginMemberId(session);
//        Review review = reviewService.findOne(reviewId);
//
//        if (memberId != review.getMember().getId() || session.getAttribute("Role").equals("ADMIN")) {
//            return "error"; // 이 부분은 상의해서 해야함 2023-10-26 작성
//        }
//
//        ReviewDTO form = new ReviewDTO();
//        form.setReviewId(reviewId);
//        form.setTitle(review.getTitle());
//        form.setContents(review.getContents());
//
//        model.addAttribute("form", form);
//
//        return "review/createReivew";
//    }
//
//    // 리뷰 수정
//    @PostMapping(value = "/update/review/{reviewId}")
//    public String updateReview(@PathVariable("reviewId") Long reviewId, @ModelAttribute("form") ReviewDTO form, Model model, HttpSession session) {
//        if (memberService.getLoginMember(session) == null) {
//            return "member/login";
//        }
//
//        Review review = reviewService.findOne(reviewId);
//
//        review.setTitle(form.getTitle());
//        review.setContents(form.getContents() + " [수정 : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm")) + "]");
//
//        reviewService.saveReview(review);
//
//        return "redirect:/상품페이지/{itemId}"; // 리뷰 수정 완료 후 어디로 갈지 상의 해야 함
//    }
//
//    // 리뷰 상세 페이지
//    @GetMapping(value = "/{itemId}/review/{reviewId}")
//    public String reviewPage(@PathVariable("itemId") Long itemId, @PathVariable("reviewId") Long reviewId, Model model, HttpSession session) {
//
//        Review review = reviewService.findOne(reviewId);
//        model.addAttribute("review", review);
//        model.addAttribute("comments", commentService.findComments(review));
//
//        // 댓글
//        CommentDTO commentDTO = new CommentDTO();
//        commentDTO.setItemId(itemId);
//        model.addAttribute("form", commentDTO);
//
//        // 수정 화면
//        model.addAttribute("updateForm", commentDTO);
//
//        // 댓글 주인 확인
//        try {
//            Member member = memberService.getLoginMember(session);
//            model.addAttribute("memberId", member.getId());
//            model.addAttribute("memberRole", member.getRole());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "reviewPage";
//    }
//
//    /**
//     *      댓글
//     * */
//
//    // 댓글 등록
//    @PostMapping(value = "/{itemId}/review/{reviewId}/{parentId}")
//    public String createComment(@PathVariable("itemId") Long itemId, @PathVariable("reviewId") Long reviewId, @PathVariable("parentId") Long parentId,
//                                @ModelAttribute("form") CommentDTO form, Model model, HttpSession session) {
//        if (memberService.getLoginMember(session) == null) {
//            return "member/login";
//        }
//
//        Long memberId = memberService.getLoginMemberId(session);
//
//        Comment comment = new Comment();
//        comment.setContents(form.getContents());
//        comment.setParent(0L);
//
//        LocalDateTime date = LocalDateTime.now();
//        comment.setDate(date);
//
//        comment.setMember(memberService.findOne(memberId));
//        comment.setReview(reviewService.findOne(reviewId));
//
//        if (parentId != 0) {
//            Comment parent = commentService.findOne(parentId);
//            Long num;
//            while (true) {
//                num = parent.getParent();
//                if (num == 0L) {
//                    break;
//                }
//                parent = commentService.findOne(parent.getParent());
//            }
//            comment.setParent(parentId);
//        }
//        commentService.saveComment(comment);
//
//        return "redirect:/{itemId}/review/{reviewId}";
//    }
//
//    // 댓글 수정
//    @PostMapping(value = "/update/comment/{commentId}")
//    public String updateComment(@PathVariable("commentId") Long commentId, @ModelAttribute("form") CommentDTO form, Model model, HttpSession session) {
//        if (memberService.getLoginMember(session) == null) {
//            return "member/login";
//        }
//        Comment comment = commentService.findOne(commentId);
//        comment.setContents(form.getContents() + " [수정 : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm")) + "]");
//
//        commentService.saveComment(comment);
//
//        return "redirect:/{itemId}/review/{reviewId}";
//    }
//
//    // 댓글 삭제
//    @GetMapping(value = "/delete/comment/{commentId}")
//    public String deleteComment(@PathVariable("commentId") Long commentId, HttpSession session) {
//        if (memberService.getLoginMember(session) == null) {
//            return "member/login";
//        }
//        Review review = commentService.deleteComments(commentId);
//
//        return "redirect:/back";  // history.back();
//    }
//}
