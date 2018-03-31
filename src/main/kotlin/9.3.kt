import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    Observable.range(1, 3)
            .subscribeOn(Schedulers.computation())  //Add
            .subscribe {
                Thread.sleep(200)
                println("1. $it")
            }

    Observable.range(10, 3)
            .subscribeOn(Schedulers.computation())  //Add
            .subscribe {
                Thread.sleep(100)
                println("2. $it")
            }
    Thread.sleep(700)  // Add
}

/*
2. 10
1. 1
2. 11
2. 12
1. 2
1. 3
 */

/*
Observable in this example is emitted concurrently.

The line of the subscribeOn(Schedulers.computation()) code
enabled both downstreams to subscribe to the Observable in a different (background) thread,
which influenced concurrency.
 */

/*
As all the operations are being performed in different threads,
we need to block the main thread to keep the program alive.
 */

/*
Schedulers.io() provides us with I/O bound threads.
To be more accurate, Schedulers.io() provides you with ThreadPool,
which can create an unbounded number of worker threads that are meant to be performing I/O bounded tasks.
 */

/*
The main reason why we should consider
Schedulers.io() for I/O boundtasks and
Schedulers.computation() for computational purposes is that computation() threads utilizethe processors better and create no more threads than the available CPUcores,
and reuses them. While Schedulers.io() is unbounded, and if youschedule10,000 computational tasks on io() in parallel,
then each of those 10,000 tasks each have their own thread and be competing for CPU incurring context switching costs.
 */

/*
The Schedulers.newThread() provides us with a scheduler that creates a new thread for each task provided.
While at first glance it may seem similar to Schedulers.io(), there's actually a huge difference.

The Schedulers.io() uses a thread pool, and whenever it gets a new unit of work,
it first looks into the thread pool to see if any idle thread is available to take up the task;
it proceeds to create a new thread if no pre-existing thread is available to take up the work.

However, Schedulers.newThread() doesn't even use a thread pool; instead,
it creates a new thread for every request and forgets them forever.

In most of the cases, when you're not using Schedulers.computation(),
you should consider Schedulers.io() and should predominantly avoid using Schedulers.newThread();
threads are very expensive resources,
you should try to avoid the creation of new threads as much as possible.

The Schedulers.single() provides us with a scheduler that contains only one thread and returns the single instance for every call. Confused? Let's make it clear. Think of a situation where you need to execute tasks that are strongly sequential—Schedulers.single() is the best available option for you here. As it provides you with only one thread, every task that you enqueue here is bound to be executed sequentially.

Schedulers.single() and Schedulers.trampoline() sound somewhat similar, both the schedulers are for sequential execution. While Schedulers.single() guarantees that all its task will run sequentially, it may run parallel to the thread it was called upon (if not, that thread is from Schedulers.single() as well);
 */