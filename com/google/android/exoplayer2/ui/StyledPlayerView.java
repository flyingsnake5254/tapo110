package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.j2.b;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.trackselection.j;
import com.google.android.exoplayer2.trackselection.k;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.u1.e;
import com.google.android.exoplayer2.u1.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.video.z;
import com.google.android.exoplayer2.x0;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class StyledPlayerView
  extends FrameLayout
  implements e0
{
  @Nullable
  private final FrameLayout H3;
  @Nullable
  private u1 I3;
  private boolean J3;
  @Nullable
  private StyledPlayerControlView.m K3;
  private boolean L3;
  @Nullable
  private Drawable M3;
  private int N3;
  private boolean O3;
  @Nullable
  private n<? super PlaybackException> P3;
  @Nullable
  private CharSequence Q3;
  private int R3;
  private boolean S3;
  private boolean T3;
  private boolean U3;
  private int V3;
  private boolean W3;
  private final a c;
  @Nullable
  private final AspectRatioFrameLayout d;
  @Nullable
  private final View f;
  @Nullable
  private final View p0;
  @Nullable
  private final TextView p1;
  @Nullable
  private final StyledPlayerControlView p2;
  @Nullable
  private final FrameLayout p3;
  @Nullable
  private final View q;
  private final boolean x;
  @Nullable
  private final ImageView y;
  @Nullable
  private final SubtitleView z;
  
  public StyledPlayerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StyledPlayerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StyledPlayerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a locala = new a();
    this.c = locala;
    if (isInEditMode())
    {
      this.d = null;
      this.f = null;
      this.q = null;
      this.x = false;
      this.y = null;
      this.z = null;
      this.p0 = null;
      this.p1 = null;
      this.p2 = null;
      this.p3 = null;
      this.H3 = null;
      paramContext = new ImageView(paramContext);
      if (o0.a >= 23) {
        r(getResources(), paramContext);
      } else {
        q(getResources(), paramContext);
      }
      addView(paramContext);
      return;
    }
    int i = p0.exo_styled_player_view;
    if (paramAttributeSet != null) {
      localObject1 = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, t0.StyledPlayerView, 0, 0);
    }
    boolean bool5;
    try
    {
      paramInt = t0.StyledPlayerView_shutter_background_color;
      bool1 = ((TypedArray)localObject1).hasValue(paramInt);
      j = ((TypedArray)localObject1).getColor(paramInt, 0);
      i = ((TypedArray)localObject1).getResourceId(t0.StyledPlayerView_player_layout_id, i);
      bool2 = ((TypedArray)localObject1).getBoolean(t0.StyledPlayerView_use_artwork, true);
      paramInt = ((TypedArray)localObject1).getResourceId(t0.StyledPlayerView_default_artwork, 0);
      bool3 = ((TypedArray)localObject1).getBoolean(t0.StyledPlayerView_use_controller, true);
      k = ((TypedArray)localObject1).getInt(t0.StyledPlayerView_surface_type, 1);
      m = ((TypedArray)localObject1).getInt(t0.StyledPlayerView_resize_mode, 0);
      int n = ((TypedArray)localObject1).getInt(t0.StyledPlayerView_show_timeout, 5000);
      bool4 = ((TypedArray)localObject1).getBoolean(t0.StyledPlayerView_hide_on_touch, true);
      bool5 = ((TypedArray)localObject1).getBoolean(t0.StyledPlayerView_auto_show, true);
      i1 = ((TypedArray)localObject1).getInteger(t0.StyledPlayerView_show_buffering, 0);
      this.O3 = ((TypedArray)localObject1).getBoolean(t0.StyledPlayerView_keep_content_on_player_reset, this.O3);
      bool6 = ((TypedArray)localObject1).getBoolean(t0.StyledPlayerView_hide_during_ads, true);
      ((TypedArray)localObject1).recycle();
      i2 = paramInt;
      paramInt = n;
    }
    finally
    {
      ((TypedArray)localObject1).recycle();
    }
    int m = 0;
    boolean bool6 = true;
    int i1 = 0;
    boolean bool4 = true;
    int k = 1;
    int j = 0;
    boolean bool1 = false;
    boolean bool2 = true;
    int i2 = 0;
    paramInt = 5000;
    boolean bool3 = true;
    LayoutInflater.from(paramContext).inflate(i, this);
    setDescendantFocusability(262144);
    Object localObject1 = (AspectRatioFrameLayout)findViewById(n0.exo_content_frame);
    this.d = ((AspectRatioFrameLayout)localObject1);
    if (localObject1 != null) {
      B((AspectRatioFrameLayout)localObject1, m);
    }
    Object localObject2 = findViewById(n0.exo_shutter);
    this.f = ((View)localObject2);
    if ((localObject2 != null) && (bool1)) {
      ((View)localObject2).setBackgroundColor(j);
    }
    if ((localObject1 != null) && (k != 0))
    {
      localObject2 = new ViewGroup.LayoutParams(-1, -1);
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4) {
            this.q = new SurfaceView(paramContext);
          }
          for (;;)
          {
            break label622;
            try
            {
              this.q = ((View)Class.forName("com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView").getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext }));
            }
            catch (Exception paramContext)
            {
              throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", paramContext);
            }
          }
        }
        try
        {
          this.q = ((View)Class.forName("com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView").getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext }));
          bool1 = true;
        }
        catch (Exception paramContext)
        {
          throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", paramContext);
        }
      }
      else
      {
        this.q = new TextureView(paramContext);
        label622:
        bool1 = false;
      }
      this.q.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.q.setOnClickListener(locala);
      this.q.setClickable(false);
      ((FrameLayout)localObject1).addView(this.q, 0);
    }
    else
    {
      this.q = null;
      bool1 = false;
    }
    this.x = bool1;
    this.p3 = ((FrameLayout)findViewById(n0.exo_ad_overlay));
    this.H3 = ((FrameLayout)findViewById(n0.exo_overlay));
    localObject1 = (ImageView)findViewById(n0.exo_artwork);
    this.y = ((ImageView)localObject1);
    if ((bool2) && (localObject1 != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.L3 = bool1;
    if (i2 != 0) {
      this.M3 = ContextCompat.getDrawable(getContext(), i2);
    }
    localObject1 = (SubtitleView)findViewById(n0.exo_subtitles);
    this.z = ((SubtitleView)localObject1);
    if (localObject1 != null)
    {
      ((SubtitleView)localObject1).d();
      ((SubtitleView)localObject1).e();
    }
    localObject1 = findViewById(n0.exo_buffering);
    this.p0 = ((View)localObject1);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    this.N3 = i1;
    localObject1 = (TextView)findViewById(n0.exo_error_message);
    this.p1 = ((TextView)localObject1);
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    j = n0.exo_controller;
    localObject2 = (StyledPlayerControlView)findViewById(j);
    localObject1 = findViewById(n0.exo_controller_placeholder);
    if (localObject2 != null)
    {
      this.p2 = ((StyledPlayerControlView)localObject2);
    }
    else if (localObject1 != null)
    {
      paramContext = new StyledPlayerControlView(paramContext, null, 0, paramAttributeSet);
      this.p2 = paramContext;
      paramContext.setId(j);
      paramContext.setLayoutParams(((View)localObject1).getLayoutParams());
      paramAttributeSet = (ViewGroup)((View)localObject1).getParent();
      j = paramAttributeSet.indexOfChild((View)localObject1);
      paramAttributeSet.removeView((View)localObject1);
      paramAttributeSet.addView(paramContext, j);
    }
    else
    {
      this.p2 = null;
    }
    paramContext = this.p2;
    if (paramContext == null) {
      paramInt = 0;
    }
    this.R3 = paramInt;
    this.U3 = bool4;
    this.S3 = bool5;
    this.T3 = bool6;
    if ((bool3) && (paramContext != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.J3 = bool1;
    if (paramContext != null)
    {
      paramContext.b0();
      this.p2.R(locala);
    }
    I();
  }
  
  @RequiresNonNull({"artworkView"})
  private boolean A(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if ((i > 0) && (j > 0))
      {
        float f1 = i / j;
        y(this.d, f1);
        this.y.setImageDrawable(paramDrawable);
        this.y.setVisibility(0);
        return true;
      }
    }
    return false;
  }
  
  private static void B(AspectRatioFrameLayout paramAspectRatioFrameLayout, int paramInt)
  {
    paramAspectRatioFrameLayout.setResizeMode(paramInt);
  }
  
  private boolean C()
  {
    u1 localu1 = this.I3;
    boolean bool1 = true;
    if (localu1 == null) {
      return true;
    }
    int i = localu1.getPlaybackState();
    if ((this.S3) && (!this.I3.w().q()))
    {
      bool2 = bool1;
      if (i == 1) {
        break label85;
      }
      bool2 = bool1;
      if (i == 4) {
        break label85;
      }
      if (!((u1)g.e(this.I3)).E())
      {
        bool2 = bool1;
        break label85;
      }
    }
    boolean bool2 = false;
    label85:
    return bool2;
  }
  
  private void E(boolean paramBoolean)
  {
    if (!N()) {
      return;
    }
    StyledPlayerControlView localStyledPlayerControlView = this.p2;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = this.R3;
    }
    localStyledPlayerControlView.setShowTimeoutMs(i);
    this.p2.t0();
  }
  
  private boolean F()
  {
    if ((N()) && (this.I3 != null))
    {
      if (!this.p2.e0())
      {
        x(true);
        return true;
      }
      if (this.U3)
      {
        this.p2.a0();
        return true;
      }
    }
    return false;
  }
  
  private void G()
  {
    Object localObject = this.I3;
    if (localObject != null) {
      localObject = ((u1)localObject).J();
    } else {
      localObject = z.a;
    }
    int i = ((z)localObject).c;
    int j = ((z)localObject).d;
    int k = ((z)localObject).e;
    float f1 = 0.0F;
    float f2;
    if ((j != 0) && (i != 0)) {
      f2 = i * ((z)localObject).f / j;
    } else {
      f2 = 0.0F;
    }
    localObject = this.q;
    float f3 = f2;
    if ((localObject instanceof TextureView))
    {
      f3 = f2;
      if (f2 > 0.0F) {
        if (k != 90)
        {
          f3 = f2;
          if (k != 270) {}
        }
        else
        {
          f3 = 1.0F / f2;
        }
      }
      if (this.V3 != 0) {
        ((View)localObject).removeOnLayoutChangeListener(this.c);
      }
      this.V3 = k;
      if (k != 0) {
        this.q.addOnLayoutChangeListener(this.c);
      }
      o((TextureView)this.q, this.V3);
    }
    localObject = this.d;
    if (this.x) {
      f2 = f1;
    } else {
      f2 = f3;
    }
    y((AspectRatioFrameLayout)localObject, f2);
  }
  
  private void H()
  {
    if (this.p0 != null)
    {
      Object localObject = this.I3;
      int i = 1;
      int j = 0;
      if ((localObject != null) && (((u1)localObject).getPlaybackState() == 2))
      {
        int k = this.N3;
        m = i;
        if (k == 2) {
          break label72;
        }
        if ((k == 1) && (this.I3.E()))
        {
          m = i;
          break label72;
        }
      }
      int m = 0;
      label72:
      localObject = this.p0;
      if (m != 0) {
        m = j;
      } else {
        m = 8;
      }
      ((View)localObject).setVisibility(m);
    }
  }
  
  private void I()
  {
    StyledPlayerControlView localStyledPlayerControlView = this.p2;
    String str = null;
    if ((localStyledPlayerControlView != null) && (this.J3))
    {
      if (localStyledPlayerControlView.e0())
      {
        if (this.U3) {
          str = getResources().getString(r0.exo_controls_hide);
        }
        setContentDescription(str);
      }
      else
      {
        setContentDescription(getResources().getString(r0.exo_controls_show));
      }
    }
    else {
      setContentDescription(null);
    }
  }
  
  private void J()
  {
    if ((w()) && (this.T3)) {
      u();
    } else {
      x(false);
    }
  }
  
  private void K()
  {
    Object localObject1 = this.p1;
    if (localObject1 != null)
    {
      Object localObject2 = this.Q3;
      if (localObject2 != null)
      {
        ((TextView)localObject1).setText((CharSequence)localObject2);
        this.p1.setVisibility(0);
        return;
      }
      localObject2 = this.I3;
      if (localObject2 != null) {
        localObject2 = ((u1)localObject2).o();
      } else {
        localObject2 = null;
      }
      if (localObject2 != null)
      {
        localObject1 = this.P3;
        if (localObject1 != null)
        {
          localObject2 = (CharSequence)((n)localObject1).a((Throwable)localObject2).second;
          this.p1.setText((CharSequence)localObject2);
          this.p1.setVisibility(0);
          return;
        }
      }
      this.p1.setVisibility(8);
    }
  }
  
  private void L(boolean paramBoolean)
  {
    u1 localu1 = this.I3;
    if ((localu1 != null) && (!localu1.u().c()))
    {
      if ((paramBoolean) && (!this.O3)) {
        p();
      }
      k localk = localu1.A();
      for (int i = 0; i < localk.a; i++)
      {
        j localj = localk.a(i);
        if (localj != null) {
          for (int j = 0; j < localj.length(); j++) {
            if (y.k(localj.a(j).H3) == 2)
            {
              t();
              return;
            }
          }
        }
      }
      p();
      if (M())
      {
        if (z(localu1.U())) {
          return;
        }
        if (A(this.M3)) {
          return;
        }
      }
      t();
      return;
    }
    if (!this.O3)
    {
      t();
      p();
    }
  }
  
  @EnsuresNonNullIf(expression={"artworkView"}, result=true)
  private boolean M()
  {
    if (this.L3)
    {
      g.i(this.y);
      return true;
    }
    return false;
  }
  
  @EnsuresNonNullIf(expression={"controller"}, result=true)
  private boolean N()
  {
    if (this.J3)
    {
      g.i(this.p2);
      return true;
    }
    return false;
  }
  
  private static void o(TextureView paramTextureView, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    float f1 = paramTextureView.getWidth();
    float f2 = paramTextureView.getHeight();
    if ((f1 != 0.0F) && (f2 != 0.0F) && (paramInt != 0))
    {
      float f3 = f1 / 2.0F;
      float f4 = f2 / 2.0F;
      localMatrix.postRotate(paramInt, f3, f4);
      RectF localRectF1 = new RectF(0.0F, 0.0F, f1, f2);
      RectF localRectF2 = new RectF();
      localMatrix.mapRect(localRectF2, localRectF1);
      localMatrix.postScale(f1 / localRectF2.width(), f2 / localRectF2.height(), f3, f4);
    }
    paramTextureView.setTransform(localMatrix);
  }
  
  private void p()
  {
    View localView = this.f;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  private static void q(Resources paramResources, ImageView paramImageView)
  {
    paramImageView.setImageDrawable(paramResources.getDrawable(l0.exo_edit_mode_logo));
    paramImageView.setBackgroundColor(paramResources.getColor(j0.exo_edit_mode_background_color));
  }
  
  @RequiresApi(23)
  private static void r(Resources paramResources, ImageView paramImageView)
  {
    paramImageView.setImageDrawable(paramResources.getDrawable(l0.exo_edit_mode_logo, null));
    paramImageView.setBackgroundColor(paramResources.getColor(j0.exo_edit_mode_background_color, null));
  }
  
  private void t()
  {
    ImageView localImageView = this.y;
    if (localImageView != null)
    {
      localImageView.setImageResource(17170445);
      this.y.setVisibility(4);
    }
  }
  
  @SuppressLint({"InlinedApi"})
  private boolean v(int paramInt)
  {
    boolean bool;
    if ((paramInt != 19) && (paramInt != 270) && (paramInt != 22) && (paramInt != 271) && (paramInt != 20) && (paramInt != 269) && (paramInt != 21) && (paramInt != 268) && (paramInt != 23)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean w()
  {
    u1 localu1 = this.I3;
    boolean bool;
    if ((localu1 != null) && (localu1.f()) && (this.I3.E())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void x(boolean paramBoolean)
  {
    if ((w()) && (this.T3)) {
      return;
    }
    if (N())
    {
      int i;
      if ((this.p2.e0()) && (this.p2.getShowTimeoutMs() <= 0)) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool = C();
      if ((paramBoolean) || (i != 0) || (bool)) {
        E(bool);
      }
    }
  }
  
  @RequiresNonNull({"artworkView"})
  private boolean z(m1 paramm1)
  {
    paramm1 = paramm1.m;
    if (paramm1 == null) {
      return false;
    }
    paramm1 = BitmapFactory.decodeByteArray(paramm1, 0, paramm1.length);
    return A(new BitmapDrawable(getResources(), paramm1));
  }
  
  public void D()
  {
    E(C());
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    u1 localu1 = this.I3;
    if ((localu1 != null) && (localu1.f())) {
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    boolean bool1 = v(paramKeyEvent.getKeyCode());
    boolean bool2 = false;
    if ((bool1) && (N()) && (!this.p2.e0()))
    {
      x(true);
    }
    else
    {
      if ((!s(paramKeyEvent)) && (!super.dispatchKeyEvent(paramKeyEvent)))
      {
        bool3 = bool2;
        if (!bool1) {
          break label123;
        }
        bool3 = bool2;
        if (!N()) {
          break label123;
        }
        x(true);
        bool3 = bool2;
        break label123;
      }
      x(true);
    }
    boolean bool3 = true;
    label123:
    return bool3;
  }
  
  public List<d0> getAdOverlayInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.H3;
    if (localObject != null) {
      localArrayList.add(new d0((View)localObject, 3, "Transparent overlay does not impact viewability"));
    }
    localObject = this.p2;
    if (localObject != null) {
      localArrayList.add(new d0((View)localObject, 0));
    }
    return ImmutableList.copyOf(localArrayList);
  }
  
  public ViewGroup getAdViewGroup()
  {
    return (ViewGroup)g.j(this.p3, "exo_ad_overlay must be present for ad playback");
  }
  
  public boolean getControllerAutoShow()
  {
    return this.S3;
  }
  
  public boolean getControllerHideOnTouch()
  {
    return this.U3;
  }
  
  public int getControllerShowTimeoutMs()
  {
    return this.R3;
  }
  
  @Nullable
  public Drawable getDefaultArtwork()
  {
    return this.M3;
  }
  
  @Nullable
  public FrameLayout getOverlayFrameLayout()
  {
    return this.H3;
  }
  
  @Nullable
  public u1 getPlayer()
  {
    return this.I3;
  }
  
  public int getResizeMode()
  {
    g.i(this.d);
    return this.d.getResizeMode();
  }
  
  @Nullable
  public SubtitleView getSubtitleView()
  {
    return this.z;
  }
  
  public boolean getUseArtwork()
  {
    return this.L3;
  }
  
  public boolean getUseController()
  {
    return this.J3;
  }
  
  @Nullable
  public View getVideoSurfaceView()
  {
    return this.q;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((N()) && (this.I3 != null))
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1) {
          return false;
        }
        if (this.W3)
        {
          this.W3 = false;
          return performClick();
        }
        return false;
      }
      this.W3 = true;
      return true;
    }
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((N()) && (this.I3 != null))
    {
      x(true);
      return true;
    }
    return false;
  }
  
  public boolean performClick()
  {
    super.performClick();
    return F();
  }
  
  public boolean s(KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((N()) && (this.p2.T(paramKeyEvent))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.b paramb)
  {
    g.i(this.d);
    this.d.setAspectRatioListener(paramb);
  }
  
  @Deprecated
  public void setControlDispatcher(x0 paramx0)
  {
    g.i(this.p2);
    this.p2.setControlDispatcher(paramx0);
  }
  
  public void setControllerAutoShow(boolean paramBoolean)
  {
    this.S3 = paramBoolean;
  }
  
  public void setControllerHideDuringAds(boolean paramBoolean)
  {
    this.T3 = paramBoolean;
  }
  
  public void setControllerHideOnTouch(boolean paramBoolean)
  {
    g.i(this.p2);
    this.U3 = paramBoolean;
    I();
  }
  
  public void setControllerOnFullScreenModeChangedListener(@Nullable StyledPlayerControlView.d paramd)
  {
    g.i(this.p2);
    this.p2.setOnFullScreenModeChangedListener(paramd);
  }
  
  public void setControllerShowTimeoutMs(int paramInt)
  {
    g.i(this.p2);
    this.R3 = paramInt;
    if (this.p2.e0()) {
      D();
    }
  }
  
  public void setControllerVisibilityListener(@Nullable StyledPlayerControlView.m paramm)
  {
    g.i(this.p2);
    StyledPlayerControlView.m localm = this.K3;
    if (localm == paramm) {
      return;
    }
    if (localm != null) {
      this.p2.o0(localm);
    }
    this.K3 = paramm;
    if (paramm != null) {
      this.p2.R(paramm);
    }
  }
  
  public void setCustomErrorMessage(@Nullable CharSequence paramCharSequence)
  {
    boolean bool;
    if (this.p1 != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    this.Q3 = paramCharSequence;
    K();
  }
  
  public void setDefaultArtwork(@Nullable Drawable paramDrawable)
  {
    if (this.M3 != paramDrawable)
    {
      this.M3 = paramDrawable;
      L(false);
    }
  }
  
  public void setErrorMessageProvider(@Nullable n<? super PlaybackException> paramn)
  {
    if (this.P3 != paramn)
    {
      this.P3 = paramn;
      K();
    }
  }
  
  public void setKeepContentOnPlayerReset(boolean paramBoolean)
  {
    if (this.O3 != paramBoolean)
    {
      this.O3 = paramBoolean;
      L(false);
    }
  }
  
  public void setPlayer(@Nullable u1 paramu1)
  {
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    if ((paramu1 != null) && (paramu1.x() != Looper.getMainLooper())) {
      bool = false;
    } else {
      bool = true;
    }
    g.a(bool);
    u1 localu1 = this.I3;
    if (localu1 == paramu1) {
      return;
    }
    if (localu1 != null)
    {
      localu1.i(this.c);
      localObject = this.q;
      if ((localObject instanceof TextureView)) {
        localu1.I((TextureView)localObject);
      } else if ((localObject instanceof SurfaceView)) {
        localu1.P((SurfaceView)localObject);
      }
    }
    Object localObject = this.z;
    if (localObject != null) {
      ((SubtitleView)localObject).setCues(null);
    }
    this.I3 = paramu1;
    if (N()) {
      this.p2.setPlayer(paramu1);
    }
    H();
    K();
    L(true);
    if (paramu1 != null)
    {
      if (paramu1.s(26))
      {
        localObject = this.q;
        if ((localObject instanceof TextureView)) {
          paramu1.z((TextureView)localObject);
        } else if ((localObject instanceof SurfaceView)) {
          paramu1.k((SurfaceView)localObject);
        }
        G();
      }
      if ((this.z != null) && (paramu1.s(27))) {
        this.z.setCues(paramu1.q());
      }
      paramu1.N(this.c);
      x(false);
    }
    else
    {
      u();
    }
  }
  
  public void setRepeatToggleModes(int paramInt)
  {
    g.i(this.p2);
    this.p2.setRepeatToggleModes(paramInt);
  }
  
  public void setResizeMode(int paramInt)
  {
    g.i(this.d);
    this.d.setResizeMode(paramInt);
  }
  
  public void setShowBuffering(int paramInt)
  {
    if (this.N3 != paramInt)
    {
      this.N3 = paramInt;
      H();
    }
  }
  
  public void setShowFastForwardButton(boolean paramBoolean)
  {
    g.i(this.p2);
    this.p2.setShowFastForwardButton(paramBoolean);
  }
  
  public void setShowMultiWindowTimeBar(boolean paramBoolean)
  {
    g.i(this.p2);
    this.p2.setShowMultiWindowTimeBar(paramBoolean);
  }
  
  public void setShowNextButton(boolean paramBoolean)
  {
    g.i(this.p2);
    this.p2.setShowNextButton(paramBoolean);
  }
  
  public void setShowPreviousButton(boolean paramBoolean)
  {
    g.i(this.p2);
    this.p2.setShowPreviousButton(paramBoolean);
  }
  
  public void setShowRewindButton(boolean paramBoolean)
  {
    g.i(this.p2);
    this.p2.setShowRewindButton(paramBoolean);
  }
  
  public void setShowShuffleButton(boolean paramBoolean)
  {
    g.i(this.p2);
    this.p2.setShowShuffleButton(paramBoolean);
  }
  
  public void setShowSubtitleButton(boolean paramBoolean)
  {
    g.i(this.p2);
    this.p2.setShowSubtitleButton(paramBoolean);
  }
  
  public void setShowVrButton(boolean paramBoolean)
  {
    g.i(this.p2);
    this.p2.setShowVrButton(paramBoolean);
  }
  
  public void setShutterBackgroundColor(int paramInt)
  {
    View localView = this.f;
    if (localView != null) {
      localView.setBackgroundColor(paramInt);
    }
  }
  
  public void setUseArtwork(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && (this.y == null)) {
      bool = false;
    } else {
      bool = true;
    }
    g.g(bool);
    if (this.L3 != paramBoolean)
    {
      this.L3 = paramBoolean;
      L(false);
    }
  }
  
  public void setUseController(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && (this.p2 == null)) {
      bool = false;
    } else {
      bool = true;
    }
    g.g(bool);
    if (this.J3 == paramBoolean) {
      return;
    }
    this.J3 = paramBoolean;
    if (N())
    {
      this.p2.setPlayer(this.I3);
    }
    else
    {
      StyledPlayerControlView localStyledPlayerControlView = this.p2;
      if (localStyledPlayerControlView != null)
      {
        localStyledPlayerControlView.a0();
        this.p2.setPlayer(null);
      }
    }
    I();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    View localView = this.q;
    if ((localView instanceof SurfaceView)) {
      localView.setVisibility(paramInt);
    }
  }
  
  public void u()
  {
    StyledPlayerControlView localStyledPlayerControlView = this.p2;
    if (localStyledPlayerControlView != null) {
      localStyledPlayerControlView.a0();
    }
  }
  
  protected void y(@Nullable AspectRatioFrameLayout paramAspectRatioFrameLayout, float paramFloat)
  {
    if (paramAspectRatioFrameLayout != null) {
      paramAspectRatioFrameLayout.setAspectRatio(paramFloat);
    }
  }
  
  private final class a
    implements u1.e, View.OnLayoutChangeListener, View.OnClickListener, StyledPlayerControlView.m
  {
    private final j2.b c = new j2.b();
    @Nullable
    private Object d;
    
    public a() {}
    
    public void B(List<c> paramList)
    {
      if (StyledPlayerView.a(StyledPlayerView.this) != null) {
        StyledPlayerView.a(StyledPlayerView.this).B(paramList);
      }
    }
    
    public void G(TrackGroupArray paramTrackGroupArray, k paramk)
    {
      u1 localu1 = (u1)g.e(StyledPlayerView.h(StyledPlayerView.this));
      paramTrackGroupArray = localu1.w();
      if (paramTrackGroupArray.q())
      {
        this.d = null;
      }
      else if (!localu1.u().c())
      {
        this.d = paramTrackGroupArray.g(localu1.H(), this.c, true).c;
      }
      else
      {
        paramk = this.d;
        if (paramk != null)
        {
          int i = paramTrackGroupArray.b(paramk);
          if (i != -1)
          {
            i = paramTrackGroupArray.f(i, this.c).d;
            if (localu1.m() == i) {
              return;
            }
          }
          this.d = null;
        }
      }
      StyledPlayerView.i(StyledPlayerView.this, false);
    }
    
    public void b(int paramInt)
    {
      StyledPlayerView.f(StyledPlayerView.this);
    }
    
    public void c(z paramz)
    {
      StyledPlayerView.b(StyledPlayerView.this);
    }
    
    public void d0(boolean paramBoolean, int paramInt)
    {
      StyledPlayerView.j(StyledPlayerView.this);
      StyledPlayerView.l(StyledPlayerView.this);
    }
    
    public void e(u1.f paramf1, u1.f paramf2, int paramInt)
    {
      if ((StyledPlayerView.m(StyledPlayerView.this)) && (StyledPlayerView.n(StyledPlayerView.this))) {
        StyledPlayerView.this.u();
      }
    }
    
    public void onClick(View paramView)
    {
      StyledPlayerView.e(StyledPlayerView.this);
    }
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      StyledPlayerView.d((TextureView)paramView, StyledPlayerView.c(StyledPlayerView.this));
    }
    
    public void q(int paramInt)
    {
      StyledPlayerView.j(StyledPlayerView.this);
      StyledPlayerView.k(StyledPlayerView.this);
      StyledPlayerView.l(StyledPlayerView.this);
    }
    
    public void z()
    {
      if (StyledPlayerView.g(StyledPlayerView.this) != null) {
        StyledPlayerView.g(StyledPlayerView.this).setVisibility(4);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\StyledPlayerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */