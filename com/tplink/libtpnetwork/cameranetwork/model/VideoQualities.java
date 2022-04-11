package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class VideoQualities
{
  private final VideoQuality main;
  private final VideoQuality minor;
  
  public VideoQualities(VideoQuality paramVideoQuality1, VideoQuality paramVideoQuality2)
  {
    this.main = paramVideoQuality1;
    this.minor = paramVideoQuality2;
  }
  
  public VideoQualities(Wrappers paramWrappers)
  {
    this((VideoQuality)Model.typeCast(paramWrappers, localModule, Section.VIDEO_MAIN), (VideoQuality)Model.typeCast(paramWrappers, localModule, Section.VIDEO_MINOR));
  }
  
  public final VideoQuality component1()
  {
    return this.main;
  }
  
  public final VideoQuality component2()
  {
    return this.minor;
  }
  
  public final VideoQualities copy(VideoQuality paramVideoQuality1, VideoQuality paramVideoQuality2)
  {
    return new VideoQualities(paramVideoQuality1, paramVideoQuality2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoQualities))
      {
        paramObject = (VideoQualities)paramObject;
        if ((j.a(this.main, ((VideoQualities)paramObject).main)) && (j.a(this.minor, ((VideoQualities)paramObject).minor))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final VideoQuality getMain()
  {
    return this.main;
  }
  
  public final VideoQuality getMinor()
  {
    return this.minor;
  }
  
  public int hashCode()
  {
    VideoQuality localVideoQuality = this.main;
    int i = 0;
    int j;
    if (localVideoQuality != null) {
      j = localVideoQuality.hashCode();
    } else {
      j = 0;
    }
    localVideoQuality = this.minor;
    if (localVideoQuality != null) {
      i = localVideoQuality.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoQualities(main=");
    localStringBuilder.append(this.main);
    localStringBuilder.append(", minor=");
    localStringBuilder.append(this.minor);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\VideoQualities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */