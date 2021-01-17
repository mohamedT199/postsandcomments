package com.example.testapp.models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(primaryKeys = {"postId","id"})
public class DetailsModel {

    /**
     * postId : 1
     * id : 1
     * name : id labore ex et quam laborum
     * email : Eliseo@gardner.biz
     * body : laudantium enim quasi est quidem magnam voluptate ipsam eos
     tempora quo necessitatibus
     dolor quam autem quasi
     reiciendis et nam sapiente accusantium
     */


    @NotNull
    private Integer postId;
    @NotNull
    private Integer id;
    private String name;
    private String email;
    private String body;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
