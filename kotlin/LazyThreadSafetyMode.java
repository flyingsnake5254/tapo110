package kotlin;

public enum LazyThreadSafetyMode
{
  static
  {
    LazyThreadSafetyMode localLazyThreadSafetyMode1 = new LazyThreadSafetyMode("SYNCHRONIZED", 0);
    SYNCHRONIZED = localLazyThreadSafetyMode1;
    LazyThreadSafetyMode localLazyThreadSafetyMode2 = new LazyThreadSafetyMode("PUBLICATION", 1);
    PUBLICATION = localLazyThreadSafetyMode2;
    LazyThreadSafetyMode localLazyThreadSafetyMode3 = new LazyThreadSafetyMode("NONE", 2);
    NONE = localLazyThreadSafetyMode3;
    $VALUES = new LazyThreadSafetyMode[] { localLazyThreadSafetyMode1, localLazyThreadSafetyMode2, localLazyThreadSafetyMode3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\LazyThreadSafetyMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */