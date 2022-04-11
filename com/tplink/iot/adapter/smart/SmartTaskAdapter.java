package com.tplink.iot.adapter.smart;

import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.a;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartReferAction;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplateMarketing;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.model.smart.e;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.SmartActionViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SmartTaskAdapter
  extends RecyclerView.Adapter
{
  private List<SmartTemplateMarketing> a;
  private List<e> b = new ArrayList();
  private FragmentActivity c;
  private boolean d;
  private a e;
  
  public SmartTaskAdapter(FragmentActivity paramFragmentActivity, boolean paramBoolean)
  {
    this.c = paramFragmentActivity;
    this.d = paramBoolean;
  }
  
  private boolean s(@NonNull ActionSetupViewModel paramActionSetupViewModel, @Nullable BaseALIoTDevice paramBaseALIoTDevice, @Nullable SmartThingAction paramSmartThingAction)
  {
    if ((paramBaseALIoTDevice != null) && (paramBaseALIoTDevice.getThingDevice() != null)) {
      return paramActionSetupViewModel.Q(paramBaseALIoTDevice.getThingDevice().getThingModelId(), paramSmartThingAction, paramBaseALIoTDevice.getDeviceId());
    }
    return false;
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((ActionTaskHolder)paramViewHolder).c((e)this.b.get(paramInt), paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new ActionTaskHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559425, paramViewGroup, false));
  }
  
  public List<e> r()
  {
    return this.b;
  }
  
  public void t(SmartAction paramSmartAction)
  {
    this.b.clear();
    ArrayList localArrayList = new ArrayList();
    if (paramSmartAction != null)
    {
      Object localObject = paramSmartAction.getThings();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(new e((SmartThingAction)((Iterator)localObject).next(), 1));
        }
      }
      paramSmartAction = paramSmartAction.getSmarts();
      if (paramSmartAction != null)
      {
        paramSmartAction = paramSmartAction.iterator();
        while (paramSmartAction.hasNext()) {
          localArrayList.add(new e((SmartReferAction)paramSmartAction.next(), 0));
        }
      }
    }
    if (!localArrayList.isEmpty()) {
      this.b.addAll(localArrayList);
    }
    notifyDataSetChanged();
  }
  
  public void u(List<SmartTemplateMarketing> paramList)
  {
    this.a = paramList;
  }
  
  public void v(a parama)
  {
    this.e = parama;
  }
  
  public class ActionTaskHolder
    extends RecyclerView.ViewHolder
  {
    private ImageView a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;
    
    ActionTaskHolder(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131363073));
      this.b = ((ImageView)paramView.findViewById(2131363074));
      this.c = ((TextView)paramView.findViewById(2131362988));
      this.d = ((TextView)paramView.findViewById(2131362926));
      this.e = ((TextView)paramView.findViewById(2131364496));
    }
    
    private boolean d(String paramString)
    {
      boolean bool;
      if ((!SmartTaskAdapter.m(SmartTaskAdapter.this).getString(2131953982).equals(paramString)) && (!SmartTaskAdapter.m(SmartTaskAdapter.this).getString(2131954296).equals(paramString))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    private void m(TextView paramTextView, String paramString, SmartThingAction paramSmartThingAction, SmartActionViewModel paramSmartActionViewModel)
    {
      paramTextView.setVisibility(8);
      if ((SmartTaskAdapter.n(SmartTaskAdapter.this)) && (SmartTaskAdapter.o(SmartTaskAdapter.this) != null) && (!SmartTaskAdapter.o(SmartTaskAdapter.this).isEmpty()))
      {
        Object localObject1 = SmartTaskAdapter.o(SmartTaskAdapter.this).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SmartTemplateMarketing)((Iterator)localObject1).next();
          if (paramString.equals(((SmartTemplateMarketing)localObject2).getCategory()))
          {
            localObject1 = ((SmartTemplateMarketing)localObject2).getUrl();
            break label106;
          }
        }
        localObject1 = "";
        label106:
        if (b.d.w.h.b.d((CharSequence)localObject1)) {
          return;
        }
        Object localObject2 = paramSmartActionViewModel.t();
        int i;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          paramSmartActionViewModel = (ActionSetupViewModel)new ViewModelProvider(SmartTaskAdapter.m(SmartTaskAdapter.this)).get(ActionSetupViewModel.class);
          localObject2 = ((List)localObject2).iterator();
          i = 0;
          BaseALIoTDevice localBaseALIoTDevice;
          do
          {
            do
            {
              j = i;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localBaseALIoTDevice = (BaseALIoTDevice)((Iterator)localObject2).next();
            } while ((!com.tplink.iot.view.smart.a.b.e(paramString, localBaseALIoTDevice)) || (!SmartTaskAdapter.p(SmartTaskAdapter.this, paramSmartActionViewModel, localBaseALIoTDevice, paramSmartThingAction)));
            i++;
          } while (!localBaseALIoTDevice.isSupportIoTCloud());
          return;
        }
        int j = 0;
        paramString = SmartTaskAdapter.m(SmartTaskAdapter.this).getResources();
        if (j == 0) {
          i = 2131953216;
        } else {
          i = 2131953954;
        }
        paramString = new SpannableString(paramString.getString(i));
        paramString.setSpan(new UnderlineSpan(), 0, paramString.length(), 0);
        paramTextView.setVisibility(0);
        paramTextView.setText(paramString);
        paramTextView.setOnClickListener(new m(this, (String)localObject1));
      }
    }
    
    public void c(e parame, int paramInt)
    {
      Object localObject1 = (SmartActionViewModel)ViewModelProviders.of(SmartTaskAdapter.m(SmartTaskAdapter.this)).get(SmartActionViewModel.class);
      int i = parame.b();
      int j = 0;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (i == 0)
      {
        localObject2 = ((SmartActionViewModel)localObject1).m(parame.d());
        localObject3 = parame.f().getName();
        localObject4 = this.c;
        if (localObject2 == null)
        {
          localObject5 = localObject3;
          if (b.d.w.h.b.d((CharSequence)localObject3)) {
            localObject5 = SmartTaskAdapter.m(SmartTaskAdapter.this).getResources().getString(2131952464);
          }
        }
        else
        {
          localObject5 = ((SmartInfo)localObject2).getName();
        }
        ((TextView)localObject4).setText((CharSequence)localObject5);
        this.d.setText(((SmartActionViewModel)localObject1).I(parame.f()));
        if (localObject2 != null) {
          localObject5 = ((SmartInfo)localObject2).getAvatarUrl();
        } else {
          localObject5 = parame.f().getAvatarUrl();
        }
        boolean bool;
        if ((localObject2 != null) && (!((SmartInfo)localObject2).getTriggerSetting().isManual())) {
          bool = false;
        } else {
          bool = true;
        }
        if (bool) {
          localObject3 = SmartRepository.i;
        } else {
          localObject3 = SmartRepository.h;
        }
        localObject1 = new ArrayList(Arrays.asList((Object[])localObject3));
        localObject3 = localObject5;
        if (!((List)localObject1).contains(localObject5)) {
          if (bool) {
            localObject3 = (String)((List)localObject1).get(0);
          } else {
            localObject3 = com.tplink.iot.view.smart.a.g.b((SmartInfo)localObject2);
          }
        }
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("file:///android_asset/smart_icons/");
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append(".png");
        localObject5 = ((StringBuilder)localObject5).toString();
        c.x(SmartTaskAdapter.m(SmartTaskAdapter.this)).s((String)localObject5).m0(new com.bumptech.glide.request.g().f(j.d)).x0(this.a);
        this.itemView.setOnClickListener(new n(this, bool, paramInt, parame));
      }
      else
      {
        localObject5 = parame.c();
        localObject2 = parame.g();
        if (SmartTaskAdapter.n(SmartTaskAdapter.this))
        {
          this.c.setText(com.tplink.iot.Utils.z0.n.f((String)localObject5));
          this.d.setText(((SmartActionViewModel)localObject1).K((SmartThingAction)localObject2, com.tplink.iot.view.smart.a.b.a((String)localObject5)));
          this.a.setImageResource(com.tplink.iot.Utils.z0.n.c((String)localObject5));
          m(this.e, (String)localObject5, (SmartThingAction)localObject2, (SmartActionViewModel)localObject1);
        }
        else
        {
          localObject4 = ((SmartActionViewModel)localObject1).l(parame.h());
          localObject3 = parame.e();
          localObject5 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject5 = SmartTaskAdapter.m(SmartTaskAdapter.this).getString(2131952465);
          }
          localObject3 = this.c;
          if (localObject4 != null) {
            localObject5 = com.tplink.iot.Utils.z0.l.c(SmartTaskAdapter.m(SmartTaskAdapter.this), (BaseALIoTDevice)localObject4);
          }
          ((TextView)localObject3).setText((CharSequence)localObject5);
          if (localObject4 != null) {
            com.tplink.iot.Utils.z0.l.o(SmartTaskAdapter.m(SmartTaskAdapter.this), (BaseALIoTDevice)localObject4, this.a);
          } else {
            this.a.setImageResource(2131689965);
          }
          this.d.setText(((SmartActionViewModel)localObject1).J((SmartThingAction)localObject2, (BaseALIoTDevice)localObject4));
          this.itemView.setOnClickListener(new k(this, (BaseALIoTDevice)localObject4, paramInt, parame));
        }
      }
      Object localObject5 = this.d;
      if (d(((TextView)localObject5).getText().toString())) {
        parame = SmartTaskAdapter.m(SmartTaskAdapter.this).getResources().getDrawable(2131690393);
      } else {
        parame = null;
      }
      ((TextView)localObject5).setCompoundDrawablesWithIntrinsicBounds(parame, null, null, null);
      this.b.setImageResource(2131690430);
      parame = this.b;
      if (SmartTaskAdapter.n(SmartTaskAdapter.this)) {
        j = 8;
      }
      parame.setVisibility(j);
      this.b.setOnClickListener(new l(this, paramInt));
    }
  }
  
  public static abstract interface a
  {
    public abstract void i0(int paramInt);
    
    public abstract void u(int paramInt, e parame);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\smart\SmartTaskAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */