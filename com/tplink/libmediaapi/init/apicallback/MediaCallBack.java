package com.tplink.libmediaapi.init.apicallback;

import android.util.Pair;
import com.tplink.libmediaapi.live.apienum.EnumBitStreamType;
import io.reactivex.q;

public abstract interface MediaCallBack
{
  public abstract void forceUpdateP2PSharePassword(String paramString);
  
  public abstract q<Pair<byte[], byte[]>> getAesEncryptKey(String paramString);
  
  public abstract EnumBitStreamType getBitStreamType(String paramString);
  
  public abstract String getLoginCloudUserName();
  
  public abstract String getLoginToken();
  
  public abstract String getMediaLoginPassword();
  
  public abstract String getPskId(String paramString);
  
  public abstract String getPskPwd(String paramString);
  
  public abstract String getServerUrl();
  
  public abstract String getUpnpIp(String paramString);
  
  public abstract int getUpnpPort(String paramString);
  
  public abstract String getUpnpStatus(String paramString);
  
  public abstract int getUpnpTimestamp(String paramString);
  
  public abstract String getUuid();
  
  public abstract boolean isUpnpEnabled(String paramString);
  
  public abstract q renewUpnpPsk(String paramString);
  
  public abstract void storeBitStreamType(String paramString, EnumBitStreamType paramEnumBitStreamType);
  
  public abstract void storeFileMemory(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void storePreImageUrl(String paramString1, String paramString2);
  
  public abstract void syncDeviceAccount(String paramString);
  
  public abstract void updateUpnpCommStatus(String paramString1, String paramString2);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\init\apicallback\MediaCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */