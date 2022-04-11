package com.tplink.libtpnetwork.cameranetwork.business.model;

import com.tplink.libtpnetwork.cameranetwork.model.BitwiseWeekDay;
import com.tplink.libtpnetwork.cameranetwork.model.BitwiseWeekDayUtils;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private Schedule a;
  private List<BitwiseWeekDay> b;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<BitwiseWeekDay> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    this.b = localArrayList;
    localArrayList.addAll(paramList);
    this.a = new Schedule(paramInt1, paramInt2, paramInt3, paramInt4, BitwiseWeekDayUtils.daysToRawSet(paramList));
  }
  
  public a(Schedule paramSchedule)
  {
    ArrayList localArrayList = new ArrayList();
    this.b = localArrayList;
    this.a = paramSchedule;
    localArrayList.addAll(BitwiseWeekDayUtils.daysFromRawSet(paramSchedule.getType()));
  }
  
  public a a()
  {
    return new a(this.a.getStartHour(), this.a.getStartMinute(), this.a.getEndHour(), this.a.getEndMinute(), this.b);
  }
  
  public Schedule b()
  {
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */