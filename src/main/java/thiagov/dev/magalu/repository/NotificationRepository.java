package thiagov.dev.magalu.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import thiagov.dev.magalu.entity.Notification;
import thiagov.dev.magalu.entity.Status;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

	List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);



}
