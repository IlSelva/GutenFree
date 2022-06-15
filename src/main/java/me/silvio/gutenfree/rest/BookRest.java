package me.silvio.gutenfree.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.silvio.gutenfree.BookRepository;
import me.silvio.gutenfree.DTO.*;
import me.silvio.gutenfree.entity.Book;

@RestController
@RequestMapping("api")
public class BookRest {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/0.1/getAllBook")
	public GetAllBookResponseDTO getAllBook() {
		GetAllBookResponseDTO response = new GetAllBookResponseDTO();
		response.setData(bookRepository.findAll());
		response.setCode(200);
		response.setSuccess(true);
		return response;
	}

	@GetMapping("/0.1/getBookById/{bookId}")
	public GetBookResponseDTO getBookById(@PathVariable Long bookId) {
		GetBookResponseDTO response = new GetBookResponseDTO();
		response.setDescription("Book with the specified Id");
		response.setData(bookRepository.findById(bookId).orElse(null));
		if (response.getData() != null) {
			response.setCode(200);
			response.setSuccess(true);
		} else {
			response.setCode(404);
			response.setSuccess(false);
		}
		return response;
	}

	@PostMapping("/0.1/insertBook")
	public InsertBookResponseDTO insertBook(@RequestBody Book book) {
		InsertBookResponseDTO response = new InsertBookResponseDTO();
		try {
			bookRepository.save(book);
			response.setData(book);
			response.setSuccess(true);
			response.setCode(200);
		} catch (Exception e) {
			response.setData(null);
			response.setSuccess(false);
			response.setCode(500);
		}
		return response;
	}

	@PutMapping("/0.1/editBook/{bookId}")
	public EditBookResponseDTO editBook(@PathVariable Long bookId, @RequestBody Book book) {
		EditBookResponseDTO response = new EditBookResponseDTO();
		try {
			Book updateBook = bookRepository.findById(bookId).orElse(null);
			if (updateBook != null) {
				updateBook.setTitle(book.getTitle());
				updateBook.setDescription(book.getDescription());
				updateBook.setLink(book.getLink());
				bookRepository.save(updateBook);
				response.setData(updateBook);
				response.setSuccess(true);
				response.setCode(200);
			} else {
				response.setData(null);
				response.setCode(404);
				response.setSuccess(false);
			}
		} catch (Exception e) {
			response.setData(null);
			response.setSuccess(false);
			response.setCode(500);
		}
		return response;
	}

	@DeleteMapping("0.1/deleteBook/{bookId}")
	public DeleteBookResponseDTO deleteBook(@PathVariable Long bookId) {
		DeleteBookResponseDTO response = new DeleteBookResponseDTO();
		try {
			Book deleteBook = bookRepository.findById(bookId).orElse(null);
			response.setData(deleteBook);
			if (deleteBook != null) {
				bookRepository.delete(deleteBook);
				response.setCode(200);
				response.setSuccess(true);
			} else {
				response.setCode(404);
				response.setSuccess(false);
			}
		} catch (Exception e) {
			response.setData(null);
			response.setSuccess(false);
			response.setCode(500);
		}
		return response;
	}

}
