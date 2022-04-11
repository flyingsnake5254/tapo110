package io.reactivex;

public enum BackpressureStrategy
{
  static
  {
    BackpressureStrategy localBackpressureStrategy1 = new BackpressureStrategy("MISSING", 0);
    MISSING = localBackpressureStrategy1;
    BackpressureStrategy localBackpressureStrategy2 = new BackpressureStrategy("ERROR", 1);
    ERROR = localBackpressureStrategy2;
    BackpressureStrategy localBackpressureStrategy3 = new BackpressureStrategy("BUFFER", 2);
    BUFFER = localBackpressureStrategy3;
    BackpressureStrategy localBackpressureStrategy4 = new BackpressureStrategy("DROP", 3);
    DROP = localBackpressureStrategy4;
    BackpressureStrategy localBackpressureStrategy5 = new BackpressureStrategy("LATEST", 4);
    LATEST = localBackpressureStrategy5;
    $VALUES = new BackpressureStrategy[] { localBackpressureStrategy1, localBackpressureStrategy2, localBackpressureStrategy3, localBackpressureStrategy4, localBackpressureStrategy5 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\BackpressureStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */