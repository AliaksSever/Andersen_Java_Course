package module;

public interface printer {
	
	public default void print() {
		System.out.println("print content in console");
	}

}
