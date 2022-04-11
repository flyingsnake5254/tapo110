package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class PathProperty<T>
  extends Property<T, Float>
{
  private float mCurrentFraction;
  private final float mPathLength;
  private final PathMeasure mPathMeasure;
  private final PointF mPointF = new PointF();
  private final float[] mPosition = new float[2];
  private final Property<T, PointF> mProperty;
  
  PathProperty(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    this.mProperty = paramProperty;
    paramProperty = new PathMeasure(paramPath, false);
    this.mPathMeasure = paramProperty;
    this.mPathLength = paramProperty.getLength();
  }
  
  public Float get(T paramT)
  {
    return Float.valueOf(this.mCurrentFraction);
  }
  
  public void set(T paramT, Float paramFloat)
  {
    this.mCurrentFraction = paramFloat.floatValue();
    this.mPathMeasure.getPosTan(this.mPathLength * paramFloat.floatValue(), this.mPosition, null);
    paramFloat = this.mPointF;
    float[] arrayOfFloat = this.mPosition;
    paramFloat.x = arrayOfFloat[0];
    paramFloat.y = arrayOfFloat[1];
    this.mProperty.set(paramT, paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\PathProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */