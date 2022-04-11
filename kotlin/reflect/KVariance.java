package kotlin.reflect;

public enum KVariance
{
  static
  {
    KVariance localKVariance1 = new KVariance("INVARIANT", 0);
    INVARIANT = localKVariance1;
    KVariance localKVariance2 = new KVariance("IN", 1);
    IN = localKVariance2;
    KVariance localKVariance3 = new KVariance("OUT", 2);
    OUT = localKVariance3;
    $VALUES = new KVariance[] { localKVariance1, localKVariance2, localKVariance3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\reflect\KVariance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */