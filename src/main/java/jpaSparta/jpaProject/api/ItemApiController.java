//package jpaSparta.jpaProject.api;
//
//import jpaSparta.jpaProject.domain.item.Item;
//import jpaSparta.jpaProject.dto.ItemDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor
//public class ItemApiController {
//
//    @PostMapping("/itemInsert")
//    public ResponseEntity<Map<String , Object>> InsertItem (@RequestBody @Valid ItemDTO itemDTO){
//        Item item = new Item();
//        item.setId(itemDTO.getId());
//        item.setName(itemDTO.getName());
//        item.setPrice(itemDTO.getPrice());
//        item.setStockQuantity(itemDTO.getStockQuantity());
//        item.setInfo(itemDTO.getInfo());
//
//
//    }

//    @PutMapping("/item/api")
//    public ResponseEntity<Map<String, Object>> UpdateItem (@RequestBody @Valid ItemDTO itemDTO)
//}
