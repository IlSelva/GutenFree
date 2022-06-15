package me.silvio.gutenfree.DTO;

import me.silvio.gutenfree.entity.Book;

public class EditBookResponseDTO extends ResponseDTO {
	private Book data;
	private final String description = "Book after edit";
	
	public EditBookResponseDTO() {}
	
	public EditBookResponseDTO(Book data) {
		super();
		this.data = data;
	}
	
	public EditBookResponseDTO(Book data, Integer code, boolean success) {
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
