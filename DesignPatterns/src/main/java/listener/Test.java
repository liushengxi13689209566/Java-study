package listener;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class Test {

    public static void main(String[] args) {

        EventBus bus = new EventBus();
        bus.register(new MyLisenter());
        bus.post(new MyEvent("test"));
    }

    static class MyEvent {
        private String message;

        public MyEvent(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return this.message;
        }
    }

    static class MyLisenter {
        @Subscribe
        public void consume(MyEvent event) {
            System.out.println(event.toString());
        }
    }
}
