package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.quicksetup.RoomLocationAdapter;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.databinding.FragmentSubGSetupLocationSelectBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGSetupLocationCustomViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import java.util.List;

public class SubGSetupLocationSelectFragment
  extends SubGBaseFragment<FragmentSubGSetupLocationSelectBinding, SubGSetupLocationCustomViewModel>
{
  private String x;
  private List<RoomInfo> y;
  
  private void H0()
  {
    this.f.e0("SubGSetupLocationCustomFragment.TAG", null);
  }
  
  private void I0(String paramString)
  {
    ((FragmentSubGSetupLocationSelectBinding)this.c).c.h();
    this.q.n.set(paramString);
    this.f.e0("SubGSetupAvatarFragment.TAG", null);
  }
  
  private void J0()
  {
    List localList = this.q.s();
    this.y = localList;
    if ((localList != null) && (!localList.isEmpty())) {
      this.x = ((RoomInfo)this.y.get(0)).getName();
    }
  }
  
  private void K0()
  {
    ((FragmentSubGSetupLocationSelectBinding)this.c).d.setLayoutManager(new LinearLayoutManager(getActivity()));
    RoomLocationAdapter localRoomLocationAdapter = new RoomLocationAdapter(getActivity(), this.y, 0);
    ((FragmentSubGSetupLocationSelectBinding)this.c).d.setAdapter(localRoomLocationAdapter);
    localRoomLocationAdapter.q(new q(this));
  }
  
  public int B0()
  {
    return 2131558972;
  }
  
  public SubGSetupLocationCustomViewModel G0()
  {
    return (SubGSetupLocationCustomViewModel)ViewModelProviders.of(this).get(SubGSetupLocationCustomViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362826) {
        this.q.E0(20002);
      }
    }
    else {
      I0(this.x);
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    J0();
    K0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGSetupLocationSelectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */