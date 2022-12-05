package org.core;

/**
 * 抽象装饰类
 */
public abstract class AbstractObservableWithUpStream<T, U> extends Observable<U> {
    protected final ObservableSource<T> source;

    public AbstractObservableWithUpStream(ObservableSource<T> source) {
        this.source = source;
    }
}
