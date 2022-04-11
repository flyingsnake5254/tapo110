package com.tplink.iot.adapter.feature;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.c0;
import com.tplink.iot.Utils.l0;
import com.tplink.iot.Utils.l0.d;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import com.tplink.iot.devices.lightstrip.widget.LightStripTintView;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.widget.WeekdayView;
import com.tplink.iot.widget.colorbulb.SmallBulbTintView;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ScheduleRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter
  extends RecyclerView.Adapter<e>
{
  private List<ScheduleRuleBean> a = new ArrayList();
  private Activity b;
  private Animation c;
  private BaseALIoTDevice d;
  private boolean e;
  private boolean f;
  private String g;
  private f h;
  
  public ScheduleAdapter(Activity paramActivity, BaseALIoTDevice paramBaseALIoTDevice, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.b = paramActivity;
    this.c = AnimationUtils.loadAnimation(paramActivity, 2130771982);
    this.d = paramBaseALIoTDevice;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
    this.g = paramString;
  }
  
  private void t(View paramView, final ScheduleRuleBean paramScheduleRuleBean, final int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(this.b.getString(2131952401).toUpperCase());
    localObject = new l0(this.b, (List)localObject);
    ((PopupWindow)localObject).setAnimationStyle(2132018155);
    ((l0)localObject).g(this.b.getResources().getColor(2131099744));
    ((l0)localObject).f(new d(paramScheduleRuleBean, paramInt));
    ((l0)localObject).i(paramView);
  }
  
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
  
  @SuppressLint({"SetTextI18n"})
  public void p(@NonNull e parame, final int paramInt)
  {
    final ScheduleRuleBean localScheduleRuleBean = (ScheduleRuleBean)this.a.get(paramInt);
    parame.e(localScheduleRuleBean.isDeleting());
    Object localObject1 = localScheduleRuleBean.getDesiredStates();
    int i = 1;
    boolean bool1;
    if ((localObject1 != null) && (((DesiredStatesBean)localObject1).isOn())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((localObject1 == null) || (!((DesiredStatesBean)localObject1).isAuto())) {
      i = 0;
    }
    Object localObject2 = parame.d;
    Object localObject3 = this.b;
    if (bool1) {
      j = ((Activity)localObject3).getResources().getColor(2131099808);
    } else {
      j = ((Activity)localObject3).getResources().getColor(2131099736);
    }
    ((TextView)localObject2).setTextColor(j);
    localObject3 = this.b;
    int j = 2131952440;
    localObject3 = ((Activity)localObject3).getString(2131952440);
    parame.d();
    localObject2 = this.d;
    if ((localObject2 != null) && (((BaseALIoTDevice)localObject2).isBulb()))
    {
      boolean bool2 = this.d.isLightStrip();
      j = 100;
      if (bool2)
      {
        if ((localObject1 != null) && (((DesiredStatesBean)localObject1).getLightingEffectData() != null))
        {
          e.c(parame).setVisibility(0);
          e.c(parame).setImageResource(2131689895);
          localObject3 = this.b.getString(2131952442);
        }
        else
        {
          parame.b.setVisibility(0);
          parame.b.setTintColor(c.f(localScheduleRuleBean.getDesiredStates()));
          if ((bool1) && (i != 0))
          {
            localObject3 = this.b.getString(2131953804);
          }
          else if (bool1)
          {
            if (localObject1 != null) {
              j = ((DesiredStatesBean)localObject1).getBrightness();
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append("%");
            localObject3 = ((StringBuilder)localObject3).toString();
          }
        }
        parame.d.setText((CharSequence)localObject3);
      }
      else if (this.e)
      {
        if ((bool1) && (i != 0))
        {
          localObject3 = this.b.getString(2131953804);
        }
        else if (bool1)
        {
          if (localObject1 != null) {
            j = ((DesiredStatesBean)localObject1).getBrightness();
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(j);
          ((StringBuilder)localObject3).append("%");
          localObject3 = ((StringBuilder)localObject3).toString();
        }
        parame.a.setVisibility(0);
        parame.a.setTintColor(i.g(localScheduleRuleBean.getDesiredStates()));
        parame.d.setText((CharSequence)localObject3);
      }
      else
      {
        parame.a.setVisibility(0);
        parame.a.setTintColor(g.f(bool1));
        if (bool1)
        {
          if (localObject1 != null) {
            j = ((DesiredStatesBean)localObject1).getBrightness();
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(j);
          ((StringBuilder)localObject3).append("%");
          localObject3 = ((StringBuilder)localObject3).toString();
        }
        parame.d.setText((CharSequence)localObject3);
      }
    }
    else if (b.k(this.d))
    {
      e.c(parame).setVisibility(0);
      l.o(this.b, this.d, e.c(parame));
      if (localObject1 != null)
      {
        bool1 = ((DesiredStatesBean)localObject1).isFrostProtectionOn();
        if (bool1)
        {
          parame.d.setText(2131952440);
        }
        else
        {
          j = ((DesiredStatesBean)localObject1).getTargetTemp();
          localObject3 = ((DesiredStatesBean)localObject1).getTempUnit();
          parame.d.setText(b.e(j, (String)localObject3));
        }
        localObject3 = parame.d;
        if (bool1) {
          j = this.b.getResources().getColor(2131099736);
        } else {
          j = this.b.getResources().getColor(2131099810);
        }
        ((TextView)localObject3).setTextColor(j);
      }
      else
      {
        parame.d.setText(2131952440);
      }
    }
    else
    {
      e.c(parame).setVisibility(0);
      l.o(this.b, this.d, e.c(parame));
      if (localObject1 != null)
      {
        localObject3 = parame.d;
        if (((DesiredStatesBean)localObject1).isOn()) {
          j = 2131952442;
        }
        ((TextView)localObject3).setText(j);
      }
      else
      {
        localObject3 = parame.d;
        if (localScheduleRuleBean.isActionOn()) {
          j = 2131952442;
        }
        ((TextView)localObject3).setText(j);
      }
    }
    parame.h.setChecked(localScheduleRuleBean.isEnable());
    parame.g.setWeekdayTime(localScheduleRuleBean.getWeekOfDays());
    if (localScheduleRuleBean.getStartTimeType() != RuleTimeType.NORMAL)
    {
      parame.k.setVisibility(0);
      localObject1 = parame.k;
      localObject2 = new StringBuilder();
      if (localScheduleRuleBean.getStartTimeType() == RuleTimeType.SUNRISE)
      {
        localObject3 = this.b.getResources();
        j = 2131954168;
      }
      else
      {
        localObject3 = this.b.getResources();
        j = 2131954171;
      }
      ((StringBuilder)localObject2).append(((Resources)localObject3).getString(j));
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(o0.o(this.b, localScheduleRuleBean.getTimeOffset()));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    else
    {
      parame.k.setVisibility(8);
    }
    j = p0.c(localScheduleRuleBean.getStartTimeMin(), this.f, this.g);
    parame.e.setText(o0.a(this.b, j));
    parame.g.setVisibility(8);
    parame.f.setVisibility(0);
    parame.f.setText(c0.a(this.b, localScheduleRuleBean.getWeekOfDays()));
    parame.itemView.setOnClickListener(new a(localScheduleRuleBean));
    parame.itemView.setOnLongClickListener(new b(localScheduleRuleBean, paramInt));
    parame.h.setOnSwitchCheckedChangeListener(new c(localScheduleRuleBean));
  }
  
  @NonNull
  public e q(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559075, paramViewGroup, false));
  }
  
  public void r(List<ScheduleRuleBean> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void s(f paramf)
  {
    this.h = paramf;
  }
  
  class a
    implements View.OnClickListener
  {
    a(ScheduleRuleBean paramScheduleRuleBean) {}
    
    public void onClick(View paramView)
    {
      if (ScheduleAdapter.m(ScheduleAdapter.this) != null) {
        ScheduleAdapter.m(ScheduleAdapter.this).N(localScheduleRuleBean);
      }
    }
  }
  
  class b
    implements View.OnLongClickListener
  {
    b(ScheduleRuleBean paramScheduleRuleBean, int paramInt) {}
    
    public boolean onLongClick(View paramView)
    {
      ScheduleAdapter.n(ScheduleAdapter.this, paramView, localScheduleRuleBean, paramInt);
      return true;
    }
  }
  
  class c
    implements TPSwitchCompat.a
  {
    c(ScheduleRuleBean paramScheduleRuleBean) {}
    
    public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        localScheduleRuleBean.setEnable(paramBoolean1);
        if (ScheduleAdapter.m(ScheduleAdapter.this) != null) {
          ScheduleAdapter.m(ScheduleAdapter.this).W(localScheduleRuleBean);
        }
      }
    }
  }
  
  class d
    implements l0.d
  {
    d(ScheduleRuleBean paramScheduleRuleBean, int paramInt) {}
    
    public void a(View paramView, int paramInt)
    {
      paramScheduleRuleBean.setDeleting(true);
      ScheduleAdapter.this.notifyItemChanged(paramInt);
      if (ScheduleAdapter.m(ScheduleAdapter.this) != null) {
        ScheduleAdapter.m(ScheduleAdapter.this).H0(paramScheduleRuleBean);
      }
    }
  }
  
  class e
    extends RecyclerView.ViewHolder
  {
    SmallBulbTintView a;
    LightStripTintView b;
    private ImageView c;
    TextView d;
    TextView e;
    TextView f;
    WeekdayView g;
    TPSwitchCompat h;
    ImageView i;
    View j;
    TextView k;
    
    public e(View paramView)
    {
      super();
      this.a = ((SmallBulbTintView)paramView.findViewById(2131363018));
      this.b = ((LightStripTintView)paramView.findViewById(2131363078));
      this.c = ((ImageView)paramView.findViewById(2131363028));
      this.d = ((TextView)paramView.findViewById(2131364647));
      this.e = ((TextView)paramView.findViewById(2131364670));
      this.f = ((TextView)paramView.findViewById(2131364396));
      this.g = ((WeekdayView)paramView.findViewById(2131364836));
      this.h = ((TPSwitchCompat)paramView.findViewById(2131364126));
      this.i = ((ImageView)paramView.findViewById(2131363025));
      this.j = paramView.findViewById(2131364791);
      this.k = ((TextView)paramView.findViewById(2131364661));
    }
    
    public void d()
    {
      this.a.setVisibility(8);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    
    public void e(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.i.setVisibility(0);
        this.i.startAnimation(ScheduleAdapter.o(ScheduleAdapter.this));
        this.h.setVisibility(8);
        this.j.setVisibility(0);
      }
      else
      {
        this.i.clearAnimation();
        this.i.setVisibility(8);
        this.h.setVisibility(0);
        this.j.setVisibility(8);
      }
    }
  }
  
  public static abstract interface f
  {
    public abstract void H0(ScheduleRuleBean paramScheduleRuleBean);
    
    public abstract void N(ScheduleRuleBean paramScheduleRuleBean);
    
    public abstract void W(ScheduleRuleBean paramScheduleRuleBean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\feature\ScheduleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */