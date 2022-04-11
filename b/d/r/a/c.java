package b.d.r.a;

import android.media.MediaFormat;
import com.tplink.libmediakit.jniinterface.DecoderProperty;
import com.tplink.libmediakit.jniinterface.DecoderProperty.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<[B>;

public class c
{
  private int a = 0;
  private int b = 0;
  private MediaFormat c;
  private final DecoderProperty d = new DecoderProperty();
  private boolean e = false;
  
  private boolean d(List<byte[]> paramList)
    throws Exception
  {
    Iterator localIterator = paramList.iterator();
    Object localObject1 = null;
    paramList = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (byte[])localIterator.next();
      if ((localObject2[4] & 0x1F) == 7) {
        localObject1 = localObject2;
      } else if ((localObject2[4] & 0x1F) == 8) {
        paramList = (List<byte[]>)localObject2;
      }
    }
    if ((localObject1 != null) && (paramList != null))
    {
      if ((this.a <= 0) || (this.b <= 0))
      {
        localObject2 = new DecoderProperty.a();
        this.d.a((byte[])localObject1, (DecoderProperty.a)localObject2);
        this.a = ((DecoderProperty.a)localObject2).b();
        this.b = ((DecoderProperty.a)localObject2).a();
      }
      localObject2 = MediaFormat.createVideoFormat("video/avc", this.a, this.b);
      this.c = ((MediaFormat)localObject2);
      ((MediaFormat)localObject2).setByteBuffer("csd-0", ByteBuffer.wrap((byte[])localObject1));
      this.c.setByteBuffer("csd-1", ByteBuffer.wrap(paramList));
      this.c.setInteger("color-format", 19);
      this.c.setInteger("max-input-size", this.a * this.b);
      this.c.setInteger("capture-rate", 30);
      return true;
    }
    return false;
  }
  
  private boolean e(byte[] paramArrayOfByte)
    throws Exception
  {
    return d(h(paramArrayOfByte));
  }
  
  public void a(List<byte[]> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 2) && (!this.e)) {
      try
      {
        this.e = d(paramList);
      }
      catch (Exception paramList)
      {
        this.e = false;
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0) && (!this.e)) {
      try
      {
        this.e = e((byte[])paramArrayOfByte.clone());
      }
      catch (Exception paramArrayOfByte)
      {
        this.e = false;
      }
    }
  }
  
  public void c()
  {
    this.e = false;
    this.c = null;
  }
  
  public MediaFormat f()
  {
    if (!this.e) {
      return null;
    }
    return this.c;
  }
  
  public boolean g()
  {
    return this.e;
  }
  
  public List<byte[]> h(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 5))
    {
      int i = paramArrayOfByte.length;
      int j = 5;
      byte[] arrayOfByte;
      while (j < i - 4)
      {
        int k = i;
        int m = j;
        if (paramArrayOfByte[j] == 0)
        {
          k = i;
          m = j;
          if (paramArrayOfByte[(j + 1)] == 0)
          {
            k = i;
            m = j;
            if (paramArrayOfByte[(j + 2)] == 0)
            {
              k = i;
              m = j;
              if (paramArrayOfByte[(j + 3)] == 1)
              {
                arrayOfByte = new byte[j];
                System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, j);
                localArrayList.add(arrayOfByte);
                k = i - j;
                System.arraycopy(paramArrayOfByte, j, paramArrayOfByte, 0, k);
                m = 5;
              }
            }
          }
        }
        j = m + 1;
        i = k;
      }
      if (i > 5)
      {
        arrayOfByte = new byte[i];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
        localArrayList.add(arrayOfByte);
      }
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\r\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */