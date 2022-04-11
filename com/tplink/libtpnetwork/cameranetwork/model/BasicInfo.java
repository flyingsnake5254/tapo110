package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class BasicInfo
{
  @c("avatar")
  private final String avatar;
  private final String barcode;
  @c("device_alias")
  private final String deviceAlias;
  @c("dev_id")
  private final String deviceId;
  @c("features")
  private final String feature;
  @c("ffs")
  private final boolean ffs;
  @c("hw_desc")
  private final String hardwareDesc;
  @c("hw_version")
  private final String hardwareVer;
  @c("device_info")
  private final String info;
  @c("lock_message")
  private final String lockMessage;
  @c("lock_status")
  private final Integer lockStatus;
  private final String mac;
  @c("device_model")
  private final String model;
  @c("device_name")
  private final String name;
  @c("oem_id")
  private final String oemId;
  @c("oem_name")
  private final String oenName;
  @c("sw_version")
  private final String softwareVer;
  @c("device_type")
  private final String type;
  
  public BasicInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, boolean paramBoolean, String paramString15, Integer paramInteger, String paramString16)
  {
    this.type = paramString1;
    this.model = paramString2;
    this.name = paramString3;
    this.info = paramString4;
    this.hardwareVer = paramString5;
    this.softwareVer = paramString6;
    this.deviceAlias = paramString7;
    this.avatar = paramString8;
    this.feature = paramString9;
    this.barcode = paramString10;
    this.mac = paramString11;
    this.deviceId = paramString12;
    this.oemId = paramString13;
    this.hardwareDesc = paramString14;
    this.ffs = paramBoolean;
    this.oenName = paramString15;
    this.lockStatus = paramInteger;
    this.lockMessage = paramString16;
  }
  
  public final String component1()
  {
    return this.type;
  }
  
  public final String component10()
  {
    return this.barcode;
  }
  
  public final String component11()
  {
    return this.mac;
  }
  
  public final String component12()
  {
    return this.deviceId;
  }
  
  public final String component13()
  {
    return this.oemId;
  }
  
  public final String component14()
  {
    return this.hardwareDesc;
  }
  
  public final boolean component15()
  {
    return this.ffs;
  }
  
  public final String component16()
  {
    return this.oenName;
  }
  
  public final Integer component17()
  {
    return this.lockStatus;
  }
  
  public final String component18()
  {
    return this.lockMessage;
  }
  
  public final String component2()
  {
    return this.model;
  }
  
  public final String component3()
  {
    return this.name;
  }
  
  public final String component4()
  {
    return this.info;
  }
  
  public final String component5()
  {
    return this.hardwareVer;
  }
  
  public final String component6()
  {
    return this.softwareVer;
  }
  
  public final String component7()
  {
    return this.deviceAlias;
  }
  
  public final String component8()
  {
    return this.avatar;
  }
  
  public final String component9()
  {
    return this.feature;
  }
  
  public final BasicInfo copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, boolean paramBoolean, String paramString15, Integer paramInteger, String paramString16)
  {
    j.e(paramString1, "type");
    j.e(paramString2, "model");
    j.e(paramString3, "name");
    j.e(paramString4, "info");
    j.e(paramString5, "hardwareVer");
    j.e(paramString6, "softwareVer");
    j.e(paramString7, "deviceAlias");
    j.e(paramString9, "feature");
    j.e(paramString10, "barcode");
    j.e(paramString11, "mac");
    j.e(paramString12, "deviceId");
    j.e(paramString13, "oemId");
    j.e(paramString14, "hardwareDesc");
    return new BasicInfo(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramBoolean, paramString15, paramInteger, paramString16);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof BasicInfo))
      {
        paramObject = (BasicInfo)paramObject;
        if ((j.a(this.type, ((BasicInfo)paramObject).type)) && (j.a(this.model, ((BasicInfo)paramObject).model)) && (j.a(this.name, ((BasicInfo)paramObject).name)) && (j.a(this.info, ((BasicInfo)paramObject).info)) && (j.a(this.hardwareVer, ((BasicInfo)paramObject).hardwareVer)) && (j.a(this.softwareVer, ((BasicInfo)paramObject).softwareVer)) && (j.a(this.deviceAlias, ((BasicInfo)paramObject).deviceAlias)) && (j.a(this.avatar, ((BasicInfo)paramObject).avatar)) && (j.a(this.feature, ((BasicInfo)paramObject).feature)) && (j.a(this.barcode, ((BasicInfo)paramObject).barcode)) && (j.a(this.mac, ((BasicInfo)paramObject).mac)) && (j.a(this.deviceId, ((BasicInfo)paramObject).deviceId)) && (j.a(this.oemId, ((BasicInfo)paramObject).oemId)) && (j.a(this.hardwareDesc, ((BasicInfo)paramObject).hardwareDesc)) && (this.ffs == ((BasicInfo)paramObject).ffs) && (j.a(this.oenName, ((BasicInfo)paramObject).oenName)) && (j.a(this.lockStatus, ((BasicInfo)paramObject).lockStatus)) && (j.a(this.lockMessage, ((BasicInfo)paramObject).lockMessage))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getAvatar()
  {
    return this.avatar;
  }
  
  public final String getBarcode()
  {
    return this.barcode;
  }
  
  public final String getDeviceAlias()
  {
    return this.deviceAlias;
  }
  
  public final String getDeviceId()
  {
    return this.deviceId;
  }
  
  public final String getFeature()
  {
    return this.feature;
  }
  
  public final boolean getFfs()
  {
    return this.ffs;
  }
  
  public final String getHardwareDesc()
  {
    return this.hardwareDesc;
  }
  
  public final String getHardwareVer()
  {
    return this.hardwareVer;
  }
  
  public final String getInfo()
  {
    return this.info;
  }
  
  public final String getLockMessage()
  {
    return this.lockMessage;
  }
  
  public final Integer getLockStatus()
  {
    return this.lockStatus;
  }
  
  public final String getMac()
  {
    return this.mac;
  }
  
  public final String getModel()
  {
    return this.model;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final String getOemId()
  {
    return this.oemId;
  }
  
  public final String getOenName()
  {
    return this.oenName;
  }
  
  public final String getSoftwareVer()
  {
    return this.softwareVer;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    Object localObject = this.type;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.model;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.name;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.info;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.hardwareVer;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.softwareVer;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    localObject = this.deviceAlias;
    int i3;
    if (localObject != null) {
      i3 = localObject.hashCode();
    } else {
      i3 = 0;
    }
    localObject = this.avatar;
    int i4;
    if (localObject != null) {
      i4 = localObject.hashCode();
    } else {
      i4 = 0;
    }
    localObject = this.feature;
    int i5;
    if (localObject != null) {
      i5 = localObject.hashCode();
    } else {
      i5 = 0;
    }
    localObject = this.barcode;
    int i6;
    if (localObject != null) {
      i6 = localObject.hashCode();
    } else {
      i6 = 0;
    }
    localObject = this.mac;
    int i7;
    if (localObject != null) {
      i7 = localObject.hashCode();
    } else {
      i7 = 0;
    }
    localObject = this.deviceId;
    int i8;
    if (localObject != null) {
      i8 = localObject.hashCode();
    } else {
      i8 = 0;
    }
    localObject = this.oemId;
    int i9;
    if (localObject != null) {
      i9 = localObject.hashCode();
    } else {
      i9 = 0;
    }
    localObject = this.hardwareDesc;
    int i10;
    if (localObject != null) {
      i10 = localObject.hashCode();
    } else {
      i10 = 0;
    }
    int i11 = this.ffs;
    int i13 = i11;
    if (i11 != 0) {
      i13 = 1;
    }
    localObject = this.oenName;
    int i12;
    if (localObject != null) {
      i12 = localObject.hashCode();
    } else {
      i12 = 0;
    }
    localObject = this.lockStatus;
    int i14;
    if (localObject != null) {
      i14 = localObject.hashCode();
    } else {
      i14 = 0;
    }
    localObject = this.lockMessage;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return ((((((((((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i13) * 31 + i12) * 31 + i14) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BasicInfo(type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", model=");
    localStringBuilder.append(this.model);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", info=");
    localStringBuilder.append(this.info);
    localStringBuilder.append(", hardwareVer=");
    localStringBuilder.append(this.hardwareVer);
    localStringBuilder.append(", softwareVer=");
    localStringBuilder.append(this.softwareVer);
    localStringBuilder.append(", deviceAlias=");
    localStringBuilder.append(this.deviceAlias);
    localStringBuilder.append(", avatar=");
    localStringBuilder.append(this.avatar);
    localStringBuilder.append(", feature=");
    localStringBuilder.append(this.feature);
    localStringBuilder.append(", barcode=");
    localStringBuilder.append(this.barcode);
    localStringBuilder.append(", mac=");
    localStringBuilder.append(this.mac);
    localStringBuilder.append(", deviceId=");
    localStringBuilder.append(this.deviceId);
    localStringBuilder.append(", oemId=");
    localStringBuilder.append(this.oemId);
    localStringBuilder.append(", hardwareDesc=");
    localStringBuilder.append(this.hardwareDesc);
    localStringBuilder.append(", ffs=");
    localStringBuilder.append(this.ffs);
    localStringBuilder.append(", oenName=");
    localStringBuilder.append(this.oenName);
    localStringBuilder.append(", lockStatus=");
    localStringBuilder.append(this.lockStatus);
    localStringBuilder.append(", lockMessage=");
    localStringBuilder.append(this.lockMessage);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\BasicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */