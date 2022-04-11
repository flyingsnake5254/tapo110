package kotlin.text;

class c
  extends b
{
  public static final boolean d(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    if (paramChar1 == paramChar2) {
      return true;
    }
    if (!paramBoolean) {
      return false;
    }
    if (Character.toUpperCase(paramChar1) == Character.toUpperCase(paramChar2)) {
      return true;
    }
    return Character.toLowerCase(paramChar1) == Character.toLowerCase(paramChar2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */