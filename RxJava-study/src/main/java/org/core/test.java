package org.core;

public class test {
    public static void main(String[] args) {
        System.out.println("ssss");

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(Emitter<Object> emitter) {
                emitter.onNext("111");
                emitter.onNext("222");
                emitter.onNext("333");

                emitter.onComplete();
                emitter.onError(new Throwable());
            }
        }).map(new Function<Object, Object>() {
            @Override
            public Object apply(Object o) {
                return "处理后的：" + o.toString();
            }
        }).subscribe(new Observer() {
            @Override
            public void onSubscribe() {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext：" + o.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }
        });


        System.out.println("END");
    }
}
