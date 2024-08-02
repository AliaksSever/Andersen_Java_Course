package module;

public interface Printer {
	
	public default void print() {
		System.out.println("print content in console");
	}

}
