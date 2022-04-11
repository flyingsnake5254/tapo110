package b.d.q.b;

import android.text.TextUtils;
import b.d.s.a.a;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.libtpnetwork.cameranetwork.util.j;

public class i
{
  public static String a()
  {
    String str = b();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return "Public";
  }
  
  public static String b()
  {
    Object localObject = a.f().c();
    if (localObject != null) {
      localObject = ((TCAccountBean)localObject).getCloudUserName();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public static String c()
  {
    Object localObject = a.f().c();
    if (localObject != null) {
      localObject = ((TCAccountBean)localObject).getPassword();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public static String d()
  {
    Object localObject = a.f().c();
    if (localObject != null) {
      localObject = ((TCAccountBean)localObject).getToken();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public static String e()
  {
    String str = c();
    if (str != null) {
      str = j.a(str);
    } else {
      str = "";
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\q\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */