package jpaSparta.jpaProject.service;

import jpaSparta.jpaProject.domain.item.Food;
import jpaSparta.jpaProject.domain.item.Item;
import jpaSparta.jpaProject.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Long saveItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOnd(itemId);
    }

    public int UpdateItem(Item item) { return itemRepository.UpdateItem(item); }

    public int DeleteItem(Long id) { return itemRepository.DeleteItem(id); }
    @Transactional
    public void updateItem(Long itemId, int price, String name, int stockQuantity) {
        //변경 감지한 이용한 엔티티 업데이트
        Item findItem = itemRepository.findOnd(itemId);//아이템 정보 찾고

        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);

    }

//    @Transactional
//    public Long saveFood(Food food){
//        itemRepository.save(food);
//        return food.getId();
//    }

}