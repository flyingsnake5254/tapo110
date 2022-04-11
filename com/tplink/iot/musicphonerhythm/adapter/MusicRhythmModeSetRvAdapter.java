package com.tplink.iot.musicphonerhythm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;

public class MusicRhythmModeSetRvAdapter
  extends RecyclerView.Adapter<ViewHolder>
{
  private LayoutInflater a;
  private ArrayList<String> b;
  private int c = -1;
  private b d;
  
  public MusicRhythmModeSetRvAdapter(Context paramContext, ArrayList<String> paramArrayList, int paramInt, b paramb)
  {
    this.a = LayoutInflater.from(paramContext);
    this.b = paramArrayList;
    this.c = paramInt;
    this.d = paramb;
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public void o(ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.a.setText((CharSequence)this.b.get(paramInt));
    if (paramViewHolder.getAdapterPosition() == this.c) {
      paramViewHolder.b.setVisibility(0);
    } else {
      paramViewHolder.b.setVisibility(8);
    }
    paramViewHolder.itemView.setTag(Integer.valueOf(paramInt));
  }
  
  public ViewHolder p(final ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.a.inflate(2131559304, paramViewGroup, false);
    final ViewHolder localViewHolder = new ViewHolder(paramViewGroup);
    paramViewGroup.setOnClickListener(new a(localViewHolder, paramViewGroup));
    return localViewHolder;
  }
  
  public static class ViewHolder
    extends RecyclerView.ViewHolder
  {
    public TextView a;
    public ImageView b;
    
    public ViewHolder(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131363523));
      this.b = ((ImageView)paramView.findViewById(2131363511));
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a(MusicRhythmModeSetRvAdapter.ViewHolder paramViewHolder, View paramView) {}
    
    public void onClick(View paramView)
    {
      MusicRhythmModeSetRvAdapter.m(MusicRhythmModeSetRvAdapter.this, localViewHolder.getAdapterPosition());
      MusicRhythmModeSetRvAdapter.this.notifyDataSetChanged();
      if (MusicRhythmModeSetRvAdapter.n(MusicRhythmModeSetRvAdapter.this) != null)
      {
        paramView = MusicRhythmModeSetRvAdapter.n(MusicRhythmModeSetRvAdapter.this);
        View localView = paramViewGroup;
        paramView.a(localView, ((Integer)localView.getTag()).intValue());
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\adapter\MusicRhythmModeSetRvAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */