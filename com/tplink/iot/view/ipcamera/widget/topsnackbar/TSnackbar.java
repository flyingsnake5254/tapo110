package com.tplink.iot.view.ipcamera.widget.topsnackbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener;

public final class TSnackbar
{
  private static final Handler a = new Handler(Looper.getMainLooper(), new b());
  private int b = 0;
  private ViewGroup c;
  private Context d;
  private SnackbarLayout e;
  private int f;
  private k g;
  private AccessibilityManager h;
  private final d.b i = new d();
  
  private TSnackbar(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = paramInt;
    this.c = paramViewGroup;
    paramViewGroup = paramViewGroup.getContext();
    this.d = paramViewGroup;
    paramViewGroup = LayoutInflater.from(paramViewGroup);
    if (paramInt == 1) {
      this.e = ((SnackbarLayout)paramViewGroup.inflate(2131559402, this.c, false));
    } else {
      this.e = ((SnackbarLayout)paramViewGroup.inflate(2131559447, this.c, false));
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
  
  @NonNull
  public static TSnackbar A(@NonNull View paramView, @NonNull CharSequence paramCharSequence, int paramInt)
  {
    paramView = new TSnackbar(m(paramView), 0);
    paramView.L(paramCharSequence);
    paramView.K(paramInt);
    return paramView;
  }
  
  @NonNull
  public static TSnackbar B(@NonNull Fragment paramFragment, @StringRes int paramInt1, int paramInt2)
  {
    return A(s(paramFragment), paramFragment.getResources().getText(paramInt1), paramInt2);
  }
  
  public static TSnackbar C(@NonNull Fragment paramFragment, @NonNull CharSequence paramCharSequence, int paramInt)
  {
    return A(s(paramFragment), paramCharSequence, paramInt);
  }
  
  private void D(int paramInt)
  {
    d.e().l(this.i);
    if (this.g == null)
    {
      ViewParent localViewParent = this.e.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.e);
      }
      return;
    }
    throw null;
  }
  
  private void E()
  {
    d.e().m(this.i);
    if (this.g == null) {
      return;
    }
    throw null;
  }
  
  private boolean M()
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
    localAnimation.setAnimationListener(new i());
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
    localAnimation.setAnimationListener(new a(paramInt));
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
  
  public static ViewGroup s(Fragment paramFragment)
  {
    return r(paramFragment.getActivity());
  }
  
  @NonNull
  public static TSnackbar x(@NonNull Activity paramActivity, @StringRes int paramInt1, int paramInt2)
  {
    return A(r(paramActivity), paramActivity.getResources().getText(paramInt1), paramInt2);
  }
  
  public static TSnackbar y(@NonNull Activity paramActivity, @NonNull CharSequence paramCharSequence, int paramInt)
  {
    return A(r(paramActivity), paramCharSequence, paramInt);
  }
  
  @NonNull
  public static TSnackbar z(@NonNull View paramView, @StringRes int paramInt1, int paramInt2)
  {
    return A(paramView, paramView.getResources().getText(paramInt1), paramInt2);
  }
  
  @NonNull
  public TSnackbar F(@StringRes int paramInt, View.OnClickListener paramOnClickListener)
  {
    return H(this.d.getText(paramInt), paramOnClickListener);
  }
  
  @NonNull
  public TSnackbar G(Drawable paramDrawable, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.e.getActionView();
    if (paramDrawable == null)
    {
      localTextView.setVisibility(8);
      localTextView.setOnClickListener(null);
    }
    else
    {
      localTextView.setVisibility(0);
      localTextView.setBackground(paramDrawable);
      localTextView.setOnClickListener(new a(this, paramOnClickListener));
    }
    return this;
  }
  
  @NonNull
  public TSnackbar H(CharSequence paramCharSequence, final View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.e.getActionView();
    if ((!TextUtils.isEmpty(paramCharSequence)) && (paramOnClickListener != null))
    {
      localTextView.setVisibility(0);
      localTextView.setText(paramCharSequence);
      localTextView.setOnClickListener(new c(paramOnClickListener));
    }
    else
    {
      localTextView.setVisibility(8);
      localTextView.setOnClickListener(null);
    }
    return this;
  }
  
  @NonNull
  public TSnackbar I(@ColorInt int paramInt)
  {
    this.e.getActionView().setTextColor(paramInt);
    return this;
  }
  
  public TSnackbar J(@ColorInt int paramInt)
  {
    this.e.setBackgroundColor(paramInt);
    return this;
  }
  
  @NonNull
  public TSnackbar K(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  @NonNull
  public TSnackbar L(@NonNull CharSequence paramCharSequence)
  {
    this.e.getMessageView().setText(paramCharSequence);
    return this;
  }
  
  public void N()
  {
    d.e().p(this.f, this.i);
  }
  
  final void O()
  {
    if (this.e.getParent() == null)
    {
      Object localObject = this.e.getLayoutParams();
      if ((localObject instanceof CoordinatorLayout.LayoutParams))
      {
        j localj = new j();
        localj.setStartAlphaSwipeDistance(0.1F);
        localj.setEndAlphaSwipeDistance(0.6F);
        localj.setSwipeDirection(0);
        localj.setListener(new e());
        localObject = (CoordinatorLayout.LayoutParams)localObject;
        ((CoordinatorLayout.LayoutParams)localObject).setBehavior(localj);
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(0, -30, 0, 0);
      }
      this.c.addView(this.e);
    }
    if (ViewCompat.isLaidOut(this.e)) {
      j();
    } else {
      this.e.setOnLayoutChangeListener(new f());
    }
    this.e.setOnAttachStateChangeListener(new g());
    if (ViewCompat.isLaidOut(this.e))
    {
      if (M()) {
        j();
      } else {
        E();
      }
    }
    else {
      this.e.setOnLayoutChangeListener(new h());
    }
  }
  
  final void t(int paramInt)
  {
    if ((M()) && (this.e.getVisibility() == 0)) {
      k(paramInt);
    } else {
      D(paramInt);
    }
  }
  
  public boolean u()
  {
    return d.e().h(this.i);
  }
  
  public static class SnackbarLayout
    extends LinearLayout
  {
    private TextView c;
    private TextView d;
    private int f;
    private int q;
    private b x;
    private a y;
    
    public SnackbarLayout(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, com.tplink.iot.b.SnackbarLayout);
      this.f = paramAttributeSet.getDimensionPixelSize(0, -1);
      this.q = paramAttributeSet.getDimensionPixelSize(7, -1);
      if (paramAttributeSet.hasValue(6)) {
        ViewCompat.setElevation(this, paramAttributeSet.getDimensionPixelSize(6, 0));
      }
      paramAttributeSet.recycle();
      setClickable(true);
      LayoutInflater.from(paramContext).inflate(2131559448, this);
      ViewCompat.setAccessibilityLiveRegion(this, 1);
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    
    TextView getActionView()
    {
      return this.d;
    }
    
    TextView getMessageView()
    {
      return this.c;
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      a locala = this.y;
      if (locala != null) {
        locala.onViewAttachedToWindow(this);
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      a locala = this.y;
      if (locala != null) {
        locala.onViewDetachedFromWindow(this);
      }
    }
    
    protected void onFinishInflate()
    {
      super.onFinishInflate();
      this.c = ((TextView)findViewById(2131364060));
      this.d = ((TextView)findViewById(2131364056));
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramBoolean)
      {
        b localb = this.x;
        if (localb != null) {
          localb.onLayoutChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
        }
      }
    }
    
    void setOnAttachStateChangeListener(a parama)
    {
      this.y = parama;
    }
    
    void setOnLayoutChangeListener(b paramb)
    {
      this.x = paramb;
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
  }
  
  class a
    implements Animation.AnimationListener
  {
    a(int paramInt) {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      TSnackbar.h(TSnackbar.this, paramInt);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  static final class b
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
        ((TSnackbar)paramMessage.obj).t(paramMessage.arg1);
        return true;
      }
      ((TSnackbar)paramMessage.obj).O();
      return true;
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c(View.OnClickListener paramOnClickListener) {}
    
    public void onClick(View paramView)
    {
      paramOnClickListener.onClick(paramView);
      TSnackbar.c(TSnackbar.this, 1);
    }
  }
  
  class d
    implements d.b
  {
    d() {}
    
    public String content()
    {
      return TSnackbar.SnackbarLayout.a(TSnackbar.e(TSnackbar.this)).getText().toString();
    }
    
    public void dismiss(int paramInt)
    {
      TSnackbar.d().sendMessage(TSnackbar.d().obtainMessage(1, paramInt, 0, TSnackbar.this));
    }
    
    public View getParentView()
    {
      return TSnackbar.f(TSnackbar.this);
    }
    
    public void show()
    {
      TSnackbar.d().sendMessage(TSnackbar.d().obtainMessage(0, TSnackbar.this));
    }
  }
  
  class e
    implements SwipeDismissBehavior.OnDismissListener
  {
    e() {}
    
    public void onDismiss(View paramView)
    {
      paramView.setVisibility(8);
      TSnackbar.c(TSnackbar.this, 0);
    }
    
    public void onDragStateChanged(int paramInt)
    {
      if (paramInt != 0)
      {
        if ((paramInt == 1) || (paramInt == 2)) {
          d.e().c(TSnackbar.b(TSnackbar.this));
        }
      }
      else {
        d.e().n(TSnackbar.b(TSnackbar.this));
      }
    }
  }
  
  class f
    implements TSnackbar.SnackbarLayout.b
  {
    f() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      TSnackbar.g(TSnackbar.this);
      TSnackbar.e(TSnackbar.this).setOnLayoutChangeListener(null);
    }
  }
  
  class g
    implements TSnackbar.SnackbarLayout.a
  {
    g() {}
    
    public void onViewAttachedToWindow(View paramView) {}
    
    public void onViewDetachedFromWindow(View paramView)
    {
      if (TSnackbar.this.u()) {
        TSnackbar.d().post(new a());
      }
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        TSnackbar.h(TSnackbar.this, 3);
      }
    }
  }
  
  class h
    implements TSnackbar.SnackbarLayout.b
  {
    h() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      TSnackbar.e(TSnackbar.this).setOnLayoutChangeListener(null);
      if (TSnackbar.i(TSnackbar.this)) {
        TSnackbar.g(TSnackbar.this);
      } else {
        TSnackbar.a(TSnackbar.this);
      }
    }
  }
  
  class i
    implements Animation.AnimationListener
  {
    i() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      TSnackbar.a(TSnackbar.this);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  final class j
    extends SwipeDismissBehavior<TSnackbar.SnackbarLayout>
  {
    j() {}
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, TSnackbar.SnackbarLayout paramSnackbarLayout, MotionEvent paramMotionEvent)
    {
      if (paramCoordinatorLayout.isPointInChildBounds(paramSnackbarLayout, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        int i = paramMotionEvent.getActionMasked();
        if (i != 0)
        {
          if ((i == 1) || (i == 3)) {
            d.e().n(TSnackbar.b(TSnackbar.this));
          }
        }
        else {
          d.e().c(TSnackbar.b(TSnackbar.this));
        }
      }
      return super.onInterceptTouchEvent(paramCoordinatorLayout, paramSnackbarLayout, paramMotionEvent);
    }
    
    public boolean canSwipeDismissView(View paramView)
    {
      return paramView instanceof TSnackbar.SnackbarLayout;
    }
  }
  
  public static abstract class k {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\topsnackbar\TSnackbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */