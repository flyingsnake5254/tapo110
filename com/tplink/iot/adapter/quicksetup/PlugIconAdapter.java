package com.tplink.iot.adapter.quicksetup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.q;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import java.util.Iterator;
import java.util.List;

public class PlugIconAdapter
  extends RecyclerView.Adapter<b>
{
  private Context a;
  private List<g> b;
  
  public PlugIconAdapter(Context paramContext, List<g> paramList)
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
  
  public EnumIoTAvatarType n()
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() > 0)) {
      for (int i = 0; i < this.b.size(); i++) {
        if (((g)this.b.get(i)).b()) {
          return ((g)this.b.get(i)).a();
        }
      }
    }
    return EnumIoTAvatarType.PLUG;
  }
  
  public void o(@NonNull b paramb, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size()))
    {
      final g localg = (g)this.b.get(paramInt);
      if (localg != null)
      {
        View localView = paramb.b;
        if (localg.b()) {
          paramInt = 0;
        } else {
          paramInt = 8;
        }
        localView.setVisibility(paramInt);
        paramb.a.setImageResource(q.i(localg.a()));
        paramb.itemView.setOnClickListener(new a(localg));
      }
    }
  }
  
  @NonNull
  public b p(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2131559201, paramViewGroup, false));
  }
  
  class a
    implements View.OnClickListener
  {
    a(g paramg) {}
    
    public void onClick(View paramView)
    {
      if (!localg.b())
      {
        paramView = PlugIconAdapter.m(PlugIconAdapter.this).iterator();
        while (paramView.hasNext()) {
          ((g)paramView.next()).d(false);
        }
        localg.d(true);
        PlugIconAdapter.this.notifyDataSetChanged();
      }
    }
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    View b;
    
    b(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362797));
      this.b = paramView.findViewById(2131364009);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\PlugIconAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */