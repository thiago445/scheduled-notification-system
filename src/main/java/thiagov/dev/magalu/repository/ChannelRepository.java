package thiagov.dev.magalu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import thiagov.dev.magalu.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
	

}
