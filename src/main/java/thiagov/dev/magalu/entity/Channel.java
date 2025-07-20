package thiagov.dev.magalu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_channel")
public class Channel {
	
	@Id
	private Long channelId;
	
	private String description;
	
	

	public Channel() {
		
	}
	
	
	
	public Channel(Long channelId, String description) {
		super();
		this.channelId = channelId;
		this.description = description;
	}



	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public enum Values{
		EMAIL(1l, "email"),
		SMS(2l, "sms"),
		PUSH(3l, "push"),
		WHATSAPP(4l,"whatsapp");
		
		private Long id;
		
		private String description;

		private Values(Long id, String description) {
			this.id = id;
			this.description = description;
		}
		
		public Channel toChannel() {
			return new Channel(id, description);
		}
		
		
	}
	
	
}
