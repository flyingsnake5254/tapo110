package com.tplink.iot.viewmodel.iotcommon;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.w;
import com.tplink.iot.g.d.a.b;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumButtonAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumContactSensorAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHubAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumSensorAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumTRVAvatarType;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.List;

public class IoTSettingAvatarViewModel
  extends AndroidViewModel
{
  private AbstractThingRepository a;
  private AbstractSubThingRepository b;
  private EnumDeviceType c = EnumDeviceType.PLUG;
  private String d;
  private final ThingContext e;
  private boolean f = false;
  private SingleLiveEvent<Integer> g = new SingleLiveEvent();
  
  public IoTSettingAvatarViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.e = paramThingContext;
    if (paramThingContext.getIoTDevice() != null)
    {
      this.c = EnumDeviceType.fromType(((ALIoTDevice)paramThingContext.getIoTDevice()).getDeviceType());
      this.d = ((ALIoTDevice)paramThingContext.getIoTDevice()).getDeviceModel();
      this.f = ((ALIoTDevice)paramThingContext.getIoTDevice()).isSubDevice();
    }
    paramApplication = com.tplink.libtpnetwork.IoTNetwork.util.c.a(paramThingContext);
    if ((paramApplication instanceof AbstractThingRepository)) {
      this.a = ((AbstractThingRepository)paramApplication);
    } else if ((paramApplication instanceof AbstractSubThingRepository)) {
      this.b = ((AbstractSubThingRepository)paramApplication);
    } else {
      this.a = ((AbstractThingRepository)e.a(paramThingContext, PlugRepository.class));
    }
    paramThingContext = new StringBuilder();
    paramThingContext.append("ThingRepository class: ");
    if (paramApplication != null) {
      paramApplication = paramApplication.getClass().getSimpleName();
    } else {
      paramApplication = "";
    }
    paramThingContext.append(paramApplication);
    b.d.w.c.a.e("DeviceCommon", paramThingContext.toString());
  }
  
  public String g()
  {
    boolean bool = this.f;
    LocalIoTBaseDevice localLocalIoTBaseDevice = null;
    Object localObject;
    if (bool)
    {
      localObject = this.b;
      if (localObject != null) {
        localLocalIoTBaseDevice = (LocalIoTBaseDevice)((AbstractSubThingRepository)localObject).Y0().getValue();
      }
    }
    else
    {
      localObject = this.a;
      if (localObject != null) {
        localLocalIoTBaseDevice = (LocalIoTBaseDevice)((AbstractThingRepository)localObject).j1().getValue();
      }
    }
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.getAvatar();
    }
    return "";
  }
  
  public List<String> h()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.c;
    if (localObject != null)
    {
      int i = c.a[localObject.ordinal()];
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      int i4 = 0;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                EnumIoTAvatarType[] arrayOfEnumIoTAvatarType = EnumIoTAvatarType.values();
                j = arrayOfEnumIoTAvatarType.length;
                while (i4 < j)
                {
                  localObject = arrayOfEnumIoTAvatarType[i4];
                  if ((!com.tplink.iot.Utils.w0.a.c(this.e.getDeviceIdMD5())) || (w.e((EnumIoTAvatarType)localObject))) {
                    localArrayList.add(((EnumIoTAvatarType)localObject).getName());
                  }
                  i4++;
                }
              }
              if (b.l(this.d))
              {
                localObject = EnumTRVAvatarType.values();
                k = localObject.length;
                for (i4 = j; i4 < k; i4++) {
                  localArrayList.add(localObject[i4].getValue());
                }
              }
            }
            else if ("S210".equals(this.d))
            {
              localArrayList.addAll(EnumSwitchAvatarType.getS210AvatarNames());
            }
            else
            {
              localArrayList.addAll(EnumSwitchAvatarType.getS220AvatarNames());
            }
          }
          else
          {
            if ("T110".equals(this.d))
            {
              localObject = EnumContactSensorAvatarType.values();
              j = localObject.length;
              for (i4 = k; i4 < j; i4++) {
                localArrayList.add(localObject[i4].getValue());
              }
            }
            if ("S200B".equals(this.d))
            {
              localObject = EnumButtonAvatarType.values();
              j = localObject.length;
              for (i4 = m; i4 < j; i4++) {
                localArrayList.add(localObject[i4].getValue());
              }
            }
            localObject = EnumSensorAvatarType.values();
            j = localObject.length;
            for (i4 = n; i4 < j; i4++) {
              localArrayList.add(localObject[i4].getValue());
            }
          }
        }
        else
        {
          localObject = EnumHubAvatarType.values();
          j = localObject.length;
          for (i4 = i1; i4 < j; i4++) {
            localArrayList.add(localObject[i4].getName());
          }
        }
      }
      else
      {
        if (com.tplink.iot.g.b.c.c.i(this.d))
        {
          localObject = EnumLightStripAvatarType.values();
          j = localObject.length;
          for (i4 = i2; i4 < j; i4++) {
            localArrayList.add(localObject[i4].getValue());
          }
        }
        localObject = EnumBulbAvatarType.values();
        j = localObject.length;
        for (i4 = i3; i4 < j; i4++) {
          localArrayList.add(localObject[i4].getName());
        }
      }
    }
    return localArrayList;
  }
  
  @Nullable
  public String i()
  {
    return this.d;
  }
  
  public EnumDeviceType j()
  {
    return this.c;
  }
  
  @SuppressLint({"CheckResult"})
  public void k(String paramString)
  {
    Object localObject;
    if (this.f)
    {
      localObject = this.b;
      if (localObject != null) {
        paramString = ((AbstractSubThingRepository)localObject).T3(paramString);
      } else {
        paramString = io.reactivex.a.m(new Throwable("Null Device Repository"));
      }
    }
    else
    {
      localObject = this.a;
      if (localObject != null) {
        paramString = ((AbstractThingRepository)localObject).F4(paramString);
      } else {
        paramString = io.reactivex.a.m(new Throwable("Null Device Repository"));
      }
    }
    paramString.r(io.reactivex.d0.b.a.a()).A(new a(), new b());
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a() {}
    
    public void run()
      throws Exception
    {
      IoTSettingAvatarViewModel.f(IoTSettingAvatarViewModel.this).postValue(Integer.valueOf(0));
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (w.d(paramThrowable)) {
        w.f();
      } else {
        IoTSettingAvatarViewModel.f(IoTSettingAvatarViewModel.this).postValue(Integer.valueOf(-1));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotcommon\IoTSettingAvatarViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */