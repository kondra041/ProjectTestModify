package projectTestModify.springreactivenonreactive.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import projectTestModify.springreactivenonreactive.model.Message;

@Repository
public interface NonReactiveRepository extends MongoRepository<Message, String> {

}
