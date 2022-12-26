package org.core;

/**
 * 事件发射器
 */
public interface Emitter<T> {
    /* 回调接口 */
    void onSubscribe(T t);

    void onNext(T t);

    void onComplete();

    void onError(Throwable throwable);
}
