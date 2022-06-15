package me.silvio.gutenfree.DTO;

import me.silvio.gutenfree.entity.Book;

public class GetBookResponseDTO extends ResponseDTO{
	private Book data;
	private String description;
	
	public GetBookResponseDTO() {}
	
	public GetBookResponseDTO(Book data) {
		super();
		this.data = data;
	}
	
	public GetBookResponseDTO(Book data, Integer code, boolean success, String description) {
		super(code,success);
		this.data = data;
		this.description = description;
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

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
