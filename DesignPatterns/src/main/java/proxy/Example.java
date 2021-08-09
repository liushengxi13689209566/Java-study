package proxy;

public class Example {
    public interface IUserController {
        UserVo login(String telephone, String password);

        UserVo register(String telephone, String password);
    }

    public class UserController implements IUserController {
        //...省略其他属性和方法...

        @Override
        public UserVo login(String telephone, String password) {
            //...省略login逻辑...
            //...返回UserVo数据...
        }

        @Override
        public UserVo register(String telephone, String password) {
            //...省略register逻辑...
            //...返回UserVo数据...
        }
    }

    public class UserControllerProxy implements IUserController {
        private MetricsCollector metricsCollector;
        private UserController userController;

        public UserControllerProxy(UserController userController) {
            this.userController = userController;
            this.metricsCollector = new MetricsCollector();
        }

        @Override
        public UserVo login(String telephone, String password) {
            long startTimestamp = System.currentTimeMillis();

            // 委托
            UserVo userVo = userController.login(telephone, password);

            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);

            return userVo;
        }

        @Override
        public UserVo register(String telephone, String password) {
            long startTimestamp = System.currentTimeMillis();

            UserVo userVo = userController.register(telephone, password);

            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);

            return userVo;
        }
    }
}
