package kotlin;

public enum DeprecationLevel
{
  static
  {
    DeprecationLevel localDeprecationLevel1 = new DeprecationLevel("WARNING", 0);
    WARNING = localDeprecationLevel1;
    DeprecationLevel localDeprecationLevel2 = new DeprecationLevel("ERROR", 1);
    ERROR = localDeprecationLevel2;
    DeprecationLevel localDeprecationLevel3 = new DeprecationLevel("HIDDEN", 2);
    HIDDEN = localDeprecationLevel3;
    $VALUES = new DeprecationLevel[] { localDeprecationLevel1, localDeprecationLevel2, localDeprecationLevel3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\DeprecationLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */