package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x509.t;
import org.bouncycastle.asn1.x509.y;
import org.bouncycastle.crypto.p.e;
import org.bouncycastle.crypto.p.f;
import org.bouncycastle.util.a;

public class m1
{
  public static final byte[] a = new byte[0];
  public static final short[] b = new short[0];
  public static final int[] c = new int[0];
  public static final long[] d = new long[0];
  public static final Integer e = org.bouncycastle.util.d.b(13);
  static final byte[] f = { 67, 76, 78, 84 };
  static final byte[] g = { 83, 82, 86, 82 };
  static final byte[][] h = u();
  
  public static int A(int paramInt)
    throws IOException
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 4) && (paramInt != 5)) {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        throw new TlsFatalAlert((short)80);
                      }
                    case 65281: 
                    case 65283: 
                    case 65285: 
                      return 104;
                    }
                    return 103;
                  }
                  return 21;
                case 49313: 
                case 49315: 
                case 49321: 
                case 49323: 
                case 49327: 
                  return 18;
                case 49312: 
                case 49314: 
                case 49320: 
                case 49322: 
                case 49326: 
                  return 16;
                case 49309: 
                case 49311: 
                case 49317: 
                case 49319: 
                case 49325: 
                  return 17;
                case 49308: 
                case 49310: 
                case 49316: 
                case 49318: 
                case 49324: 
                  return 15;
                case 49275: 
                case 49277: 
                case 49279: 
                case 49281: 
                case 49283: 
                case 49285: 
                case 49287: 
                case 49289: 
                case 49291: 
                case 49293: 
                case 49295: 
                case 49297: 
                case 49299: 
                  return 20;
                case 49274: 
                case 49276: 
                case 49278: 
                case 49280: 
                case 49282: 
                case 49284: 
                case 49286: 
                case 49288: 
                case 49290: 
                case 49292: 
                case 49294: 
                case 49296: 
                case 49298: 
                  return 19;
                }
                break;
              }
              break;
            }
            break;
          }
        case 186: 
        case 187: 
        case 188: 
        case 189: 
        case 190: 
        case 191: 
          return 12;
        case 176: 
        case 177: 
        case 180: 
        case 181: 
        case 184: 
        case 185: 
          return 0;
        case 157: 
        case 159: 
        case 161: 
        case 163: 
        case 165: 
        case 167: 
        case 169: 
        case 171: 
        case 173: 
          return 11;
        case 156: 
        case 158: 
        case 160: 
        case 162: 
        case 164: 
        case 166: 
        case 168: 
        case 170: 
        case 172: 
          return 10;
        case 150: 
        case 151: 
        case 152: 
        case 153: 
        case 154: 
        case 155: 
          return 14;
        case 141: 
        case 145: 
        case 149: 
        case 175: 
        case 179: 
        case 183: 
          return 9;
        case 140: 
        case 144: 
        case 148: 
        case 174: 
        case 178: 
        case 182: 
          return 8;
        case 132: 
        case 133: 
        case 134: 
        case 135: 
        case 136: 
        case 137: 
        case 192: 
        case 193: 
        case 194: 
        case 195: 
        case 196: 
        case 197: 
          return 13;
        case 10: 
        case 13: 
        case 16: 
        case 19: 
        case 22: 
        case 27: 
        case 139: 
        case 143: 
        case 147: 
          return 7;
        }
      }
      return 2;
    }
    return 0;
  }
  
  public static void A0(int[] paramArrayOfInt, OutputStream paramOutputStream)
    throws IOException
  {
    int i = paramArrayOfInt.length * 2;
    i(i);
    w0(i, paramOutputStream);
    y0(paramArrayOfInt, paramOutputStream);
  }
  
  public static byte[] B(Hashtable paramHashtable, Integer paramInteger)
  {
    if (paramHashtable == null) {
      paramHashtable = null;
    } else {
      paramHashtable = (byte[])paramHashtable.get(paramInteger);
    }
    return paramHashtable;
  }
  
  public static void B0(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int i = paramArrayOfInt.length * 2;
    i(i);
    x0(i, paramArrayOfByte, paramInt);
    z0(paramArrayOfInt, paramArrayOfByte, paramInt + 2);
  }
  
  public static short C(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return 5;
        }
        throw new IllegalArgumentException("unknown PRFAlgorithm");
      }
      return 4;
    }
    throw new IllegalArgumentException("legacy PRF not a valid algorithm");
  }
  
  public static void C0(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write((byte)(paramInt >>> 16));
    paramOutputStream.write((byte)(paramInt >>> 8));
    paramOutputStream.write((byte)paramInt);
  }
  
  public static int D(int paramInt)
    throws IOException
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 4) && (paramInt != 5)) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      throw new TlsFatalAlert((short)80);
                    }
                    break;
                  }
                  break;
                }
                break;
              }
            case 49203: 
            case 49204: 
            case 49205: 
            case 49206: 
            case 49207: 
            case 49208: 
            case 49209: 
            case 49210: 
            case 49211: 
              return 24;
            case 49180: 
            case 49183: 
            case 49186: 
              return 22;
            case 49179: 
            case 49182: 
            case 49185: 
              return 23;
            case 49178: 
            case 49181: 
            case 49184: 
              return 21;
            case 49173: 
            case 49174: 
            case 49175: 
            case 49176: 
            case 49177: 
              return 20;
            case 49168: 
            case 49169: 
            case 49170: 
            case 49171: 
            case 49172: 
            case 49191: 
            case 49192: 
            case 49199: 
            case 49200: 
              return 19;
            case 49163: 
            case 49164: 
            case 49165: 
            case 49166: 
            case 49167: 
            case 49193: 
            case 49194: 
            case 49201: 
            case 49202: 
              return 18;
            case 49158: 
            case 49159: 
            case 49160: 
            case 49161: 
            case 49162: 
            case 49187: 
            case 49188: 
            case 49195: 
            case 49196: 
              return 17;
            }
            return 16;
          }
          break;
        }
      case 146: 
      case 147: 
      case 148: 
      case 149: 
      case 172: 
      case 173: 
      case 182: 
      case 183: 
      case 184: 
      case 185: 
        return 15;
      case 142: 
      case 143: 
      case 144: 
      case 145: 
      case 170: 
      case 171: 
      case 178: 
      case 179: 
      case 180: 
      case 181: 
        return 14;
      case 138: 
      case 139: 
      case 140: 
      case 141: 
      case 168: 
      case 169: 
      case 174: 
      case 175: 
      case 176: 
      case 177: 
        return 13;
      case 24: 
      case 27: 
      case 137: 
      case 155: 
      case 166: 
      case 167: 
      case 191: 
      case 197: 
        return 11;
      case 22: 
      case 136: 
      case 154: 
      case 158: 
      case 159: 
      case 190: 
      case 196: 
        return 5;
      case 19: 
      case 135: 
      case 153: 
      case 162: 
      case 163: 
      case 189: 
      case 195: 
        return 3;
      case 16: 
      case 134: 
      case 152: 
      case 160: 
      case 161: 
      case 188: 
      case 194: 
        return 9;
      case 13: 
      case 133: 
      case 151: 
      case 164: 
      case 165: 
      case 187: 
      case 193: 
        return 7;
      }
    }
    return 1;
  }
  
  public static void D0(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(byte)paramInt1);
  }
  
  public static int E(int paramInt)
    throws IOException
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 4) {
          break label1442;
        }
        if (paramInt == 5) {}
      }
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      throw new TlsFatalAlert((short)80);
                    }
                    break;
                  }
                  break;
                }
                break;
              }
              break;
            }
            break;
          }
          break;
        }
      case 175: 
      case 177: 
      case 179: 
      case 181: 
      case 183: 
      case 185: 
        return 4;
      case 174: 
      case 176: 
      case 178: 
      case 180: 
      case 182: 
      case 184: 
      case 186: 
      case 187: 
      case 188: 
      case 189: 
      case 190: 
      case 191: 
      case 192: 
      case 193: 
      case 194: 
      case 195: 
      case 196: 
      case 197: 
        return 3;
      case 156: 
      case 157: 
      case 158: 
      case 159: 
      case 160: 
      case 161: 
      case 162: 
      case 163: 
      case 164: 
      case 165: 
      case 166: 
      case 167: 
      case 168: 
      case 169: 
      case 170: 
      case 171: 
      case 172: 
      case 173: 
        return 0;
      case 10: 
      case 13: 
      case 16: 
      case 19: 
      case 22: 
      case 27: 
      case 132: 
      case 133: 
      case 134: 
      case 135: 
      case 136: 
      case 137: 
      case 138: 
      case 139: 
      case 140: 
      case 141: 
      case 142: 
      case 143: 
      case 144: 
      case 145: 
      case 146: 
      case 147: 
      case 148: 
      case 149: 
      case 150: 
      case 151: 
      case 152: 
      case 153: 
      case 154: 
      case 155: 
        return 2;
      }
    }
    label1442:
    return 1;
  }
  
  public static void E0(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)(byte)(int)(paramLong >>> 56));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(byte)(int)(paramLong >>> 48));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(byte)(int)(paramLong >>> 40));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(byte)(int)(paramLong >>> 32));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(byte)(int)(paramLong >>> 24));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(byte)(int)(paramLong >>> 16));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(byte)(int)(paramLong >>> 8));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(byte)(int)paramLong);
  }
  
  public static x F(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        return x.a;
                      }
                      break;
                    }
                    break;
                  }
                  break;
                }
                break;
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
      break;
    }
    return x.d;
  }
  
  public static void F0(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramInt);
  }
  
  public static d0 G(p0 paramp0, k1 paramk1)
    throws IOException
  {
    if (P(paramp0))
    {
      paramp0 = paramk1.a();
      if (paramp0 == null) {
        throw new TlsFatalAlert((short)80);
      }
    }
    else
    {
      paramp0 = null;
    }
    return paramp0;
  }
  
  public static void G0(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(byte)paramInt1);
  }
  
  public static boolean H(Hashtable paramHashtable, Integer paramInteger, short paramShort)
    throws IOException
  {
    paramHashtable = B(paramHashtable, paramInteger);
    if (paramHashtable == null) {
      return false;
    }
    if (paramHashtable.length == 0) {
      return true;
    }
    throw new TlsFatalAlert(paramShort);
  }
  
  public static void H0(short paramShort, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramShort);
  }
  
  static void I(org.bouncycastle.crypto.g paramg, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    org.bouncycastle.crypto.t.b localb = new org.bouncycastle.crypto.t.b(paramg);
    localb.d(new org.bouncycastle.crypto.w.a0(paramArrayOfByte1));
    int i = paramg.e();
    int j = (paramArrayOfByte3.length + i - 1) / i;
    int k = localb.a();
    paramArrayOfByte1 = new byte[k];
    byte[] arrayOfByte = new byte[localb.a()];
    paramg = paramArrayOfByte2;
    int m = 0;
    while (m < j)
    {
      localb.update(paramg, 0, paramg.length);
      localb.doFinal(paramArrayOfByte1, 0);
      localb.update(paramArrayOfByte1, 0, k);
      localb.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
      localb.doFinal(arrayOfByte, 0);
      int n = i * m;
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte3, n, Math.min(i, paramArrayOfByte3.length - n));
      m++;
      paramg = paramArrayOfByte1;
    }
  }
  
  public static void I0(short paramShort, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)(byte)paramShort);
  }
  
  public static boolean J(int paramInt)
    throws IOException
  {
    paramInt = v(paramInt);
    boolean bool = true;
    if (1 != paramInt) {
      bool = false;
    }
    return bool;
  }
  
  public static void J0(short[] paramArrayOfShort, OutputStream paramOutputStream)
    throws IOException
  {
    for (int i = 0; i < paramArrayOfShort.length; i++) {
      H0(paramArrayOfShort[i], paramOutputStream);
    }
  }
  
  public static boolean K(p0 paramp0)
  {
    return paramp0.b().i();
  }
  
  public static void K0(short[] paramArrayOfShort, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int i = 0;
    int j = paramInt;
    for (paramInt = i; paramInt < paramArrayOfShort.length; paramInt++)
    {
      I0(paramArrayOfShort[paramInt], paramArrayOfByte, j);
      j++;
    }
  }
  
  public static boolean L(x paramx)
  {
    return x.d.h(paramx.c());
  }
  
  public static void L0(short[] paramArrayOfShort, OutputStream paramOutputStream)
    throws IOException
  {
    k(paramArrayOfShort.length);
    F0(paramArrayOfShort.length, paramOutputStream);
    J0(paramArrayOfShort, paramOutputStream);
  }
  
  public static boolean M(x paramx)
  {
    return x.c.h(paramx.c());
  }
  
  public static void M0(short[] paramArrayOfShort, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    k(paramArrayOfShort.length);
    G0(paramArrayOfShort.length, paramArrayOfByte, paramInt);
    K0(paramArrayOfShort, paramArrayOfByte, paramInt + 1);
  }
  
  public static boolean N(p0 paramp0)
  {
    return M(paramp0.b());
  }
  
  public static void N0(x paramx, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramx.d());
    paramOutputStream.write(paramx.e());
  }
  
  public static boolean O(x paramx)
  {
    return x.d.h(paramx.c());
  }
  
  public static void O0(x paramx, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)(byte)paramx.d());
    paramArrayOfByte[(paramInt + 1)] = ((byte)(byte)paramx.e());
  }
  
  public static boolean P(p0 paramp0)
  {
    return O(paramp0.b());
  }
  
  public static boolean Q(int paramInt, x paramx)
  {
    return F(paramInt).h(paramx.c());
  }
  
  public static boolean R(int paramInt)
  {
    boolean bool;
    if ((0xFFFF & paramInt) == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean S(int paramInt)
  {
    boolean bool;
    if ((0xFFFFFF & paramInt) == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean T(int paramInt)
  {
    boolean bool;
    if ((paramInt & 0xFF) == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean U(short paramShort)
  {
    boolean bool;
    if ((paramShort & 0xFF) == paramShort) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static Vector V(boolean paramBoolean, InputStream paramInputStream)
    throws IOException
  {
    int i = d0(paramInputStream);
    if ((i >= 2) && ((i & 0x1) == 0))
    {
      int j = i / 2;
      Vector localVector = new Vector(j);
      for (i = 0; i < j; i++)
      {
        d0 locald0 = d0.d(paramInputStream);
        if ((!paramBoolean) && (locald0.c() == 0)) {
          throw new TlsFatalAlert((short)47);
        }
        localVector.addElement(locald0);
      }
      return localVector;
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public static q W(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new org.bouncycastle.asn1.i(paramArrayOfByte);
    q localq = paramArrayOfByte.t();
    if (localq != null)
    {
      if (paramArrayOfByte.t() == null) {
        return localq;
      }
      throw new TlsFatalAlert((short)50);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public static byte[] X(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    if (paramInt < 1) {
      return a;
    }
    byte[] arrayOfByte = new byte[paramInt];
    int i = org.bouncycastle.util.io.b.c(paramInputStream, arrayOfByte);
    if (i == 0) {
      return null;
    }
    if (i == paramInt) {
      return arrayOfByte;
    }
    throw new EOFException();
  }
  
  public static q Y(byte[] paramArrayOfByte)
    throws IOException
  {
    q localq = W(paramArrayOfByte);
    if (a.c(localq.e("DER"), paramArrayOfByte)) {
      return localq;
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public static byte[] Z(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    if (paramInt < 1) {
      return a;
    }
    byte[] arrayOfByte = new byte[paramInt];
    if (paramInt == org.bouncycastle.util.io.b.c(paramInputStream, arrayOfByte)) {
      return arrayOfByte;
    }
    throw new EOFException();
  }
  
  public static byte[] a(p0 paramp0, byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, int paramInt)
  {
    if (!paramp0.b().i())
    {
      byte[] arrayOfByte = org.bouncycastle.util.i.e(paramString);
      paramString = m(arrayOfByte, paramArrayOfByte2);
      int i = paramp0.e().g();
      if (i == 0) {
        return b(paramArrayOfByte1, arrayOfByte, paramString, paramInt);
      }
      paramp0 = o(i);
      paramArrayOfByte2 = new byte[paramInt];
      I(paramp0, paramArrayOfByte1, paramString, paramArrayOfByte2);
      return paramArrayOfByte2;
    }
    throw new IllegalStateException("No PRF available for SSLv3 session");
  }
  
  public static byte[] a0(InputStream paramInputStream)
    throws IOException
  {
    return Z(d0(paramInputStream), paramInputStream);
  }
  
  static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    int i = (paramArrayOfByte1.length + 1) / 2;
    paramArrayOfByte2 = new byte[i];
    byte[] arrayOfByte1 = new byte[i];
    int j = 0;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, i);
    System.arraycopy(paramArrayOfByte1, paramArrayOfByte1.length - i, arrayOfByte1, 0, i);
    byte[] arrayOfByte2 = new byte[paramInt];
    paramArrayOfByte1 = new byte[paramInt];
    I(n((short)1), paramArrayOfByte2, paramArrayOfByte3, arrayOfByte2);
    I(n((short)2), arrayOfByte1, paramArrayOfByte3, paramArrayOfByte1);
    while (j < paramInt)
    {
      arrayOfByte2[j] = ((byte)(byte)(arrayOfByte2[j] ^ paramArrayOfByte1[j]));
      j++;
    }
    return arrayOfByte2;
  }
  
  public static byte[] b0(InputStream paramInputStream)
    throws IOException
  {
    return Z(g0(paramInputStream), paramInputStream);
  }
  
  public static void c(Hashtable paramHashtable, Vector paramVector)
    throws IOException
  {
    paramHashtable.put(e, p(paramVector));
  }
  
  public static byte[] c0(InputStream paramInputStream)
    throws IOException
  {
    return Z(j0(paramInputStream), paramInputStream);
  }
  
  static byte[] d(p0 paramp0, int paramInt)
  {
    Object localObject = paramp0.e();
    byte[] arrayOfByte = ((a0)localObject).e();
    localObject = m(((a0)localObject).i(), ((a0)localObject).c());
    if (K(paramp0)) {
      return e(arrayOfByte, (byte[])localObject, paramInt);
    }
    return a(paramp0, arrayOfByte, "key expansion", (byte[])localObject, paramInt);
  }
  
  public static int d0(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    if (j >= 0) {
      return j | i << 8;
    }
    throw new EOFException();
  }
  
  static byte[] e(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    org.bouncycastle.crypto.g localg1 = n();
    org.bouncycastle.crypto.g localg2 = n((short)2);
    int i = localg1.e();
    int j = localg2.e();
    byte[] arrayOfByte1 = new byte[j];
    byte[] arrayOfByte2 = new byte[paramInt + i];
    int k = 0;
    for (int m = 0; k < paramInt; m++)
    {
      byte[] arrayOfByte3 = h[m];
      localg2.update(arrayOfByte3, 0, arrayOfByte3.length);
      localg2.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      localg2.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
      localg2.doFinal(arrayOfByte1, 0);
      localg1.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      localg1.update(arrayOfByte1, 0, j);
      localg1.doFinal(arrayOfByte2, k);
      k += i;
    }
    return a.s(arrayOfByte2, 0, paramInt);
  }
  
  public static int e0(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    return paramArrayOfByte[(paramInt + 1)] & 0xFF | (i & 0xFF) << 8;
  }
  
  static byte[] f(p0 paramp0, byte[] paramArrayOfByte)
  {
    Object localObject = paramp0.e();
    byte[] arrayOfByte;
    if (((a0)localObject).o) {
      arrayOfByte = ((a0)localObject).j();
    } else {
      arrayOfByte = m(((a0)localObject).c(), ((a0)localObject).i());
    }
    if (K(paramp0)) {
      return g(paramArrayOfByte, arrayOfByte);
    }
    if (((a0)localObject).o) {
      localObject = "extended master secret";
    } else {
      localObject = "master secret";
    }
    return a(paramp0, paramArrayOfByte, (String)localObject, arrayOfByte, 48);
  }
  
  public static int[] f0(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    int[] arrayOfInt = new int[paramInt];
    for (int i = 0; i < paramInt; i++) {
      arrayOfInt[i] = d0(paramInputStream);
    }
    return arrayOfInt;
  }
  
  static byte[] g(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    org.bouncycastle.crypto.g localg1 = n();
    org.bouncycastle.crypto.g localg2 = n((short)2);
    int i = localg1.e();
    int j = localg2.e();
    byte[] arrayOfByte1 = new byte[j];
    byte[] arrayOfByte2 = new byte[i * 3];
    int k = 0;
    int m = 0;
    while (k < 3)
    {
      byte[] arrayOfByte3 = h[k];
      localg2.update(arrayOfByte3, 0, arrayOfByte3.length);
      localg2.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      localg2.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
      localg2.doFinal(arrayOfByte1, 0);
      localg1.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      localg1.update(arrayOfByte1, 0, j);
      localg1.doFinal(arrayOfByte2, m);
      m += i;
      k++;
    }
    return arrayOfByte2;
  }
  
  public static int g0(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    int k = paramInputStream.read();
    if (k >= 0) {
      return k | i << 16 | j << 8;
    }
    throw new EOFException();
  }
  
  static byte[] h(p0 paramp0, String paramString, byte[] paramArrayOfByte)
  {
    if (K(paramp0)) {
      return paramArrayOfByte;
    }
    a0 locala0 = paramp0.e();
    return a(paramp0, locala0.e(), paramString, paramArrayOfByte, locala0.k());
  }
  
  public static int h0(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    paramInt++;
    int j = paramArrayOfByte[paramInt];
    return paramArrayOfByte[(paramInt + 1)] & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  public static void i(int paramInt)
    throws IOException
  {
    if (R(paramInt)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static long i0(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    int k = paramInputStream.read();
    int m = paramInputStream.read();
    if (m >= 0) {
      return (m | i << 24 | j << 16 | k << 8) & 0xFFFFFFFF;
    }
    throw new EOFException();
  }
  
  public static void j(int paramInt)
    throws IOException
  {
    if (S(paramInt)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static short j0(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i >= 0) {
      return (short)i;
    }
    throw new EOFException();
  }
  
  public static void k(int paramInt)
    throws IOException
  {
    if (T(paramInt)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static short k0(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(paramArrayOfByte[paramInt] & 0xFF);
  }
  
  public static org.bouncycastle.crypto.g l(short paramShort, org.bouncycastle.crypto.g paramg)
  {
    switch (paramShort)
    {
    default: 
      throw new IllegalArgumentException("unknown HashAlgorithm");
    case 6: 
      return new org.bouncycastle.crypto.p.i((org.bouncycastle.crypto.p.i)paramg);
    case 5: 
      return new org.bouncycastle.crypto.p.h((org.bouncycastle.crypto.p.h)paramg);
    case 4: 
      return new org.bouncycastle.crypto.p.g((org.bouncycastle.crypto.p.g)paramg);
    case 3: 
      return new f((f)paramg);
    case 2: 
      return new e((e)paramg);
    }
    return new org.bouncycastle.crypto.p.d((org.bouncycastle.crypto.p.d)paramg);
  }
  
  public static short[] l0(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    short[] arrayOfShort = new short[paramInt];
    for (int i = 0; i < paramInt; i++) {
      arrayOfShort[i] = j0(paramInputStream);
    }
    return arrayOfShort;
  }
  
  static byte[] m(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public static x m0(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    if (j >= 0) {
      return x.b(i, j);
    }
    throw new EOFException();
  }
  
  public static org.bouncycastle.crypto.g n(short paramShort)
  {
    switch (paramShort)
    {
    default: 
      throw new IllegalArgumentException("unknown HashAlgorithm");
    case 6: 
      return new org.bouncycastle.crypto.p.i();
    case 5: 
      return new org.bouncycastle.crypto.p.h();
    case 4: 
      return new org.bouncycastle.crypto.p.g();
    case 3: 
      return new f();
    case 2: 
      return new e();
    }
    return new org.bouncycastle.crypto.p.d();
  }
  
  public static x n0(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    return x.b(paramArrayOfByte[paramInt] & 0xFF, paramArrayOfByte[(paramInt + 1)] & 0xFF);
  }
  
  public static org.bouncycastle.crypto.g o(int paramInt)
  {
    if (paramInt != 0) {
      return n(C(paramInt));
    }
    return new m();
  }
  
  public static int o0(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int i = paramArrayOfByte[paramInt];
    return paramArrayOfByte[(paramInt + 1)] | i << 8;
  }
  
  public static byte[] p(Vector paramVector)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    r(paramVector, false, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  static void p0(v0 paramv0, Vector paramVector)
  {
    if (paramVector != null) {
      for (int i = 0; i < paramVector.size(); i++)
      {
        short s = ((d0)paramVector.elementAt(i)).b();
        if (!s.c(s)) {
          paramv0.h(s);
        }
      }
    }
  }
  
  public static byte[] q(byte[] paramArrayOfByte)
    throws IOException
  {
    k(paramArrayOfByte.length);
    return a.E(paramArrayOfByte, (byte)paramArrayOfByte.length);
  }
  
  static void q0(org.bouncycastle.asn1.x509.h paramh, int paramInt)
    throws IOException
  {
    paramh = paramh.o().g();
    if (paramh != null)
    {
      paramh = t.f(paramh);
      if ((paramh != null) && ((paramh.g()[0] & 0xFF & paramInt) != paramInt)) {
        throw new TlsFatalAlert((short)46);
      }
    }
  }
  
  public static void r(Vector paramVector, boolean paramBoolean, OutputStream paramOutputStream)
    throws IOException
  {
    if ((paramVector != null) && (paramVector.size() >= 1) && (paramVector.size() < 32768))
    {
      int i = paramVector.size() * 2;
      i(i);
      w0(i, paramOutputStream);
      for (i = 0; i < paramVector.size(); i++)
      {
        d0 locald0 = (d0)paramVector.elementAt(i);
        if ((!paramBoolean) && (locald0.c() == 0)) {
          throw new IllegalArgumentException("SignatureAlgorithm.anonymous MUST NOT appear in the signature_algorithms extension");
        }
        locald0.a(paramOutputStream);
      }
      return;
    }
    throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
  }
  
  private static Vector r0(Object paramObject)
  {
    Vector localVector = new Vector(1);
    localVector.addElement(paramObject);
    return localVector;
  }
  
  public static byte[] s(int[] paramArrayOfInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length * 2 + 2];
    B0(paramArrayOfInt, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static void s0(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramArrayOfByte[paramInt] = ((byte)(byte)(i >>> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(byte)(i >>> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(byte)(i >>> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(byte)i);
  }
  
  public static byte[] t(short[] paramArrayOfShort)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramArrayOfShort.length + 1];
    M0(paramArrayOfShort, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static void t0(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    i(paramArrayOfByte.length);
    w0(paramArrayOfByte.length, paramOutputStream);
    paramOutputStream.write(paramArrayOfByte);
  }
  
  private static byte[][] u()
  {
    byte[][] arrayOfByte = new byte[10][];
    int j;
    for (int i = 0; i < 10; i = j)
    {
      j = i + 1;
      byte[] arrayOfByte1 = new byte[j];
      a.u(arrayOfByte1, (byte)(i + 65));
      arrayOfByte[i] = arrayOfByte1;
    }
    return arrayOfByte;
  }
  
  public static void u0(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    j(paramArrayOfByte.length);
    C0(paramArrayOfByte.length, paramOutputStream);
    paramOutputStream.write(paramArrayOfByte);
  }
  
  public static int v(int paramInt)
    throws IOException
  {
    paramInt = A(paramInt);
    if ((paramInt != 103) && (paramInt != 104)) {
      switch (paramInt)
      {
      default: 
        throw new TlsFatalAlert((short)80);
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 12: 
      case 13: 
      case 14: 
        return 1;
      case 0: 
      case 1: 
      case 2: 
        return 0;
      }
    }
    return 2;
  }
  
  public static void v0(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    k(paramArrayOfByte.length);
    F0(paramArrayOfByte.length, paramOutputStream);
    paramOutputStream.write(paramArrayOfByte);
  }
  
  public static Vector w()
  {
    return r0(new d0((short)2, (short)2));
  }
  
  public static void w0(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramInt >>> 8);
    paramOutputStream.write(paramInt);
  }
  
  public static Vector x()
  {
    return r0(new d0((short)2, (short)3));
  }
  
  public static void x0(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(byte)paramInt1);
  }
  
  public static Vector y()
  {
    return r0(new d0((short)2, (short)1));
  }
  
  public static void y0(int[] paramArrayOfInt, OutputStream paramOutputStream)
    throws IOException
  {
    for (int i = 0; i < paramArrayOfInt.length; i++) {
      w0(paramArrayOfInt[i], paramOutputStream);
    }
  }
  
  public static Vector z()
  {
    Vector localVector = new Vector();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 5; j++) {
        localVector.addElement(new d0(new short[] { 2, 3, 4, 5, 6 }[j], new short[] { 1, 2, 3 }[i]));
      }
    }
    return localVector;
  }
  
  public static void z0(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    for (int i = 0; i < paramArrayOfInt.length; i++)
    {
      x0(paramArrayOfInt[i], paramArrayOfByte, paramInt);
      paramInt += 2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\m1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */