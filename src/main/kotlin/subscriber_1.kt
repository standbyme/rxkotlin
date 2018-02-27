import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

val subscriber_1 = object : Subscriber<Item> {
    override fun onSubscribe(subscription: Subscription) {
        subscription.request(4)  // You must call request method ,else this will not get anything
        println("New Subscription ")
    }

    override fun onNext(s: Item) {
        Thread.sleep(200)
        println("Subscriber received " + s)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }

    override fun onComplete() {
        println("Done!")
    }
}

/*
The request() method will request the number of emissions the Subscriber should listen on from the upstream, counting after the method is called.
The Subscriber will ignore any further emissions after the requested emissions
 */