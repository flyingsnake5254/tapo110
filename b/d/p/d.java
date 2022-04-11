package b.d.p;

import b.c.a.g;
import b.c.a.j;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static boolean a = false;
  
  public static void a(String paramString1, String paramString2)
  {
    g.f(paramString1).c(paramString2);
  }
  
  public static void b(String paramString)
  {
    g.c(paramString, new Object[0]);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    g.f(paramString1).f(paramString2, new Object[0]);
  }
  
  public static void d(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void e(String paramString1, String paramString2)
  {
    g.f(paramString1).a(paramString2);
  }
  
  public static void f(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    JSONObject localJSONObject = new JSONObject();
    for (int i = 0; i < arrayOfStackTraceElement.length; i++) {
      try
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        localJSONObject.put(localStringBuilder.toString(), arrayOfStackTraceElement[i].toString());
      }
      catch (JSONException localJSONException)
      {
        b(localJSONException.toString());
      }
    }
    e(paramString, localJSONObject.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\p\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */