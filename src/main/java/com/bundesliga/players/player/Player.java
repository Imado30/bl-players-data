package com.bundesliga.players.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "player_data")
public class Player {

    //Every Attribut from table player_data
    @Id
    @Column(name = "index", unique = true)      //Where to find the name in our database
    private Integer index;

    private String name;

    private String full_name;

    private Integer age;

    private Float height;

    private String nationality;

    private String place_of_birth;

    private Float price;

    private Float max_price;

    private String position;

    private Integer shirt_nr;

    private String foot;

    private String club;

    private String contract_expires;

    private String joined_club;

    private String player_agent;

    private String outfitter;

    public Player() {
    }

    public Player(Integer index,
                  String name,
                  String full_name,
                  Integer age,
                  Float height,
                  String nationality,
                  String place_of_birth,
                  Float price,
                  Float max_price,
                  String position,
                  Integer shirt_nr,
                  String foot,
                  String club,
                  String contract_expires,
                  String joined_club,
                  String player_agent,
                  String outfitter) {
        this.index = index;
        this.name = name;
        this.full_name = full_name;
        this.age = age;
        this.height = height;
        this.nationality = nationality;
        this.place_of_birth = place_of_birth;
        this.price = price;
        this.max_price = max_price;
        this.position = position;
        this.shirt_nr = shirt_nr;
        this.foot = foot;
        this.club = club;
        this.contract_expires = contract_expires;
        this.joined_club = joined_club;
        this.player_agent = player_agent;
        this.outfitter = outfitter;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getMax_price() {
        return max_price;
    }

    public void setMax_price(Float max_price) {
        this.max_price = max_price;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getShirt_nr() {
        return shirt_nr;
    }

    public void setShirt_nr(Integer shirt_nr) {
        this.shirt_nr = shirt_nr;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getContract_expires() {
        return contract_expires;
    }

    public void setContract_expires(String contract_expires) {
        this.contract_expires = contract_expires;
    }

    public String getJoined_club() {
        return joined_club;
    }

    public void setJoined_club(String joined_club) {
        this.joined_club = joined_club;
    }

    public String getPlayer_agent() {
        return player_agent;
    }

    public void setPlayer_agent(String player_agent) {
        this.player_agent = player_agent;
    }

    public String getOutfitter() {
        return outfitter;
    }

    public void setOutfitter(String outfitter) {
        this.outfitter = outfitter;
    }
}
