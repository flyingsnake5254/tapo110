package com.tplink.iot.adapter.smart;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.a;
import com.tplink.iot.Utils.c0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.smart.common.SmartScheduleSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.view.smart.a.f;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumRotateDirection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SmartTriggerAdapter
  extends RecyclerView.Adapter
{
  private List<com.tplink.iot.model.smart.g> a = new ArrayList();
  private FragmentActivity b;
  private ActionSetupViewModel c;
  private boolean d;
  private boolean e = false;
  private a f;
  
  public SmartTriggerAdapter(FragmentActivity paramFragmentActivity, boolean paramBoolean)
  {
    this.b = paramFragmentActivity;
    this.d = paramBoolean;
    this.c = ((ActionSetupViewModel)new ViewModelProvider(paramFragmentActivity).get(ActionSetupViewModel.class));
  }
  
  @Nullable
  private String v(@Nullable SmartThingTrigger paramSmartThingTrigger, @Nullable BaseALIoTDevice paramBaseALIoTDevice, String paramString)
  {
    if (!f.d(paramSmartThingTrigger, paramBaseALIoTDevice))
    {
      if (this.c.O()) {
        return this.b.getString(2131954003);
      }
      return this.b.getString(2131954004);
    }
    return paramString;
  }
  
  private String w(@Nullable SmartThingTrigger paramSmartThingTrigger, @Nullable BaseALIoTDevice paramBaseALIoTDevice)
  {
    if ((paramBaseALIoTDevice != null) && (paramBaseALIoTDevice.isOnline()))
    {
      if (paramSmartThingTrigger == null) {
        return "";
      }
      if (paramSmartThingTrigger.getStateReported() != null)
      {
        paramSmartThingTrigger = paramSmartThingTrigger.getStateReported();
        if (b.k(paramBaseALIoTDevice)) {
          return f.b(paramSmartThingTrigger);
        }
      }
      else if (paramSmartThingTrigger.getEvent() != null)
      {
        String str = paramSmartThingTrigger.getEvent().getName();
        str.hashCode();
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          break;
        case 1862401626: 
          if (str.equals("windowOpen")) {
            i = 14;
          }
          break;
        case 1316937012: 
          if (str.equals("Babycry")) {
            i = 13;
          }
          break;
        case 94756344: 
          if (str.equals("close")) {
            i = 12;
          }
          break;
        case 92895825: 
          if (str.equals("alarm")) {
            i = 11;
          }
          break;
        case 3417674: 
          if (str.equals("open")) {
            i = 10;
          }
          break;
        case -40300674: 
          if (str.equals("rotation")) {
            i = 9;
          }
          break;
        case -56853649: 
          if (str.equals("keepOpen")) {
            i = 8;
          }
          break;
        case -103138146: 
          if (str.equals("tapoCameraLinecrossingDetection")) {
            i = 7;
          }
          break;
        case -154750372: 
          if (str.equals("tapoCameraAreaIntrusionDetection")) {
            i = 6;
          }
          break;
        case -496124649: 
          if (str.equals("PersonDetected")) {
            i = 5;
          }
          break;
        case -1068318794: 
          if (str.equals("motion")) {
            i = 4;
          }
          break;
        case -1643834313: 
          if (str.equals("doubleClick")) {
            i = 3;
          }
          break;
        case -1690695697: 
          if (str.equals("tapoCameraCameraTampering")) {
            i = 2;
          }
          break;
        case -1757823456: 
          if (str.equals("singleClick")) {
            i = 1;
          }
          break;
        case -1984451626: 
          if (str.equals("Motion")) {
            i = 0;
          }
          break;
        }
        switch (i)
        {
        default: 
          break;
        case 14: 
          return this.b.getString(2131954099);
        case 13: 
          return v(paramSmartThingTrigger, paramBaseALIoTDevice, this.b.getString(2131954083));
        case 12: 
          return this.b.getString(2131954086);
        case 11: 
          return this.b.getString(2131954080);
        case 9: 
          paramSmartThingTrigger = f.a(paramSmartThingTrigger);
          if ((paramSmartThingTrigger != null) && (paramSmartThingTrigger == EnumRotateDirection.CLOCKWISE)) {
            return this.b.getString(2131954103);
          }
          if ((paramSmartThingTrigger != null) && (paramSmartThingTrigger == EnumRotateDirection.ANTICLOCKWISE)) {
            return this.b.getString(2131954102);
          }
        case 10: 
          return this.b.getString(2131954098);
        case 8: 
          return this.b.getString(2131954096);
        case 7: 
          return this.b.getString(2131954085);
        case 6: 
          return this.b.getString(2131954082);
        case 5: 
          return v(paramSmartThingTrigger, paramBaseALIoTDevice, this.b.getString(2131952029));
        case 4: 
          return this.b.getString(2131954097);
        case 3: 
          if ((paramBaseALIoTDevice.isSwitch()) && (!f.c(paramSmartThingTrigger, paramBaseALIoTDevice))) {
            return this.b.getString(2131953971);
          }
          return this.b.getString(2131954089);
        case 2: 
          return this.b.getString(2131954084);
        case 1: 
          return this.b.getString(2131954105);
        }
        return this.b.getString(2131951944);
      }
      return "";
    }
    return this.b.getString(2131954296);
  }
  
  private String x(SmartScheduleSetting paramSmartScheduleSetting)
  {
    int i = paramSmartScheduleSetting.getDaysOfWeek();
    return c0.a(this.b, i);
  }
  
  private String y(SmartScheduleSetting paramSmartScheduleSetting)
  {
    String str;
    if (paramSmartScheduleSetting.getMode() == 2) {
      str = this.b.getResources().getString(2131954171);
    } else if (paramSmartScheduleSetting.getMode() == 1) {
      str = this.b.getResources().getString(2131954168);
    } else {
      str = o0.a(this.b, paramSmartScheduleSetting.getTime().intValue());
    }
    if ((paramSmartScheduleSetting.getMode() != 0) && (paramSmartScheduleSetting.getOffsetMins() != null)) {
      paramSmartScheduleSetting = o0.o(this.b, paramSmartScheduleSetting.getOffsetMins().intValue());
    } else {
      paramSmartScheduleSetting = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramSmartScheduleSetting);
    return localStringBuilder.toString();
  }
  
  private boolean z(@Nullable String paramString)
  {
    for (int i = 0; i < 4; i++)
    {
      int j = new int[] { 2131954296, 2131953971, 2131954003, 2131954004 }[i];
      if (this.b.getString(j).equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public void A(SmartTrigger paramSmartTrigger)
  {
    this.a.clear();
    if (paramSmartTrigger != null)
    {
      this.e = paramSmartTrigger.isManual();
      Object localObject = paramSmartTrigger.getSchedules();
      paramSmartTrigger = paramSmartTrigger.getThings();
      if (this.e)
      {
        this.a.add(new com.tplink.iot.model.smart.g());
      }
      else
      {
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            SmartScheduleSetting localSmartScheduleSetting = (SmartScheduleSetting)((Iterator)localObject).next();
            this.a.add(new com.tplink.iot.model.smart.g(0, localSmartScheduleSetting));
          }
        }
        if (paramSmartTrigger != null)
        {
          paramSmartTrigger = paramSmartTrigger.iterator();
          while (paramSmartTrigger.hasNext())
          {
            localObject = (SmartThingTrigger)paramSmartTrigger.next();
            this.a.add(new com.tplink.iot.model.smart.g(1, (SmartThingTrigger)localObject));
          }
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public void B(a parama)
  {
    this.f = parama;
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
    ((TriggerHolder)paramViewHolder).c((com.tplink.iot.model.smart.g)this.a.get(paramInt), paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new TriggerHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559167, paramViewGroup, false));
  }
  
  public class TriggerHolder
    extends RecyclerView.ViewHolder
  {
    private ImageView a;
    private ImageView b;
    private TextView c;
    private LinearLayout d;
    private TextView e;
    private TextView f;
    private TextView g;
    private View h;
    
    TriggerHolder(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131363075));
      this.b = ((ImageView)paramView.findViewById(2131363074));
      this.c = ((TextView)paramView.findViewById(2131362992));
      this.d = ((LinearLayout)paramView.findViewById(2131363298));
      this.e = ((TextView)paramView.findViewById(2131362988));
      this.f = ((TextView)paramView.findViewById(2131362980));
      this.g = ((TextView)paramView.findViewById(2131362981));
      this.h = paramView.findViewById(2131362020);
    }
    
    public void c(com.tplink.iot.model.smart.g paramg, int paramInt)
    {
      this.itemView.setOnClickListener(null);
      boolean bool = SmartTriggerAdapter.m(SmartTriggerAdapter.this);
      int j = 8;
      Object localObject2;
      if (bool)
      {
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        localObject1 = com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository.i[0];
      }
      else
      {
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        if (paramg.a() == 0)
        {
          this.g.setVisibility(0);
          this.e.setText(2131954012);
          if (paramg.b() != null)
          {
            this.f.setText(SmartTriggerAdapter.n(SmartTriggerAdapter.this, paramg.b()));
            this.g.setText(SmartTriggerAdapter.o(SmartTriggerAdapter.this, paramg.b()));
          }
          localObject1 = com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository.h[0];
        }
        else
        {
          if (paramg.a() == 1)
          {
            this.g.setVisibility(8);
            this.e.setText(2131952465);
            if (paramg.d() != null)
            {
              localObject1 = paramg.d().getNickname();
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                this.e.setText((CharSequence)localObject1);
              }
              localObject1 = SmartTriggerAdapter.p(SmartTriggerAdapter.this).l(paramg.d().getThingName());
              if (localObject1 != null) {
                this.e.setText(l.e(SmartTriggerAdapter.q(SmartTriggerAdapter.this), ((BaseALIoTDevice)localObject1).getDeviceType(), ((BaseALIoTDevice)localObject1).getDeviceName(), ((BaseALIoTDevice)localObject1).getDeviceModel()));
              }
              l.o(SmartTriggerAdapter.q(SmartTriggerAdapter.this), (BaseALIoTDevice)localObject1, this.a);
              this.f.setText(SmartTriggerAdapter.r(SmartTriggerAdapter.this, paramg.d(), (BaseALIoTDevice)localObject1));
              this.itemView.setOnClickListener(new p(this, paramg));
            }
          }
          localObject1 = null;
        }
        localObject2 = this.h;
        if ((SmartTriggerAdapter.s(SmartTriggerAdapter.this)) && (paramInt == SmartTriggerAdapter.this.getItemCount() - 1)) {
          paramInt = 8;
        } else {
          paramInt = 0;
        }
        ((View)localObject2).setVisibility(paramInt);
      }
      if (localObject1 != null)
      {
        i locali = c.x(SmartTriggerAdapter.q(SmartTriggerAdapter.this));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("file:///android_asset/smart_icons/");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(".png");
        locali.s(((StringBuilder)localObject2).toString()).m0(new com.bumptech.glide.request.g().f(j.d)).x0(this.a);
      }
      if (SmartTriggerAdapter.t(SmartTriggerAdapter.this, this.f.getText().toString())) {
        localObject1 = ResourcesCompat.getDrawable(SmartTriggerAdapter.q(SmartTriggerAdapter.this).getResources(), 2131690393, null);
      } else {
        localObject1 = null;
      }
      this.f.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
      Object localObject1 = this.b;
      if (SmartTriggerAdapter.s(SmartTriggerAdapter.this)) {
        paramInt = j;
      } else {
        paramInt = 0;
      }
      ((ImageView)localObject1).setVisibility(paramInt);
      if (!SmartTriggerAdapter.s(SmartTriggerAdapter.this)) {
        this.b.setOnClickListener(new o(this, paramg));
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void I(com.tplink.iot.model.smart.g paramg);
    
    public abstract void o(com.tplink.iot.model.smart.g paramg);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\smart\SmartTriggerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */