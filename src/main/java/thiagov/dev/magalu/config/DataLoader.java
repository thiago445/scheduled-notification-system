package thiagov.dev.magalu.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import thiagov.dev.magalu.entity.Channel;
import thiagov.dev.magalu.entity.Status;
import thiagov.dev.magalu.repository.ChannelRepository;
import thiagov.dev.magalu.repository.StatusRepository;

@Configuration
public class DataLoader implements CommandLineRunner {

	
	private final ChannelRepository channelRepository;
	
	private final StatusRepository statusRepository;
	
	
	
	
	
	public DataLoader(ChannelRepository channelRepository, StatusRepository statusRepository) {
		
		this.channelRepository = channelRepository;
		this.statusRepository = statusRepository;
	}





	@Override
	public void run(String... args) throws Exception {
		Arrays.stream(Channel.Values.values())
		.map(Channel.Values::toChannel)
		.forEach(channelRepository::save);
		
		
		Arrays.stream( Status.Values.values())
		.map(Status.Values::toStatus)
		.forEach(statusRepository::save);
		
		
	}
	
	
}
