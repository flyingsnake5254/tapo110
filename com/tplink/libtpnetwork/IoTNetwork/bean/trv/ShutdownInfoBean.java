package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

import kotlin.jvm.internal.j;

public final class ShutdownInfoBean
{
  private boolean enable;
  private String mode;
  
  public ShutdownInfoBean(boolean paramBoolean, String paramString)
  {
    this.enable = paramBoolean;
    this.mode = paramString;
  }
  
  public final boolean component1()
  {
    return this.enable;
  }
  
  public final String component2()
  {
    return this.mode;
  }
  
  public final ShutdownInfoBean copy(boolean paramBoolean, String paramString)
  {
    return new ShutdownInfoBean(paramBoolean, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ShutdownInfoBean))
      {
        paramObject = (ShutdownInfoBean)paramObject;
        if ((this.enable == ((ShutdownInfoBean)paramObject).enable) && (j.a(this.mode, ((ShutdownInfoBean)paramObject).mode))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getEnable()
  {
    return this.enable;
  }
  
  public final EnumShutdownMode getEnumMode()
  {
    for (localEnumShutdownMode : ) {
      if (j.a(localEnumShutdownMode.getValue(), this.mode)) {
        break label46;
      }
    }
    EnumShutdownMode localEnumShutdownMode = null;
    label46:
    return localEnumShutdownMode;
  }
  
  public final String getMode()
  {
    return this.mode;
  }
  
  public int hashCode()
  {
    boolean bool1 = this.enable;
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = true;
    }
    String str = this.mode;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return bool2 * true + i;
  }
  
  public final void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public final void setMode(String paramString)
  {
    this.mode = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShutdownInfoBean(enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append(", mode=");
    localStringBuilder.append(this.mode);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\ShutdownInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */