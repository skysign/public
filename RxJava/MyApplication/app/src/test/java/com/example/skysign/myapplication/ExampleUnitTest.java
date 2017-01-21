package com.example.skysign.myapplication;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void myOserverableTest() throws Exception {
        System.out.println("myOserverableTest begin");

        Observable<String> values = Observable.create(o -> {
            o.onNext("First");
            o.onNext("Second");
            o.onNext("Third");
            o.onNext("Fourth");
            o.onNext("Fifth");
        });

        //.distinctUntilChanged(v -> v.charAt(0))
        values.distinct(v -> v.charAt(0))
                .subscribe(
                        v -> System.out.println(v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
        System.out.println("myOserverableTest end");
    }

    @Test
    public void myOserverableTestFromArry() throws Exception {
        System.out.println("myOserverableTest2 begin");
        Integer[] is = {1,2,3};
        Observable<Integer> values = Observable.fromArray(is);

        values.filter(v -> v > 1)
                .subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
        System.out.println("myOserverableTest2 end");
    }

    @Test
    public void myOservableTestFromList() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Observable<Integer> values = Observable.fromIterable(list);
        values.filter(v -> v > 2)
                .subscribe(
                        v -> System.out.println("Received: " + v),
                        e -> System.out.println("Error: " + e),
                        () -> System.out.println("Completed")
                );
    }
}