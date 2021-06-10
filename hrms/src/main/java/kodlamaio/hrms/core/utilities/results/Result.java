package kodlamaio.hrms.core.utilities.results;

public class Result {
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success=success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
