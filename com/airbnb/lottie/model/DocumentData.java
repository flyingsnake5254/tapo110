package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class DocumentData
{
  public final String a;
  public final String b;
  public final float c;
  public final Justification d;
  public final int e;
  public final float f;
  public final float g;
  @ColorInt
  public final int h;
  @ColorInt
  public final int i;
  public final float j;
  public final boolean k;
  
  public DocumentData(String paramString1, String paramString2, float paramFloat1, Justification paramJustification, int paramInt1, float paramFloat2, float paramFloat3, @ColorInt int paramInt2, @ColorInt int paramInt3, float paramFloat4, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramFloat1;
    this.d = paramJustification;
    this.e = paramInt1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramInt2;
    this.i = paramInt3;
    this.j = paramFloat4;
    this.k = paramBoolean;
  }
  
  public int hashCode()
  {
    int m = (int)((this.a.hashCode() * 31 + this.b.hashCode()) * 31 + this.c);
    int n = this.d.ordinal();
    int i1 = this.e;
    long l = Float.floatToRawIntBits(this.f);
    return (((m * 31 + n) * 31 + i1) * 31 + (int)(l ^ l >>> 32)) * 31 + this.h;
  }
  
  public static enum Justification
  {
    static
    {
      Justification localJustification1 = new Justification("LEFT_ALIGN", 0);
      LEFT_ALIGN = localJustification1;
      Justification localJustification2 = new Justification("RIGHT_ALIGN", 1);
      RIGHT_ALIGN = localJustification2;
      Justification localJustification3 = new Justification("CENTER", 2);
      CENTER = localJustification3;
      $VALUES = new Justification[] { localJustification1, localJustification2, localJustification3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\DocumentData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */