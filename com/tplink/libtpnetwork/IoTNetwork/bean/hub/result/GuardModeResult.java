package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode.a;
import kotlin.jvm.internal.j;

public final class GuardModeResult
{
  private boolean enable;
  @c("guard_mode")
  private String guardMode;
  
  public GuardModeResult(boolean paramBoolean, String paramString)
  {
    this.enable = paramBoolean;
    this.guardMode = paramString;
  }
  
  public final boolean component1()
  {
    return this.enable;
  }
  
  public final String component2()
  {
    return this.guardMode;
  }
  
  public final GuardModeResult copy(boolean paramBoolean, String paramString)
  {
    j.e(paramString, "guardMode");
    return new GuardModeResult(paramBoolean, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof GuardModeResult))
      {
        paramObject = (GuardModeResult)paramObject;
        if ((this.enable == ((GuardModeResult)paramObject).enable) && (j.a(this.guardMode, ((GuardModeResult)paramObject).guardMode))) {}
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
  
  public final EnumGuardMode getEnumGuardMode()
  {
    return EnumGuardMode.Companion.a(this.guardMode);
  }
  
  public final String getGuardMode()
  {
    return this.guardMode;
  }
  
  public int hashCode()
  {
    boolean bool1 = this.enable;
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = true;
    }
    String str = this.guardMode;
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
  
  public final void setGuardMode(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.guardMode = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuardModeResult(enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append(", guardMode=");
    localStringBuilder.append(this.guardMode);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\result\GuardModeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */