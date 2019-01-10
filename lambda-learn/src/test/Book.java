package test;

import java.time.LocalDate;

public class Book {

	private Long id;
	private String name;
	private Double price;
	private String type;
	private LocalDate publishDate;

	public Book() {
	}

	public Book(Long id, String name, Double price, String type, LocalDate publishDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.publishDate = publishDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + ", publishDate="
				+ publishDate + "]";
	}

}
