package b.d.v.b;

import android.text.TextUtils;
import b.d.i.a.a.f;
import b.d.i.a.b.b;
import b.d.i.a.b.c.n;
import com.tplink.libmediakit.jniinterface.GenKey;
import com.tplink.libtpcommonstream.stream.control.common.CommonPayload;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlNotification;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlResponse;
import com.tplink.libtpcommonstream.stream.control.request.DoStopRequest;
import com.tplink.libtpcommonstream.stream.control.response.GetTalkResponse;
import com.tplink.libtpcommonstream.stream.control.response.Response;
import com.tplink.libtpmediastatistics.ConnectionInfoVO;
import com.tplink.libtpmediastatistics.ConnectionVO;
import com.tplink.libtpmediastatistics.OnceConnectionVO;
import com.tplink.libtpmediastatistics.StatisticsManager;
import com.tplink.libtpmediastatistics.StatisticsStreamType;
import com.tplink.libtpmediastatistics.StopReason;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class d
  extends f
{
  private Future<Boolean> H3;
  private volatile boolean I3;
  private com.tplink.libtpstreamconnectionsocket.a J3;
  private String K3;
  private b.d.p.a L3;
  private n M3;
  private final String N3;
  private String O3;
  private long P3;
  private a Q3;
  private c p2;
  private e p3;
  
  public d(String paramString)
  {
    this.N3 = paramString;
    this.K3 = null;
  }
  
  private void o()
    throws Exception
  {
    int i = 1;
    while (i != 0)
    {
      this.J3.g();
      Object localObject1 = this.J3.p();
      if ((((Map)localObject1).size() != 0) && (((Map)localObject1).containsKey("Content-Type")))
      {
        Object localObject2 = (String)((Map)localObject1).get("Content-Type");
        int j;
        if ((((Map)localObject1).containsKey("X-If-Encrypt")) && ("1".equals(((Map)localObject1).get("X-If-Encrypt")))) {
          j = 1;
        } else {
          j = 0;
        }
        if ((!"video/mp2t".equals(localObject2)) && ("application/json".equals(localObject2)))
        {
          localObject2 = this.J3.m();
          localObject1 = localObject2;
          if (j != 0)
          {
            b.d.p.a locala = this.L3;
            localObject1 = localObject2;
            if (locala != null) {
              localObject1 = locala.a((byte[])localObject2, localObject2.length);
            }
          }
          localObject1 = new String((byte[])localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("payload: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          b.d.p.d.a("DoubleTalkStreamConnection", ((StringBuilder)localObject2).toString());
          localObject2 = (CommonPayload)b.b((String)localObject1, CommonPayload.class);
          if ("notification".equals(((CommonPayload)localObject2).getType()))
          {
            localObject2 = b.c((CommonPayload)localObject2);
            if ((localObject2 != null) && (this.M3 != null))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("event type ");
              ((StringBuilder)localObject1).append(((StreamControlNotification)localObject2).getEventType());
              b.d.p.d.a("DoubleTalkStreamConnection", ((StringBuilder)localObject1).toString());
              this.M3.a(this.c, (StreamControlNotification)localObject2);
            }
          }
          else if ("response".equals(((CommonPayload)localObject2).getType()))
          {
            if (this.K3 == null)
            {
              localObject2 = (GetTalkResponse)b.e((CommonPayload)localObject2, GetTalkResponse.class).getResult();
              if ((((Response)localObject2).getErrorCode() == 0) && (((GetTalkResponse)localObject2).getSessionId() != null))
              {
                y(((GetTalkResponse)localObject2).getSessionId());
                localObject1 = this.Q3;
                if (localObject1 != null) {
                  ((a)localObject1).a();
                }
              }
              else
              {
                localObject1 = this.Q3;
                if (localObject1 != null) {
                  ((a)localObject1).b(((Response)localObject2).getErrorCode());
                }
              }
            }
            else
            {
              localObject1 = this.M3;
              if (localObject1 != null) {
                ((n)localObject1).c((CommonPayload)localObject2);
              }
            }
            i = 0;
          }
        }
      }
    }
  }
  
  private void q()
  {
    Object localObject1 = StatisticsManager.getInstance();
    Object localObject2 = this.c;
    Object localObject3 = StatisticsStreamType.DOUBLE_TALK;
    localObject2 = ((StatisticsManager)localObject1).getOnceConnectionCacheKey((String)localObject2, (StatisticsStreamType)localObject3, this.x);
    localObject1 = StatisticsManager.getInstance().getAndRemoveOnceConnectionVO((String)localObject2);
    if (localObject1 != null)
    {
      ((OnceConnectionVO)localObject1).setStopReason(StopReason.USER_CLOSE.value());
      StatisticsManager.getInstance().insertOnceConnectionVO((String)localObject2, (OnceConnectionVO)localObject1);
    }
    else
    {
      localObject1 = new OnceConnectionVO();
    }
    String str = StatisticsManager.getInstance().getConnectionInfoCacheKey(this.c, (StatisticsStreamType)localObject3);
    localObject2 = StatisticsManager.getInstance().getConnectionInfoVO(str);
    localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = new ConnectionInfoVO();
      StatisticsManager.getInstance().insertConnectionInfoVO(str, (ConnectionInfoVO)localObject3);
    }
    int i = this.x;
    if (i == 16) {
      ((ConnectionInfoVO)localObject3).getP2pConnectionVO().addData((OnceConnectionVO)localObject1);
    } else if (i == 0) {
      ((ConnectionInfoVO)localObject3).getRelayConnectionVO().addData((OnceConnectionVO)localObject1);
    } else if (i == 256) {
      ((ConnectionInfoVO)localObject3).getLocalConnectionVO().addData((OnceConnectionVO)localObject1);
    }
  }
  
  private void r(byte[] paramArrayOfByte)
  {
    if ((this.J3 != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      try
      {
        localObject = this.L3;
        if (localObject != null)
        {
          b.d.p.d.a("DoubleTalkStreamConnection", "send encrypt data");
          paramArrayOfByte = this.L3.b(paramArrayOfByte);
          this.J3.I(true);
          localObject = new java/util/HashMap;
          ((HashMap)localObject).<init>();
          ((Map)localObject).put("Content-Type", "audio/mp2t");
          ((Map)localObject).put("X-If-Encrypt", "1");
          ((Map)localObject).put("X-Session-Id", this.K3);
          this.J3.E((Map)localObject, paramArrayOfByte);
        }
        else
        {
          b.d.p.d.a("DoubleTalkStreamConnection", "send plain data");
          this.J3.I(true);
          localObject = new java/util/HashMap;
          ((HashMap)localObject).<init>();
          ((Map)localObject).put("Content-Type", "audio/mp2t");
          ((Map)localObject).put("X-Session-Id", this.K3);
          this.J3.E((Map)localObject, paramArrayOfByte);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        Object localObject = this.p2;
        if (localObject != null) {
          ((c)localObject).onDoubleTalkSendDataFailure(this.c, -1, paramArrayOfByte);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        b.d.p.d.a("DoubleTalkStreamConnection", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void s()
  {
    if ((this.J3 != null) && (!TextUtils.isEmpty(this.K3))) {
      try
      {
        int i = this.M3.b();
        Object localObject1 = new com/tplink/libtpcommonstream/stream/control/request/DoStopRequest;
        ((DoStopRequest)localObject1).<init>();
        Object localObject2 = new com/tplink/libtpcommonstream/stream/control/common/StreamControlRequest;
        ((StreamControlRequest)localObject2).<init>(localObject1);
        ((StreamControlRequest)localObject2).setSeq(i);
        localObject2 = b.d((StreamControlRequest)localObject2);
        localObject1 = new java/util/HashMap;
        ((HashMap)localObject1).<init>();
        ((Map)localObject1).put("Content-Type", "application/json");
        ((Map)localObject1).put("X-Session-Id", this.K3);
        this.J3.I(true);
        this.J3.D((Map)localObject1, (String)localObject2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void A(String paramString)
  {
    this.O3 = paramString;
  }
  
  public void B()
  {
    this.P3 = System.currentTimeMillis();
  }
  
  public void C()
  {
    int i = Math.round((float)(System.currentTimeMillis() - this.P3) / 1000.0F);
    String str = StatisticsManager.getInstance().getOnceConnectionCacheKey(this.c, StatisticsStreamType.DOUBLE_TALK, this.x);
    OnceConnectionVO localOnceConnectionVO = StatisticsManager.getInstance().getOnceConnectionVO(str);
    if (localOnceConnectionVO != null)
    {
      localOnceConnectionVO.addUsageTime(i);
      StatisticsManager.getInstance().insertOnceConnectionVO(str, localOnceConnectionVO);
    }
  }
  
  public void f(String paramString)
  {
    if ((this.J3 != null) && (!TextUtils.isEmpty(this.N3)))
    {
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(this.K3)) {
        localHashMap.put("X-Session-Id", this.K3);
      }
      this.J3.t(paramString, localHashMap);
      if (this.J3.s()) {
        this.J3.I(false);
      }
      try
      {
        o();
      }
      catch (Exception paramString)
      {
        this.p2.onDoubleTalkSendDataFailure(this.c, -1, paramString);
      }
    }
  }
  
  public Boolean l()
    throws Exception
  {
    boolean bool = true;
    this.I3 = true;
    Object localObject1 = b.d.d.a.a.d();
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = GenKey.a();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("设备建立语音流：账号：");
    ((StringBuilder)localObject1).append("admin");
    ((StringBuilder)localObject1).append(" 密码：");
    ((StringBuilder)localObject1).append((String)localObject2);
    b.d.p.d.a("DoubleTalkStreamConnection", ((StringBuilder)localObject1).toString());
    Object localObject3;
    if (e())
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("Content-Type", "multipart/mixed; boundary=--client-stream-boundary--");
      localObject3 = com.tplink.libtpstreamconnectionsocket.a.o(this.d, this.f);
      localObject1 = b.d.i.a.c.a.a().c((String)localObject3, "admin", (String)localObject2, "POST", (Map)localObject1);
    }
    else
    {
      localObject1 = "";
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (e()))
    {
      localObject2 = this.p2;
      if (localObject2 != null) {
        ((c)localObject2).onDoubleTalkCreateFailure(this.c, 2);
      }
      return Boolean.TRUE;
    }
    try
    {
      localObject3 = new com/tplink/libtpstreamconnectionsocket/a;
      ((com.tplink.libtpstreamconnectionsocket.a)localObject3).<init>(this.d, this.f);
      this.J3 = ((com.tplink.libtpstreamconnectionsocket.a)localObject3);
      ((com.tplink.libtpstreamconnectionsocket.a)localObject3).F(30000);
      this.J3.H(15000);
      this.J3.G("POST");
      if (17 == a()) {
        this.J3.e(this.c);
      } else {
        this.J3.d();
      }
      if (a() != 0) {
        bool = false;
      }
      int i = this.J3.q((String)localObject1, bool);
      if (i == 200)
      {
        localObject1 = this.J3.p();
        if (((Map)localObject1).containsKey("Key-Exchange"))
        {
          localObject3 = (String)((Map)localObject1).get("Key-Exchange");
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append((String)localObject3);
          b.d.p.d.a("DoubleTalkStreamConnection", ((StringBuilder)localObject1).toString());
          this.L3 = b.d.i.a.a.e.b((String)localObject3, (String)localObject2);
        }
      }
      if ((i != 200) && (i != 204))
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("设备：");
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append("LiveStream连接失败，errorCode：");
        ((StringBuilder)localObject2).append(i);
        b.d.p.d.a("DoubleTalkStreamConnection", ((StringBuilder)localObject2).toString());
        if (i == 401)
        {
          localObject2 = this.p2;
          if (localObject2 != null) {
            ((c)localObject2).onDoubleTalkCreateFailure(this.c, 2);
          }
          localObject2 = this.J3;
          if (localObject2 != null) {
            ((com.tplink.libtpstreamconnectionsocket.a)localObject2).f();
          }
          return Boolean.FALSE;
        }
        localObject2 = new java/io/IOException;
        ((IOException)localObject2).<init>();
        throw ((Throwable)localObject2);
      }
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append("设备：");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("ConnectType ");
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append(" 双向语音连接成功");
      b.d.p.d.a("DoubleTalkStreamConnection", ((StringBuilder)localObject2).toString());
      if (!TextUtils.isEmpty(this.N3))
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("requestTalk ");
        ((StringBuilder)localObject2).append(this.N3);
        b.d.p.d.a("DoubleTalkStreamConnection", ((StringBuilder)localObject2).toString());
        this.J3.t(this.N3, null);
      }
      o();
      localObject2 = this.p3;
      if (localObject2 != null) {
        ((e)localObject2).o(this.c, a());
      }
      return Boolean.TRUE;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject1 = this.p2;
      if (localObject1 != null) {
        ((c)localObject1).onDoubleTalkCreateFailure(this.c, 2);
      }
      if ((localException instanceof SocketTimeoutException))
      {
        localObject1 = this.p3;
        if (localObject1 != null) {
          ((e)localObject1).g(this.c, a(), localException);
        }
      }
    }
    return Boolean.FALSE;
  }
  
  public void p()
  {
    this.I3 = false;
    this.p2 = null;
    this.p3 = null;
    this.Q3 = null;
    new Thread(new a(this)).start();
    q();
    if ("aec".equalsIgnoreCase(this.O3)) {
      C();
    }
  }
  
  public void t(byte[] paramArrayOfByte)
  {
    if (!this.I3) {
      return;
    }
    r(paramArrayOfByte);
  }
  
  public void u(a parama)
  {
    this.Q3 = parama;
  }
  
  public void v(c paramc)
  {
    this.p2 = paramc;
  }
  
  public void w(e parame)
  {
    this.p3 = parame;
  }
  
  public void x(Future<Boolean> paramFuture)
  {
    this.H3 = paramFuture;
  }
  
  public void y(String paramString)
  {
    this.K3 = paramString;
  }
  
  public void z(n paramn)
  {
    this.M3 = paramn;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\v\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */