package b.c.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class h
  implements j
{
  private final ThreadLocal<String> a = new ThreadLocal();
  private final List<d> b = new ArrayList();
  
  @NonNull
  private String j(@NonNull String paramString, @Nullable Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs != null) {
      if (paramVarArgs.length == 0) {
        str = paramString;
      } else {
        str = String.format(paramString, paramVarArgs);
      }
    }
    return str;
  }
  
  @Nullable
  private String k()
  {
    String str = (String)this.a.get();
    if (str != null)
    {
      this.a.remove();
      return str;
    }
    return null;
  }
  
  private void m(int paramInt, @Nullable Throwable paramThrowable, @NonNull String paramString, @Nullable Object... paramVarArgs)
  {
    try
    {
      k.a(paramString);
      l(paramInt, k(), j(paramString, paramVarArgs), paramThrowable);
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  public void a(@Nullable String paramString)
  {
    if (k.d(paramString))
    {
      c("Empty/Null json content");
      return;
    }
    try
    {
      paramString = paramString.trim();
      Object localObject;
      if (paramString.startsWith("{"))
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        c(((JSONObject)localObject).toString(2));
        return;
      }
      if (paramString.startsWith("["))
      {
        localObject = new org/json/JSONArray;
        ((JSONArray)localObject).<init>(paramString);
        c(((JSONArray)localObject).toString(2));
        return;
      }
      f("Invalid Json", new Object[0]);
    }
    catch (JSONException paramString)
    {
      f("Invalid Json", new Object[0]);
    }
  }
  
  public void b(@NonNull String paramString, @Nullable Object... paramVarArgs)
  {
    m(4, null, paramString, paramVarArgs);
  }
  
  public void c(@Nullable Object paramObject)
  {
    m(3, null, k.e(paramObject), new Object[0]);
  }
  
  public j d(String paramString)
  {
    if (paramString != null) {
      this.a.set(paramString);
    }
    return this;
  }
  
  public void e(@NonNull String paramString, @Nullable Object... paramVarArgs)
  {
    m(2, null, paramString, paramVarArgs);
  }
  
  public void f(@NonNull String paramString, @Nullable Object... paramVarArgs)
  {
    i(null, paramString, paramVarArgs);
  }
  
  public void g(@NonNull d paramd)
  {
    this.b.add(k.a(paramd));
  }
  
  public void h(@NonNull String paramString, @Nullable Object... paramVarArgs)
  {
    m(5, null, paramString, paramVarArgs);
  }
  
  public void i(@Nullable Throwable paramThrowable, @NonNull String paramString, @Nullable Object... paramVarArgs)
  {
    m(6, paramThrowable, paramString, paramVarArgs);
  }
  
  public void l(int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable)
  {
    Object localObject = paramString2;
    if (paramThrowable != null)
    {
      localObject = paramString2;
      if (paramString2 == null) {}
    }
    try
    {
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" : ");
      ((StringBuilder)localObject).append(k.c(paramThrowable));
      localObject = ((StringBuilder)localObject).toString();
      paramString2 = (String)localObject;
      if (paramThrowable != null)
      {
        paramString2 = (String)localObject;
        if (localObject == null) {
          paramString2 = k.c(paramThrowable);
        }
      }
      paramThrowable = paramString2;
      if (k.d(paramString2)) {
        paramThrowable = "Empty/NULL log message";
      }
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramString2 = (d)((Iterator)localObject).next();
        if (paramString2.b(paramInt, paramString1)) {
          paramString2.a(paramInt, paramString1, paramThrowable);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\c\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */