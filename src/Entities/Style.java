package Entities;

import TADs.MyLinkedList;
import TADs.MyLinkedListImpl;

public class Style {

    private String name;

    private MyLinkedList<Beer> beers = new MyLinkedListImpl<>();

    public Style(String name) {this.name = name;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public MyLinkedList<Beer> getBeers() {return beers;}

    public void setBeers(MyLinkedList<Beer> beers) {this.beers = beers;}

}
