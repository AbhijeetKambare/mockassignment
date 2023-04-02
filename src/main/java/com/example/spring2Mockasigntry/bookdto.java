package com.example.spring2Mockasigntry;

import com.example.spring2Mockasigntry.Model.Author;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class bookdto {
    private String bookname;
    private int pages;

    private int authorID;
}
