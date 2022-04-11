package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

public final class PathSegment
{
  private final PointF mEnd;
  private final float mEndFraction;
  private final PointF mStart;
  private final float mStartFraction;
  
  public PathSegment(@NonNull PointF paramPointF1, float paramFloat1, @NonNull PointF paramPointF2, float paramFloat2)
  {
    this.mStart = ((PointF)Preconditions.checkNotNull(paramPointF1, "start == null"));
    this.mStartFraction = paramFloat1;
    this.mEnd = ((PointF)Preconditions.checkNotNull(paramPointF2, "end == null"));
    this.mEndFraction = paramFloat2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof PathSegment)) {
      return false;
    }
    paramObject = (PathSegment)paramObject;
    if ((Float.compare(this.mStartFraction, ((PathSegment)paramObject).mStartFraction) != 0) || (Float.compare(this.mEndFraction, ((PathSegment)paramObject).mEndFraction) != 0) || (!this.mStart.equals(((PathSegment)paramObject).mStart)) || (!this.mEnd.equals(((PathSegment)paramObject).mEnd))) {
      bool = false;
    }
    return bool;
  }
  
  @NonNull
  public PointF getEnd()
  {
    return this.mEnd;
  }
  
  public float getEndFraction()
  {
    return this.mEndFraction;
  }
  
  @NonNull
  public PointF getStart()
  {
    return this.mStart;
  }
  
  public float getStartFraction()
  {
    return this.mStartFraction;
  }
  
  public int hashCode()
  {
    int i = this.mStart.hashCode();
    float f = this.mStartFraction;
    int j = 0;
    int k;
    if (f != 0.0F) {
      k = Float.floatToIntBits(f);
    } else {
      k = 0;
    }
    int m = this.mEnd.hashCode();
    f = this.mEndFraction;
    if (f != 0.0F) {
      j = Float.floatToIntBits(f);
    }
    return ((i * 31 + k) * 31 + m) * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PathSegment{start=");
    localStringBuilder.append(this.mStart);
    localStringBuilder.append(", startFraction=");
    localStringBuilder.append(this.mStartFraction);
    localStringBuilder.append(", end=");
    localStringBuilder.append(this.mEnd);
    localStringBuilder.append(", endFraction=");
    localStringBuilder.append(this.mEndFraction);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\PathSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */