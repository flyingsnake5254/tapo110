package com.tplink.iot.adapter.iotbulb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;

public class BrightnessPresetAdapter
  extends RecyclerView.Adapter
{
  private List<Integer> a = new ArrayList();
  private f b;
  
  public int getItemCount()
  {
    return this.a.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      paramInt = 2131559048;
    } else {
      paramInt = 2131559047;
    }
    return paramInt;
  }
  
  public void o(int paramInt)
  {
    if (this.a.size() >= 5) {
      return;
    }
    this.a.add(Integer.valueOf(paramInt));
    notifyDataSetChanged();
    f localf = this.b;
    if (localf != null) {
      localf.z(this.a.size());
    }
  }
  
  public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    Object localObject;
    if ((paramViewHolder instanceof e))
    {
      paramViewHolder = (e)paramViewHolder;
      Integer localInteger = (Integer)this.a.get(paramInt);
      paramViewHolder.c.setProgress(localInteger.intValue());
      paramViewHolder.b.setOnClickListener(new a(paramInt));
      localObject = paramViewHolder.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localInteger);
      localStringBuilder.append("%");
      ((TextView)localObject).setText(localStringBuilder.toString());
      paramViewHolder.c.setOnSeekBarChangeListener(new b(paramViewHolder, paramInt));
    }
    else if ((paramViewHolder instanceof d))
    {
      localObject = paramViewHolder.itemView;
      if (this.a.size() == 5) {
        paramInt = 8;
      } else {
        paramInt = 0;
      }
      ((View)localObject).setVisibility(paramInt);
      paramViewHolder.itemView.setOnClickListener(new c());
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2131559047) {
      return new e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559047, paramViewGroup, false));
    }
    return new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559048, paramViewGroup, false));
  }
  
  public int p()
  {
    return this.a.size();
  }
  
  public List<Integer> q()
  {
    return this.a;
  }
  
  public void r(List<Integer> paramList)
  {
    this.a.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.a.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void s(f paramf)
  {
    this.b = paramf;
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      BrightnessPresetAdapter.m(BrightnessPresetAdapter.this).remove(paramInt);
      BrightnessPresetAdapter.this.notifyDataSetChanged();
      if (BrightnessPresetAdapter.n(BrightnessPresetAdapter.this) != null) {
        BrightnessPresetAdapter.n(BrightnessPresetAdapter.this).z(BrightnessPresetAdapter.m(BrightnessPresetAdapter.this).size());
      }
    }
  }
  
  class b
    implements SeekBar.OnSeekBarChangeListener
  {
    b(BrightnessPresetAdapter.e parame, int paramInt) {}
    
    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      int i = paramInt;
      if (paramInt < 1)
      {
        paramSeekBar.setProgress(1);
        i = 1;
      }
      paramSeekBar = paramViewHolder.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("%");
      paramSeekBar.setText(localStringBuilder.toString());
      BrightnessPresetAdapter.m(BrightnessPresetAdapter.this).set(paramInt, Integer.valueOf(i));
    }
    
    public void onStartTrackingTouch(SeekBar paramSeekBar) {}
    
    public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      BrightnessPresetAdapter.this.o(50);
    }
  }
  
  class d
    extends RecyclerView.ViewHolder
  {
    public d(View paramView)
    {
      super();
    }
  }
  
  class e
    extends RecyclerView.ViewHolder
  {
    TextView a;
    ImageView b;
    AppCompatSeekBar c;
    
    public e(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364586));
      this.b = ((ImageView)paramView.findViewById(2131363024));
      this.c = ((AppCompatSeekBar)paramView.findViewById(2131364008));
    }
  }
  
  public static abstract interface f
  {
    public abstract void z(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iotbulb\BrightnessPresetAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */