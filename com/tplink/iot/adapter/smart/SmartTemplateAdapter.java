package com.tplink.iot.adapter.smart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.g;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.model.smart.SmartTemplateBaseBean;
import com.tplink.iot.model.smart.SmartTemplateEntityBean;
import com.tplink.iot.model.smart.SmartTemplateTitleBean;
import java.util.List;

public class SmartTemplateAdapter
  extends RecyclerView.Adapter
{
  private List<SmartTemplateBaseBean> a;
  private b b;
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((SmartTemplateBaseBean)this.a.get(paramInt)).getType();
  }
  
  public void n(b paramb)
  {
    this.b = paramb;
  }
  
  public void o(List<SmartTemplateBaseBean> paramList)
  {
    this.a = paramList;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((a)paramViewHolder).c((SmartTemplateBaseBean)this.a.get(paramInt), paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559221, paramViewGroup, false));
    } else {
      paramViewGroup = new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559220, paramViewGroup, false));
    }
    return paramViewGroup;
  }
  
  private abstract class a
    extends RecyclerView.ViewHolder
  {
    a(View paramView)
    {
      super();
    }
    
    public abstract void c(SmartTemplateBaseBean paramSmartTemplateBaseBean, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void A(int paramInt);
  }
  
  private class c
    extends SmartTemplateAdapter.a
  {
    private ImageView b;
    private TextView c;
    
    c(View paramView)
    {
      super(paramView);
      this.c = ((TextView)paramView.findViewById(2131364639));
      this.b = ((ImageView)paramView.findViewById(2131363049));
    }
    
    public void c(final SmartTemplateBaseBean paramSmartTemplateBaseBean, final int paramInt)
    {
      paramSmartTemplateBaseBean = ((SmartTemplateEntityBean)paramSmartTemplateBaseBean).getEntity();
      this.c.setText(paramSmartTemplateBaseBean.getName());
      c.u(this.b.getContext()).s(paramSmartTemplateBaseBean.getTitleImgUrl()).m0(((g)((g)new g().V(2131690376)).j(2131690376)).f(j.d)).x0(this.b);
      this.b.setOnClickListener(new a(paramInt, paramSmartTemplateBaseBean));
    }
    
    class a
      implements View.OnClickListener
    {
      a(int paramInt, SmartTemplate paramSmartTemplate) {}
      
      public void onClick(View paramView)
      {
        if (SmartTemplateAdapter.m(SmartTemplateAdapter.this) != null)
        {
          int i = paramInt;
          int j;
          if (paramSmartTemplateBaseBean.getTriggerSetting().isManual()) {
            j = 1;
          } else {
            j = 2;
          }
          SmartTemplateAdapter.m(SmartTemplateAdapter.this).A(i - j);
        }
      }
    }
  }
  
  private class d
    extends SmartTemplateAdapter.a
  {
    private TextView b;
    
    d(View paramView)
    {
      super(paramView);
      this.b = ((TextView)paramView.findViewById(2131364640));
    }
    
    public void c(SmartTemplateBaseBean paramSmartTemplateBaseBean, int paramInt)
    {
      this.b.setText(((SmartTemplateTitleBean)paramSmartTemplateBaseBean).getTitle());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\smart\SmartTemplateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */