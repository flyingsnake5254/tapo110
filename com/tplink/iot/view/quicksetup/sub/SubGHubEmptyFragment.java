package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.quicksetup.DeviceCategoryBean;
import com.tplink.iot.adapter.quicksetup.SelectCategoryNewAdapter;
import com.tplink.iot.databinding.FragmentSubGHubEmptyBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.base.b;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGHubEmptyViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubGHubEmptyFragment
  extends SubGBaseFragment<FragmentSubGHubEmptyBinding, SubGHubEmptyViewModel>
{
  private RecyclerView x;
  
  private void H0(List<BaseALIoTDevice> paramList)
  {
    boolean bool1 = false;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      do
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break;
        }
      } while (!((BaseALIoTDevice)paramList.next()).isUserRoleTypeDevice());
      boolean bool2 = true;
      K0(bool2);
    }
    else
    {
      K0(false);
    }
  }
  
  private void I0(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b.c().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new DeviceCategoryBean((String)localIterator.next()));
    }
    this.x = ((RecyclerView)paramView.findViewById(2131363820));
    paramView = new GridLayoutManager(getActivity(), 2);
    paramView.setOrientation(1);
    this.x.setLayoutManager(paramView);
    paramView = new SelectCategoryNewAdapter(getActivity(), localArrayList);
    this.x.setAdapter(paramView);
  }
  
  private void K0(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = ((FragmentSubGHubEmptyBinding)this.c).c;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localFrameLayout.setVisibility(i);
  }
  
  private void L0()
  {
    ((SubGHubEmptyViewModel)this.d).f().observe(getViewLifecycleOwner(), new d(this));
  }
  
  public int B0()
  {
    return 2131558964;
  }
  
  public SubGHubEmptyViewModel G0()
  {
    return (SubGHubEmptyViewModel)ViewModelProviders.of(this).get(SubGHubEmptyViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362826) {
      A0();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    I0(paramView);
    L0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGHubEmptyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */