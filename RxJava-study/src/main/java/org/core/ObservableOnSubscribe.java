package org.core;

/**
 * 连接 事件发射器和 被观察者的接口
 */
public interface ObservableOnSubscribe<T> {
    void subscribe(Emitter<T> emitter);
}
