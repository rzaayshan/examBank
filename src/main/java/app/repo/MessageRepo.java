package app.repo;

import app.entity.Message;
import app.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {

  List<Message> findAllByFromAndTo(Userr sender, Userr receiver);

  List<Message> findAllByFromOrTo(Userr sender, Userr receiver);

}
