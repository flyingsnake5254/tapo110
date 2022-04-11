package uk.co.senab.photoview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.core.view.MotionEventCompat;
import java.lang.ref.WeakReference;
import uk.co.senab.photoview.e.e;
import uk.co.senab.photoview.e.f;

public class d
  implements c, View.OnTouchListener, e, ViewTreeObserver.OnGlobalLayoutListener
{
  private static final boolean c = Log.isLoggable("PhotoViewAttacher", 3);
  static final Interpolator d = new AccelerateDecelerateInterpolator();
  static int f = 1;
  private uk.co.senab.photoview.e.d H3;
  private final Matrix I3 = new Matrix();
  private final Matrix J3 = new Matrix();
  private final Matrix K3 = new Matrix();
  private final RectF L3 = new RectF();
  private final float[] M3 = new float[9];
  private e N3;
  private f O3;
  private i P3;
  private View.OnLongClickListener Q3;
  private g R3;
  private h S3;
  private int T3;
  private int U3;
  private int V3;
  private int W3;
  private d X3;
  private int Y3 = 2;
  private float Z3;
  private boolean a4;
  private ImageView.ScaleType b4 = ImageView.ScaleType.FIT_CENTER;
  private boolean p0 = true;
  private boolean p1 = false;
  private WeakReference<ImageView> p2;
  private GestureDetector p3;
  int q = 200;
  private float x = 1.0F;
  private float y = 1.75F;
  private float z = 3.0F;
  
  public d(ImageView paramImageView)
  {
    this(paramImageView, true);
  }
  
  public d(ImageView paramImageView, boolean paramBoolean)
  {
    this.p2 = new WeakReference(paramImageView);
    paramImageView.setDrawingCacheEnabled(true);
    paramImageView.setOnTouchListener(this);
    ViewTreeObserver localViewTreeObserver = paramImageView.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    J(paramImageView);
    if (paramImageView.isInEditMode()) {
      return;
    }
    this.H3 = f.a(paramImageView.getContext(), this);
    paramImageView = new GestureDetector(paramImageView.getContext(), new a());
    this.p3 = paramImageView;
    paramImageView.setOnDoubleTapListener(new b(this));
    this.Z3 = 0.0F;
    b0(paramBoolean);
  }
  
  private float C(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.M3);
    return this.M3[paramInt];
  }
  
  private static boolean E(ImageView paramImageView)
  {
    boolean bool;
    if ((paramImageView != null) && (paramImageView.getDrawable() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean F(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    if (b.a[paramScaleType.ordinal()] != 1) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramScaleType.name());
    localStringBuilder.append(" is not supported in PhotoView");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void G()
  {
    this.K3.reset();
    U(this.Z3);
    I(r());
    l();
  }
  
  private void I(Matrix paramMatrix)
  {
    ImageView localImageView = s();
    if (localImageView != null)
    {
      k();
      localImageView.setImageMatrix(paramMatrix);
      if (this.N3 != null)
      {
        paramMatrix = q(paramMatrix);
        if (paramMatrix != null) {
          this.N3.a(paramMatrix);
        }
      }
    }
  }
  
  private static void J(ImageView paramImageView)
  {
    if ((paramImageView != null) && (!(paramImageView instanceof c)) && (!ImageView.ScaleType.MATRIX.equals(paramImageView.getScaleType()))) {
      paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  private void d0(Drawable paramDrawable)
  {
    Object localObject = s();
    if ((localObject != null) && (paramDrawable != null))
    {
      float f1 = u((ImageView)localObject);
      float f2 = t((ImageView)localObject);
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      this.I3.reset();
      float f3 = i;
      float f4 = f1 / f3;
      float f5 = j;
      float f6 = f2 / f5;
      paramDrawable = this.b4;
      if (paramDrawable == ImageView.ScaleType.CENTER)
      {
        this.I3.postTranslate((f1 - f3) / 2.0F, (f2 - f5) / 2.0F);
      }
      else if (paramDrawable == ImageView.ScaleType.CENTER_CROP)
      {
        f4 = Math.max(f4, f6);
        this.I3.postScale(f4, f4);
        this.I3.postTranslate((f1 - f3 * f4) / 2.0F, (f2 - f5 * f4) / 2.0F);
      }
      else if (paramDrawable == ImageView.ScaleType.CENTER_INSIDE)
      {
        f4 = Math.min(1.0F, Math.min(f4, f6));
        this.I3.postScale(f4, f4);
        this.I3.postTranslate((f1 - f3 * f4) / 2.0F, (f2 - f5 * f4) / 2.0F);
      }
      else
      {
        paramDrawable = new RectF(0.0F, 0.0F, f3, f5);
        localObject = new RectF(0.0F, 0.0F, f1, f2);
        if ((int)this.Z3 % 180 != 0) {
          paramDrawable = new RectF(0.0F, 0.0F, f5, f3);
        }
        j = b.a[this.b4.ordinal()];
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j == 5) {
                this.I3.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.FILL);
              }
            }
            else {
              this.I3.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.CENTER);
            }
          }
          else {
            this.I3.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.END);
          }
        }
        else {
          this.I3.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.START);
        }
      }
      G();
    }
  }
  
  private void i()
  {
    d locald = this.X3;
    if (locald != null)
    {
      locald.a();
      this.X3 = null;
    }
  }
  
  private void j()
  {
    if (l()) {
      I(r());
    }
  }
  
  private void k()
  {
    ImageView localImageView = s();
    if ((localImageView != null) && (!(localImageView instanceof c)) && (!ImageView.ScaleType.MATRIX.equals(localImageView.getScaleType()))) {
      throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
    }
  }
  
  private boolean l()
  {
    ImageView localImageView = s();
    if (localImageView == null) {
      return false;
    }
    RectF localRectF = q(r());
    if (localRectF == null) {
      return false;
    }
    float f1 = localRectF.height();
    float f2 = localRectF.width();
    float f3 = t(localImageView);
    float f4 = 0.0F;
    int i;
    if (f1 <= f3)
    {
      i = b.a[this.b4.ordinal()];
      if (i != 2) {
        if (i != 3)
        {
          f3 = (f3 - f1) / 2.0F;
          f1 = localRectF.top;
        }
        else
        {
          f3 -= f1;
          f1 = localRectF.top;
        }
      }
    }
    label135:
    do
    {
      f3 -= f1;
      break;
      f1 = localRectF.top;
      break label135;
      f1 = localRectF.top;
      if (f1 > 0.0F)
      {
        f3 = -f1;
        break;
      }
      f1 = localRectF.bottom;
    } while (f1 < f3);
    f3 = 0.0F;
    f1 = u(localImageView);
    if (f2 <= f1)
    {
      i = b.a[this.b4.ordinal()];
      if (i != 2)
      {
        if (i != 3)
        {
          f1 = (f1 - f2) / 2.0F;
          f4 = localRectF.left;
        }
        else
        {
          f1 -= f2;
          f4 = localRectF.left;
        }
        f1 -= f4;
      }
      else
      {
        f1 = -localRectF.left;
      }
      this.Y3 = 2;
    }
    else
    {
      f2 = localRectF.left;
      if (f2 > 0.0F)
      {
        this.Y3 = 0;
        f1 = -f2;
      }
      else
      {
        f2 = localRectF.right;
        if (f2 < f1)
        {
          f1 -= f2;
          this.Y3 = 1;
        }
        else
        {
          this.Y3 = -1;
          f1 = f4;
        }
      }
    }
    this.K3.postTranslate(f1, f3);
    return true;
  }
  
  private static void m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2)
    {
      if (paramFloat2 < paramFloat3) {
        return;
      }
      throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
    }
    throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
  }
  
  private RectF q(Matrix paramMatrix)
  {
    Object localObject = s();
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        this.L3.set(0.0F, 0.0F, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        paramMatrix.mapRect(this.L3);
        return this.L3;
      }
    }
    return null;
  }
  
  private int t(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return 0;
    }
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }
  
  private int u(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return 0;
    }
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }
  
  public float A()
  {
    return (float)Math.sqrt((float)Math.pow(C(this.K3, 0), 2.0D) + (float)Math.pow(C(this.K3, 3), 2.0D));
  }
  
  public ImageView.ScaleType B()
  {
    return this.b4;
  }
  
  public Bitmap D()
  {
    Object localObject = s();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ImageView)localObject).getDrawingCache();
    }
    return (Bitmap)localObject;
  }
  
  public void H(boolean paramBoolean)
  {
    this.p0 = paramBoolean;
  }
  
  public void K(float paramFloat)
  {
    m(this.x, this.y, paramFloat);
    this.z = paramFloat;
  }
  
  public void L(float paramFloat)
  {
    m(this.x, paramFloat, this.z);
    this.y = paramFloat;
  }
  
  public void M(float paramFloat)
  {
    m(paramFloat, this.y, this.z);
    this.x = paramFloat;
  }
  
  public void N(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    if (paramOnDoubleTapListener != null) {
      this.p3.setOnDoubleTapListener(paramOnDoubleTapListener);
    } else {
      this.p3.setOnDoubleTapListener(new b(this));
    }
  }
  
  public void O(View.OnLongClickListener paramOnLongClickListener)
  {
    this.Q3 = paramOnLongClickListener;
  }
  
  public void P(e parame)
  {
    this.N3 = parame;
  }
  
  public void Q(f paramf)
  {
    this.O3 = paramf;
  }
  
  public void R(g paramg)
  {
    this.R3 = paramg;
  }
  
  public void S(h paramh)
  {
    this.S3 = paramh;
  }
  
  public void T(i parami)
  {
    this.P3 = parami;
  }
  
  public void U(float paramFloat)
  {
    this.K3.postRotate(paramFloat % 360.0F);
    j();
  }
  
  public void V(float paramFloat)
  {
    this.K3.setRotate(paramFloat % 360.0F);
    j();
  }
  
  public void W(float paramFloat)
  {
    Y(paramFloat, false);
  }
  
  public void X(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    ImageView localImageView = s();
    if (localImageView != null) {
      if ((paramFloat1 >= this.x) && (paramFloat1 <= this.z))
      {
        if (paramBoolean)
        {
          localImageView.post(new c(A(), paramFloat1, paramFloat2, paramFloat3));
        }
        else
        {
          this.K3.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
          j();
        }
      }
      else {
        uk.co.senab.photoview.f.a.a().b("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
      }
    }
  }
  
  public void Y(float paramFloat, boolean paramBoolean)
  {
    ImageView localImageView = s();
    if (localImageView != null) {
      X(paramFloat, localImageView.getRight() / 2, localImageView.getBottom() / 2, paramBoolean);
    }
  }
  
  public void Z(ImageView.ScaleType paramScaleType)
  {
    if ((F(paramScaleType)) && (paramScaleType != this.b4))
    {
      this.b4 = paramScaleType;
      c0();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.H3.c()) {
      return;
    }
    if (c) {
      uk.co.senab.photoview.f.a.a().a("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
    }
    Object localObject = s();
    this.K3.postTranslate(paramFloat1, paramFloat2);
    j();
    localObject = ((ImageView)localObject).getParent();
    if ((this.p0) && (!this.H3.c()) && (!this.p1))
    {
      int i = this.Y3;
      if (((i == 2) || ((i == 0) && (paramFloat1 >= 1.0F)) || ((i == 1) && (paramFloat1 <= -1.0F))) && (localObject != null)) {
        ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
      }
    }
    else if (localObject != null)
    {
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public void a0(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 200;
    }
    this.q = i;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (c) {
      uk.co.senab.photoview.f.a.a().a("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    }
    if (((A() < this.z) || (paramFloat1 < 1.0F)) && ((A() > this.x) || (paramFloat1 > 1.0F)))
    {
      g localg = this.R3;
      if (localg != null) {
        localg.a(paramFloat1, paramFloat2, paramFloat3);
      }
      this.K3.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      j();
    }
  }
  
  public void b0(boolean paramBoolean)
  {
    this.a4 = paramBoolean;
    c0();
  }
  
  public void c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (c)
    {
      localObject1 = uk.co.senab.photoview.f.a.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onFling. sX: ");
      ((StringBuilder)localObject2).append(paramFloat1);
      ((StringBuilder)localObject2).append(" sY: ");
      ((StringBuilder)localObject2).append(paramFloat2);
      ((StringBuilder)localObject2).append(" Vx: ");
      ((StringBuilder)localObject2).append(paramFloat3);
      ((StringBuilder)localObject2).append(" Vy: ");
      ((StringBuilder)localObject2).append(paramFloat4);
      ((uk.co.senab.photoview.f.b)localObject1).a("PhotoViewAttacher", ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = s();
    Object localObject2 = new d(((ImageView)localObject1).getContext());
    this.X3 = ((d)localObject2);
    ((d)localObject2).b(u((ImageView)localObject1), t((ImageView)localObject1), (int)paramFloat3, (int)paramFloat4);
    ((ImageView)localObject1).post(this.X3);
  }
  
  public void c0()
  {
    ImageView localImageView = s();
    if (localImageView != null) {
      if (this.a4)
      {
        J(localImageView);
        d0(localImageView.getDrawable());
      }
      else
      {
        G();
      }
    }
  }
  
  public void n()
  {
    Object localObject = this.p2;
    if (localObject == null) {
      return;
    }
    localObject = (ImageView)((WeakReference)localObject).get();
    if (localObject != null)
    {
      ViewTreeObserver localViewTreeObserver = ((ImageView)localObject).getViewTreeObserver();
      if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
      ((ImageView)localObject).setOnTouchListener(null);
      i();
    }
    localObject = this.p3;
    if (localObject != null) {
      ((GestureDetector)localObject).setOnDoubleTapListener(null);
    }
    this.N3 = null;
    this.O3 = null;
    this.P3 = null;
    this.p2 = null;
  }
  
  public Matrix o()
  {
    return new Matrix(r());
  }
  
  public void onGlobalLayout()
  {
    ImageView localImageView = s();
    if (localImageView != null) {
      if (this.a4)
      {
        int i = localImageView.getTop();
        int j = localImageView.getRight();
        int k = localImageView.getBottom();
        int m = localImageView.getLeft();
        if ((i != this.T3) || (k != this.V3) || (m != this.W3) || (j != this.U3))
        {
          d0(localImageView.getDrawable());
          this.T3 = i;
          this.U3 = j;
          this.V3 = k;
          this.W3 = m;
        }
      }
      else
      {
        d0(localImageView.getDrawable());
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.a4;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = bool2;
    if (bool1)
    {
      bool4 = bool2;
      if (E((ImageView)paramView))
      {
        Object localObject = paramView.getParent();
        int i = paramMotionEvent.getAction();
        if (i != 0)
        {
          if (((i == 1) || (i == 3)) && (A() < this.x))
          {
            localObject = p();
            if (localObject != null)
            {
              paramView.post(new c(A(), this.x, ((RectF)localObject).centerX(), ((RectF)localObject).centerY()));
              bool4 = true;
              break label162;
            }
          }
        }
        else
        {
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          } else {
            uk.co.senab.photoview.f.a.a().b("PhotoViewAttacher", "onTouch getParent() returned null");
          }
          i();
        }
        bool4 = false;
        label162:
        paramView = this.H3;
        if (paramView != null)
        {
          bool4 = paramView.c();
          bool1 = this.H3.a();
          bool2 = this.H3.onTouchEvent(paramMotionEvent);
          if ((!bool4) && (!this.H3.c())) {
            i = 1;
          } else {
            i = 0;
          }
          int j;
          if ((!bool1) && (!this.H3.a())) {
            j = 1;
          } else {
            j = 0;
          }
          bool4 = bool3;
          if (i != 0)
          {
            bool4 = bool3;
            if (j != 0) {
              bool4 = true;
            }
          }
          this.p1 = bool4;
          bool3 = bool2;
        }
        else
        {
          bool3 = bool4;
        }
        paramView = this.p3;
        bool4 = bool3;
        if (paramView != null)
        {
          bool4 = bool3;
          if (paramView.onTouchEvent(paramMotionEvent)) {
            bool4 = true;
          }
        }
      }
    }
    return bool4;
  }
  
  public RectF p()
  {
    l();
    return q(r());
  }
  
  public Matrix r()
  {
    this.J3.set(this.I3);
    this.J3.postConcat(this.K3);
    return this.J3;
  }
  
  public ImageView s()
  {
    Object localObject = this.p2;
    if (localObject != null) {
      localObject = (ImageView)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      n();
      uk.co.senab.photoview.f.a.a().b("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
    }
    return (ImageView)localObject;
  }
  
  public float v()
  {
    return this.z;
  }
  
  public float w()
  {
    return this.y;
  }
  
  public float x()
  {
    return this.x;
  }
  
  @Deprecated
  public f y()
  {
    return this.O3;
  }
  
  @Deprecated
  public i z()
  {
    return this.P3;
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    a() {}
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (d.e(d.this) != null)
      {
        if (d.this.A() > 1.0F) {
          return false;
        }
        if ((MotionEventCompat.getPointerCount(paramMotionEvent1) <= d.f) && (MotionEventCompat.getPointerCount(paramMotionEvent2) <= d.f)) {
          return d.e(d.this).onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
      }
      return false;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      if (d.d(d.this) != null) {
        d.d(d.this).onLongClick(d.this.s());
      }
    }
  }
  
  private class c
    implements Runnable
  {
    private final float c;
    private final float d;
    private final long f;
    private final float q;
    private final float x;
    
    public c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.c = paramFloat3;
      this.d = paramFloat4;
      this.f = System.currentTimeMillis();
      this.q = paramFloat1;
      this.x = paramFloat2;
    }
    
    private float a()
    {
      float f1 = Math.min(1.0F, (float)(System.currentTimeMillis() - this.f) * 1.0F / d.this.q);
      return d.d.getInterpolation(f1);
    }
    
    public void run()
    {
      ImageView localImageView = d.this.s();
      if (localImageView == null) {
        return;
      }
      float f1 = a();
      float f2 = this.q;
      f2 = (f2 + (this.x - f2) * f1) / d.this.A();
      d.this.b(f2, this.c, this.d);
      if (f1 < 1.0F) {
        a.d(localImageView, this);
      }
    }
  }
  
  private class d
    implements Runnable
  {
    private final uk.co.senab.photoview.g.d c;
    private int d;
    private int f;
    
    public d(Context paramContext)
    {
      this.c = uk.co.senab.photoview.g.d.f(paramContext);
    }
    
    public void a()
    {
      if (d.f()) {
        uk.co.senab.photoview.f.a.a().a("PhotoViewAttacher", "Cancel Fling");
      }
      this.c.c(true);
    }
    
    public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Object localObject = d.this.p();
      if (localObject == null) {
        return;
      }
      int i = Math.round(-((RectF)localObject).left);
      float f1 = paramInt1;
      int j;
      int k;
      if (f1 < ((RectF)localObject).width())
      {
        j = Math.round(((RectF)localObject).width() - f1);
        k = 0;
      }
      else
      {
        paramInt1 = i;
        j = paramInt1;
        k = paramInt1;
      }
      int m = Math.round(-((RectF)localObject).top);
      f1 = paramInt2;
      if (f1 < ((RectF)localObject).height())
      {
        paramInt2 = Math.round(((RectF)localObject).height() - f1);
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = m;
        paramInt2 = paramInt1;
      }
      this.d = i;
      this.f = m;
      if (d.f())
      {
        uk.co.senab.photoview.f.b localb = uk.co.senab.photoview.f.a.a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fling. StartX:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" StartY:");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(" MaxX:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" MaxY:");
        ((StringBuilder)localObject).append(paramInt2);
        localb.a("PhotoViewAttacher", ((StringBuilder)localObject).toString());
      }
      if ((i != j) || (m != paramInt2)) {
        this.c.b(i, m, paramInt3, paramInt4, k, j, paramInt1, paramInt2, 0, 0);
      }
    }
    
    public void run()
    {
      if (this.c.g()) {
        return;
      }
      ImageView localImageView = d.this.s();
      if ((localImageView != null) && (this.c.a()))
      {
        int i = this.c.d();
        int j = this.c.e();
        if (d.f())
        {
          uk.co.senab.photoview.f.b localb = uk.co.senab.photoview.f.a.a();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fling run(). CurrentX:");
          ((StringBuilder)localObject).append(this.d);
          ((StringBuilder)localObject).append(" CurrentY:");
          ((StringBuilder)localObject).append(this.f);
          ((StringBuilder)localObject).append(" NewX:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" NewY:");
          ((StringBuilder)localObject).append(j);
          localb.a("PhotoViewAttacher", ((StringBuilder)localObject).toString());
        }
        d.g(d.this).postTranslate(this.d - i, this.f - j);
        Object localObject = d.this;
        d.h((d)localObject, ((d)localObject).r());
        this.d = i;
        this.f = j;
        a.d(localImageView, this);
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(RectF paramRectF);
  }
  
  public static abstract interface f
  {
    public abstract void R();
    
    public abstract void a0(View paramView, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface g
  {
    public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public static abstract interface h
  {
    public abstract boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface i
  {
    public abstract void a(View paramView, float paramFloat1, float paramFloat2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\uk\co\senab\photoview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */