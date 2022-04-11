package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class NewFirmware
{
  private final String fw_new_notify;
  private final String fw_update_type;
  private final String not_show;
  
  public NewFirmware(String paramString1, String paramString2, String paramString3)
  {
    this.fw_new_notify = paramString1;
    this.fw_update_type = paramString2;
    this.not_show = paramString3;
  }
  
  public final String component1()
  {
    return this.fw_new_notify;
  }
  
  public final String component2()
  {
    return this.fw_update_type;
  }
  
  public final String component3()
  {
    return this.not_show;
  }
  
  public final NewFirmware copy(String paramString1, String paramString2, String paramString3)
  {
    return new NewFirmware(paramString1, paramString2, paramString3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NewFirmware))
      {
        paramObject = (NewFirmware)paramObject;
        if ((j.a(this.fw_new_notify, ((NewFirmware)paramObject).fw_new_notify)) && (j.a(this.fw_update_type, ((NewFirmware)paramObject).fw_update_type)) && (j.a(this.not_show, ((NewFirmware)paramObject).not_show))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getFw_new_notify()
  {
    return this.fw_new_notify;
  }
  
  public final String getFw_update_type()
  {
    return this.fw_update_type;
  }
  
  public final String getNot_show()
  {
    return this.not_show;
  }
  
  public int hashCode()
  {
    String str = this.fw_new_notify;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.fw_update_type;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.not_show;
    if (str != null) {
      i = str.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NewFirmware(fw_new_notify=");
    localStringBuilder.append(this.fw_new_notify);
    localStringBuilder.append(", fw_update_type=");
    localStringBuilder.append(this.fw_update_type);
    localStringBuilder.append(", not_show=");
    localStringBuilder.append(this.not_show);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\NewFirmware.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */