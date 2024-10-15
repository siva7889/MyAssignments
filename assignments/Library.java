package home.assignments;

public class Library {
	
	
	
	public String addBook(String bookTitle) {
		
		System.out.println( "Book '" +bookTitle+ "' added successfully");
		return bookTitle;
		
		}
	
	
	public void issueBook() {
		System.out.println("Book issued successfully");

	}
	
	public static void main(String[] args) {
		
		Library l = new Library();
		System.out.println( "Addition of Book");
		System.out.println( "***************************************************");
		l.addBook("Sapiens: A Brief History of Humankind");
		l.addBook("The Alchemist");
		System.out.println();
		System.out.println( "Issue Book");
		System.out.println( "****************************************************");
		l.issueBook();
		
		}
	
	

}
