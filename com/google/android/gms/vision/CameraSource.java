package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class CameraSource
{
  @SuppressLint({"InlinedApi"})
  public static final int CAMERA_FACING_BACK = 0;
  @SuppressLint({"InlinedApi"})
  public static final int CAMERA_FACING_FRONT = 1;
  private int facing = 0;
  private int rotation;
  private Context zzg;
  private final Object zzh = new Object();
  @GuardedBy("cameraLock")
  private Camera zzi;
  private Size zzj;
  private float zzk = 30.0F;
  private int zzl = 1024;
  private int zzm = 768;
  private boolean zzn = false;
  private String zzo;
  private SurfaceTexture zzp;
  private boolean zzq;
  private Thread zzr;
  private zza zzs;
  private Map<byte[], ByteBuffer> zzt = new HashMap();
  
  @SuppressLint({"InlinedApi"})
  private final byte[] zza(Size paramSize)
  {
    int i = ImageFormat.getBitsPerPixel(17);
    paramSize = new byte[(int)Math.ceil(paramSize.getHeight() * paramSize.getWidth() * i / 8.0D) + 1];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramSize);
    if ((localByteBuffer.hasArray()) && (localByteBuffer.array() == paramSize))
    {
      this.zzt.put(paramSize, localByteBuffer);
      return paramSize;
    }
    throw new IllegalStateException("Failed to create valid buffer for camera source.");
  }
  
  @SuppressLint({"InlinedApi"})
  private final Camera zzb()
    throws IOException
  {
    int i = this.facing;
    Object localObject1 = new Camera.CameraInfo();
    for (int j = 0; j < Camera.getNumberOfCameras(); j++)
    {
      Camera.getCameraInfo(j, (Camera.CameraInfo)localObject1);
      if (((Camera.CameraInfo)localObject1).facing == i)
      {
        i = j;
        break label48;
      }
    }
    i = -1;
    label48:
    if (i != -1)
    {
      Camera localCamera = Camera.open(i);
      int k = this.zzl;
      int m = this.zzm;
      Object localObject2 = localCamera.getParameters();
      localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
      List localList = ((Camera.Parameters)localObject2).getSupportedPictureSizes();
      Object localObject3 = new ArrayList();
      Iterator localIterator = ((List)localObject1).iterator();
      Object localObject4;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label223;
        }
        Camera.Size localSize = (Camera.Size)localIterator.next();
        float f = localSize.width / localSize.height;
        localObject4 = localList.iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localObject2 = (Camera.Size)((Iterator)localObject4).next();
          if (Math.abs(f - ((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height) >= 0.01F) {
            break;
          }
          ((List)localObject3).add(new zze(localSize, (Camera.Size)localObject2));
        }
      }
      label223:
      if (((List)localObject3).size() == 0)
      {
        Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject3).add(new zze((Camera.Size)((Iterator)localObject1).next(), null));
        }
      }
      int n = ((ArrayList)localObject3).size();
      int i1 = Integer.MAX_VALUE;
      localObject1 = null;
      int i2 = 0;
      j = Integer.MAX_VALUE;
      int i3;
      while (i2 < n)
      {
        localObject2 = ((ArrayList)localObject3).get(i2);
        i3 = i2 + 1;
        localObject2 = (zze)localObject2;
        localObject4 = ((zze)localObject2).zzc();
        int i4 = Math.abs(((Size)localObject4).getWidth() - k) + Math.abs(((Size)localObject4).getHeight() - m);
        i2 = i3;
        if (i4 < j)
        {
          localObject1 = localObject2;
          j = i4;
          i2 = i3;
        }
      }
      if (localObject1 != null)
      {
        localObject3 = ((zze)localObject1).zzd();
        this.zzj = ((zze)localObject1).zzc();
        i3 = (int)(this.zzk * 1000.0F);
        localObject4 = localCamera.getParameters().getSupportedPreviewFpsRange().iterator();
        localObject1 = null;
        j = i1;
        while (((Iterator)localObject4).hasNext())
        {
          localObject2 = (int[])((Iterator)localObject4).next();
          i1 = localObject2[0];
          i2 = localObject2[1];
          i2 = Math.abs(i3 - i1) + Math.abs(i3 - i2);
          if (i2 < j)
          {
            localObject1 = localObject2;
            j = i2;
          }
        }
        if (localObject1 != null)
        {
          localObject2 = localCamera.getParameters();
          if (localObject3 != null) {
            ((Camera.Parameters)localObject2).setPictureSize(((Size)localObject3).getWidth(), ((Size)localObject3).getHeight());
          }
          ((Camera.Parameters)localObject2).setPreviewSize(this.zzj.getWidth(), this.zzj.getHeight());
          ((Camera.Parameters)localObject2).setPreviewFpsRange(localObject1[0], localObject1[1]);
          ((Camera.Parameters)localObject2).setPreviewFormat(17);
          j = ((WindowManager)this.zzg.getSystemService("window")).getDefaultDisplay().getRotation();
          if (j != 0) {
            if (j != 1)
            {
              if (j != 2)
              {
                if (j != 3)
                {
                  localObject1 = new StringBuilder(31);
                  ((StringBuilder)localObject1).append("Bad rotation value: ");
                  ((StringBuilder)localObject1).append(j);
                  Log.e("CameraSource", ((StringBuilder)localObject1).toString());
                }
                else
                {
                  j = 270;
                  break label673;
                }
              }
              else
              {
                j = 180;
                break label673;
              }
            }
            else
            {
              j = 90;
              break label673;
            }
          }
          j = 0;
          label673:
          localObject1 = new Camera.CameraInfo();
          Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
          if (((Camera.CameraInfo)localObject1).facing == 1)
          {
            j = (((Camera.CameraInfo)localObject1).orientation + j) % 360;
            i = (360 - j) % 360;
          }
          else
          {
            j = (((Camera.CameraInfo)localObject1).orientation - j + 360) % 360;
            i = j;
          }
          this.rotation = (j / 90);
          localCamera.setDisplayOrientation(i);
          ((Camera.Parameters)localObject2).setRotation(j);
          if (this.zzo != null) {
            if (((Camera.Parameters)localObject2).getSupportedFocusModes().contains(this.zzo))
            {
              ((Camera.Parameters)localObject2).setFocusMode(this.zzo);
            }
            else
            {
              Log.w("CameraSource", String.format("FocusMode %s is not supported on this device.", new Object[] { this.zzo }));
              this.zzo = null;
            }
          }
          if ((this.zzo == null) && (this.zzn)) {
            if (((Camera.Parameters)localObject2).getSupportedFocusModes().contains("continuous-video"))
            {
              ((Camera.Parameters)localObject2).setFocusMode("continuous-video");
              this.zzo = "continuous-video";
            }
            else
            {
              Log.i("CameraSource", "Camera auto focus is not supported on this device.");
            }
          }
          localCamera.setParameters((Camera.Parameters)localObject2);
          localCamera.setPreviewCallbackWithBuffer(new zzb(null));
          localCamera.addCallbackBuffer(zza(this.zzj));
          localCamera.addCallbackBuffer(zza(this.zzj));
          localCamera.addCallbackBuffer(zza(this.zzj));
          localCamera.addCallbackBuffer(zza(this.zzj));
          return localCamera;
        }
        throw new IOException("Could not find suitable preview frames per second range.");
      }
      throw new IOException("Could not find suitable preview size.");
    }
    throw new IOException("Could not find requested camera.");
  }
  
  public int getCameraFacing()
  {
    return this.facing;
  }
  
  public Size getPreviewSize()
  {
    return this.zzj;
  }
  
  public void release()
  {
    synchronized (this.zzh)
    {
      stop();
      this.zzs.release();
      return;
    }
  }
  
  @RequiresPermission("android.permission.CAMERA")
  public CameraSource start()
    throws IOException
  {
    synchronized (this.zzh)
    {
      if (this.zzi != null) {
        return this;
      }
      this.zzi = zzb();
      Object localObject2 = new android/graphics/SurfaceTexture;
      ((SurfaceTexture)localObject2).<init>(100);
      this.zzp = ((SurfaceTexture)localObject2);
      this.zzi.setPreviewTexture((SurfaceTexture)localObject2);
      this.zzq = true;
      this.zzi.startPreview();
      localObject2 = new java/lang/Thread;
      ((Thread)localObject2).<init>(this.zzs);
      this.zzr = ((Thread)localObject2);
      ((Thread)localObject2).setName("gms.vision.CameraSource");
      this.zzs.setActive(true);
      this.zzr.start();
      return this;
    }
  }
  
  @RequiresPermission("android.permission.CAMERA")
  public CameraSource start(SurfaceHolder paramSurfaceHolder)
    throws IOException
  {
    synchronized (this.zzh)
    {
      if (this.zzi != null) {
        return this;
      }
      Camera localCamera = zzb();
      this.zzi = localCamera;
      localCamera.setPreviewDisplay(paramSurfaceHolder);
      this.zzi.startPreview();
      paramSurfaceHolder = new java/lang/Thread;
      paramSurfaceHolder.<init>(this.zzs);
      this.zzr = paramSurfaceHolder;
      this.zzs.setActive(true);
      this.zzr.start();
      this.zzq = false;
      return this;
    }
  }
  
  public void stop()
  {
    synchronized (this.zzh)
    {
      this.zzs.setActive(false);
      Thread localThread = this.zzr;
      if (localThread != null)
      {
        try
        {
          localThread.join();
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.d("CameraSource", "Frame processing thread interrupted on release.");
        }
        this.zzr = null;
      }
      Camera localCamera = this.zzi;
      if (localCamera != null)
      {
        localCamera.stopPreview();
        this.zzi.setPreviewCallbackWithBuffer(null);
        try
        {
          if (this.zzq) {
            this.zzi.setPreviewTexture(null);
          } else {
            this.zzi.setPreviewDisplay(null);
          }
        }
        catch (Exception localException)
        {
          String str = String.valueOf(localException);
          int i = str.length();
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>(i + 32);
          localStringBuilder.append("Failed to clear camera preview: ");
          localStringBuilder.append(str);
          Log.e("CameraSource", localStringBuilder.toString());
        }
        this.zzi.release();
        this.zzi = null;
      }
      this.zzt.clear();
      return;
    }
  }
  
  public void takePicture(ShutterCallback paramShutterCallback, PictureCallback paramPictureCallback)
  {
    synchronized (this.zzh)
    {
      if (this.zzi != null)
      {
        zzd localzzd = new com/google/android/gms/vision/CameraSource$zzd;
        localzzd.<init>(null);
        zzd.zza(localzzd, paramShutterCallback);
        paramShutterCallback = new com/google/android/gms/vision/CameraSource$zzc;
        paramShutterCallback.<init>(this, null);
        zzc.zza(paramShutterCallback, paramPictureCallback);
        this.zzi.takePicture(localzzd, null, null, paramShutterCallback);
      }
      return;
    }
  }
  
  public static class Builder
  {
    private final Detector<?> zzx;
    private CameraSource zzy;
    
    public Builder(Context paramContext, Detector<?> paramDetector)
    {
      CameraSource localCameraSource = new CameraSource(null);
      this.zzy = localCameraSource;
      if (paramContext != null)
      {
        if (paramDetector != null)
        {
          this.zzx = paramDetector;
          CameraSource.zza(localCameraSource, paramContext);
          return;
        }
        throw new IllegalArgumentException("No detector supplied.");
      }
      throw new IllegalArgumentException("No context supplied.");
    }
    
    public CameraSource build()
    {
      CameraSource localCameraSource = this.zzy;
      localCameraSource.getClass();
      CameraSource.zza(localCameraSource, new CameraSource.zza(localCameraSource, this.zzx));
      return this.zzy;
    }
    
    public Builder setAutoFocusEnabled(boolean paramBoolean)
    {
      CameraSource.zza(this.zzy, paramBoolean);
      return this;
    }
    
    public Builder setFacing(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1))
      {
        StringBuilder localStringBuilder = new StringBuilder(27);
        localStringBuilder.append("Invalid camera: ");
        localStringBuilder.append(paramInt);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      CameraSource.zzc(this.zzy, paramInt);
      return this;
    }
    
    public Builder setFocusMode(String paramString)
    {
      String str = paramString;
      if (!paramString.equals("continuous-video"))
      {
        str = paramString;
        if (!paramString.equals("continuous-picture"))
        {
          Log.w("CameraSource", String.format("FocusMode %s is not supported for now.", new Object[] { paramString }));
          str = null;
        }
      }
      CameraSource.zza(this.zzy, str);
      return this;
    }
    
    public Builder setRequestedFps(float paramFloat)
    {
      if (paramFloat > 0.0F)
      {
        CameraSource.zza(this.zzy, paramFloat);
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder(28);
      localStringBuilder.append("Invalid fps: ");
      localStringBuilder.append(paramFloat);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public Builder setRequestedPreviewSize(int paramInt1, int paramInt2)
    {
      if ((paramInt1 > 0) && (paramInt1 <= 1000000) && (paramInt2 > 0) && (paramInt2 <= 1000000))
      {
        CameraSource.zza(this.zzy, paramInt1);
        CameraSource.zzb(this.zzy, paramInt2);
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder(45);
      localStringBuilder.append("Invalid preview size: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("x");
      localStringBuilder.append(paramInt2);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public static abstract interface PictureCallback
  {
    public abstract void onPictureTaken(byte[] paramArrayOfByte);
  }
  
  public static abstract interface ShutterCallback
  {
    public abstract void onShutter();
  }
  
  final class zza
    implements Runnable
  {
    private final Object lock = new Object();
    private boolean zzaa = true;
    private long zzab;
    private int zzac = 0;
    private ByteBuffer zzad;
    private Detector<?> zzx;
    private long zzz = SystemClock.elapsedRealtime();
    
    zza()
    {
      Detector localDetector;
      this.zzx = localDetector;
    }
    
    @SuppressLint({"Assert"})
    final void release()
    {
      this.zzx.release();
      this.zzx = null;
    }
    
    /* Error */
    @SuppressLint({"InlinedApi"})
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 42	com/google/android/gms/vision/CameraSource$zza:lock	Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_1
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 44	com/google/android/gms/vision/CameraSource$zza:zzaa	Z
      //   11: istore_2
      //   12: iload_2
      //   13: ifeq +35 -> 48
      //   16: aload_0
      //   17: getfield 68	com/google/android/gms/vision/CameraSource$zza:zzad	Ljava/nio/ByteBuffer;
      //   20: astore_3
      //   21: aload_3
      //   22: ifnonnull +26 -> 48
      //   25: aload_0
      //   26: getfield 42	com/google/android/gms/vision/CameraSource$zza:lock	Ljava/lang/Object;
      //   29: invokevirtual 71	java/lang/Object:wait	()V
      //   32: goto -25 -> 7
      //   35: astore_3
      //   36: ldc 73
      //   38: ldc 75
      //   40: aload_3
      //   41: invokestatic 81	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   44: pop
      //   45: aload_1
      //   46: monitorexit
      //   47: return
      //   48: iload_2
      //   49: ifne +6 -> 55
      //   52: aload_1
      //   53: monitorexit
      //   54: return
      //   55: new 83	com/google/android/gms/vision/Frame$Builder
      //   58: astore_3
      //   59: aload_3
      //   60: invokespecial 84	com/google/android/gms/vision/Frame$Builder:<init>	()V
      //   63: aload_3
      //   64: aload_0
      //   65: getfield 68	com/google/android/gms/vision/CameraSource$zza:zzad	Ljava/nio/ByteBuffer;
      //   68: aload_0
      //   69: getfield 29	com/google/android/gms/vision/CameraSource$zza:zzae	Lcom/google/android/gms/vision/CameraSource;
      //   72: invokestatic 88	com/google/android/gms/vision/CameraSource:zzf	(Lcom/google/android/gms/vision/CameraSource;)Lcom/google/android/gms/common/images/Size;
      //   75: invokevirtual 94	com/google/android/gms/common/images/Size:getWidth	()I
      //   78: aload_0
      //   79: getfield 29	com/google/android/gms/vision/CameraSource$zza:zzae	Lcom/google/android/gms/vision/CameraSource;
      //   82: invokestatic 88	com/google/android/gms/vision/CameraSource:zzf	(Lcom/google/android/gms/vision/CameraSource;)Lcom/google/android/gms/common/images/Size;
      //   85: invokevirtual 97	com/google/android/gms/common/images/Size:getHeight	()I
      //   88: bipush 17
      //   90: invokevirtual 101	com/google/android/gms/vision/Frame$Builder:setImageData	(Ljava/nio/ByteBuffer;III)Lcom/google/android/gms/vision/Frame$Builder;
      //   93: aload_0
      //   94: getfield 46	com/google/android/gms/vision/CameraSource$zza:zzac	I
      //   97: invokevirtual 105	com/google/android/gms/vision/Frame$Builder:setId	(I)Lcom/google/android/gms/vision/Frame$Builder;
      //   100: aload_0
      //   101: getfield 107	com/google/android/gms/vision/CameraSource$zza:zzab	J
      //   104: invokevirtual 111	com/google/android/gms/vision/Frame$Builder:setTimestampMillis	(J)Lcom/google/android/gms/vision/Frame$Builder;
      //   107: aload_0
      //   108: getfield 29	com/google/android/gms/vision/CameraSource$zza:zzae	Lcom/google/android/gms/vision/CameraSource;
      //   111: invokestatic 115	com/google/android/gms/vision/CameraSource:zze	(Lcom/google/android/gms/vision/CameraSource;)I
      //   114: invokevirtual 118	com/google/android/gms/vision/Frame$Builder:setRotation	(I)Lcom/google/android/gms/vision/Frame$Builder;
      //   117: invokevirtual 122	com/google/android/gms/vision/Frame$Builder:build	()Lcom/google/android/gms/vision/Frame;
      //   120: astore 4
      //   122: aload_0
      //   123: getfield 68	com/google/android/gms/vision/CameraSource$zza:zzad	Ljava/nio/ByteBuffer;
      //   126: astore_3
      //   127: aload_0
      //   128: aconst_null
      //   129: putfield 68	com/google/android/gms/vision/CameraSource$zza:zzad	Ljava/nio/ByteBuffer;
      //   132: aload_1
      //   133: monitorexit
      //   134: aload_0
      //   135: getfield 48	com/google/android/gms/vision/CameraSource$zza:zzx	Lcom/google/android/gms/vision/Detector;
      //   138: aload 4
      //   140: invokevirtual 126	com/google/android/gms/vision/Detector:receiveFrame	(Lcom/google/android/gms/vision/Frame;)V
      //   143: aload_0
      //   144: getfield 29	com/google/android/gms/vision/CameraSource$zza:zzae	Lcom/google/android/gms/vision/CameraSource;
      //   147: invokestatic 130	com/google/android/gms/vision/CameraSource:zzb	(Lcom/google/android/gms/vision/CameraSource;)Landroid/hardware/Camera;
      //   150: aload_3
      //   151: invokevirtual 136	java/nio/ByteBuffer:array	()[B
      //   154: invokevirtual 142	android/hardware/Camera:addCallbackBuffer	([B)V
      //   157: goto -157 -> 0
      //   160: astore_1
      //   161: goto +30 -> 191
      //   164: astore_1
      //   165: ldc 73
      //   167: ldc -112
      //   169: aload_1
      //   170: invokestatic 147	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   173: pop
      //   174: aload_0
      //   175: getfield 29	com/google/android/gms/vision/CameraSource$zza:zzae	Lcom/google/android/gms/vision/CameraSource;
      //   178: invokestatic 130	com/google/android/gms/vision/CameraSource:zzb	(Lcom/google/android/gms/vision/CameraSource;)Landroid/hardware/Camera;
      //   181: aload_3
      //   182: invokevirtual 136	java/nio/ByteBuffer:array	()[B
      //   185: invokevirtual 142	android/hardware/Camera:addCallbackBuffer	([B)V
      //   188: goto -188 -> 0
      //   191: aload_0
      //   192: getfield 29	com/google/android/gms/vision/CameraSource$zza:zzae	Lcom/google/android/gms/vision/CameraSource;
      //   195: invokestatic 130	com/google/android/gms/vision/CameraSource:zzb	(Lcom/google/android/gms/vision/CameraSource;)Landroid/hardware/Camera;
      //   198: aload_3
      //   199: invokevirtual 136	java/nio/ByteBuffer:array	()[B
      //   202: invokevirtual 142	android/hardware/Camera:addCallbackBuffer	([B)V
      //   205: aload_1
      //   206: athrow
      //   207: astore_3
      //   208: aload_1
      //   209: monitorexit
      //   210: aload_3
      //   211: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	212	0	this	zza
      //   4	129	1	localObject1	Object
      //   160	1	1	localObject2	Object
      //   164	45	1	localException	Exception
      //   11	38	2	bool	boolean
      //   20	2	3	localByteBuffer	ByteBuffer
      //   35	6	3	localInterruptedException	InterruptedException
      //   58	141	3	localObject3	Object
      //   207	4	3	localObject4	Object
      //   120	19	4	localFrame	Frame
      // Exception table:
      //   from	to	target	type
      //   25	32	35	java/lang/InterruptedException
      //   134	143	160	finally
      //   165	174	160	finally
      //   134	143	164	java/lang/Exception
      //   7	12	207	finally
      //   16	21	207	finally
      //   25	32	207	finally
      //   36	47	207	finally
      //   52	54	207	finally
      //   55	134	207	finally
      //   208	210	207	finally
    }
    
    final void setActive(boolean paramBoolean)
    {
      synchronized (this.lock)
      {
        this.zzaa = paramBoolean;
        this.lock.notifyAll();
        return;
      }
    }
    
    final void zza(byte[] paramArrayOfByte, Camera paramCamera)
    {
      synchronized (this.lock)
      {
        ByteBuffer localByteBuffer = this.zzad;
        if (localByteBuffer != null)
        {
          paramCamera.addCallbackBuffer(localByteBuffer.array());
          this.zzad = null;
        }
        if (!CameraSource.zzd(CameraSource.this).containsKey(paramArrayOfByte))
        {
          Log.d("CameraSource", "Skipping frame. Could not find ByteBuffer associated with the image data from the camera.");
          return;
        }
        this.zzab = (SystemClock.elapsedRealtime() - this.zzz);
        this.zzac += 1;
        this.zzad = ((ByteBuffer)CameraSource.zzd(CameraSource.this).get(paramArrayOfByte));
        this.lock.notifyAll();
        return;
      }
    }
  }
  
  final class zzb
    implements Camera.PreviewCallback
  {
    private zzb() {}
    
    public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      CameraSource.zzc(CameraSource.this).zza(paramArrayOfByte, paramCamera);
    }
  }
  
  final class zzc
    implements Camera.PictureCallback
  {
    private CameraSource.PictureCallback zzaf;
    
    private zzc() {}
    
    public final void onPictureTaken(byte[] arg1, Camera paramCamera)
    {
      paramCamera = this.zzaf;
      if (paramCamera != null) {
        paramCamera.onPictureTaken(???);
      }
      synchronized (CameraSource.zza(CameraSource.this))
      {
        if (CameraSource.zzb(CameraSource.this) != null) {
          CameraSource.zzb(CameraSource.this).startPreview();
        }
        return;
      }
    }
  }
  
  static final class zzd
    implements Camera.ShutterCallback
  {
    private CameraSource.ShutterCallback zzag;
    
    public final void onShutter()
    {
      CameraSource.ShutterCallback localShutterCallback = this.zzag;
      if (localShutterCallback != null) {
        localShutterCallback.onShutter();
      }
    }
  }
  
  @VisibleForTesting
  static final class zze
  {
    private Size zzaj;
    private Size zzak;
    
    public zze(Camera.Size paramSize1, @Nullable Camera.Size paramSize2)
    {
      this.zzaj = new Size(paramSize1.width, paramSize1.height);
      if (paramSize2 != null) {
        this.zzak = new Size(paramSize2.width, paramSize2.height);
      }
    }
    
    public final Size zzc()
    {
      return this.zzaj;
    }
    
    @Nullable
    public final Size zzd()
    {
      return this.zzak;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\CameraSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */