package Group3.ShopAcc.Config;

import Group3.ShopAcc.Entity.Product;
import Group3.ShopAcc.Repository.ProductRepository;
import Group3.ShopAcc.Service.ProductService;
import Group3.ShopAcc.Service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    private final ProductRepository productRepository;

    // Inject ProductRepository vào AppConfig thông qua constructor
    public AppConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Định nghĩa bean cho ProductService và inject ProductRepository vào ProductService

}
