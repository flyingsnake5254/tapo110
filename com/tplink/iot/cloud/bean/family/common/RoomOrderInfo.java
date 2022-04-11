package com.tplink.iot.cloud.bean.family.common;

import java.util.List;

public class RoomOrderInfo
{
  private List<String> roomIds;
  
  public RoomOrderInfo() {}
  
  public RoomOrderInfo(List<String> paramList)
  {
    this.roomIds = paramList;
  }
  
  public List<String> getRoomIds()
  {
    return this.roomIds;
  }
  
  public void setRoomIds(List<String> paramList)
  {
    this.roomIds = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\family\common\RoomOrderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */