package com.tplink.libtpstreamclientmanager;

import b.d.d.d.a;
import b.d.d.d.b;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;

public class n
{
  public static void a()
  {
    b.a(new a());
  }
  
  class a
    implements a
  {
    public boolean a(String paramString)
    {
      paramString = TPStreamConnectionManager.a(paramString);
      if (paramString != null) {
        return paramString.isP2PAvailable();
      }
      return false;
    }
    
    public String b(String paramString)
    {
      paramString = TPStreamConnectionManager.a(paramString);
      if (paramString != null) {
        paramString = paramString.getLocalIp();
      } else {
        paramString = null;
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    public TPMediaDevice c(String paramString)
    {
      return TPStreamConnectionManager.a(paramString);
    }
    
    public String d(String paramString)
    {
      paramString = TPStreamConnectionManager.a(paramString);
      if (paramString != null) {
        paramString = paramString.getUserSharePassword();
      } else {
        paramString = null;
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    public boolean e(String paramString)
    {
      paramString = TPStreamConnectionManager.a(paramString);
      if (paramString != null) {
        return paramString.isDeviceLocal();
      }
      return false;
    }
    
    public boolean f(String paramString)
    {
      paramString = TPStreamConnectionManager.a(paramString);
      if (paramString != null) {
        return paramString.isUserRoleTypeDevice();
      }
      return false;
    }
    
    public boolean g(String paramString)
    {
      boolean bool;
      if (TPStreamConnectionManager.a(paramString) == null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean h(String paramString)
    {
      paramString = TPStreamConnectionManager.a(paramString);
      if (paramString != null) {
        return paramString.isDeviceRemoteOnline();
      }
      return false;
    }
    
    public String i(String paramString)
    {
      paramString = TPStreamConnectionManager.a(paramString);
      if (paramString != null) {
        paramString = paramString.getUserShareUsername();
      } else {
        paramString = null;
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreamclientmanager\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */