package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.j2.b;
import com.google.android.exoplayer2.j2.c;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.u1.d;
import com.google.android.exoplayer2.u1.e;
import com.google.android.exoplayer2.util.f0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.x0;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerControlView
  extends FrameLayout
{
  @Nullable
  private final TextView H3;
  @Nullable
  private final TextView I3;
  @Nullable
  private final y0 J3;
  private final StringBuilder K3;
  private final Formatter L3;
  private final j2.b M3;
  private final j2.c N3;
  private final Runnable O3;
  private final Runnable P3;
  private final Drawable Q3;
  private final Drawable R3;
  private final Drawable S3;
  private final String T3;
  private final String U3;
  private final String V3;
  private final Drawable W3;
  private final Drawable X3;
  private final float Y3;
  private final float Z3;
  private final String a4;
  private final String b4;
  private final b c;
  @Nullable
  private u1 c4;
  private final CopyOnWriteArrayList<d> d;
  private x0 d4;
  @Nullable
  private c e4;
  @Nullable
  private final View f;
  private boolean f4;
  private boolean g4;
  private boolean h4;
  private boolean i4;
  private int j4;
  private int k4;
  private int l4;
  private boolean m4;
  private boolean n4;
  private boolean o4;
  @Nullable
  private final View p0;
  @Nullable
  private final ImageView p1;
  @Nullable
  private final ImageView p2;
  @Nullable
  private final View p3;
  private boolean p4;
  @Nullable
  private final View q;
  private boolean q4;
  private long r4;
  private long[] s4;
  private boolean[] t4;
  private long[] u4;
  private boolean[] v4;
  private long w4;
  @Nullable
  private final View x;
  @Nullable
  private final View y;
  @Nullable
  private final View z;
  
  static
  {
    h1.a("goog.exo.ui");
  }
  
  public PlayerControlView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PlayerControlView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PlayerControlView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, paramAttributeSet);
  }
  
  public PlayerControlView(Context paramContext, @Nullable AttributeSet paramAttributeSet1, int paramInt, @Nullable AttributeSet paramAttributeSet2)
  {
    super(paramContext, paramAttributeSet1, paramInt);
    int i = p0.exo_player_control_view;
    this.j4 = 5000;
    this.l4 = 0;
    this.k4 = 200;
    this.r4 = -9223372036854775807L;
    this.m4 = true;
    this.n4 = true;
    this.o4 = true;
    this.p4 = true;
    this.q4 = false;
    paramInt = i;
    if (paramAttributeSet2 != null) {
      paramAttributeSet1 = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet2, t0.PlayerControlView, 0, 0);
    }
    try
    {
      this.j4 = paramAttributeSet1.getInt(t0.PlayerControlView_show_timeout, this.j4);
      paramInt = paramAttributeSet1.getResourceId(t0.PlayerControlView_controller_layout_id, i);
      this.l4 = E(paramAttributeSet1, this.l4);
      this.m4 = paramAttributeSet1.getBoolean(t0.PlayerControlView_show_rewind_button, this.m4);
      this.n4 = paramAttributeSet1.getBoolean(t0.PlayerControlView_show_fastforward_button, this.n4);
      this.o4 = paramAttributeSet1.getBoolean(t0.PlayerControlView_show_previous_button, this.o4);
      this.p4 = paramAttributeSet1.getBoolean(t0.PlayerControlView_show_next_button, this.p4);
      this.q4 = paramAttributeSet1.getBoolean(t0.PlayerControlView_show_shuffle_button, this.q4);
      setTimeBarMinUpdateInterval(paramAttributeSet1.getInt(t0.PlayerControlView_time_bar_min_update_interval, this.k4));
      paramAttributeSet1.recycle();
    }
    finally
    {
      paramAttributeSet1.recycle();
    }
    this.M3 = new j2.b();
    this.N3 = new j2.c();
    paramAttributeSet1 = new StringBuilder();
    this.K3 = paramAttributeSet1;
    this.L3 = new Formatter(paramAttributeSet1, Locale.getDefault());
    this.s4 = new long[0];
    this.t4 = new boolean[0];
    this.u4 = new long[0];
    this.v4 = new boolean[0];
    paramAttributeSet1 = new b(null);
    this.c = paramAttributeSet1;
    this.d4 = new com.google.android.exoplayer2.y0();
    this.O3 = new d(this);
    this.P3 = new a(this);
    LayoutInflater.from(paramContext).inflate(paramInt, this);
    setDescendantFocusability(262144);
    paramInt = n0.exo_progress;
    Object localObject = (y0)findViewById(paramInt);
    View localView = findViewById(n0.exo_progress_placeholder);
    if (localObject != null)
    {
      this.J3 = ((y0)localObject);
    }
    else if (localView != null)
    {
      paramAttributeSet2 = new DefaultTimeBar(paramContext, null, 0, paramAttributeSet2);
      paramAttributeSet2.setId(paramInt);
      paramAttributeSet2.setLayoutParams(localView.getLayoutParams());
      localObject = (ViewGroup)localView.getParent();
      paramInt = ((ViewGroup)localObject).indexOfChild(localView);
      ((ViewGroup)localObject).removeView(localView);
      ((ViewGroup)localObject).addView(paramAttributeSet2, paramInt);
      this.J3 = paramAttributeSet2;
    }
    else
    {
      this.J3 = null;
    }
    this.H3 = ((TextView)findViewById(n0.exo_duration));
    this.I3 = ((TextView)findViewById(n0.exo_position));
    paramAttributeSet2 = this.J3;
    if (paramAttributeSet2 != null) {
      paramAttributeSet2.a(paramAttributeSet1);
    }
    paramAttributeSet2 = findViewById(n0.exo_play);
    this.x = paramAttributeSet2;
    if (paramAttributeSet2 != null) {
      paramAttributeSet2.setOnClickListener(paramAttributeSet1);
    }
    paramAttributeSet2 = findViewById(n0.exo_pause);
    this.y = paramAttributeSet2;
    if (paramAttributeSet2 != null) {
      paramAttributeSet2.setOnClickListener(paramAttributeSet1);
    }
    paramAttributeSet2 = findViewById(n0.exo_prev);
    this.f = paramAttributeSet2;
    if (paramAttributeSet2 != null) {
      paramAttributeSet2.setOnClickListener(paramAttributeSet1);
    }
    paramAttributeSet2 = findViewById(n0.exo_next);
    this.q = paramAttributeSet2;
    if (paramAttributeSet2 != null) {
      paramAttributeSet2.setOnClickListener(paramAttributeSet1);
    }
    paramAttributeSet2 = findViewById(n0.exo_rew);
    this.p0 = paramAttributeSet2;
    if (paramAttributeSet2 != null) {
      paramAttributeSet2.setOnClickListener(paramAttributeSet1);
    }
    paramAttributeSet2 = findViewById(n0.exo_ffwd);
    this.z = paramAttributeSet2;
    if (paramAttributeSet2 != null) {
      paramAttributeSet2.setOnClickListener(paramAttributeSet1);
    }
    paramAttributeSet2 = (ImageView)findViewById(n0.exo_repeat_toggle);
    this.p1 = paramAttributeSet2;
    if (paramAttributeSet2 != null) {
      paramAttributeSet2.setOnClickListener(paramAttributeSet1);
    }
    paramAttributeSet2 = (ImageView)findViewById(n0.exo_shuffle);
    this.p2 = paramAttributeSet2;
    if (paramAttributeSet2 != null) {
      paramAttributeSet2.setOnClickListener(paramAttributeSet1);
    }
    paramAttributeSet1 = findViewById(n0.exo_vr);
    this.p3 = paramAttributeSet1;
    setShowVrButton(false);
    R(false, false, paramAttributeSet1);
    paramContext = paramContext.getResources();
    this.Y3 = (paramContext.getInteger(o0.exo_media_button_opacity_percentage_enabled) / 100.0F);
    this.Z3 = (paramContext.getInteger(o0.exo_media_button_opacity_percentage_disabled) / 100.0F);
    this.Q3 = paramContext.getDrawable(l0.exo_controls_repeat_off);
    this.R3 = paramContext.getDrawable(l0.exo_controls_repeat_one);
    this.S3 = paramContext.getDrawable(l0.exo_controls_repeat_all);
    this.W3 = paramContext.getDrawable(l0.exo_controls_shuffle_on);
    this.X3 = paramContext.getDrawable(l0.exo_controls_shuffle_off);
    this.T3 = paramContext.getString(r0.exo_controls_repeat_off_description);
    this.U3 = paramContext.getString(r0.exo_controls_repeat_one_description);
    this.V3 = paramContext.getString(r0.exo_controls_repeat_all_description);
    this.a4 = paramContext.getString(r0.exo_controls_shuffle_on_description);
    this.b4 = paramContext.getString(r0.exo_controls_shuffle_off_description);
  }
  
  private void B(u1 paramu1)
  {
    this.d4.l(paramu1, false);
  }
  
  private void C(u1 paramu1)
  {
    int i = paramu1.getPlaybackState();
    if (i == 1) {
      this.d4.h(paramu1);
    } else if (i == 4) {
      M(paramu1, paramu1.m(), -9223372036854775807L);
    }
    this.d4.l(paramu1, true);
  }
  
  private void D(u1 paramu1)
  {
    int i = paramu1.getPlaybackState();
    if ((i != 1) && (i != 4) && (paramu1.E())) {
      B(paramu1);
    } else {
      C(paramu1);
    }
  }
  
  private static int E(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getInt(t0.PlayerControlView_repeat_toggle_modes, paramInt);
  }
  
  private void G()
  {
    removeCallbacks(this.P3);
    if (this.j4 > 0)
    {
      long l = SystemClock.uptimeMillis();
      int i = this.j4;
      this.r4 = (l + i);
      if (this.f4) {
        postDelayed(this.P3, i);
      }
    }
    else
    {
      this.r4 = -9223372036854775807L;
    }
  }
  
  @SuppressLint({"InlinedApi"})
  private static boolean H(int paramInt)
  {
    boolean bool;
    if ((paramInt != 90) && (paramInt != 89) && (paramInt != 85) && (paramInt != 79) && (paramInt != 126) && (paramInt != 127) && (paramInt != 87) && (paramInt != 88)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void L()
  {
    boolean bool = O();
    View localView;
    if (!bool)
    {
      localView = this.x;
      if (localView != null)
      {
        localView.requestFocus();
        return;
      }
    }
    if (bool)
    {
      localView = this.y;
      if (localView != null) {
        localView.requestFocus();
      }
    }
  }
  
  private boolean M(u1 paramu1, int paramInt, long paramLong)
  {
    return this.d4.c(paramu1, paramInt, paramLong);
  }
  
  private void N(u1 paramu1, long paramLong)
  {
    j2 localj2 = paramu1.w();
    if ((this.h4) && (!localj2.q()))
    {
      int i = localj2.p();
      for (j = 0;; j++)
      {
        long l = localj2.n(j, this.N3).d();
        if (paramLong < l) {
          break;
        }
        if (j == i - 1)
        {
          paramLong = l;
          break;
        }
        paramLong -= l;
      }
    }
    int j = paramu1.m();
    M(paramu1, j, paramLong);
    U();
  }
  
  private boolean O()
  {
    u1 localu1 = this.c4;
    boolean bool = true;
    if ((localu1 == null) || (localu1.getPlaybackState() == 4) || (this.c4.getPlaybackState() == 1) || (!this.c4.E())) {
      bool = false;
    }
    return bool;
  }
  
  private void Q()
  {
    T();
    S();
    V();
    W();
    X();
  }
  
  private void R(boolean paramBoolean1, boolean paramBoolean2, @Nullable View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setEnabled(paramBoolean2);
    float f1;
    if (paramBoolean2) {
      f1 = this.Y3;
    } else {
      f1 = this.Z3;
    }
    paramView.setAlpha(f1);
    int i;
    if (paramBoolean1) {
      i = 0;
    } else {
      i = 8;
    }
    paramView.setVisibility(i);
  }
  
  private void S()
  {
    if ((I()) && (this.f4))
    {
      Object localObject = this.c4;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3;
      boolean bool4;
      boolean bool5;
      if (localObject != null)
      {
        bool3 = ((u1)localObject).s(4);
        bool4 = ((u1)localObject).s(6);
        if ((((u1)localObject).s(10)) && (this.d4.g())) {
          bool5 = true;
        } else {
          bool5 = false;
        }
        bool1 = bool2;
        if (((u1)localObject).s(11))
        {
          bool1 = bool2;
          if (this.d4.k()) {
            bool1 = true;
          }
        }
        boolean bool6 = ((u1)localObject).s(8);
        bool2 = bool1;
        bool1 = bool4;
        bool4 = bool6;
      }
      else
      {
        bool2 = false;
        bool4 = false;
        bool3 = false;
        bool5 = false;
      }
      R(this.o4, bool1, this.f);
      R(this.m4, bool5, this.p0);
      R(this.n4, bool2, this.z);
      R(this.p4, bool4, this.q);
      localObject = this.J3;
      if (localObject != null) {
        ((y0)localObject).setEnabled(bool3);
      }
    }
  }
  
  private void T()
  {
    if ((I()) && (this.f4))
    {
      boolean bool = O();
      View localView = this.x;
      int i = 8;
      int j = 1;
      int k;
      if (localView != null)
      {
        if ((bool) && (localView.isFocused())) {
          k = 1;
        } else {
          k = 0;
        }
        m = k | 0x0;
        localView = this.x;
        if (bool) {
          k = 8;
        } else {
          k = 0;
        }
        localView.setVisibility(k);
        k = m;
      }
      else
      {
        k = 0;
      }
      localView = this.y;
      int m = k;
      if (localView != null)
      {
        if ((!bool) && (localView.isFocused())) {
          m = j;
        } else {
          m = 0;
        }
        m = k | m;
        localView = this.y;
        k = i;
        if (bool) {
          k = 0;
        }
        localView.setVisibility(k);
      }
      if (m != 0) {
        L();
      }
    }
  }
  
  private void U()
  {
    if ((I()) && (this.f4))
    {
      u1 localu1 = this.c4;
      long l1 = 0L;
      long l2;
      if (localu1 != null)
      {
        l1 = this.w4 + localu1.M();
        l2 = this.w4 + localu1.R();
      }
      else
      {
        l2 = 0L;
      }
      Object localObject = this.I3;
      if ((localObject != null) && (!this.i4)) {
        ((TextView)localObject).setText(com.google.android.exoplayer2.util.o0.Z(this.K3, this.L3, l1));
      }
      localObject = this.J3;
      if (localObject != null)
      {
        ((y0)localObject).setPosition(l1);
        this.J3.setBufferedPosition(l2);
      }
      localObject = this.e4;
      if (localObject != null) {
        ((c)localObject).a(l1, l2);
      }
      removeCallbacks(this.O3);
      int i;
      if (localu1 == null) {
        i = 1;
      } else {
        i = localu1.getPlaybackState();
      }
      long l3 = 1000L;
      if ((localu1 != null) && (localu1.O()))
      {
        localObject = this.J3;
        if (localObject != null) {
          l2 = ((y0)localObject).getPreferredUpdateDelay();
        } else {
          l2 = 1000L;
        }
        l2 = Math.min(l2, 1000L - l1 % 1000L);
        float f1 = localu1.c().c;
        l1 = l3;
        if (f1 > 0.0F) {
          l1 = ((float)l2 / f1);
        }
        l1 = com.google.android.exoplayer2.util.o0.q(l1, this.k4, 1000L);
        postDelayed(this.O3, l1);
      }
      else if ((i != 4) && (i != 1))
      {
        postDelayed(this.O3, 1000L);
      }
    }
  }
  
  private void V()
  {
    if ((I()) && (this.f4))
    {
      ImageView localImageView = this.p1;
      if (localImageView != null)
      {
        if (this.l4 == 0)
        {
          R(false, false, localImageView);
          return;
        }
        u1 localu1 = this.c4;
        if (localu1 == null)
        {
          R(true, false, localImageView);
          this.p1.setImageDrawable(this.Q3);
          this.p1.setContentDescription(this.T3);
          return;
        }
        R(true, true, localImageView);
        int i = localu1.getRepeatMode();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2)
            {
              this.p1.setImageDrawable(this.S3);
              this.p1.setContentDescription(this.V3);
            }
          }
          else
          {
            this.p1.setImageDrawable(this.R3);
            this.p1.setContentDescription(this.U3);
          }
        }
        else
        {
          this.p1.setImageDrawable(this.Q3);
          this.p1.setContentDescription(this.T3);
        }
        this.p1.setVisibility(0);
      }
    }
  }
  
  private void W()
  {
    if ((I()) && (this.f4))
    {
      Object localObject = this.p2;
      if (localObject != null)
      {
        u1 localu1 = this.c4;
        if (!this.q4)
        {
          R(false, false, (View)localObject);
        }
        else if (localu1 == null)
        {
          R(true, false, (View)localObject);
          this.p2.setImageDrawable(this.X3);
          this.p2.setContentDescription(this.b4);
        }
        else
        {
          R(true, true, (View)localObject);
          ImageView localImageView = this.p2;
          if (localu1.Q()) {
            localObject = this.W3;
          } else {
            localObject = this.X3;
          }
          localImageView.setImageDrawable((Drawable)localObject);
          localImageView = this.p2;
          if (localu1.Q()) {
            localObject = this.a4;
          } else {
            localObject = this.b4;
          }
          localImageView.setContentDescription((CharSequence)localObject);
        }
      }
    }
  }
  
  private void X()
  {
    Object localObject1 = this.c4;
    if (localObject1 == null) {
      return;
    }
    boolean bool;
    if ((this.g4) && (z(((u1)localObject1).w(), this.N3))) {
      bool = true;
    } else {
      bool = false;
    }
    this.h4 = bool;
    long l1 = 0L;
    this.w4 = 0L;
    Object localObject2 = ((u1)localObject1).w();
    int i;
    int j;
    int m;
    if (!((j2)localObject2).q())
    {
      i = ((u1)localObject1).m();
      bool = this.h4;
      if (bool) {
        j = 0;
      } else {
        j = i;
      }
      int k;
      if (bool) {
        k = ((j2)localObject2).p() - 1;
      } else {
        k = i;
      }
      l1 = 0L;
      m = 0;
      while (j <= k)
      {
        if (j == i) {
          this.w4 = w0.e(l1);
        }
        ((j2)localObject2).n(j, this.N3);
        localObject1 = this.N3;
        if (((j2.c)localObject1).r == -9223372036854775807L)
        {
          g.g(this.h4 ^ true);
          break;
        }
        for (int n = ((j2.c)localObject1).s;; n++)
        {
          localObject1 = this.N3;
          if (n > ((j2.c)localObject1).t) {
            break;
          }
          ((j2)localObject2).f(n, this.M3);
          int i1 = this.M3.n();
          int i2 = this.M3.c();
          while (i1 < i2)
          {
            long l2 = this.M3.f(i1);
            long l3 = l2;
            if (l2 == Long.MIN_VALUE)
            {
              l3 = this.M3.e;
              if (l3 == -9223372036854775807L)
              {
                i3 = m;
                break label399;
              }
            }
            l3 += this.M3.m();
            int i3 = m;
            if (l3 >= 0L)
            {
              localObject1 = this.s4;
              if (m == localObject1.length)
              {
                if (localObject1.length == 0) {
                  i3 = 1;
                } else {
                  i3 = localObject1.length * 2;
                }
                this.s4 = Arrays.copyOf((long[])localObject1, i3);
                this.t4 = Arrays.copyOf(this.t4, i3);
              }
              this.s4[m] = w0.e(l1 + l3);
              this.t4[m] = this.M3.o(i1);
              i3 = m + 1;
            }
            label399:
            i1++;
            m = i3;
          }
        }
        l1 += ((j2.c)localObject1).r;
        j++;
      }
    }
    else
    {
      m = 0;
    }
    l1 = w0.e(l1);
    localObject2 = this.H3;
    if (localObject2 != null) {
      ((TextView)localObject2).setText(com.google.android.exoplayer2.util.o0.Z(this.K3, this.L3, l1));
    }
    localObject2 = this.J3;
    if (localObject2 != null)
    {
      ((y0)localObject2).setDuration(l1);
      i = this.u4.length;
      j = m + i;
      localObject2 = this.s4;
      if (j > localObject2.length)
      {
        this.s4 = Arrays.copyOf((long[])localObject2, j);
        this.t4 = Arrays.copyOf(this.t4, j);
      }
      System.arraycopy(this.u4, 0, this.s4, m, i);
      System.arraycopy(this.v4, 0, this.t4, m, i);
      this.J3.b(this.s4, this.t4, j);
    }
    U();
  }
  
  private static boolean z(j2 paramj2, j2.c paramc)
  {
    if (paramj2.p() > 100) {
      return false;
    }
    int i = paramj2.p();
    for (int j = 0; j < i; j++) {
      if (paramj2.n(j, paramc).r == -9223372036854775807L) {
        return false;
      }
    }
    return true;
  }
  
  public boolean A(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    u1 localu1 = this.c4;
    if ((localu1 != null) && (H(i)))
    {
      if (paramKeyEvent.getAction() == 0) {
        if (i == 90)
        {
          if (localu1.getPlaybackState() != 4) {
            this.d4.f(localu1);
          }
        }
        else if (i == 89) {
          this.d4.b(localu1);
        } else if (paramKeyEvent.getRepeatCount() == 0) {
          if ((i != 79) && (i != 85))
          {
            if (i != 87)
            {
              if (i != 88)
              {
                if (i != 126)
                {
                  if (i == 127) {
                    B(localu1);
                  }
                }
                else {
                  C(localu1);
                }
              }
              else {
                this.d4.i(localu1);
              }
            }
            else {
              this.d4.j(localu1);
            }
          }
          else {
            D(localu1);
          }
        }
      }
      return true;
    }
    return false;
  }
  
  public void F()
  {
    if (I())
    {
      setVisibility(8);
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).b(getVisibility());
      }
      removeCallbacks(this.O3);
      removeCallbacks(this.P3);
      this.r4 = -9223372036854775807L;
    }
  }
  
  public boolean I()
  {
    boolean bool;
    if (getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void K(d paramd)
  {
    this.d.remove(paramd);
  }
  
  public void P()
  {
    if (!I())
    {
      setVisibility(0);
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).b(getVisibility());
      }
      Q();
      L();
    }
    G();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((!A(paramKeyEvent)) && (!super.dispatchKeyEvent(paramKeyEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      removeCallbacks(this.P3);
    } else if (paramMotionEvent.getAction() == 1) {
      G();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @Nullable
  public u1 getPlayer()
  {
    return this.c4;
  }
  
  public int getRepeatToggleModes()
  {
    return this.l4;
  }
  
  public boolean getShowShuffleButton()
  {
    return this.q4;
  }
  
  public int getShowTimeoutMs()
  {
    return this.j4;
  }
  
  public boolean getShowVrButton()
  {
    View localView = this.p3;
    boolean bool;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.f4 = true;
    long l = this.r4;
    if (l != -9223372036854775807L)
    {
      l -= SystemClock.uptimeMillis();
      if (l <= 0L) {
        F();
      } else {
        postDelayed(this.P3, l);
      }
    }
    else if (I())
    {
      G();
    }
    Q();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.f4 = false;
    removeCallbacks(this.O3);
    removeCallbacks(this.P3);
  }
  
  @Deprecated
  public void setControlDispatcher(x0 paramx0)
  {
    if (this.d4 != paramx0)
    {
      this.d4 = paramx0;
      S();
    }
  }
  
  public void setPlayer(@Nullable u1 paramu1)
  {
    Looper localLooper = Looper.myLooper();
    Object localObject = Looper.getMainLooper();
    boolean bool1 = true;
    if (localLooper == localObject) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.g(bool2);
    boolean bool2 = bool1;
    if (paramu1 != null) {
      if (paramu1.x() == Looper.getMainLooper()) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    g.a(bool2);
    localObject = this.c4;
    if (localObject == paramu1) {
      return;
    }
    if (localObject != null) {
      ((u1)localObject).i(this.c);
    }
    this.c4 = paramu1;
    if (paramu1 != null) {
      paramu1.N(this.c);
    }
    Q();
  }
  
  public void setProgressUpdateListener(@Nullable c paramc)
  {
    this.e4 = paramc;
  }
  
  public void setRepeatToggleModes(int paramInt)
  {
    this.l4 = paramInt;
    u1 localu1 = this.c4;
    if (localu1 != null)
    {
      int i = localu1.getRepeatMode();
      if ((paramInt == 0) && (i != 0)) {
        this.d4.e(this.c4, 0);
      } else if ((paramInt == 1) && (i == 2)) {
        this.d4.e(this.c4, 1);
      } else if ((paramInt == 2) && (i == 1)) {
        this.d4.e(this.c4, 2);
      }
    }
    V();
  }
  
  public void setShowFastForwardButton(boolean paramBoolean)
  {
    this.n4 = paramBoolean;
    S();
  }
  
  public void setShowMultiWindowTimeBar(boolean paramBoolean)
  {
    this.g4 = paramBoolean;
    X();
  }
  
  public void setShowNextButton(boolean paramBoolean)
  {
    this.p4 = paramBoolean;
    S();
  }
  
  public void setShowPreviousButton(boolean paramBoolean)
  {
    this.o4 = paramBoolean;
    S();
  }
  
  public void setShowRewindButton(boolean paramBoolean)
  {
    this.m4 = paramBoolean;
    S();
  }
  
  public void setShowShuffleButton(boolean paramBoolean)
  {
    this.q4 = paramBoolean;
    W();
  }
  
  public void setShowTimeoutMs(int paramInt)
  {
    this.j4 = paramInt;
    if (I()) {
      G();
    }
  }
  
  public void setShowVrButton(boolean paramBoolean)
  {
    View localView = this.p3;
    if (localView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
  
  public void setTimeBarMinUpdateInterval(int paramInt)
  {
    this.k4 = com.google.android.exoplayer2.util.o0.p(paramInt, 16, 1000);
  }
  
  public void setVrButtonListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    View localView = this.p3;
    if (localView != null)
    {
      localView.setOnClickListener(paramOnClickListener);
      boolean bool1 = getShowVrButton();
      boolean bool2;
      if (paramOnClickListener != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      R(bool1, bool2, this.p3);
    }
  }
  
  public void y(d paramd)
  {
    g.e(paramd);
    this.d.add(paramd);
  }
  
  private final class b
    implements u1.e, y0.a, View.OnClickListener
  {
    private b() {}
    
    public void S(u1 paramu1, u1.d paramd)
    {
      if (paramd.b(new int[] { 5, 6 })) {
        PlayerControlView.a(PlayerControlView.this);
      }
      if (paramd.b(new int[] { 5, 6, 8 })) {
        PlayerControlView.l(PlayerControlView.this);
      }
      if (paramd.a(9)) {
        PlayerControlView.r(PlayerControlView.this);
      }
      if (paramd.a(10)) {
        PlayerControlView.s(PlayerControlView.this);
      }
      if (paramd.b(new int[] { 9, 10, 12, 0 })) {
        PlayerControlView.t(PlayerControlView.this);
      }
      if (paramd.b(new int[] { 12, 0 })) {
        PlayerControlView.u(PlayerControlView.this);
      }
    }
    
    public void b(y0 paramy0, long paramLong)
    {
      if (PlayerControlView.w(PlayerControlView.this) != null) {
        PlayerControlView.w(PlayerControlView.this).setText(com.google.android.exoplayer2.util.o0.Z(PlayerControlView.x(PlayerControlView.this), PlayerControlView.b(PlayerControlView.this), paramLong));
      }
    }
    
    public void h(y0 paramy0, long paramLong, boolean paramBoolean)
    {
      PlayerControlView.v(PlayerControlView.this, false);
      if ((!paramBoolean) && (PlayerControlView.c(PlayerControlView.this) != null))
      {
        paramy0 = PlayerControlView.this;
        PlayerControlView.d(paramy0, PlayerControlView.c(paramy0), paramLong);
      }
    }
    
    public void i(y0 paramy0, long paramLong)
    {
      PlayerControlView.v(PlayerControlView.this, true);
      if (PlayerControlView.w(PlayerControlView.this) != null) {
        PlayerControlView.w(PlayerControlView.this).setText(com.google.android.exoplayer2.util.o0.Z(PlayerControlView.x(PlayerControlView.this), PlayerControlView.b(PlayerControlView.this), paramLong));
      }
    }
    
    public void onClick(View paramView)
    {
      u1 localu1 = PlayerControlView.c(PlayerControlView.this);
      if (localu1 == null) {
        return;
      }
      if (PlayerControlView.e(PlayerControlView.this) == paramView) {
        PlayerControlView.f(PlayerControlView.this).j(localu1);
      } else if (PlayerControlView.g(PlayerControlView.this) == paramView) {
        PlayerControlView.f(PlayerControlView.this).i(localu1);
      } else if (PlayerControlView.h(PlayerControlView.this) == paramView)
      {
        if (localu1.getPlaybackState() != 4) {
          PlayerControlView.f(PlayerControlView.this).f(localu1);
        }
      }
      else if (PlayerControlView.i(PlayerControlView.this) == paramView) {
        PlayerControlView.f(PlayerControlView.this).b(localu1);
      } else if (PlayerControlView.j(PlayerControlView.this) == paramView) {
        PlayerControlView.k(PlayerControlView.this, localu1);
      } else if (PlayerControlView.m(PlayerControlView.this) == paramView) {
        PlayerControlView.n(PlayerControlView.this, localu1);
      } else if (PlayerControlView.o(PlayerControlView.this) == paramView) {
        PlayerControlView.f(PlayerControlView.this).e(localu1, f0.a(localu1.getRepeatMode(), PlayerControlView.p(PlayerControlView.this)));
      } else if (PlayerControlView.q(PlayerControlView.this) == paramView) {
        PlayerControlView.f(PlayerControlView.this).d(localu1, localu1.Q() ^ true);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(long paramLong1, long paramLong2);
  }
  
  public static abstract interface d
  {
    public abstract void b(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\PlayerControlView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */