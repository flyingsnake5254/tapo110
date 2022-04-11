package com.tplink.iot.core;

import android.app.Application;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import androidx.multidex.MultiDexApplication;
import b.d.q.b.l;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.tplink.iot.Utils.b0;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.cloud.bean.common.IoTWebServiceIdParams;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.libmediaapi.init.TPMediaKit;
import com.tplink.libmediaapi.init.apicallback.MediaCallBack;
import com.tplink.libmediaapi.live.apienum.EnumBitStreamType;
import com.tplink.libtpinappmessaging.model.b.b;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.NBUCloudRepository;
import com.tplink.libtpnetwork.Utils.a0;
import com.tplink.libtpnetwork.Utils.c0;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.Utils.s;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.model.PubIp;
import com.tplink.libtpnetwork.cameranetwork.model.Status;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpCommStatus;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpInfo;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpPsk;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpStatus;
import com.tplink.libtpnetwork.cameranetwork.model.VHttpd;
import com.tplink.libtpnetwork.cameranetwork.util.i.b;
import io.reactivex.q;
import java.util.Locale;
import okhttp3.logging.HttpLoggingInterceptor.Logger;

public class AppContext
  extends MultiDexApplication
{
  public static AppContext c;
  public long d;
  
  static
  {
    g();
    io.reactivex.j0.a.A(new b());
  }
  
  private void a()
  {
    com.tplink.iot.Utils.a1.a.c(this, false);
  }
  
  private void c()
  {
    b.d.w.c.a.j(this, "Tapo", false, false, false);
    com.tplink.tpble.m.a(this);
    com.tplink.libtpnetwork.TDPNetwork.a.q().s(this);
    FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
    b.d.q.b.p.b.v(this);
    com.tplink.libtpnetwork.cameranetwork.util.i.g(this);
    com.tplink.libtpnetwork.cameranetwork.util.d.c().h(this);
    com.tplink.libtpwifi.b.k().o(this);
    o.G0(this);
    b0.b(this);
    com.tplink.iot.view.quicksetup.base.f.c.h().j(this);
    try
    {
      b.d.w.d.a.e(this);
    }
    catch (Exception localException1)
    {
      b.d.w.c.a.d("TPSerializeUtils e");
    }
    try
    {
      s.f(this);
    }
    catch (Exception localException2)
    {
      b.d.w.c.a.d("TPSerializeUpgradeUtils e");
    }
    Object localObject = com.tplink.libtpnetwork.cameranetwork.util.i.d();
    com.tplink.libtpnetwork.cameranetwork.util.c.c(((i.b)localObject).c(), ((i.b)localObject).d());
    d();
    com.tplink.iot.Utils.n.b().d(this);
    o.h0().x0(false);
    p.k(this);
    j.j(this);
    f();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AppContext:PID=");
    ((StringBuilder)localObject).append(Process.myPid());
    b.d.w.c.a.d(((StringBuilder)localObject).toString());
  }
  
  private void d()
  {
    c0.e(this);
    n.a = c0.b();
    n.c = t0.d(this);
    n.d = getPackageName();
    n.e = t0.c(this);
    e();
  }
  
  private void e()
  {
    com.tplink.cloud.context.a locala = new com.tplink.cloud.context.a();
    locala.t("TP-Link_Tapo_Android");
    locala.v(n.c);
    if (a0.j())
    {
      if (a0.k()) {
        localObject = "https://n-wap-gw.tplinkcloud.com";
      } else {
        localObject = "https://n-wap-beta.tplinkcloud.com";
      }
      locala.y((String)localObject);
    }
    else
    {
      locala.y(n.c());
    }
    locala.B("wifi");
    locala.D(n.a);
    locala.u(n.d);
    locala.C(n.b);
    locala.z(Locale.getDefault().toString());
    locala.A(n.f);
    locala.F(n.g);
    locala.E(n.h);
    locala.w("nbu_access_key", "409d6040516e4602b1319903c68d53bb");
    locala.w("nbu_secret", "0602b6f22b034123a523b71e2e607882");
    locala.w("nbu_app_cid_app_type", "TP-Link_Tapo_Android");
    locala.x(new a());
    if (a0.j()) {
      localObject = new IoTWebServiceIdParams(a0.b(), a0.c(), a0.d());
    } else {
      localObject = new IoTWebServiceIdParams("nbu.iot-app-server.app", "nbu.iot-cloud-gateway.app", "nbu.iot-security.appdevice");
    }
    b.d.s.a.a.i(locala, "https://app-server.iot.i.tplinknbu.com", (IoTWebServiceIdParams)localObject);
    b.d.c.a.e.l().g(this, b.d.s.a.a.f(), true);
    b.d.c.a.e.l().e();
    Object localObject = new b.b().c(this).g("https://iac.tplinknbu.com").f(b.d.s.a.a.f()).d(true).b("tapo").e(d.a).a();
    b.d.n.f.b.l().e((com.tplink.libtpinappmessaging.model.b)localObject);
    com.tplink.iot.Utils.p.e();
    NBUCloudRepository.i(this);
  }
  
  private void f()
  {
    b.d.q.b.k.b(this);
    TPMediaKit.initSDK(this, new c());
  }
  
  private static void g()
  {
    System.setProperty("rx2.purge-enabled", "true");
    System.setProperty("rx2.purge-period-seconds", "6000");
  }
  
  private void h() {}
  
  public void b()
  {
    Intent localIntent = new Intent(this, MainActivity.class);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    sendBroadcast(new Intent("action.exit"));
  }
  
  public void onCreate()
  {
    super.onCreate();
    c = this;
    this.d = System.currentTimeMillis();
    c();
    com.tplink.libtpnetwork.Utils.k.a().c(this, "");
    com.tplink.zxing.activity.b.a(this);
    h();
    a();
  }
  
  public void onTerminate()
  {
    p.l();
    p.n(this);
    FragmentStateReceiver.k();
    super.onTerminate();
  }
  
  class a
    implements HttpLoggingInterceptor.Logger
  {
    a() {}
    
    public void log(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        b.d.w.c.a.i("Cloud Log:", paramString);
      }
    }
  }
  
  static final class b
    implements io.reactivex.g0.g<Throwable>
  {
    public void a(Throwable paramThrowable)
      throws Exception
    {
      b.d.w.c.a.g(paramThrowable, "", new Object[0]);
    }
  }
  
  class c
    implements MediaCallBack
  {
    c() {}
    
    public void forceUpdateP2PSharePassword(String paramString)
    {
      ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, CommonCameraRepository.class)).a0();
    }
    
    public q<Pair<byte[], byte[]>> getAesEncryptKey(String paramString)
    {
      return ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, CommonCameraRepository.class)).b0();
    }
    
    public EnumBitStreamType getBitStreamType(String paramString)
    {
      try
      {
        paramString = l.f(paramString);
        if (!TextUtils.isEmpty(paramString.k()))
        {
          paramString = EnumBitStreamType.fromString(paramString.k());
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return null;
    }
    
    public String getLoginCloudUserName()
    {
      return b.d.q.b.i.b();
    }
    
    public String getLoginToken()
    {
      return b.d.q.b.i.d();
    }
    
    public String getMediaLoginPassword()
    {
      return b.d.q.b.i.e();
    }
    
    public String getPskId(String paramString)
    {
      if (paramString == null) {
        return "";
      }
      paramString = (ALCameraDevice)TPIoTClientManager.K1(paramString).getCameraDevice();
      if ((paramString != null) && (paramString.getUpnpPsk() != null)) {
        return paramString.getUpnpPsk().getPskIdentity();
      }
      return "";
    }
    
    public String getPskPwd(String paramString)
    {
      if (paramString == null) {
        return "";
      }
      paramString = (ALCameraDevice)TPIoTClientManager.K1(paramString).getCameraDevice();
      if ((paramString != null) && (paramString.getUpnpPsk() != null)) {
        return paramString.getUpnpPsk().getPsk();
      }
      return "";
    }
    
    public String getServerUrl()
    {
      return n.c();
    }
    
    public String getUpnpIp(String paramString)
    {
      String str = "";
      if (paramString == null) {
        return "";
      }
      ALCameraDevice localALCameraDevice = (ALCameraDevice)TPIoTClientManager.K1(paramString).getCameraDevice();
      paramString = str;
      if (localALCameraDevice != null)
      {
        paramString = str;
        if (localALCameraDevice.getPubIp() != null)
        {
          paramString = str;
          if (!TextUtils.isEmpty(localALCameraDevice.getPubIp().getIp()))
          {
            paramString = str;
            if (!"null".equals(localALCameraDevice.getPubIp().getIp())) {
              paramString = localALCameraDevice.getPubIp().getIp();
            }
          }
        }
      }
      return paramString;
    }
    
    public int getUpnpPort(String paramString)
    {
      int i = -1;
      if (paramString == null) {
        return -1;
      }
      paramString = (ALCameraDevice)TPIoTClientManager.K1(paramString).getCameraDevice();
      int j = i;
      if (paramString != null)
      {
        j = i;
        if (paramString.getUpnpStatus() != null)
        {
          j = i;
          if (paramString.getUpnpStatus().getVHttpd() != null)
          {
            j = i;
            if (!TextUtils.isEmpty(paramString.getUpnpStatus().getVHttpd().getExtPort())) {
              try
              {
                j = Integer.parseInt(paramString.getUpnpStatus().getVHttpd().getExtPort());
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
                j = i;
              }
            }
          }
        }
      }
      return j;
    }
    
    public String getUpnpStatus(String paramString)
    {
      paramString = (ALCameraDevice)TPIoTClientManager.K1(paramString).getCameraDevice();
      if ((paramString != null) && (paramString.getUpnpCommStatus() != null) && (paramString.getUpnpCommStatus().getStatus() != null)) {
        return paramString.getUpnpCommStatus().getStatus().name();
      }
      return null;
    }
    
    public int getUpnpTimestamp(String paramString)
    {
      paramString = (ALCameraDevice)TPIoTClientManager.K1(paramString).getCameraDevice();
      if (paramString != null) {}
      try
      {
        if ((paramString.getUpnpCommStatus() != null) && (paramString.getUpnpCommStatus().getTimestamp() != null))
        {
          int i = Integer.parseInt(paramString.getUpnpCommStatus().getTimestamp());
          return i;
        }
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
      return 0;
    }
    
    public String getUuid()
    {
      return c0.b();
    }
    
    public boolean isUpnpEnabled(String paramString)
    {
      boolean bool1 = false;
      if (paramString == null) {
        return false;
      }
      paramString = (ALCameraDevice)TPIoTClientManager.K1(paramString).getCameraDevice();
      boolean bool2 = bool1;
      if (paramString != null)
      {
        bool2 = bool1;
        if (paramString.getUpnpInfo() != null)
        {
          bool2 = bool1;
          if ("on".equals(paramString.getUpnpInfo().getEnabled()))
          {
            bool2 = bool1;
            if (paramString.getUpnpStatus() != null)
            {
              bool2 = bool1;
              if (paramString.getUpnpStatus().getVHttpd() != null)
              {
                bool2 = bool1;
                if (paramString.getUpnpStatus().getVHttpd().getStatus() != null)
                {
                  bool2 = bool1;
                  if (!paramString.getUpnpStatus().getVHttpd().getStatus().equals("off")) {
                    bool2 = true;
                  }
                }
              }
            }
          }
        }
      }
      return bool2;
    }
    
    public q renewUpnpPsk(String paramString)
    {
      return ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, CommonCameraRepository.class)).j0();
    }
    
    public void storeBitStreamType(String paramString, EnumBitStreamType paramEnumBitStreamType)
    {
      l.r(paramString, new a(paramEnumBitStreamType));
    }
    
    public void storeFileMemory(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      ALCameraDevice localALCameraDevice = (ALCameraDevice)TPIoTClientManager.K1(paramString1).getCameraDevice();
      if (localALCameraDevice != null) {
        l.h(new c(paramString2, paramString3, paramString1, localALCameraDevice, paramInt));
      }
    }
    
    public void storePreImageUrl(String paramString1, String paramString2)
    {
      l.r(paramString1, new b(paramString2));
    }
    
    public void syncDeviceAccount(String paramString)
    {
      ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, CommonCameraRepository.class)).k().C(io.reactivex.l0.a.c()).y();
    }
    
    public void updateUpnpCommStatus(String paramString1, String paramString2)
    {
      paramString1 = (CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString1, CommonCameraRepository.class);
      Status localStatus = Status.valueOf(paramString2);
      paramString2 = new StringBuilder();
      paramString2.append(System.currentTimeMillis() / 1000L);
      paramString2.append("");
      paramString1.O0(new UpnpCommStatus(localStatus, paramString2.toString())).L0(io.reactivex.l0.a.c()).C(m.c).F0();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\core\AppContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */