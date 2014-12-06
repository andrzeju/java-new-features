package pl.au.test.java6;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Andrzej
 * As of Java 6 JAXB is a part of SDK
 */
public class JAXBConversion {

	public static void main(String[] args) {
		Book book = new Book();
		book.setAuthor("Arthur Conan Doyle");
		book.setTitle("The adventures of Sherlock Holmes");
		book.setPages(430);
		
		File file = new File("target/sherlock.xml");
		try {
			JAXBContext ctx = JAXBContext.newInstance(Book.class);
			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(book, file);
			marshaller.marshal(book, System.out);
			 
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			Book xmlBook = (Book) unmarshaller.unmarshal(file);
			
			System.out.println(xmlBook);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

}

@XmlRootElement
class Book {

	private String title;
	private String author;
	private int pages;

	public String getTitle() {
		return title;
	}

	@XmlAttribute
	public void setTitle(String name) {
		this.title = name;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	@XmlElement
	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", pages="
				+ pages + "]";
	}
	
}