package com.tplink.iot.dailysummary.model;

import com.tplink.iot.Utils.q0;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClipVideo;
import com.tplink.iot.dailysummary.network.bean.common.SummaryImage;
import java.io.Serializable;
import kotlin.jvm.internal.j;

public final class SummaryClipItem
  implements Serializable
{
  private boolean choosed;
  private final String displayHour;
  private final String eventLocalTime;
  private final SummaryImage image;
  private final long splitPoint;
  private final int type;
  private final String uuid;
  private final SummaryClipVideo video;
  
  public SummaryClipItem()
  {
    this(null, null, 0L, null, null, false, 0, null, 255, null);
  }
  
  public SummaryClipItem(String paramString1, String paramString2, long paramLong, SummaryClipVideo paramSummaryClipVideo, SummaryImage paramSummaryImage, boolean paramBoolean, int paramInt, String paramString3)
  {
    this.uuid = paramString1;
    this.eventLocalTime = paramString2;
    this.splitPoint = paramLong;
    this.video = paramSummaryClipVideo;
    this.image = paramSummaryImage;
    this.choosed = paramBoolean;
    this.type = paramInt;
    this.displayHour = paramString3;
  }
  
  public final String component1()
  {
    return this.uuid;
  }
  
  public final String component2()
  {
    return this.eventLocalTime;
  }
  
  public final long component3()
  {
    return this.splitPoint;
  }
  
  public final SummaryClipVideo component4()
  {
    return this.video;
  }
  
  public final SummaryImage component5()
  {
    return this.image;
  }
  
  public final boolean component6()
  {
    return this.choosed;
  }
  
  public final int component7()
  {
    return this.type;
  }
  
  public final String component8()
  {
    return this.displayHour;
  }
  
  public final SummaryClipItem copy(String paramString1, String paramString2, long paramLong, SummaryClipVideo paramSummaryClipVideo, SummaryImage paramSummaryImage, boolean paramBoolean, int paramInt, String paramString3)
  {
    j.e(paramString1, "uuid");
    j.e(paramString2, "eventLocalTime");
    j.e(paramString3, "displayHour");
    return new SummaryClipItem(paramString1, paramString2, paramLong, paramSummaryClipVideo, paramSummaryImage, paramBoolean, paramInt, paramString3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SummaryClipItem))
      {
        paramObject = (SummaryClipItem)paramObject;
        if ((j.a(this.uuid, ((SummaryClipItem)paramObject).uuid)) && (j.a(this.eventLocalTime, ((SummaryClipItem)paramObject).eventLocalTime)) && (this.splitPoint == ((SummaryClipItem)paramObject).splitPoint) && (j.a(this.video, ((SummaryClipItem)paramObject).video)) && (j.a(this.image, ((SummaryClipItem)paramObject).image)) && (this.choosed == ((SummaryClipItem)paramObject).choosed) && (this.type == ((SummaryClipItem)paramObject).type) && (j.a(this.displayHour, ((SummaryClipItem)paramObject).displayHour))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getChoosed()
  {
    return this.choosed;
  }
  
  public final String getDisplayHour()
  {
    return this.displayHour;
  }
  
  public final String getDurationString()
  {
    String str = q0.b(this.eventLocalTime);
    j.d(str, "TimeUtils.generateDisplayTime(eventLocalTime)");
    return str;
  }
  
  public final String getEventLocalTime()
  {
    return this.eventLocalTime;
  }
  
  public final SummaryImage getImage()
  {
    return this.image;
  }
  
  public final long getSplitPoint()
  {
    return this.splitPoint;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final String getUuid()
  {
    return this.uuid;
  }
  
  public final SummaryClipVideo getVideo()
  {
    return this.video;
  }
  
  public int hashCode()
  {
    Object localObject = this.uuid;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.eventLocalTime;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    int m = a.a(this.splitPoint);
    localObject = this.video;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.image;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    int i2 = this.choosed;
    int i4 = i2;
    if (i2 != 0) {
      i4 = 1;
    }
    int i3 = this.type;
    localObject = this.displayHour;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return ((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i4) * 31 + i3) * 31 + i;
  }
  
  public final void setChoosed(boolean paramBoolean)
  {
    this.choosed = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SummaryClipItem(uuid=");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append(", eventLocalTime=");
    localStringBuilder.append(this.eventLocalTime);
    localStringBuilder.append(", splitPoint=");
    localStringBuilder.append(this.splitPoint);
    localStringBuilder.append(", video=");
    localStringBuilder.append(this.video);
    localStringBuilder.append(", image=");
    localStringBuilder.append(this.image);
    localStringBuilder.append(", choosed=");
    localStringBuilder.append(this.choosed);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", displayHour=");
    localStringBuilder.append(this.displayHour);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\model\SummaryClipItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */