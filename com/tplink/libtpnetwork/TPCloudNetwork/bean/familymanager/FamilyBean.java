package com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager;

import java.util.List;

public class FamilyBean
{
  private int mDeviceCount;
  private String mFamilyId;
  private String mFamilyName;
  private boolean mIsDefault;
  private List<RoomBean> mRoomList;
  
  public boolean getDefault()
  {
    return this.mIsDefault;
  }
  
  public int getDeviceCount()
  {
    return this.mDeviceCount;
  }
  
  public String getFamilyId()
  {
    return this.mFamilyId;
  }
  
  public String getFamilyName()
  {
    return this.mFamilyName;
  }
  
  public List<RoomBean> getRoomList()
  {
    return this.mRoomList;
  }
  
  public void setDeviceCount(int paramInt)
  {
    this.mDeviceCount = paramInt;
  }
  
  public void setFamilyId(String paramString)
  {
    this.mFamilyId = paramString;
  }
  
  public void setFamilyName(String paramString)
  {
    this.mFamilyName = paramString;
  }
  
  public void setIsDefault(boolean paramBoolean)
  {
    this.mIsDefault = paramBoolean;
  }
  
  public void setRoomList(List<RoomBean> paramList)
  {
    this.mRoomList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\bean\familymanager\FamilyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */