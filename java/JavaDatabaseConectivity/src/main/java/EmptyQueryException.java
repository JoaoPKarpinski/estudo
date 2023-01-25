@SuppressWarnings("serial")
public class EmptyQueryException extends RuntimeException {
	private String op;
	
	public EmptyQueryException() {	
	}
	
	public EmptyQueryException(String operation) {
		this.op = operation;
	}
	
	@Override
	public String getMessage() {	
		if (op != null) {
			return "Operação '" + op + "' não retornou resultado algum."; 
		}
		else {
			return "Resultado vazio.";
		}
	}
}