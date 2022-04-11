package b.d.n.d;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import b.d.n.j.e;
import com.google.gson.Gson;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class c
  implements b.d.n.i.c
{
  private static final String a = b.d.n.i.c.class.getSimpleName();
  private SharedPreferences b;
  private final String c;
  
  public c(Application paramApplication, String paramString)
  {
    this.b = paramApplication.getSharedPreferences("tp_iam_sp", 0);
    this.c = paramString;
    g();
  }
  
  private void g()
  {
    File localFile = new File(this.c);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putString("tp_iam_account_id", paramString);
    localEditor.apply();
  }
  
  public void b(String paramString)
  {
    b.d.n.h.a.a().execute(new a(this, paramString));
  }
  
  public void c()
  {
    b.d.n.h.a.a().execute(new b(this));
  }
  
  public void clear()
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.remove("tp_iam_account_id");
    localEditor.apply();
  }
  
  public String d()
  {
    return this.b.getString("tp_iam_account_id", "");
  }
  
  public Map<String, String> e()
  {
    Object localObject1 = this.b.getString("tp_iam_resources_map", "");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return new HashMap();
    }
    Object localObject2 = new a().getType();
    localObject1 = (Map)b.d.n.j.c.a.m((String)localObject1, (Type)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(a);
    ((StringBuilder)localObject2).append(" getResourcesMap \n[resMapString]:");
    ((StringBuilder)localObject2).append(localObject1);
    e.b(((StringBuilder)localObject2).toString());
    return (Map<String, String>)localObject1;
  }
  
  public void f(Map<String, String> paramMap)
  {
    paramMap = b.d.n.j.c.a.u(paramMap);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append(" saveResourcesMap \n[resMapString]:");
    ((StringBuilder)localObject).append(paramMap);
    e.b(((StringBuilder)localObject).toString());
    localObject = this.b.edit();
    ((SharedPreferences.Editor)localObject).putString("tp_iam_resources_map", paramMap);
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  class a
    extends com.google.gson.r.a<HashMap<String, String>>
  {
    a() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */