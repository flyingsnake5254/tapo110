package com.tplink.iot.adapter.smart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.tplink.iot.Utils.l0;
import com.tplink.iot.adapter.home.k;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.viewmodel.smart.SmartActionViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.RunShortCutResultBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.Utils.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SmartActionAdapter
  extends RecyclerView.Adapter
  implements k
{
  private int a = 0;
  private boolean b;
  private FragmentActivity c;
  private SmartActionViewModel d;
  private Animation e;
  private List<SmartInfo> f = new ArrayList();
  private List<com.tplink.iot.model.smart.b> g = new ArrayList();
  private b h;
  private c i;
  
  public SmartActionAdapter(FragmentActivity paramFragmentActivity, boolean paramBoolean)
  {
    this.c = paramFragmentActivity;
    this.b = paramBoolean;
    this.d = ((SmartActionViewModel)ViewModelProviders.of(paramFragmentActivity).get(SmartActionViewModel.class));
    this.e = AnimationUtils.loadAnimation(paramFragmentActivity, 2130771982);
  }
  
  private void D(View paramView, int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(this.c.getString(2131952401).toUpperCase());
    localObject = new l0(this.c, (List)localObject);
    ((PopupWindow)localObject).setAnimationStyle(2132018155);
    ((l0)localObject).g(this.c.getResources().getColor(2131099744));
    ((l0)localObject).f(new h(this, paramInt));
    ((l0)localObject).i(paramView);
  }
  
  private com.tplink.iot.model.smart.c u(com.tplink.iot.model.smart.c paramc, List<com.tplink.iot.model.smart.b> paramList)
  {
    SmartInfo localSmartInfo = paramc.c();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (com.tplink.iot.model.smart.b)paramList.next();
        if ((localObject != null) && (((com.tplink.iot.model.smart.b)localObject).a() == 1))
        {
          localObject = (com.tplink.iot.model.smart.c)localObject;
          if ((((com.tplink.iot.model.smart.c)localObject).c() != null) && (localSmartInfo.getId().equals(((com.tplink.iot.model.smart.c)localObject).c().getId()))) {
            paramc.e(((com.tplink.iot.model.smart.c)localObject).d());
          }
        }
      }
    }
    return paramc;
  }
  
  private List<com.tplink.iot.model.smart.b> v(List<com.tplink.iot.model.smart.b> paramList1, List<com.tplink.iot.model.smart.b> paramList2)
  {
    if ((paramList1 != null) && (!paramList1.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      for (int j = 0; j < paramList1.size(); j++)
      {
        com.tplink.iot.model.smart.b localb = (com.tplink.iot.model.smart.b)paramList1.get(j);
        if (localb.a() == 1)
        {
          com.tplink.iot.model.smart.c localc = (com.tplink.iot.model.smart.c)localb;
          if (localc.c().getTriggerSetting().isManual())
          {
            localArrayList.add(u(localc, paramList2));
            continue;
          }
        }
        localArrayList.add(localb);
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public void A(b paramb)
  {
    this.h = paramb;
  }
  
  public void B(int paramInt)
  {
    this.a = paramInt;
    notifyDataSetChanged();
  }
  
  public void C(c paramc)
  {
    this.i = paramc;
  }
  
  public void E(RunShortCutResultBean paramRunShortCutResultBean)
  {
    for (int j = 0; j < this.g.size(); j++) {
      if (((com.tplink.iot.model.smart.b)this.g.get(j)).a() == 1)
      {
        com.tplink.iot.model.smart.c localc = (com.tplink.iot.model.smart.c)this.g.get(j);
        SmartInfo localSmartInfo = localc.c();
        if ((localSmartInfo != null) && (paramRunShortCutResultBean.getSmartId().equals(localSmartInfo.getId())) && (localc.d() == 1))
        {
          if (paramRunShortCutResultBean.isSuccess()) {
            localc.e(2);
          } else {
            localc.e(0);
          }
          notifyItemChanged(j);
        }
      }
    }
  }
  
  public boolean e()
  {
    int j = this.a;
    boolean bool = true;
    if ((j != 1) || (!this.b)) {
      bool = false;
    }
    return bool;
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    List localList = this.g;
    if ((localList != null) && (localList.size() > 1) && (paramInt1 != paramInt2) && (paramInt1 >= 0) && (paramInt1 < this.g.size()) && (paramInt2 >= 0) && (paramInt2 < this.g.size()))
    {
      Collections.swap(this.g, paramInt1, paramInt2);
      notifyItemMoved(paramInt1, paramInt2);
    }
  }
  
  public int getItemCount()
  {
    List localList = this.g;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((com.tplink.iot.model.smart.b)this.g.get(paramInt)).a();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = (a)paramViewHolder;
    paramViewHolder.c((com.tplink.iot.model.smart.b)this.g.get(paramInt), paramInt, paramViewHolder);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return new HistoryHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559216, paramViewGroup, false));
      }
      return new ActionHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559215, paramViewGroup, false));
    }
    return new TitleHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559217, paramViewGroup, false));
  }
  
  public List<SmartInfo> w()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.g.isEmpty()) {
      return localArrayList;
    }
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (com.tplink.iot.model.smart.b)localIterator.next();
      if (1 == ((com.tplink.iot.model.smart.b)localObject).a())
      {
        localObject = ((com.tplink.iot.model.smart.c)localObject).c();
        if ((((SmartInfo)localObject).getTriggerSetting() != null) && (((SmartInfo)localObject).getTriggerSetting().isManual())) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public void z(List<com.tplink.iot.model.smart.b> paramList)
  {
    this.g = v(paramList, this.g);
    this.f = w();
    notifyDataSetChanged();
  }
  
  public class ActionHolder
    extends SmartActionAdapter.a
  {
    private RelativeLayout b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private Button g;
    private SwitchCompat h;
    private ImageView i;
    private View j;
    private ImageView k;
    private ImageView l;
    
    ActionHolder(View paramView)
    {
      super(paramView);
      this.b = ((RelativeLayout)paramView.findViewById(2131363904));
      this.c = ((ImageView)paramView.findViewById(2131363129));
      this.d = ((TextView)paramView.findViewById(2131364634));
      this.e = ((TextView)paramView.findViewById(2131363087));
      this.f = ((TextView)paramView.findViewById(2131364633));
      this.g = ((Button)paramView.findViewById(2131362108));
      this.j = paramView.findViewById(2131364810);
      this.k = ((ImageView)paramView.findViewById(2131363126));
      this.l = ((ImageView)paramView.findViewById(2131363127));
      this.h = ((SwitchCompat)paramView.findViewById(2131364133));
      this.i = ((ImageView)paramView.findViewById(2131363130));
    }
    
    private void d(boolean paramBoolean)
    {
      this.g.setVisibility(0);
      this.g.setEnabled(paramBoolean);
      Button localButton = this.g;
      float f1;
      if (paramBoolean) {
        f1 = 1.0F;
      } else {
        f1 = 0.4F;
      }
      localButton.setAlpha(f1);
      this.k.clearAnimation();
      this.k.setVisibility(8);
      this.l.setVisibility(8);
      this.j.setVisibility(8);
    }
    
    private void q(com.tplink.iot.model.smart.c paramc)
    {
      paramc = paramc.c();
      this.h.setEnabled(SmartActionAdapter.m(SmartActionAdapter.this).R(paramc.getId()));
      this.h.setOnCheckedChangeListener(null);
      if (!this.h.isEnabled())
      {
        this.h.setChecked(false);
      }
      else
      {
        this.h.setChecked(paramc.isEnabled());
        this.h.setOnCheckedChangeListener(new b(this, paramc));
      }
    }
    
    private void r(com.tplink.iot.model.smart.c paramc, int paramInt)
    {
      SmartInfo localSmartInfo = paramc.c();
      if (SmartActionAdapter.m(SmartActionAdapter.this).R(localSmartInfo.getId()))
      {
        int n = paramc.d();
        if (n != 1)
        {
          if (n != 2)
          {
            d(true);
          }
          else
          {
            paramc.e(0);
            s();
          }
        }
        else {
          t();
        }
      }
      else
      {
        d(false);
      }
      Button localButton = this.g;
      if (!localButton.isEnabled()) {
        paramc = null;
      } else {
        paramc = new c(this, paramc, paramInt, localSmartInfo);
      }
      localButton.setOnClickListener(paramc);
    }
    
    private void s()
    {
      this.g.setVisibility(8);
      this.j.setVisibility(0);
      this.k.clearAnimation();
      this.k.setVisibility(8);
      this.l.setVisibility(0);
      this.l.postDelayed(new f(this), 1000L);
    }
    
    private void t()
    {
      this.g.setVisibility(8);
      this.j.setVisibility(0);
      this.l.setVisibility(8);
      this.k.setVisibility(0);
      this.k.startAnimation(SmartActionAdapter.q(SmartActionAdapter.this));
    }
    
    @SuppressLint({"ClickableViewAccessibility"})
    public void c(com.tplink.iot.model.smart.b paramb, int paramInt, SmartActionAdapter.a parama)
    {
      com.tplink.iot.model.smart.c localc = (com.tplink.iot.model.smart.c)paramb;
      SmartInfo localSmartInfo = localc.c();
      ActionHolder localActionHolder = (ActionHolder)parama;
      this.d.setText(localSmartInfo.getName());
      this.f.setText(SmartActionAdapter.m(SmartActionAdapter.this).o(localSmartInfo));
      parama = localSmartInfo.getAvatarUrl();
      boolean bool1 = localSmartInfo.getTriggerSetting().isManual();
      if (bool1) {
        paramb = SmartRepository.i;
      } else {
        paramb = SmartRepository.h;
      }
      ArrayList localArrayList = new ArrayList(Arrays.asList(paramb));
      boolean bool2 = localArrayList.contains(parama);
      int n = 0;
      paramb = parama;
      if (!bool2) {
        if (bool1) {
          paramb = (String)localArrayList.get(0);
        } else {
          paramb = com.tplink.iot.view.smart.a.g.b(localSmartInfo);
        }
      }
      parama = new StringBuilder();
      parama.append("file:///android_asset/smart_icons/");
      parama.append(paramb);
      parama.append(".png");
      paramb = parama.toString();
      com.bumptech.glide.c.x(SmartActionAdapter.n(SmartActionAdapter.this)).s(paramb).m0(new com.bumptech.glide.request.g().f(j.d)).x0(this.c);
      int i1;
      if ((SmartActionAdapter.o(SmartActionAdapter.this) != null) && (!SmartActionAdapter.o(SmartActionAdapter.this).isEmpty())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2 = paramInt - i1 - (bool1 ^ true);
      paramb = this.i;
      if (SmartActionAdapter.p(SmartActionAdapter.this)) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      paramb.setVisibility(i1);
      if (SmartActionAdapter.p(SmartActionAdapter.this))
      {
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.i.setOnTouchListener(new a(this, localActionHolder));
      }
      else
      {
        parama = o.h0().f("new_smart_info", "");
        paramb = this.e;
        if (localSmartInfo.getId().equals(parama)) {
          i1 = 0;
        } else {
          i1 = 8;
        }
        paramb.setVisibility(i1);
        this.b.setOnClickListener(new d(this, i2));
        this.b.setOnLongClickListener(new e(this, i2));
        paramb = this.g;
        if (bool1) {
          i1 = 0;
        } else {
          i1 = 8;
        }
        paramb.setVisibility(i1);
        if (bool1) {
          localActionHolder.r(localc, paramInt);
        }
        paramb = this.h;
        if (!bool1) {
          paramInt = n;
        } else {
          paramInt = 8;
        }
        paramb.setVisibility(paramInt);
        if (!bool1) {
          localActionHolder.q(localc);
        }
      }
    }
  }
  
  public class HistoryHolder
    extends SmartActionAdapter.a
  {
    private LinearLayout b;
    
    HistoryHolder(View paramView)
    {
      super(paramView);
      this.b = ((LinearLayout)paramView.findViewById(2131363254));
    }
    
    public void c(com.tplink.iot.model.smart.b paramb, int paramInt, SmartActionAdapter.a parama)
    {
      this.b.setOnClickListener(new g(this));
    }
  }
  
  public class TitleHolder
    extends SmartActionAdapter.a
  {
    private TextView b;
    
    TitleHolder(View paramView)
    {
      super(paramView);
      this.b = ((TextView)paramView.findViewById(2131364636));
    }
    
    public void c(com.tplink.iot.model.smart.b paramb, int paramInt, SmartActionAdapter.a parama)
    {
      this.b.setText(((com.tplink.iot.model.smart.f)paramb).c());
    }
  }
  
  private abstract class a
    extends RecyclerView.ViewHolder
  {
    a(View paramView)
    {
      super();
    }
    
    public abstract void c(com.tplink.iot.model.smart.b paramb, int paramInt, a parama);
  }
  
  public static abstract interface b
  {
    public abstract void F(SmartInfo paramSmartInfo);
    
    public abstract void Q(SmartInfo paramSmartInfo, SmartActionAdapter.ActionHolder paramActionHolder);
    
    public abstract void a0();
    
    public abstract void h0(int paramInt);
    
    public abstract void q(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void B(SmartActionAdapter.ActionHolder paramActionHolder);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\smart\SmartActionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */