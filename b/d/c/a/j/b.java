package b.d.c.a.j;

import b.d.c.a.d;
import com.tplink.libtpanalytics.bean.ExceptionParams;
import com.tplink.libtpanalytics.core.define.e;

public class b
  extends d
{
  private a b;
  private b.d.c.a.i.b c;
  private a.a d;
  
  public b(e parame, b.d.c.a.i.b paramb)
  {
    super(parame);
    parame = new a();
    this.d = parame;
    this.c = paramb;
    this.b = new a(parame);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      Thread.setDefaultUncaughtExceptionHandler(null);
    }
  }
  
  class a
    implements a.a
  {
    a() {}
    
    public void a(String paramString)
    {
      b.d.c.b.b localb = new b.d.c.b.b("app_exception", b.b(b.this));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis() / 1000L);
      localStringBuilder.append("");
      localb.d(new ExceptionParams(paramString, localStringBuilder.toString()));
      paramString = b.d.c.b.a.a(localb);
      if (paramString != null) {
        b.c(b.this).a(paramString);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c\a\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */