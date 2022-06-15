package me.silvio.gutenfree.DTO;

public class ResponseDTO {

	protected Integer code;
	protected boolean success = false;
	
	public ResponseDTO() {}
	
	public ResponseDTO(Integer code, boolean success) {
		super();
		this.code = code;
		this.success = success;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}


}
