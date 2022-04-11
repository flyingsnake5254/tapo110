package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class PhotoView
  extends ImageView
  implements c
{
  private d c;
  private ImageView.ScaleType d;
  
  public PhotoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    a();
  }
  
  protected void a()
  {
    Object localObject = this.c;
    if ((localObject == null) || (((d)localObject).s() == null)) {
      this.c = new d(this);
    }
    localObject = this.d;
    if (localObject != null)
    {
      setScaleType((ImageView.ScaleType)localObject);
      this.d = null;
    }
  }
  
  public Matrix getDisplayMatrix()
  {
    return this.c.o();
  }
  
  public RectF getDisplayRect()
  {
    return this.c.p();
  }
  
  public c getIPhotoViewImplementation()
  {
    return this.c;
  }
  
  @Deprecated
  public float getMaxScale()
  {
    return getMaximumScale();
  }
  
  public float getMaximumScale()
  {
    return this.c.v();
  }
  
  public float getMediumScale()
  {
    return this.c.w();
  }
  
  @Deprecated
  public float getMidScale()
  {
    return getMediumScale();
  }
  
  @Deprecated
  public float getMinScale()
  {
    return getMinimumScale();
  }
  
  public float getMinimumScale()
  {
    return this.c.x();
  }
  
  @Deprecated
  public d.f getOnPhotoTapListener()
  {
    return this.c.y();
  }
  
  @Deprecated
  public d.i getOnViewTapListener()
  {
    return this.c.z();
  }
  
  public float getScale()
  {
    return this.c.A();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.c.B();
  }
  
  public Bitmap getVisibleRectangleBitmap()
  {
    return this.c.D();
  }
  
  protected void onAttachedToWindow()
  {
    a();
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    this.c.n();
    super.onDetachedFromWindow();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.c.H(paramBoolean);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.c;
    if (paramDrawable != null) {
      paramDrawable.c0();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    d locald = this.c;
    if (locald != null) {
      locald.c0();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = this.c;
    if (paramUri != null) {
      paramUri.c0();
    }
  }
  
  @Deprecated
  public void setMaxScale(float paramFloat)
  {
    setMaximumScale(paramFloat);
  }
  
  public void setMaximumScale(float paramFloat)
  {
    this.c.K(paramFloat);
  }
  
  public void setMediumScale(float paramFloat)
  {
    this.c.L(paramFloat);
  }
  
  @Deprecated
  public void setMidScale(float paramFloat)
  {
    setMediumScale(paramFloat);
  }
  
  @Deprecated
  public void setMinScale(float paramFloat)
  {
    setMinimumScale(paramFloat);
  }
  
  public void setMinimumScale(float paramFloat)
  {
    this.c.M(paramFloat);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.c.N(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.c.O(paramOnLongClickListener);
  }
  
  public void setOnMatrixChangeListener(d.e parame)
  {
    this.c.P(parame);
  }
  
  public void setOnPhotoTapListener(d.f paramf)
  {
    this.c.Q(paramf);
  }
  
  public void setOnScaleChangeListener(d.g paramg)
  {
    this.c.R(paramg);
  }
  
  public void setOnSingleFlingListener(d.h paramh)
  {
    this.c.S(paramh);
  }
  
  public void setOnViewTapListener(d.i parami)
  {
    this.c.T(parami);
  }
  
  public void setPhotoViewRotation(float paramFloat)
  {
    this.c.V(paramFloat);
  }
  
  public void setRotationBy(float paramFloat)
  {
    this.c.U(paramFloat);
  }
  
  public void setRotationTo(float paramFloat)
  {
    this.c.V(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.c.W(paramFloat);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    d locald = this.c;
    if (locald != null) {
      locald.Z(paramScaleType);
    } else {
      this.d = paramScaleType;
    }
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    this.c.a0(paramInt);
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.c.b0(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\uk\co\senab\photoview\PhotoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */