import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

val subscriber_2 = object : Subscriber<Item> {
    lateinit var subscription: Subscription  // Add this line compared with subscriber_1
    override fun onSubscribe(subscription: Subscription) {
        this.subscription = subscription  // Add this line compared with subscriber_1
        subscription.request(4)
        println("New Subscription ")
    }

    override fun onNext(s: Item) {
        Thread.sleep(200)
        println("Subscriber received " + s)
        if (s.id == 4) {                    // |\
            println("Requesting two more")  // | \
            subscription.request(2)       // | /--- Add these lines compared with subscriber_1
        }                                   // |/
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