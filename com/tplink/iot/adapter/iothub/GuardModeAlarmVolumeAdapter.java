package com.tplink.iot.adapter.iothub;

import android.content.Context;
import android.widget.TextView;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkViewHolder;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class GuardModeAlarmVolumeAdapter
  extends SingleCheckMarkAdapter<a>
{
  private static final List<a> g = l.g(new a[] { new a(2131954447, EnumGuardModeAlarmVolume.MUTE), new a(2131953103, EnumGuardModeAlarmVolume.LOW), new a(2131953104, EnumGuardModeAlarmVolume.NORMAL), new a(2131953102, EnumGuardModeAlarmVolume.HIGH) });
  public static final b h = new b(null);
  
  public GuardModeAlarmVolumeAdapter(Context paramContext)
  {
    super(paramContext, g, 0, 4, null);
  }
  
  public void B(SingleCheckMarkViewHolder paramSingleCheckMarkViewHolder, a parama, int paramInt)
  {
    j.e(paramSingleCheckMarkViewHolder, "holder");
    j.e(parama, "data");
    paramSingleCheckMarkViewHolder.d().setText(parama.a());
  }
  
  public final void C(EnumGuardModeAlarmVolume paramEnumGuardModeAlarmVolume)
  {
    j.e(paramEnumGuardModeAlarmVolume, "volume");
    Iterator localIterator = g.iterator();
    int i = 0;
    for (int j = 0; localIterator.hasNext(); j++)
    {
      int k;
      if (((a)localIterator.next()).b() == paramEnumGuardModeAlarmVolume) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0) {
        break label71;
      }
    }
    j = -1;
    label71:
    paramEnumGuardModeAlarmVolume = Integer.valueOf(j);
    j = i;
    if (paramEnumGuardModeAlarmVolume.intValue() != -1) {
      j = 1;
    }
    if (j == 0) {
      paramEnumGuardModeAlarmVolume = null;
    }
    if (paramEnumGuardModeAlarmVolume != null) {
      z(paramEnumGuardModeAlarmVolume.intValue());
    }
  }
  
  public static final class a
  {
    private final int a;
    private final EnumGuardModeAlarmVolume b;
    
    public a(int paramInt, EnumGuardModeAlarmVolume paramEnumGuardModeAlarmVolume)
    {
      this.a = paramInt;
      this.b = paramEnumGuardModeAlarmVolume;
    }
    
    public final int a()
    {
      return this.a;
    }
    
    public final EnumGuardModeAlarmVolume b()
    {
      return this.b;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this != paramObject) {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.a == ((a)paramObject).a) && (j.a(this.b, ((a)paramObject).b))) {}
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    
    public int hashCode()
    {
      int i = this.a;
      EnumGuardModeAlarmVolume localEnumGuardModeAlarmVolume = this.b;
      int j;
      if (localEnumGuardModeAlarmVolume != null) {
        j = localEnumGuardModeAlarmVolume.hashCode();
      } else {
        j = 0;
      }
      return i * 31 + j;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AlarmVolume(titleRes=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", volume=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  public static final class b
  {
    public final int a(EnumGuardModeAlarmVolume paramEnumGuardModeAlarmVolume)
    {
      j.e(paramEnumGuardModeAlarmVolume, "volume");
      Iterator localIterator = GuardModeAlarmVolumeAdapter.A().iterator();
      int i;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (((GuardModeAlarmVolumeAdapter.a)localObject).b() == paramEnumGuardModeAlarmVolume) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          paramEnumGuardModeAlarmVolume = (EnumGuardModeAlarmVolume)localObject;
          break label63;
        }
      }
      paramEnumGuardModeAlarmVolume = null;
      label63:
      paramEnumGuardModeAlarmVolume = (GuardModeAlarmVolumeAdapter.a)paramEnumGuardModeAlarmVolume;
      if (paramEnumGuardModeAlarmVolume != null) {
        i = paramEnumGuardModeAlarmVolume.a();
      } else {
        i = 2131954447;
      }
      return i;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iothub\GuardModeAlarmVolumeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */