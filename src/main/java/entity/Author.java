package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "author")
@Entity(name = "author")
@AllArgsConstructor
@NoArgsConstructor
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "name")
	private String name;

	public Author(String name, Long id) {
		this.name = name;
		this.id = id;
	}

}
