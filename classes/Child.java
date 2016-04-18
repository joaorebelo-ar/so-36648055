package classes;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author User01
 *
 */
@Entity
@Table(name = "CHILD")
public class Child {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Parent parent;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Parent getParent() {
	return parent;
    }

    public void setParent(Parent parent) {
	this.parent = parent;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Child [id=");
	builder.append(id);
	builder.append("]");
	return builder.toString();
    }

}
