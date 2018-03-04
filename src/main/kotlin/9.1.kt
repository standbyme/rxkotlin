// 7.8.kt
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    val flowable: Flowable<Int> = Flowable.create<Int>({
        for (i in 1..10) {
            it.onNext(i) // it: FlowableEmitter
        }
        it.onComplete()
    }, BackpressureStrategy.BUFFER)

    flowable
            .observeOn(Schedulers.newThread())
            .subscribe(subscriber_3)

    Thread.sleep(10000)

}

/*
Create Flowable
Flowable.create() takes two parameters to create an instance of Flowable. The following is the definition of the Flowable.create() method:

    fun <T> create(source:FlowableOnSubscribe<T>,
    mode:BackpressureStrategy):Flowable<T> {
      //...
    }
First parameter is the source from where the emissions will generate,
and the second one is BackpressureStrategy;
it is an enum that helps supporting backpressure
(it basically helps choosing which strategy to follow for backpressure)
by caching/buffering or dropping some of the emissions if the downstream can't keep up.
The enum BackpressureStrategy has five underlying options for different kinds of implementations of backpressure.
 */

/*
BackpressureStrategy.MISSING: This leads to no backpressure implementation at all; downstream has to deal with backpressure overflows. This option is helpful while using the onBackpressureXXX() operator. We will learn this example later in this chapter.
BackpressureStrategy.ERROR: This, again, leads to no backpressure implementation and signals MissingBackpressureException the very moment the downstream cannot keep up with the source.
BackpressureStrategy.BUFFER: This buffers all the emissions in an unbounded buffer until the downstream is able to consume them. This can lead to OutOfMemoryError if there are a lot of emissions to buffer.
BackpressureStrategy.DROP: This strategy will let you drop all the emissions while the downstream is busy and can't keep up; when the downstream finishes the previous operation, it'll get the very first emission after its finishing time, and will miss any emissions in between. For example, say the source is emitting five values, 1, 2, 3, 4, and 5 respectively, the downstream got busy after receiving 1 and while the source emitted 2, 3, and 4, it got ready just before the source emitted 5; the downstream will receive 5 only and will miss all remaining.
BackpressureStrategy.LATEST: This strategy will let you drop all the emissions, but keeps the latest one while the downstream is busy and can't keep up; when the downstream finishes the previous operation it'll get the last emission just before it finished, and will miss any emissions in between. For example, say the source is emitting five values 1, 2, 3, 4, and 5 respectively, the downstream got busy after receiving 1 and while the source emitted 2, 3, and 4, it got ready just before the source emitted 5; the downstream will receive both of them
(if it didn't again get busy after receiving 4, that it can't receive 5).
 */