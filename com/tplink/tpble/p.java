package com.tplink.tpble;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import io.reactivex.m0.d;
import io.reactivex.m0.g;
import io.reactivex.t;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class p
{
  private static int a = 0;
  private static int b = 18;
  private static final List<byte[]> c = Collections.synchronizedList(new ArrayList());
  private static boolean d = false;
  private Application e;
  private BluetoothAdapter f;
  private BluetoothGatt g;
  private BluetoothGattCharacteristic h;
  private BluetoothGattCharacteristic i;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private int o = 0;
  private s p;
  private boolean q;
  private n r;
  private g<q> s = d.n1();
  private final BluetoothGattCallback t = new a();
  
  p(s params, n paramn)
  {
    this.p = params;
    this.r = paramn;
    params = r.b().a();
    this.e = params;
    params = (BluetoothManager)params.getSystemService("bluetooth");
    if (params != null) {
      this.f = params.getAdapter();
    }
  }
  
  private void D(q paramq)
  {
    F();
    v();
    H(paramq);
  }
  
  private void E()
  {
    z(new q(0));
  }
  
  private void F()
  {
    this.n = false;
    this.j = false;
    this.k = false;
    this.l = false;
    this.q = false;
    d = false;
    this.m = false;
    this.o = 0;
  }
  
  private void H(q paramq)
  {
    z(paramq);
    n localn = this.r;
    if (localn != null)
    {
      localn.a(paramq, EnumBLEStatus.BLE_STATUS_DISCONNECTED);
      this.r = null;
    }
  }
  
  private void I(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    if (paramBluetoothGattCharacteristic != null) {
      J(paramBluetoothGattCharacteristic.getValue());
    }
  }
  
  private void J(byte[] paramArrayOfByte)
  {
    n localn = this.r;
    if ((localn != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      localn.e(paramArrayOfByte);
    }
  }
  
  private void L()
  {
    synchronized (c)
    {
      if (???.size() > 0)
      {
        Object localObject1 = (byte[])???.get(0);
        if ((localObject1 != null) && (localObject1.length != 0))
        {
          if (M((byte[])localObject1))
          {
            a = 0;
          }
          else
          {
            localObject1 = new android/os/Handler;
            ((Handler)localObject1).<init>(Looper.getMainLooper());
            b localb = new com/tplink/tpble/b;
            localb.<init>(this);
            ((Handler)localObject1).postDelayed(localb, 100L);
          }
        }
        else {
          return;
        }
      }
      return;
    }
  }
  
  private boolean M(byte[] paramArrayOfByte)
  {
    BluetoothGattCharacteristic localBluetoothGattCharacteristic = this.i;
    if ((localBluetoothGattCharacteristic != null) && (this.g != null))
    {
      if (this.l) {
        return false;
      }
      this.l = true;
      localBluetoothGattCharacteristic.setWriteType(2);
      this.i.setValue(paramArrayOfByte);
      return this.g.writeCharacteristic(this.i);
    }
    return false;
  }
  
  private void v()
  {
    BluetoothGatt localBluetoothGatt = this.g;
    if (localBluetoothGatt != null)
    {
      localBluetoothGatt.close();
      this.g = null;
    }
  }
  
  private void y(List<BluetoothGattService> paramList)
  {
    do
    {
      paramList = paramList.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (BluetoothGattService)paramList.next();
        } while (!((BluetoothGattService)localObject).getUuid().toString().equalsIgnoreCase(this.p.d()));
        localObject = ((BluetoothGattService)localObject).getCharacteristics().iterator();
      }
      BluetoothGattCharacteristic localBluetoothGattCharacteristic = (BluetoothGattCharacteristic)((Iterator)localObject).next();
      if (localBluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(this.p.c()))
      {
        this.h = localBluetoothGattCharacteristic;
        this.j = true;
      }
      else if (localBluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(this.p.e()))
      {
        this.i = localBluetoothGattCharacteristic;
        this.k = true;
      }
    } while ((!this.j) || (!this.k));
    this.n = true;
    E();
    return;
    if (!this.j) {
      D(new q(6, "bluetooth is not readable"));
    }
    if (!this.k) {
      D(new q(7, "bluetooth is not writable"));
    }
  }
  
  private void z(q paramq)
  {
    g localg = this.s;
    if (localg != null)
    {
      localg.onNext(paramq);
      if ((!this.s.j1()) && (!this.s.k1())) {
        this.s.onComplete();
      }
    }
  }
  
  boolean G()
  {
    if (!this.n) {
      return false;
    }
    if (this.f != null)
    {
      BluetoothGatt localBluetoothGatt = this.g;
      if (localBluetoothGatt != null)
      {
        if (this.l) {
          return false;
        }
        if (this.m)
        {
          L();
          return false;
        }
        this.l = true;
        return localBluetoothGatt.readCharacteristic(this.h);
      }
    }
    return false;
  }
  
  void K(byte[] paramArrayOfByte)
  {
    if (!this.n) {
      return;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (paramArrayOfByte.length <= b)
      {
        c.add(paramArrayOfByte);
        this.m = true;
      }
      else
      {
        int i1 = 0;
        int i3;
        for (;;)
        {
          int i2 = paramArrayOfByte.length;
          i3 = b;
          if (i1 >= i2 / i3) {
            break;
          }
          i2 = i1 + 1;
          byte[] arrayOfByte = Arrays.copyOfRange(paramArrayOfByte, i3 * i1, i3 * i2);
          i1 = i2;
          if (arrayOfByte.length > 0)
          {
            c.add(arrayOfByte);
            this.m = true;
            i1 = i2;
          }
        }
        paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, i3 * i1, paramArrayOfByte.length);
        if (paramArrayOfByte.length > 0)
        {
          c.add(paramArrayOfByte);
          this.m = true;
        }
      }
      if (!d)
      {
        d = true;
        new Handler(Looper.getMainLooper()).postDelayed(new a(this), 200L);
      }
    }
  }
  
  t<q> w()
  {
    if (this.f == null)
    {
      D(new q(2, "Bluetooth Adapter is null"));
      return this.s;
    }
    if (this.p.a() == null)
    {
      D(new q(3, "Bluetooth Address is null"));
      return this.s;
    }
    Object localObject = this.g;
    if (localObject != null)
    {
      if (!((BluetoothGatt)localObject).connect()) {
        D(new q(4, "Bluetooth reConnect fail"));
      }
      return this.s;
    }
    localObject = this.f.getRemoteDevice(this.p.a());
    if (localObject == null)
    {
      D(new q(5, "Bluetooth device is null"));
      return this.s;
    }
    if (this.g != null)
    {
      F();
      v();
    }
    this.g = ((BluetoothDevice)localObject).connectGatt(this.e, false, this.t);
    return this.s;
  }
  
  void x()
  {
    F();
    BluetoothGatt localBluetoothGatt = this.g;
    if (localBluetoothGatt != null) {
      localBluetoothGatt.disconnect();
    }
  }
  
  class a
    extends BluetoothGattCallback
  {
    a() {}
    
    public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
    {
      p.f(p.this, paramBluetoothGattCharacteristic);
    }
    
    public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
    {
      if (paramBluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(p.p(p.this).c()))
      {
        p.u(p.this, false);
        if (paramInt == 0)
        {
          if (paramBluetoothGattCharacteristic.getValue() != null)
          {
            paramInt = paramBluetoothGattCharacteristic.getValue().length;
            if ((paramInt > 20) && (paramInt > p.d()))
            {
              p.e(paramInt);
              if (p.d() >= p.p(p.this).b()) {
                p.e(p.p(p.this).b() - 5);
              }
            }
          }
          p.f(p.this, paramBluetoothGattCharacteristic);
        }
      }
    }
    
    public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
    {
      if (paramBluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(p.p(p.this).e()))
      {
        if ((p.g() != null) && (p.g().size() > 0)) {
          p.g().remove(0);
        }
        p.u(p.this, false);
        if ((p.g() != null) && (p.g().size() > 0))
        {
          p.h(p.this, true);
          p.i(p.this);
        }
        else
        {
          p.h(p.this, false);
          p.j(false);
        }
      }
    }
    
    public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
    {
      if (paramInt1 == 0)
      {
        if (paramInt2 == 2)
        {
          p.l(p.this, 0);
          p.o(p.this, true);
          if (Build.VERSION.SDK_INT >= 21)
          {
            if (x.a().b("request_mtu_fail", 0) >= 2) {
              p.a(p.this).discoverServices();
            } else {
              p.a(p.this).requestMtu(p.p(p.this).b());
            }
          }
          else {
            p.a(p.this).discoverServices();
          }
        }
        else if (paramInt2 == 0)
        {
          p.c(p.this, new q(12, "bluetooth state disconnected"));
        }
        else
        {
          p.c(p.this, new q(13, "bluetooth state unknown"));
        }
      }
      else if ((!p.n(p.this)) && (p.k(p.this) < 5))
      {
        p.m(p.this);
        p.q(p.this);
        p.this.w();
      }
      else if ((p.n(p.this)) && (p.a(p.this) != null))
      {
        p.r(p.this);
        p.a(p.this).disconnect();
        p.b(p.this, null);
        p.s(p.this, new q(10, "bluetooth state fail and bluetooth is connected"));
      }
      else
      {
        p.c(p.this, new q(9, "bluetooth state fail and bluetooth is not connected"));
      }
    }
    
    public void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0)
      {
        x.a().d("request_mtu_fail", 0);
        p.a(p.this).discoverServices();
      }
      else
      {
        paramInt1 = x.a().b("request_mtu_fail", 0);
        if (paramInt1 < 2) {
          x.a().d("request_mtu_fail", paramInt1 + 1);
        }
        p.c(p.this, new q(11, "bluetooth mtu changed fail"));
      }
    }
    
    public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
    {
      if (paramInt == 0) {
        p.t(p.this, paramBluetoothGatt.getServices());
      } else {
        p.c(p.this, new q(8, "bluetooth services discover failed"));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tpble\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */