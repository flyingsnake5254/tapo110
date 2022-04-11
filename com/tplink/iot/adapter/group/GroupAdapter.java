package com.tplink.iot.adapter.group;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.j;
import com.tplink.iot.Utils.z0.o;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.widget.RippleCardView;
import java.util.ArrayList;
import java.util.List;

public class GroupAdapter
  extends RecyclerView.Adapter
{
  private Activity a;
  private List<GroupInfo> b = new ArrayList();
  private a c;
  
  public GroupAdapter(Activity paramActivity)
  {
    this.a = paramActivity;
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
  
  public void o(List<GroupInfo> paramList)
  {
    this.b.clear();
    if (paramList != null) {
      this.b.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((b)paramViewHolder).c((GroupInfo)this.b.get(paramInt), paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2131559018, paramViewGroup, false));
  }
  
  public void p(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, GroupInfo paramGroupInfo);
  }
  
  private class b
    extends RecyclerView.ViewHolder
  {
    RippleCardView a;
    TextView b;
    TextView c;
    ImageView d;
    
    b(View paramView)
    {
      super();
      this.a = ((RippleCardView)paramView.findViewById(2131362351));
      this.b = ((TextView)paramView.findViewById(2131364409));
      this.c = ((TextView)paramView.findViewById(2131364484));
      this.d = ((ImageView)paramView.findViewById(2131363066));
    }
    
    public void c(final GroupInfo paramGroupInfo, int paramInt)
    {
      this.b.setText(o.d(GroupAdapter.m(GroupAdapter.this), paramGroupInfo.getName()));
      o.g(paramGroupInfo, this.d);
      this.c.setText(o.a(paramGroupInfo));
      this.a.setCardElevation(j.a(GroupAdapter.m(GroupAdapter.this), 2.0F));
      this.a.setCardBackgroundColor(GroupAdapter.m(GroupAdapter.this).getResources().getColor(2131100206));
      this.b.setTextColor(GroupAdapter.m(GroupAdapter.this).getResources().getColor(2131099729));
      this.c.setTextColor(GroupAdapter.m(GroupAdapter.this).getResources().getColor(2131099754));
      this.b.setCompoundDrawablesWithIntrinsicBounds(null, null, GroupAdapter.m(GroupAdapter.this).getResources().getDrawable(2131689680), null);
      this.itemView.setOnClickListener(new a(paramGroupInfo));
    }
    
    class a
      implements View.OnClickListener
    {
      a(GroupInfo paramGroupInfo) {}
      
      public void onClick(View paramView)
      {
        if (GroupAdapter.n(GroupAdapter.this) != null) {
          GroupAdapter.n(GroupAdapter.this).a(paramView, paramGroupInfo);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\group\GroupAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */