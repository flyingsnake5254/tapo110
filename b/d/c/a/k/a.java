package b.d.c.a.k;

import android.os.Bundle;
import android.text.TextUtils;
import b.d.c.a.m.c;
import com.tplink.libtpanalytics.bean.GAParams;
import com.tplink.libtpanalytics.core.define.TAException;
import com.tplink.libtpanalytics.core.define.e;
import java.util.ArrayList;
import java.util.List;

public class a
  extends b.d.c.a.d
{
  private b.d.c.a.i.b b;
  private List<String> c = new ArrayList();
  private boolean d = true;
  
  public a(e parame, b.d.c.a.i.b paramb)
  {
    super(parame);
    this.b = paramb;
  }
  
  public void b(String paramString, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("event_action");
    String str2 = paramBundle.getString("event_label");
    paramBundle = paramBundle.getString("event_value");
    if (!TextUtils.isEmpty(paramString))
    {
      if (!TextUtils.isEmpty(str1))
      {
        paramString = new GAParams(paramString, str1);
        if (!TextUtils.isEmpty(str2)) {
          paramString.setLabel(str2);
        }
        if (!TextUtils.isEmpty(paramBundle)) {
          paramString.setValue(paramBundle);
        }
        paramBundle = new b.d.c.b.b("ga_event", this.a);
        paramBundle.d(paramString);
        paramString = b.d.c.b.a.a(paramBundle);
        if (paramString != null) {
          this.b.f(paramString);
        }
        if (!this.d) {
          c.f().e();
        }
        return;
      }
      throw new TAException("action required");
    }
    throw new TAException("categoryName required");
  }
  
  public void c(String paramString, Bundle paramBundle)
  {
    d(paramString, paramBundle, "V1");
  }
  
  public void d(String paramString1, Bundle paramBundle, String paramString2)
  {
    if (!this.c.contains(paramString2)) {
      b(paramString1, paramBundle);
    }
  }
  
  public void e()
  {
    this.d = true;
  }
  
  public void f()
  {
    this.d = false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c\a\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */