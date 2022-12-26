package org.core;


public class ObservableFlatMap<T, U> extends AbstractObservableWithUpStream<T, U> {

    Function<T, U> function;


    public ObservableFlatMap(ObservableSource<T> source, Function<T, U> function) {
        super(source);
        this.function = function;
    }

    public ObservableFlatMap(ObservableSource<T> source) {
        super(source);
    }

    @Override
    protected void subscribeActual(Observer observer) {
        source.subscribe(new MapObserver(observer, function));
    }

    static class MapObserver<T, U> implements Observer<T> {
        Observer<U> downstream;
        Function<T, U> function;


        public MapObserver(Observer<U> downstream, Function<T, U> function) {
            this.downstream = downstream;
            this.function = function;
        }

        @Override
        public void onSubscribe() {
            downstream.onSubscribe();
        }

        @Override
        public void onNext(T t) {
            //核心实现
            U u = (U) function.apply(t);
            downstream.onNext(u);
        }

        @Override
        public void onComplete() {
            downstream.onComplete();
        }

        @Override
        public void onError(Throwable throwable) {
            downstream.onError(throwable);
        }
    }
}
