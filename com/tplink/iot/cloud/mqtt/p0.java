package com.tplink.iot.cloud.mqtt;

import b.d.b.d.a.a.c;
import com.google.gson.Gson;
import com.tplink.iot.cloud.bean.auth.params.AuthParams;
import com.tplink.iot.cloud.bean.common.AsyncResult;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPingSender;
import org.eclipse.paho.client.mqttv3.ScheduledExecutorPingSender;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class p0
  implements MqttCallbackExtended, IMqttMessageListener
{
  private static final String a = "p0";
  private static final Gson b = new com.google.gson.d().c().b();
  private String c = m0(paramString);
  private String d;
  private com.tplink.iot.c.c.b e;
  private MqttConnectOptions f;
  private SSLSocketFactory g;
  private MqttClientPersistence h;
  private MqttPingSender i;
  private MqttAsyncClient j = null;
  private volatile boolean k = true;
  private volatile boolean l = false;
  private boolean m = true;
  private String n;
  private io.reactivex.m0.g<Boolean> o = io.reactivex.m0.a.n1();
  private String p;
  private Set<q0> q = new HashSet();
  private final ConcurrentHashMap<String, r0> r = new ConcurrentHashMap();
  
  public p0(String paramString, com.tplink.iot.c.c.b paramb, MqttClientPersistence paramMqttClientPersistence)
  {
    this.e = paramb;
    this.d = paramb.g();
    this.p = String.format("$tpiot/apps/%1$s/%2$s/api/reply", new Object[] { paramb.i(), paramb.j() });
    this.n = String.format("$tpiot/app/%s/refresh/reply", new Object[] { this.d });
    paramString = new MqttConnectOptions();
    this.f = paramString;
    paramString.setUserName(paramb.k());
    this.f.setMqttVersion(4);
    this.f.setKeepAliveInterval(235);
    this.f.setHttpsHostnameVerificationEnabled(false);
    this.g = b.d.b.d.a.a.c(Collections.singletonList("-----BEGIN CERTIFICATE-----\nMIIDBzCCAe+gAwIBAgIQT5x0ma7QnINHCQvhnmzR9zANBgkqhkiG9w0BAQsFADAV\nMRMwEQYDVQQDEwp0cC1saW5rLUNBMCAXDTE4MDExOTA4Mjc1MloYDzIwNjgwMTE5\nMDgzNzUyWjAVMRMwEQYDVQQDEwp0cC1saW5rLUNBMIIBIjANBgkqhkiG9w0BAQEF\nAAOCAQ8AMIIBCgKCAQEAuGG8n5zEUN1j5wuvUz4pAIMurhKHbpfUUu+b2acFHKS6\niU9hNJWvDyhXcihY5Wz6aq9m4D5SZcgW3k31YoNNtrztDjdg2qw7AaX85S99/G0B\nVbIXktrhs34OW19WA/haDwut3dFhLem+gCRRKUXcmuqchZc84dY7JFVfhPcJci4m\nsRjLCFNO0ho9OX+MZwfO4BLaeAqKVoAor6rf4BXVtO0xjYHDKO0fb3AWLLJ4EjGe\nq6YieqPiYlPFEqRm5PrvBXTm0IuQogygyVpK4LHr/K207ZLyV33DxLLbsUgSEJVn\npZUv/WUujXjlIDgxIvyZZCYiXO3dle2/MEvpmZk6JQIDAQABo1EwTzALBgNVHQ8E\nBAMCAYYwDwYDVR0TAQH/BAUwAwEB/zAdBgNVHQ4EFgQUxu2iBRTsef5iNnsADVhM\nJDQWi6kwEAYJKwYBBAGCNxUBBAMCAQAwDQYJKoZIhvcNAQELBQADggEBAB52Majd\n+wo3cb5BsTo63z2Psbbyl4ACMUaw68NxUMy61Oihx3mcLzLJqiIZcKePiHskLqLJ\nF7QfT9TqjvizMjFJVgsLuVubUBXKBzqyN+3KKlQci0PO3mH+ObhyaE7BzV+qrS3P\ndVTgsCWFv8DkgLTRudSWxL7VwVoedc7lRz5EroGgJ33nRGCR0ngcW919tLTARDQO\npULmzulcdWeZgG+0PLX0xjJQIjFEvbOxR1Z+gxMupBz0rWFokmWYrcga8eWiWzjQ\nIa3/ASBVJ69srV77trWlfLumkChbXk9i64NXBKnce0Jmll0Y9OC1nMPqrbQKnzcn\ndSAA4fejD/qMQn0=\n-----END CERTIFICATE-----")).c();
    this.h = paramMqttClientPersistence;
  }
  
  private q<MqttWireMessage> V(String paramString, MqttMessage paramMqttMessage)
  {
    return q.m(new d(this, paramString, paramMqttMessage));
  }
  
  private q<Boolean> W()
  {
    return q.m(new l(this)).F(new o(this)).C(new n(this));
  }
  
  private void X(long paramLong, final io.reactivex.b paramb)
    throws MqttException
  {
    if (o()) {
      this.j.disconnect(paramLong, null, new b(paramb));
    } else {
      paramb.onComplete();
    }
  }
  
  private void Y(String paramString, MqttMessage paramMqttMessage, final r<MqttWireMessage> paramr)
    throws MqttException
  {
    if (o())
    {
      this.j.publish(paramString, paramMqttMessage, null, new c(paramr));
    }
    else
    {
      b.d.w.c.a.c(a, "Client is not connected, so not sending message");
      paramr.onError(new MqttException(32104));
    }
  }
  
  private void Z(final String[] paramArrayOfString, IMqttMessageListener[] paramArrayOfIMqttMessageListener, final r<MqttWireMessage> paramr)
    throws MqttException
  {
    String str = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("subscribe({");
    ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfString));
    ((StringBuilder)localObject).append("})");
    b.d.w.c.a.c(str, ((StringBuilder)localObject).toString());
    if (paramArrayOfString.length == 0)
    {
      b.d.w.c.a.c(str, "Available Topic is None, so not need to subscribe");
      paramr.onComplete();
    }
    else if (o())
    {
      localObject = new int[paramArrayOfString.length];
      Arrays.fill((int[])localObject, 1);
      this.j.subscribe(paramArrayOfString, (int[])localObject, null, new d(paramArrayOfString, paramr), paramArrayOfIMqttMessageListener);
    }
    else
    {
      b.d.w.c.a.c(str, "Client is not connected, so not subscribe");
      l0(paramArrayOfString, 3);
      paramr.onError(new MqttException(32104));
    }
  }
  
  private void a0(final String[] paramArrayOfString, final io.reactivex.b paramb)
    throws MqttException
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unsubscribe({");
    localStringBuilder.append(Arrays.toString(paramArrayOfString));
    localStringBuilder.append("})");
    b.d.w.c.a.c(str, localStringBuilder.toString());
    if (paramArrayOfString.length == 0)
    {
      b.d.w.c.a.c(str, "Available Topic is None, so not unsubscribe");
      paramb.onComplete();
    }
    else if (o())
    {
      this.j.unsubscribe(paramArrayOfString, null, new e(paramArrayOfString, paramb));
    }
    else
    {
      b.d.w.c.a.c(str, "Client is not connected, so not unsubscribe");
      l0(paramArrayOfString, 3);
      paramb.onError(new MqttException(32104));
    }
  }
  
  private io.reactivex.a c0(String paramString1, String paramString2)
  {
    return i(paramString1, paramString2, true).Z().c(j().C(io.reactivex.l0.a.c()));
  }
  
  private void d0(boolean paramBoolean)
  {
    try
    {
      this.l = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void e0(boolean paramBoolean)
  {
    try
    {
      this.k = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private MqttMessage f()
  {
    return new MqttMessage(b.u(new AuthParams(this.e.i(), this.e.j(), this.e.e())).getBytes());
  }
  
  private q<MqttWireMessage> f0(String paramString, IMqttMessageListener paramIMqttMessageListener)
  {
    return g0(new String[] { paramString }, new IMqttMessageListener[] { paramIMqttMessageListener });
  }
  
  private q<Boolean> g()
  {
    if (this.l)
    {
      String str = a;
      b.d.w.c.a.c(str, "mDelegateClient != null and the client is connecting. Connect return directly.");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Connect return:mIsConnecting:");
      localStringBuilder.append(this.l);
      localStringBuilder.append(".disconnected:");
      localStringBuilder.append(this.k);
      b.d.w.c.a.c(str, localStringBuilder.toString());
      return q.J(new MqttException(32110));
    }
    if (!this.k)
    {
      b.d.w.c.a.c(a, "mDelegateClient != null and the client is connected and notify!");
      d0(false);
      e0(false);
      return q.f0(Boolean.TRUE);
    }
    return W();
  }
  
  private q<MqttWireMessage> g0(String[] paramArrayOfString, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
  {
    return q.m(new g(this, paramArrayOfString, paramArrayOfIMqttMessageListener));
  }
  
  private q<Boolean> i(String paramString1, String paramString2, boolean paramBoolean)
  {
    return io.reactivex.a.n(new p(this, paramString1, paramString2, paramBoolean)).d(g());
  }
  
  private io.reactivex.a i0(String paramString)
  {
    return j0(new String[] { paramString });
  }
  
  private io.reactivex.a j0(String[] paramArrayOfString)
  {
    return io.reactivex.a.g(new c(this, paramArrayOfString));
  }
  
  private void l(String[] paramArrayOfString, IMqttMessageListener[] paramArrayOfIMqttMessageListener, List<String> paramList, List<IMqttMessageListener> paramList1)
  {
    ConcurrentHashMap localConcurrentHashMap = this.r;
    IMqttMessageListener localIMqttMessageListener = null;
    int i1 = 0;
    try
    {
      while (i1 < paramArrayOfString.length)
      {
        String str = paramArrayOfString[i1];
        if (paramArrayOfIMqttMessageListener != null) {
          localIMqttMessageListener = paramArrayOfIMqttMessageListener[i1];
        }
        if ((!str.equals(this.p)) && (!str.equals(this.n)))
        {
          r0 localr0 = (r0)this.r.get(str);
          if (localr0 != null)
          {
            localr0.e(localIMqttMessageListener);
            if (localr0.c())
            {
              localr0.f(0);
              paramList.add(str);
              paramList1.add(localIMqttMessageListener);
            }
          }
          else
          {
            localr0 = new com/tplink/iot/cloud/mqtt/r0;
            localr0.<init>(str, 0, localIMqttMessageListener);
            paramList.add(str);
            paramList1.add(localIMqttMessageListener);
            this.r.put(str, localr0);
          }
        }
        else
        {
          paramList.add(str);
          paramList1.add(localIMqttMessageListener);
        }
        i1++;
      }
      return;
    }
    finally {}
  }
  
  private void l0(String[] paramArrayOfString, int paramInt)
  {
    synchronized (this.r)
    {
      int i1 = paramArrayOfString.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        String str = paramArrayOfString[i2];
        r0 localr0 = (r0)this.r.get(str);
        if (localr0 != null) {
          localr0.f(paramInt);
        }
        if (paramInt == 3) {
          this.r.remove(str);
        }
      }
      return;
    }
  }
  
  private String[] m(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = paramArrayOfString.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      String str = paramArrayOfString[i2];
      r0 localr0 = (r0)this.r.get(str);
      if ((localr0 != null) && (localr0.d()))
      {
        localr0.f(2);
        localArrayList.add(str);
      }
    }
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  private String m0(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.contains("://"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("wss://");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    int i1 = ((String)localObject).indexOf("://") + 3;
    paramString = (String)localObject;
    if (((String)localObject).indexOf(":", i1) == -1)
    {
      boolean bool = ((String)localObject).startsWith("tcp://");
      paramString = ":443";
      if (bool) {
        paramString = ":1883";
      } else if ((!((String)localObject).startsWith("ssl://")) && (((String)localObject).startsWith("ws://"))) {
        paramString = ":8883";
      }
      i1 = ((String)localObject).indexOf("/", i1);
      StringBuilder localStringBuilder;
      if (i1 != -1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((String)localObject).substring(0, i1));
        localStringBuilder.append(paramString);
        localStringBuilder.append(((String)localObject).substring(i1));
        paramString = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
      }
    }
    return paramString;
  }
  
  private void n(String paramString1, String paramString2, boolean paramBoolean)
    throws MqttException
  {
    if (this.j == null)
    {
      Object localObject = Executors.newScheduledThreadPool(5);
      this.i = new ScheduledExecutorPingSender((ScheduledExecutorService)localObject);
      localObject = new MqttAsyncClient(this.c, this.d, this.h, this.i, (ScheduledExecutorService)localObject);
      this.j = ((MqttAsyncClient)localObject);
      ((MqttAsyncClient)localObject).setCallback(this);
    }
    if (paramString1 == null)
    {
      this.f.setSocketFactory(this.g);
    }
    else
    {
      paramString1 = m0(paramString1);
      if ((!paramString1.startsWith("ssl://")) && (!paramString1.startsWith("wss://"))) {
        this.f.setSocketFactory(null);
      } else {
        this.f.setSocketFactory(this.g);
      }
      this.f.setServerURIs(new String[] { paramString1 });
    }
    this.f.setPassword(paramString2.toCharArray());
    this.f.setCleanSession(paramBoolean);
  }
  
  public static boolean q(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof MqttException))
    {
      paramThrowable = (MqttException)paramThrowable;
      if ((paramThrowable.getReasonCode() == 32000) || (paramThrowable.getReasonCode() == 32002)) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  private boolean r()
  {
    if (this.r.isEmpty()) {
      return true;
    }
    Iterator localIterator = this.r.values().iterator();
    while (localIterator.hasNext()) {
      if (((r0)localIterator.next()).b() != 3) {
        return false;
      }
    }
    return true;
  }
  
  public q<Boolean> b0()
  {
    return V(String.format("$tpiot/app/%s/refresh", new Object[] { this.d }), f()).v0(1L, o0.c).N(new i(this)).q0(Boolean.FALSE);
  }
  
  public void connectComplete(boolean paramBoolean, String paramString)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("connectComplete(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString);
    localStringBuilder.append(")");
    b.d.w.c.a.c(str, localStringBuilder.toString());
    e0(false);
  }
  
  public void connectionLost(Throwable paramThrowable)
  {
    b.d.w.c.a.f(a, paramThrowable, "connectionLost", new Object[0]);
    e0(true);
    if (this.f.isAutomaticReconnect()) {
      this.i.schedule(100L);
    } else {
      j().y();
    }
  }
  
  public void deliveryComplete(IMqttDeliveryToken paramIMqttDeliveryToken) {}
  
  public void e(q0 paramq0)
  {
    this.q.add(paramq0);
  }
  
  public q<Boolean> h(String paramString1, String paramString2)
  {
    return q.f0(Boolean.valueOf(p())).R(new h(this, paramString1, paramString2)).d(i(paramString1, paramString2, false)).E(new f(this)).z(new e(this));
  }
  
  public io.reactivex.a h0(String paramString, IMqttMessageListener paramIMqttMessageListener)
  {
    return f0(String.format("$tpiot/things/%s/shadow/update/accepted", new Object[] { paramString }), paramIMqttMessageListener).Z();
  }
  
  public io.reactivex.a j()
  {
    return k(30000L);
  }
  
  public io.reactivex.a k(long paramLong)
  {
    return io.reactivex.a.g(new k(this, paramLong)).l(new j(this));
  }
  
  public io.reactivex.a k0(String paramString)
  {
    return i0(String.format("$tpiot/things/%s/shadow/update/accepted", new Object[] { paramString })).i(new m(this));
  }
  
  public void messageArrived(String paramString, MqttMessage paramMqttMessage)
    throws Exception
  {
    String str = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("messageArrived(");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",{");
    ((StringBuilder)localObject).append(paramMqttMessage.toString());
    ((StringBuilder)localObject).append("})");
    b.d.w.c.a.c(str, ((StringBuilder)localObject).toString());
    if (paramString.equals(this.p))
    {
      paramString = (AsyncResult)b.l(paramMqttMessage.toString(), AsyncResult.class);
      paramMqttMessage = this.q.iterator();
      while (paramMqttMessage.hasNext()) {
        ((q0)paramMqttMessage.next()).a(paramString);
      }
    }
    if (paramString.equals(this.n))
    {
      paramMqttMessage = (AsyncResult)b.l(paramMqttMessage.toString(), AsyncResult.class);
      paramString = this.o;
      boolean bool;
      if (paramMqttMessage.getCode() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramString.onNext(Boolean.valueOf(bool));
    }
    else
    {
      localObject = (r0)this.r.get(paramString);
      if ((localObject != null) && (((r0)localObject).a() != null)) {
        ((r0)localObject).a().messageArrived(paramString, paramMqttMessage);
      }
    }
  }
  
  public boolean o()
  {
    MqttAsyncClient localMqttAsyncClient = this.j;
    boolean bool;
    if ((localMqttAsyncClient != null) && (localMqttAsyncClient.isConnected())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean p()
  {
    return this.m;
  }
  
  public boolean s(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.r;
    boolean bool = true;
    paramString = (r0)localConcurrentHashMap.get(String.format("$tpiot/things/%s/shadow/update/accepted", new Object[] { paramString }));
    if ((paramString == null) || (!paramString.d())) {
      bool = false;
    }
    return bool;
  }
  
  class a
    implements IMqttActionListener
  {
    a(r paramr) {}
    
    public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
    {
      String str = p0.b();
      paramIMqttToken = new StringBuilder();
      paramIMqttToken.append("connect fail, call connect to reconnect.reason:");
      paramIMqttToken.append(paramThrowable.getMessage());
      b.d.w.c.a.c(str, paramIMqttToken.toString());
      p0.d(p0.this, true);
      p0.c(p0.this, false);
      this.a.onError(paramThrowable);
    }
    
    public void onSuccess(IMqttToken paramIMqttToken)
    {
      b.d.w.c.a.c(p0.b(), "connect success!");
      p0.c(p0.this, false);
      p0.d(p0.this, false);
      this.a.onNext(Boolean.valueOf(paramIMqttToken.getSessionPresent()));
      this.a.onComplete();
    }
  }
  
  class b
    implements IMqttActionListener
  {
    b(io.reactivex.b paramb) {}
    
    public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
    {
      paramb.onError(paramThrowable);
    }
    
    public void onSuccess(IMqttToken paramIMqttToken)
    {
      paramb.onComplete();
    }
  }
  
  class c
    implements IMqttActionListener
  {
    c(r paramr) {}
    
    public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
    {
      paramr.onError(paramThrowable);
    }
    
    public void onSuccess(IMqttToken paramIMqttToken)
    {
      paramr.onNext(paramIMqttToken.getResponse());
      paramr.onComplete();
    }
  }
  
  class d
    implements IMqttActionListener
  {
    d(String[] paramArrayOfString, r paramr) {}
    
    public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
    {
      p0.a(p0.this, paramArrayOfString, 3);
      paramr.onError(paramThrowable);
    }
    
    public void onSuccess(IMqttToken paramIMqttToken)
    {
      p0.a(p0.this, paramArrayOfString, 1);
      paramr.onNext(paramIMqttToken.getResponse());
      paramr.onComplete();
    }
  }
  
  class e
    implements IMqttActionListener
  {
    e(String[] paramArrayOfString, io.reactivex.b paramb) {}
    
    public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
    {
      p0.a(p0.this, paramArrayOfString, 1);
      paramb.onError(paramThrowable);
    }
    
    public void onSuccess(IMqttToken paramIMqttToken)
    {
      p0.a(p0.this, paramArrayOfString, 3);
      paramb.onComplete();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\mqtt\p0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */