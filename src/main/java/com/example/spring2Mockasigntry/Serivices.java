package com.example.spring2Mockasigntry;

import com.example.spring2Mockasigntry.Model.Author;
import com.example.spring2Mockasigntry.Model.Boook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class Serivices {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    Bookrepository bookrepository;
    public String addAuthor(Author author){
//        Author author1= Author.builder().age(author.getAge()).name(author.getName()).gender(author.getGender())
//                .rating(author.getRating()).build();
        authorRepository.save(author);
        return "Author successfully created";
    }
    public String addBook(bookdto boook){
        Author author=authorRepository.findById(boook.getAuthorID()).get();
        Boook book1= Boook.builder().bookname(boook.getBookname()).pages(boook.getPages())
                .author(author).build();
        bookrepository.save(book1);
        return "book is added succesfully";
    }
    public List<Author> getAuthor(int givenAge, float rating){
        List<Author>ans=new ArrayList<>();
        List<Author>authorList=authorRepository.findAll();
        for(Author author:authorList){
            if(givenAge>= author.getAge() && author.getRating()>rating){
                ans.add(author);
            }
        }
        return ans;
    }
    public String updateBook(String BookName,int noOfPages){
        List<Boook>boooks=bookrepository.findAll();
        Boook changeBook=null;
        for (Boook boook:boooks){
            if (BookName.equals(boook.getBookname()))
                changeBook=boook;
        }
        changeBook.setPages(noOfPages);
        bookrepository.save(changeBook);
        return "pages has been updated suucessfully";
    }
    public  HashMap<Author, Integer> findNofBook(float rating){
        List<Author> authorList=authorRepository.findAll();
        List<Author> ratAuthors=new ArrayList<>();
        for (Author author:authorList){
            if(rating>= author.getRating()){
                ratAuthors.add(author);
            }
        }
        HashMap<Author,Integer> map=new HashMap<>();
        for (Author author:ratAuthors){
            map.put(author,author.getBoookList().size());
        }
        return map;
    }
}
