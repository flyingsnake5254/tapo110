package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.List;
import kotlin.jvm.internal.j;

public final class OsdConfig
{
  public static final Companion Companion = new Companion(null);
  private final OsdElement date;
  private final OsdFont font;
  private final List<OsdElement> labels;
  private final OsdElement logo;
  private final OsdElement week;
  
  public OsdConfig(OsdElement paramOsdElement1, OsdElement paramOsdElement2, OsdElement paramOsdElement3, OsdFont paramOsdFont, List<OsdElement> paramList)
  {
    this.logo = paramOsdElement1;
    this.date = paramOsdElement2;
    this.week = paramOsdElement3;
    this.font = paramOsdFont;
    this.labels = paramList;
  }
  
  public final OsdElement component1()
  {
    return this.logo;
  }
  
  public final OsdElement component2()
  {
    return this.date;
  }
  
  public final OsdElement component3()
  {
    return this.week;
  }
  
  public final OsdFont component4()
  {
    return this.font;
  }
  
  public final List<OsdElement> component5()
  {
    return this.labels;
  }
  
  public final OsdConfig copy(OsdElement paramOsdElement1, OsdElement paramOsdElement2, OsdElement paramOsdElement3, OsdFont paramOsdFont, List<OsdElement> paramList)
  {
    return new OsdConfig(paramOsdElement1, paramOsdElement2, paramOsdElement3, paramOsdFont, paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof OsdConfig))
      {
        paramObject = (OsdConfig)paramObject;
        if ((j.a(this.logo, ((OsdConfig)paramObject).logo)) && (j.a(this.date, ((OsdConfig)paramObject).date)) && (j.a(this.week, ((OsdConfig)paramObject).week)) && (j.a(this.font, ((OsdConfig)paramObject).font)) && (j.a(this.labels, ((OsdConfig)paramObject).labels))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final OsdElement getDate()
  {
    return this.date;
  }
  
  public final OsdFont getFont()
  {
    return this.font;
  }
  
  public final List<OsdElement> getLabels()
  {
    return this.labels;
  }
  
  public final OsdElement getLogo()
  {
    return this.logo;
  }
  
  public final OsdElement getWeek()
  {
    return this.week;
  }
  
  public int hashCode()
  {
    Object localObject = this.logo;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.date;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.week;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.font;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.labels;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OsdConfig(logo=");
    localStringBuilder.append(this.logo);
    localStringBuilder.append(", date=");
    localStringBuilder.append(this.date);
    localStringBuilder.append(", week=");
    localStringBuilder.append(this.week);
    localStringBuilder.append(", font=");
    localStringBuilder.append(this.font);
    localStringBuilder.append(", labels=");
    localStringBuilder.append(this.labels);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
    implements UnwrapFromResponse<OsdConfig>
  {
    public OsdConfig fromResponse(Response<Wrappers> paramResponse)
    {
      j.e(paramResponse, "response");
      if (j.a(paramResponse.getMethod(), Method.GET_OSD.getValue()))
      {
        Wrappers localWrappers = (Wrappers)paramResponse.getResult();
        paramResponse = Module.OSD;
        paramResponse = new OsdConfig((OsdElement)Model.typeCast(localWrappers, paramResponse, Section.OSD_LOGO), (OsdElement)Model.typeCast(localWrappers, paramResponse, Section.OSD_DATE), (OsdElement)Model.typeCast(localWrappers, paramResponse, Section.OSD_WEEK), (OsdFont)Model.typeCast(localWrappers, paramResponse, Section.OSD_FONT), Model.toOsdList(localWrappers));
      }
      else
      {
        paramResponse = null;
      }
      return paramResponse;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\OsdConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */