package com.tplink.iot.view.ipcamera.widget.scollitem;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.viewmodel.ipcamera.play.VodPlayRate;
import java.util.List;

public class ScrollPlayRateAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<VodPlayRate> a;
  private Context b;
  private int c = -1;
  private b d;
  
  public ScrollPlayRateAdapter(Context paramContext, List<VodPlayRate> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    return i;
  }
  
  public void o()
  {
    this.c = -1;
    notifyDataSetChanged();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = (a)paramViewHolder;
    Object localObject = this.a;
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (VodPlayRate)this.a.get(paramInt);
      paramViewHolder.a.setTag(Integer.valueOf(paramInt));
      paramViewHolder.a.setText(((VodPlayRate)localObject).getDisplayValue());
      if (this.c == paramInt) {
        paramViewHolder.a.setTextColor(this.b.getResources().getColor(2131099808));
      } else {
        paramViewHolder.a.setTextColor(this.b.getResources().getColor(2131099862));
      }
      paramViewHolder.a.setOnClickListener(new a(this));
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.b).inflate(2131559066, paramViewGroup, false));
  }
  
  public void p(b paramb)
  {
    this.d = paramb;
  }
  
  public void q(int paramInt)
  {
    List localList = this.a;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size()))
    {
      this.c = paramInt;
      notifyDataSetChanged();
    }
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    TextView a;
    
    public a(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131363747));
    }
  }
  
  public static abstract interface b
  {
    public abstract void e(VodPlayRate paramVodPlayRate);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\scollitem\ScrollPlayRateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */