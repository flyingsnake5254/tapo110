package com.tplink.libmediaapi.init;

import android.app.Application;
import android.util.Pair;
import b.d.d.j.b;
import b.d.p.d;
import com.tplink.libmediaapi.init.apicallback.MediaCallBack;
import com.tplink.libmediaapi.live.apienum.EnumBitStreamType;
import com.tplink.libmediakit.jniinterface.FdSanitizer;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpstreamclientmanager.n;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;

public class TPMediaKit
{
  public static void initSDK(Application paramApplication, MediaCallBack paramMediaCallBack)
  {
    d.d(false);
    b.d.d.c.a.c();
    FdSanitizer.b(0);
    b.a(paramApplication, new b.d.d.j.a()
    {
      public void forceUpdateP2PSharePassword(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          localMediaCallBack.forceUpdateP2PSharePassword(paramAnonymousString);
        }
      }
      
      public q<b.d.p.a> getAesEncryptKey(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          localMediaCallBack.getAesEncryptKey(paramAnonymousString).N(new j()
          {
            public t<b.d.p.a> apply(Pair<byte[], byte[]> paramAnonymous2Pair)
              throws Exception
            {
              if (paramAnonymous2Pair != null) {
                return q.f0(new b.d.p.a((byte[])paramAnonymous2Pair.first, (byte[])paramAnonymous2Pair.second));
              }
              return q.f0(new b.d.p.a());
            }
          });
        }
        return q.f0(new b.d.p.a());
      }
      
      public BitStreamType getBitStreamType(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null)
        {
          paramAnonymousString = localMediaCallBack.getBitStreamType(paramAnonymousString);
          if (paramAnonymousString != null) {
            return BitStreamType.fromString(paramAnonymousString.getValue());
          }
        }
        return null;
      }
      
      public String getLoginCloudUserName()
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.getLoginCloudUserName();
        }
        return null;
      }
      
      public String getLoginToken()
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.getLoginToken();
        }
        return null;
      }
      
      public String getMediaLoginPassword()
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.getMediaLoginPassword();
        }
        return null;
      }
      
      public String getPskId(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.getPskId(paramAnonymousString);
        }
        return null;
      }
      
      public String getPskPwd(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.getPskPwd(paramAnonymousString);
        }
        return null;
      }
      
      public String getServerUrl()
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.getServerUrl();
        }
        return null;
      }
      
      public String getUpnpIp(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.getUpnpIp(paramAnonymousString);
        }
        return null;
      }
      
      public int getUpnpPort(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.getUpnpPort(paramAnonymousString);
        }
        return 0;
      }
      
      public String getUpnpStatus(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.getUpnpStatus(paramAnonymousString);
        }
        return null;
      }
      
      public int getUpnpTimestamp(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.getUpnpTimestamp(paramAnonymousString);
        }
        return 0;
      }
      
      public String getUuid()
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.getUuid();
        }
        return "";
      }
      
      public boolean isUpnpEnabled(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.isUpnpEnabled(paramAnonymousString);
        }
        return false;
      }
      
      public q renewUpnpPsk(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          return localMediaCallBack.renewUpnpPsk(paramAnonymousString);
        }
        return q.f0(Integer.valueOf(0));
      }
      
      public void storeBitStreamType(String paramAnonymousString, BitStreamType paramAnonymousBitStreamType)
      {
        if (TPMediaKit.this != null)
        {
          paramAnonymousBitStreamType = EnumBitStreamType.fromString(paramAnonymousBitStreamType.getValue());
          TPMediaKit.this.storeBitStreamType(paramAnonymousString, paramAnonymousBitStreamType);
        }
      }
      
      public void storeFileMemory(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          localMediaCallBack.storeFileMemory(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousInt);
        }
      }
      
      public void storePreImageUrl(String paramAnonymousString1, String paramAnonymousString2)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          localMediaCallBack.storePreImageUrl(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public void syncDeviceAccount(String paramAnonymousString)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          localMediaCallBack.syncDeviceAccount(paramAnonymousString);
        }
      }
      
      public void updateUpnpCommStatus(String paramAnonymousString1, String paramAnonymousString2)
      {
        MediaCallBack localMediaCallBack = TPMediaKit.this;
        if (localMediaCallBack != null) {
          localMediaCallBack.updateUpnpCommStatus(paramAnonymousString1, paramAnonymousString2);
        }
      }
    });
    b.d.d.f.a.i(b.b.getServerUrl());
    n.a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\init\TPMediaKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */