package com.tplink.iot.firebase;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.graphics.Bitmap;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.d.n.j.g;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.core.n;
import com.tplink.iot.core.p;
import com.tplink.iot.model.notification.NotificationCenterManager;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TNotificationSnackbar;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TNotificationSnackbar.l;
import com.tplink.iot.view.login.LoginActivity;
import com.tplink.iot.view.welcome.StartupActivity;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.o;
import io.reactivex.q;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang.e;

public class TapoFirebaseMessagingService
  extends FirebaseMessagingService
{
  private static AtomicBoolean c = new AtomicBoolean(false);
  private static CloudMessageBean d = null;
  private long f;
  
  public static void d()
  {
    d = null;
    c.set(false);
  }
  
  private Activity e()
  {
    if (!p.d()) {
      return null;
    }
    Activity localActivity = p.c();
    if ((!(localActivity instanceof StartupActivity)) && (!(localActivity instanceof LoginActivity))) {
      return localActivity;
    }
    return null;
  }
  
  private String f(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramMap != null)
    {
      str = paramString2;
      if (paramMap.size() > 0)
      {
        str = paramString2;
        if (paramMap.containsKey(paramString1))
        {
          str = (String)paramMap.get(paramString1);
          if (str == null) {
            str = paramString2;
          }
        }
      }
    }
    return str;
  }
  
  private void l()
  {
    try
    {
      Uri localUri = RingtoneManager.getDefaultUri(2);
      RingtoneManager.getRingtone(getApplicationContext(), localUri).play();
    }
    catch (Exception localException)
    {
      b.d.w.c.a.c("TapoFirebaseMessagingService", "play notification sound error!!!");
    }
  }
  
  private void m(CloudMessageBean paramCloudMessageBean, Bitmap paramBitmap)
  {
    Activity localActivity = e();
    if (localActivity == null)
    {
      d();
      return;
    }
    l();
    TNotificationSnackbar.u(localActivity, paramCloudMessageBean.getTitle(), 3000).A(paramCloudMessageBean.getContent()).C(paramBitmap).D(true).z(new b(localActivity, paramCloudMessageBean)).y(new a()).G();
  }
  
  @SuppressLint({"CheckResult"})
  private void n(CloudMessageBean paramCloudMessageBean)
  {
    if (!TextUtils.isEmpty(paramCloudMessageBean.getImgUrl())) {
      com.tplink.iot.view.notification.c.b.b(paramCloudMessageBean.getImgUrl()).H0(new c(this, paramCloudMessageBean), new a(this, paramCloudMessageBean));
    } else {
      m(paramCloudMessageBean, null);
    }
  }
  
  private void o(CloudMessageBean paramCloudMessageBean)
  {
    if (paramCloudMessageBean == null) {
      return;
    }
    if ((System.currentTimeMillis() - this.f < 3000L) && (c.get()))
    {
      d = paramCloudMessageBean;
      return;
    }
    d = null;
    this.f = System.currentTimeMillis();
    c.set(true);
    n(paramCloudMessageBean);
  }
  
  public void onMessageReceived(RemoteMessage paramRemoteMessage)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("From: ");
    ((StringBuilder)localObject1).append(paramRemoteMessage.getFrom());
    b.d.w.c.a.c("TapoFirebaseMessagingService", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Data: ");
    ((StringBuilder)localObject1).append(paramRemoteMessage.getData());
    b.d.w.c.a.c("TapoFirebaseMessagingService", ((StringBuilder)localObject1).toString());
    Object localObject2 = paramRemoteMessage.getData();
    localObject1 = "";
    String str1 = f((Map)localObject2, "msgId", "");
    String str2 = f(paramRemoteMessage.getData(), "title", "");
    String str3 = f(paramRemoteMessage.getData(), "content", "");
    localObject2 = f(paramRemoteMessage.getData(), "msgType", "");
    String str4 = f(paramRemoteMessage.getData(), "time", "");
    f(paramRemoteMessage.getData(), "deviceCount", String.valueOf(0));
    f(paramRemoteMessage.getData(), "userName", "");
    String str5 = f(paramRemoteMessage.getData(), "deviceId", "");
    String str6 = f(paramRemoteMessage.getData(), "imgUrl", "");
    String str7 = f(paramRemoteMessage.getData(), "alias", "");
    String str8 = f(paramRemoteMessage.getData(), "uuid", "");
    String str9 = f(paramRemoteMessage.getData(), "summaryDate", "");
    if (p.d())
    {
      com.tplink.cloud.context.b localb = b.d.s.a.a.f();
      if (localb != null)
      {
        TCAccountBean localTCAccountBean = localb.c();
        if ((localTCAccountBean != null) && (!TextUtils.isEmpty(localTCAccountBean.getCloudUserName()))) {
          ((NotificationCenterManager)b.d.b.f.b.a(localb, NotificationCenterManager.class)).u();
        }
      }
    }
    if (!TextUtils.isEmpty(g.b(paramRemoteMessage)))
    {
      localObject2 = g.b(paramRemoteMessage);
      localObject1 = g.c(paramRemoteMessage);
    }
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return;
    }
    paramRemoteMessage = new CloudMessageBean(str1, (String)localObject2, str4);
    paramRemoteMessage.setTitle(str2);
    paramRemoteMessage.setContent(str3);
    paramRemoteMessage.setDeviceId(str5);
    paramRemoteMessage.setImgUrl(str6);
    paramRemoteMessage.setAlias(str7);
    paramRemoteMessage.setUuid(str8);
    paramRemoteMessage.setTaskId((String)localObject1);
    paramRemoteMessage.setSummaryDate(str9);
    o(paramRemoteMessage);
  }
  
  public void onNewToken(@NonNull String paramString)
  {
    try
    {
      String str = o.h0().Q();
      if (!e.a(paramString))
      {
        if (!paramString.equals(str)) {
          o.h0().V0(paramString);
        }
        ((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).w3(n.e, n.d, paramString, "TP-Link_Tapo_Android", n.a);
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  class a
    extends TNotificationSnackbar.l
  {
    a() {}
    
    public void a(TNotificationSnackbar paramTNotificationSnackbar, int paramInt)
    {
      super.a(paramTNotificationSnackbar, paramInt);
      paramTNotificationSnackbar = TapoFirebaseMessagingService.a();
      TapoFirebaseMessagingService.d();
      if ((paramInt == 2) && (paramTNotificationSnackbar != null)) {
        TapoFirebaseMessagingService.b(TapoFirebaseMessagingService.this, paramTNotificationSnackbar);
      }
    }
    
    public void b(TNotificationSnackbar paramTNotificationSnackbar)
    {
      super.b(paramTNotificationSnackbar);
      TapoFirebaseMessagingService.c().set(true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\firebase\TapoFirebaseMessagingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */