package b.d.c.a.f;

import android.text.TextUtils;
import b.d.c.a.d;
import com.tplink.libtpanalytics.bean.AppUpdateParams;
import com.tplink.libtpanalytics.bean.OSUpdateParams;
import com.tplink.libtpanalytics.core.define.c;
import com.tplink.libtpanalytics.core.define.e;
import com.tplink.libtpanalytics.core.define.f;
import com.tplink.libtpanalytics.utils.j;

public class a
  extends d
{
  private b.d.c.a.i.b b;
  private boolean c = false;
  
  public a(e parame, b.d.c.a.i.b paramb)
  {
    super(parame);
    this.b = paramb;
  }
  
  private void b()
  {
    f.a().c();
    com.tplink.libtpanalytics.database.d.b localb = b.d.c.b.a.a(new b.d.c.b.b("app_launch", this.a));
    if (localb != null) {
      this.b.b(localb);
    }
  }
  
  private void c()
  {
    Object localObject1 = j.g(this.a.c()).f();
    Object localObject2 = this.a.e().d();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      j.g(this.a.c()).k((String)localObject2);
    }
    else if (!((String)localObject1).equals(localObject2))
    {
      j.g(this.a.c()).k((String)localObject2);
      localObject2 = new b.d.c.b.b("app_update", this.a);
      ((b.d.c.b.b)localObject2).d(new AppUpdateParams((String)localObject1));
      localObject1 = b.d.c.b.a.a((b.d.c.b.b)localObject2);
      if (localObject1 != null) {
        this.b.c((com.tplink.libtpanalytics.database.d.b)localObject1);
      }
    }
  }
  
  private void d()
  {
    Object localObject1 = j.g(this.a.c()).h();
    Object localObject2 = this.a.e().j();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      j.g(this.a.c()).l((String)localObject2);
    }
    else if (!((String)localObject1).equals(localObject2))
    {
      j.g(this.a.c()).l((String)localObject2);
      localObject2 = new b.d.c.b.b("os_update", this.a);
      ((b.d.c.b.b)localObject2).d(new OSUpdateParams((String)localObject1));
      localObject1 = b.d.c.b.a.a((b.d.c.b.b)localObject2);
      if (localObject1 != null) {
        this.b.g((com.tplink.libtpanalytics.database.d.b)localObject1);
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.c = paramBoolean;
  }
  
  public void e()
  {
    if (this.c)
    {
      b();
      d();
      c();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c\a\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */