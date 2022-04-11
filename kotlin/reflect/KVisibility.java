package kotlin.reflect;

public enum KVisibility
{
  static
  {
    KVisibility localKVisibility1 = new KVisibility("PUBLIC", 0);
    PUBLIC = localKVisibility1;
    KVisibility localKVisibility2 = new KVisibility("PROTECTED", 1);
    PROTECTED = localKVisibility2;
    KVisibility localKVisibility3 = new KVisibility("INTERNAL", 2);
    INTERNAL = localKVisibility3;
    KVisibility localKVisibility4 = new KVisibility("PRIVATE", 3);
    PRIVATE = localKVisibility4;
    $VALUES = new KVisibility[] { localKVisibility1, localKVisibility2, localKVisibility3, localKVisibility4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\reflect\KVisibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */