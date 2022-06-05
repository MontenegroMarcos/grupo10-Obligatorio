package Entities;

import TADs.MyLinkedList;
import TADs.MyLinkedListImpl;

import java.util.Date;

public class Review {

    private Long id;

    private Date date;

    private Double overallScore;

    private Double aromaScore;

    private Double appearanceScore;

    private Double flavourScore;

    private MyLinkedList<Beer> beers = new MyLinkedListImpl<>();

    public Review(Long id, Date date, Double overallScore, Double aromaScore, Double appearanceScore, Double flavourScore) {
        this.id = id;
        this.date = date;
        this.overallScore = overallScore;
        this.aromaScore = aromaScore;
        this.appearanceScore = appearanceScore;
        this.flavourScore = flavourScore;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

    public Double getOverallScore() {return overallScore;}

    public void setOverallScore(Double overallScore) {this.overallScore = overallScore;}

    public Double getAromaScore() {return aromaScore;}

    public void setAromaScore(Double aromaScore) {this.aromaScore = aromaScore;}

    public Double getAppearanceScore() {return appearanceScore;}

    public void setAppearanceScore(Double appearanceScore) {this.appearanceScore = appearanceScore;}

    public Double getFlavourScore() {return flavourScore;}

    public void setFlavourScore(Double flavourScore) {this.flavourScore = flavourScore;}

    public MyLinkedList<Beer> getBeers() {return beers;}

    public void setBeers(MyLinkedList<Beer> beers) {this.beers = beers;}

}
