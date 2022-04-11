package com.tplink.iot.view.ipcamera.setting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.libtpnetwork.cameranetwork.util.i.b;
import java.util.ArrayList;
import java.util.List;

public class TimezoneListAdapter
  extends RecyclerView.Adapter<a>
{
  private List<i.b> a = new ArrayList();
  private i.b b;
  
  public int getItemCount()
  {
    List localList = this.a;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public i.b m()
  {
    return this.b;
  }
  
  public void p(@NonNull a parama, int paramInt)
  {
    i.b localb = (i.b)this.a.get(paramInt);
    parama.b.setText(localb.c());
    parama.c.setText(localb.d());
    if (this.b != null)
    {
      ImageView localImageView = parama.d;
      int i;
      if (localb.d().equals(this.b.d())) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
    parama.a.setOnClickListener(new v4(this, paramInt));
  }
  
  @NonNull
  public a q(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559023, paramViewGroup, false));
  }
  
  public void r(List<i.b> paramList, i.b paramb)
  {
    this.a.clear();
    this.a.addAll(paramList);
    this.b = paramb;
    notifyDataSetChanged();
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    RelativeLayout a;
    TextView b;
    TextView c;
    ImageView d;
    View e;
    
    public a(View paramView)
    {
      super();
      this.e = paramView;
      this.a = ((RelativeLayout)paramView.findViewById(2131362993));
      this.b = ((TextView)paramView.findViewById(2131362984));
      this.c = ((TextView)paramView.findViewById(2131362983));
      this.d = ((ImageView)paramView.findViewById(2131362986));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\TimezoneListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */