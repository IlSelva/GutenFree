package me.silvio.gutenfree.DTO;

import me.silvio.gutenfree.entity.Book;

public class InsertBookResponseDTO extends ResponseDTO {
	private Book data;
	private final String description = "Book just inserted";
	
	public InsertBookResponseDTO() {}
	
	public InsertBookResponseDTO(Book data) {
		super();
		this.data = data;
	}
	
	public InsertBookResponseDTO(Book data, Integer code, boolean success) {
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

