package com.example.exercise.controller;

import com.example.exercise.model.Book;
import com.example.exercise.model.BorrowedBook;
import com.example.exercise.service.IBookService;
import com.example.exercise.service.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowedBookService borrowedBookService;

    @GetMapping("")
    public String getListBook(Model model) {
        model.addAttribute("listBook", bookService.listBook());
        model.addAttribute("book", new Book());
        return "list";
    }

    @GetMapping("/rent/{id}")
    public String showRentBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "rent";
    }

    @PostMapping("/rentBook")
    public String rentBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        Random random = new Random();
        String bookCode = String.valueOf(random.nextInt(99999 - 10000 + 1) + 10000);
        if (book.getQuantity() == 0) {
            return "error";
        }
        book.setQuantity(book.getQuantity() - 1);
        bookService.update(book);
        Book book1 = new Book(book.getId());
        BorrowedBook borrowedBook = new BorrowedBook(bookCode, book1);
        borrowedBookService.save(borrowedBook);
        redirectAttributes.addFlashAttribute("mess", " Mượn sách thành công");
        redirectAttributes.addFlashAttribute("codeBook", " Mã mượn sách của bạn" + bookCode);
        return "redirect:/list";

    }

    @PostMapping("/pay")
    public String bookReturn(@RequestParam String codeBook, RedirectAttributes redirectAttributes) {
        Book book;


        for (BorrowedBook borrowedBook : borrowedBookService.findAll()) {
            if (codeBook.equals(borrowedBook.getId())) {
                book = bookService.findById(borrowedBook.getBook().getId());
                book.setQuantity(book.getQuantity() + 1);
                bookService.update(book);
                redirectAttributes.addFlashAttribute("mess", "Trả sách thành công");
                return "redirect:/book";
            }
        }
        return "error";
    }
}


