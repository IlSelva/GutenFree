package me.silvio.gutenfree.DTO;

import java.util.List;

import me.silvio.gutenfree.entity.Book;

public class GetAllBookResponseDTO extends ResponseDTO{
	private List<Book> data;
	private final String description = "list of all books";
	
	public GetAllBookResponseDTO() {}
	
	public GetAllBookResponseDTO(List<Book> data) {
		super();
		this.data = data;
	}
	
	
	public GetAllBookResponseDTO(List<Book> data, Integer code, boolean success) {
		super(code, success);
		this.data = data;
	}

	public List<Book> getData() {
		return data;
	}

	public void setData(List<Book> data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

}
