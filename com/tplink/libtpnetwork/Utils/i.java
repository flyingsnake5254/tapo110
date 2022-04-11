package com.tplink.libtpnetwork.Utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.d;
import com.google.gson.f;
import com.google.gson.l;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i
{
  private static Gson a = new d().c().b();
  
  public static <T> T a(com.google.gson.i parami, Type paramType)
  {
    return (T)a.h(parami, paramType);
  }
  
  public static <T> T b(String paramString, Type paramType)
  {
    return (T)a.m(paramString, paramType);
  }
  
  @Nullable
  public static <T> T c(com.google.gson.i parami, Type paramType)
  {
    try
    {
      parami = a.h(parami, paramType);
      return parami;
    }
    catch (Exception parami)
    {
      parami.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public static <T> T d(String paramString, Type paramType)
  {
    try
    {
      paramString = a.m(paramString, paramType);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static <T> List<T> e(String paramString, Class<T> paramClass)
  {
    localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    try
    {
      Object localObject = new com/google/gson/l;
      ((l)localObject).<init>();
      paramString = ((l)localObject).a(paramString).b().iterator();
      while (paramString.hasNext())
      {
        localObject = (com.google.gson.i)paramString.next();
        localArrayList.add(a.g((com.google.gson.i)localObject, paramClass));
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String f(Object paramObject)
  {
    return a.u(paramObject);
  }
  
  public static String g(Object paramObject, Type paramType)
  {
    return a.v(paramObject, paramType);
  }
  
  public static String h(Object paramObject)
  {
    try
    {
      paramObject = a.u(paramObject);
      return (String)paramObject;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return "";
  }
  
  public static com.google.gson.i i(Object paramObject)
  {
    return a.A(paramObject);
  }
  
  public static String j(Object paramObject)
  {
    return new d().c().f().b().u(paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */