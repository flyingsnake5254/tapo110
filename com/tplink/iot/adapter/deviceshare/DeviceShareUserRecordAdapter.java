package com.tplink.iot.adapter.deviceshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.view.deviceshare.a;
import com.tplink.libtpcontrols.TPCircleMaskView;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import java.util.List;

public class DeviceShareUserRecordAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<TCDeviceUserInfoBean> b;
  private b c;
  
  public DeviceShareUserRecordAdapter(Context paramContext, List<TCDeviceUserInfoBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int i;
    if ((localList != null) && (!localList.isEmpty())) {
      i = this.b.size();
    } else {
      i = 0;
    }
    return i;
  }
  
  public void n(b paramb)
  {
    this.c = paramb;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    c localc = (c)paramViewHolder;
    paramViewHolder = (TCDeviceUserInfoBean)this.b.get(paramInt);
    localc.d.g(paramViewHolder.getAvatarUrl(), 2131689624);
    localc.a.setText(a.c(paramViewHolder));
    localc.b.setText(paramViewHolder.getCloudUserName());
    localc.itemView.setOnClickListener(new a(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new c(LayoutInflater.from(this.a).inflate(2131559144, paramViewGroup, false));
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (DeviceShareUserRecordAdapter.m(DeviceShareUserRecordAdapter.this) != null) {
        DeviceShareUserRecordAdapter.m(DeviceShareUserRecordAdapter.this).a(paramView, paramInt);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt);
  }
  
  private class c
    extends RecyclerView.ViewHolder
  {
    TextView a;
    TextView b;
    TextView c;
    TPCircleMaskView d;
    
    c(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364536));
      this.b = ((TextView)paramView.findViewById(2131364515));
      this.c = ((TextView)paramView.findViewById(2131364573));
      this.d = ((TPCircleMaskView)paramView.findViewById(2131362837));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\deviceshare\DeviceShareUserRecordAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */