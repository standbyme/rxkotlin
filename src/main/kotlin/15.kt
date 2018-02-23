interface Disposable {
    /**
     * Dispose the resource, the operation should be idempotent.
     */
    fun dispose()
    /**
     * Returns true if this resource has been disposed.
     * @return true if this resource has been disposed
     */
    val isDisposed:Boolean
}