package com.example.spring2Mockasigntry;

import com.example.spring2Mockasigntry.Model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    Serivices serivices;
    @PostMapping("/addAuthor")
    public ResponseEntity addAuthor(@RequestBody() Author author){
        return new ResponseEntity<>(serivices.addAuthor(author), HttpStatus.CREATED);
    }
    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody() bookdto bookdto){
        return new ResponseEntity<>(serivices.addBook(bookdto),HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity getAuthors(@RequestParam() int givenAge,@RequestParam() float ratin){
        return new ResponseEntity<>(serivices.getAuthor(givenAge,ratin),HttpStatus.FOUND);
    }
    @PutMapping ("/update")
    public ResponseEntity updatesPages(@RequestParam() String name,@RequestParam() int pages){
        return new ResponseEntity<>(serivices.updateBook(name,pages),HttpStatus.ACCEPTED);
    }
    @GetMapping("/getxratedauthor")
    public ResponseEntity getratedauthours(int rating){
        return new ResponseEntity<>(serivices.findNofBook(rating),HttpStatus.FOUND);
    }
}
