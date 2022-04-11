package com.tplink.iot.adapter.quicksetup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.adapter.iot.IoTSettingAvatarAdapter;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import java.util.Iterator;
import java.util.List;

public class IoTIconAdapter
  extends RecyclerView.Adapter<b>
{
  private List<e> a;
  private EnumDeviceType b;
  private int c = 0;
  private String d;
  
  public IoTIconAdapter(List<e> paramList, EnumDeviceType paramEnumDeviceType)
  {
    this.a = paramList;
    this.b = paramEnumDeviceType;
  }
  
  public IoTIconAdapter(List<e> paramList, EnumDeviceType paramEnumDeviceType, String paramString)
  {
    this.a = paramList;
    this.b = paramEnumDeviceType;
    this.d = paramString;
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
  
  public String o()
  {
    int i = this.c;
    if ((i >= 0) && (i < this.a.size())) {
      return ((e)this.a.get(this.c)).a();
    }
    return EnumIoTAvatarType.PLUG.getName();
  }
  
  public void p(@NonNull b paramb, final int paramInt)
  {
    final e locale = (e)this.a.get(paramInt);
    if (locale.b())
    {
      this.c = paramInt;
      paramb.b.setVisibility(0);
    }
    else
    {
      paramb.b.setVisibility(8);
    }
    paramb.a.setImageResource(IoTSettingAvatarAdapter.p(this.b, locale.a(), this.d));
    paramb.itemView.setOnClickListener(new a(locale, paramInt));
  }
  
  @NonNull
  public b q(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559201, paramViewGroup, false));
  }
  
  public void r(int paramInt)
  {
    if ((paramInt != this.c) && (paramInt >= 0) && (paramInt < getItemCount()))
    {
      int i = this.c;
      ((e)this.a.get(i)).d(false);
      ((e)this.a.get(paramInt)).d(true);
      notifyItemChanged(i);
      notifyItemChanged(paramInt);
      this.c = paramInt;
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a(e parame, int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (!locale.b())
      {
        IoTIconAdapter.m(IoTIconAdapter.this, paramInt);
        paramView = IoTIconAdapter.n(IoTIconAdapter.this).iterator();
        while (paramView.hasNext()) {
          ((e)paramView.next()).d(false);
        }
        locale.d(true);
        IoTIconAdapter.this.notifyDataSetChanged();
      }
    }
  }
  
  static class b
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    View b;
    
    b(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362797));
      this.b = paramView.findViewById(2131364009);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\IoTIconAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */