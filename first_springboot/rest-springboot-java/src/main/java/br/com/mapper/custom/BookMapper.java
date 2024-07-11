package br.com.mapper.custom;

import org.springframework.stereotype.Service;

import br.com.data.vo.v1.BookVO;
import br.com.model.Book;

@Service
public class BookMapper {
	
	public BookVO convertEntityToVO(Book book) {
		BookVO vo = new BookVO();
		vo.setAuthor(book.getAuthor());
		vo.setLaunchDate(book.getLaunchDate());
		vo.setPrice(book.getPrice());
		vo.setTitle(book.getTitle());
		return vo;
	}
	
	public Book convertVOToEntity(Book book) {
		Book entity = new Book();
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		return entity;
	}
}
