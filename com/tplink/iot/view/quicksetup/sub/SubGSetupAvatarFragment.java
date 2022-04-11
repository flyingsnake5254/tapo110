package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.quicksetup.IoTIconAdapter;
import com.tplink.iot.databinding.FragmentSubGSetupAvatarBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGSetupAvatarViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubGSetupAvatarFragment
  extends SubGBaseFragment<FragmentSubGSetupAvatarBinding, SubGSetupAvatarViewModel>
{
  private IoTIconAdapter x = null;
  private final List<com.tplink.iot.adapter.quicksetup.e> y = new ArrayList();
  
  private void H0()
  {
    ((FragmentSubGSetupAvatarBinding)this.c).x.setVisibility(0);
    ((FragmentSubGSetupAvatarBinding)this.c).y.setEnabled(false);
  }
  
  private void I0()
  {
    ((FragmentSubGSetupAvatarBinding)this.c).x.setVisibility(8);
    ((FragmentSubGSetupAvatarBinding)this.c).y.setEnabled(true);
  }
  
  private void K0()
  {
    Iterator localIterator = this.q.z().k().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.y.add(new com.tplink.iot.adapter.quicksetup.e(str, false));
    }
    ((com.tplink.iot.adapter.quicksetup.e)this.y.get(0)).d(true);
  }
  
  private void L0()
  {
    this.q.v.observe(getViewLifecycleOwner(), new a());
  }
  
  private void N0()
  {
    ((FragmentSubGSetupAvatarBinding)this.c).d.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    ((FragmentSubGSetupAvatarBinding)this.c).d.setItemAnimator(new DefaultItemAnimator());
    Object localObject = new IoTIconAdapter(this.y, this.q.v(), this.q.u().value());
    this.x = ((IoTIconAdapter)localObject);
    ((FragmentSubGSetupAvatarBinding)this.c).d.setAdapter((RecyclerView.Adapter)localObject);
    localObject = (String)this.q.o.get();
    int i = 0;
    int j = i;
    if (localObject != null) {
      for (int k = 0;; k++)
      {
        j = i;
        if (k >= this.y.size()) {
          break;
        }
        if (((com.tplink.iot.adapter.quicksetup.e)this.y.get(k)).a().equals(localObject))
        {
          j = k;
          break;
        }
      }
    }
    this.x.r(j);
  }
  
  public int B0()
  {
    return 2131558970;
  }
  
  public SubGSetupAvatarViewModel J0()
  {
    return (SubGSetupAvatarViewModel)ViewModelProviders.of(this).get(SubGSetupAvatarViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i != 2131362826)
      {
        if (i == 2131364387) {
          this.f.e0("SubGCompleteFragment.TAG", null);
        }
      }
      else {
        this.q.E0(20002);
      }
    }
    else
    {
      H0();
      this.q.o.set(this.x.o());
      this.q.m();
    }
  }
  
  public void onDestroyView()
  {
    this.q.h();
    super.onDestroyView();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    K0();
    N0();
    L0();
  }
  
  class a
    implements Observer<a<Boolean>>
  {
    a() {}
    
    public void a(a<Boolean> parama)
    {
      ((FragmentSubGSetupAvatarBinding)SubGSetupAvatarFragment.this.c).c.h();
      SubGSetupAvatarFragment.G0(SubGSetupAvatarFragment.this);
      if (parama != null)
      {
        parama = (Boolean)parama.a();
        if ((parama != null) && (parama.booleanValue()))
        {
          if (!SubGSetupAvatarFragment.this.isAdded()) {
            return;
          }
          SubGSetupAvatarFragment.this.f.e0("SubGCompleteFragment.TAG", null);
        }
        else
        {
          int i = SubGSetupAvatarFragment.this.q.q.get();
          SubGSetupAvatarFragment.this.q.q.set(i + 1);
          s0.r(SubGSetupAvatarFragment.this.getActivity(), SubGSetupAvatarFragment.this.getString(2131953313), 3000L);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGSetupAvatarFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */