package com.tplink.iot.adapter.group;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditGroupAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<GroupInfo> b = new ArrayList();
  private Map<String, GroupInfo> c = new HashMap();
  private a d;
  
  public EditGroupAdapter(Activity paramActivity)
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
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((b)paramViewHolder).c((GroupInfo)this.b.get(paramInt), paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559029, paramViewGroup, false));
  }
  
  public List<GroupInfo> p()
  {
    return new ArrayList(this.c.values());
  }
  
  public void q(List<GroupInfo> paramList)
  {
    this.b.clear();
    if (paramList != null) {
      this.b.addAll(paramList);
    }
    this.c.clear();
    notifyDataSetChanged();
  }
  
  public void r(a parama)
  {
    this.d = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt);
  }
  
  private class b
    extends RecyclerView.ViewHolder
  {
    View a;
    TextView b;
    TextView c;
    ImageView d;
    TPCheckboxCompat e;
    RippleCardView f;
    
    b(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131364409));
      this.c = ((TextView)paramView.findViewById(2131364484));
      this.d = ((ImageView)paramView.findViewById(2131363066));
      this.e = ((TPCheckboxCompat)paramView.findViewById(2131362205));
      this.f = ((RippleCardView)paramView.findViewById(2131362351));
    }
    
    public void c(final GroupInfo paramGroupInfo, int paramInt)
    {
      this.b.setText(o.d(EditGroupAdapter.m(EditGroupAdapter.this), paramGroupInfo.getName()));
      o.g(paramGroupInfo, this.d);
      this.c.setText(o.a(paramGroupInfo));
      this.f.setCardElevation(j.a(EditGroupAdapter.m(EditGroupAdapter.this), 2.0F));
      this.e.setCompoundDrawablesRelativeWithIntrinsicBounds(EditGroupAdapter.m(EditGroupAdapter.this).getResources().getDrawable(2131231495), null, null, null);
      this.f.setCardBackgroundColor(EditGroupAdapter.m(EditGroupAdapter.this).getResources().getColor(2131100206));
      this.b.setTextColor(EditGroupAdapter.m(EditGroupAdapter.this).getResources().getColor(2131099729));
      this.c.setTextColor(EditGroupAdapter.m(EditGroupAdapter.this).getResources().getColor(2131099754));
      this.b.setCompoundDrawablesWithIntrinsicBounds(null, null, EditGroupAdapter.m(EditGroupAdapter.this).getResources().getDrawable(2131689680), null);
      this.e.setOnCheckedChangeListener(new a(paramGroupInfo));
      this.e.setChecked(EditGroupAdapter.n(EditGroupAdapter.this).containsKey(paramGroupInfo.getId()));
    }
    
    class a
      implements TPCheckboxCompat.a
    {
      a(GroupInfo paramGroupInfo) {}
      
      public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
      {
        if (paramBoolean2) {
          if (paramBoolean1) {
            EditGroupAdapter.n(EditGroupAdapter.this).put(paramGroupInfo.getId(), paramGroupInfo);
          } else {
            EditGroupAdapter.n(EditGroupAdapter.this).remove(paramGroupInfo.getId());
          }
        }
        if (EditGroupAdapter.o(EditGroupAdapter.this) != null) {
          EditGroupAdapter.o(EditGroupAdapter.this).b(EditGroupAdapter.n(EditGroupAdapter.this).size());
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\group\EditGroupAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */