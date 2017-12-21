package mum.edu.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PropertyImage {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@NotNull
	@Column(name="url")
	private String url;

	public PropertyImage() {
	    
	}
	
	public PropertyImage(String url) {
		this.url = url;
	}
	
	public PropertyImage(int id, String url) {
		this.id = id;
		this.url = url;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getUrl() {
		return url;
	}

	public final void setUrl(String url) {
		this.url = url;
	}

}
