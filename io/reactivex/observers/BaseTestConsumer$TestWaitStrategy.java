package io.reactivex.observers;

public enum BaseTestConsumer$TestWaitStrategy
  implements Runnable
{
  static
  {
    a locala = new a("SPIN", 0);
    SPIN = locala;
    b localb = new b("YIELD", 1);
    YIELD = localb;
    c localc = new c("SLEEP_1MS", 2);
    SLEEP_1MS = localc;
    d locald = new d("SLEEP_10MS", 3);
    SLEEP_10MS = locald;
    e locale = new e("SLEEP_100MS", 4);
    SLEEP_100MS = locale;
    f localf = new f("SLEEP_1000MS", 5);
    SLEEP_1000MS = localf;
    $VALUES = new TestWaitStrategy[] { locala, localb, localc, locald, locale, localf };
  }
  
  static void sleep(int paramInt)
  {
    long l = paramInt;
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException(localInterruptedException);
    }
  }
  
  public abstract void run();
  
  static enum a
  {
    a()
    {
      super(paramInt, null);
    }
    
    public void run() {}
  }
  
  static enum b
  {
    b()
    {
      super(paramInt, null);
    }
    
    public void run() {}
  }
  
  static enum c
  {
    c()
    {
      super(paramInt, null);
    }
    
    public void run()
    {
      BaseTestConsumer.TestWaitStrategy.sleep(1);
    }
  }
  
  static enum d
  {
    d()
    {
      super(paramInt, null);
    }
    
    public void run()
    {
      BaseTestConsumer.TestWaitStrategy.sleep(10);
    }
  }
  
  static enum e
  {
    e()
    {
      super(paramInt, null);
    }
    
    public void run()
    {
      BaseTestConsumer.TestWaitStrategy.sleep(100);
    }
  }
  
  static enum f
  {
    f()
    {
      super(paramInt, null);
    }
    
    public void run()
    {
      BaseTestConsumer.TestWaitStrategy.sleep(1000);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\observers\BaseTestConsumer$TestWaitStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */