package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			Category category1 = new Category("Jännitys");
			crepository.save(category1);
			Category category2 = new Category("Kauhu");
			crepository.save(category2);
			Category category3 = new Category("Lasten kirja");
			crepository.save(category3);
			
			repository.save(new Book("Valon voima", "Kaisa", 2010, "2736253327", "19.90", category1));
			repository.save(new Book("Saku Sammakko", "Jaana", 2009, "9388463748", "20", category2));
			repository.save(new Book("Koiran elämää", "Lassi", 1999, "7384723645", "15.50", category3));
			
			User user1 = new User("user", "$2a$10$707oagWSMsW2hUEgNRKVO.0.n3j0eyYFrlC/ACr8XmrX0WSroAZk6", "user@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$7t/Dkr0pGueqZj27Ces1E.QKObbTjO3BQY2dOq.wITC5jEFL1btaq", "admin@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all the books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
