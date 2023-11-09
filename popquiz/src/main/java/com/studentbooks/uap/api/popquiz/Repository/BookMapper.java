package com.studentbooks.uap.api.popquiz.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.studentbooks.uap.api.popquiz.models.Book;

@Mapper
public interface BookMapper {
	@Insert("INSERT INTO borrowed_books (book_code, title, type_code) VALUES (#{bookCode}, #{title}, #{typeCode})")
    void insertBook(Book book);
    List<Book> selectBooksByType(String typeCode);
    List<Book> selectAllBooks();
}