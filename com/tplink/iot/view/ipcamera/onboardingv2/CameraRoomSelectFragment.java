package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.adapter.quicksetup.RoomLocationAdapter;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.databinding.FragmentCameraV2RoomSelectBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraRoomSelectViewModel;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import java.util.List;

public class CameraRoomSelectFragment
  extends OnBoardingFragment<FragmentCameraV2RoomSelectBinding, CameraRoomSelectViewModel>
{
  private String x;
  private List<RoomInfo> y;
  
  private void H0()
  {
    Object localObject = (TPIoTClientManager)b.a(a.f(), TPIoTClientManager.class);
    if (((TPIoTClientManager)localObject).Q1() != null) {
      localObject = ((TPIoTClientManager)localObject).Q1().getRooms();
    } else {
      localObject = null;
    }
    this.y = ((List)localObject);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      this.x = ((RoomInfo)this.y.get(0)).getName();
    }
  }
  
  private void I0()
  {
    ((FragmentCameraV2RoomSelectBinding)this.c).x.setNavigationOnClickListener(new u0(this));
    RoomLocationAdapter localRoomLocationAdapter = new RoomLocationAdapter(getActivity(), this.y, 0);
    ((FragmentCameraV2RoomSelectBinding)this.c).d.setLayoutManager(new LinearLayoutManager(getActivity()));
    ((FragmentCameraV2RoomSelectBinding)this.c).d.setAdapter(localRoomLocationAdapter);
    localRoomLocationAdapter.q(new t0(this));
  }
  
  public int A0()
  {
    return 2131558896;
  }
  
  public CameraRoomSelectViewModel G0()
  {
    return (CameraRoomSelectViewModel)ViewModelProviders.of(this).get(CameraRoomSelectViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363541)
    {
      this.q.X = this.x;
      this.f.e0("CameraSetLocationFragment.TAG", null);
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    H0();
    I0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraRoomSelectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */