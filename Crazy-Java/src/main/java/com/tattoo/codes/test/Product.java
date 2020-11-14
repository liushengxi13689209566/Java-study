package com.tattoo.codes.test;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Data
public class Product {
    private Integer productId;
    private Boolean isDel;
    private List<ProductInfo> productInfoList;
    private ProductTitle productTitle;
    private String opReason;

    @Test
    public void demo01() {
        Product product = mock(Product.class);
        assert !product.getIsDel();
        assert product.getOpReason() == null;
        assert product.getProductId() == 0;
        assert product.getProductInfoList().size() == 0;
        assert product.getProductTitle() == null;
    }

    @Test
    public void demo02() {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(0)).thenReturn("second");
        // 对同一个方法进行多次mock时，最后一次mock对象的行为会覆盖之前的行为
        assert mockedList.get(0) == "second";
        // 同一个方法的多次调用mock不同的返回值或异常
        when(mockedList.get(1))
                .thenThrow(new IllegalArgumentException())
                .thenReturn("foo");
        // 第一次调用 : 抛出运IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> mockedList.get(1));
        // 第二次调用 : 输出"foo"
        assert mockedList.get(1) == "foo";

        // 后续调用 : 也是输出"foo"
        assert mockedList.get(1) == "foo";
    }

    @Test
    public void demo03() {
        LinkedList mockedList = mock(LinkedList.class);
        // 对于无返回值的方法，可以用 doThrow(异常).when(mock对象).方法 的方式模拟异常行为
        doThrow(new RuntimeException()).when(mockedList).clear();
        // 对于有返回值的方法，可以用when(mock对象的方法).thenThrow(异常)的方式模拟异常行为
        when(mockedList.size()).thenThrow(new RuntimeException());
        // 调用下面代码会抛出异常
        mockedList.clear();
        mockedList.size();
    }
}

@Service
class ProductQueryService {
    // 待测试方法
    public String getProductTitle(Integer productId) {
//        if (VerifyUtils.isNotPositive(productId)) {
//            throw new IllegalArgumentException("参数不合法");
//        }
        return "产品名称";
    }
}

@RunWith(MockitoJUnitRunner.class)
class ProductQueryServiceTest {
    // 使用spy注解
    @Spy
    private ProductQueryService productQueryService;

    @Test
    public void demo1() {
        doReturn("产品名称").when(productQueryService).getProductTitle(-1);
        // doReturn(...).when(...)，测试通过
        assert productQueryService.getProductTitle(-1).equals("产品名称");
    }

    @Test
    public void demo2() {
        // 使用when(...).thenReturn(...)会进行真实的调用，抛出异常
        assertThrows(IllegalArgumentException.class, () -> when(productQueryService.getProductTitle(-1)).thenReturn("产品名称"), "参数不合法");
    }
}






