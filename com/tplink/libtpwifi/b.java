package com.tplink.libtpwifi;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static WifiManager a;
  private static volatile b b;
  private Context c;
  private ConnectivityManager.NetworkCallback d;
  
  private void c(String paramString1, String paramString2)
  {
    paramString1 = new Intent(paramString1);
    paramString1.putExtra("tp_wifi_extra_ssid", paramString2);
    this.c.sendBroadcast(paramString1);
  }
  
  private void f(String paramString1, String paramString2, String paramString3, TPWifiCipherType paramTPWifiCipherType)
  {
    paramString2 = i(paramString1, paramString2, paramString3, paramTPWifiCipherType);
    int i = a.addNetwork(paramString2);
    int j = i;
    if (i == -1)
    {
      paramString3 = p(paramString1);
      j = i;
      if (paramString3 != null) {
        j = paramString3.networkId;
      }
    }
    if (j != -1)
    {
      a.disconnect();
      boolean bool = a.enableNetwork(j, true);
      u(paramString2);
      if (Build.VERSION.SDK_INT <= 22) {
        a.reconnect();
      }
      if (!bool) {
        c("com.tplink.tpm5.wifi.le.ACTION_WIFI_CONNECT_FAIL", paramString1);
      }
    }
    else
    {
      c("com.tplink.tpm5.wifi.le.ACTION_WIFI_CONNECT_FAIL", paramString1);
    }
  }
  
  @TargetApi(29)
  private void g(final String paramString1, String paramString2, String paramString3, TPWifiCipherType paramTPWifiCipherType)
  {
    t();
    ConnectivityManager localConnectivityManager = (ConnectivityManager)this.c.getSystemService("connectivity");
    this.d = new a(paramString1);
    localConnectivityManager.requestNetwork(h(paramString1, paramString2, paramString3, paramTPWifiCipherType), this.d);
  }
  
  @TargetApi(29)
  private NetworkRequest h(String paramString1, String paramString2, String paramString3, TPWifiCipherType paramTPWifiCipherType)
  {
    paramString1 = new WifiNetworkSpecifier.Builder().setSsid(paramString1);
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1.setBssid(MacAddress.fromString(paramString3));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      if (paramTPWifiCipherType == TPWifiCipherType.WIFI_CIPHER_WPA3) {
        paramString1.setWpa3Passphrase(paramString2);
      } else {
        paramString1.setWpa2Passphrase(paramString2);
      }
    }
    paramString1 = paramString1.build();
    return new NetworkRequest.Builder().addTransportType(1).removeCapability(12).setNetworkSpecifier(paramString1).build();
  }
  
  private WifiConfiguration i(String paramString1, String paramString2, String paramString3, TPWifiCipherType paramTPWifiCipherType)
  {
    WifiConfiguration localWifiConfiguration = new WifiConfiguration();
    localWifiConfiguration.allowedAuthAlgorithms.clear();
    localWifiConfiguration.allowedGroupCiphers.clear();
    localWifiConfiguration.allowedKeyManagement.clear();
    localWifiConfiguration.allowedPairwiseCiphers.clear();
    localWifiConfiguration.allowedProtocols.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\"");
    localWifiConfiguration.SSID = localStringBuilder.toString();
    if (paramString3 != null) {
      localWifiConfiguration.BSSID = paramString3;
    }
    paramString1 = p(paramString1);
    if (paramString1 != null) {
      a.removeNetwork(paramString1.networkId);
    }
    if (paramTPWifiCipherType == TPWifiCipherType.WIFICIPHER_NOPASS)
    {
      localWifiConfiguration.hiddenSSID = true;
      localWifiConfiguration.allowedKeyManagement.set(0);
    }
    else if (paramTPWifiCipherType == TPWifiCipherType.WIFICIPHER_WEP)
    {
      localWifiConfiguration.hiddenSSID = true;
      paramString3 = localWifiConfiguration.wepKeys;
      paramString1 = new StringBuilder();
      paramString1.append("\"");
      paramString1.append(paramString2);
      paramString1.append("\"");
      paramString3[0] = paramString1.toString();
      localWifiConfiguration.allowedAuthAlgorithms.set(1);
      localWifiConfiguration.allowedGroupCiphers.set(3);
      localWifiConfiguration.allowedGroupCiphers.set(2);
      localWifiConfiguration.allowedGroupCiphers.set(0);
      localWifiConfiguration.allowedGroupCiphers.set(1);
      localWifiConfiguration.allowedKeyManagement.set(0);
      localWifiConfiguration.wepTxKeyIndex = 0;
    }
    else if (paramTPWifiCipherType == TPWifiCipherType.WIFICIPHER_WPA)
    {
      paramString1 = new StringBuilder();
      paramString1.append("\"");
      paramString1.append(paramString2);
      paramString1.append("\"");
      localWifiConfiguration.preSharedKey = paramString1.toString();
      localWifiConfiguration.hiddenSSID = true;
      localWifiConfiguration.allowedAuthAlgorithms.set(0);
      localWifiConfiguration.allowedGroupCiphers.set(2);
      localWifiConfiguration.allowedKeyManagement.set(1);
      localWifiConfiguration.allowedPairwiseCiphers.set(1);
      localWifiConfiguration.allowedGroupCiphers.set(3);
      localWifiConfiguration.allowedPairwiseCiphers.set(2);
      localWifiConfiguration.status = 2;
    }
    else if (paramTPWifiCipherType == TPWifiCipherType.WIFI_CIPHER_WPA2)
    {
      paramString1 = new StringBuilder();
      paramString1.append("\"");
      paramString1.append(paramString2);
      paramString1.append("\"");
      localWifiConfiguration.preSharedKey = paramString1.toString();
      localWifiConfiguration.hiddenSSID = true;
      localWifiConfiguration.allowedAuthAlgorithms.set(0);
      localWifiConfiguration.allowedGroupCiphers.set(2);
      localWifiConfiguration.allowedKeyManagement.set(1);
      localWifiConfiguration.allowedPairwiseCiphers.set(1);
      localWifiConfiguration.allowedGroupCiphers.set(3);
      localWifiConfiguration.allowedPairwiseCiphers.set(2);
      localWifiConfiguration.status = 2;
    }
    return localWifiConfiguration;
  }
  
  public static b k()
  {
    b localb1 = b;
    b localb2 = localb1;
    if (localb1 == null) {
      try
      {
        localb1 = b;
        localb2 = localb1;
        if (localb1 == null)
        {
          localb2 = new com/tplink/libtpwifi/b;
          localb2.<init>();
          b = localb2;
        }
      }
      finally {}
    }
    return localb3;
  }
  
  private WifiConfiguration p(String paramString)
  {
    List localList;
    if ((Build.VERSION.SDK_INT >= 23) && (this.c.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0)) {
      localList = null;
    } else {
      localList = a.getConfiguredNetworks();
    }
    if ((localList != null) && (localList.size() > 0)) {
      for (int i = 0; i < localList.size(); i++)
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)localList.get(i);
        if (localWifiConfiguration != null)
        {
          String str = localWifiConfiguration.SSID;
          if (str != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("\"");
            localStringBuilder.append(paramString);
            localStringBuilder.append("\"");
            if (str.equals(localStringBuilder.toString())) {
              return localWifiConfiguration;
            }
          }
        }
      }
    }
    return null;
  }
  
  @TargetApi(29)
  private void t()
  {
    if (this.d != null)
    {
      ((ConnectivityManager)this.c.getSystemService("connectivity")).unregisterNetworkCallback(this.d);
      this.d = null;
    }
  }
  
  public void d(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      e(paramString1, null, paramString3, TPWifiCipherType.WIFICIPHER_NOPASS);
    } else {
      e(paramString1, paramString2, paramString3, TPWifiCipherType.WIFI_CIPHER_WPA2);
    }
  }
  
  public void e(String paramString1, String paramString2, String paramString3, TPWifiCipherType paramTPWifiCipherType)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      g(paramString1, paramString2, paramString3, paramTPWifiCipherType);
    } else {
      f(paramString1, paramString2, paramString3, paramTPWifiCipherType);
    }
  }
  
  public String j()
  {
    WifiInfo localWifiInfo = a.getConnectionInfo();
    if (localWifiInfo != null) {
      return localWifiInfo.getBSSID();
    }
    return "";
  }
  
  public String l()
  {
    WifiInfo localWifiInfo = a.getConnectionInfo();
    if (localWifiInfo != null) {
      return localWifiInfo.getSSID();
    }
    return "";
  }
  
  public WifiManager m()
  {
    return a;
  }
  
  public void n(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }
  }
  
  public void o(Application paramApplication)
  {
    this.c = paramApplication;
    a = (WifiManager)paramApplication.getSystemService("wifi");
  }
  
  public boolean q(String paramString)
  {
    WifiInfo localWifiInfo = a.getConnectionInfo();
    if ((localWifiInfo != null) && (paramString != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\"");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\"");
      if ((localStringBuilder.toString().equals(localWifiInfo.getSSID())) && (!TextUtils.isEmpty(localWifiInfo.getBSSID())) && (!localWifiInfo.getBSSID().equals("00:00:00:00:00:00")))
      {
        bool = true;
        break label89;
      }
    }
    boolean bool = false;
    label89:
    return bool;
  }
  
  public boolean r()
  {
    return a.isWifiEnabled();
  }
  
  public void s()
  {
    a.startScan();
  }
  
  public void u(WifiConfiguration paramWifiConfiguration)
  {
    if (paramWifiConfiguration == null) {
      return;
    }
    Object localObject = null;
    if ((Build.VERSION.SDK_INT < 23) || (this.c.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0)) {
      localObject = a.getConfiguredNetworks();
    }
    if (localObject == null) {
      localObject = Collections.emptyList();
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (WifiConfiguration)localIterator.next();
      if (((WifiConfiguration)localObject).priority >= 99999)
      {
        ((WifiConfiguration)localObject).priority = 99998;
        a.updateNetwork((WifiConfiguration)localObject);
      }
    }
    paramWifiConfiguration.priority = 99999;
    a.updateNetwork(paramWifiConfiguration);
  }
  
  class a
    extends ConnectivityManager.NetworkCallback
  {
    a(String paramString) {}
    
    public void onLost(Network paramNetwork)
    {
      super.onLost(paramNetwork);
      b.a(b.this);
    }
    
    public void onUnavailable()
    {
      super.onUnavailable();
      b.a(b.this);
      b.b(b.this, "com.tplink.tpm5.wifi.le.ACTION_WIFI_CONNECT_FAIL", paramString1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpwifi\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */