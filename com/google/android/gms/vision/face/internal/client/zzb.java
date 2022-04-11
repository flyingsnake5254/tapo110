package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.media.Image.Plane;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzbj;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.face.Contour;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import java.nio.ByteBuffer;

public final class zzb
  extends zzs<zzh>
{
  private final zzf zzdg;
  
  public zzb(Context paramContext, zzf paramzzf)
  {
    super(paramContext, "FaceNativeHandle", "face");
    zzbj.init(paramContext);
    this.zzdg = paramzzf;
    zzq();
  }
  
  private final Face zza(FaceParcel paramFaceParcel)
  {
    int i = paramFaceParcel.id;
    PointF localPointF = new PointF(paramFaceParcel.centerX, paramFaceParcel.centerY);
    float f1 = paramFaceParcel.width;
    float f2 = paramFaceParcel.height;
    float f3 = paramFaceParcel.zzdh;
    float f4 = paramFaceParcel.zzdi;
    float f5 = paramFaceParcel.zzdj;
    Object localObject1 = paramFaceParcel.zzdk;
    Object localObject2;
    int j;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = new Landmark[0];
    }
    else
    {
      localObject2 = new Landmark[localObject1.length];
      for (j = 0; j < localObject1.length; j++)
      {
        localObject3 = localObject1[j];
        localObject2[j] = new Landmark(new PointF(((LandmarkParcel)localObject3).x, ((LandmarkParcel)localObject3).y), ((LandmarkParcel)localObject3).type);
      }
      localObject1 = localObject2;
    }
    zza[] arrayOfzza = paramFaceParcel.zzdl;
    if (arrayOfzza == null)
    {
      localObject2 = new Contour[0];
    }
    else
    {
      j = 0;
      localObject2 = new Contour[arrayOfzza.length];
      while (j < arrayOfzza.length)
      {
        localObject3 = arrayOfzza[j];
        localObject2[j] = new Contour(((zza)localObject3).zzdf, ((zza)localObject3).type);
        j++;
      }
    }
    return new Face(i, localPointF, f1, f2, f3, f4, f5, (Landmark[])localObject1, (Contour[])localObject2, paramFaceParcel.zzcm, paramFaceParcel.zzcn, paramFaceParcel.zzco, paramFaceParcel.zzcp);
  }
  
  @RequiresApi(19)
  public final Face[] zza(Image.Plane[] paramArrayOfPlane, zzu paramzzu)
  {
    boolean bool = isOperational();
    int i = 0;
    if (!bool)
    {
      Log.e("FaceNativeHandle", "Native handle is not ready to be used.");
      return new Face[0];
    }
    if ((paramArrayOfPlane != null) && (paramArrayOfPlane.length != 3)) {
      throw new IllegalArgumentException("Only android.graphics.ImageFormat#YUV_420_888 is supported which should have 3 planes.");
    }
    try
    {
      paramArrayOfPlane = ((zzh)zzq()).zza(ObjectWrapper.wrap(paramArrayOfPlane[0].getBuffer()), ObjectWrapper.wrap(paramArrayOfPlane[1].getBuffer()), ObjectWrapper.wrap(paramArrayOfPlane[2].getBuffer()), paramArrayOfPlane[0].getPixelStride(), paramArrayOfPlane[1].getPixelStride(), paramArrayOfPlane[2].getPixelStride(), paramArrayOfPlane[0].getRowStride(), paramArrayOfPlane[1].getRowStride(), paramArrayOfPlane[2].getRowStride(), paramzzu);
      paramzzu = new Face[paramArrayOfPlane.length];
      while (i < paramArrayOfPlane.length)
      {
        paramzzu[i] = zza(paramArrayOfPlane[i]);
        i++;
      }
      return paramzzu;
    }
    catch (RemoteException paramArrayOfPlane)
    {
      Log.e("FaceNativeHandle", "Could not call native face detector", paramArrayOfPlane);
    }
    return new Face[0];
  }
  
  public final Face[] zzb(ByteBuffer paramByteBuffer, zzu paramzzu)
  {
    boolean bool = isOperational();
    int i = 0;
    if (!bool) {
      return new Face[0];
    }
    try
    {
      paramByteBuffer = ObjectWrapper.wrap(paramByteBuffer);
      paramzzu = ((zzh)zzq()).zzc(paramByteBuffer, paramzzu);
      paramByteBuffer = new Face[paramzzu.length];
      while (i < paramzzu.length)
      {
        paramByteBuffer[i] = zza(paramzzu[i]);
        i++;
      }
      return paramByteBuffer;
    }
    catch (RemoteException paramByteBuffer)
    {
      Log.e("FaceNativeHandle", "Could not call native face detector", paramByteBuffer);
    }
    return new Face[0];
  }
  
  public final boolean zzd(int paramInt)
  {
    if (!isOperational()) {
      return false;
    }
    try
    {
      boolean bool = ((zzh)zzq()).zzd(paramInt);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("FaceNativeHandle", "Could not call native face detector", localRemoteException);
    }
    return false;
  }
  
  protected final void zzo()
    throws RemoteException
  {
    ((zzh)zzq()).zzn();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\internal\client\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */