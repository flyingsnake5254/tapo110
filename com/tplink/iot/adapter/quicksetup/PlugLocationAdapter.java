package com.tplink.iot.adapter.quicksetup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import java.util.Iterator;
import java.util.List;

public class PlugLocationAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<SelectLocationBean> b;
  private f c;
  
  public PlugLocationAdapter(Context paramContext, List<SelectLocationBean> paramList)
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
  
  public void o(f paramf)
  {
    this.c = paramf;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    b localb = (b)paramViewHolder;
    paramViewHolder = (SelectLocationBean)this.b.get(paramInt);
    localb.a.setText(EnumDeviceNicknameType.fromType(paramViewHolder.getLocation()));
    localb.b.setSelected(paramViewHolder.isSelect());
    localb.itemView.setOnClickListener(new a(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2131559071, paramViewGroup, false));
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      Iterator localIterator = PlugLocationAdapter.m(PlugLocationAdapter.this).iterator();
      while (localIterator.hasNext()) {
        ((SelectLocationBean)localIterator.next()).setSelect(false);
      }
      ((SelectLocationBean)PlugLocationAdapter.m(PlugLocationAdapter.this).get(paramInt)).setSelect(true);
      PlugLocationAdapter.this.notifyDataSetChanged();
      if (PlugLocationAdapter.n(PlugLocationAdapter.this) != null) {
        PlugLocationAdapter.n(PlugLocationAdapter.this).a(paramView, paramInt);
      }
    }
  }
  
  private class b
    extends RecyclerView.ViewHolder
  {
    TextView a;
    ImageView b;
    
    b(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364413));
      this.b = ((ImageView)paramView.findViewById(2131362816));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\PlugLocationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */