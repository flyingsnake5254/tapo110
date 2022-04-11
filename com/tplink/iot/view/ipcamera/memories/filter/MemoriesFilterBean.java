package com.tplink.iot.view.ipcamera.memories.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MemoriesFilterBean
  implements Serializable
{
  private String designatedDeviceidMD5;
  private boolean hasCloudVideo;
  private boolean hasPicture;
  private boolean hasVideo;
  private List<String> onlyDeviceName = new ArrayList();
  private boolean onlyLike;
  private boolean onlyUnLick;
  
  public MemoriesFilterBean clone()
  {
    MemoriesFilterBean localMemoriesFilterBean = new MemoriesFilterBean();
    localMemoriesFilterBean.hasVideo = this.hasVideo;
    localMemoriesFilterBean.hasCloudVideo = this.hasCloudVideo;
    localMemoriesFilterBean.hasPicture = this.hasPicture;
    localMemoriesFilterBean.onlyDeviceName = this.onlyDeviceName;
    localMemoriesFilterBean.onlyLike = this.onlyLike;
    localMemoriesFilterBean.onlyUnLick = this.onlyUnLick;
    localMemoriesFilterBean.designatedDeviceidMD5 = this.designatedDeviceidMD5;
    return localMemoriesFilterBean;
  }
  
  public String getDesignatedDeviceidMD5()
  {
    return this.designatedDeviceidMD5;
  }
  
  public List<String> getOnlyDeviceName()
  {
    return this.onlyDeviceName;
  }
  
  public boolean isHasCloudVideo()
  {
    return this.hasCloudVideo;
  }
  
  public boolean isHasPicture()
  {
    return this.hasPicture;
  }
  
  public boolean isHasVideo()
  {
    return this.hasVideo;
  }
  
  public boolean isOnlyLike()
  {
    return this.onlyLike;
  }
  
  public boolean isOnlyUnLick()
  {
    return this.onlyUnLick;
  }
  
  public boolean isSelectAll()
  {
    boolean bool = this.hasVideo;
    if (((!bool) && (!this.hasCloudVideo) && (!this.hasPicture)) || ((bool) && (this.hasCloudVideo) && (this.hasPicture)))
    {
      bool = this.onlyLike;
      if (((!bool) && (!this.onlyUnLick)) || ((bool) && (this.onlyUnLick)))
      {
        List localList = this.onlyDeviceName;
        if (((localList == null) || (localList.size() <= 0)) && (this.designatedDeviceidMD5 == null)) {
          return true;
        }
      }
    }
    bool = false;
    return bool;
  }
  
  public void selectAll()
  {
    this.hasVideo = false;
    this.hasCloudVideo = false;
    this.hasPicture = false;
    this.onlyLike = false;
    this.onlyUnLick = false;
    this.onlyDeviceName = new ArrayList(0);
    this.designatedDeviceidMD5 = null;
  }
  
  public void setDesignatedDeviceidMD5(String paramString)
  {
    this.designatedDeviceidMD5 = paramString;
  }
  
  public void setHasCloudVideo(boolean paramBoolean)
  {
    this.hasCloudVideo = paramBoolean;
  }
  
  public void setHasPicture(boolean paramBoolean)
  {
    this.hasPicture = paramBoolean;
  }
  
  public void setHasVideo(boolean paramBoolean)
  {
    this.hasVideo = paramBoolean;
  }
  
  public void setOnlyDeviceName(List<String> paramList)
  {
    this.onlyDeviceName = paramList;
  }
  
  public void setOnlyLike(boolean paramBoolean)
  {
    this.onlyLike = paramBoolean;
  }
  
  public void setOnlyUnLick(boolean paramBoolean)
  {
    this.onlyUnLick = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\memories\filter\MemoriesFilterBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */