package com.tplink.iot.view.ipcamera.memories.filter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.g;
import com.tplink.iot.view.ipcamera.setting.z4;
import com.tplink.libtpmediaother.memory.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemoriesFilterAdapter
  extends RecyclerView.Adapter
{
  private List<p> a = new ArrayList();
  private Set<String> b = new HashSet();
  private Context c;
  
  public MemoriesFilterAdapter()
  {
    setHasStableIds(true);
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  void n()
  {
    this.b.clear();
    notifyDataSetChanged();
  }
  
  List<String> o()
  {
    return new ArrayList(this.b);
  }
  
  public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    p localp = (p)this.a.get(paramInt);
    paramViewHolder = (b)paramViewHolder;
    paramViewHolder.itemView.setTag(localp.a());
    paramViewHolder.itemView.setOnClickListener(new a(paramViewHolder));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(localp.a());
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = this.b.contains(localObject);
    localObject = paramViewHolder.d;
    if (bool) {
      paramInt = 2131689728;
    } else {
      paramInt = 2131689727;
    }
    ((ImageView)localObject).setImageResource(paramInt);
    paramViewHolder.b.setText(localp.a());
    if (!TextUtils.isEmpty(localp.b()))
    {
      if (!TextUtils.isEmpty(localp.c()))
      {
        localObject = localp.c();
        g localg = new g();
        localg.f0(new com.tplink.iot.Utils.y0.c());
        com.bumptech.glide.c.u(this.c).s((String)localObject).m0(localg).x0(paramViewHolder.a);
        paramViewHolder.c.setText(localp.b());
      }
      else
      {
        localObject = z4.c(this.c, localp.b(), true);
        paramViewHolder.c.setText((CharSequence)localObject);
        paramViewHolder.a.setImageResource(z4.a(this.c, localp.b()));
      }
    }
    else
    {
      paramViewHolder.a.setImageResource(2131690018);
      paramViewHolder.c.setText(2131953286);
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    this.c = paramViewGroup.getContext();
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559054, paramViewGroup, false));
  }
  
  void p(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.b.clear();
      this.b.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void q(List<p> paramList)
  {
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  class a
    implements View.OnClickListener
  {
    a(MemoriesFilterAdapter.b paramb) {}
    
    public void onClick(View paramView)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramView.getTag());
      paramView = ((StringBuilder)localObject).toString();
      boolean bool = MemoriesFilterAdapter.m(MemoriesFilterAdapter.this).contains(paramView);
      localObject = paramViewHolder.d;
      int i;
      if (!bool) {
        i = 2131689728;
      } else {
        i = 2131689727;
      }
      ((ImageView)localObject).setImageResource(i);
      if (bool) {
        MemoriesFilterAdapter.m(MemoriesFilterAdapter.this).remove(paramView);
      } else {
        MemoriesFilterAdapter.m(MemoriesFilterAdapter.this).add(paramView);
      }
    }
  }
  
  private class b
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    TextView b;
    TextView c;
    ImageView d;
    
    public b(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362405));
      this.b = ((TextView)paramView.findViewById(2131362414));
      this.c = ((TextView)paramView.findViewById(2131362412));
      this.d = ((ImageView)paramView.findViewById(2131362955));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\memories\filter\MemoriesFilterAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */