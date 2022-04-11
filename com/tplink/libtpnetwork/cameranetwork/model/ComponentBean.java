package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class ComponentBean
{
  private String name;
  private int version;
  
  public ComponentBean(String paramString, int paramInt)
  {
    this.name = paramString;
    this.version = paramInt;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final int getVersion()
  {
    return this.version;
  }
  
  public final void setName(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.name = paramString;
  }
  
  public final void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ComponentBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */