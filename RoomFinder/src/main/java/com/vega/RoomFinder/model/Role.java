package com.vega.RoomFinder.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;


@Entity
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    String name;

   @ManyToMany(mappedBy = "roles")
    List<User> users;

   public Role()
   {

   }
   public int getId(){
       return id;
   }

//    public Role(int id, String name, List<User> users) {
//        this.id = id;
//        this.name = name;
//        this.users = users;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}