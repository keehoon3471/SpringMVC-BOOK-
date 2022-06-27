package book.keehoon.web.spring;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Alias("BoardVO")
public class BoardVO {
	private int seq;
	
//	@NotNull
//	@Min(value=10)
	@NotEmpty(message="[필수]")
	private String isbn;
	
	@NotEmpty(message="[필수]")
	private String bookname;
	
	@NotEmpty(message="[필수]")
	private String author;
	
	@NotEmpty(message="[필수]")
	private String publisher;
	
	@NotNull
	@Min(value=1000)
	@Max(value=100000)
	private int price;
	
	private String image;
	
	@NotEmpty(message="[필수]책 소개를 간략히 입력하세요.")
	private String info;
	
	//추가
	private MultipartFile uploadFile;
	
	public BoardVO() { }
	
	public BoardVO(String isbn, String bookname, String author, String publisher, int price, String image, String info) {
		super();
		this.isbn = isbn;
		this.bookname = bookname;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.image = image;
		this.info = info;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	//추가
	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
}
