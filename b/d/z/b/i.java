package b.d.z.b;

import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class i
  extends b
  implements c.a
{
  private static final String Q3 = i.class.getSimpleName();
  protected final AtomicReference<YUVBuffer> R3 = new AtomicReference();
  private final AtomicReference<YUVBuffer> S3 = new AtomicReference();
  private final AtomicReference<YUVBuffer> T3 = new AtomicReference();
  private final ByteBuffer[] U3 = new ByteBuffer[3];
  private int[] V3;
  private c W3;
  private int X3;
  
  public i(int paramInt)
  {
    this.O3 = paramInt;
    this.W3 = null;
  }
  
  private void q(int paramInt)
  {
    if ((this.W3 != null) && (paramInt == this.X3)) {
      return;
    }
    String str = Q3;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mColorFormat ");
    localStringBuilder.append(this.X3);
    localStringBuilder.append(" colorFormat ");
    localStringBuilder.append(paramInt);
    b.d.p.d.a(str, localStringBuilder.toString());
    this.X3 = paramInt;
    this.W3 = s();
  }
  
  private void r(ByteBuffer[] paramArrayOfByteBuffer, int paramInt)
  {
    ByteBuffer[] arrayOfByteBuffer = this.U3;
    if ((arrayOfByteBuffer[0] != null) && (arrayOfByteBuffer[0].capacity() >= paramArrayOfByteBuffer[0].limit())) {
      this.U3[0].clear();
    } else {
      this.U3[0] = ByteBuffer.allocate(paramArrayOfByteBuffer[0].limit());
    }
    this.U3[0].put(paramArrayOfByteBuffer[0]);
    arrayOfByteBuffer = this.U3;
    if ((arrayOfByteBuffer[1] != null) && (arrayOfByteBuffer[1].capacity() >= paramArrayOfByteBuffer[1].limit())) {
      this.U3[1].clear();
    } else {
      this.U3[1] = ByteBuffer.allocate(paramArrayOfByteBuffer[1].limit());
    }
    this.U3[1].put(paramArrayOfByteBuffer[1]);
    if (paramInt == 10)
    {
      arrayOfByteBuffer = this.U3;
      if ((arrayOfByteBuffer[2] != null) && (arrayOfByteBuffer[2].capacity() >= paramArrayOfByteBuffer[2].limit())) {
        this.U3[2].clear();
      } else {
        this.U3[2] = ByteBuffer.allocate(paramArrayOfByteBuffer[2].limit());
      }
      this.U3[2].put(paramArrayOfByteBuffer[2]);
    }
  }
  
  private c s()
  {
    if (this.X3 == 11)
    {
      localObject = new e(this);
      ((c)localObject).p();
      return (c)localObject;
    }
    Object localObject = new d(this);
    ((c)localObject).p();
    return (c)localObject;
  }
  
  public float[] a()
  {
    return f();
  }
  
  protected void b()
  {
    if (this.T3.get() == null)
    {
      boolean bool = this.d;
      if ((bool) || (this.f))
      {
        if ((bool) && (this.f))
        {
          this.d = false;
          this.f = true;
        }
        this.T3.set((YUVBuffer)this.S3.get());
        YUVBuffer localYUVBuffer = (YUVBuffer)this.T3.get();
        if (localYUVBuffer == null) {
          return;
        }
        if ((localYUVBuffer.yuvPlanes != null) && (this.c != null)) {
          new Thread(new a(this, localYUVBuffer), "generatePic").start();
        }
      }
    }
  }
  
  public void m(YUVBuffer paramYUVBuffer)
  {
    paramYUVBuffer = (YUVBuffer)this.R3.getAndSet(paramYUVBuffer);
    h localh = this.P3;
    if ((localh != null) && (paramYUVBuffer != null)) {
      localh.d(paramYUVBuffer);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    Object localObject = (YUVBuffer)this.R3.getAndSet(null);
    if ((localObject == null) && (this.S3.get() == null)) {
      return;
    }
    if (localObject != null)
    {
      paramGL10 = (YUVBuffer)this.S3.get();
      if ((paramGL10 != null) && (this.S3.compareAndSet((YUVBuffer)this.T3.get(), localObject)))
      {
        localObject = Q3;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("渲染完毕,不释放");
        localStringBuilder.append(paramGL10);
        b.d.p.d.a((String)localObject, localStringBuilder.toString());
      }
      else
      {
        this.S3.set(localObject);
        if ((this.P3 != null) && (paramGL10 != null) && (this.T3.get() != paramGL10)) {
          this.P3.d(paramGL10);
        }
      }
    }
    localObject = (YUVBuffer)this.S3.get();
    if ((((YUVBuffer)localObject).yuvStrides != null) && (((YUVBuffer)localObject).yuvPlanes != null))
    {
      int i = ((YUVBuffer)localObject).height;
      if ((i != this.I3) || (((YUVBuffer)localObject).width != this.H3))
      {
        this.I3 = i;
        this.H3 = ((YUVBuffer)localObject).width;
        i();
      }
      q(((YUVBuffer)localObject).frameFormat);
      paramGL10 = this.W3;
      if (paramGL10 != null) {
        paramGL10.b((YUVBuffer)localObject);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = this.W3;
    if (paramGL10 != null) {
      paramGL10.q();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\z\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */