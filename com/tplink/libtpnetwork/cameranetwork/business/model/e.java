package com.tplink.libtpnetwork.cameranetwork.business.model;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class e
{
  private boolean a;
  private List<d> b = new ArrayList();
  
  public List<d> a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public void c(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void d(List<d> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool1 = paramObject instanceof e;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (e)paramObject;
      bool3 = bool2;
      if (((e)paramObject).a == this.a)
      {
        bool3 = bool2;
        if (((e)paramObject).b.equals(this.b)) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */