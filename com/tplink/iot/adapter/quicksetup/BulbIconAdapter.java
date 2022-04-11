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
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.model.iot.a;
import java.util.List;

public class BulbIconAdapter
  extends RecyclerView.Adapter<b>
{
  private Context a;
  private List<a> b;
  
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
  
  public void n(@NonNull final b paramb, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size()))
    {
      final a locala = (a)this.b.get(paramInt);
      if (locala != null)
      {
        View localView = paramb.b;
        if (locala.b()) {
          paramInt = 0;
        } else {
          paramInt = 8;
        }
        localView.setVisibility(paramInt);
        paramb.a.setImageResource(g.e(locala.a()));
        paramb.itemView.setOnClickListener(new a(locala, paramb));
      }
    }
  }
  
  @NonNull
  public b o(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2131559201, paramViewGroup, false));
  }
  
  class a
    implements View.OnClickListener
  {
    a(a parama, BulbIconAdapter.b paramb) {}
    
    public void onClick(View paramView)
    {
      if (!locala.b())
      {
        for (int i = 0; i < BulbIconAdapter.m(BulbIconAdapter.this).size(); i++) {
          ((a)BulbIconAdapter.m(BulbIconAdapter.this).get(i)).c(false);
        }
        ((a)BulbIconAdapter.m(BulbIconAdapter.this).get(paramb.getAdapterPosition())).c(true);
        BulbIconAdapter.this.notifyDataSetChanged();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\BulbIconAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */