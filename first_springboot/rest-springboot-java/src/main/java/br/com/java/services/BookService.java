package br.com.java.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.controller.BookController;
import br.com.java.data.vo.v1.BookVO;
import br.com.java.exceptions.RequiredObjectIsNullException;
import br.com.java.exceptions.ResourceNotFoundException;
import br.com.java.mapper.DozerMapper;
import br.com.java.mapper.custom.BookMapper;
import br.com.java.model.Book;
import br.com.java.repositories.BookRepository;

@Service
public class BookService {
	private Logger logger = Logger.getLogger(BookService.class.getName());

	@Autowired
	BookRepository repository;

	@Autowired
	BookMapper mapper;
	
	public List<BookVO> findAll(){
		logger.info("Finding all books!");

		var books =  DozerMapper.parseListObjects(repository.findAll(), BookVO.class);

		books.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
		return books;
	}

	public BookVO findById(Long id) {
		logger.info("Finding one book!");

		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return vo;
	}

	public BookVO create(BookVO book) {

		if (book == null) throw new RequiredObjectIsNullException();
		logger.info("Adding one more book!");

		var entity = DozerMapper.parseObject(book, Book.class);
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);

		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public BookVO update(BookVO book) {

		if (book == null) throw new RequiredObjectIsNullException();
		logger.info("Updating yoour shelf!");

		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());

		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);

		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting a book!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		repository.delete(entity);
	}


}
