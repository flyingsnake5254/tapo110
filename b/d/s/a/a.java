package b.d.s.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.iot.cloud.bean.common.IoTWebServiceIdParams;
import com.tplink.libtpnetwork.Utils.o;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class a
{
  private static final a a = new a();
  private Map<String, b> b = new HashMap();
  private b c;
  private com.tplink.cloud.context.a d;
  private String e;
  private IoTWebServiceIdParams f;
  private b g;
  private b h;
  
  private b a(@NonNull TCAccountBean paramTCAccountBean)
  {
    Objects.requireNonNull(this.d, "mDefaultCloudEnvironment must be inited");
    b localb = (b)this.b.get(paramTCAccountBean.getCloudUserName());
    Object localObject = localb;
    if (localb == null)
    {
      localObject = new com.tplink.iot.c.c.a(paramTCAccountBean, this.d, this.e, this.f);
      this.c = ((b)localObject);
      this.b.put(paramTCAccountBean.getCloudUserName(), localObject);
    }
    return (b)localObject;
  }
  
  private b b()
  {
    return this.c;
  }
  
  public static b c(@NonNull TCAccountBean paramTCAccountBean)
  {
    return a.a(paramTCAccountBean);
  }
  
  public static String d()
  {
    Object localObject = f().c();
    if ((localObject != null) && (((TCAccountBean)localObject).getAccountId() != null)) {
      localObject = ((TCAccountBean)localObject).getAccountId();
    } else {
      localObject = "";
    }
    return (String)localObject;
  }
  
  public static String e()
  {
    Object localObject = f().c();
    if ((localObject != null) && (((TCAccountBean)localObject).getCloudUserName() != null)) {
      localObject = ((TCAccountBean)localObject).getCloudUserName();
    } else {
      localObject = "";
    }
    return (String)localObject;
  }
  
  public static b f()
  {
    Object localObject = a;
    if (((a)localObject).b() != null) {
      localObject = ((a)localObject).b();
    } else {
      localObject = ((a)localObject).g;
    }
    return (b)localObject;
  }
  
  public static b g()
  {
    return a.h;
  }
  
  public static String h()
  {
    Object localObject = f();
    String str = "";
    if ((localObject != null) && (f().c() != null)) {
      localObject = f().c().getEmail();
    } else {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      str = b.d.w.h.a.g((String)localObject);
    }
    return str;
  }
  
  public static void i(com.tplink.cloud.context.a parama, String paramString, IoTWebServiceIdParams paramIoTWebServiceIdParams)
  {
    a locala = a;
    locala.d = parama;
    locala.e = paramString;
    locala.f = paramIoTWebServiceIdParams;
    TCAccountBean localTCAccountBean = o.h0().P();
    if (localTCAccountBean != null) {
      c(localTCAccountBean);
    } else {
      locala.g = new com.tplink.iot.c.c.a(new TCAccountBean(), parama, paramString, paramIoTWebServiceIdParams);
    }
    locala.h = new com.tplink.iot.c.c.a(new TCAccountBean("test@tp-link.net", "test"), parama, paramString, paramIoTWebServiceIdParams);
  }
  
  public static void j(String paramString)
  {
    a.b.remove(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\s\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */