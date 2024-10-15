package home.assignments;

public class LibraryManagement {
	
	
	public static void main(String[] args) {
		

		Library l1 = new Library();
	    l1.addBook("The Happiest Man on Earth");
		l1.issueBook();
		System.out.println("*****************************************************");
		Library l2 = new Library();
		l2.addBook("The Old Man and the Sea");
		l2.issueBook();
		
		}
	
	

}
