package n;

import java.util.Objects;

public class Category{
	private String name;
	private int id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Category)) return false;
		Category category = (Category) o;
		return id == category.id && Objects.equals(name, category.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, id);
	}
}
