package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.util.i;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser
  implements ImageHeaderParser
{
  static final byte[] a = "Exif\000\000".getBytes(Charset.forName("UTF-8"));
  private static final int[] b = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  
  private static int d(int paramInt1, int paramInt2)
  {
    return paramInt1 + 2 + paramInt2 * 12;
  }
  
  private int e(Reader paramReader, b paramb)
    throws IOException
  {
    try
    {
      int i = paramReader.a();
      boolean bool = g(i);
      if (!bool)
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3))
        {
          paramReader = new java/lang/StringBuilder;
          paramReader.<init>();
          paramReader.append("Parser doesn't handle magic number: ");
          paramReader.append(i);
          Log.d("DfltImageHeaderParser", paramReader.toString());
        }
        return -1;
      }
      i = i(paramReader);
      if (i == -1)
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
          Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
        }
        return -1;
      }
      byte[] arrayOfByte = (byte[])paramb.c(i, byte[].class);
      try
      {
        i = k(paramReader, arrayOfByte, i);
        return i;
      }
      finally
      {
        paramb.e(arrayOfByte);
      }
      return -1;
    }
    catch (DefaultImageHeaderParser.Reader.EndOfFileException paramReader) {}
  }
  
  @NonNull
  private ImageHeaderParser.ImageType f(Reader paramReader)
    throws IOException
  {
    try
    {
      int i = paramReader.a();
      if (i == 65496) {
        return ImageHeaderParser.ImageType.JPEG;
      }
      i = i << 8 | paramReader.c();
      if (i == 4671814) {
        return ImageHeaderParser.ImageType.GIF;
      }
      i = i << 8 | paramReader.c();
      if (i == -1991225785)
      {
        paramReader.skip(21L);
        try
        {
          if (paramReader.c() >= 3) {
            paramReader = ImageHeaderParser.ImageType.PNG_A;
          } else {
            paramReader = ImageHeaderParser.ImageType.PNG;
          }
          return paramReader;
        }
        catch (DefaultImageHeaderParser.Reader.EndOfFileException paramReader)
        {
          return ImageHeaderParser.ImageType.PNG;
        }
      }
      if (i != 1380533830) {
        return ImageHeaderParser.ImageType.UNKNOWN;
      }
      paramReader.skip(4L);
      if ((paramReader.a() << 16 | paramReader.a()) != 1464156752) {
        return ImageHeaderParser.ImageType.UNKNOWN;
      }
      i = paramReader.a() << 16 | paramReader.a();
      if ((i & 0xFF00) != 1448097792) {
        return ImageHeaderParser.ImageType.UNKNOWN;
      }
      i &= 0xFF;
      if (i == 88)
      {
        paramReader.skip(4L);
        if ((paramReader.c() & 0x10) != 0) {
          paramReader = ImageHeaderParser.ImageType.WEBP_A;
        } else {
          paramReader = ImageHeaderParser.ImageType.WEBP;
        }
        return paramReader;
      }
      if (i == 76)
      {
        paramReader.skip(4L);
        if ((paramReader.c() & 0x8) != 0) {
          paramReader = ImageHeaderParser.ImageType.WEBP_A;
        } else {
          paramReader = ImageHeaderParser.ImageType.WEBP;
        }
        return paramReader;
      }
      paramReader = ImageHeaderParser.ImageType.WEBP;
      return paramReader;
    }
    catch (DefaultImageHeaderParser.Reader.EndOfFileException paramReader) {}
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  private static boolean g(int paramInt)
  {
    boolean bool;
    if (((paramInt & 0xFFD8) != 65496) && (paramInt != 19789) && (paramInt != 18761)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean h(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2;
    if ((paramArrayOfByte != null) && (paramInt > a.length)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (bool2) {
      for (paramInt = 0;; paramInt++)
      {
        byte[] arrayOfByte = a;
        if (paramInt >= arrayOfByte.length) {
          break;
        }
        if (paramArrayOfByte[paramInt] != arrayOfByte[paramInt])
        {
          bool2 = bool1;
          break;
        }
      }
    }
    return bool2;
  }
  
  private int i(Reader paramReader)
    throws IOException
  {
    int i;
    int j;
    long l1;
    long l2;
    do
    {
      i = paramReader.c();
      if (i != 255)
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3))
        {
          paramReader = new StringBuilder();
          paramReader.append("Unknown segmentId=");
          paramReader.append(i);
          Log.d("DfltImageHeaderParser", paramReader.toString());
        }
        return -1;
      }
      i = paramReader.c();
      if (i == 218) {
        return -1;
      }
      if (i == 217)
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
          Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
        }
        return -1;
      }
      j = paramReader.a() - 2;
      if (i == 225) {
        break;
      }
      l1 = j;
      l2 = paramReader.skip(l1);
    } while (l2 == l1);
    if (Log.isLoggable("DfltImageHeaderParser", 3))
    {
      paramReader = new StringBuilder();
      paramReader.append("Unable to skip enough data, type: ");
      paramReader.append(i);
      paramReader.append(", wanted to skip: ");
      paramReader.append(j);
      paramReader.append(", but actually skipped: ");
      paramReader.append(l2);
      Log.d("DfltImageHeaderParser", paramReader.toString());
    }
    return -1;
    return j;
  }
  
  private static int j(b paramb)
  {
    int i = paramb.a(6);
    Object localObject;
    if (i != 18761)
    {
      if (i != 19789)
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unknown endianness = ");
          ((StringBuilder)localObject).append(i);
          Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
        }
        localObject = ByteOrder.BIG_ENDIAN;
      }
      else
      {
        localObject = ByteOrder.BIG_ENDIAN;
      }
    }
    else {
      localObject = ByteOrder.LITTLE_ENDIAN;
    }
    paramb.e((ByteOrder)localObject);
    int j = paramb.b(10) + 6;
    int k = paramb.a(j);
    for (i = 0; i < k; i++)
    {
      int m = d(j, i);
      int n = paramb.a(m);
      if (n == 274)
      {
        int i1 = paramb.a(m + 2);
        if ((i1 >= 1) && (i1 <= 12))
        {
          int i2 = paramb.b(m + 4);
          if (i2 < 0)
          {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
              Log.d("DfltImageHeaderParser", "Negative tiff component count");
            }
          }
          else
          {
            if (Log.isLoggable("DfltImageHeaderParser", 3))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Got tagIndex=");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(" tagType=");
              ((StringBuilder)localObject).append(n);
              ((StringBuilder)localObject).append(" formatCode=");
              ((StringBuilder)localObject).append(i1);
              ((StringBuilder)localObject).append(" componentCount=");
              ((StringBuilder)localObject).append(i2);
              Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
            }
            i2 += b[i1];
            if (i2 > 4)
            {
              if (Log.isLoggable("DfltImageHeaderParser", 3))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Got byte count > 4, not orientation, continuing, formatCode=");
                ((StringBuilder)localObject).append(i1);
                Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
              }
            }
            else
            {
              m += 8;
              if ((m >= 0) && (m <= paramb.d()))
              {
                if ((i2 >= 0) && (i2 + m <= paramb.d())) {
                  return paramb.a(m);
                }
                if (Log.isLoggable("DfltImageHeaderParser", 3))
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("Illegal number of bytes for TI tag data tagType=");
                  ((StringBuilder)localObject).append(n);
                  Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
                }
              }
              else if (Log.isLoggable("DfltImageHeaderParser", 3))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Illegal tagValueOffset=");
                ((StringBuilder)localObject).append(m);
                ((StringBuilder)localObject).append(" tagType=");
                ((StringBuilder)localObject).append(n);
                Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
              }
            }
          }
        }
        else if (Log.isLoggable("DfltImageHeaderParser", 3))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Got invalid format code = ");
          ((StringBuilder)localObject).append(i1);
          Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
        }
      }
    }
    return -1;
  }
  
  private int k(Reader paramReader, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int i = paramReader.b(paramArrayOfByte, paramInt);
    if (i != paramInt)
    {
      if (Log.isLoggable("DfltImageHeaderParser", 3))
      {
        paramReader = new StringBuilder();
        paramReader.append("Unable to read exif segment data, length: ");
        paramReader.append(paramInt);
        paramReader.append(", actually read: ");
        paramReader.append(i);
        Log.d("DfltImageHeaderParser", paramReader.toString());
      }
      return -1;
    }
    if (h(paramArrayOfByte, paramInt)) {
      return j(new b(paramArrayOfByte, paramInt));
    }
    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
      Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
    }
    return -1;
  }
  
  @NonNull
  public ImageHeaderParser.ImageType a(@NonNull ByteBuffer paramByteBuffer)
    throws IOException
  {
    return f(new a((ByteBuffer)i.d(paramByteBuffer)));
  }
  
  @NonNull
  public ImageHeaderParser.ImageType b(@NonNull InputStream paramInputStream)
    throws IOException
  {
    return f(new c((InputStream)i.d(paramInputStream)));
  }
  
  public int c(@NonNull InputStream paramInputStream, @NonNull b paramb)
    throws IOException
  {
    return e(new c((InputStream)i.d(paramInputStream)), (b)i.d(paramb));
  }
  
  private static abstract interface Reader
  {
    public abstract int a()
      throws IOException;
    
    public abstract int b(byte[] paramArrayOfByte, int paramInt)
      throws IOException;
    
    public abstract short c()
      throws IOException;
    
    public abstract long skip(long paramLong)
      throws IOException;
    
    public static final class EndOfFileException
      extends IOException
    {
      private static final long serialVersionUID = 1L;
      
      EndOfFileException()
      {
        super();
      }
    }
  }
  
  private static final class a
    implements DefaultImageHeaderParser.Reader
  {
    private final ByteBuffer a;
    
    a(ByteBuffer paramByteBuffer)
    {
      this.a = paramByteBuffer;
      paramByteBuffer.order(ByteOrder.BIG_ENDIAN);
    }
    
    public int a()
      throws DefaultImageHeaderParser.Reader.EndOfFileException
    {
      return c() << 8 | c();
    }
    
    public int b(byte[] paramArrayOfByte, int paramInt)
    {
      paramInt = Math.min(paramInt, this.a.remaining());
      if (paramInt == 0) {
        return -1;
      }
      this.a.get(paramArrayOfByte, 0, paramInt);
      return paramInt;
    }
    
    public short c()
      throws DefaultImageHeaderParser.Reader.EndOfFileException
    {
      if (this.a.remaining() >= 1) {
        return (short)(this.a.get() & 0xFF);
      }
      throw new DefaultImageHeaderParser.Reader.EndOfFileException();
    }
    
    public long skip(long paramLong)
    {
      int i = (int)Math.min(this.a.remaining(), paramLong);
      ByteBuffer localByteBuffer = this.a;
      localByteBuffer.position(localByteBuffer.position() + i);
      return i;
    }
  }
  
  private static final class b
  {
    private final ByteBuffer a;
    
    b(byte[] paramArrayOfByte, int paramInt)
    {
      this.a = ((ByteBuffer)ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN).limit(paramInt));
    }
    
    private boolean c(int paramInt1, int paramInt2)
    {
      boolean bool;
      if (this.a.remaining() - paramInt1 >= paramInt2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    short a(int paramInt)
    {
      int i;
      if (c(paramInt, 2))
      {
        paramInt = this.a.getShort(paramInt);
        i = paramInt;
      }
      else
      {
        paramInt = -1;
        i = paramInt;
      }
      return i;
    }
    
    int b(int paramInt)
    {
      if (c(paramInt, 4)) {
        paramInt = this.a.getInt(paramInt);
      } else {
        paramInt = -1;
      }
      return paramInt;
    }
    
    int d()
    {
      return this.a.remaining();
    }
    
    void e(ByteOrder paramByteOrder)
    {
      this.a.order(paramByteOrder);
    }
  }
  
  private static final class c
    implements DefaultImageHeaderParser.Reader
  {
    private final InputStream a;
    
    c(InputStream paramInputStream)
    {
      this.a = paramInputStream;
    }
    
    public int a()
      throws IOException
    {
      return c() << 8 | c();
    }
    
    public int b(byte[] paramArrayOfByte, int paramInt)
      throws IOException
    {
      int i = 0;
      int j = 0;
      int k;
      for (;;)
      {
        k = j;
        if (i >= paramInt) {
          break;
        }
        j = this.a.read(paramArrayOfByte, i, paramInt - i);
        k = j;
        if (j == -1) {
          break;
        }
        i += j;
      }
      if ((i == 0) && (k == -1)) {
        throw new DefaultImageHeaderParser.Reader.EndOfFileException();
      }
      return i;
    }
    
    public short c()
      throws IOException
    {
      int i = this.a.read();
      if (i != -1) {
        return (short)i;
      }
      throw new DefaultImageHeaderParser.Reader.EndOfFileException();
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        return 0L;
      }
      long l1 = paramLong;
      if (l1 > 0L)
      {
        long l2 = this.a.skip(l1);
        if (l2 > 0L) {}
        for (;;)
        {
          l1 -= l2;
          break;
          if (this.a.read() == -1) {
            break label61;
          }
          l2 = 1L;
        }
      }
      label61:
      return paramLong - l1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\DefaultImageHeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */