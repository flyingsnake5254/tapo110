package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.c;
import java.util.List;

public final class HubAlarmLogsResult
{
  private final List<HubAlarmLog> logs;
  @c("start_id")
  private final int startId;
  private final int sum;
  
  public HubAlarmLogsResult(int paramInt1, int paramInt2, List<HubAlarmLog> paramList)
  {
    this.startId = paramInt1;
    this.sum = paramInt2;
    this.logs = paramList;
  }
  
  public final List<HubAlarmLog> getLogs()
  {
    return this.logs;
  }
  
  public final int getStartId()
  {
    return this.startId;
  }
  
  public final int getSum()
  {
    return this.sum;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\result\HubAlarmLogsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */