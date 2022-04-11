package com.tplink.iot.adapter.iotplug;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.adapter.quicksetup.SelectLocationBean;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import java.util.List;

public class PlugSettingLocationAdapter
  extends RecyclerView.Adapter<b>
{
  private List<SelectLocationBean> a;
  private c b;
  private String c;
  
  public PlugSettingLocationAdapter(List<SelectLocationBean> paramList)
  {
    this.a = paramList;
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
  
  public String n()
  {
    return this.c;
  }
  
  public void o(@NonNull b paramb, final int paramInt)
  {
    SelectLocationBean localSelectLocationBean = (SelectLocationBean)this.a.get(paramInt);
    b.c(paramb).setText(EnumDeviceNicknameType.fromType(localSelectLocationBean.getLocation()));
    b.d(paramb).setSelected(localSelectLocationBean.isSelect());
    if ((paramInt == getItemCount() - 1) && (localSelectLocationBean.isSelect()) && (!TextUtils.isEmpty(this.c)))
    {
      b.e(paramb).setVisibility(0);
      b.e(paramb).setText(this.c);
    }
    else
    {
      b.e(paramb).setVisibility(8);
      b.e(paramb).setText("");
    }
    paramb.itemView.setOnClickListener(new a(paramInt));
  }
  
  @NonNull
  public b p(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559081, paramViewGroup, false));
  }
  
  public void q(int paramInt)
  {
    for (int i = 0; i < getItemCount(); i++) {
      ((SelectLocationBean)this.a.get(i)).setSelect(false);
    }
    ((SelectLocationBean)this.a.get(paramInt)).setSelect(true);
    notifyDataSetChanged();
  }
  
  public void r(String paramString)
  {
    this.c = paramString;
  }
  
  public void s(c paramc)
  {
    this.b = paramc;
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (PlugSettingLocationAdapter.m(PlugSettingLocationAdapter.this) != null) {
        PlugSettingLocationAdapter.m(PlugSettingLocationAdapter.this).r0(this, paramInt);
      }
    }
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    private TextView a;
    private TextView b;
    private ImageView c;
    
    public b(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364515));
      this.b = ((TextView)paramView.findViewById(2131364516));
      this.c = ((ImageView)paramView.findViewById(2131362208));
    }
  }
  
  public static abstract interface c
  {
    public abstract void r0(View.OnClickListener paramOnClickListener, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iotplug\PlugSettingLocationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */