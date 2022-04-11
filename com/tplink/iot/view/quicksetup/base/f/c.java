package com.tplink.iot.view.quicksetup.base.f;

import android.app.Application;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.tplink.iot.view.quicksetup.base.DeviceLocationInfo;
import io.reactivex.g0.j;
import io.reactivex.m0.d;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class c
{
  private static volatile c a;
  private Context b;
  private LocationManager c;
  private b d;
  private g<DeviceLocationInfo> e = d.n1();
  
  private String e()
  {
    Object localObject1 = new Criteria();
    ((Criteria)localObject1).setAccuracy(1);
    CharSequence localCharSequence;
    try
    {
      localObject1 = this.c.getBestProvider((Criteria)localObject1, true);
    }
    catch (Exception localException)
    {
      localCharSequence = null;
    }
    Object localObject2 = localCharSequence;
    if (TextUtils.isEmpty(localCharSequence)) {
      localObject2 = "gps";
    }
    return (String)localObject2;
  }
  
  private DeviceLocationInfo f(Location paramLocation)
  {
    if (paramLocation != null)
    {
      int i = (int)(paramLocation.getLongitude() * 10000.0D);
      int j = (int)(paramLocation.getLatitude() * 10000.0D);
      if ((i != 0) || (j != 0)) {
        return new DeviceLocationInfo(Integer.valueOf(i), Integer.valueOf(j));
      }
    }
    return new DeviceLocationInfo();
  }
  
  public static c h()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          c localc = new com/tplink/iot/view/quicksetup/base/f/c;
          localc.<init>();
          a = localc;
        }
      }
      finally {}
    }
    return a;
  }
  
  private Location i(Context paramContext)
  {
    if (this.c == null) {
      return null;
    }
    if ((ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION") != 0) && (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_COARSE_LOCATION") != 0)) {
      return null;
    }
    try
    {
      paramContext = this.c.getProviders(true);
    }
    catch (Exception paramContext)
    {
      paramContext = null;
    }
    if ((paramContext != null) && (!paramContext.isEmpty()))
    {
      Iterator localIterator = paramContext.iterator();
      for (Context localContext = null; localIterator.hasNext(); localContext = paramContext)
      {
        label69:
        paramContext = (String)localIterator.next();
        try
        {
          paramContext = this.c.getLastKnownLocation(paramContext);
        }
        catch (SecurityException paramContext)
        {
          paramContext = null;
        }
        if ((paramContext == null) || ((localContext != null) && (paramContext.getAccuracy() >= localContext.getAccuracy()))) {
          break label69;
        }
      }
      return localContext;
    }
    return null;
  }
  
  private t<DeviceLocationInfo> k()
  {
    Location localLocation1 = i(this.b);
    Location localLocation2 = localLocation1;
    if (localLocation1 == null) {
      localLocation2 = n();
    }
    if (localLocation2 != null) {
      return q.f0(f(localLocation2));
    }
    return l();
  }
  
  private t<DeviceLocationInfo> l()
  {
    if (this.c == null) {
      return q.f0(new DeviceLocationInfo());
    }
    Object localObject = e();
    b localb = new b(new d(), this.c);
    this.d = localb;
    try
    {
      this.c.requestLocationUpdates((String)localObject, 60000L, 1000.0F, localb);
      localObject = this.e;
      return (t<DeviceLocationInfo>)localObject;
    }
    catch (SecurityException localSecurityException) {}
    return q.f0(new DeviceLocationInfo());
  }
  
  private void m()
  {
    LocationManager localLocationManager = this.c;
    b localb;
    if (localLocationManager != null)
    {
      localb = this.d;
      if (localb == null) {}
    }
    try
    {
      localLocationManager.removeUpdates(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private Location n()
  {
    Object localObject1 = this.c;
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    localObject1 = e();
    try
    {
      localObject1 = this.c.getLastKnownLocation((String)localObject1);
      localObject2 = localObject1;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
    return (Location)localObject2;
  }
  
  public q<DeviceLocationInfo> g(long paramLong)
  {
    return q.f0(Boolean.valueOf(a.a(this.b))).N(new c()).T0(paramLong, TimeUnit.MILLISECONDS).q0(new DeviceLocationInfo()).A(new b()).y(new a());
  }
  
  public void j(@NonNull Application paramApplication)
  {
    Object localObject = paramApplication;
    if (com.tplink.iot.Utils.a1.a.b()) {
      localObject = paramApplication.createAttributionContext("AttrTagTPLocationManager");
    }
    this.b = ((Context)localObject);
    this.c = ((LocationManager)((Context)localObject).getSystemService("location"));
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a() {}
    
    public void run()
      throws Exception
    {
      c.a(c.this);
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b() {}
    
    public void run()
      throws Exception
    {
      c.a(c.this);
    }
  }
  
  class c
    implements j<Boolean, t<DeviceLocationInfo>>
  {
    c() {}
    
    public t<DeviceLocationInfo> a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue()) {
        return c.b(c.this);
      }
      return q.f0(new DeviceLocationInfo());
    }
  }
  
  class d
    implements LocationListener
  {
    d() {}
    
    public void onLocationChanged(Location paramLocation)
    {
      c.d(c.this).onNext(c.c(c.this, paramLocation));
      if ((!c.d(c.this).j1()) && (!c.d(c.this).k1())) {
        c.d(c.this).onComplete();
      }
    }
    
    public void onProviderDisabled(String paramString) {}
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */