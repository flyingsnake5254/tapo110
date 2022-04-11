package b.a.a.a.a.a;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import b.a.a.a.a.a.e.a.b.b;
import io.reactivex.q;

public class d
{
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public static q<a> a(Context paramContext)
  {
    Object localObject;
    if (c.c()) {
      localObject = new b();
    } else if (c.b()) {
      localObject = new b.a.a.a.a.a.e.a.b.a();
    } else {
      localObject = new b.a.a.a.a.a.e.a.b.c();
    }
    return b(paramContext, (b.a.a.a.a.a.e.a.a)localObject);
  }
  
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public static q<a> b(Context paramContext, b.a.a.a.a.a.e.a.a parama)
  {
    c.a(paramContext, "context == null");
    c.a(parama, "strategy == null");
    return parama.a(paramContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\a\a\a\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */