package com.tplink.libtpcontrols.horizontalpageview;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import java.util.ArrayList;
import java.util.List;

public class TPHorizontalRecycleAdapter
  extends RecyclerView.Adapter<ViewHolder>
{
  private Context a;
  private List<String> b = new ArrayList();
  private List<String> c = new ArrayList();
  private a d = null;
  
  public TPHorizontalRecycleAdapter(Context paramContext, List<String> paramList1, List<String> paramList2)
  {
    this.a = paramContext;
    this.b.clear();
    this.c.clear();
    this.b.addAll(paramList1);
    this.c.addAll(paramList2);
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
  
  public void o(@NonNull ViewHolder paramViewHolder, int paramInt)
  {
    String str1 = (String)this.b.get(paramInt);
    String str2 = (String)this.c.get(paramInt);
    paramViewHolder.b.setOnClickListener(new c(this, paramInt));
    paramViewHolder.c.setText(str1);
    paramViewHolder.d.setImageResource(this.a.getResources().getIdentifier(str2, "mipmap", this.a.getPackageName()));
  }
  
  @NonNull
  public ViewHolder p(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(t0.location_recyclew_adapter, paramViewGroup, false);
    GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = (paramViewGroup.getWidth() / 4);
    localLayoutParams.height = (paramViewGroup.getHeight() / 2);
    localView.setLayoutParams(localLayoutParams);
    return new ViewHolder(localView);
  }
  
  public void q(a parama)
  {
    this.d = parama;
  }
  
  public static class ViewHolder
    extends RecyclerView.ViewHolder
  {
    public View a;
    public LinearLayout b;
    public TextView c;
    public ImageView d;
    
    public ViewHolder(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((LinearLayout)paramView.findViewById(s0.layout));
      this.c = ((TextView)paramView.findViewById(s0.tv_name));
      this.d = ((ImageView)paramView.findViewById(s0.image));
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\horizontalpageview\TPHorizontalRecycleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */