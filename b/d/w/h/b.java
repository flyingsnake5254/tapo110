package b.d.w.h;

public class b
{
  public static boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 == paramCharSequence2) {
      return true;
    }
    if ((paramCharSequence1 != null) && (paramCharSequence2 != null))
    {
      int i = paramCharSequence1.length();
      if (i == paramCharSequence2.length())
      {
        if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
          return paramCharSequence1.equals(paramCharSequence2);
        }
        for (int j = 0; j < i; j++) {
          if (paramCharSequence1.charAt(j) != paramCharSequence2.charAt(j)) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if (paramString != null)
    {
      String str = paramString;
      if (paramString.contains("@")) {
        str = paramString.split("@")[0];
      }
      return str;
    }
    return "";
  }
  
  public static boolean c(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      bool2 = bool1;
      if (paramString.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~\\-]+@[a-zA-Z0-9\\-]+(\\.[a-zA-Z0-9\\-]+)+$"))
      {
        bool2 = bool1;
        if (paramString.length() <= 64) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public static boolean d(CharSequence paramCharSequence)
  {
    boolean bool;
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */