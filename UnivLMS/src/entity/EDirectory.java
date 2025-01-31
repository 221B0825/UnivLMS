package entity;

import java.util.Scanner;

public class EDirectory {
	//attributes
	private String number;
	private String name;
	private String hyperLink;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHyperLink() {
		return hyperLink;
	}

	public void setHyperLink(String hyperLink) {
		this.hyperLink = hyperLink;
	}

	public void read(Scanner scanner) {
		this.number = scanner.next();
		this.name = scanner.next();
		this.hyperLink = scanner.next();
	}
}
