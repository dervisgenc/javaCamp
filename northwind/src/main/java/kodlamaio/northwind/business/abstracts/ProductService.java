package kodlamaio.northwind.business.abstracts;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.northwind.entities.concretes.Product;
@Service
public interface ProductService {
	List<Product> getAll();
}
