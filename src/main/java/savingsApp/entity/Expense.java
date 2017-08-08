package savingsApp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Expense {
	
	public long id;
	public Date dateCreated;
	public String type;
	public String description;
	public Double amount;
	
	public Expense() {
		// TODO Auto-generated constructor stub
	}
	
	public Expense(Date dateCreated, String type, String description, Double amount) {
		this.dateCreated = dateCreated;
		this.type = type;
		this.description = description;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="date_created")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="amount")
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", dateCreated=" + dateCreated + ", description=" + description + ", amount="
				+ amount + "]";
	}
	
	

}
