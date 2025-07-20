package thiagov.dev.magalu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status")
public class Status {
	
	@Id
	private long statusId;
	
	private String description;
	
	

	public Status() {
		
	}
	
	

	public Status(long statusId, String description) {
		super();
		this.statusId = statusId;
		this.description = description;
	}



	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public enum Values{
		PENDING(1l, "pending"),
		SUCCESS(2l, "success"),
		ERROR(3l, "error"),
		CANCELED(4l,"canceled");
		
		private Long id;
		
		private String description;
		

		
		private Values(Long id, String description) {
			this.id = id;
			this.description = description;
		}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getDescription() {
			return description;
		}



		public void setDescription(String description) {
			this.description = description;
		}



		public Status toStatus(){
			return new Status(id, description);
		}
	}
	
}
