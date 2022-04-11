package com.tplink.iot.view.ipcamera.widget.topsnackbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener;

public final class TNotificationSnackbar
{
  private static final Handler a = new Handler(Looper.getMainLooper(), new c());
  private int b = 0;
  private ViewGroup c;
  private Context d;
  private SnackbarLayout e;
  private int f;
  private l g;
  private AccessibilityManager h;
  private final d.b i = new f();
  
  private TNotificationSnackbar(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = paramInt;
    this.c = paramViewGroup;
    paramViewGroup = paramViewGroup.getContext();
    this.d = paramViewGroup;
    paramViewGroup = LayoutInflater.from(paramViewGroup);
    if (paramInt == 1) {
      this.e = ((SnackbarLayout)paramViewGroup.inflate(2131559403, this.c, false));
    } else {
      this.e = ((SnackbarLayout)paramViewGroup.inflate(2131559449, this.c, false));
    }
    this.h = ((AccessibilityManager)this.d.getSystemService("accessibility"));
    if (paramInt == 0) {
      if (this.d.getResources().getConfiguration().orientation == 2)
      {
        this.e.setMinimumHeight(c.a(this.d));
        SnackbarLayout.a(this.e).setGravity(17);
      }
      else
      {
        this.e.setPadding(0, c.b(this.d), 0, 0);
        this.e.setMinimumHeight(c.a(this.d) / 2 + c.b(this.d));
      }
    }
  }
  
  private boolean F()
  {
    return this.h.isEnabled() ^ true;
  }
  
  private void j()
  {
    Animation localAnimation;
    if (this.b == 0) {
      localAnimation = o();
    } else {
      localAnimation = n();
    }
    localAnimation.setInterpolator(b.b);
    localAnimation.setDuration(250L);
    localAnimation.setAnimationListener(new a());
    this.e.startAnimation(localAnimation);
  }
  
  private void k(final int paramInt)
  {
    Animation localAnimation;
    if (this.b == 0) {
      localAnimation = q();
    } else {
      localAnimation = p();
    }
    localAnimation.setInterpolator(b.b);
    localAnimation.setDuration(250L);
    localAnimation.setAnimationListener(new b(paramInt));
    this.e.startAnimation(localAnimation);
  }
  
  private void l(int paramInt)
  {
    d.e().d(this.i, paramInt);
  }
  
  private static ViewGroup m(View paramView)
  {
    Object localObject1 = null;
    View localView = paramView;
    Object localObject2;
    do
    {
      if ((localView instanceof CoordinatorLayout)) {
        return (ViewGroup)localView;
      }
      localObject2 = localObject1;
      if ((localView instanceof FrameLayout))
      {
        if (localView.getId() == 16908290) {
          return (ViewGroup)localView;
        }
        localObject2 = (ViewGroup)localView;
      }
      paramView = localView;
      if (localView != null)
      {
        paramView = localView.getParent();
        if ((paramView instanceof View)) {
          paramView = (View)paramView;
        } else {
          paramView = null;
        }
      }
      localObject1 = localObject2;
      localView = paramView;
    } while (paramView != null);
    return (ViewGroup)localObject2;
  }
  
  private Animation n()
  {
    return AnimationUtils.loadAnimation(this.e.getContext(), 2130772002);
  }
  
  private Animation o()
  {
    return AnimationUtils.loadAnimation(this.e.getContext(), 2130772060);
  }
  
  private Animation p()
  {
    return AnimationUtils.loadAnimation(this.e.getContext(), 2130772003);
  }
  
  private Animation q()
  {
    return AnimationUtils.loadAnimation(this.e.getContext(), 2130772061);
  }
  
  public static ViewGroup r(Activity paramActivity)
  {
    return (ViewGroup)paramActivity.findViewById(16908290).getRootView();
  }
  
  public static TNotificationSnackbar u(@NonNull Activity paramActivity, @NonNull CharSequence paramCharSequence, int paramInt)
  {
    return v(r(paramActivity), paramCharSequence, paramInt);
  }
  
  @NonNull
  public static TNotificationSnackbar v(@NonNull View paramView, @NonNull CharSequence paramCharSequence, int paramInt)
  {
    paramView = new TNotificationSnackbar(m(paramView), 0);
    paramView.E(paramCharSequence);
    paramView.B(paramInt);
    return paramView;
  }
  
  private void w(int paramInt)
  {
    d.e().l(this.i);
    Object localObject = this.g;
    if (localObject != null) {
      ((l)localObject).a(this, paramInt);
    }
    localObject = this.e.getParent();
    if ((localObject instanceof ViewGroup)) {
      ((ViewGroup)localObject).removeView(this.e);
    }
  }
  
  private void x()
  {
    d.e().m(this.i);
    l locall = this.g;
    if (locall != null) {
      locall.b(this);
    }
  }
  
  @NonNull
  public TNotificationSnackbar A(@NonNull CharSequence paramCharSequence)
  {
    this.e.getContentView().setText(paramCharSequence);
    return this;
  }
  
  @NonNull
  public TNotificationSnackbar B(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  @NonNull
  public TNotificationSnackbar C(Bitmap paramBitmap)
  {
    ImageView localImageView = this.e.getImageView();
    if (paramBitmap != null)
    {
      localImageView.setVisibility(0);
      localImageView.setImageBitmap(paramBitmap);
    }
    else
    {
      localImageView.setVisibility(8);
    }
    return this;
  }
  
  public TNotificationSnackbar D(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.e.setOnSwipeListener(new e());
    }
    return this;
  }
  
  @NonNull
  public TNotificationSnackbar E(@NonNull CharSequence paramCharSequence)
  {
    this.e.getMessageView().setText(paramCharSequence);
    return this;
  }
  
  public void G()
  {
    d.e().p(this.f, this.i);
  }
  
  final void H()
  {
    if (this.e.getParent() == null)
    {
      Object localObject = this.e.getLayoutParams();
      if ((localObject instanceof CoordinatorLayout.LayoutParams))
      {
        k localk = new k();
        localk.setStartAlphaSwipeDistance(0.1F);
        localk.setEndAlphaSwipeDistance(0.6F);
        localk.setSwipeDirection(0);
        localk.setListener(new g());
        localObject = (CoordinatorLayout.LayoutParams)localObject;
        ((CoordinatorLayout.LayoutParams)localObject).setBehavior(localk);
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(0, -30, 0, 0);
      }
      this.c.addView(this.e);
    }
    if (ViewCompat.isLaidOut(this.e)) {
      j();
    } else {
      this.e.setOnLayoutChangeListener(new h());
    }
    this.e.setOnAttachStateChangeListener(new i());
    if (ViewCompat.isLaidOut(this.e))
    {
      if (F()) {
        j();
      } else {
        x();
      }
    }
    else {
      this.e.setOnLayoutChangeListener(new j());
    }
  }
  
  final void s(int paramInt)
  {
    if ((F()) && (this.e.getVisibility() == 0)) {
      k(paramInt);
    } else {
      w(paramInt);
    }
  }
  
  public boolean t()
  {
    return d.e().h(this.i);
  }
  
  @NonNull
  public TNotificationSnackbar y(l paraml)
  {
    this.g = paraml;
    return this;
  }
  
  @NonNull
  public TNotificationSnackbar z(final View.OnClickListener paramOnClickListener)
  {
    this.e.getCardView().setOnClickListener(new d(paramOnClickListener));
    return this;
  }
  
  public static class SnackbarLayout
    extends LinearLayout
  {
    private b H3;
    private a I3;
    private TextView c;
    private TextView d;
    private ImageView f;
    private float p0;
    private boolean p1 = false;
    private c p2;
    private final int p3 = 20;
    private TextView q;
    private int x;
    private int y;
    private float z;
    
    public SnackbarLayout(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, com.tplink.iot.b.SnackbarLayout);
      this.x = paramAttributeSet.getDimensionPixelSize(0, -1);
      this.y = paramAttributeSet.getDimensionPixelSize(7, -1);
      if (paramAttributeSet.hasValue(6)) {
        ViewCompat.setElevation(this, paramAttributeSet.getDimensionPixelSize(6, 0));
      }
      paramAttributeSet.recycle();
      setClickable(true);
      LayoutInflater.from(paramContext).inflate(2131559450, this);
      ViewCompat.setAccessibilityLiveRegion(this, 1);
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    
    View getCardView()
    {
      return this;
    }
    
    TextView getContentView()
    {
      return this.d;
    }
    
    ImageView getImageView()
    {
      return this.f;
    }
    
    TextView getMessageView()
    {
      return this.c;
    }
    
    TextView getTimeView()
    {
      return this.q;
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      a locala = this.I3;
      if (locala != null) {
        locala.onViewAttachedToWindow(this);
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      a locala = this.I3;
      if (locala != null) {
        locala.onViewDetachedFromWindow(this);
      }
    }
    
    protected void onFinishInflate()
    {
      super.onFinishInflate();
      this.c = ((TextView)findViewById(2131364060));
      this.d = ((TextView)findViewById(2131364058));
      this.f = ((ImageView)findViewById(2131364059));
      this.q = ((TextView)findViewById(2131364061));
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramBoolean)
      {
        b localb = this.H3;
        if (localb != null) {
          localb.onLayoutChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
        }
      }
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            float f1 = paramMotionEvent.getY();
            this.p0 = f1;
            if (this.z - f1 > 20.0F)
            {
              if (!this.p1)
              {
                paramMotionEvent = this.p2;
                if (paramMotionEvent != null)
                {
                  this.p1 = true;
                  paramMotionEvent.a();
                }
              }
              return true;
            }
          }
        }
        else if (this.z - this.p0 > 20.0F)
        {
          if (!this.p1)
          {
            paramMotionEvent = this.p2;
            if (paramMotionEvent != null)
            {
              this.p1 = true;
              paramMotionEvent.a();
            }
          }
          return true;
        }
      }
      else
      {
        this.z = paramMotionEvent.getY();
        this.p1 = false;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    
    protected void onWindowVisibilityChanged(int paramInt)
    {
      super.onWindowVisibilityChanged(paramInt);
      if (paramInt != 4)
      {
        a locala = this.I3;
        if (locala != null) {
          locala.onViewDetachedFromWindow(this);
        }
      }
    }
    
    void setOnAttachStateChangeListener(a parama)
    {
      this.I3 = parama;
    }
    
    void setOnLayoutChangeListener(b paramb)
    {
      this.H3 = paramb;
    }
    
    public void setOnSwipeListener(c paramc)
    {
      this.p2 = paramc;
    }
    
    static abstract interface a
    {
      public abstract void onViewAttachedToWindow(View paramView);
      
      public abstract void onViewDetachedFromWindow(View paramView);
    }
    
    static abstract interface b
    {
      public abstract void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    }
    
    static abstract interface c
    {
      public abstract void a();
    }
  }
  
  class a
    implements Animation.AnimationListener
  {
    a() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      TNotificationSnackbar.a(TNotificationSnackbar.this);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  class b
    implements Animation.AnimationListener
  {
    b(int paramInt) {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      TNotificationSnackbar.h(TNotificationSnackbar.this, paramInt);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  static final class c
    implements Handler.Callback
  {
    public boolean handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i != 1) {
          return false;
        }
        ((TNotificationSnackbar)paramMessage.obj).s(paramMessage.arg1);
        return true;
      }
      ((TNotificationSnackbar)paramMessage.obj).H();
      return true;
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d(View.OnClickListener paramOnClickListener) {}
    
    public void onClick(View paramView)
    {
      View.OnClickListener localOnClickListener = paramOnClickListener;
      if (localOnClickListener != null) {
        localOnClickListener.onClick(paramView);
      }
      TNotificationSnackbar.c(TNotificationSnackbar.this, 1);
    }
  }
  
  class e
    implements TNotificationSnackbar.SnackbarLayout.c
  {
    e() {}
    
    public void a()
    {
      TNotificationSnackbar.c(TNotificationSnackbar.this, 0);
    }
  }
  
  class f
    implements d.b
  {
    f() {}
    
    public String content()
    {
      return TNotificationSnackbar.SnackbarLayout.a(TNotificationSnackbar.e(TNotificationSnackbar.this)).getText().toString();
    }
    
    public void dismiss(int paramInt)
    {
      TNotificationSnackbar.d().sendMessage(TNotificationSnackbar.d().obtainMessage(1, paramInt, 0, TNotificationSnackbar.this));
    }
    
    public View getParentView()
    {
      return TNotificationSnackbar.f(TNotificationSnackbar.this);
    }
    
    public void show()
    {
      TNotificationSnackbar.d().sendMessage(TNotificationSnackbar.d().obtainMessage(0, TNotificationSnackbar.this));
    }
  }
  
  class g
    implements SwipeDismissBehavior.OnDismissListener
  {
    g() {}
    
    public void onDismiss(View paramView)
    {
      paramView.setVisibility(8);
      TNotificationSnackbar.c(TNotificationSnackbar.this, 0);
    }
    
    public void onDragStateChanged(int paramInt)
    {
      if (paramInt != 0)
      {
        if ((paramInt == 1) || (paramInt == 2)) {
          d.e().c(TNotificationSnackbar.b(TNotificationSnackbar.this));
        }
      }
      else {
        d.e().n(TNotificationSnackbar.b(TNotificationSnackbar.this));
      }
    }
  }
  
  class h
    implements TNotificationSnackbar.SnackbarLayout.b
  {
    h() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      TNotificationSnackbar.g(TNotificationSnackbar.this);
      TNotificationSnackbar.e(TNotificationSnackbar.this).setOnLayoutChangeListener(null);
    }
  }
  
  class i
    implements TNotificationSnackbar.SnackbarLayout.a
  {
    i() {}
    
    public void onViewAttachedToWindow(View paramView) {}
    
    public void onViewDetachedFromWindow(View paramView)
    {
      if (TNotificationSnackbar.this.t()) {
        TNotificationSnackbar.d().post(new a());
      }
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        TNotificationSnackbar.h(TNotificationSnackbar.this, 3);
      }
    }
  }
  
  class j
    implements TNotificationSnackbar.SnackbarLayout.b
  {
    j() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      TNotificationSnackbar.e(TNotificationSnackbar.this).setOnLayoutChangeListener(null);
      if (TNotificationSnackbar.i(TNotificationSnackbar.this)) {
        TNotificationSnackbar.g(TNotificationSnackbar.this);
      } else {
        TNotificationSnackbar.a(TNotificationSnackbar.this);
      }
    }
  }
  
  final class k
    extends SwipeDismissBehavior<TNotificationSnackbar.SnackbarLayout>
  {
    k() {}
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, TNotificationSnackbar.SnackbarLayout paramSnackbarLayout, MotionEvent paramMotionEvent)
    {
      if (paramCoordinatorLayout.isPointInChildBounds(paramSnackbarLayout, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        int i = paramMotionEvent.getActionMasked();
        if (i != 0)
        {
          if ((i == 1) || (i == 3)) {
            d.e().n(TNotificationSnackbar.b(TNotificationSnackbar.this));
          }
        }
        else {
          d.e().c(TNotificationSnackbar.b(TNotificationSnackbar.this));
        }
      }
      return super.onInterceptTouchEvent(paramCoordinatorLayout, paramSnackbarLayout, paramMotionEvent);
    }
    
    public boolean canSwipeDismissView(View paramView)
    {
      return paramView instanceof TNotificationSnackbar.SnackbarLayout;
    }
  }
  
  public static abstract class l
  {
    public void a(TNotificationSnackbar paramTNotificationSnackbar, int paramInt) {}
    
    public void b(TNotificationSnackbar paramTNotificationSnackbar) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\topsnackbar\TNotificationSnackbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */