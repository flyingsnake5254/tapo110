package com.tplink.libtpcontrols.horizontalscrollpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import java.util.List;

public class SimpleAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<?> b;
  
  public SimpleAdapter(Context paramContext, List<?> paramList)
  {
    this.a = paramContext;
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
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    a locala = (a)paramViewHolder;
    if ((paramInt >= 0) && (paramInt < this.b.size()) && ((this.b.get(paramInt) instanceof String)))
    {
      paramViewHolder = (String)this.b.get(paramInt);
      locala.b.setText(paramViewHolder);
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.a).inflate(t0.page_recycle_select_item, paramViewGroup, false));
  }
  
  static class a
    extends RecyclerView.ViewHolder
  {
    public View a;
    public TextView b;
    
    public a(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(s0.text));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\horizontalscrollpage\SimpleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */