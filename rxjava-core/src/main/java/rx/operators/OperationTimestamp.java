/**
 * Copyright 2013 Netflix, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rx.operators;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.util.Timestamped;
import rx.util.functions.Func1;

public final class OperationTimestamp {

    /**
     * Accepts a sequence and adds timestamps to each item in it.
     * 
     * @param sequence
     *            the input sequence.
     * @param <T>
     *            the type of the input sequence.
     * @return a sequence of timestamped values created by adding timestamps to each item in the input sequence.
     */
    public static <T> Func1<Observer<Timestamped<T>>, Subscription> timestamp(Observable<T> sequence) {
        return OperationMap.map(sequence, new Func1<T, Timestamped<T>>() {
            @Override
            public Timestamped<T> call(T value) {
                return new Timestamped<T>(System.currentTimeMillis(), value);
            }
        });
    }
}
