package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.ProvisionRequest;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.o2.j0.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.w0;
import com.google.common.base.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiresApi(18)
public final class g0
  implements e0
{
  public static final e0.c a = n.a;
  private final UUID b;
  private final MediaDrm c;
  private int d;
  
  private g0(UUID paramUUID)
    throws UnsupportedSchemeException
  {
    g.e(paramUUID);
    g.b(w0.b.equals(paramUUID) ^ true, "Use C.CLEARKEY_UUID instead");
    this.b = paramUUID;
    MediaDrm localMediaDrm = new MediaDrm(p(paramUUID));
    this.c = localMediaDrm;
    this.d = 1;
    if ((w0.d.equals(paramUUID)) && (x())) {
      r(localMediaDrm);
    }
  }
  
  private static byte[] l(byte[] paramArrayOfByte)
  {
    Object localObject = new d0(paramArrayOfByte);
    int i = ((d0)localObject).q();
    int j = ((d0)localObject).s();
    int k = ((d0)localObject).s();
    if ((j == 1) && (k == 1))
    {
      int m = ((d0)localObject).s();
      Charset localCharset = e.e;
      localObject = ((d0)localObject).B(m, localCharset);
      if (((String)localObject).contains("<LA_URL>")) {
        return paramArrayOfByte;
      }
      m = ((String)localObject).indexOf("</DATA>");
      if (m == -1) {
        u.h("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
      }
      paramArrayOfByte = ((String)localObject).substring(0, m);
      localObject = ((String)localObject).substring(m);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramArrayOfByte).length() + 26 + String.valueOf(localObject).length());
      localStringBuilder.append(paramArrayOfByte);
      localStringBuilder.append("<LA_URL>https://x</LA_URL>");
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
      i += 52;
      paramArrayOfByte = ByteBuffer.allocate(i);
      paramArrayOfByte.order(ByteOrder.LITTLE_ENDIAN);
      paramArrayOfByte.putInt(i);
      paramArrayOfByte.putShort((short)j);
      paramArrayOfByte.putShort((short)k);
      paramArrayOfByte.putShort((short)(((String)localObject).length() * 2));
      paramArrayOfByte.put(((String)localObject).getBytes(localCharset));
      return paramArrayOfByte.array();
    }
    u.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
    return paramArrayOfByte;
  }
  
  private static byte[] m(UUID paramUUID, byte[] paramArrayOfByte)
  {
    if (w0.c.equals(paramUUID)) {
      return r.a(paramArrayOfByte);
    }
    return paramArrayOfByte;
  }
  
  private static byte[] n(UUID paramUUID, byte[] paramArrayOfByte)
  {
    UUID localUUID = w0.e;
    byte[] arrayOfByte = paramArrayOfByte;
    if (localUUID.equals(paramUUID))
    {
      arrayOfByte = l.e(paramArrayOfByte, paramUUID);
      if (arrayOfByte != null) {
        paramArrayOfByte = arrayOfByte;
      }
      arrayOfByte = l.a(localUUID, l(paramArrayOfByte));
    }
    if ((o0.a >= 23) || (!w0.d.equals(paramUUID)))
    {
      if ((localUUID.equals(paramUUID)) && ("Amazon".equals(o0.c)))
      {
        paramArrayOfByte = o0.d;
        if ((!"AFTB".equals(paramArrayOfByte)) && (!"AFTS".equals(paramArrayOfByte)) && (!"AFTM".equals(paramArrayOfByte)) && (!"AFTT".equals(paramArrayOfByte))) {}
      }
    }
    else
    {
      paramUUID = l.e(arrayOfByte, paramUUID);
      if (paramUUID != null) {
        return paramUUID;
      }
    }
    return arrayOfByte;
  }
  
  private static String o(UUID paramUUID, String paramString)
  {
    if ((o0.a < 26) && (w0.c.equals(paramUUID)) && (("video/mp4".equals(paramString)) || ("audio/mp4".equals(paramString)))) {
      return "cenc";
    }
    return paramString;
  }
  
  private static UUID p(UUID paramUUID)
  {
    UUID localUUID = paramUUID;
    if (o0.a < 27)
    {
      localUUID = paramUUID;
      if (w0.c.equals(paramUUID)) {
        localUUID = w0.b;
      }
    }
    return localUUID;
  }
  
  @SuppressLint({"WrongConstant"})
  private static void r(MediaDrm paramMediaDrm)
  {
    paramMediaDrm.setPropertyString("securityLevel", "L3");
  }
  
  private static DrmInitData.SchemeData t(UUID paramUUID, List<DrmInitData.SchemeData> paramList)
  {
    if (!w0.d.equals(paramUUID)) {
      return (DrmInitData.SchemeData)paramList.get(0);
    }
    int i;
    label146:
    int k;
    if ((o0.a >= 28) && (paramList.size() > 1))
    {
      paramUUID = (DrmInitData.SchemeData)paramList.get(0);
      i = 0;
      j = 0;
      Object localObject;
      byte[] arrayOfByte;
      while (i < paramList.size())
      {
        localObject = (DrmInitData.SchemeData)paramList.get(i);
        arrayOfByte = (byte[])g.e(((DrmInitData.SchemeData)localObject).x);
        if ((o0.b(((DrmInitData.SchemeData)localObject).q, paramUUID.q)) && (o0.b(((DrmInitData.SchemeData)localObject).f, paramUUID.f)) && (l.c(arrayOfByte)))
        {
          j += arrayOfByte.length;
          i++;
        }
        else
        {
          i = 0;
          break label146;
        }
      }
      i = 1;
      if (i != 0)
      {
        arrayOfByte = new byte[j];
        j = 0;
        i = 0;
        while (j < paramList.size())
        {
          localObject = (byte[])g.e(((DrmInitData.SchemeData)paramList.get(j)).x);
          k = localObject.length;
          System.arraycopy(localObject, 0, arrayOfByte, i, k);
          i += k;
          j++;
        }
        return paramUUID.a(arrayOfByte);
      }
    }
    for (int j = 0; j < paramList.size(); j++)
    {
      paramUUID = (DrmInitData.SchemeData)paramList.get(j);
      k = l.g((byte[])g.e(paramUUID.x));
      i = o0.a;
      if ((i < 23) && (k == 0)) {
        return paramUUID;
      }
      if ((i >= 23) && (k == 1)) {
        return paramUUID;
      }
    }
    return (DrmInitData.SchemeData)paramList.get(0);
  }
  
  private static boolean x()
  {
    return "ASUS_Z00AD".equals(o0.d);
  }
  
  public static g0 y(UUID paramUUID)
    throws UnsupportedDrmException
  {
    try
    {
      paramUUID = new g0(paramUUID);
      return paramUUID;
    }
    catch (Exception paramUUID)
    {
      throw new UnsupportedDrmException(2, paramUUID);
    }
    catch (UnsupportedSchemeException paramUUID)
    {
      throw new UnsupportedDrmException(1, paramUUID);
    }
  }
  
  public Class<f0> a()
  {
    return f0.class;
  }
  
  public Map<String, String> b(byte[] paramArrayOfByte)
  {
    return this.c.queryKeyStatus(paramArrayOfByte);
  }
  
  public e0.d d()
  {
    MediaDrm.ProvisionRequest localProvisionRequest = this.c.getProvisionRequest();
    return new e0.d(localProvisionRequest.getData(), localProvisionRequest.getDefaultUrl());
  }
  
  public byte[] e()
    throws MediaDrmException
  {
    return this.c.openSession();
  }
  
  public void f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.c.restoreKeys(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void g(@Nullable e0.b paramb)
  {
    MediaDrm localMediaDrm = this.c;
    if (paramb == null) {
      paramb = null;
    } else {
      paramb = new o(this, paramb);
    }
    localMediaDrm.setOnEventListener(paramb);
  }
  
  public void h(byte[] paramArrayOfByte)
    throws DeniedByServerException
  {
    this.c.provideProvisionResponse(paramArrayOfByte);
  }
  
  public void i(byte[] paramArrayOfByte)
  {
    this.c.closeSession(paramArrayOfByte);
  }
  
  @Nullable
  public byte[] j(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws NotProvisionedException, DeniedByServerException
  {
    byte[] arrayOfByte = paramArrayOfByte2;
    if (w0.c.equals(this.b)) {
      arrayOfByte = r.b(paramArrayOfByte2);
    }
    return this.c.provideKeyResponse(paramArrayOfByte1, arrayOfByte);
  }
  
  public e0.a k(byte[] paramArrayOfByte, @Nullable List<DrmInitData.SchemeData> paramList, int paramInt, @Nullable HashMap<String, String> paramHashMap)
    throws NotProvisionedException
  {
    Object localObject1 = null;
    if (paramList != null)
    {
      paramList = t(this.b, paramList);
      arrayOfByte = n(this.b, (byte[])g.e(paramList.x));
      localObject2 = o(this.b, paramList.q);
    }
    else
    {
      arrayOfByte = null;
      localObject2 = arrayOfByte;
      paramList = (List<DrmInitData.SchemeData>)localObject1;
    }
    Object localObject2 = this.c.getKeyRequest(paramArrayOfByte, arrayOfByte, (String)localObject2, paramInt, paramHashMap);
    byte[] arrayOfByte = m(this.b, ((MediaDrm.KeyRequest)localObject2).getData());
    paramHashMap = ((MediaDrm.KeyRequest)localObject2).getDefaultUrl();
    paramArrayOfByte = paramHashMap;
    if ("https://x".equals(paramHashMap)) {
      paramArrayOfByte = "";
    }
    paramHashMap = paramArrayOfByte;
    if (TextUtils.isEmpty(paramArrayOfByte))
    {
      paramHashMap = paramArrayOfByte;
      if (paramList != null)
      {
        paramHashMap = paramArrayOfByte;
        if (!TextUtils.isEmpty(paramList.f)) {
          paramHashMap = paramList.f;
        }
      }
    }
    if (o0.a >= 23) {
      paramInt = ((MediaDrm.KeyRequest)localObject2).getRequestType();
    } else {
      paramInt = Integer.MIN_VALUE;
    }
    return new e0.a(arrayOfByte, paramHashMap, paramInt);
  }
  
  public f0 q(byte[] paramArrayOfByte)
    throws MediaCryptoException
  {
    boolean bool;
    if ((o0.a < 21) && (w0.d.equals(this.b)) && ("L3".equals(s("securityLevel")))) {
      bool = true;
    } else {
      bool = false;
    }
    return new f0(p(this.b), paramArrayOfByte, bool);
  }
  
  public void release()
  {
    try
    {
      int i = this.d - 1;
      this.d = i;
      if (i == 0) {
        this.c.release();
      }
      return;
    }
    finally {}
  }
  
  public String s(String paramString)
  {
    return this.c.getPropertyString(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */