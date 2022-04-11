package com.tplink.libtpnetwork.cameranetwork.business.model;

import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionSchedule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class c
{
  private boolean a;
  private List<a> b = new ArrayList();
  private Map<DayOfWeek, List<IntrusionSchedule>> c = new EnumMap(DayOfWeek.class);
  
  public List<a> a()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public List<IntrusionSchedule> b(DayOfWeek paramDayOfWeek)
  {
    return Collections.unmodifiableList((List)this.c.get(paramDayOfWeek));
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public void d(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void e(List<a> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      if ((((c)paramObject).a == this.a) && (((c)paramObject).b.equals(this.b))) {
        return true;
      }
    }
    return false;
  }
  
  public void f(DayOfWeek paramDayOfWeek, @Nullable List<IntrusionSchedule> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null) {
      localArrayList.addAll(paramList);
    }
    this.c.put(paramDayOfWeek, localArrayList);
  }
  
  public static class a
  {
    private int a;
    private int b;
    private int c;
    private int d;
    
    public a() {}
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
    }
    
    public int a()
    {
      return this.d;
    }
    
    public int b()
    {
      return this.c;
    }
    
    public int c()
    {
      return this.a;
    }
    
    public int d()
    {
      return this.b;
    }
    
    public void e(int paramInt)
    {
      this.d = paramInt;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool1 = paramObject instanceof a;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      if (paramObject == this) {
        return true;
      }
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (((a)paramObject).a == this.a)
      {
        bool1 = bool2;
        if (((a)paramObject).b == this.b)
        {
          bool1 = bool2;
          if (((a)paramObject).c == this.c)
          {
            bool1 = bool2;
            if (((a)paramObject).d == this.d) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    public void f(int paramInt)
    {
      this.c = paramInt;
    }
    
    public void g(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void h(int paramInt)
    {
      this.b = paramInt;
    }
    
    public int hashCode()
    {
      return ((this.a * 31 + this.b) * 31 + this.c) * 31 + this.d;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */