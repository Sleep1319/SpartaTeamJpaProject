package jpaSparta.jpaProject.api;

import jpaSparta.jpaProject.dto.OrderDTO;
import jpaSparta.jpaProject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderService orderService;

    @PostMapping("/OrderInsert/api")
    public ResponseEntity<Map<String, Object>> InsertOrder (@RequestBody @Valid OrderDTO orderDTO) {
    Map<String, Object> response = new HashMap<>();
        try {
            orderService.order(orderDTO.getMember_id(), orderDTO.getItem_id(), orderDTO.getCount());
            response.put("message", "오더 등록 성공");
            response.put("status", 200);
            return ResponseEntity.ok(response);
        } catch (IllegalAccessError e) {
            response.put("message", "오더 등록 실패");
            response.put("status", 400);
            return ResponseEntity.ok(response);
        }
    }
}
