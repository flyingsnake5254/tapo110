package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class b
  implements Configurator
{
  public static final Configurator a = new b();
  
  public void configure(EncoderConfig<?> paramEncoderConfig)
  {
    Object localObject = b.a;
    paramEncoderConfig.registerEncoder(j.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(d.class, (ObjectEncoder)localObject);
    localObject = e.a;
    paramEncoderConfig.registerEncoder(l.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(g.class, (ObjectEncoder)localObject);
    localObject = c.a;
    paramEncoderConfig.registerEncoder(ClientInfo.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(e.class, (ObjectEncoder)localObject);
    localObject = a.a;
    paramEncoderConfig.registerEncoder(a.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(c.class, (ObjectEncoder)localObject);
    localObject = d.a;
    paramEncoderConfig.registerEncoder(k.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(f.class, (ObjectEncoder)localObject);
    localObject = f.a;
    paramEncoderConfig.registerEncoder(NetworkConnectionInfo.class, (ObjectEncoder)localObject);
    paramEncoderConfig.registerEncoder(i.class, (ObjectEncoder)localObject);
  }
  
  private static final class a
    implements ObjectEncoder<a>
  {
    static final a a = new a();
    private static final FieldDescriptor b = FieldDescriptor.of("sdkVersion");
    private static final FieldDescriptor c = FieldDescriptor.of("model");
    private static final FieldDescriptor d = FieldDescriptor.of("hardware");
    private static final FieldDescriptor e = FieldDescriptor.of("device");
    private static final FieldDescriptor f = FieldDescriptor.of("product");
    private static final FieldDescriptor g = FieldDescriptor.of("osBuild");
    private static final FieldDescriptor h = FieldDescriptor.of("manufacturer");
    private static final FieldDescriptor i = FieldDescriptor.of("fingerprint");
    private static final FieldDescriptor j = FieldDescriptor.of("locale");
    private static final FieldDescriptor k = FieldDescriptor.of("country");
    private static final FieldDescriptor l = FieldDescriptor.of("mccMnc");
    private static final FieldDescriptor m = FieldDescriptor.of("applicationBuild");
    
    public void a(a parama, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(b, parama.m());
      paramObjectEncoderContext.add(c, parama.j());
      paramObjectEncoderContext.add(d, parama.f());
      paramObjectEncoderContext.add(e, parama.d());
      paramObjectEncoderContext.add(f, parama.l());
      paramObjectEncoderContext.add(g, parama.k());
      paramObjectEncoderContext.add(h, parama.h());
      paramObjectEncoderContext.add(i, parama.e());
      paramObjectEncoderContext.add(j, parama.g());
      paramObjectEncoderContext.add(k, parama.c());
      paramObjectEncoderContext.add(l, parama.i());
      paramObjectEncoderContext.add(m, parama.b());
    }
  }
  
  private static final class b
    implements ObjectEncoder<j>
  {
    static final b a = new b();
    private static final FieldDescriptor b = FieldDescriptor.of("logRequest");
    
    public void a(j paramj, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(b, paramj.c());
    }
  }
  
  private static final class c
    implements ObjectEncoder<ClientInfo>
  {
    static final c a = new c();
    private static final FieldDescriptor b = FieldDescriptor.of("clientType");
    private static final FieldDescriptor c = FieldDescriptor.of("androidClientInfo");
    
    public void a(ClientInfo paramClientInfo, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(b, paramClientInfo.c());
      paramObjectEncoderContext.add(c, paramClientInfo.b());
    }
  }
  
  private static final class d
    implements ObjectEncoder<k>
  {
    static final d a = new d();
    private static final FieldDescriptor b = FieldDescriptor.of("eventTimeMs");
    private static final FieldDescriptor c = FieldDescriptor.of("eventCode");
    private static final FieldDescriptor d = FieldDescriptor.of("eventUptimeMs");
    private static final FieldDescriptor e = FieldDescriptor.of("sourceExtension");
    private static final FieldDescriptor f = FieldDescriptor.of("sourceExtensionJsonProto3");
    private static final FieldDescriptor g = FieldDescriptor.of("timezoneOffsetSeconds");
    private static final FieldDescriptor h = FieldDescriptor.of("networkConnectionInfo");
    
    public void a(k paramk, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(b, paramk.c());
      paramObjectEncoderContext.add(c, paramk.b());
      paramObjectEncoderContext.add(d, paramk.d());
      paramObjectEncoderContext.add(e, paramk.f());
      paramObjectEncoderContext.add(f, paramk.g());
      paramObjectEncoderContext.add(g, paramk.h());
      paramObjectEncoderContext.add(h, paramk.e());
    }
  }
  
  private static final class e
    implements ObjectEncoder<l>
  {
    static final e a = new e();
    private static final FieldDescriptor b = FieldDescriptor.of("requestTimeMs");
    private static final FieldDescriptor c = FieldDescriptor.of("requestUptimeMs");
    private static final FieldDescriptor d = FieldDescriptor.of("clientInfo");
    private static final FieldDescriptor e = FieldDescriptor.of("logSource");
    private static final FieldDescriptor f = FieldDescriptor.of("logSourceName");
    private static final FieldDescriptor g = FieldDescriptor.of("logEvent");
    private static final FieldDescriptor h = FieldDescriptor.of("qosTier");
    
    public void a(l paraml, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(b, paraml.g());
      paramObjectEncoderContext.add(c, paraml.h());
      paramObjectEncoderContext.add(d, paraml.b());
      paramObjectEncoderContext.add(e, paraml.d());
      paramObjectEncoderContext.add(f, paraml.e());
      paramObjectEncoderContext.add(g, paraml.c());
      paramObjectEncoderContext.add(h, paraml.f());
    }
  }
  
  private static final class f
    implements ObjectEncoder<NetworkConnectionInfo>
  {
    static final f a = new f();
    private static final FieldDescriptor b = FieldDescriptor.of("networkType");
    private static final FieldDescriptor c = FieldDescriptor.of("mobileSubtype");
    
    public void a(NetworkConnectionInfo paramNetworkConnectionInfo, ObjectEncoderContext paramObjectEncoderContext)
      throws IOException
    {
      paramObjectEncoderContext.add(b, paramNetworkConnectionInfo.c());
      paramObjectEncoderContext.add(c, paramNetworkConnectionInfo.b());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */