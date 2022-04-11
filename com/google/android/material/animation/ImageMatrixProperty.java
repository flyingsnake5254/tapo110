package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

public class ImageMatrixProperty
  extends Property<ImageView, Matrix>
{
  private final Matrix matrix = new Matrix();
  
  public ImageMatrixProperty()
  {
    super(Matrix.class, "imageMatrixProperty");
  }
  
  @NonNull
  public Matrix get(@NonNull ImageView paramImageView)
  {
    this.matrix.set(paramImageView.getImageMatrix());
    return this.matrix;
  }
  
  public void set(@NonNull ImageView paramImageView, @NonNull Matrix paramMatrix)
  {
    paramImageView.setImageMatrix(paramMatrix);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\animation\ImageMatrixProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */