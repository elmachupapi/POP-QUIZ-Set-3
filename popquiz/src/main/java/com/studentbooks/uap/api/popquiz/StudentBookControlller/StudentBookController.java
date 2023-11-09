package com.studentbooks.uap.api.popquiz.StudentBookControlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.studentbooks.uap.api.popquiz.models.Book;
import com.studentbooks.uap.api.popquiz.models.Student;
import com.studentbooks.uap.api.popquiz.repository.BookMapper;
import com.studentbooks.uap.api.popquiz.repository.StudentMapper;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentBooksController {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private BookMapper bookMapper;

    // Endpoint for creating a student and borrowing books
    @PostMapping("/borrow")
    public Student borrowBooks(@RequestBody Student student) {
        studentMapper.insertStudent(student);

        List<Book> books = student.getBooks();
        for (Book book : books) {
            bookMapper.insertBook(book);
        }

        Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));

        return student;
    }

    // Endpoint for getting books by type
    @GetMapping("/books/{type}")
    public List<Book> getBooksByType(@PathVariable String type) {
        return bookMapper.selectBooksByType(type);
    }
}
