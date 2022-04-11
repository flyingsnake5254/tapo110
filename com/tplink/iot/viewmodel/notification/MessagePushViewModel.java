package com.tplink.iot.viewmodel.notification;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.cloud.bean.push.params.UnsubscribeMsgParams;
import com.tplink.iot.Utils.p;
import com.tplink.iot.model.notification.DeviceNotificationBean;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.SubscribeItemBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.model.h;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MsgPushRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessagePushViewModel
  extends AndroidViewModel
{
  private TPIoTClientManager a;
  private TCMessagePushRepository b;
  private MediatorLiveData<List<BaseALIoTDevice>> c = new MediatorLiveData();
  
  public MessagePushViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.b = ((TCMessagePushRepository)b.a(paramApplication, TCMessagePushRepository.class));
    paramApplication = (TPIoTClientManager)b.a(paramApplication, TPIoTClientManager.class);
    this.a = paramApplication;
    this.c.addSource(paramApplication.C1(), new a());
  }
  
  private SubscribeItemBean h(String paramString)
  {
    return this.b.E(paramString);
  }
  
  private int j(BaseALIoTDevice paramBaseALIoTDevice)
  {
    boolean bool = paramBaseALIoTDevice.isCamera();
    int i = 0;
    if (bool) {
      i = 1;
    } else if (paramBaseALIoTDevice.isPlug())
    {
      if (((ALIoTDevice)paramBaseALIoTDevice).isPlugP105OfJP()) {
        i = 2;
      }
    }
    else if (!paramBaseALIoTDevice.isSwitch()) {
      if (paramBaseALIoTDevice.isHub()) {
        i = 4;
      } else if ((paramBaseALIoTDevice.isSensor()) && (!TextUtils.equals(paramBaseALIoTDevice.getCategory(), EnumIoTCategory.SUBG_TRIGGER_BUTTON.value()))) {
        i = 5;
      } else if (paramBaseALIoTDevice.isEnergy()) {
        i = 6;
      }
    }
    return i;
  }
  
  private boolean p(String paramString)
  {
    paramString = h(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.isSubscribeCameraMotion())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private q<Boolean> t(String paramString)
  {
    q localq = q.f0(Boolean.TRUE);
    String str = b.d.w.h.a.g(paramString);
    Object localObject = TPIoTClientManager.I1(str);
    paramString = localq;
    if ((localObject instanceof ALCameraDevice))
    {
      localObject = ((ALCameraDevice)localObject).getCameraComponent();
      paramString = localq;
      if (localObject != null)
      {
        paramString = localq;
        if (((CameraComponent)localObject).isSupportMsgPush())
        {
          paramString = (MsgPushRepository)e.c(str, MsgPushRepository.class);
          paramString = paramString.D(true, paramString.v().d());
        }
      }
    }
    return paramString;
  }
  
  public MediatorLiveData<List<BaseALIoTDevice>> g()
  {
    return this.c;
  }
  
  public List<BaseALIoTDevice> i(List<BaseALIoTDevice> paramList, int paramInt)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (BaseALIoTDevice)localIterator.next();
      if (j(paramList) == paramInt) {
        localArrayList.add(paramList);
      }
    }
    return localArrayList;
  }
  
  public boolean k(List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (BaseALIoTDevice)localIterator.next();
        if ((paramList.isCamera()) && (paramList.getCloudIoTDevice() != null)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean l(List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (BaseALIoTDevice)localIterator.next();
        if ((paramList.isHasThingOrCloudDevice()) && (j(paramList) != 0)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean m()
  {
    return o.h0().e0();
  }
  
  public boolean n()
  {
    return o.h0().b0();
  }
  
  public boolean o()
  {
    return o.h0().c0();
  }
  
  public void u(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (!paramBoolean) {
      localArrayList.add("marketPromotion");
    }
    o.h0().h1(paramBoolean);
    p.b(localArrayList);
    UnsubscribeMsgParams localUnsubscribeMsgParams = new UnsubscribeMsgParams();
    localUnsubscribeMsgParams.setMsgTypes(localArrayList);
    this.b.T(localUnsubscribeMsgParams).F0();
  }
  
  public void v(List<BaseALIoTDevice> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    o.h0().i1(paramBoolean);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localIterator.next();
      SubscribeItemBean localSubscribeItemBean = new SubscribeItemBean(localBaseALIoTDevice.getDeviceId());
      paramList = h(localBaseALIoTDevice.getDeviceId());
      if (paramList != null) {
        localSubscribeItemBean.setDeviceSubscribeOffBit(paramList.getDeviceSubscribeOffBit());
      }
      localArrayList1.add(localBaseALIoTDevice.getDeviceId());
      localArrayList2.add(localSubscribeItemBean);
    }
    this.b.R(localArrayList1, localArrayList2).y();
  }
  
  public void w(String paramString, EnumMsgSubscribeType paramEnumMsgSubscribeType, boolean paramBoolean1, boolean paramBoolean2)
  {
    SubscribeItemBean localSubscribeItemBean1 = new SubscribeItemBean(paramString);
    SubscribeItemBean localSubscribeItemBean2 = h(paramString);
    if (localSubscribeItemBean2 != null) {
      localSubscribeItemBean1.setDeviceSubscribeOffBit(localSubscribeItemBean2.getDeviceSubscribeOffBit());
    }
    if (paramBoolean1) {
      localSubscribeItemBean1.addSubscribeFunc(paramEnumMsgSubscribeType);
    } else {
      localSubscribeItemBean1.removeSubscribeFunc(paramEnumMsgSubscribeType);
    }
    this.b.S(paramString, localSubscribeItemBean1).F(new a(this, paramBoolean2, paramBoolean1, paramString)).F0();
  }
  
  public void x(List<BaseALIoTDevice> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    o.h0().g1(paramBoolean);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
      SubscribeItemBean localSubscribeItemBean1 = new SubscribeItemBean(localBaseALIoTDevice.getDeviceId());
      SubscribeItemBean localSubscribeItemBean2 = h(localBaseALIoTDevice.getDeviceId());
      if (localSubscribeItemBean2 != null) {
        localSubscribeItemBean1.setDeviceSubscribeOffBit(localSubscribeItemBean2.getDeviceSubscribeOffBit());
      }
      localArrayList1.add(localBaseALIoTDevice.getDeviceId());
      localArrayList2.add(localSubscribeItemBean1);
    }
    this.b.R(localArrayList1, localArrayList2).y();
  }
  
  public List<DeviceNotificationBean> y(List<BaseALIoTDevice> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
      localArrayList.add(new DeviceNotificationBean(localBaseALIoTDevice, p(localBaseALIoTDevice.getDeviceId())));
    }
    return localArrayList;
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
          if ((localBaseALIoTDevice != null) && ((localBaseALIoTDevice.getCloudIoTDevice() != null) || (localBaseALIoTDevice.getThingDevice() != null))) {
            localArrayList.add(localBaseALIoTDevice);
          }
        }
      }
      MessagePushViewModel.f(MessagePushViewModel.this).postValue(localArrayList);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\notification\MessagePushViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */