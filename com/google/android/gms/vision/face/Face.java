package com.google.android.gms.vision.face;

import android.graphics.PointF;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Arrays;
import java.util.List;

public class Face
{
  public static final float UNCOMPUTED_PROBABILITY = -1.0F;
  private float height;
  private int id;
  private float width;
  private PointF zzcg;
  private float zzch;
  private float zzci;
  private float zzcj;
  private List<Landmark> zzck;
  private final List<Contour> zzcl;
  private float zzcm;
  private float zzcn;
  private float zzco;
  private final float zzcp;
  
  public Face(int paramInt, PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, Landmark[] paramArrayOfLandmark, Contour[] paramArrayOfContour, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.id = paramInt;
    this.zzcg = paramPointF;
    this.width = paramFloat1;
    this.height = paramFloat2;
    this.zzch = paramFloat3;
    this.zzci = paramFloat4;
    this.zzcj = paramFloat5;
    this.zzck = Arrays.asList(paramArrayOfLandmark);
    this.zzcl = Arrays.asList(paramArrayOfContour);
    this.zzcm = zza(paramFloat6);
    this.zzcn = zza(paramFloat7);
    this.zzco = zza(paramFloat8);
    this.zzcp = zza(paramFloat9);
  }
  
  private static float zza(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {
      return paramFloat;
    }
    return -1.0F;
  }
  
  public List<Contour> getContours()
  {
    return this.zzcl;
  }
  
  @KeepForSdk
  @ShowFirstParty
  public float getEulerX()
  {
    return this.zzcj;
  }
  
  public float getEulerY()
  {
    return this.zzch;
  }
  
  public float getEulerZ()
  {
    return this.zzci;
  }
  
  public float getHeight()
  {
    return this.height;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public float getIsLeftEyeOpenProbability()
  {
    return this.zzcm;
  }
  
  public float getIsRightEyeOpenProbability()
  {
    return this.zzcn;
  }
  
  public float getIsSmilingProbability()
  {
    return this.zzco;
  }
  
  public List<Landmark> getLandmarks()
  {
    return this.zzck;
  }
  
  public PointF getPosition()
  {
    PointF localPointF = this.zzcg;
    return new PointF(localPointF.x - this.width / 2.0F, localPointF.y - this.height / 2.0F);
  }
  
  public float getWidth()
  {
    return this.width;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\Face.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */