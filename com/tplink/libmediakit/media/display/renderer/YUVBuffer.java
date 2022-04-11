package com.tplink.libmediakit.media.display.renderer;

import androidx.annotation.Nullable;
import com.tplink.libmediakit.jniinterface.DecoderProperty;
import java.nio.ByteBuffer;

public class YUVBuffer
{
  public static final int FRAME_FORMAT_I420 = 10;
  public static final int FRAME_FORMAT_NV12 = 11;
  @Nullable
  public ByteBuffer data;
  public int frameFormat;
  public int height;
  public int outputIndex;
  public long presentationTimeUs;
  public long timestamp;
  public int width;
  @Nullable
  public ByteBuffer[] yuvPlanes;
  @Nullable
  public int[] yuvStrides;
  
  public YUVBuffer() {}
  
  public YUVBuffer(int paramInt)
  {
    this.outputIndex = paramInt;
  }
  
  private boolean initForYuvFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.frameFormat = paramInt5;
    paramInt1 = (int)((paramInt2 + 1L) / 2L);
    if ((!isNotSafeToMultiply(paramInt3, paramInt2)) && (!isNotSafeToMultiply(paramInt4, paramInt1)))
    {
      paramInt2 *= paramInt3;
      int i = paramInt1 * paramInt4;
      paramInt1 = i * 2 + paramInt2;
      if (paramInt5 == 11) {
        paramInt1 = paramInt2 + i;
      }
      if ((!isNotSafeToMultiply(i, 2)) && (paramInt1 >= paramInt2))
      {
        Object localObject = this.data;
        if ((localObject != null) && (((ByteBuffer)localObject).capacity() >= paramInt1)) {
          this.data.clear();
        } else {
          this.data = ByteBuffer.allocateDirect(paramInt1);
        }
        if (this.yuvPlanes == null) {
          this.yuvPlanes = new ByteBuffer[3];
        }
        ByteBuffer localByteBuffer = this.data;
        localObject = this.yuvPlanes;
        localObject[0] = localByteBuffer.slice();
        localObject[0].limit(paramInt2);
        localByteBuffer.position(paramInt2);
        localObject[1] = localByteBuffer.slice();
        localObject[1].limit(i);
        if (paramInt5 != 11)
        {
          localByteBuffer.position(paramInt2 + i);
          localObject[2] = localByteBuffer.slice();
          localObject[2].limit(i);
        }
        if (this.yuvStrides == null) {
          this.yuvStrides = new int[3];
        }
        localObject = this.yuvStrides;
        localObject[0] = paramInt3;
        localObject[1] = paramInt4;
        if (paramInt5 != 11) {
          localObject[2] = paramInt4;
        } else {
          localObject[2] = 0;
        }
        this.presentationTimeUs = paramLong;
        return true;
      }
    }
    return false;
  }
  
  private static boolean isNotSafeToMultiply(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && ((paramInt2 <= 0) || (paramInt1 < Integer.MAX_VALUE / paramInt2))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean initParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, ByteBuffer paramByteBuffer)
  {
    if (paramInt1 == 19) {
      paramInt1 = 10;
    } else {
      paramInt1 = 11;
    }
    this.frameFormat = paramInt1;
    this.width = paramInt6;
    this.height = paramInt7;
    if (paramInt1 == 10) {
      paramInt1 = paramInt2 / 2;
    } else {
      paramInt1 = paramInt2;
    }
    paramInt3 = (int)((paramInt7 + 1L) / 2L);
    if ((!isNotSafeToMultiply(paramInt2, paramInt7)) && (!isNotSafeToMultiply(paramInt1, paramInt3)))
    {
      paramInt7 = this.height * paramInt2;
      int i = paramInt3 * paramInt1;
      paramInt6 = paramInt7 + i;
      if (this.frameFormat == 10) {
        paramInt3 = i * 2 + paramInt7;
      } else {
        paramInt3 = paramInt6;
      }
      if ((!isNotSafeToMultiply(i, 2)) && (paramInt3 >= paramInt7))
      {
        Object localObject = this.data;
        if ((localObject != null) && (((ByteBuffer)localObject).capacity() >= paramInt3)) {
          this.data.clear();
        } else {
          this.data = ByteBuffer.allocateDirect(paramInt3);
        }
        paramByteBuffer.position(paramInt5 * paramInt2);
        localObject = paramByteBuffer.slice();
        ((ByteBuffer)localObject).limit(paramInt7);
        this.data.put((ByteBuffer)localObject);
        this.data.position(paramInt7);
        paramInt5 = paramInt5 / 2 * paramInt1;
        paramInt3 = paramInt2 * paramInt4 + paramInt5;
        paramByteBuffer.position(paramInt3);
        localObject = paramByteBuffer.slice();
        ((ByteBuffer)localObject).limit(i);
        this.data.put((ByteBuffer)localObject);
        this.data.position(paramInt6);
        if (this.frameFormat == 10)
        {
          paramByteBuffer.position(paramInt5 + paramInt3 + paramInt1 * paramInt4 / 2);
          paramByteBuffer = paramByteBuffer.slice();
          paramByteBuffer.limit(i);
          this.data.put(paramByteBuffer);
          this.data.position(paramInt6 + i);
        }
        this.data.flip();
        if (this.yuvPlanes == null) {
          this.yuvPlanes = new ByteBuffer[3];
        }
        paramByteBuffer = this.data;
        localObject = this.yuvPlanes;
        localObject[0] = paramByteBuffer.slice();
        localObject[0].limit(paramInt7);
        paramByteBuffer.position(paramInt7);
        localObject[1] = paramByteBuffer.slice();
        localObject[1].limit(i);
        if (this.frameFormat != 11)
        {
          paramByteBuffer.position(paramInt6);
          localObject[2] = paramByteBuffer.slice();
          localObject[2].limit(i);
        }
        if (this.yuvStrides == null) {
          this.yuvStrides = new int[3];
        }
        paramByteBuffer = this.yuvStrides;
        paramByteBuffer[0] = paramInt2;
        paramByteBuffer[1] = paramInt1;
        if (this.frameFormat != 11) {
          paramByteBuffer[2] = paramInt1;
        } else {
          paramByteBuffer[2] = 0;
        }
        this.presentationTimeUs = paramLong;
        return true;
      }
    }
    return false;
  }
  
  public boolean initParamsInNative(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, ByteBuffer paramByteBuffer)
  {
    boolean bool;
    if (DecoderProperty.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong, paramByteBuffer, this) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void release()
  {
    this.data = null;
    this.yuvPlanes = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("YUVBuffer@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\display\renderer\YUVBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */