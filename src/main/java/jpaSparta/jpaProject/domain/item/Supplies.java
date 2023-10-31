package jpaSparta.jpaProject.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Supplies")
@Getter
@Setter
public class Supplies extends Item{
    private String usage;
}
