package com.example.spring2Mockasigntry;

import com.example.spring2Mockasigntry.Model.Boook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface Bookrepository extends JpaRepository<Boook,Integer> {
}
