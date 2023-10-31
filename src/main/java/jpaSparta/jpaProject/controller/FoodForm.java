package jpaSparta.jpaProject.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FoodForm {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String info;
    private String age;
}
