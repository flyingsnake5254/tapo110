package com.tplink.libtpnetwork.cameranetwork.business.model;

import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class o
{
  private boolean a;
  private Map<DayOfWeek, List<Schedule>> b = new EnumMap(DayOfWeek.class);
  
  public Map<DayOfWeek, List<Schedule>> a()
  {
    return this.b;
  }
  
  public List<Schedule> b(DayOfWeek paramDayOfWeek)
  {
    return Collections.unmodifiableList((List)this.b.get(paramDayOfWeek));
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public void d(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void e(DayOfWeek paramDayOfWeek, @Nullable List<Schedule> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null) {
      localArrayList.addAll(paramList);
    }
    this.b.put(paramDayOfWeek, localArrayList);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */