package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.quicksetup.SubGSetupHubCandidateAdapter;
import com.tplink.iot.cloud.bean.thing.common.SubThingCategoryBean;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingSupportCategory;
import com.tplink.iot.databinding.FragmentSubGHubListBinding;
import com.tplink.iot.view.iotcommon.IoTFirmwareUpdateActivity;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGHubListViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.exception.IoTException;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubGHubListFragment
  extends SubGBaseFragment<FragmentSubGHubListBinding, SubGHubListViewModel>
{
  private SubGSetupHubCandidateAdapter x;
  private SubGSetupHubCandidateAdapter y;
  
  private void G0(ThingSupportCategory paramThingSupportCategory, com.tplink.iot.model.iot.e parame)
  {
    if (paramThingSupportCategory.getDeviceCategoryList() != null)
    {
      int i = 0;
      paramThingSupportCategory = paramThingSupportCategory.getDeviceCategoryList().iterator();
      do
      {
        j = i;
        if (!paramThingSupportCategory.hasNext()) {
          break;
        }
      } while (!((SubThingCategoryBean)paramThingSupportCategory.next()).getCategory().equalsIgnoreCase(this.q.u().getCategory()));
      int j = 1;
      if (j != 0)
      {
        this.q.A0(parame.b().getDeviceIdMD5());
        J0();
        return;
      }
    }
    if (a1(parame)) {
      N0(parame);
    } else {
      b1();
    }
  }
  
  private void H0(int paramInt)
  {
    com.tplink.iot.model.iot.e locale = this.x.n(paramInt);
    BaseALIoTDevice localBaseALIoTDevice;
    if (locale != null) {
      localBaseALIoTDevice = locale.b();
    } else {
      localBaseALIoTDevice = null;
    }
    if (localBaseALIoTDevice == null)
    {
      s0.n(getActivity(), 2131952444);
      return;
    }
    if (((SubGHubListViewModel)this.d).f(localBaseALIoTDevice))
    {
      new TPMaterialDialogV2.Builder(getContext()).h(2131954140).o(2131952441, 2131099808, null).y();
      return;
    }
    s0.l(getActivity());
    I0(locale).N(new h(this, localBaseALIoTDevice)).l0(io.reactivex.d0.b.a.a()).E(new g(this, locale)).C(new i(this, locale)).F0();
  }
  
  private q<Boolean> I0(@NonNull com.tplink.iot.model.iot.e parame)
  {
    if (parame.a() == null) {
      return ((SubGHubListViewModel)this.d).h(parame.b()).g0(a.c);
    }
    return q.f0(Boolean.valueOf(a1(parame)));
  }
  
  private void J0()
  {
    this.f.e0("SubGRemoveCoverFragment.TAG", null);
  }
  
  private void L0()
  {
    this.f.e0("SubGHubEmptyFragment.TAG", null);
  }
  
  private void N0(@Nullable com.tplink.iot.model.iot.e parame)
  {
    if (parame != null) {
      IoTFirmwareUpdateActivity.t1(requireContext(), parame.b().getDeviceIdMD5(), true);
    }
  }
  
  private void O0(Throwable paramThrowable, com.tplink.iot.model.iot.e parame)
  {
    if ((paramThrowable instanceof IoTException))
    {
      paramThrowable = (IoTException)paramThrowable;
      if ((paramThrowable.getErrCode() == -1) && ("NeedToUpgradeHub".equals(paramThrowable.getMsg())))
      {
        i = 1;
        break label40;
      }
    }
    int i = 0;
    label40:
    if (i != 0) {
      N0(parame);
    } else {
      s0.n(getActivity(), 2131952444);
    }
  }
  
  private void P0(@Nullable List<com.tplink.iot.model.iot.e> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      int i = 0;
      boolean bool = false;
      while (localIterator.hasNext())
      {
        paramList = (com.tplink.iot.model.iot.e)localIterator.next();
        if (paramList.b().isUserRoleTypeDevice()) {
          bool = true;
        } else if (paramList.b().isOnline()) {
          localArrayList1.add(paramList);
        } else {
          localArrayList2.add(paramList);
        }
      }
      this.x.s(localArrayList1);
      this.y.s(localArrayList2);
      paramList = ((FragmentSubGHubListBinding)this.c).y;
      if (localArrayList1.isEmpty()) {
        j = 8;
      } else {
        j = 0;
      }
      paramList.setVisibility(j);
      paramList = ((FragmentSubGHubListBinding)this.c).f;
      int j = i;
      if (localArrayList2.isEmpty()) {
        j = 8;
      }
      paramList.setVisibility(j);
      if ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty())) {
        L0();
      }
      c1(bool);
      return;
    }
    L0();
  }
  
  private void Q0()
  {
    ((SubGHubListViewModel)this.d).g().observe(getViewLifecycleOwner(), new e(this));
  }
  
  private boolean a1(@Nullable com.tplink.iot.model.iot.e parame)
  {
    if ((parame != null) && (parame.a() != null)) {
      return parame.a().isNeedToUpgrade();
    }
    return false;
  }
  
  private void b1()
  {
    new TPMaterialDialogV3.Builder(requireContext()).d(2131954139).j(2131952441, 2131099808, null).t();
  }
  
  private void c1(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = ((FragmentSubGHubListBinding)this.c).c;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localFrameLayout.setVisibility(i);
  }
  
  public int B0()
  {
    return 2131558966;
  }
  
  public SubGHubListViewModel K0()
  {
    return (SubGHubListViewModel)ViewModelProviders.of(this).get(SubGHubListViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362826) {
      this.q.E0(20002);
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (this.q.r.get())
    {
      this.q.E0(20002);
      return;
    }
    ((FragmentSubGHubListBinding)this.c).x.setLayoutManager(new LinearLayoutManager(getActivity()));
    ((FragmentSubGHubListBinding)this.c).q.setLayoutManager(new LinearLayoutManager(getActivity()));
    this.x = new SubGSetupHubCandidateAdapter(getActivity());
    this.y = new SubGSetupHubCandidateAdapter(getActivity());
    ((FragmentSubGHubListBinding)this.c).x.setAdapter(this.x);
    ((FragmentSubGHubListBinding)this.c).q.setAdapter(this.y);
    this.x.t(new f(this));
    Q0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGHubListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */