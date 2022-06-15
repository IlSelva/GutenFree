package me.silvio.gutenfree.DTO;

import me.silvio.gutenfree.entity.Book;

public class DeleteBookResponseDTO extends ResponseDTO {
	private Book data;
	private final String description = "Book just deleted";
	
	public DeleteBookResponseDTO() {}
	
	public DeleteBookResponseDTO(Book data) {
		super();
		this.data = data;
	}
	
	public DeleteBookResponseDTO(Book data, Integer code, boolean success) {
		super(code,success);
		this.data = data;
	}

	public Book getData() {
		return data;
	}

	public void setData(Book data) {
		this.data = data;
	}
	
	public String getDescription() {
		return description;
	}
}
