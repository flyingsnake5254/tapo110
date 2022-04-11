package b.d.w.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import b.d.w.f.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

@SuppressLint({"CommitPrefEdits"})
public class a
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  
  public a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences(paramString, 0);
    this.a = paramContext;
    this.b = paramContext.edit();
  }
  
  public boolean a(String paramString)
  {
    return this.a.contains(paramString);
  }
  
  public Map<String, ?> b()
  {
    return this.a.getAll();
  }
  
  public boolean c(String paramString, boolean paramBoolean)
  {
    return this.a.getBoolean(paramString, paramBoolean);
  }
  
  public int d(String paramString, int paramInt)
  {
    return this.a.getInt(paramString, paramInt);
  }
  
  public long e(String paramString, long paramLong)
  {
    return this.a.getLong(paramString, paramLong);
  }
  
  public String f(String paramString1, String paramString2)
  {
    return this.a.getString(paramString1, paramString2);
  }
  
  @SuppressLint({"NewApi"})
  public Set<String> g(String paramString)
  {
    if (b.g())
    {
      try
      {
        paramString = (HashSet)this.a.getStringSet(paramString, null);
        if (paramString == null) {
          break label123;
        }
        paramString = new HashSet(paramString);
        return paramString;
      }
      catch (ClassCastException paramString)
      {
        b.d.w.c.a.d(paramString.toString());
      }
    }
    else
    {
      String str = this.a.getString(paramString, null);
      if (str != null)
      {
        HashSet localHashSet = new HashSet();
        try
        {
          paramString = new org/json/JSONArray;
          paramString.<init>(str);
          int i = 0;
          int j = paramString.length();
          while (i < j)
          {
            localHashSet.add(paramString.getString(i));
            i++;
          }
          return localHashSet;
        }
        catch (JSONException paramString)
        {
          b.d.w.c.a.d(paramString.toString());
        }
      }
    }
    label123:
    return null;
  }
  
  public void h(String paramString, boolean paramBoolean)
  {
    this.b.putBoolean(paramString, paramBoolean);
    this.b.commit();
  }
  
  public void i(String paramString, int paramInt)
  {
    this.b.putInt(paramString, paramInt);
    this.b.commit();
  }
  
  public void j(String paramString, long paramLong)
  {
    this.b.putLong(paramString, paramLong);
    this.b.commit();
  }
  
  public void k(String paramString1, String paramString2)
  {
    this.b.putString(paramString1, paramString2);
    this.b.commit();
  }
  
  public void l(Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      this.b.putString((String)paramMap.getKey(), (String)paramMap.getValue());
    }
    this.b.commit();
  }
  
  @SuppressLint({"NewApi"})
  public void m(String paramString, Set<String> paramSet)
  {
    if ((paramSet != null) && (paramSet.size() != 0)) {
      if (b.g())
      {
        this.b.putStringSet(paramString, paramSet);
        this.b.commit();
      }
      else
      {
        paramSet = new JSONArray(paramSet);
        this.b.putString(paramString, paramSet.toString());
        this.b.commit();
      }
    }
  }
  
  public void n(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      this.b.remove(paramList);
    }
    this.b.commit();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */