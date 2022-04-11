package com.tplink.iot.adapter.group;

import android.app.Activity;
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
import com.tplink.iot.Utils.b0;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import java.util.List;

public class GroupRoomLocationAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<RoomInfo> b;
  private int c = 0;
  private f d;
  
  public GroupRoomLocationAdapter(Activity paramActivity, List<RoomInfo> paramList, int paramInt)
  {
    this.a = paramActivity;
    this.b = paramList;
    this.c = paramInt;
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int i = 1;
    if (localList != null) {
      i = 1 + localList.size();
    }
    return i;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    b localb = (b)paramViewHolder;
    TextView localTextView = localb.a;
    if (paramInt < p()) {
      paramViewHolder = ((RoomInfo)this.b.get(paramInt)).getName();
    } else {
      paramViewHolder = b0.a(2131953004);
    }
    localTextView.setText(paramViewHolder);
    int i = getItemCount();
    boolean bool = true;
    if (paramInt != i - 1)
    {
      localb.b.setVisibility(0);
      localb.c.setVisibility(8);
    }
    else
    {
      localb.b.setVisibility(8);
      localb.c.setVisibility(0);
    }
    paramViewHolder = localb.b;
    if (paramInt != this.c) {
      bool = false;
    }
    paramViewHolder.setSelected(bool);
    localb.itemView.setOnClickListener(new a(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2131559038, paramViewGroup, false));
  }
  
  public int p()
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
  
  public void q(f paramf)
  {
    this.d = paramf;
  }
  
  public void r(int paramInt)
  {
    if ((paramInt != this.c) && (paramInt < p()))
    {
      this.c = paramInt;
      notifyDataSetChanged();
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if ((paramInt != GroupRoomLocationAdapter.m(GroupRoomLocationAdapter.this)) && (paramInt != GroupRoomLocationAdapter.this.getItemCount() - 1))
      {
        GroupRoomLocationAdapter.n(GroupRoomLocationAdapter.this, paramInt);
        GroupRoomLocationAdapter.this.notifyDataSetChanged();
      }
      if (GroupRoomLocationAdapter.o(GroupRoomLocationAdapter.this) != null) {
        GroupRoomLocationAdapter.o(GroupRoomLocationAdapter.this).a(paramView, paramInt);
      }
    }
  }
  
  private class b
    extends RecyclerView.ViewHolder
  {
    TextView a;
    ImageView b;
    ImageView c;
    
    b(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364413));
      this.b = ((ImageView)paramView.findViewById(2131362816));
      this.c = ((ImageView)paramView.findViewById(2131362846));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\group\GroupRoomLocationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */