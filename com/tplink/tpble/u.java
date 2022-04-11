package com.tplink.tpble;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.os.Build.VERSION;
import io.reactivex.e0.b;
import io.reactivex.q;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

class u
{
  private BluetoothAdapter a;
  private v b;
  private List<String> c = new ArrayList();
  private List<t> d = new ArrayList();
  private io.reactivex.m0.g<List<t>> e;
  private b f;
  private BluetoothAdapter.LeScanCallback g = new a();
  
  u(Application paramApplication, v paramv)
  {
    paramApplication = (BluetoothManager)paramApplication.getSystemService("bluetooth");
    if (paramApplication != null) {
      this.a = paramApplication.getAdapter();
    }
    this.b = paramv;
    this.e = io.reactivex.m0.d.n1();
    this.f = new b();
  }
  
  private List<t> f()
  {
    if (!this.d.isEmpty()) {
      Collections.sort(this.d, i.c);
    }
    return this.d;
  }
  
  private void g()
  {
    if ((!this.e.j1()) && (!this.e.k1())) {
      this.e.onComplete();
    }
    b localb = this.f;
    if (localb != null) {
      localb.d();
    }
  }
  
  private void h(Throwable paramThrowable)
  {
    if ((!this.e.j1()) && (!this.e.k1())) {
      this.e.onError(paramThrowable);
    }
    paramThrowable = this.f;
    if (paramThrowable != null) {
      paramThrowable.d();
    }
  }
  
  private boolean i(List<UUID> paramList, String paramString)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      for (int i = 0; i < paramList.size(); i++) {
        if (((UUID)paramList.get(i)).toString().equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private List<UUID> u(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
    while (paramArrayOfByte.remaining() > 2)
    {
      int i = paramArrayOfByte.get();
      if (i == 0) {
        break;
      }
      int j = paramArrayOfByte.get();
      int k = i;
      if (j != 2)
      {
        k = i;
        if (j != 3)
        {
          k = i;
          if (j != 6)
          {
            k = i;
            if (j != 7)
            {
              paramArrayOfByte.position(paramArrayOfByte.position() + i - 1);
              continue;
            }
          }
          while (k >= 16)
          {
            long l = paramArrayOfByte.getLong();
            localArrayList.add(new UUID(paramArrayOfByte.getLong(), l));
            k = (byte)(k - 16);
          }
          continue;
        }
      }
      while (k >= 2)
      {
        localArrayList.add(UUID.fromString(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[] { Short.valueOf(paramArrayOfByte.getShort()) })));
        k = (byte)(k - 2);
      }
    }
    return localArrayList;
  }
  
  private void v()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = UUID.fromString(this.b.a());
      BluetoothAdapter localBluetoothAdapter = this.a;
      if (localBluetoothAdapter != null)
      {
        BluetoothAdapter.LeScanCallback localLeScanCallback = this.g;
        localBluetoothAdapter.startLeScan(new UUID[] { localObject }, localLeScanCallback);
      }
    }
    else
    {
      localObject = this.a;
      if (localObject != null) {
        ((BluetoothAdapter)localObject).startLeScan(this.g);
      }
    }
  }
  
  private void w()
  {
    this.f.b(q.c0(5000L, TimeUnit.MILLISECONDS).Q0(2L).F(new c(this)).I0(new e(this), new f(this), new g(this)));
  }
  
  q<List<t>> x()
  {
    return q.f0(Boolean.TRUE).N(new d(this)).q0(new ArrayList()).y(new h(this));
  }
  
  void y()
  {
    BluetoothAdapter localBluetoothAdapter = this.a;
    if (localBluetoothAdapter != null) {
      localBluetoothAdapter.stopLeScan(this.g);
    }
  }
  
  class a
    implements BluetoothAdapter.LeScanCallback
  {
    a() {}
    
    public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        List localList = u.a(u.this, paramArrayOfByte);
        paramArrayOfByte = u.this;
        if (!u.c(paramArrayOfByte, localList, u.b(paramArrayOfByte).a())) {
          return;
        }
      }
      if ((paramBluetoothDevice != null) && (paramBluetoothDevice.getAddress() != null) && (!u.d(u.this).contains(paramBluetoothDevice.getAddress())))
      {
        u.d(u.this).add(paramBluetoothDevice.getAddress());
        u.e(u.this).add(new t(paramInt, paramBluetoothDevice));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tpble\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */