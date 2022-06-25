package Entities;

import TADs.MyHashTableIMPL;
import TADs.MyLinkedList;
import TADs.MyLinkedListImpl;


public class User {

    private String username;

    private MyHashTableIMPL<Long,Review> resenia = new MyHashTableIMPL<>(2000);


    public User(String username) {
        this.username = username;}

    public String getUsername() {
        return username;}

    public void setUsername(String username) {
        this.username = username;}

    public MyHashTableIMPL<Long,Review> getReviews() {
        return resenia;}

    public void setReviews(MyHashTableIMPL<Long,Review> resenia)
    {this.resenia = resenia;}

}