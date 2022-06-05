package Entities;
import TADs.MyLinkedList;
import TADs.MyLinkedListImpl;


public class User {

    private String username;

    private MyLinkedList<Review> reviews = new MyLinkedListImpl<>();

    public User(String username) {this.username = username;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public MyLinkedList<Review> getReviews() {return reviews;}

    public void setReviews(MyLinkedList<Review> reviews) {this.reviews = reviews;}

}
