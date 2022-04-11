package io.reactivex;

public enum BackpressureOverflowStrategy
{
  static
  {
    BackpressureOverflowStrategy localBackpressureOverflowStrategy1 = new BackpressureOverflowStrategy("ERROR", 0);
    ERROR = localBackpressureOverflowStrategy1;
    BackpressureOverflowStrategy localBackpressureOverflowStrategy2 = new BackpressureOverflowStrategy("DROP_OLDEST", 1);
    DROP_OLDEST = localBackpressureOverflowStrategy2;
    BackpressureOverflowStrategy localBackpressureOverflowStrategy3 = new BackpressureOverflowStrategy("DROP_LATEST", 2);
    DROP_LATEST = localBackpressureOverflowStrategy3;
    $VALUES = new BackpressureOverflowStrategy[] { localBackpressureOverflowStrategy1, localBackpressureOverflowStrategy2, localBackpressureOverflowStrategy3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\BackpressureOverflowStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */