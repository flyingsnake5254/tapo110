package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class VideoCapabilities
{
  private final VideoCapability main;
  private final VideoCapability minor;
  
  public VideoCapabilities(VideoCapability paramVideoCapability1, VideoCapability paramVideoCapability2)
  {
    this.main = paramVideoCapability1;
    this.minor = paramVideoCapability2;
  }
  
  public VideoCapabilities(Wrappers paramWrappers)
  {
    this((VideoCapability)Model.typeCast(paramWrappers, localModule, Section.VIDEO_MAIN), (VideoCapability)Model.typeCast(paramWrappers, localModule, Section.VIDEO_MINOR));
  }
  
  public final VideoCapability component1()
  {
    return this.main;
  }
  
  public final VideoCapability component2()
  {
    return this.minor;
  }
  
  public final VideoCapabilities copy(VideoCapability paramVideoCapability1, VideoCapability paramVideoCapability2)
  {
    return new VideoCapabilities(paramVideoCapability1, paramVideoCapability2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoCapabilities))
      {
        paramObject = (VideoCapabilities)paramObject;
        if ((j.a(this.main, ((VideoCapabilities)paramObject).main)) && (j.a(this.minor, ((VideoCapabilities)paramObject).minor))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final VideoCapability getMain()
  {
    return this.main;
  }
  
  public final VideoCapability getMinor()
  {
    return this.minor;
  }
  
  public int hashCode()
  {
    VideoCapability localVideoCapability = this.main;
    int i = 0;
    int j;
    if (localVideoCapability != null) {
      j = localVideoCapability.hashCode();
    } else {
      j = 0;
    }
    localVideoCapability = this.minor;
    if (localVideoCapability != null) {
      i = localVideoCapability.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoCapabilities(main=");
    localStringBuilder.append(this.main);
    localStringBuilder.append(", minor=");
    localStringBuilder.append(this.minor);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\VideoCapabilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */