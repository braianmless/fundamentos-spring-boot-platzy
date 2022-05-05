package com.fundamentosplatzi.springboot.fundamentos.entity;

import javax.persistence.*;

@Entity
@Table(name = "post")

public class Post {
    //siempre debe llevar un id, representa la identidad a nivel de la tabla en la BD
    @Id
    //generatedvalue para que genere un id unico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true) //representa el nombre id a nivel de BD
    private long id; //representa la columna como un valor en la clase, es el mismo de la anotacion @id
    @Column(name = "description", length = 255)
    private String description; //representa la columna como un valor en la clase

    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
