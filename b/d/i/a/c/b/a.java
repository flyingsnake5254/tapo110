package b.d.i.a.c.b;

import android.text.TextUtils;
import java.util.StringTokenizer;

public class a
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  private boolean g(String paramString)
  {
    return paramString.toLowerCase().startsWith("digest");
  }
  
  private void h(String paramString)
  {
    if (!g(paramString)) {
      return;
    }
    l(paramString);
    int j = paramString.toLowerCase().indexOf("realm");
    if (j < 0) {
      return;
    }
    paramString = new StringTokenizer(paramString.substring(j), ",");
    while (paramString.hasMoreTokens()) {
      n(paramString.nextToken());
    }
    p("MD5");
  }
  
  private void i(String paramString)
  {
    String str = paramString.toLowerCase();
    int j = str.indexOf("qop=");
    if (j < 0) {
      return;
    }
    int k = str.indexOf("\"", j + 4);
    int m = k + 1;
    j = str.indexOf("\"", m);
    if ((k >= 0) && (j >= 0)) {
      try
      {
        v(paramString.substring(m, j));
      }
      catch (IndexOutOfBoundsException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static a j(String paramString)
  {
    a locala = new a();
    locala.h(paramString);
    return locala;
  }
  
  private void k(String paramString)
  {
    String str = paramString.toLowerCase();
    int j = str.indexOf("domain=");
    if (j < 0) {
      return;
    }
    int k = str.indexOf("\"", j);
    int m = str.indexOf("\"", k + 1);
    if ((k >= 0) && (m >= 0)) {
      try
      {
        r(paramString.substring(j + 1, m));
      }
      catch (IndexOutOfBoundsException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void l(String paramString)
  {
    k(paramString);
    i(paramString);
  }
  
  private void m(String paramString)
  {
    paramString.replaceAll("\\\"", "\"");
    s(paramString);
  }
  
  private void n(String paramString)
  {
    int j = paramString.indexOf("=");
    if (j < 0) {
      return;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = paramString.substring(0, j).toLowerCase();
      try
      {
        String str = paramString.substring(j + 1);
        paramString = (String)localObject2;
        localObject2 = str;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
      {
        paramString = (String)localObject2;
      }
      localIndexOutOfBoundsException2.printStackTrace();
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
    {
      paramString = null;
    }
    Object localObject2 = localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
      try
      {
        localObject2 = o((String)localObject2);
        if ("nonce".equals(paramString))
        {
          m((String)localObject2);
          return;
        }
        u(paramString, (String)localObject2);
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private String o(String paramString)
    throws IndexOutOfBoundsException
  {
    String str = paramString;
    if (paramString.charAt(0) == '"') {
      str = paramString.substring(1);
    }
    paramString = str;
    if (str.charAt(str.length() - 1) == '"') {
      paramString = str.substring(0, str.length() - 1);
    }
    return paramString;
  }
  
  private void p(String paramString)
  {
    this.f = paramString;
  }
  
  private void q(String paramString)
  {
    this.h = paramString;
  }
  
  private void r(String paramString)
  {
    this.b = paramString;
  }
  
  private void s(String paramString)
  {
    this.c = paramString;
  }
  
  private void t(String paramString)
  {
    this.d = paramString;
  }
  
  private void u(String paramString1, String paramString2)
  {
    if (paramString1.equals("realm")) {
      w(paramString2);
    } else if (paramString1.equals("opaque")) {
      t(paramString2);
    } else if (paramString1.equals("stale")) {
      x(paramString2);
    } else if (paramString1.equals("algorithm")) {
      p(paramString2);
    } else if (paramString1.equals("charset")) {
      q(paramString2);
    } else if (paramString1.equals("userhash")) {
      y(paramString2);
    }
  }
  
  private void v(String paramString)
  {
    this.g = paramString;
  }
  
  private void w(String paramString)
  {
    this.a = paramString;
  }
  
  private void x(String paramString)
  {
    this.e = paramString;
  }
  
  private void y(String paramString)
  {
    this.i = paramString;
  }
  
  public String a()
  {
    return this.f;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.g;
  }
  
  public String e()
  {
    return this.a;
  }
  
  public String f()
  {
    return this.i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\i\a\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */