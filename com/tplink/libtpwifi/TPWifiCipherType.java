package com.tplink.libtpwifi;

public enum TPWifiCipherType
{
  static
  {
    TPWifiCipherType localTPWifiCipherType1 = new TPWifiCipherType("WIFICIPHER_WEP", 0);
    WIFICIPHER_WEP = localTPWifiCipherType1;
    TPWifiCipherType localTPWifiCipherType2 = new TPWifiCipherType("WIFICIPHER_WPA", 1);
    WIFICIPHER_WPA = localTPWifiCipherType2;
    TPWifiCipherType localTPWifiCipherType3 = new TPWifiCipherType("WIFICIPHER_NOPASS", 2);
    WIFICIPHER_NOPASS = localTPWifiCipherType3;
    TPWifiCipherType localTPWifiCipherType4 = new TPWifiCipherType("WIFI_CIPHER_WPA2", 3);
    WIFI_CIPHER_WPA2 = localTPWifiCipherType4;
    TPWifiCipherType localTPWifiCipherType5 = new TPWifiCipherType("WIFI_CIPHER_WPA3", 4);
    WIFI_CIPHER_WPA3 = localTPWifiCipherType5;
    $VALUES = new TPWifiCipherType[] { localTPWifiCipherType1, localTPWifiCipherType2, localTPWifiCipherType3, localTPWifiCipherType4, localTPWifiCipherType5 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpwifi\TPWifiCipherType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */