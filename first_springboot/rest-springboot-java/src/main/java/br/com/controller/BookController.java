package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.data.vo.v1.BookVO;
import br.com.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/book")
@Tag(name = "Book", description = "Endpoints for Managing Books")
public class BookController {
	private static final String APPLICATION_YAML_VALUE = "application/x-yaml";

	@Autowired
	private BookService service;
	

	@GetMapping(value = "/{id}", 
				produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML_VALUE})
	@Operation(summary = "Findis a Book", 
			   description = "Finds a Book", 
			   tags = {"Book"}, 
			   responses = { @ApiResponse(description = "Success", responseCode = "200", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookVO.class)))})})
	public BookVO findById(@PathVariable(value = "id") Long id){
		return service.findById(id);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML_VALUE})
	@Operation(summary = "Finds all Books", 
	   description = "Finds all Books", 
	   tags = {"Book"}, 
	   responses = { @ApiResponse(description = "Success", responseCode = "200", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookVO.class)))})})
	public List<BookVO> findAll(){
		return service.findAll();
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML_VALUE},
				 produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML_VALUE})
	@Operation(summary = "Adds a new Book", 
	   description = "Adds a new Book by passing in a JSON, XML or YML", 
	   tags = {"Book"}, 
	   responses = {@ApiResponse(description = "Success", responseCode = "200", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookVO.class)))})})
	public BookVO create(@RequestBody BookVO book){
		return service.create(book);
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML_VALUE},
				produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML_VALUE})
	@Operation(summary = "Updates a Book", 
	   description = "Updates a Book by passing in a JSON, XML or YML", 
	   tags = {"Book"}, 
	   responses = {@ApiResponse(description = "Updated", responseCode = "200", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookVO.class)))}),
			   		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			   		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			   		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			   		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public BookVO update(@RequestBody BookVO book){
		return service.update(book);
	}
	
	@DeleteMapping(value = "/{id}",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, APPLICATION_YAML_VALUE})
	@Operation(summary = "Removes a Book", 
	   description = "Removes a Book by passing in a JSON, XML or YML", 
	   tags = {"Book"}, 
	   responses = {@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			   		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			   		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			   		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			   		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
