package com.tplink.iot.Utils.z0;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import b.d.q.b.o;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.g;
import com.google.gson.k;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.d;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.ipcamera.setting.z4;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.Utils.t;
import com.tplink.libtpnetwork.Utils.u;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraBasicInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.model.ServiceList;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.q;

public class h
{
  private static void A(Context paramContext, ALCameraDevice paramALCameraDevice, ImageView paramImageView, int paramInt)
  {
    if (paramImageView == null) {
      return;
    }
    int i = 2131690019;
    if ((paramALCameraDevice != null) && (paramContext != null))
    {
      if (paramALCameraDevice.isDefaultLocation())
      {
        paramImageView.setImageResource(z4.a(paramContext, paramALCameraDevice.getDeviceLocation()));
      }
      else
      {
        paramALCameraDevice = paramALCameraDevice.getCustomLocationUrl();
        if (!TextUtils.isEmpty(paramALCameraDevice))
        {
          g localg = (g)new g().f(j.a);
          if (paramInt == 1) {
            paramInt = 18;
          } else if (paramInt == 2) {
            paramInt = 24;
          } else {
            paramInt = 35;
          }
          localg = (g)localg.f0(new com.tplink.iot.Utils.y0.f(paramInt));
          com.bumptech.glide.c.u(paramContext).s(paramALCameraDevice).m0(localg).x0(paramImageView);
        }
        else
        {
          if (paramInt == 1) {
            paramInt = 2131690018;
          } else if (paramInt == 2) {
            paramInt = i;
          } else {
            paramInt = 2131690020;
          }
          paramImageView.setImageResource(paramInt);
        }
      }
      return;
    }
    if (paramInt == 1) {
      paramInt = 2131690018;
    } else if (paramInt == 2) {
      paramInt = i;
    } else {
      paramInt = 2131690020;
    }
    paramImageView.setImageResource(paramInt);
  }
  
  public static boolean B(String paramString, DeviceModel paramDeviceModel)
  {
    Object localObject = TPIoTClientManager.K1(paramString);
    boolean bool1 = false;
    if (localObject != null)
    {
      localObject = (ALCameraDevice)((TPBaseDeviceContext)localObject).getCameraDevice();
      if ((localObject != null) && (((BaseALIoTDevice)localObject).isUserRoleTypeDevice())) {
        return false;
      }
    }
    if ((!com.tplink.iot.view.ipcamera.base.c.t(paramDeviceModel)) && (!com.tplink.iot.view.ipcamera.base.c.u(paramDeviceModel)) && (!com.tplink.iot.view.ipcamera.base.c.v(paramDeviceModel))) {
      return false;
    }
    boolean bool2 = bool1;
    if (u.d(paramString))
    {
      bool2 = bool1;
      if (!t.b(paramString))
      {
        bool2 = bool1;
        if (t.a()) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public static boolean C(String paramString)
  {
    if (u.g(paramString)) {
      return false;
    }
    Object localObject = TPIoTClientManager.K1(paramString);
    if (localObject != null)
    {
      localObject = (ALCameraDevice)((TPBaseDeviceContext)localObject).getCameraDevice();
      if ((localObject != null) && (((BaseALIoTDevice)localObject).isUserRoleTypeDevice())) {
        return false;
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = u.c(paramString);
    if ((l2 != -1L) && (l1 - l2 >= 604800000L))
    {
      u.o(paramString, true);
      boolean bool1 = u.a(paramString).booleanValue();
      boolean bool2 = u.e(paramString);
      boolean bool3 = u.f(paramString);
      if ((bool1) && (bool2) && (bool3)) {
        return false;
      }
      return com.tplink.iot.Utils.v0.d.e(paramString);
    }
    return false;
  }
  
  public static boolean D(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = true;
    int i;
    if ((!bool1) && (com.tplink.iot.Utils.v0.d.c(paramString))) {
      i = 1;
    } else {
      i = 0;
    }
    paramString = TPIoTClientManager.K1(paramString);
    if (paramString != null)
    {
      paramString = (ALCameraDevice)paramString.getCameraDevice();
      if (paramString != null)
      {
        bool1 = paramString.isUserRoleTypeDevice();
        break label59;
      }
    }
    bool1 = false;
    label59:
    if ((i != 0) && (!bool1)) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    return bool1;
  }
  
  public static void E(Activity paramActivity, String paramString)
  {
    Object localObject1 = (ALCameraDevice)TPIoTClientManager.I1(paramString);
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if ((localObject1 != null) && (((ALCameraDevice)localObject1).getCameraComponent() != null))
    {
      bool1 = ((ALCameraDevice)localObject1).getCameraComponent().isSupportBabyCry();
      bool2 = ((ALCameraDevice)localObject1).getCameraComponent().hasComponent(ComponentType.TARGET_TRACK);
      bool3 = ((ALCameraDevice)localObject1).getCameraComponent().hasComponent(ComponentType.BLOCK_ZONE);
    }
    else
    {
      bool3 = false;
      bool1 = false;
      bool2 = false;
    }
    String str1 = paramActivity.getString(2131951783);
    Object localObject2 = paramActivity.getString(2131954275);
    String str2 = paramActivity.getString(2131953852);
    int i;
    if ((bool1) && (!u.a(paramString).booleanValue())) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((bool2) && (!u.e(paramString))) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((bool3) && (!u.f(paramString))) {
      k = 1;
    } else {
      k = 0;
    }
    if (i != 0)
    {
      if (j != 0)
      {
        if (k != 0)
        {
          localObject1 = paramActivity.getApplicationContext();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str1);
          localStringBuilder.append(",");
          localStringBuilder.append((String)localObject2);
          localObject1 = ((Context)localObject1).getString(2131954222, new Object[] { localStringBuilder.toString(), str2 });
        }
        else
        {
          localObject1 = paramActivity.getApplicationContext().getString(2131954222, new Object[] { str1, localObject2 });
        }
      }
      else if (k != 0) {
        localObject1 = paramActivity.getApplicationContext().getString(2131954222, new Object[] { str1, str2 });
      } else {
        localObject1 = paramActivity.getApplicationContext().getString(2131954221, new Object[] { str1 });
      }
    }
    else if (j != 0)
    {
      if (k != 0) {
        localObject1 = paramActivity.getApplicationContext().getString(2131954222, new Object[] { localObject2, str2 });
      } else {
        localObject1 = paramActivity.getApplicationContext().getString(2131954221, new Object[] { localObject2 });
      }
    }
    else
    {
      if (k == 0) {
        return;
      }
      localObject1 = paramActivity.getApplicationContext().getString(2131954221, new Object[] { str2 });
    }
    localObject2 = new TPLongMaterialDialogV2.Builder(paramActivity);
    paramActivity = ((TPLongMaterialDialogV2.Builder)localObject2).a();
    ((TPLongMaterialDialogV2.Builder)localObject2).g((String)localObject1).l(2131953902, 2131099808, new a(paramActivity)).d(8, 0).b(false).c(false).a();
    if (!paramActivity.isShowing())
    {
      paramActivity.show();
      u.o(paramString, true);
    }
  }
  
  public static q<Integer> a(String paramString, boolean paramBoolean, ComponentType paramComponentType, com.tplink.libtpnetwork.Utils.f0.b<Boolean> paramb)
  {
    if (b(paramComponentType, paramString)) {
      return q.f0(Integer.valueOf(2));
    }
    return o(paramString, paramBoolean, paramb);
  }
  
  public static boolean b(ComponentType paramComponentType, String paramString)
  {
    return com.tplink.libtpnetwork.Utils.d.a(paramComponentType, paramString);
  }
  
  public static q<Boolean> c(String paramString, com.tplink.libtpnetwork.Utils.f0.b<Boolean> paramb)
  {
    return d(paramString, true, paramb);
  }
  
  public static q<Boolean> d(String paramString, boolean paramBoolean, com.tplink.libtpnetwork.Utils.f0.b<Boolean> paramb)
  {
    paramString = j(paramString);
    if (paramString == null) {
      return q.J(new Throwable("device id is null"));
    }
    CloudVideoRepository localCloudVideoRepository = (CloudVideoRepository)b.d.b.f.b.a(b.d.s.a.a.f(), CloudVideoRepository.class);
    DeviceCloudProduct localDeviceCloudProduct = localCloudVideoRepository.Z(paramString);
    if ((localDeviceCloudProduct != null) && (paramBoolean)) {
      return q.f0(Boolean.valueOf(localCloudVideoRepository.k0(localDeviceCloudProduct)));
    }
    return localCloudVideoRepository.M(paramString).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).F(new e(paramb)).y(new c(paramb)).g0(new f(localCloudVideoRepository)).q0(Boolean.valueOf(localCloudVideoRepository.k0(localCloudVideoRepository.K(paramString))));
  }
  
  public static k e(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
  {
    k localk = new k();
    localk.m("type", "SMART.IPCAMERA");
    if (paramBaseALIoTDevice != null)
    {
      String str = paramBaseALIoTDevice.getDeviceModel();
      localk.m("device_id", paramBaseALIoTDevice.getDeviceIdMD5());
      if (str != null) {
        localk.m("model", str);
      }
    }
    return localk;
  }
  
  public static k f(@Nullable TDPCameraDevice paramTDPCameraDevice)
  {
    if (paramTDPCameraDevice == null) {
      paramTDPCameraDevice = null;
    } else {
      paramTDPCameraDevice = new ALCameraDevice(paramTDPCameraDevice);
    }
    return e(paramTDPCameraDevice);
  }
  
  public static k g(@Nullable String paramString)
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = TPIoTClientManager.I1(paramString);
    }
    return e(paramString);
  }
  
  public static String h(Context paramContext, ALCameraDevice paramALCameraDevice)
  {
    if (paramContext == null) {
      return "";
    }
    if ((paramALCameraDevice != null) && (!TextUtils.isEmpty(paramALCameraDevice.getDeviceLocation()))) {
      return z4.c(paramContext, paramALCameraDevice.getDeviceLocation(), paramALCameraDevice.isDefaultLocation());
    }
    return paramContext.getString(2131953286);
  }
  
  public static q<DeviceCloudProduct> i(String paramString, boolean paramBoolean)
  {
    String str = j(paramString);
    if (str == null) {
      return q.J(new Throwable("device id is null"));
    }
    CloudVideoRepository localCloudVideoRepository = (CloudVideoRepository)b.d.b.f.b.a(b.d.s.a.a.f(), CloudVideoRepository.class);
    paramString = localCloudVideoRepository.Z(str);
    if ((paramString != null) && (paramBoolean)) {
      return q.f0(paramString);
    }
    if (localCloudVideoRepository.K(str) == null) {
      return localCloudVideoRepository.M(str).L0(io.reactivex.l0.a.c());
    }
    return localCloudVideoRepository.M(str).L0(io.reactivex.l0.a.c()).q0(localCloudVideoRepository.K(str));
  }
  
  @Nullable
  public static String j(String paramString)
  {
    paramString = (ALCameraDevice)TPIoTClientManager.K1(paramString).getCameraDevice();
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = paramString.getDeviceId();
    }
    return paramString;
  }
  
  public static String k(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = TPIoTClientManager.K1(paramString);
    if (paramString != null)
    {
      paramString = (ALCameraDevice)paramString.getCameraDevice();
      if ((paramString != null) && (paramString.getBasicInfo() != null)) {
        return paramString.getBasicInfo().getDeviceId();
      }
    }
    return null;
  }
  
  public static String l(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppContext.c.getString(2131953840));
    localStringBuilder.append(": ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void m(String paramString)
  {
    com.tplink.libtpnetwork.Utils.d.b(paramString).F0();
  }
  
  public static ServiceList n(String paramString)
  {
    return com.tplink.libtpnetwork.Utils.d.c(paramString);
  }
  
  public static q<Integer> o(String paramString, boolean paramBoolean, com.tplink.libtpnetwork.Utils.f0.b<Boolean> paramb)
  {
    String str = j(paramString);
    if (str == null) {
      return q.J(new Throwable("device id is null"));
    }
    CloudVideoRepository localCloudVideoRepository = (CloudVideoRepository)b.d.b.f.b.a(b.d.s.a.a.f(), CloudVideoRepository.class);
    DeviceCloudProduct localDeviceCloudProduct = localCloudVideoRepository.Z(str);
    boolean bool = s(paramString);
    if ((localDeviceCloudProduct != null) && (paramBoolean)) {
      return q.f0(Integer.valueOf(localCloudVideoRepository.g0(localDeviceCloudProduct, bool)));
    }
    return localCloudVideoRepository.M(str).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).F(new b(paramb)).y(new a(paramb)).g0(new d(localCloudVideoRepository, bool)).q0(Integer.valueOf(localCloudVideoRepository.g0(localCloudVideoRepository.K(str), bool)));
  }
  
  public static int p(Activity paramActivity)
  {
    if (paramActivity == null) {
      return 0;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    int i = o.a(paramActivity, 200.0F);
    int j = (int)(localDisplayMetrics.widthPixels / 1.7777778F);
    if (i >= j) {
      j = i;
    }
    return j;
  }
  
  public static void q(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)))
    {
      Intent localIntent = new Intent(paramActivity, VideoPlayActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static boolean r(SdCardStatus paramSdCardStatus)
  {
    if (paramSdCardStatus != null) {
      int i = b.a[paramSdCardStatus.ordinal()];
    }
    return false;
  }
  
  public static boolean s(String paramString)
  {
    CameraSettingRepository localCameraSettingRepository = (CameraSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, CameraSettingRepository.class);
    paramString = (ALCameraDevice)((TPCameraDeviceContext)((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, CommonCameraRepository.class)).b()).getCameraDevice();
    if ((paramString != null) && (paramString.getCameraComponent() != null) && (paramString.getCameraComponent().hasComponent(ComponentType.SD_CARD)))
    {
      paramString = localCameraSettingRepository.x().getSdCardInfoCache();
      if (paramString != null) {
        return r(paramString.getStatus());
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public static void y(Context paramContext, ALCameraDevice paramALCameraDevice, ImageView paramImageView)
  {
    A(paramContext, paramALCameraDevice, paramImageView, 1);
  }
  
  public static void z(Context paramContext, ALCameraDevice paramALCameraDevice, ImageView paramImageView)
  {
    A(paramContext, paramALCameraDevice, paramImageView, 2);
  }
  
  static final class a
    implements TPLongMaterialDialogV2.d
  {
    a(TPLongMaterialDialogV2 paramTPLongMaterialDialogV2) {}
    
    public void onClick(View paramView)
    {
      this.a.dismiss();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\z0\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */