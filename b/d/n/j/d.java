package b.d.n.j;

import b.d.n.i.f;
import com.tplink.nbu.bean.iam.Event;
import java.text.SimpleDateFormat;

public class d
{
  private static d a;
  private static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd");
  private static final SimpleDateFormat c = new SimpleDateFormat("HH");
  private f d;
  private String e;
  private String f;
  private b.d.n.i.d g;
  
  private Event a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = new Event();
    paramString2.setAccountId(this.e);
    paramString2.setAppType(this.f);
    paramString2.setOs("android");
    paramString2.setType(paramString4);
    paramString2.setTaskId(paramString1);
    paramString2.setUnixTimestampUtc(System.currentTimeMillis());
    return paramString2;
  }
  
  public static d c()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          d locald = new b/d/n/j/d;
          locald.<init>();
          a = locald;
        }
      }
      finally {}
    }
    return a;
  }
  
  public void b()
  {
    this.e = null;
  }
  
  public void d(String paramString1, String paramString2, String paramString3)
  {
    this.g.e(a(paramString1, paramString2, paramString3, "action_click"));
  }
  
  public void e(String paramString1, String paramString2, String paramString3)
  {
    this.g.e(a(paramString1, paramString2, paramString3, "action_show"));
  }
  
  public void f(String paramString)
  {
    this.e = paramString;
  }
  
  public void g(String paramString)
  {
    this.f = paramString;
  }
  
  public void h(b.d.n.i.d paramd)
  {
    this.g = paramd;
  }
  
  public void i(f paramf)
  {
    this.d = paramf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\j\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */