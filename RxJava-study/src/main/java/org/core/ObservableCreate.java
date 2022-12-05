package org.core;


public class ObservableCreate<T> extends Observable<T> {
    /**
     * 连接 事件发射器和 被观察者的接口
     */
    ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer observer) {
        observer.onSubscribe();
        CreateEmitter<T> emitter = new CreateEmitter<T>(observer);
        source.subscribe(emitter);
    }

    static class CreateEmitter<T> implements Emitter<T> {
        /**
         * 观察者
         */
        Observer<T> observer;
        boolean done;

        public CreateEmitter() {
        }

        public CreateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        /**
         * 为什么不去实现 ？
         */
        @Override
        public void onSubscribe(T t) {

        }

        @Override
        public void onNext(T t) {
            if (done) return;
            observer.onNext(t);
        }

        @Override
        public void onComplete() {
            if (done) return;
            observer.onComplete();
            done = true;
        }

        @Override
        public void onError(Throwable throwable) {
            if (done) return;
            observer.onError(throwable);
            done = true;
        }
    }
}
