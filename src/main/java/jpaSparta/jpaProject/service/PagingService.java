//package jpaSparta.jpaProject.service;
//
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//
//import java.util.List;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class PagingService {
//
//    private int allCount; // 글 총 개수
//    private int unit;     // 노출되는 글 (10개씩)
//    private int viewPage; // 노출되는 페이지 (5페이지씩)
//
//    public List<?> getBoardPage(List<?> object, int currentPage, int unit, int viewPage, Model model) {
//        this.unit = unit;
//        this.viewPage = viewPage;
//        this.allCount = object.size();
//
//        int start = (currentPage - 1) * unit;
//        int end = allCount;
//
//        if ((currentPage * unit) < end) {
//            end = start + unit;
//        }
//
//        if (viewPage != 0) {
//            this.setStartEndPage(currentPage, model);
//        }
//
//        return object.subList(start, end);
//    }
//
//    @Getter
//    private int start;
//    @Getter
//    private int end;
//    @Getter
//    private int previous;
//    @Getter
//    private int next;
//    @Getter
//    private int maxPage;
//
//    public void setStartEndPage(int currentPage, Model model) {
//        maxPage = this.allCount;
//        int plusPage = this.allCount % this.unit;
//
//        if (plusPage > 0) {
//            maxPage++;
//        }
//
//        int firstPage = (currentPage / (this.viewPage + 1)) + 1;
//
//        if (currentPage > this.viewPage) {
//            if (currentPage % this.viewPage != 0) {
//                firstPage = ((currentPage / this.viewPage) * this.viewPage) + 1;
//            } else {
//                firstPage = ((currentPage / this.viewPage) - 1) * this.viewPage + 1;
//            }
//        }
//
//        int lastPage = firstPage + this.viewPage - 1;
//
//        start = firstPage;
//        end = lastPage;
//        previous = start - unit + 1;
//        next = end + 1;
//
//        if (previous < 0) {
//            previous = 1;
//        }
//
//        if (lastPage > maxPage) {
//            end = maxPage;
//            next = end;
//        }
//
//        if (end == maxPage) {
//            next = maxPage;
//        }
//
//
//        model.addAttribute("resetPage", 1);
//        model.addAttribute("previous", this.getPrevious());
//        model.addAttribute("start", this.getStart());
//        model.addAttribute("end", this.getEnd());
//        model.addAttribute("next", this.getNext());
//        model.addAttribute("lastPage", this.getMaxPage());
//
//    }
//}
