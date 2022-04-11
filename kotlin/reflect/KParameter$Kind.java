package kotlin.reflect;

public enum KParameter$Kind
{
  static
  {
    Kind localKind1 = new Kind("INSTANCE", 0);
    INSTANCE = localKind1;
    Kind localKind2 = new Kind("EXTENSION_RECEIVER", 1);
    EXTENSION_RECEIVER = localKind2;
    Kind localKind3 = new Kind("VALUE", 2);
    VALUE = localKind3;
    $VALUES = new Kind[] { localKind1, localKind2, localKind3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\reflect\KParameter$Kind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */