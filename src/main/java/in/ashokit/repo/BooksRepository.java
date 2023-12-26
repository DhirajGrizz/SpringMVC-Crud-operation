package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Books;
import java.util.List;


public interface BooksRepository extends JpaRepository<Books, Integer> {
	
	public List<Books> findByAllowst(String allowst);

}
