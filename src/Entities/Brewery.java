package Entities;

import TADs.MyLinkedList;
import TADs.MyLinkedListImpl;

public class Brewery {

    private Long id;

    private String name;

    private MyLinkedList<Review> reviews = new MyLinkedListImpl<>();

    public Brewery(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public MyLinkedList<Review> getReviews() {return reviews;}

    public void setReviews(MyLinkedList<Review> reviews) {this.reviews = reviews;}

}
