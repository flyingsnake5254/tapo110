package com.tplink.iot.adapter.playback;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordTypeAdapter
  extends RecyclerView.Adapter
{
  private List<Integer> a;
  private Context b;
  
  public RecordTypeAdapter(Context paramContext)
  {
    this.b = paramContext;
    this.a = new ArrayList();
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public void n(List<Integer> paramList)
  {
    this.a.clear();
    if (!s.b(paramList)) {
      this.a.addAll(paramList);
    }
    Collections.sort(this.a);
    notifyDataSetChanged();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((a)paramViewHolder).c((Integer)this.a.get(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.b).inflate(2131559067, paramViewGroup, false));
  }
  
  private class a
    extends RecyclerView.ViewHolder
  {
    View a;
    ImageView b;
    TextView c;
    
    a(View paramView)
    {
      super();
      this.a = paramView.findViewById(2131362006);
      this.b = ((ImageView)paramView.findViewById(2131363105));
      this.c = ((TextView)paramView.findViewById(2131364591));
    }
    
    private void d(int paramInt)
    {
      this.a.setBackgroundResource(2131231304);
      this.a.getBackground().setLevel(paramInt);
      int i = 2131953367;
      int j = 2131231264;
      int k = 2131100206;
      switch (paramInt)
      {
      default: 
        paramInt = i;
        break;
      case 7: 
        j = 2131231263;
        paramInt = 2131951870;
        break;
      case 6: 
        j = 2131231267;
        paramInt = 2131954247;
        break;
      case 5: 
        j = 2131231262;
        paramInt = 2131953803;
        break;
      case 4: 
        j = 2131231265;
        paramInt = 2131953830;
        break;
      case 3: 
        j = 2131231268;
        paramInt = 2131953881;
        break;
      case 2: 
        j = 2131231266;
        paramInt = 2131953357;
        break;
      case 1: 
        k = 2131099729;
        paramInt = i;
      }
      this.b.setImageResource(j);
      this.c.setText(RecordTypeAdapter.m(RecordTypeAdapter.this).getString(paramInt));
      this.c.setTextColor(RecordTypeAdapter.m(RecordTypeAdapter.this).getResources().getColor(k));
    }
    
    public void c(Integer paramInteger)
    {
      d(paramInteger.intValue());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\playback\RecordTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */