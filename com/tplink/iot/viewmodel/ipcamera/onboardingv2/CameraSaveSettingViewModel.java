package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import java.util.Iterator;
import java.util.List;

public class CameraSaveSettingViewModel
  extends OnBoardingFragmentViewModel
{
  public final ObservableField<String> a = new ObservableField("");
  private final TPIoTClientManager b = (TPIoTClientManager)b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
  private final FamilyManagerRepository c = (FamilyManagerRepository)b.a(b.d.s.a.a.f(), FamilyManagerRepository.class);
  
  public CameraSaveSettingViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private List<RoomInfo> f()
  {
    if (this.b.Q1() == null) {
      return null;
    }
    return this.b.Q1().getRooms();
  }
  
  @SuppressLint({"CheckResult"})
  private void g(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = f().iterator();
    while (((Iterator)localObject).hasNext())
    {
      RoomInfo localRoomInfo = (RoomInfo)((Iterator)localObject).next();
      if (TextUtils.equals(localRoomInfo.getName(), paramString2))
      {
        localObject = localRoomInfo.getId();
        bool = false;
        break label64;
      }
    }
    localObject = null;
    boolean bool = true;
    label64:
    this.c.b1(paramString3, paramString1, (String)localObject, paramString2, bool, true).y();
  }
  
  @SuppressLint({"CheckResult"})
  public void h(String paramString1, String paramString2)
  {
    String str;
    if (this.b.Q1() != null) {
      str = this.b.Q1().getId();
    } else {
      str = null;
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud set room");
        g(str, paramString1, paramString2);
      }
      return;
    }
    b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud return");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraSaveSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */