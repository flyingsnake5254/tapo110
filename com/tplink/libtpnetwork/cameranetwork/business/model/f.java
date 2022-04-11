package com.tplink.libtpnetwork.cameranetwork.business.model;

import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionSchedule;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class f
{
  private boolean a;
  private List<LineCrossingDetectionRegion> b = new ArrayList();
  private Map<DayOfWeek, List<IntrusionSchedule>> c = new EnumMap(DayOfWeek.class);
  
  public List<LineCrossingDetectionRegion> a()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public List<IntrusionSchedule> b(DayOfWeek paramDayOfWeek)
  {
    return Collections.unmodifiableList((List)this.c.get(paramDayOfWeek));
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public void d(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void e(List<LineCrossingDetectionRegion> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      if ((((f)paramObject).a == this.a) && (((f)paramObject).b.equals(this.b))) {
        return true;
      }
    }
    return false;
  }
  
  public void f(DayOfWeek paramDayOfWeek, @Nullable List<IntrusionSchedule> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null) {
      localArrayList.addAll(paramList);
    }
    this.c.put(paramDayOfWeek, localArrayList);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */