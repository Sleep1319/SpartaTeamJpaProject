package jpaSparta.jpaProject.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private Long member_id;
    private Long item_id;
    private int count;


}
