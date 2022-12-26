package org.core;

/**
 * 观察者
 */
public interface Observer<T> {
    /* 回调接口 */
    void onSubscribe();

    void onNext(T t);

    void onComplete();

    void onError(Throwable throwable);
}
