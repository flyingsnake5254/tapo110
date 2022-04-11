package com.tplink.iot.adapter.smart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.a;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.viewmodel.smart.SmartActionViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartActionTaskAdapter
  extends RecyclerView.Adapter
{
  private List<SmartInfo> a = new ArrayList();
  private Context b;
  private SmartActionViewModel c;
  private a d;
  
  public SmartActionTaskAdapter(SmartActionViewModel paramSmartActionViewModel)
  {
    this.c = paramSmartActionViewModel;
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((ActionTaskHolder)paramViewHolder).c((SmartInfo)this.a.get(paramInt), paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    this.b = paramViewGroup.getContext();
    return new ActionTaskHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559422, paramViewGroup, false));
  }
  
  public void p(a parama)
  {
    this.d = parama;
  }
  
  public void q(List<SmartInfo> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public class ActionTaskHolder
    extends RecyclerView.ViewHolder
  {
    private RelativeLayout a;
    private ImageView b;
    private TextView c;
    private TextView d;
    
    ActionTaskHolder(View paramView)
    {
      super();
      this.a = ((RelativeLayout)paramView.findViewById(2131363905));
      this.b = ((ImageView)paramView.findViewById(2131363073));
      this.c = ((TextView)paramView.findViewById(2131362988));
      this.d = ((TextView)paramView.findViewById(2131362926));
    }
    
    public void c(SmartInfo paramSmartInfo, final int paramInt)
    {
      this.c.setText(paramSmartInfo.getName());
      this.d.setText(SmartActionTaskAdapter.m(SmartActionTaskAdapter.this).o(paramSmartInfo));
      String str = paramSmartInfo.getAvatarUrl();
      boolean bool = paramSmartInfo.getTriggerSetting().isManual();
      if (bool) {
        localObject = SmartRepository.i;
      } else {
        localObject = SmartRepository.h;
      }
      ArrayList localArrayList = new ArrayList(Arrays.asList((Object[])localObject));
      Object localObject = str;
      if (!localArrayList.contains(str)) {
        if (bool) {
          localObject = (String)localArrayList.get(0);
        } else {
          localObject = com.tplink.iot.view.smart.a.g.b(paramSmartInfo);
        }
      }
      paramSmartInfo = new StringBuilder();
      paramSmartInfo.append("file:///android_asset/smart_icons/");
      paramSmartInfo.append((String)localObject);
      paramSmartInfo.append(".png");
      paramSmartInfo = paramSmartInfo.toString();
      c.u(SmartActionTaskAdapter.n(SmartActionTaskAdapter.this)).s(paramSmartInfo).m0(new com.bumptech.glide.request.g().f(j.d)).x0(this.b);
      this.a.setOnClickListener(new a(paramInt));
    }
    
    class a
      implements View.OnClickListener
    {
      a(int paramInt) {}
      
      public void onClick(View paramView)
      {
        if (SmartActionTaskAdapter.o(SmartActionTaskAdapter.this) != null) {
          SmartActionTaskAdapter.o(SmartActionTaskAdapter.this).z(paramInt);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void z(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\smart\SmartActionTaskAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */