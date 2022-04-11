package com.tplink.iot.adapter.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.g;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.RunShortCutResultBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeShortcutAdapter
  extends RecyclerView.Adapter
{
  private Activity a;
  private List<com.tplink.iot.model.home.i> b = new ArrayList();
  private c c;
  private Animation d;
  private boolean e = false;
  
  public HomeShortcutAdapter(Activity paramActivity)
  {
    this.a = paramActivity;
    this.d = AnimationUtils.loadAnimation(paramActivity, 2130771982);
  }
  
  private void r(d paramd)
  {
    paramd.c.setVisibility(8);
    paramd.f.setVisibility(8);
    paramd.e.setVisibility(8);
    paramd.e.clearAnimation();
  }
  
  private void s(d paramd, final com.tplink.iot.model.home.i parami)
  {
    paramd.c.setVisibility(0);
    paramd.e.setVisibility(8);
    paramd.e.clearAnimation();
    paramd.f.setVisibility(0);
    paramd.f.postDelayed(new b(parami), 1000L);
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
  
  public List<com.tplink.iot.model.home.i> o()
  {
    return this.b;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    d locald = (d)paramViewHolder;
    final com.tplink.iot.model.home.i locali = (com.tplink.iot.model.home.i)this.b.get(paramInt);
    final SmartInfo localSmartInfo = locali.b();
    Object localObject = localSmartInfo.getAvatarUrl();
    ArrayList localArrayList = new ArrayList(Arrays.asList(SmartRepository.i));
    paramViewHolder = (RecyclerView.ViewHolder)localObject;
    if (!localArrayList.contains(localObject)) {
      paramViewHolder = (String)localArrayList.get(0);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file:///android_asset/smart_icons/");
    ((StringBuilder)localObject).append(paramViewHolder);
    ((StringBuilder)localObject).append(".png");
    paramViewHolder = ((StringBuilder)localObject).toString();
    c.t(this.a).s(paramViewHolder).m0(new g().f(j.d)).x0(locald.b);
    locald.a.setText(localSmartInfo.getName());
    if (locali.c())
    {
      locald.d.setVisibility(8);
      int i = locali.a();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            s(locald, locali);
            break label286;
          }
        }
        else
        {
          locald.c.setVisibility(0);
          locald.e.setVisibility(0);
          locald.e.startAnimation(this.d);
          locald.f.setVisibility(8);
          break label286;
        }
      }
      else {
        r(locald);
      }
      r(locald);
    }
    else
    {
      locald.d.setVisibility(0);
      locali.e(0);
      r(locald);
    }
    label286:
    locald.itemView.setOnClickListener(new a(locali, paramInt, localSmartInfo));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new d(LayoutInflater.from(this.a).inflate(2131559161, paramViewGroup, false));
  }
  
  public void onViewRecycled(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
  }
  
  public void p(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void q(c paramc)
  {
    this.c = paramc;
  }
  
  public void t(List<com.tplink.iot.model.home.i> paramList)
  {
    this.b.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.b.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void u(RunShortCutResultBean paramRunShortCutResultBean)
  {
    for (int i = 0; i < this.b.size(); i++)
    {
      com.tplink.iot.model.home.i locali = (com.tplink.iot.model.home.i)this.b.get(i);
      if ((locali.b() != null) && (locali.b().getId() != null) && (locali.b().getId().equals(paramRunShortCutResultBean.getSmartId())) && (locali.a() == 1))
      {
        if (paramRunShortCutResultBean.isSuccess()) {
          locali.e(2);
        } else {
          locali.e(0);
        }
        notifyItemChanged(i);
      }
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a(com.tplink.iot.model.home.i parami, int paramInt, SmartInfo paramSmartInfo) {}
    
    public void onClick(View paramView)
    {
      if ((HomeShortcutAdapter.m(HomeShortcutAdapter.this) != null) && (locali.c()) && (locali.a() == 0) && (!HomeShortcutAdapter.n(HomeShortcutAdapter.this)))
      {
        locali.e(1);
        HomeShortcutAdapter.this.notifyItemChanged(paramInt);
        HomeShortcutAdapter.m(HomeShortcutAdapter.this).a(paramView, paramInt, localSmartInfo.getId());
      }
    }
  }
  
  class b
    implements Runnable
  {
    b(com.tplink.iot.model.home.i parami) {}
    
    public void run()
    {
      parami.e(0);
      HomeShortcutAdapter.this.notifyDataSetChanged();
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(View paramView, int paramInt, String paramString);
  }
  
  private class d
    extends RecyclerView.ViewHolder
  {
    TextView a;
    ImageView b;
    View c;
    View d;
    ImageView e;
    ImageView f;
    
    d(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364536));
      this.b = ((ImageView)paramView.findViewById(2131362837));
      this.c = paramView.findViewById(2131364810);
      this.d = paramView.findViewById(2131364794);
      this.e = ((ImageView)paramView.findViewById(2131363126));
      this.f = ((ImageView)paramView.findViewById(2131363127));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\HomeShortcutAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */