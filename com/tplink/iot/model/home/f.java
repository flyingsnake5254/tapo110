package com.tplink.iot.model.home;

import java.util.ArrayList;
import java.util.List;

public class f
{
  private List<HomeCacheBean> a;
  private boolean b;
  
  public f(List<HomeCacheBean> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    this.a = localArrayList;
    localArrayList.clear();
    this.a.addAll(paramList);
    this.b = paramBoolean;
  }
  
  public List<HomeCacheBean> a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\home\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */