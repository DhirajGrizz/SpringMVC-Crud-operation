package in.ashokit.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Books;
import in.ashokit.repo.BooksRepository;

@Service
public class BooksService {

	private BooksRepository booksRepo;

	public BooksService(BooksRepository booksRepo) {
		this.booksRepo = booksRepo;
	}

	public List<Books> getData() {

		return booksRepo.findAll();
	}

	public boolean addBookData(Books books) {

		books.setAllowst("Y");

		Books save = booksRepo.save(books);

		if (save != null) {

			return true;
		}

		return false;
	}

	public Books editBook(Integer id) {

		Optional<Books> findById = booksRepo.findById(id);

		if (findById.isPresent()) {

			return findById.get();
		}

		return null;
	}

	public void deleteBook(Integer id) {

		// for permanemt delete
		// booksRepo.deleteById(id);
		Optional<Books> findById = booksRepo.findById(id);

		boolean present = findById.isPresent();

		if (present) {

			Books books = findById.get();

			books.setAllowst("N");

			booksRepo.save(books);

		}

	}
	
	public List<Books> findByAllowst(String allowst){
		
		List<Books> findByAllowst = booksRepo.findByAllowst(allowst);
		
		return findByAllowst;
	}

	
	
	
	
}
