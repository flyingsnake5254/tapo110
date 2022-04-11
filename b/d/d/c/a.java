package b.d.d.c;

import b.d.d.b.c;
import com.tplink.libtpappcommonmedia.bean.TPMediaAccountInfo;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static final a a = new a();
  private Map<String, c> b = new HashMap();
  private c c;
  private c d;
  
  private c a()
  {
    return this.c;
  }
  
  public static c b()
  {
    Object localObject = a;
    if (((a)localObject).a() != null) {
      localObject = ((a)localObject).a();
    } else {
      localObject = ((a)localObject).d;
    }
    return (c)localObject;
  }
  
  public static void c()
  {
    a.d = new c(new TPMediaAccountInfo("default_account_id"));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */