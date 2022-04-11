package com.tplink.cloud.bean.firmware.result;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

public class FirmwareListResult
{
  @c(alternate={"fwVersions"}, value="fwList")
  private List<FirmwareInfoResult> fwList = new ArrayList();
  
  public List<FirmwareInfoResult> getFwList()
  {
    return this.fwList;
  }
  
  public void setFwList(List<FirmwareInfoResult> paramList)
  {
    this.fwList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\firmware\result\FirmwareListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */