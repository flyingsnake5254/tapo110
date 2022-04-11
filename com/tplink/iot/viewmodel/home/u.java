package com.tplink.iot.viewmodel.home;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.f.b;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.d;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.view.cloudvideo.CloudVideoListActivity;
import com.tplink.iot.view.home.DeviceOfflineTroubleshootingActivity;
import com.tplink.iot.view.ipcamera.play.CameraUpdatingDialogFragment;
import com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog;
import com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog.a;
import com.tplink.iot.view.ipcamera.setting.firmware.FirmwareUpdateNewIpcActivity;
import com.tplink.iot.widget.ListContentDialog;
import com.tplink.iot.widget.ListContentDialog.Builder;
import com.tplink.iot.widget.ListContentDialog.e;
import com.tplink.iot.widget.ListContentLongDialog;
import com.tplink.iot.widget.ListContentLongDialog.Builder;
import com.tplink.iot.widget.ListContentLongDialog.e;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareUpdateLevel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class u
{
  private static WeakReference<CameraUpdatingDialogFragment> a;
  private static WeakReference<ForcedUpdateFwDialog> b;
  
  public static void A(Activity paramActivity, String paramString)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = new TPMaterialDialogV2.Builder(paramActivity);
    paramActivity.j(paramString);
    paramActivity.c(false);
    paramActivity.b(false);
    paramActivity.o(2131953902, 2131099808, null);
    paramActivity.g(8, 8);
    paramActivity.a().show();
  }
  
  public static void B(Activity paramActivity, String paramString, TPLongMaterialDialogV2.d paramd)
  {
    y(paramActivity, paramString, 2131953924, paramd);
  }
  
  public static void C(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = new TPMaterialDialogV2.Builder(paramActivity);
    paramActivity.t(paramString1);
    paramActivity.j(paramString2);
    paramActivity.c(false);
    paramActivity.b(false);
    paramActivity.o(2131953902, 2131099804, null);
    paramActivity.g(8, 8);
    paramActivity.a().show();
  }
  
  public static void D(Activity paramActivity, String paramString1, String paramString2, TPMaterialDialogV2.d paramd)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = new TPMaterialDialogV2.Builder(paramActivity);
    paramActivity.t(paramString1);
    paramActivity.j(paramString2);
    paramActivity.c(false);
    paramActivity.b(false);
    paramActivity.o(2131953908, 2131099808, paramd);
    paramActivity.l(2131953902, 2131099804, null);
    paramActivity.g(8, 8);
    paramActivity.a().show();
  }
  
  public static boolean E(Activity paramActivity, String paramString, FragmentManager paramFragmentManager)
  {
    com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u localu = ((FirmwareManager)b.a(b.d.s.a.a.f(), FirmwareManager.class)).g(paramString);
    if (localu != null)
    {
      if (!localu.f())
      {
        s(paramFragmentManager);
        return true;
      }
      if (localu.b() == FirmwareUpdateLevel.LEVEL4)
      {
        q(paramActivity, paramString, paramFragmentManager);
        return true;
      }
    }
    return false;
  }
  
  private static void b(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, CloudVideoListActivity.class);
    localIntent.putExtra("cloud_video_device_id", paramString);
    paramActivity.startActivity(localIntent);
  }
  
  private static void c(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramActivity == null) {
      return;
    }
    String str = paramActivity.getString(2131952534);
    if ((paramBoolean2) && (paramBoolean1)) {
      str = paramActivity.getString(2131952536);
    } else if (paramBoolean1) {
      str = paramActivity.getString(2131952535);
    }
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(paramActivity);
    localBuilder.t(paramActivity.getString(2131952675));
    localBuilder.j(str);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.o(2131953902, 2131099808, null);
    localBuilder.g(8, 8);
    localBuilder.a().show();
  }
  
  public static void d(final Activity paramActivity, final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    if (paramActivity == null) {
      return;
    }
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(paramActivity);
    TPMaterialDialogV2 localTPMaterialDialogV2 = localBuilder.a();
    View localView = LayoutInflater.from(paramActivity).inflate(2131559109, null, false);
    localView.findViewById(2131364402).setOnClickListener(new c(localTPMaterialDialogV2, paramActivity, paramString1, paramString2, paramString3));
    localView.findViewById(2131364372).setOnClickListener(new d(localTPMaterialDialogV2, paramActivity, paramString4));
    localView.findViewById(2131364359).setOnClickListener(new e(localTPMaterialDialogV2));
    localBuilder.e(localView);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.g(8, 8);
    localTPMaterialDialogV2.show();
  }
  
  public static void e(Activity paramActivity, List<BaseALIoTDevice> paramList, String paramString1, String paramString2)
  {
    i(paramActivity, paramList, paramString1, paramString2);
  }
  
  public static void f(Activity paramActivity, String paramString)
  {
    g(paramActivity, paramString, null);
  }
  
  public static void g(Activity paramActivity, String paramString, TPMaterialDialogV2.d paramd)
  {
    if (paramActivity == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = paramActivity.getString(2131951753);
    } else {
      paramString = String.format(paramActivity.getString(2131951754), new Object[] { b.d.w.h.a.a(paramString) });
    }
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(paramActivity);
    TPMaterialDialogV2 localTPMaterialDialogV2 = localBuilder.a();
    localBuilder.t(paramActivity.getString(2131951755));
    localBuilder.j(paramString);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.q(paramActivity.getString(2131951752), 2131099808, paramd);
    localBuilder.g(8, 8);
    localTPMaterialDialogV2.show();
  }
  
  public static void h(Activity paramActivity, TPMaterialDialogV2.d paramd)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = new TPMaterialDialogV2.Builder(paramActivity);
    paramActivity.h(2131952052);
    paramActivity.c(false);
    paramActivity.b(false);
    paramActivity.o(2131953902, 2131099808, paramd);
    paramActivity.g(8, 8);
    paramActivity.a().show();
  }
  
  public static void i(Activity paramActivity, List<BaseALIoTDevice> paramList, String paramString1, String paramString2)
  {
    if (paramActivity == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
      localArrayList.add(l.e(paramActivity, localBaseALIoTDevice.getDeviceType(), localBaseALIoTDevice.getDeviceName(), localBaseALIoTDevice.getDeviceModel()));
    }
    paramActivity = new ListContentDialog.Builder(paramActivity).h(paramString1).b(paramString2).g(paramActivity.getString(2131953902)).d(localArrayList).a();
    paramActivity.setCancelable(false);
    paramActivity.show();
  }
  
  public static void j(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    k(paramActivity, paramString1, paramString2, paramString3, null);
  }
  
  public static void k(final Activity paramActivity, final String paramString1, final String paramString2, final String paramString3, @Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (paramActivity == null) {
      return;
    }
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(paramActivity);
    TPMaterialDialogV2 localTPMaterialDialogV2 = localBuilder.a();
    localBuilder.r(2131952575);
    localBuilder.h(2131952541);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.l(2131952391, 2131099804, null);
    localBuilder.o(2131952402, 2131099808, new b(localTPMaterialDialogV2, paramActivity, paramString1, paramString2, paramString3));
    localBuilder.g(8, 8);
    localTPMaterialDialogV2.setOnDismissListener(paramOnDismissListener);
    localTPMaterialDialogV2.show();
  }
  
  public static void l(Activity paramActivity, int paramInt, long paramLong, List<String> paramList, TPMaterialDialogV2.d paramd)
  {
    m(paramActivity, true, paramInt, paramLong, paramList, paramd);
  }
  
  private static void m(Activity paramActivity, boolean paramBoolean, int paramInt, long paramLong, List<String> paramList, TPMaterialDialogV2.d paramd)
  {
    if (paramActivity == null) {
      return;
    }
    Object localObject2;
    if (paramBoolean)
    {
      if ((paramList != null) && (paramList.size() == 1))
      {
        paramList = (ALCameraDevice)TPIoTClientManager.K1(b.d.w.h.a.g((String)paramList.get(0))).getCameraDevice();
        if (paramList != null) {
          paramList = paramList.getDeviceName();
        } else {
          paramList = "";
        }
        paramList = String.format(paramActivity.getString(2131954239), new Object[] { Integer.valueOf(paramInt), b.d.w.a.a.a(paramLong), paramList });
      }
      else if (paramList != null)
      {
        paramList = String.format(paramActivity.getString(2131954238), new Object[] { Integer.valueOf(paramInt), b.d.w.a.a.a(paramLong), Integer.valueOf(paramList.size()) });
      }
      else
      {
        paramList = String.format(paramActivity.getString(2131954238), new Object[] { Integer.valueOf(paramInt), b.d.w.a.a.a(paramLong), Integer.valueOf(0) });
      }
      localObject1 = paramActivity.getString(2131953902);
      localObject2 = paramList;
      paramList = (List<String>)localObject1;
    }
    else
    {
      localObject2 = String.format(paramActivity.getString(2131954240), new Object[] { Integer.valueOf(paramInt) });
      paramList = paramActivity.getString(2131953748);
    }
    paramActivity = new TPMaterialDialogV2.Builder(paramActivity);
    Object localObject1 = paramActivity.a();
    paramActivity.j((String)localObject2);
    paramActivity.c(false);
    paramActivity.b(false);
    paramActivity.q(paramList, 2131099808, paramd);
    paramActivity.g(8, 8);
    ((TPMaterialDialogV2)localObject1).show();
  }
  
  public static void n(Activity paramActivity, int paramInt, TPMaterialDialogV2.d paramd)
  {
    m(paramActivity, false, paramInt, -1L, null, paramd);
  }
  
  public static void o(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!o.h0().g0(paramString))
    {
      o.h0().k1(paramString, true);
      c(paramActivity, paramBoolean1, paramBoolean2);
    }
  }
  
  public static void p(Activity paramActivity, String paramString)
  {
    o(paramActivity, paramString, false, true);
  }
  
  private static void q(Activity paramActivity, final String paramString, FragmentManager paramFragmentManager)
  {
    Object localObject1 = b;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (ForcedUpdateFwDialog)((WeakReference)localObject1).get();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ForcedUpdateFwDialog();
      b = new WeakReference(localObject2);
    }
    if (((Fragment)localObject2).isAdded()) {
      return;
    }
    localObject1 = ((FirmwareManager)b.a(b.d.s.a.a.f(), FirmwareManager.class)).g(paramString);
    if (localObject1 != null) {
      localObject1 = ((com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u)localObject1).a();
    } else {
      localObject1 = "";
    }
    ((ForcedUpdateFwDialog)localObject2).A0((String)localObject1);
    ((ForcedUpdateFwDialog)localObject2).B0(new a(paramActivity, paramString));
    ((DialogFragment)localObject2).show(paramFragmentManager, "ForcedUpdateFwDialog");
  }
  
  public static void r(Activity paramActivity, List<BaseALIoTDevice> paramList, ListContentLongDialog.e parame)
  {
    if (paramActivity == null) {
      return;
    }
    x(paramActivity, paramList, paramActivity.getString(2131953924), parame);
  }
  
  private static void s(FragmentManager paramFragmentManager)
  {
    Object localObject1 = a;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (CameraUpdatingDialogFragment)((WeakReference)localObject1).get();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new CameraUpdatingDialogFragment();
      a = new WeakReference(localObject2);
    }
    if (((Fragment)localObject2).isAdded()) {
      return;
    }
    ((DialogFragment)localObject2).show(paramFragmentManager, "UpdatingDialog");
  }
  
  public static void t(Activity paramActivity, List<BaseALIoTDevice> paramList, String paramString1, String paramString2)
  {
    if (paramActivity == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (BaseALIoTDevice)localIterator.next();
      localArrayList.add(l.e(paramActivity, paramList.getDeviceType(), paramList.getDeviceName(), paramList.getDeviceModel()));
    }
    paramActivity = new ListContentDialog.Builder(paramActivity).h(paramString1).b(paramString2).g(paramActivity.getString(2131953902)).d(localArrayList).a();
    paramActivity.setCancelable(false);
    paramActivity.show();
  }
  
  public static void u(Activity paramActivity, List<BaseALIoTDevice> paramList, String paramString1, String paramString2, ListContentDialog.e parame)
  {
    if (paramActivity == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (BaseALIoTDevice)localIterator.next();
      localArrayList.add(l.e(paramActivity, paramList.getDeviceType(), paramList.getDeviceName(), paramList.getDeviceModel()));
    }
    paramActivity = new ListContentDialog.Builder(paramActivity).h(paramString1).b(paramString2).e(paramActivity.getString(2131953902)).g(paramActivity.getString(2131953908)).d(localArrayList).f(parame).a();
    paramActivity.setCancelable(false);
    paramActivity.show();
  }
  
  public static void v(Activity paramActivity, List<BaseALIoTDevice> paramList, ListContentLongDialog.e parame)
  {
    if (paramActivity == null) {
      return;
    }
    x(paramActivity, paramList, paramActivity.getString(2131953917), parame);
  }
  
  public static void w(Activity paramActivity, String paramString, TPLongMaterialDialogV2.d paramd)
  {
    y(paramActivity, paramString, 2131953917, paramd);
  }
  
  private static void x(Activity paramActivity, List<BaseALIoTDevice> paramList, String paramString, ListContentLongDialog.e parame)
  {
    if (paramActivity == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localIterator.next();
      localArrayList.add(l.e(paramActivity, localBaseALIoTDevice.getDeviceType(), localBaseALIoTDevice.getDeviceName(), localBaseALIoTDevice.getDeviceModel()));
    }
    new ListContentLongDialog.Builder(paramActivity).h(paramString).b(com.tplink.iot.view.deviceshare.a.b(paramActivity, paramList)).e(paramActivity.getString(2131952391)).g(paramActivity.getString(2131953906)).d(localArrayList).f(parame).a().show();
  }
  
  private static void y(Activity paramActivity, String paramString, int paramInt, TPLongMaterialDialogV2.d paramd)
  {
    if (paramActivity == null) {
      return;
    }
    paramString = com.tplink.iot.view.deviceshare.a.a(paramActivity, paramString);
    paramActivity = new TPLongMaterialDialogV2.Builder(paramActivity);
    paramActivity.o(paramInt);
    paramActivity.g(paramString);
    paramActivity.c(false);
    paramActivity.b(false);
    paramActivity.l(2131953906, 2131099808, paramd);
    paramActivity.i(2131952391, 2131099804, null);
    paramActivity.d(8, 8);
    paramActivity.a().show();
  }
  
  public static void z(Activity paramActivity, String paramString)
  {
    A(paramActivity, paramString);
  }
  
  static final class a
    implements ForcedUpdateFwDialog.a
  {
    a(Activity paramActivity, String paramString) {}
    
    public void a() {}
    
    public void b()
    {
      FirmwareUpdateNewIpcActivity.g1(this.a, paramString, false);
    }
    
    public void c()
    {
      FirmwareUpdateNewIpcActivity.g1(this.a, paramString, true);
    }
  }
  
  static final class b
    implements TPMaterialDialogV2.d
  {
    b(TPMaterialDialogV2 paramTPMaterialDialogV2, Activity paramActivity, String paramString1, String paramString2, String paramString3) {}
    
    public void onClick(View paramView)
    {
      paramView = this.a;
      if (paramView != null) {
        paramView.dismiss();
      }
      DeviceOfflineTroubleshootingActivity.p1(paramActivity, paramString1, paramString2, paramString3);
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(TPMaterialDialogV2 paramTPMaterialDialogV2, Activity paramActivity, String paramString1, String paramString2, String paramString3) {}
    
    public void onClick(View paramView)
    {
      paramView = this.c;
      if (paramView != null) {
        paramView.dismiss();
      }
      DeviceOfflineTroubleshootingActivity.p1(paramActivity, paramString1, paramString2, paramString3);
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(TPMaterialDialogV2 paramTPMaterialDialogV2, Activity paramActivity, String paramString) {}
    
    public void onClick(View paramView)
    {
      paramView = this.c;
      if (paramView != null) {
        paramView.dismiss();
      }
      u.a(paramActivity, paramString4);
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(TPMaterialDialogV2 paramTPMaterialDialogV2) {}
    
    public void onClick(View paramView)
    {
      paramView = this.c;
      if (paramView != null) {
        paramView.dismiss();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */