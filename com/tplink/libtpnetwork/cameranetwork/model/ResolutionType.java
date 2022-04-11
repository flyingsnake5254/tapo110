package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public enum ResolutionType
{
  public static final Companion Companion = new Companion(null);
  private final String value;
  
  static
  {
    HD_4M localHD_4M = new HD_4M("HD_4M", 0);
    HD_4M = localHD_4M;
    HD_3M localHD_3M = new HD_3M("HD_3M", 1);
    HD_3M = localHD_3M;
    HD_1080P localHD_1080P = new HD_1080P("HD_1080P", 2);
    HD_1080P = localHD_1080P;
    HD_720P localHD_720P = new HD_720P("HD_720P", 3);
    HD_720P = localHD_720P;
    VGA_360P localVGA_360P = new VGA_360P("VGA_360P", 4);
    VGA_360P = localVGA_360P;
    $VALUES = new ResolutionType[] { localHD_4M, localHD_3M, localHD_1080P, localHD_720P, localVGA_360P };
  }
  
  private ResolutionType(String paramString)
  {
    this.value = paramString;
  }
  
  public static final ResolutionType fromString(String paramString)
  {
    return Companion.fromString(paramString);
  }
  
  public static final List<ResolutionType> fromStringList(List<String> paramList)
  {
    return Companion.fromStringList(paramList);
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public static final class Companion
  {
    public final ResolutionType fromString(String paramString)
    {
      j.e(paramString, "value");
      for (ResolutionType localResolutionType : ResolutionType.values()) {
        if (j.a(localResolutionType.getValue(), paramString)) {
          return localResolutionType;
        }
      }
      paramString = null;
      return paramString;
    }
    
    public final List<ResolutionType> fromStringList(List<String> paramList)
    {
      j.e(paramList, "valueList");
      ArrayList localArrayList = new ArrayList(l.l(paramList, 10));
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        localArrayList.add(ResolutionType.Companion.fromString(paramList));
      }
      return localArrayList;
    }
  }
  
  static final class HD_1080P
    extends ResolutionType
  {
    HD_1080P(String paramString, int paramInt)
    {
      super(paramInt, "1920*1080", null);
    }
    
    public String toString()
    {
      return getValue();
    }
  }
  
  static final class HD_3M
    extends ResolutionType
  {
    HD_3M(String paramString, int paramInt)
    {
      super(paramInt, "2304*1296", null);
    }
    
    public String toString()
    {
      return getValue();
    }
  }
  
  static final class HD_4M
    extends ResolutionType
  {
    HD_4M(String paramString, int paramInt)
    {
      super(paramInt, "2560*1440", null);
    }
    
    public String toString()
    {
      return getValue();
    }
  }
  
  static final class HD_720P
    extends ResolutionType
  {
    HD_720P(String paramString, int paramInt)
    {
      super(paramInt, "1280*720", null);
    }
    
    public String toString()
    {
      return getValue();
    }
  }
  
  static final class VGA_360P
    extends ResolutionType
  {
    VGA_360P(String paramString, int paramInt)
    {
      super(paramInt, "640*360", null);
    }
    
    public String toString()
    {
      return getValue();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ResolutionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */