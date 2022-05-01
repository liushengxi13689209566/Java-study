import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022-04-02 09:40
 * @Author: liushengxi
 * @Description:
 */


// 接口实现类：鉴权过滤器
class AuthencationFilter implements Filter {
    @Override
    public void doFilter(RpcRequest req) throws RpcException {
        //...鉴权逻辑..
    }
}

// 接口实现类：限流过滤器
class RateLimitFilter implements Filter {
    @Override
    public void doFilter(RpcRequest req) throws RpcException {
        //...限流逻辑...
    }

    private void test() {
        return;
    }
}

// 过滤器使用demo
public class Application {
    // filters.add(new AuthencationFilter());
    // filters.add(new RateLimitFilter());
    private List<Filter> filters = new ArrayList<>();

    public void handleRpcRequest(RpcRequest req) {
        try {
            for (Filter filter : filters) {
                filter.doFilter(req);
            }
        } catch (RpcException e) {
            // ...处理过滤结果...
        }
        // ...省略其他处理逻辑...
    }
}
