package b.d.e0.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import b.d.e0.h.e;
import b.d.e0.h.e.b;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.b.a;
import com.tplink.zxing.activity.CaptureFragment;
import java.nio.ByteBuffer;

final class d
  extends Handler
{
  private static final String a = d.class.getSimpleName();
  private final CaptureFragment b;
  private final BarcodeScanner c;
  
  d(CaptureFragment paramCaptureFragment)
  {
    this.b = paramCaptureFragment;
    this.c = com.google.mlkit.vision.barcode.c.a(new b.a().a());
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.currentTimeMillis();
    int i = paramArrayOfByte.length;
    Object localObject1 = new byte[i];
    for (int j = 0; j < paramInt2; j++) {
      for (int k = 0; k < paramInt1; k++) {
        localObject1[(k * paramInt2 + paramInt2 - j - 1)] = ((byte)paramArrayOfByte[(j * paramInt1 + k)]);
      }
    }
    paramArrayOfByte = b.d.e0.h.c.c().a((byte[])localObject1, paramInt2, paramInt1);
    try
    {
      Object localObject2 = new b/d/e0/h/e$b;
      ((e.b)localObject2).<init>();
      localObject2 = ((e.b)localObject2).d(paramInt2).b(paramInt1).c(0).a();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
      localByteBuffer.put((byte[])localObject1);
      localObject1 = b.b.a.a.a.a.a(localByteBuffer, ((e)localObject2).c(), ((e)localObject2).a(), ((e)localObject2).b(), 17);
      localObject1 = this.c.q((b.b.a.a.a.a)localObject1);
      localObject2 = new b/d/e0/i/b;
      ((b)localObject2).<init>(this, paramArrayOfByte);
      paramArrayOfByte = ((Task)localObject1).addOnSuccessListener((OnSuccessListener)localObject2);
      localObject1 = new b/d/e0/i/a;
      ((a)localObject1).<init>(this);
      paramArrayOfByte.addOnFailureListener((OnFailureListener)localObject1);
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (this.b.B0() != null) {
        Message.obtain(this.b.B0(), b.d.e0.d.decode_failed).sendToTarget();
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i == b.d.e0.d.decode)
    {
      a((byte[])paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
    }
    else if (i == b.d.e0.d.quit)
    {
      this.c.close();
      Looper.myLooper().quit();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */