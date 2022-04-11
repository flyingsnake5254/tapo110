package com.tplink.iot.view.smart.actionsetup;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bumptech.glide.c;
import com.bumptech.glide.request.l.b;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.view.smart.b.e;
import com.tplink.iot.view.smart.b.f;
import com.tplink.iot.view.smart.b.g;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.DeviceChooseViewModel;
import com.tplink.iot.widget.ItemSmartSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConditionAddFragment
  extends BaseFragment
{
  private DeviceChooseViewModel p0;
  private f p1;
  private ItemSmartSettingLayout q;
  private ItemSmartSettingLayout x;
  private ActionDetailActivity y;
  private ActionSetupViewModel z;
  
  private void K0(View paramView)
  {
    ((TextView)paramView.findViewById(2131364290)).setText(2131953939);
    ((Toolbar)paramView.findViewById(2131364275)).setNavigationOnClickListener(new b());
    this.q = ((ItemSmartSettingLayout)paramView.findViewById(2131363915));
    ItemSmartSettingLayout localItemSmartSettingLayout = (ItemSmartSettingLayout)paramView.findViewById(2131363912);
    this.x = ((ItemSmartSettingLayout)paramView.findViewById(2131363911));
    c.x(this.y).s("file:///android_asset/smart_icons/SmartOneClickBlueBackground.png").u0(new g(this.q));
    c.x(this.y).s("file:///android_asset/smart_icons/SmartTimeTriggerBlueBackground.png").u0(new g(localItemSmartSettingLayout));
    c.x(this.y).s("file:///android_asset/smart_icons/SmartDeviceTriggerBlueBackground.png").u0(new g(this.x));
    localItemSmartSettingLayout.setOnClickListener(new c());
    this.x.setOnClickListener(new d());
  }
  
  private void Q0(List<BaseALIoTDevice> paramList)
  {
    Object localObject1 = this.z.v().getActionSetting();
    Object localObject2 = new ArrayList();
    if ((localObject1 != null) && (((SmartAction)localObject1).getThings() != null)) {
      ((List)localObject2).addAll(((SmartAction)localObject1).getThings());
    }
    localObject1 = new ArrayList();
    ((List)localObject1).add(new e());
    ((List)localObject1).add(new g(new o(this)));
    ((List)localObject1).add(new com.tplink.iot.view.smart.b.h());
    ((List)localObject1).add(new com.tplink.iot.view.smart.b.i(new n((List)localObject2)));
    ((List)localObject1).add(new f());
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!((com.tplink.iot.view.smart.b.d)((Iterator)localObject2).next()).a(localBaseALIoTDevice))
          {
            i = 0;
            break label210;
          }
        }
        i = 1;
        label210:
        if (i != 0)
        {
          i = 1;
          break label224;
        }
      }
    }
    int i = 0;
    label224:
    if (i != 0)
    {
      this.x.setEnabled(true);
      this.x.setItemEnable(true);
      this.x.setItemInfo(getString(2131954011));
    }
    else
    {
      this.x.setEnabled(false);
      this.x.setItemEnable(false);
      this.x.setItemInfo(getString(2131953220));
    }
  }
  
  private void S0()
  {
    this.z.D().observe(getViewLifecycleOwner(), new a());
    this.z.r().observe(getViewLifecycleOwner(), new m(this));
  }
  
  private void h()
  {
    if (this.z.P())
    {
      this.q.setVisibility(8);
    }
    else
    {
      this.q.setVisibility(0);
      this.q.setOnClickListener(new e());
    }
  }
  
  public void R0(f paramf)
  {
    this.p1 = paramf;
  }
  
  public boolean d()
  {
    if (getFragmentManager() != null) {
      getFragmentManager().popBackStackImmediate();
    }
    return true;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131558954, paramViewGroup, false);
    paramLayoutInflater = (ActionDetailActivity)getActivity();
    this.y = paramLayoutInflater;
    if (paramLayoutInflater == null) {
      B0();
    }
    com.tplink.iot.view.quicksetup.base.d.J(this.y, paramViewGroup.findViewById(2131364275));
    this.z = ((ActionSetupViewModel)ViewModelProviders.of(this.y).get(ActionSetupViewModel.class));
    this.p0 = ((DeviceChooseViewModel)ViewModelProviders.of(this.y).get(DeviceChooseViewModel.class));
    setHasOptionsMenu(true);
    K0(paramViewGroup);
    S0();
    return paramViewGroup;
  }
  
  class a
    implements Observer<SmartInfo>
  {
    a() {}
    
    public void a(@Nullable SmartInfo paramSmartInfo)
    {
      ConditionAddFragment.H0(ConditionAddFragment.this);
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      ConditionAddFragment.this.B0();
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      if (ConditionAddFragment.I0(ConditionAddFragment.this) != null) {
        ConditionAddFragment.I0(ConditionAddFragment.this).b();
      }
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      if (ConditionAddFragment.I0(ConditionAddFragment.this) != null) {
        ConditionAddFragment.I0(ConditionAddFragment.this).c();
      }
    }
  }
  
  class e
    implements View.OnClickListener
  {
    e() {}
    
    public void onClick(View paramView)
    {
      SmartInfo localSmartInfo = ConditionAddFragment.J0(ConditionAddFragment.this).v();
      paramView = new SmartTrigger();
      paramView.setManual(true);
      localSmartInfo.setTriggerSetting(paramView);
      ConditionAddFragment.J0(ConditionAddFragment.this).i0(true);
      ConditionAddFragment.J0(ConditionAddFragment.this).p0(localSmartInfo);
      if (ConditionAddFragment.I0(ConditionAddFragment.this) != null) {
        ConditionAddFragment.I0(ConditionAddFragment.this).a();
      }
    }
  }
  
  public static abstract interface f
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
  }
  
  public static class g
    extends com.bumptech.glide.request.k.d<ItemSmartSettingLayout, Drawable>
  {
    private ImageView z;
    
    g(@NonNull ItemSmartSettingLayout paramItemSmartSettingLayout)
    {
      super();
      this.z = ((ImageView)paramItemSmartSettingLayout.findViewById(2131363122));
    }
    
    public void h(@Nullable Drawable paramDrawable)
    {
      paramDrawable = this.z;
      if (paramDrawable != null) {
        paramDrawable.setImageResource(2131689744);
      }
    }
    
    protected void l(@Nullable Drawable paramDrawable) {}
    
    public void o(@NonNull Drawable paramDrawable, @Nullable b<? super Drawable> paramb)
    {
      paramb = this.z;
      if (paramb != null) {
        paramb.setImageDrawable(paramDrawable);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\ConditionAddFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */