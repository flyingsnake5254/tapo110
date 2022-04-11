package com.tplink.iot.adapter.deviceshare;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.l0;
import com.tplink.iot.Utils.l0.d;
import com.tplink.libtpcontrols.TPCircleMaskView;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import java.util.ArrayList;
import java.util.List;

public class DeviceShareUserAdapter
  extends RecyclerView.Adapter
{
  private Activity a;
  private List<TCDeviceUserInfoBean> b;
  private d c;
  
  public DeviceShareUserAdapter(Activity paramActivity, List<TCDeviceUserInfoBean> paramList)
  {
    this.a = paramActivity;
    this.b = paramList;
  }
  
  private void p(View paramView, final int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(this.a.getString(2131952401).toUpperCase());
    localObject = new l0(this.a, (List)localObject);
    ((PopupWindow)localObject).setAnimationStyle(2132018155);
    ((l0)localObject).g(this.a.getResources().getColor(2131099744));
    ((l0)localObject).f(new c(paramInt));
    ((l0)localObject).i(paramView);
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int i;
    if ((localList != null) && (!localList.isEmpty())) {
      i = this.b.size() + 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    List localList = this.b;
    int i = 1;
    int j = i;
    if (localList != null) {
      if (localList.isEmpty()) {
        j = i;
      } else if (paramInt < this.b.size()) {
        j = i;
      } else {
        j = 2;
      }
    }
    return j;
  }
  
  public void o(d paramd)
  {
    this.c = paramd;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    paramViewHolder = (e)paramViewHolder;
    if (getItemViewType(paramInt) == 1)
    {
      TCDeviceUserInfoBean localTCDeviceUserInfoBean = (TCDeviceUserInfoBean)this.b.get(paramInt);
      paramViewHolder.d.g(localTCDeviceUserInfoBean.getAvatarUrl(), 2131689624);
      paramViewHolder.a.setText(com.tplink.iot.view.deviceshare.a.c(localTCDeviceUserInfoBean));
      TextView localTextView = paramViewHolder.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(com.tplink.iot.view.iotplug.c.a.b(localTCDeviceUserInfoBean.getBindingTime()));
      localStringBuilder.append(" ");
      localStringBuilder.append(this.a.getString(2131951624));
      localTextView.setText(localStringBuilder.toString());
      paramViewHolder.itemView.setOnClickListener(new a(paramInt));
      paramViewHolder.itemView.setOnLongClickListener(new b(paramInt));
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      paramViewGroup = LayoutInflater.from(this.a).inflate(2131559144, paramViewGroup, false);
    } else {
      paramViewGroup = LayoutInflater.from(this.a).inflate(2131559145, paramViewGroup, false);
    }
    return new e(paramViewGroup);
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (DeviceShareUserAdapter.m(DeviceShareUserAdapter.this) != null) {
        DeviceShareUserAdapter.m(DeviceShareUserAdapter.this).a(paramView, paramInt);
      }
    }
  }
  
  class b
    implements View.OnLongClickListener
  {
    b(int paramInt) {}
    
    public boolean onLongClick(View paramView)
    {
      DeviceShareUserAdapter.n(DeviceShareUserAdapter.this, paramView, paramInt);
      return true;
    }
  }
  
  class c
    implements l0.d
  {
    c(int paramInt) {}
    
    public void a(View paramView, int paramInt)
    {
      if (DeviceShareUserAdapter.m(DeviceShareUserAdapter.this) != null) {
        DeviceShareUserAdapter.m(DeviceShareUserAdapter.this).b(paramView, paramInt);
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(View paramView, int paramInt);
    
    public abstract void b(View paramView, int paramInt);
  }
  
  private class e
    extends RecyclerView.ViewHolder
  {
    TextView a;
    TextView b;
    TextView c;
    TPCircleMaskView d;
    
    e(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364536));
      this.b = ((TextView)paramView.findViewById(2131364515));
      this.c = ((TextView)paramView.findViewById(2131364573));
      this.d = ((TPCircleMaskView)paramView.findViewById(2131362837));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\deviceshare\DeviceShareUserAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */