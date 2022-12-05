package org.core;

/**
 * 被观察者()的顶层接口
 */
public interface ObservableSource<T>  {

    void subscribe(Observer observer);
}
