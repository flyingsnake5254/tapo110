package b.d.w.e;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
{
  public static int a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = paramString.split("\\.");
      int i = 0;
      int j = 0;
      while ((i < paramString.length) && (i < 4))
      {
        int k = Integer.parseInt(paramString[i]);
        if (k > 255) {
          return 0;
        }
        j |= (k & 0xFF) << 24 - i * 8;
        i++;
      }
      return j;
    }
    return 0;
  }
  
  public static boolean b(String paramString)
  {
    if (paramString != null) {
      return Pattern.compile("^([A-Za-z0-9`~!@#$\\\\%^&*()-=_+\\[\\]{};:'\"|/?.,<> ]{8,63}|[0-9a-fA-F]{8,64})$").matcher(paramString).matches();
    }
    return false;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      int i;
      try
      {
        i = paramString.getBytes("UTF-8").length;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        i = paramString.length();
      }
      long l = i;
      bool2 = bool1;
      if (l > 0L)
      {
        bool2 = bool1;
        if (l <= 32L) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public static boolean d(String paramString)
  {
    int i = paramString.length();
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    i = (a(paramString) ^ 0xFFFFFFFF) + 1;
    if ((i & i - 1) == 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */