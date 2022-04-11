package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

public final class HubRemoveAlarmLogsParams
{
  private List<RemoveAlarmLogBean> logs;
  @c("remove_all")
  private boolean removeAll;
  
  public HubRemoveAlarmLogsParams(boolean paramBoolean, List<RemoveAlarmLogBean> paramList)
  {
    this.removeAll = paramBoolean;
    this.logs = paramList;
  }
  
  public final boolean component1()
  {
    return this.removeAll;
  }
  
  public final List<RemoveAlarmLogBean> component2()
  {
    return this.logs;
  }
  
  public final HubRemoveAlarmLogsParams copy(boolean paramBoolean, List<RemoveAlarmLogBean> paramList)
  {
    return new HubRemoveAlarmLogsParams(paramBoolean, paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HubRemoveAlarmLogsParams))
      {
        paramObject = (HubRemoveAlarmLogsParams)paramObject;
        if ((this.removeAll == ((HubRemoveAlarmLogsParams)paramObject).removeAll) && (j.a(this.logs, ((HubRemoveAlarmLogsParams)paramObject).logs))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<RemoveAlarmLogBean> getLogs()
  {
    return this.logs;
  }
  
  public final boolean getRemoveAll()
  {
    return this.removeAll;
  }
  
  public int hashCode()
  {
    boolean bool1 = this.removeAll;
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = true;
    }
    List localList = this.logs;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    return bool2 * true + i;
  }
  
  public final void setLogs(List<RemoveAlarmLogBean> paramList)
  {
    this.logs = paramList;
  }
  
  public final void setRemoveAll(boolean paramBoolean)
  {
    this.removeAll = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HubRemoveAlarmLogsParams(removeAll=");
    localStringBuilder.append(this.removeAll);
    localStringBuilder.append(", logs=");
    localStringBuilder.append(this.logs);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class RemoveAlarmLogBean
  {
    private int id;
    
    public RemoveAlarmLogBean(int paramInt)
    {
      this.id = paramInt;
    }
    
    public final int component1()
    {
      return this.id;
    }
    
    public final RemoveAlarmLogBean copy(int paramInt)
    {
      return new RemoveAlarmLogBean(paramInt);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this != paramObject) {
        if ((paramObject instanceof RemoveAlarmLogBean))
        {
          paramObject = (RemoveAlarmLogBean)paramObject;
          if (this.id == ((RemoveAlarmLogBean)paramObject).id) {}
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    
    public final int getId()
    {
      return this.id;
    }
    
    public int hashCode()
    {
      return this.id;
    }
    
    public final void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RemoveAlarmLogBean(id=");
      localStringBuilder.append(this.id);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\params\HubRemoveAlarmLogsParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */