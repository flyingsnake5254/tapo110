package com.tplink.iot.adapter.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.model.home.c;
import java.util.ArrayList;
import java.util.List;

public class DeviceMoveAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<c> b;
  private b c;
  
  public DeviceMoveAdapter(Context paramContext)
  {
    this.a = paramContext;
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
  
  public void n(List<c> paramList)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.b.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void o(b paramb)
  {
    this.c = paramb;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    final c localc = (c)this.b.get(paramInt);
    paramViewHolder = (c)paramViewHolder;
    paramViewHolder.a.setText(localc.c());
    paramInt = localc.a();
    if (paramInt == 0) {
      paramViewHolder.b.setText(this.a.getResources().getString(2131953206));
    } else {
      paramViewHolder.b.setText(this.a.getResources().getQuantityString(2131820544, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    }
    paramViewHolder.itemView.setOnClickListener(new a(localc));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new c(LayoutInflater.from(this.a).inflate(2131559021, paramViewGroup, false));
  }
  
  class a
    implements View.OnClickListener
  {
    a(c paramc) {}
    
    public void onClick(View paramView)
    {
      if (DeviceMoveAdapter.m(DeviceMoveAdapter.this) != null) {
        DeviceMoveAdapter.m(DeviceMoveAdapter.this).Z(localc);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void Z(c paramc);
  }
  
  class c
    extends RecyclerView.ViewHolder
  {
    TextView a;
    TextView b;
    
    public c(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364610));
      this.b = ((TextView)paramView.findViewById(2131364611));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\DeviceMoveAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */