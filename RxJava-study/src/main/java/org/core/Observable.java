package org.core;

/**
 * 被观察者的核心抽象类
 * 也是使用框架的入口
 */
public abstract class Observable<T> implements ObservableSource {
    @Override
    public void subscribe(Observer observer) {
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer observer);

    /**
     * 实现 create 操作符
     */
    public static <T> ObservableCreate<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        return new ObservableCreate<T>(observableOnSubscribe);
    }

    /**
     * 实现 map 操作符
     */
    public <R> ObservableMap<T, R> map(Function<T, R> function) {
        return new ObservableMap<T, R>(this, function);
    }

}
