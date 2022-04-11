package io.netty.util.internal.shaded.org.jctools.queues;

public abstract interface MessagePassingQueue<T>
{
  public static final int UNBOUNDED_CAPACITY = -1;
  
  public abstract int capacity();
  
  public abstract void clear();
  
  public abstract int drain(Consumer<T> paramConsumer);
  
  public abstract int drain(Consumer<T> paramConsumer, int paramInt);
  
  public abstract void drain(Consumer<T> paramConsumer, WaitStrategy paramWaitStrategy, ExitCondition paramExitCondition);
  
  public abstract int fill(Supplier<T> paramSupplier);
  
  public abstract int fill(Supplier<T> paramSupplier, int paramInt);
  
  public abstract void fill(Supplier<T> paramSupplier, WaitStrategy paramWaitStrategy, ExitCondition paramExitCondition);
  
  public abstract boolean isEmpty();
  
  public abstract boolean offer(T paramT);
  
  public abstract T peek();
  
  public abstract T poll();
  
  public abstract boolean relaxedOffer(T paramT);
  
  public abstract T relaxedPeek();
  
  public abstract T relaxedPoll();
  
  public abstract int size();
  
  public static abstract interface Consumer<T>
  {
    public abstract void accept(T paramT);
  }
  
  public static abstract interface ExitCondition
  {
    public abstract boolean keepRunning();
  }
  
  public static abstract interface Supplier<T>
  {
    public abstract T get();
  }
  
  public static abstract interface WaitStrategy
  {
    public abstract int idle(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\MessagePassingQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */