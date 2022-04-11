package com.tplink.iot.adapter.iot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.Utils.z0.q;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.model.iot.d;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHubAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumTRVAvatarType;
import java.util.List;

public class IoTSettingAvatarAdapter
  extends RecyclerView.Adapter<c>
{
  private List<d> a;
  private int b;
  private d c;
  private EnumDeviceType d;
  private String e;
  
  public IoTSettingAvatarAdapter(List<d> paramList, EnumDeviceType paramEnumDeviceType, String paramString)
  {
    this.a = paramList;
    this.d = paramEnumDeviceType;
    this.e = paramString;
  }
  
  public static int p(EnumDeviceType paramEnumDeviceType, String paramString1, String paramString2)
  {
    if (paramEnumDeviceType != null) {
      switch (b.a[paramEnumDeviceType.ordinal()])
      {
      default: 
        break;
      case 6: 
        return com.tplink.iot.g.d.a.b.h(EnumTRVAvatarType.fromString(paramString1));
      case 5: 
        return com.tplink.iot.g.c.a.b.c(EnumSwitchAvatarType.fromString(paramString1), paramString2);
      case 4: 
        return r.g(paramString1, paramString2);
      case 3: 
        return p.f(EnumHubAvatarType.fromString(paramString1));
      case 2: 
        if (c.i(paramString2)) {
          return c.d(EnumLightStripAvatarType.fromString(paramString1));
        }
        return g.e(EnumBulbAvatarType.fromString(paramString1));
      case 1: 
        return q.i(EnumIoTAvatarType.fromString(paramString1));
      }
    }
    return q.i(EnumIoTAvatarType.fromString(paramString1));
  }
  
  private void t(int paramInt)
  {
    for (int i = 0; i < getItemCount(); i++) {
      ((d)this.a.get(i)).c(false);
    }
    ((d)this.a.get(paramInt)).c(true);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public String q()
  {
    return ((d)this.a.get(this.b)).a();
  }
  
  public void r(@NonNull c paramc, final int paramInt)
  {
    d locald = (d)this.a.get(paramInt);
    c.c(paramc).setImageResource(p(this.d, locald.a(), this.e));
    if (locald.b())
    {
      c.d(paramc).setVisibility(0);
      this.b = paramInt;
    }
    else
    {
      c.d(paramc).setVisibility(8);
    }
    paramc.itemView.setOnClickListener(new a(paramInt));
  }
  
  @NonNull
  public c s(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559080, paramViewGroup, false));
  }
  
  public void u(d paramd)
  {
    this.c = paramd;
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      IoTSettingAvatarAdapter.m(IoTSettingAvatarAdapter.this, paramInt);
      IoTSettingAvatarAdapter.n(IoTSettingAvatarAdapter.this, paramInt);
      if (IoTSettingAvatarAdapter.o(IoTSettingAvatarAdapter.this) != null) {
        IoTSettingAvatarAdapter.o(IoTSettingAvatarAdapter.this).e(paramInt);
      }
    }
  }
  
  class c
    extends RecyclerView.ViewHolder
  {
    private ImageView a;
    private ImageView b;
    
    public c(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362999));
      this.b = ((ImageView)paramView.findViewById(2131363118));
    }
  }
  
  public static abstract interface d
  {
    public abstract void e(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iot\IoTSettingAvatarAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */