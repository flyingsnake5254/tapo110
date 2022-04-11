package b.d.d.d;

import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import io.reactivex.q;

public class c
{
  public static q<b.d.p.a> a(String paramString)
  {
    return b.d.d.j.b.b.getAesEncryptKey(paramString);
  }
  
  public static String b(String paramString)
  {
    String str = "";
    if (paramString == null) {
      return "";
    }
    paramString = b.a.b(paramString);
    if (paramString == null) {
      paramString = str;
    }
    return paramString;
  }
  
  public static TPMediaDevice c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return b.a.c(paramString);
  }
  
  public static String d(String paramString)
  {
    return b.d.d.j.b.b.getPskId(paramString);
  }
  
  public static String e(String paramString)
  {
    return b.d.d.j.b.b.getPskPwd(paramString);
  }
  
  public static String f(String paramString)
  {
    String str = "";
    if (paramString == null) {
      return "";
    }
    paramString = b.a.d(paramString);
    if (paramString == null) {
      paramString = str;
    }
    return paramString;
  }
  
  public static String g(String paramString)
  {
    String str = "";
    if (paramString == null) {
      return "";
    }
    paramString = b.a.i(paramString);
    if (paramString == null) {
      paramString = str;
    }
    return paramString;
  }
  
  public static boolean h(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    return b.a.g(paramString);
  }
  
  public static boolean i(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return b.a.e(paramString);
  }
  
  public static boolean j(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    if ((i(paramString)) || (k(paramString))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean k(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return b.a.h(paramString);
  }
  
  public static boolean l(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return b.a.a(paramString);
  }
  
  public static boolean m(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return b.a.f(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */