package n;

import java.util.Objects;

public class TagsItem{
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
		if (!(o instanceof TagsItem)) return false;
		TagsItem tagsItem = (TagsItem) o;
		return id == tagsItem.id && Objects.equals(name, tagsItem.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, id);
	}
}
