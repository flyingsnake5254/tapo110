package com.tplink.iot.model.cloudvideo;

import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import java.util.List;

public class CloudVideoItem
{
  public static final int TYPE_HEADER = 0;
  public static final int TYPE_VIDEO = 1;
  private CloudVideo mCloudVideo;
  private String mDisplayTime;
  private boolean mHasVideo;
  private int mType;
  
  public CloudVideoItem(CloudVideo paramCloudVideo, int paramInt)
  {
    this.mCloudVideo = paramCloudVideo;
    this.mType = paramInt;
  }
  
  public CloudVideo getCloudVideo()
  {
    return this.mCloudVideo;
  }
  
  public String getDisplayTime()
  {
    return this.mDisplayTime;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public boolean isHasVideo()
  {
    return this.mHasVideo;
  }
  
  public void setCloudVideo(CloudVideo paramCloudVideo)
  {
    this.mCloudVideo = paramCloudVideo;
  }
  
  public void setDisplayTime(String paramString)
  {
    this.mDisplayTime = paramString;
  }
  
  public void setHasVideo()
  {
    Object localObject = this.mCloudVideo;
    boolean bool1 = false;
    if (localObject == null)
    {
      this.mHasVideo = false;
      return;
    }
    localObject = ((CloudVideo)localObject).getPartCloudVideos();
    boolean bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (!((List)localObject).isEmpty()) {
        bool2 = true;
      }
    }
    this.mHasVideo = bool2;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\cloudvideo\CloudVideoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */