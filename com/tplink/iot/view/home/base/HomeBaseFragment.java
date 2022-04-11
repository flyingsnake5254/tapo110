package com.tplink.iot.view.home.base;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.d;
import com.tplink.iot.Utils.TPLongThreeMaterialDialog.Builder;
import com.tplink.iot.Utils.TPLongThreeMaterialDialog.e;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.v0.d;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.devices.switches.view.SwitchDetailActivity;
import com.tplink.iot.devices.trv.view.TRVDetailActivity;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.k;
import com.tplink.iot.view.deviceshare.AddShareDeviceActivity;
import com.tplink.iot.view.deviceshare.DeviceShareHelpActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.group.detail.GroupAddDeviceListActivity;
import com.tplink.iot.view.group.detail.GroupDetailColorBulbActivity;
import com.tplink.iot.view.home.DeviceMoveActivity;
import com.tplink.iot.view.iothub.HubDetailActivity;
import com.tplink.iot.view.iotplug.PlugDetailActivity;
import com.tplink.iot.view.iotsensor.SensorDetailActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.widget.ListContentDialog.e;
import com.tplink.iot.widget.ListContentLongDialog.e;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class HomeBaseFragment
  extends BaseFragment
{
  private long q = 0L;
  
  private void B1()
  {
    L1(getString(2131952830), getString(2131953925));
  }
  
  private void C1(List<BaseALIoTDevice> paramList, String paramString1, String paramString2)
  {
    u.t(getActivity(), paramList, paramString1, paramString2);
  }
  
  private void D1(List<BaseALIoTDevice> paramList)
  {
    C1(paramList, getString(2131952838), getString(2131952839));
  }
  
  private void E1()
  {
    L1(getString(2131952838), getString(2131953925));
  }
  
  private void F1(List<BaseALIoTDevice> paramList)
  {
    u.r(getActivity(), paramList, new g());
  }
  
  private void G1(final List<BaseALIoTDevice> paramList)
  {
    u.u(getActivity(), paramList, getString(2131953924), getString(2131953909), new h(paramList));
  }
  
  private void H1(final BaseALIoTDevice paramBaseALIoTDevice)
  {
    u.B(getActivity(), paramBaseALIoTDevice.getDeviceType(), new d(paramBaseALIoTDevice));
  }
  
  private void I1()
  {
    u.A(getActivity(), getString(2131952532));
  }
  
  private void J1()
  {
    u.z(getActivity(), getString(2131952567));
  }
  
  private void K1()
  {
    u.A(getActivity(), getString(2131952533));
  }
  
  private void L1(String paramString1, String paramString2)
  {
    u.C(getActivity(), paramString1, paramString2);
  }
  
  private void M1()
  {
    u.z(getActivity(), getString(2131953238));
  }
  
  private void Q0(List<BaseALIoTDevice> paramList)
  {
    AddShareDeviceActivity.D1(getActivity(), paramList);
    O0();
  }
  
  private void S0(BaseALIoTDevice<?> paramBaseALIoTDevice, String paramString)
  {
    if (paramBaseALIoTDevice.isSensor()) {
      SensorDetailActivity.D1(requireActivity(), paramString);
    } else if (paramBaseALIoTDevice.isSwitch()) {
      SwitchDetailActivity.R1(requireActivity(), paramString);
    } else if (com.tplink.iot.g.d.a.b.k(paramBaseALIoTDevice)) {
      TRVDetailActivity.e2(requireActivity(), paramString);
    }
  }
  
  private void T0(BaseALIoTDevice paramBaseALIoTDevice)
  {
    ShareDeviceUserListActivity.v1(getActivity(), paramBaseALIoTDevice.getDeviceIdMD5());
    O0();
  }
  
  private void W0(List<e> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (e)localIterator.next();
      if ((localObject instanceof k))
      {
        k localk = (k)localObject;
        localObject = localk.g();
        if (localObject != null)
        {
          if (j1(localk)) {
            localArrayList1.add(localObject);
          }
          if (((BaseALIoTDevice)localObject).getThingDevice() == null) {
            localArrayList2.add(localObject);
          }
        }
      }
    }
    if (!localArrayList1.isEmpty())
    {
      u.i(getActivity(), localArrayList1, null, getString(2131952538));
      return;
    }
    if (localArrayList2.size() > 0) {
      w1(localArrayList2);
    } else {
      n1(paramList);
    }
  }
  
  private void Z0(e parame)
  {
    if ((parame instanceof k)) {
      a1((k)parame);
    } else if ((parame instanceof com.tplink.iot.model.home.g)) {
      b1((com.tplink.iot.model.home.g)parame);
    }
  }
  
  private void a1(k paramk)
  {
    if (j1(paramk))
    {
      I1();
      return;
    }
    if ((paramk.g() != null) && (paramk.g().getThingDevice() != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramk);
      n1(localArrayList);
    }
    else
    {
      B1();
    }
  }
  
  private void b1(com.tplink.iot.model.home.g paramg)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramg);
    n1(localArrayList);
  }
  
  private void c1(List<e> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (e)localIterator.next();
      if ((localObject instanceof k))
      {
        localObject = (k)localObject;
        BaseALIoTDevice localBaseALIoTDevice = ((k)localObject).g();
        if (localBaseALIoTDevice != null)
        {
          if (j1((k)localObject)) {
            localArrayList1.add(localBaseALIoTDevice);
          }
          if (localBaseALIoTDevice.getThingDevice() == null) {
            localArrayList2.add(localBaseALIoTDevice);
          }
        }
      }
    }
    if (!localArrayList1.isEmpty())
    {
      u.i(getActivity(), localArrayList1, null, getString(2131952539));
      return;
    }
    if (localArrayList2.size() > 0) {
      D1(localArrayList2);
    } else {
      q1(paramList);
    }
  }
  
  private void d1(e parame)
  {
    if ((parame instanceof k)) {
      e1((k)parame);
    } else if ((parame instanceof com.tplink.iot.model.home.g)) {
      f1((com.tplink.iot.model.home.g)parame);
    }
  }
  
  private void e1(k paramk)
  {
    if (j1(paramk))
    {
      K1();
      return;
    }
    if ((paramk.g() != null) && (paramk.g().getThingDevice() != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramk);
      q1(localArrayList);
    }
    else
    {
      E1();
    }
  }
  
  private void f1(com.tplink.iot.model.home.g paramg)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramg);
    q1(localArrayList);
  }
  
  private void g1(List<k> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (k)((Iterator)localObject1).next();
      if ((((k)localObject2).g() != null) && (((k)localObject2).v()))
      {
        localArrayList1.add(((k)localObject2).g());
        if (((k)localObject2).g().isDeviceOffLine()) {
          localArrayList2.add(((k)localObject2).g());
        }
      }
    }
    if (!localArrayList1.isEmpty())
    {
      if (localArrayList1.size() == localArrayList2.size()) {
        u.e(getActivity(), localArrayList1, getString(2131953924), getString(2131953238));
      } else {
        u.e(getActivity(), localArrayList1, getString(2131953924), getString(2131952568));
      }
      return;
    }
    localArrayList2 = new ArrayList();
    localObject1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (k)paramList.next();
      if (((k)localObject2).g() != null) {
        if (((k)localObject2).g().isHasThingOrCloudDevice()) {
          localArrayList2.add(((k)localObject2).g());
        } else {
          ((List)localObject1).add(((k)localObject2).g());
        }
      }
    }
    if (!((List)localObject1).isEmpty())
    {
      G1((List)localObject1);
    }
    else
    {
      paramList = new ArrayList();
      localObject2 = localArrayList2.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (BaseALIoTDevice)((Iterator)localObject2).next();
        if ((((BaseALIoTDevice)localObject1).getDeviceManagerInfo() != null) && (((BaseALIoTDevice)localObject1).getDeviceManagerInfo().getUserInfo() != null) && (((BaseALIoTDevice)localObject1).getDeviceManagerInfo().getUserInfo().size() > com.tplink.iot.view.deviceshare.a.d(((BaseALIoTDevice)localObject1).getDeviceType()))) {
          paramList.add(localObject1);
        }
      }
      if (!paramList.isEmpty()) {
        F1(paramList);
      } else {
        v1(localArrayList2);
      }
    }
  }
  
  private void h1(k paramk)
  {
    if (paramk.v())
    {
      if ((paramk.g() != null) && (paramk.g().isDeviceOffLine())) {
        M1();
      } else {
        J1();
      }
      return;
    }
    if ((paramk.g() != null) && (paramk.g().isHasThingOrCloudDevice()))
    {
      Object localObject = paramk.g().getDeviceManagerInfo();
      if ((((DeviceManagerInfoBean)localObject).getUserInfo() != null) && (((DeviceManagerInfoBean)localObject).getUserInfo().size() > com.tplink.iot.view.deviceshare.a.d(paramk.g().getDeviceType())))
      {
        H1(paramk.g());
      }
      else
      {
        localObject = new ArrayList();
        ((List)localObject).add(paramk.g());
        v1((List)localObject);
      }
    }
    else
    {
      x1(paramk);
    }
  }
  
  private boolean i1(List<BaseALIoTDevice> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((BaseALIoTDevice)paramList.next()).isCamera()) {
        return true;
      }
    }
    return false;
  }
  
  private boolean j1(k paramk)
  {
    return paramk.r() ^ true;
  }
  
  private void m1(List<String> paramList1, List<String> paramList2)
  {
    FamilyInfo localFamilyInfo = P0();
    if ((localFamilyInfo != null) && (!TextUtils.isEmpty(localFamilyInfo.getId())) && ((!paramList1.isEmpty()) || (!paramList2.isEmpty()))) {
      DeviceMoveActivity.p1(getContext(), localFamilyInfo.getId(), paramList1, paramList2);
    }
    O0();
  }
  
  private void n1(List<e> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (e)paramList.next();
      if ((localObject instanceof k))
      {
        localObject = ((k)localObject).h();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList1.add(localObject);
        }
      }
      else if ((localObject instanceof com.tplink.iot.model.home.g))
      {
        localObject = ((com.tplink.iot.model.home.g)localObject).i();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList2.add(localObject);
        }
      }
    }
    m1(localArrayList1, localArrayList2);
  }
  
  private void v1(final List<BaseALIoTDevice> paramList)
  {
    if (i1(paramList)) {
      u.h(getActivity(), new f(paramList));
    } else {
      Q0(paramList);
    }
  }
  
  private void w1(List<BaseALIoTDevice> paramList)
  {
    C1(paramList, getString(2131952830), getString(2131952831));
  }
  
  private void x1(final k paramk)
  {
    u.D(getActivity(), getString(2131953924), getString(2131953925), new e(paramk));
  }
  
  private void y1(final com.tplink.iot.model.home.g paramg)
  {
    new TPLongThreeMaterialDialog.Builder(getActivity()).f(2131952820, 2131099799).k(2131952821, 2131099808, new b(paramg)).m(2131952822, 2131099812, new a(paramg)).h(2131952391, 2131099804, null).b(false).c(false).d(8, 8).t();
  }
  
  private void z1()
  {
    new TPMaterialDialogV2.Builder(getActivity()).i(2131952778, 2131099799).o(2131951761, 2131099812, null).b(false).c(false).g(8, 8).y();
  }
  
  protected void A1(final List<e> paramList)
  {
    String str = getString(2131952827);
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if ((locale instanceof com.tplink.iot.model.home.g)) {
        j = 1;
      } else if ((locale instanceof k)) {
        i = 1;
      }
    }
    if ((i != 0) && (j != 0)) {
      str = getString(2131952840);
    } else if (j != 0) {
      str = getString(2131952841);
    } else if (i != 0) {
      str = getString(2131952827);
    }
    new TPMaterialDialogV2.Builder(getActivity()).k(str, 2131099799).o(2131952451, 2131099812, new c(paramList)).l(2131952391, 2131099804, null).b(false).c(false).g(8, 8).y();
  }
  
  public abstract void J0(List<e> paramList);
  
  protected void K0(List<e> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (e)localIterator.next();
      Object localObject;
      if ((paramList instanceof k))
      {
        localObject = ((k)paramList).g();
        if ((localObject != null) && (((BaseALIoTDevice)localObject).isSupportIoTCloud()) && (!((BaseALIoTDevice)localObject).isCommonDevice())) {
          localArrayList.add(paramList);
        }
      }
      else if ((paramList instanceof com.tplink.iot.model.home.g))
      {
        localObject = ((com.tplink.iot.model.home.g)paramList).h();
        if ((localObject != null) && (!((GroupBean)localObject).isCommon())) {
          localArrayList.add(paramList);
        }
      }
    }
    if (!localArrayList.isEmpty()) {
      J0(localArrayList);
    }
    O0();
  }
  
  protected void L0(List<e> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    if (paramList.size() == 1) {
      Z0((e)paramList.get(0));
    } else {
      W0(paramList);
    }
  }
  
  protected void N0(List<e> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    if (paramList.size() == 1) {
      d1((e)paramList.get(0));
    } else {
      c1(paramList);
    }
  }
  
  public abstract void O0();
  
  public abstract FamilyInfo P0();
  
  public boolean R0(BaseALIoTDevice paramBaseALIoTDevice)
  {
    String str = paramBaseALIoTDevice.getDeviceIdMD5();
    if (paramBaseALIoTDevice.isCamera())
    {
      if (!u.E(getActivity(), str, getFragmentManager()))
      {
        long l = System.currentTimeMillis();
        if (Math.abs(l - this.q) < 500L) {
          return false;
        }
        this.q = l;
        h.q(getActivity(), str);
        return true;
      }
      return false;
    }
    if (paramBaseALIoTDevice.isBulb())
    {
      com.tplink.iot.Utils.z0.g.h(getActivity(), str);
      return true;
    }
    if (paramBaseALIoTDevice.isHub())
    {
      HubDetailActivity.K1(getActivity(), str);
      return true;
    }
    if (paramBaseALIoTDevice.isSubDevice())
    {
      S0(paramBaseALIoTDevice, str);
      return true;
    }
    PlugDetailActivity.K1(getActivity(), str);
    return true;
  }
  
  protected void U0(k paramk)
  {
    BaseALIoTDevice localBaseALIoTDevice = paramk.g();
    if (localBaseALIoTDevice == null) {
      return;
    }
    paramk = localBaseALIoTDevice.getDeviceIdMD5();
    if (TextUtils.isEmpty(paramk)) {
      return;
    }
    s1(false, paramk);
    Object localObject;
    if ((localBaseALIoTDevice instanceof ALCameraDevice))
    {
      localObject = (ALCameraDevice)localBaseALIoTDevice;
      if (((ALCameraDevice)localObject).isCameraLocked())
      {
        u.f(getActivity(), ((ALCameraDevice)localObject).getLockMessage());
        return;
      }
    }
    if (localBaseALIoTDevice.isOnline())
    {
      if (R0(localBaseALIoTDevice)) {
        p1();
      }
    }
    else if (localBaseALIoTDevice.isDeviceOffLine())
    {
      localObject = localBaseALIoTDevice.getDeviceId();
      if ((localBaseALIoTDevice.isCamera()) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!localBaseALIoTDevice.isUserRoleTypeDevice()) && (d.e(paramk)) && (d.d())) {
        u.d(getActivity(), localBaseALIoTDevice.getDeviceType(), localBaseALIoTDevice.getDeviceModel(), localBaseALIoTDevice.getDeviceHwVer(), (String)localObject);
      } else {
        u.j(getActivity(), localBaseALIoTDevice.getDeviceType(), localBaseALIoTDevice.getDeviceModel(), localBaseALIoTDevice.getDeviceHwVer());
      }
      k1(paramk);
    }
  }
  
  protected void V0(com.tplink.iot.model.home.g paramg)
  {
    GroupBean localGroupBean = paramg.h();
    if ((localGroupBean != null) && (!TextUtils.isEmpty(localGroupBean.getGroupId()))) {
      if ((!localGroupBean.isOnline()) && (!localGroupBean.isPartOffline()))
      {
        if (localGroupBean.isOffLine()) {
          z1();
        } else if (localGroupBean.isEmpty()) {
          y1(paramg);
        }
      }
      else {
        GroupDetailColorBulbActivity.z1(getContext(), localGroupBean.getGroupId());
      }
    }
  }
  
  protected void X0(k paramk, boolean paramBoolean)
  {
    BaseALIoTDevice localBaseALIoTDevice = paramk.g();
    if (localBaseALIoTDevice == null) {
      return;
    }
    paramk = localBaseALIoTDevice.getDeviceIdMD5();
    if (TextUtils.isEmpty(paramk)) {
      return;
    }
    t1(paramk, paramBoolean);
    localBaseALIoTDevice.setDeviceOn(paramBoolean);
    o1();
    l1(localBaseALIoTDevice, paramBoolean);
  }
  
  protected void Y0(com.tplink.iot.model.home.g paramg, boolean paramBoolean)
  {
    if ((paramg != null) && (paramg.h() != null))
    {
      paramg = paramg.h();
      if (paramg == null) {
        return;
      }
      ((GroupRepository)b.d.b.f.b.a(b.d.s.a.a.f(), GroupRepository.class)).u0(paramg.getGroupId(), paramBoolean);
    }
  }
  
  protected abstract void k1(String paramString);
  
  protected abstract void l1(BaseALIoTDevice paramBaseALIoTDevice, boolean paramBoolean);
  
  protected abstract void o1();
  
  protected abstract void p1();
  
  public abstract void q1(List<e> paramList);
  
  public abstract void r1(List<e> paramList);
  
  protected abstract void s1(boolean paramBoolean, String paramString);
  
  protected abstract void t1(String paramString, boolean paramBoolean);
  
  protected void u1(List<e> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e locale = (e)paramList.next();
      if ((locale instanceof k)) {
        localArrayList.add((k)locale);
      } else {
        b.d.w.c.a.d("bean is not device");
      }
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    if (localArrayList.size() == 1) {
      h1((k)localArrayList.get(0));
    } else {
      g1(localArrayList);
    }
  }
  
  class a
    implements TPLongThreeMaterialDialog.e
  {
    a(com.tplink.iot.model.home.g paramg) {}
    
    public void onClick(View paramView)
    {
      paramView = new ArrayList();
      paramView.add(paramg);
      HomeBaseFragment.this.r1(paramView);
    }
  }
  
  class b
    implements TPLongThreeMaterialDialog.e
  {
    b(com.tplink.iot.model.home.g paramg) {}
    
    public void onClick(View paramView)
    {
      GroupAddDeviceListActivity.r1(HomeBaseFragment.this.getContext(), paramg.i());
    }
  }
  
  class c
    implements TPMaterialDialogV2.d
  {
    c(List paramList) {}
    
    public void onClick(View paramView)
    {
      HomeBaseFragment.this.r1(paramList);
      HomeBaseFragment.this.O0();
    }
  }
  
  class d
    implements TPLongMaterialDialogV2.d
  {
    d(BaseALIoTDevice paramBaseALIoTDevice) {}
    
    public void onClick(View paramView)
    {
      HomeBaseFragment.H0(HomeBaseFragment.this, paramBaseALIoTDevice);
    }
  }
  
  class e
    implements TPMaterialDialogV2.d
  {
    e(k paramk) {}
    
    public void onClick(View paramView)
    {
      ArrayList localArrayList = new ArrayList();
      paramView = paramk;
      if ((paramView != null) && (paramView.g() != null)) {
        localArrayList.add(paramk.g());
      }
      DeviceShareHelpActivity.h1(HomeBaseFragment.this.getActivity(), localArrayList, 3);
      HomeBaseFragment.this.O0();
    }
  }
  
  class f
    implements TPMaterialDialogV2.d
  {
    f(List paramList) {}
    
    public void onClick(View paramView)
    {
      HomeBaseFragment.I0(HomeBaseFragment.this, paramList);
    }
  }
  
  class g
    implements ListContentLongDialog.e
  {
    g() {}
    
    public void dismiss()
    {
      HomeBaseFragment.this.C0(ShareDeviceActivity.class);
      HomeBaseFragment.this.O0();
    }
  }
  
  class h
    implements ListContentDialog.e
  {
    h(List paramList) {}
    
    public void dismiss()
    {
      DeviceShareHelpActivity.h1(HomeBaseFragment.this.getActivity(), paramList, 3);
      HomeBaseFragment.this.O0();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\base\HomeBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */