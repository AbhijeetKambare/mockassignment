package com.example.spring2Mockasigntry.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private  char gender;
    private float rating;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Boook> boookList =new ArrayList<>();
}
