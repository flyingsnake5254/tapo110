package com.tplink.iot.adapter.quicksetup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.view.quicksetup.base.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoBean;
import java.util.List;

public class PlugScanAPListAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<WirelessScanInfoBean> b;
  private f c;
  
  public PlugScanAPListAdapter(Context paramContext, List<WirelessScanInfoBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private boolean n(int paramInt)
  {
    List localList = this.b;
    boolean bool = true;
    if (localList == null) {
      return true;
    }
    if (paramInt < localList.size()) {
      bool = false;
    }
    return bool;
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int i = 1;
    if (localList != null) {
      i = 1 + localList.size();
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (n(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public void o(f paramf)
  {
    this.c = paramf;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    paramViewHolder = (c)paramViewHolder;
    if (!n(paramInt))
    {
      WirelessScanInfoBean localWirelessScanInfoBean = (WirelessScanInfoBean)this.b.get(paramInt);
      paramViewHolder.a.setText(localWirelessScanInfoBean.getSsid());
      boolean bool = "wep".equalsIgnoreCase(localWirelessScanInfoBean.getKeyType());
      int i = 0;
      if (bool)
      {
        paramViewHolder.b.setVisibility(4);
        paramViewHolder.c.setImageResource(2131690448);
        paramViewHolder.itemView.setAlpha(0.6F);
        paramViewHolder.itemView.setClickable(false);
      }
      else
      {
        ImageView localImageView = paramViewHolder.b;
        if ("none".equalsIgnoreCase(localWirelessScanInfoBean.getKeyType())) {
          i = 4;
        }
        localImageView.setVisibility(i);
        paramViewHolder.c.setImageResource(c.j0(localWirelessScanInfoBean.getSignalLevel()));
        paramViewHolder.itemView.setAlpha(1.0F);
        paramViewHolder.itemView.setClickable(true);
        paramViewHolder.itemView.setOnClickListener(new a(paramInt));
      }
    }
    else
    {
      paramViewHolder.itemView.setAlpha(1.0F);
      paramViewHolder.itemView.setClickable(true);
      paramViewHolder.itemView.setOnClickListener(new b(paramInt));
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      paramViewGroup = LayoutInflater.from(this.a).inflate(2131559203, paramViewGroup, false);
    } else {
      paramViewGroup = LayoutInflater.from(this.a).inflate(2131559202, paramViewGroup, false);
    }
    return new c(paramViewGroup);
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (PlugScanAPListAdapter.m(PlugScanAPListAdapter.this) != null) {
        PlugScanAPListAdapter.m(PlugScanAPListAdapter.this).a(paramView, paramInt);
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (PlugScanAPListAdapter.m(PlugScanAPListAdapter.this) != null) {
        PlugScanAPListAdapter.m(PlugScanAPListAdapter.this).a(paramView, paramInt);
      }
    }
  }
  
  private class c
    extends RecyclerView.ViewHolder
  {
    TextView a;
    ImageView b;
    ImageView c;
    
    c(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364322));
      this.b = ((ImageView)paramView.findViewById(2131362850));
      this.c = ((ImageView)paramView.findViewById(2131362848));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\PlugScanAPListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */