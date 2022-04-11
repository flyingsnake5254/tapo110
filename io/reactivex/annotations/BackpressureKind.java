package io.reactivex.annotations;

public enum BackpressureKind
{
  static
  {
    BackpressureKind localBackpressureKind1 = new BackpressureKind("PASS_THROUGH", 0);
    PASS_THROUGH = localBackpressureKind1;
    BackpressureKind localBackpressureKind2 = new BackpressureKind("FULL", 1);
    FULL = localBackpressureKind2;
    BackpressureKind localBackpressureKind3 = new BackpressureKind("SPECIAL", 2);
    SPECIAL = localBackpressureKind3;
    BackpressureKind localBackpressureKind4 = new BackpressureKind("UNBOUNDED_IN", 3);
    UNBOUNDED_IN = localBackpressureKind4;
    BackpressureKind localBackpressureKind5 = new BackpressureKind("ERROR", 4);
    ERROR = localBackpressureKind5;
    BackpressureKind localBackpressureKind6 = new BackpressureKind("NONE", 5);
    NONE = localBackpressureKind6;
    $VALUES = new BackpressureKind[] { localBackpressureKind1, localBackpressureKind2, localBackpressureKind3, localBackpressureKind4, localBackpressureKind5, localBackpressureKind6 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\annotations\BackpressureKind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */