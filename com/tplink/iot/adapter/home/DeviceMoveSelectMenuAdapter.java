package com.tplink.iot.adapter.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.Iterator;
import java.util.List;

public class DeviceMoveSelectMenuAdapter
  extends RecyclerView.Adapter
{
  private Activity a;
  private List<HomeFamilySelectBean> b;
  private b c;
  
  public DeviceMoveSelectMenuAdapter(Activity paramActivity, List<HomeFamilySelectBean> paramList)
  {
    this.a = paramActivity;
    this.b = paramList;
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public void o(b paramb)
  {
    this.c = paramb;
  }
  
  public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    c localc = (c)paramViewHolder;
    paramViewHolder = (HomeFamilySelectBean)this.b.get(paramInt);
    localc.a.setText(paramViewHolder.getFamilyName());
    ImageView localImageView = localc.b;
    int i;
    if (paramViewHolder.isSelected()) {
      i = 2131689728;
    } else {
      i = 2131689727;
    }
    localImageView.setImageResource(i);
    localc.itemView.setOnClickListener(new a(paramViewHolder, paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new c(LayoutInflater.from(this.a).inflate(2131558768, paramViewGroup, false));
  }
  
  class a
    implements View.OnClickListener
  {
    a(HomeFamilySelectBean paramHomeFamilySelectBean, int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (!paramViewHolder.isSelected())
      {
        Iterator localIterator = DeviceMoveSelectMenuAdapter.m(DeviceMoveSelectMenuAdapter.this).iterator();
        while (localIterator.hasNext()) {
          ((HomeFamilySelectBean)localIterator.next()).setSelected(false);
        }
        ((HomeFamilySelectBean)DeviceMoveSelectMenuAdapter.m(DeviceMoveSelectMenuAdapter.this).get(paramInt)).setSelected(true);
        DeviceMoveSelectMenuAdapter.this.notifyDataSetChanged();
        if (DeviceMoveSelectMenuAdapter.n(DeviceMoveSelectMenuAdapter.this) != null) {
          DeviceMoveSelectMenuAdapter.n(DeviceMoveSelectMenuAdapter.this).a(paramView, paramInt);
        }
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
    ImageView b;
    TextView c;
    
    c(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364457));
      this.b = ((ImageView)paramView.findViewById(2131362835));
      this.c = ((TextView)paramView.findViewById(2131364625));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\DeviceMoveSelectMenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */