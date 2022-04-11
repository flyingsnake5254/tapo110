package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class DstInfo
{
  @c("dst_end_1")
  private final String dstEndNorthern;
  @c("dst_end_2")
  private final String dstEndSouthern;
  @c("dst_local_end")
  private final String dstLocalEnd;
  @c("dst_local_start")
  private final String dstLocalStart;
  @c("dst_offset")
  private final String dstOffset;
  @c("dst_savings_1")
  private final String dstSavingsNorthern;
  @c("dst_savings_2")
  private final String dstSavingsSouthern;
  @c("dst_start_1")
  private final String dstStartNorthern;
  @c("dst_start_2")
  private final String dstStartSouthern;
  @c("enabled")
  private final String enabled;
  @c("has_rule")
  private final String hasRule;
  private final String synced;
  
  public DstInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    this.enabled = paramString1;
    this.hasRule = paramString2;
    this.dstSavingsNorthern = paramString3;
    this.dstStartNorthern = paramString4;
    this.dstEndNorthern = paramString5;
    this.dstSavingsSouthern = paramString6;
    this.dstStartSouthern = paramString7;
    this.dstEndSouthern = paramString8;
    this.dstLocalStart = paramString9;
    this.dstLocalEnd = paramString10;
    this.dstOffset = paramString11;
    this.synced = paramString12;
  }
  
  public final String component1()
  {
    return this.enabled;
  }
  
  public final String component10()
  {
    return this.dstLocalEnd;
  }
  
  public final String component11()
  {
    return this.dstOffset;
  }
  
  public final String component12()
  {
    return this.synced;
  }
  
  public final String component2()
  {
    return this.hasRule;
  }
  
  public final String component3()
  {
    return this.dstSavingsNorthern;
  }
  
  public final String component4()
  {
    return this.dstStartNorthern;
  }
  
  public final String component5()
  {
    return this.dstEndNorthern;
  }
  
  public final String component6()
  {
    return this.dstSavingsSouthern;
  }
  
  public final String component7()
  {
    return this.dstStartSouthern;
  }
  
  public final String component8()
  {
    return this.dstEndSouthern;
  }
  
  public final String component9()
  {
    return this.dstLocalStart;
  }
  
  public final DstInfo copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    return new DstInfo(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DstInfo))
      {
        paramObject = (DstInfo)paramObject;
        if ((j.a(this.enabled, ((DstInfo)paramObject).enabled)) && (j.a(this.hasRule, ((DstInfo)paramObject).hasRule)) && (j.a(this.dstSavingsNorthern, ((DstInfo)paramObject).dstSavingsNorthern)) && (j.a(this.dstStartNorthern, ((DstInfo)paramObject).dstStartNorthern)) && (j.a(this.dstEndNorthern, ((DstInfo)paramObject).dstEndNorthern)) && (j.a(this.dstSavingsSouthern, ((DstInfo)paramObject).dstSavingsSouthern)) && (j.a(this.dstStartSouthern, ((DstInfo)paramObject).dstStartSouthern)) && (j.a(this.dstEndSouthern, ((DstInfo)paramObject).dstEndSouthern)) && (j.a(this.dstLocalStart, ((DstInfo)paramObject).dstLocalStart)) && (j.a(this.dstLocalEnd, ((DstInfo)paramObject).dstLocalEnd)) && (j.a(this.dstOffset, ((DstInfo)paramObject).dstOffset)) && (j.a(this.synced, ((DstInfo)paramObject).synced))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDstEndNorthern()
  {
    return this.dstEndNorthern;
  }
  
  public final String getDstEndSouthern()
  {
    return this.dstEndSouthern;
  }
  
  public final String getDstLocalEnd()
  {
    return this.dstLocalEnd;
  }
  
  public final String getDstLocalStart()
  {
    return this.dstLocalStart;
  }
  
  public final String getDstOffset()
  {
    return this.dstOffset;
  }
  
  public final String getDstSavingsNorthern()
  {
    return this.dstSavingsNorthern;
  }
  
  public final String getDstSavingsSouthern()
  {
    return this.dstSavingsSouthern;
  }
  
  public final String getDstStartNorthern()
  {
    return this.dstStartNorthern;
  }
  
  public final String getDstStartSouthern()
  {
    return this.dstStartSouthern;
  }
  
  public final String getEnabled()
  {
    return this.enabled;
  }
  
  public final String getHasRule()
  {
    return this.hasRule;
  }
  
  public final String getSynced()
  {
    return this.synced;
  }
  
  public int hashCode()
  {
    String str = this.enabled;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.hasRule;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.dstSavingsNorthern;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.dstStartNorthern;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.dstEndNorthern;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.dstSavingsSouthern;
    int i2;
    if (str != null) {
      i2 = str.hashCode();
    } else {
      i2 = 0;
    }
    str = this.dstStartSouthern;
    int i3;
    if (str != null) {
      i3 = str.hashCode();
    } else {
      i3 = 0;
    }
    str = this.dstEndSouthern;
    int i4;
    if (str != null) {
      i4 = str.hashCode();
    } else {
      i4 = 0;
    }
    str = this.dstLocalStart;
    int i5;
    if (str != null) {
      i5 = str.hashCode();
    } else {
      i5 = 0;
    }
    str = this.dstLocalEnd;
    int i6;
    if (str != null) {
      i6 = str.hashCode();
    } else {
      i6 = 0;
    }
    str = this.dstOffset;
    int i7;
    if (str != null) {
      i7 = str.hashCode();
    } else {
      i7 = 0;
    }
    str = this.synced;
    if (str != null) {
      i = str.hashCode();
    }
    return ((((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DstInfo(enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", hasRule=");
    localStringBuilder.append(this.hasRule);
    localStringBuilder.append(", dstSavingsNorthern=");
    localStringBuilder.append(this.dstSavingsNorthern);
    localStringBuilder.append(", dstStartNorthern=");
    localStringBuilder.append(this.dstStartNorthern);
    localStringBuilder.append(", dstEndNorthern=");
    localStringBuilder.append(this.dstEndNorthern);
    localStringBuilder.append(", dstSavingsSouthern=");
    localStringBuilder.append(this.dstSavingsSouthern);
    localStringBuilder.append(", dstStartSouthern=");
    localStringBuilder.append(this.dstStartSouthern);
    localStringBuilder.append(", dstEndSouthern=");
    localStringBuilder.append(this.dstEndSouthern);
    localStringBuilder.append(", dstLocalStart=");
    localStringBuilder.append(this.dstLocalStart);
    localStringBuilder.append(", dstLocalEnd=");
    localStringBuilder.append(this.dstLocalEnd);
    localStringBuilder.append(", dstOffset=");
    localStringBuilder.append(this.dstOffset);
    localStringBuilder.append(", synced=");
    localStringBuilder.append(this.synced);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\DstInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */