package jpaSparta.jpaProject.domain;

import lombok.Getter;

import javax.persistence.Embeddable;


//상의 필요
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {

    }

    public Address(String city,String street,String zipcode) {
        this.city=city;
        this.street=street;
        this.zipcode=zipcode;
    }
}
