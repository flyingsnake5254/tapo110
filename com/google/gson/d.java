package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d
{
  private Excluder a = Excluder.c;
  private LongSerializationPolicy b = LongSerializationPolicy.DEFAULT;
  private c c = FieldNamingPolicy.IDENTITY;
  private final Map<Type, e<?>> d = new HashMap();
  private final List<p> e = new ArrayList();
  private final List<p> f = new ArrayList();
  private boolean g = false;
  private String h;
  private int i = 2;
  private int j = 2;
  private boolean k = false;
  private boolean l = false;
  private boolean m = true;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  
  private void a(String paramString, int paramInt1, int paramInt2, List<p> paramList)
  {
    Object localObject;
    DefaultDateTypeAdapter localDefaultDateTypeAdapter1;
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      localObject = new DefaultDateTypeAdapter(java.util.Date.class, paramString);
      localDefaultDateTypeAdapter1 = new DefaultDateTypeAdapter(Timestamp.class, paramString);
      paramString = new DefaultDateTypeAdapter(java.sql.Date.class, paramString);
    }
    else
    {
      if ((paramInt1 == 2) || (paramInt2 == 2)) {
        return;
      }
      paramString = new DefaultDateTypeAdapter(java.util.Date.class, paramInt1, paramInt2);
      localDefaultDateTypeAdapter1 = new DefaultDateTypeAdapter(Timestamp.class, paramInt1, paramInt2);
      DefaultDateTypeAdapter localDefaultDateTypeAdapter2 = new DefaultDateTypeAdapter(java.sql.Date.class, paramInt1, paramInt2);
      localObject = paramString;
      paramString = localDefaultDateTypeAdapter2;
    }
    paramList.add(TypeAdapters.b(java.util.Date.class, (TypeAdapter)localObject));
    paramList.add(TypeAdapters.b(Timestamp.class, localDefaultDateTypeAdapter1));
    paramList.add(TypeAdapters.b(java.sql.Date.class, paramString));
  }
  
  public Gson b()
  {
    ArrayList localArrayList1 = new ArrayList(this.e.size() + this.f.size() + 3);
    localArrayList1.addAll(this.e);
    Collections.reverse(localArrayList1);
    ArrayList localArrayList2 = new ArrayList(this.f);
    Collections.reverse(localArrayList2);
    localArrayList1.addAll(localArrayList2);
    a(this.h, this.i, this.j, localArrayList1);
    return new Gson(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.b, this.h, this.i, this.j, this.e, this.f, localArrayList1);
  }
  
  public d c()
  {
    this.m = false;
    return this;
  }
  
  public d d(Type paramType, Object paramObject)
  {
    boolean bool1 = paramObject instanceof o;
    boolean bool2;
    if ((!bool1) && (!(paramObject instanceof h)) && (!(paramObject instanceof e)) && (!(paramObject instanceof TypeAdapter))) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    com.google.gson.internal.a.a(bool2);
    if ((paramObject instanceof e)) {
      this.d.put(paramType, (e)paramObject);
    }
    if ((bool1) || ((paramObject instanceof h)))
    {
      com.google.gson.r.a locala = com.google.gson.r.a.get(paramType);
      this.e.add(TreeTypeAdapter.b(locala, paramObject));
    }
    if ((paramObject instanceof TypeAdapter)) {
      this.e.add(TypeAdapters.a(com.google.gson.r.a.get(paramType), (TypeAdapter)paramObject));
    }
    return this;
  }
  
  public d e(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public d f()
  {
    this.n = true;
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */