package org.example.bookshop.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookshop.dao.BookDao;
import org.example.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

//    public String listBooks(Model model){
//        model.addAttribute("books",bookService.listBooks());
//    }

}
