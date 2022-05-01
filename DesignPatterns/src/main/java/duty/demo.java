package duty;

/**
 * @Date: 2022-03-14 10:52
 * @Author: liushengxi
 * @Description:
 */
public class demo {

    public interface ICallback {
        void methodToCallback(boolean handled);
    }

    public abstract class Handler {
        protected Handler successor = null;

        public void setSuccessor(Handler successor) {
            this.successor = successor;
        }

        public abstract void handle(ICallback callback);
    }

    public class HandlerA extends Handler {
        @Override
        public void handle(ICallback callback) {
            boolean handled = false;
            // 真实业务逻辑
            callback.methodToCallback(handled);
            if (!handled && successor != null) {
                successor.handle(callback);
            }
        }
    }

    public class HandlerB extends Handler {
        @Override
        public void handle(ICallback callback) {
            boolean handled = false;
            // 真实业务逻辑
            callback.methodToCallback(handled);
            if (!handled && successor != null) {
                successor.handle(callback);
            }
        }
    }

    public class HandlerChain {
        private Handler head = null;
        private Handler tail = null;

        public void addHandler(Handler handler) {
            handler.setSuccessor(null);

            if (head == null) {
                head = handler;
                tail = handler;
                return;
            }

            tail.setSuccessor(handler);
            tail = handler;
        }

        public void handle() {
            if (head != null) {
                head.handle();
            }
        }
    }

    // 使用举例
    public class Application {
        public void main(String[] args) {
            HandlerChain chain = new HandlerChain();
            //有顺序的处理器链条
            chain.addHandler(new HandlerA());
            chain.addHandler(new HandlerB());
            chain.handle();
        }
    }

}


