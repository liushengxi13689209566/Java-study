import com.tattoo.codes.test.ProductInfo;
import com.tattoo.codes.test.ProductTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    private Integer productId;
    private Boolean isDel;
    private List<ProductInfo> productInfoList;
    private ProductTitle productTitle;
    private String opReason;

    @Test
    public void demo() {
        Product product = mock(Product.class);
        assert !product.getIsDel();
        assert product.getOpReason() == null;
        assert product.getProductId() == 0;
        assert product.getProductInfoList().size() == 0;
        assert product.getProductTitle() == null;
    }
}


