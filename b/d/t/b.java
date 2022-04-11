package b.d.t;

import android.os.Build;
import android.text.TextUtils;
import b.d.d.m.h;
import com.tplink.libmediakit.jniinterface.RemoteConnection;
import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class b
{
  public static void a(int paramInt, DeviceModel paramDeviceModel)
  {
    RemoteConnection.d().a(paramInt);
  }
  
  public static int b(BaseConnection paramBaseConnection, int paramInt)
  {
    return RemoteConnection.d().e(paramInt);
  }
  
  private static int c(BaseConnection paramBaseConnection)
  {
    Object localObject1 = b.d.d.d.c.c(paramBaseConnection.getDeviceIdMD5());
    if (localObject1 == null) {
      return -1;
    }
    Object localObject2 = b.d.d.m.a.a();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("TP-Link_Tapo_Android Android ");
    ((StringBuilder)localObject3).append((String)localObject2);
    String str1 = ((StringBuilder)localObject3).toString();
    String str2 = ((TPMediaDevice)localObject1).getDeviceId();
    String str3 = ((TPMediaDevice)localObject1).getDeviceMac();
    String str4 = b.d.d.a.a.a();
    localObject3 = b.d.d.a.a.c();
    localObject2 = localObject3;
    if (paramBaseConnection.getConnectionType() == 0)
    {
      localObject2 = localObject3;
      if (((TPMediaDevice)localObject1).isUserRoleTypeDevice())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(b.d.d.a.a.c());
        ((StringBuilder)localObject2).append("; tokenType=appSlaveToken");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    String str5 = h.a();
    String str6 = Build.MODEL;
    int i = e(paramBaseConnection.getConnectionType());
    int j = h(paramBaseConnection.getMediaType());
    int k = g(paramBaseConnection.getBitStreamType());
    String str7 = b.d.d.a.a.e();
    if (((TPMediaDevice)localObject1).isSupportIoTCloud()) {
      localObject3 = ((TPMediaDevice)localObject1).getIotThingUrl();
    } else {
      localObject3 = ((TPMediaDevice)localObject1).getAppServerUrl();
    }
    String str8 = b.d.t.e.d.b(str7, (String)localObject3);
    str7 = b.d.t.e.d.c(str7, (String)localObject3);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(str8);
    ((StringBuilder)localObject3).append(":80");
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str8);
    localStringBuilder.append(":443");
    str8 = localStringBuilder.toString();
    str7 = k(str7);
    boolean bool = ((TPMediaDevice)localObject1).isSupportIoTCloud();
    localObject1 = String.format("app:%1$s:%2$s", new Object[] { "TP-Link_Tapo_Android", b.d.d.j.b.b.getUuid() });
    if (paramBaseConnection.getConnectionType() == 0)
    {
      paramBaseConnection = "--client-stream-boundary--";
    }
    else
    {
      str8 = "";
      paramBaseConnection = str8;
      localObject3 = str7;
    }
    paramBaseConnection = b.d.t.e.c.b(str3, str1, str2, str4, (String)localObject2, str5, str6, i, j, k, (String)localObject3, str8, paramBaseConnection, bool, (String)localObject1);
    return RemoteConnection.d().c(paramBaseConnection);
  }
  
  private static int d(BaseConnection paramBaseConnection, int paramInt)
  {
    TPMediaDevice localTPMediaDevice = b.d.d.d.c.c(paramBaseConnection.getDeviceIdMD5());
    if (localTPMediaDevice == null) {
      return -1;
    }
    String str1 = localTPMediaDevice.getDeviceId();
    int i = e(paramBaseConnection.getConnectionType());
    int j = h(paramBaseConnection.getMediaType());
    int k = g(paramBaseConnection.getBitStreamType());
    long l1 = paramBaseConnection.getStartTime();
    long l2 = paramBaseConnection.getEndTime();
    int m = i(paramBaseConnection.getTalkMode());
    String str2 = b.d.d.a.a.d();
    if (localTPMediaDevice.isSupportIoTCloud()) {
      paramBaseConnection = localTPMediaDevice.getIotThingUrl();
    } else {
      paramBaseConnection = localTPMediaDevice.getAppServerUrl();
    }
    paramBaseConnection.replace("http://", "").replace("https://", "");
    paramBaseConnection = b.d.t.e.c.a(str1, i, j, k, l1, l2, m, "admin", str2, paramBaseConnection, paramBaseConnection, 30000);
    return RemoteConnection.d().b(paramInt, paramBaseConnection);
  }
  
  private static int e(int paramInt)
  {
    if (paramInt == 16) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    return paramInt;
  }
  
  public static int f(BaseConnection paramBaseConnection, int paramInt)
  {
    return d(paramBaseConnection, paramInt);
  }
  
  private static int g(BitStreamType paramBitStreamType)
  {
    int i;
    if ((paramBitStreamType != null) && (paramBitStreamType.equals(BitStreamType.MAIN_HD))) {
      i = 0;
    } else {
      i = 1;
    }
    return i;
  }
  
  private static int h(int paramInt)
  {
    int i = 1;
    if (paramInt != 1)
    {
      i = 2;
      if (paramInt != 2)
      {
        i = 3;
        if (paramInt != 3) {
          return 0;
        }
      }
    }
    return i;
  }
  
  public static int i(String paramString)
  {
    if ("aec".equals(paramString)) {
      return 2;
    }
    return 0;
  }
  
  public static int j(BaseConnection paramBaseConnection)
  {
    if (TextUtils.isEmpty(b.d.d.a.a.c())) {
      return -1;
    }
    return c(paramBaseConnection);
  }
  
  private static String k(String paramString)
  {
    try
    {
      String str = InetAddress.getByName(paramString).getHostAddress();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("ip ");
      localStringBuilder.append(str);
      b.d.p.d.a("NatUtils", localStringBuilder.toString());
      return str;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      localUnknownHostException.printStackTrace();
    }
    return b.d.t.e.d.a(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\t\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */