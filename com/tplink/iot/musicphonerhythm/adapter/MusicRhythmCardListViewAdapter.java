package com.tplink.iot.musicphonerhythm.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.d.a;
import com.airbnb.lottie.j;
import com.airbnb.lottie.k;
import com.airbnb.lottie.w.b;
import com.airbnb.lottie.w.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MusicRhythmCardListViewAdapter
  extends RecyclerView.Adapter<ViewHolder>
{
  private LayoutInflater a;
  private ArrayList<String> b;
  
  public MusicRhythmCardListViewAdapter(Context paramContext, ArrayList<String> paramArrayList)
  {
    this.a = LayoutInflater.from(paramContext);
    this.b = paramArrayList;
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public void m(ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.d((String)this.b.get(paramInt));
    paramViewHolder.a.n();
  }
  
  public ViewHolder n(ViewGroup paramViewGroup, int paramInt)
  {
    LayoutInflater.from(paramViewGroup.getContext());
    return new ViewHolder(this.a.inflate(2131559060, paramViewGroup, false));
  }
  
  public void o(ArrayList<String> paramArrayList)
  {
    this.b.clear();
    this.b.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
  
  public static class ViewHolder
    extends RecyclerView.ViewHolder
  {
    public LottieAnimationView a;
    
    public ViewHolder(View paramView)
    {
      super();
      this.a = ((LottieAnimationView)paramView.findViewById(2131363388));
    }
    
    private String c(String paramString)
    {
      paramString.hashCode();
      int i = paramString.hashCode();
      int j = -1;
      switch (i)
      {
      default: 
        break;
      case 440747165: 
        if (paramString.equals("power_mode")) {
          j = 2;
        }
        break;
      case -208977225: 
        if (paramString.equals("light_flow")) {
          j = 1;
        }
        break;
      case -1731972241: 
        if (paramString.equals("single_lamp")) {
          j = 0;
        }
        break;
      }
      switch (j)
      {
      default: 
        return null;
      case 2: 
        return "music_rhythm_power_mode.json";
      case 1: 
        return "music_rhythm_flowing_beam_mode.json";
      }
      return "music_rhythm_single_lamp_mode.json";
    }
    
    public void d(String paramString)
    {
      try
      {
        this.a.setImageAssetsFolder("images/");
        paramString = c(paramString);
        paramString = d.a.a(this.a.getContext(), paramString);
        this.a.g();
        this.a.setProgress(0.0F);
        if (paramString != null) {
          this.a.setComposition(paramString);
        }
        this.a.o();
        this.a.setVisibility(0);
        LottieAnimationView localLottieAnimationView = this.a;
        paramString = new com/tplink/iot/musicphonerhythm/adapter/MusicRhythmCardListViewAdapter$ViewHolder$a;
        paramString.<init>(this);
        localLottieAnimationView.d(paramString);
      }
      catch (Exception paramString)
      {
        Log.e("lottie", "load local lottie anim error");
      }
    }
    
    class a
      implements j
    {
      a() {}
      
      @SuppressLint({"RestrictedApi"})
      public void a(com.airbnb.lottie.d paramd)
      {
        Iterator localIterator = MusicRhythmCardListViewAdapter.ViewHolder.this.a.p(new com.airbnb.lottie.model.d(new String[] { "**" })).iterator();
        while (localIterator.hasNext())
        {
          paramd = (com.airbnb.lottie.model.d)localIterator.next();
          if ((!paramd.h("矩形备份 2", 1)) && (!paramd.h("矩形备份 5", 1)) && (!paramd.h("矩形备份 8", 1)) && (!paramd.h("矩形备份 11", 1)) && (!paramd.h("矩形备份 14", 1)) && (!paramd.h("矩形备份 17", 1)) && (!paramd.h("矩形备份 20", 1)))
          {
            if ((!paramd.h("矩形备份 3", 1)) && (!paramd.h("矩形备份 6", 1)) && (!paramd.h("矩形备份 9", 1)) && (!paramd.h("矩形备份 12", 1)) && (!paramd.h("矩形备份 15", 1)) && (!paramd.h("矩形备份 18", 1)) && (!paramd.h("矩形备份 21", 1)))
            {
              if ((!paramd.h("矩形备份 4", 1)) && (!paramd.h("矩形备份 7", 1)) && (!paramd.h("矩形备份 10", 1)) && (!paramd.h("矩形备份 13", 1)) && (!paramd.h("矩形备份 16", 1)) && (!paramd.h("矩形备份 19", 1))) {
                MusicRhythmCardListViewAdapter.ViewHolder.this.a.f(paramd, k.D, new d());
              } else {
                MusicRhythmCardListViewAdapter.ViewHolder.this.a.f(paramd, k.D, new c());
              }
            }
            else {
              MusicRhythmCardListViewAdapter.ViewHolder.this.a.f(paramd, k.D, new b());
            }
          }
          else {
            MusicRhythmCardListViewAdapter.ViewHolder.this.a.f(paramd, k.D, new a());
          }
        }
      }
      
      class a
        implements e<Integer[]>
      {
        a() {}
        
        public Integer[] b(b<Integer[]> paramb)
        {
          return new Integer[] { Integer.valueOf(Color.argb(153, 219, 27, 255)), Integer.valueOf(Color.argb(255, 237, 139, 255)) };
        }
      }
      
      class b
        implements e<Integer[]>
      {
        b() {}
        
        public Integer[] b(b<Integer[]> paramb)
        {
          return new Integer[] { Integer.valueOf(Color.argb(127, 245, 151, 163)), Integer.valueOf(Color.argb(219, 250, 202, 208)) };
        }
      }
      
      class c
        implements e<Integer[]>
      {
        c() {}
        
        public Integer[] b(b<Integer[]> paramb)
        {
          return new Integer[] { Integer.valueOf(Color.argb(173, 62, 210, 242)), Integer.valueOf(Color.argb(255, 70, 224, 255)) };
        }
      }
      
      class d
        implements e<Integer[]>
      {
        d() {}
        
        public Integer[] b(b<Integer[]> paramb)
        {
          return new Integer[] { Integer.valueOf(Color.argb(173, 62, 210, 242)), Integer.valueOf(Color.argb(255, 70, 224, 255)) };
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\adapter\MusicRhythmCardListViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */