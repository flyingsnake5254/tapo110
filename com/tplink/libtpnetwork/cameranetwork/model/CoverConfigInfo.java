package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class CoverConfigInfo
{
  private final CoverConfig config;
  private final List<CoverConfigRegion> regions;
  
  public CoverConfigInfo(CoverConfig paramCoverConfig, List<CoverConfigRegion> paramList)
  {
    this.config = paramCoverConfig;
    this.regions = paramList;
  }
  
  public CoverConfigInfo(Wrappers paramWrappers)
  {
    this(localCoverConfig, paramWrappers);
  }
  
  public final CoverConfig component1()
  {
    return this.config;
  }
  
  public final List<CoverConfigRegion> component2()
  {
    return this.regions;
  }
  
  public final CoverConfigInfo copy(CoverConfig paramCoverConfig, List<CoverConfigRegion> paramList)
  {
    return new CoverConfigInfo(paramCoverConfig, paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CoverConfigInfo))
      {
        paramObject = (CoverConfigInfo)paramObject;
        if ((j.a(this.config, ((CoverConfigInfo)paramObject).config)) && (j.a(this.regions, ((CoverConfigInfo)paramObject).regions))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final CoverConfig getConfig()
  {
    return this.config;
  }
  
  public final List<CoverConfigRegion> getRegions()
  {
    return this.regions;
  }
  
  public int hashCode()
  {
    Object localObject = this.config;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.regions;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CoverConfigInfo(config=");
    localStringBuilder.append(this.config);
    localStringBuilder.append(", regions=");
    localStringBuilder.append(this.regions);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CoverConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */