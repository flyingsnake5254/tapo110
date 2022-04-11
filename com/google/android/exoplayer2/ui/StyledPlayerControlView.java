package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e1;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.j2.b;
import com.google.android.exoplayer2.j2.c;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters;
import com.google.android.exoplayer2.trackselection.i.a;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.u1.d;
import com.google.android.exoplayer2.u1.e;
import com.google.android.exoplayer2.util.f0;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.x0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

public class StyledPlayerControlView
  extends FrameLayout
{
  private long A4;
  private v0 B4;
  private Resources C4;
  private RecyclerView D4;
  private h E4;
  private e F4;
  private PopupWindow G4;
  @Nullable
  private final View H3;
  private boolean H4;
  @Nullable
  private final TextView I3;
  private int I4;
  @Nullable
  private final TextView J3;
  @Nullable
  private DefaultTrackSelector J4;
  @Nullable
  private final y0 K3;
  private l K4;
  private final StringBuilder L3;
  private l L4;
  private final Formatter M3;
  private z0 M4;
  private final j2.b N3;
  @Nullable
  private ImageView N4;
  private final j2.c O3;
  @Nullable
  private ImageView O4;
  private final Runnable P3;
  @Nullable
  private ImageView P4;
  private final Drawable Q3;
  @Nullable
  private View Q4;
  private final Drawable R3;
  @Nullable
  private View R4;
  private final Drawable S3;
  @Nullable
  private View S4;
  private final String T3;
  private final String U3;
  private final String V3;
  private final Drawable W3;
  private final Drawable X3;
  private final float Y3;
  private final float Z3;
  private final String a4;
  private final String b4;
  private final c c;
  private final Drawable c4;
  private final CopyOnWriteArrayList<m> d;
  private final Drawable d4;
  private final String e4;
  @Nullable
  private final View f;
  private final String f4;
  private final Drawable g4;
  private final Drawable h4;
  private final String i4;
  private final String j4;
  @Nullable
  private u1 k4;
  private x0 l4;
  @Nullable
  private f m4;
  @Nullable
  private d n4;
  private boolean o4;
  @Nullable
  private final TextView p0;
  @Nullable
  private final TextView p1;
  @Nullable
  private final ImageView p2;
  @Nullable
  private final ImageView p3;
  private boolean p4;
  @Nullable
  private final View q;
  private boolean q4;
  private boolean r4;
  private boolean s4;
  private int t4;
  private int u4;
  private int v4;
  private long[] w4;
  @Nullable
  private final View x;
  private boolean[] x4;
  @Nullable
  private final View y;
  private long[] y4;
  @Nullable
  private final View z;
  private boolean[] z4;
  
  static
  {
    h1.a("goog.exo.ui");
  }
  
  public StyledPlayerControlView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StyledPlayerControlView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StyledPlayerControlView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, paramAttributeSet);
  }
  
  public StyledPlayerControlView(Context paramContext, @Nullable AttributeSet paramAttributeSet1, int paramInt, @Nullable AttributeSet paramAttributeSet2)
  {
    super(paramContext, paramAttributeSet1, paramInt);
    paramInt = p0.exo_styled_player_control_view;
    this.t4 = 5000;
    this.v4 = 0;
    this.u4 = 200;
    if (paramAttributeSet2 != null) {
      paramAttributeSet1 = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet2, t0.StyledPlayerControlView, 0, 0);
    }
    boolean bool8;
    try
    {
      paramInt = paramAttributeSet1.getResourceId(t0.StyledPlayerControlView_controller_layout_id, paramInt);
      this.t4 = paramAttributeSet1.getInt(t0.StyledPlayerControlView_show_timeout, this.t4);
      this.v4 = Z(paramAttributeSet1, this.v4);
      bool1 = paramAttributeSet1.getBoolean(t0.StyledPlayerControlView_show_rewind_button, true);
      bool2 = paramAttributeSet1.getBoolean(t0.StyledPlayerControlView_show_fastforward_button, true);
      bool3 = paramAttributeSet1.getBoolean(t0.StyledPlayerControlView_show_previous_button, true);
      bool4 = paramAttributeSet1.getBoolean(t0.StyledPlayerControlView_show_next_button, true);
      bool5 = paramAttributeSet1.getBoolean(t0.StyledPlayerControlView_show_shuffle_button, false);
      bool6 = paramAttributeSet1.getBoolean(t0.StyledPlayerControlView_show_subtitle_button, false);
      bool7 = paramAttributeSet1.getBoolean(t0.StyledPlayerControlView_show_vr_button, false);
      setTimeBarMinUpdateInterval(paramAttributeSet1.getInt(t0.StyledPlayerControlView_time_bar_min_update_interval, this.u4));
      bool8 = paramAttributeSet1.getBoolean(t0.StyledPlayerControlView_animation_enabled, true);
      paramAttributeSet1.recycle();
    }
    finally
    {
      paramAttributeSet1.recycle();
    }
    boolean bool7 = false;
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = false;
    boolean bool6 = false;
    LayoutInflater.from(paramContext).inflate(paramInt, this);
    setDescendantFocusability(262144);
    Object localObject1 = new c(null);
    this.c = ((c)localObject1);
    this.d = new CopyOnWriteArrayList();
    this.N3 = new j2.b();
    this.O3 = new j2.c();
    paramAttributeSet1 = new StringBuilder();
    this.L3 = paramAttributeSet1;
    this.M3 = new Formatter(paramAttributeSet1, Locale.getDefault());
    this.w4 = new long[0];
    this.x4 = new boolean[0];
    this.y4 = new long[0];
    this.z4 = new boolean[0];
    this.l4 = new com.google.android.exoplayer2.y0();
    this.P3 = new m(this);
    this.I3 = ((TextView)findViewById(n0.exo_duration));
    this.J3 = ((TextView)findViewById(n0.exo_position));
    paramAttributeSet1 = (ImageView)findViewById(n0.exo_subtitle);
    this.N4 = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.setOnClickListener((View.OnClickListener)localObject1);
    }
    paramAttributeSet1 = (ImageView)findViewById(n0.exo_fullscreen);
    this.O4 = paramAttributeSet1;
    d0(paramAttributeSet1, new l(this));
    paramAttributeSet1 = (ImageView)findViewById(n0.exo_minimal_fullscreen);
    this.P4 = paramAttributeSet1;
    d0(paramAttributeSet1, new l(this));
    paramAttributeSet1 = findViewById(n0.exo_settings);
    this.Q4 = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.setOnClickListener((View.OnClickListener)localObject1);
    }
    paramAttributeSet1 = findViewById(n0.exo_playback_speed);
    this.R4 = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.setOnClickListener((View.OnClickListener)localObject1);
    }
    paramAttributeSet1 = findViewById(n0.exo_audio_track);
    this.S4 = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.setOnClickListener((View.OnClickListener)localObject1);
    }
    paramInt = n0.exo_progress;
    Object localObject2 = (y0)findViewById(paramInt);
    paramAttributeSet1 = findViewById(n0.exo_progress_placeholder);
    if (localObject2 != null)
    {
      this.K3 = ((y0)localObject2);
    }
    else if (paramAttributeSet1 != null)
    {
      paramAttributeSet2 = new DefaultTimeBar(paramContext, null, 0, paramAttributeSet2, s0.ExoStyledControls_TimeBar);
      paramAttributeSet2.setId(paramInt);
      paramAttributeSet2.setLayoutParams(paramAttributeSet1.getLayoutParams());
      localObject2 = (ViewGroup)paramAttributeSet1.getParent();
      paramInt = ((ViewGroup)localObject2).indexOfChild(paramAttributeSet1);
      ((ViewGroup)localObject2).removeView(paramAttributeSet1);
      ((ViewGroup)localObject2).addView(paramAttributeSet2, paramInt);
      this.K3 = paramAttributeSet2;
    }
    else
    {
      this.K3 = null;
    }
    paramAttributeSet1 = this.K3;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.a((y0.a)localObject1);
    }
    paramAttributeSet1 = findViewById(n0.exo_play_pause);
    this.x = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.setOnClickListener((View.OnClickListener)localObject1);
    }
    paramAttributeSet1 = findViewById(n0.exo_prev);
    this.f = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.setOnClickListener((View.OnClickListener)localObject1);
    }
    paramAttributeSet1 = findViewById(n0.exo_next);
    this.q = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.setOnClickListener((View.OnClickListener)localObject1);
    }
    Typeface localTypeface = ResourcesCompat.getFont(paramContext, m0.roboto_medium_numbers);
    localObject2 = findViewById(n0.exo_rew);
    if (localObject2 == null) {
      paramAttributeSet1 = (TextView)findViewById(n0.exo_rew_with_amount);
    } else {
      paramAttributeSet1 = null;
    }
    this.p1 = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.setTypeface(localTypeface);
    }
    paramAttributeSet2 = (AttributeSet)localObject2;
    if (localObject2 == null) {
      paramAttributeSet2 = paramAttributeSet1;
    }
    this.z = paramAttributeSet2;
    if (paramAttributeSet2 != null) {
      paramAttributeSet2.setOnClickListener((View.OnClickListener)localObject1);
    }
    localObject2 = findViewById(n0.exo_ffwd);
    if (localObject2 == null) {
      paramAttributeSet1 = (TextView)findViewById(n0.exo_ffwd_with_amount);
    } else {
      paramAttributeSet1 = null;
    }
    this.p0 = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.setTypeface(localTypeface);
    }
    paramAttributeSet2 = (AttributeSet)localObject2;
    if (localObject2 == null) {
      paramAttributeSet2 = paramAttributeSet1;
    }
    this.y = paramAttributeSet2;
    if (paramAttributeSet2 != null) {
      paramAttributeSet2.setOnClickListener((View.OnClickListener)localObject1);
    }
    paramAttributeSet1 = (ImageView)findViewById(n0.exo_repeat_toggle);
    this.p2 = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.setOnClickListener((View.OnClickListener)localObject1);
    }
    paramAttributeSet1 = (ImageView)findViewById(n0.exo_shuffle);
    this.p3 = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      paramAttributeSet1.setOnClickListener((View.OnClickListener)localObject1);
    }
    paramAttributeSet1 = paramContext.getResources();
    this.C4 = paramAttributeSet1;
    this.Y3 = (paramAttributeSet1.getInteger(o0.exo_media_button_opacity_percentage_enabled) / 100.0F);
    this.Z3 = (this.C4.getInteger(o0.exo_media_button_opacity_percentage_disabled) / 100.0F);
    paramAttributeSet1 = findViewById(n0.exo_vr);
    this.H3 = paramAttributeSet1;
    if (paramAttributeSet1 != null) {
      v0(false, paramAttributeSet1);
    }
    paramAttributeSet1 = new v0(this);
    this.B4 = paramAttributeSet1;
    paramAttributeSet1.X(bool8);
    paramAttributeSet2 = this.C4.getString(r0.exo_controls_playback_speed);
    localObject2 = this.C4.getDrawable(l0.exo_styled_controls_speed);
    paramAttributeSet1 = this.C4.getString(r0.exo_track_selection_title_audio);
    localObject1 = this.C4.getDrawable(l0.exo_styled_controls_audiotrack);
    this.E4 = new h(new String[] { paramAttributeSet2, paramAttributeSet1 }, new Drawable[] { localObject2, localObject1 });
    this.I4 = this.C4.getDimensionPixelSize(k0.exo_settings_offset);
    paramContext = (RecyclerView)LayoutInflater.from(paramContext).inflate(p0.exo_styled_settings_list, null);
    this.D4 = paramContext;
    paramContext.setAdapter(this.E4);
    this.D4.setLayoutManager(new LinearLayoutManager(getContext()));
    this.G4 = new PopupWindow(this.D4, -2, -2, true);
    if (com.google.android.exoplayer2.util.o0.a < 23) {
      this.G4.setBackgroundDrawable(new ColorDrawable(0));
    }
    this.G4.setOnDismissListener(this.c);
    this.H4 = true;
    this.M4 = new g0(getResources());
    this.c4 = this.C4.getDrawable(l0.exo_styled_controls_subtitle_on);
    this.d4 = this.C4.getDrawable(l0.exo_styled_controls_subtitle_off);
    this.e4 = this.C4.getString(r0.exo_controls_cc_enabled_description);
    this.f4 = this.C4.getString(r0.exo_controls_cc_disabled_description);
    this.K4 = new j(null);
    this.L4 = new b(null);
    this.F4 = new e(this.C4.getStringArray(i0.exo_playback_speeds), this.C4.getIntArray(i0.exo_speed_multiplied_by_100));
    this.g4 = this.C4.getDrawable(l0.exo_styled_controls_fullscreen_exit);
    this.h4 = this.C4.getDrawable(l0.exo_styled_controls_fullscreen_enter);
    this.Q3 = this.C4.getDrawable(l0.exo_styled_controls_repeat_off);
    this.R3 = this.C4.getDrawable(l0.exo_styled_controls_repeat_one);
    this.S3 = this.C4.getDrawable(l0.exo_styled_controls_repeat_all);
    this.W3 = this.C4.getDrawable(l0.exo_styled_controls_shuffle_on);
    this.X3 = this.C4.getDrawable(l0.exo_styled_controls_shuffle_off);
    this.i4 = this.C4.getString(r0.exo_controls_fullscreen_exit_description);
    this.j4 = this.C4.getString(r0.exo_controls_fullscreen_enter_description);
    this.T3 = this.C4.getString(r0.exo_controls_repeat_off_description);
    this.U3 = this.C4.getString(r0.exo_controls_repeat_one_description);
    this.V3 = this.C4.getString(r0.exo_controls_repeat_all_description);
    this.a4 = this.C4.getString(r0.exo_controls_shuffle_on_description);
    this.b4 = this.C4.getString(r0.exo_controls_shuffle_off_description);
    paramContext = (ViewGroup)findViewById(n0.exo_bottom_bar);
    this.B4.Y(paramContext, true);
    this.B4.Y(this.y, bool2);
    this.B4.Y(this.z, bool1);
    this.B4.Y(this.f, bool3);
    this.B4.Y(this.q, bool4);
    this.B4.Y(this.p3, bool5);
    this.B4.Y(this.N4, bool6);
    this.B4.Y(this.H3, bool7);
    paramAttributeSet1 = this.B4;
    paramContext = this.p2;
    if (this.v4 != 0) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    paramAttributeSet1.Y(paramContext, bool5);
    addOnLayoutChangeListener(new n(this));
  }
  
  private void A0()
  {
    if ((g0()) && (this.p4) && (this.x != null)) {
      if (s0())
      {
        ((ImageView)this.x).setImageDrawable(this.C4.getDrawable(l0.exo_styled_controls_pause));
        this.x.setContentDescription(this.C4.getString(r0.exo_controls_pause_description));
      }
      else
      {
        ((ImageView)this.x).setImageDrawable(this.C4.getDrawable(l0.exo_styled_controls_play));
        this.x.setContentDescription(this.C4.getString(r0.exo_controls_play_description));
      }
    }
  }
  
  private void B0()
  {
    u1 localu1 = this.k4;
    if (localu1 == null) {
      return;
    }
    this.F4.r(localu1.c().c);
    this.E4.o(0, this.F4.m());
  }
  
  private void C0()
  {
    if ((g0()) && (this.p4))
    {
      u1 localu1 = this.k4;
      long l1 = 0L;
      long l2;
      if (localu1 != null)
      {
        l1 = this.A4 + localu1.M();
        l2 = this.A4 + localu1.R();
      }
      else
      {
        l2 = 0L;
      }
      Object localObject = this.J3;
      if ((localObject != null) && (!this.s4)) {
        ((TextView)localObject).setText(com.google.android.exoplayer2.util.o0.Z(this.L3, this.M3, l1));
      }
      localObject = this.K3;
      if (localObject != null)
      {
        ((y0)localObject).setPosition(l1);
        this.K3.setBufferedPosition(l2);
      }
      localObject = this.m4;
      if (localObject != null) {
        ((f)localObject).a(l1, l2);
      }
      removeCallbacks(this.P3);
      int i;
      if (localu1 == null) {
        i = 1;
      } else {
        i = localu1.getPlaybackState();
      }
      long l3 = 1000L;
      if ((localu1 != null) && (localu1.O()))
      {
        localObject = this.K3;
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
        l1 = com.google.android.exoplayer2.util.o0.q(l1, this.u4, 1000L);
        postDelayed(this.P3, l1);
      }
      else if ((i != 4) && (i != 1))
      {
        postDelayed(this.P3, 1000L);
      }
    }
  }
  
  private void D0()
  {
    if ((g0()) && (this.p4))
    {
      ImageView localImageView = this.p2;
      if (localImageView != null)
      {
        if (this.v4 == 0)
        {
          v0(false, localImageView);
          return;
        }
        u1 localu1 = this.k4;
        if (localu1 == null)
        {
          v0(false, localImageView);
          this.p2.setImageDrawable(this.Q3);
          this.p2.setContentDescription(this.T3);
          return;
        }
        v0(true, localImageView);
        int i = localu1.getRepeatMode();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2)
            {
              this.p2.setImageDrawable(this.S3);
              this.p2.setContentDescription(this.V3);
            }
          }
          else
          {
            this.p2.setImageDrawable(this.R3);
            this.p2.setContentDescription(this.U3);
          }
        }
        else
        {
          this.p2.setImageDrawable(this.Q3);
          this.p2.setContentDescription(this.T3);
        }
      }
    }
  }
  
  private void E0()
  {
    x0 localx0 = this.l4;
    if ((localx0 instanceof com.google.android.exoplayer2.y0))
    {
      localObject = this.k4;
      if (localObject != null)
      {
        l = ((com.google.android.exoplayer2.y0)localx0).n((u1)localObject);
        break label37;
      }
    }
    long l = 5000L;
    label37:
    int i = (int)(l / 1000L);
    Object localObject = this.p1;
    if (localObject != null) {
      ((TextView)localObject).setText(String.valueOf(i));
    }
    localObject = this.z;
    if (localObject != null) {
      ((View)localObject).setContentDescription(this.C4.getQuantityString(q0.exo_controls_rewind_by_amount_description, i, new Object[] { Integer.valueOf(i) }));
    }
  }
  
  private void F0()
  {
    this.D4.measure(0, 0);
    int i = getWidth();
    int j = this.I4;
    j = Math.min(this.D4.getMeasuredWidth(), i - j * 2);
    this.G4.setWidth(j);
    j = Math.min(getHeight() - this.I4 * 2, this.D4.getMeasuredHeight());
    this.G4.setHeight(j);
  }
  
  private void G0()
  {
    if ((g0()) && (this.p4))
    {
      Object localObject = this.p3;
      if (localObject != null)
      {
        u1 localu1 = this.k4;
        if (!this.B4.n((View)localObject))
        {
          v0(false, this.p3);
        }
        else if (localu1 == null)
        {
          v0(false, this.p3);
          this.p3.setImageDrawable(this.X3);
          this.p3.setContentDescription(this.b4);
        }
        else
        {
          v0(true, this.p3);
          ImageView localImageView = this.p3;
          if (localu1.Q()) {
            localObject = this.W3;
          } else {
            localObject = this.X3;
          }
          localImageView.setImageDrawable((Drawable)localObject);
          localImageView = this.p3;
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
  
  private void H0()
  {
    Object localObject1 = this.k4;
    if (localObject1 == null) {
      return;
    }
    boolean bool;
    if ((this.q4) && (S(((u1)localObject1).w(), this.O3))) {
      bool = true;
    } else {
      bool = false;
    }
    this.r4 = bool;
    long l1 = 0L;
    this.A4 = 0L;
    Object localObject2 = ((u1)localObject1).w();
    int i;
    int j;
    int m;
    if (!((j2)localObject2).q())
    {
      i = ((u1)localObject1).m();
      bool = this.r4;
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
      int i1;
      for (m = 0; j <= k; m = i1)
      {
        if (j == i) {
          this.A4 = w0.e(l1);
        }
        ((j2)localObject2).n(j, this.O3);
        localObject1 = this.O3;
        if (((j2.c)localObject1).r == -9223372036854775807L)
        {
          com.google.android.exoplayer2.util.g.g(this.r4 ^ true);
          break;
        }
        int n = ((j2.c)localObject1).s;
        i1 = m;
        for (;;)
        {
          localObject1 = this.O3;
          if (n > ((j2.c)localObject1).t) {
            break;
          }
          ((j2)localObject2).f(n, this.N3);
          m = this.N3.n();
          int i2 = this.N3.c();
          while (m < i2)
          {
            long l2 = this.N3.f(m);
            long l3 = l2;
            if (l2 == Long.MIN_VALUE)
            {
              l3 = this.N3.e;
              if (l3 == -9223372036854775807L)
              {
                i3 = i1;
                break label403;
              }
            }
            l3 += this.N3.m();
            int i3 = i1;
            if (l3 >= 0L)
            {
              localObject1 = this.w4;
              if (i1 == localObject1.length)
              {
                if (localObject1.length == 0) {
                  i3 = 1;
                } else {
                  i3 = localObject1.length * 2;
                }
                this.w4 = Arrays.copyOf((long[])localObject1, i3);
                this.x4 = Arrays.copyOf(this.x4, i3);
              }
              this.w4[i1] = w0.e(l1 + l3);
              this.x4[i1] = this.N3.o(m);
              i3 = i1 + 1;
            }
            label403:
            m++;
            i1 = i3;
          }
          n++;
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
    localObject2 = this.I3;
    if (localObject2 != null) {
      ((TextView)localObject2).setText(com.google.android.exoplayer2.util.o0.Z(this.L3, this.M3, l1));
    }
    localObject2 = this.K3;
    if (localObject2 != null)
    {
      ((y0)localObject2).setDuration(l1);
      j = this.y4.length;
      i = m + j;
      localObject2 = this.w4;
      if (i > localObject2.length)
      {
        this.w4 = Arrays.copyOf((long[])localObject2, i);
        this.x4 = Arrays.copyOf(this.x4, i);
      }
      System.arraycopy(this.y4, 0, this.w4, m, j);
      System.arraycopy(this.z4, 0, this.x4, m, j);
      this.K3.b(this.w4, this.x4, i);
    }
    C0();
  }
  
  private void I0()
  {
    c0();
    boolean bool;
    if (this.K4.getItemCount() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    v0(bool, this.N4);
  }
  
  private static boolean S(j2 paramj2, j2.c paramc)
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
  
  private void U(u1 paramu1)
  {
    this.l4.l(paramu1, false);
  }
  
  private void V(u1 paramu1)
  {
    int i = paramu1.getPlaybackState();
    if (i == 1) {
      this.l4.h(paramu1);
    } else if (i == 4) {
      q0(paramu1, paramu1.m(), -9223372036854775807L);
    }
    this.l4.l(paramu1, true);
  }
  
  private void W(u1 paramu1)
  {
    int i = paramu1.getPlaybackState();
    if ((i != 1) && (i != 4) && (paramu1.E())) {
      U(paramu1);
    } else {
      V(paramu1);
    }
  }
  
  private void X(RecyclerView.Adapter<?> paramAdapter)
  {
    this.D4.setAdapter(paramAdapter);
    F0();
    this.H4 = false;
    this.G4.dismiss();
    this.H4 = true;
    int i = getWidth();
    int j = this.G4.getWidth();
    int k = this.I4;
    int m = -this.G4.getHeight();
    int n = this.I4;
    this.G4.showAsDropDown(this, i - j - k, m - n);
  }
  
  private void Y(i.a parama, int paramInt, List<k> paramList)
  {
    TrackGroupArray localTrackGroupArray = parama.e(paramInt);
    com.google.android.exoplayer2.trackselection.j localj = ((u1)com.google.android.exoplayer2.util.g.e(this.k4)).A().a(paramInt);
    for (int i = 0; i < localTrackGroupArray.d; i++)
    {
      TrackGroup localTrackGroup = localTrackGroupArray.a(i);
      for (int j = 0; j < localTrackGroup.c; j++)
      {
        Format localFormat = localTrackGroup.a(j);
        if (parama.f(paramInt, i, j) == 4)
        {
          boolean bool;
          if ((localj != null) && (localj.p(localFormat) != -1)) {
            bool = true;
          } else {
            bool = false;
          }
          paramList.add(new k(paramInt, i, j, this.M4.a(localFormat), bool));
        }
      }
    }
  }
  
  private static int Z(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getInt(t0.StyledPlayerControlView_repeat_toggle_modes, paramInt);
  }
  
  private void c0()
  {
    this.K4.m();
    this.L4.m();
    if (this.k4 != null)
    {
      Object localObject = this.J4;
      if (localObject != null)
      {
        i.a locala = ((com.google.android.exoplayer2.trackselection.i)localObject).g();
        if (locala == null) {
          return;
        }
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        localObject = new ArrayList();
        for (int i = 0; i < locala.c(); i++) {
          if ((locala.d(i) == 3) && (this.B4.n(this.N4)))
          {
            Y(locala, i, localArrayList1);
            localArrayList3.add(Integer.valueOf(i));
          }
          else if (locala.d(i) == 1)
          {
            Y(locala, i, localArrayList2);
            ((List)localObject).add(Integer.valueOf(i));
          }
        }
        this.K4.n(localArrayList3, localArrayList1, locala);
        this.L4.n((List)localObject, localArrayList2, locala);
      }
    }
  }
  
  private static void d0(View paramView, View.OnClickListener paramOnClickListener)
  {
    if (paramView == null) {
      return;
    }
    paramView.setVisibility(8);
    paramView.setOnClickListener(paramOnClickListener);
  }
  
  @SuppressLint({"InlinedApi"})
  private static boolean f0(int paramInt)
  {
    boolean bool;
    if ((paramInt != 90) && (paramInt != 89) && (paramInt != 85) && (paramInt != 79) && (paramInt != 126) && (paramInt != 127) && (paramInt != 87) && (paramInt != 88)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void l0(View paramView)
  {
    if (this.n4 == null) {
      return;
    }
    boolean bool = this.o4 ^ true;
    this.o4 = bool;
    x0(this.O4, bool);
    x0(this.P4, this.o4);
    paramView = this.n4;
    if (paramView != null) {
      paramView.a(this.o4);
    }
  }
  
  private void m0(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (((paramInt3 - paramInt1 != paramInt7 - paramInt5) || (paramInt4 - paramInt2 != paramInt8 - paramInt6)) && (this.G4.isShowing()))
    {
      F0();
      paramInt4 = getWidth();
      paramInt3 = this.G4.getWidth();
      paramInt5 = this.I4;
      paramInt2 = -this.G4.getHeight();
      paramInt1 = this.I4;
      this.G4.update(paramView, paramInt4 - paramInt3 - paramInt5, paramInt2 - paramInt1, -1, -1);
    }
  }
  
  private void n0(int paramInt)
  {
    if (paramInt == 0) {
      X(this.F4);
    } else if (paramInt == 1) {
      X(this.L4);
    } else {
      this.G4.dismiss();
    }
  }
  
  private boolean q0(u1 paramu1, int paramInt, long paramLong)
  {
    return this.l4.c(paramu1, paramInt, paramLong);
  }
  
  private void r0(u1 paramu1, long paramLong)
  {
    j2 localj2 = paramu1.w();
    if ((this.r4) && (!localj2.q()))
    {
      int i = localj2.p();
      for (j = 0;; j++)
      {
        long l = localj2.n(j, this.O3).d();
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
    q0(paramu1, j, paramLong);
    C0();
  }
  
  private boolean s0()
  {
    u1 localu1 = this.k4;
    boolean bool = true;
    if ((localu1 == null) || (localu1.getPlaybackState() == 4) || (this.k4.getPlaybackState() == 1) || (!this.k4.E())) {
      bool = false;
    }
    return bool;
  }
  
  private void setPlaybackSpeed(float paramFloat)
  {
    u1 localu1 = this.k4;
    if (localu1 == null) {
      return;
    }
    this.l4.a(localu1, localu1.c().b(paramFloat));
  }
  
  private void v0(boolean paramBoolean, @Nullable View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setEnabled(paramBoolean);
    float f1;
    if (paramBoolean) {
      f1 = this.Y3;
    } else {
      f1 = this.Z3;
    }
    paramView.setAlpha(f1);
  }
  
  private void w0()
  {
    x0 localx0 = this.l4;
    if ((localx0 instanceof com.google.android.exoplayer2.y0))
    {
      localObject = this.k4;
      if (localObject != null)
      {
        l = ((com.google.android.exoplayer2.y0)localx0).m((u1)localObject);
        break label37;
      }
    }
    long l = 15000L;
    label37:
    int i = (int)(l / 1000L);
    Object localObject = this.p0;
    if (localObject != null) {
      ((TextView)localObject).setText(String.valueOf(i));
    }
    localObject = this.y;
    if (localObject != null) {
      ((View)localObject).setContentDescription(this.C4.getQuantityString(q0.exo_controls_fastforward_by_amount_description, i, new Object[] { Integer.valueOf(i) }));
    }
  }
  
  private void x0(@Nullable ImageView paramImageView, boolean paramBoolean)
  {
    if (paramImageView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramImageView.setImageDrawable(this.g4);
      paramImageView.setContentDescription(this.i4);
    }
    else
    {
      paramImageView.setImageDrawable(this.h4);
      paramImageView.setContentDescription(this.j4);
    }
  }
  
  private static void y0(@Nullable View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean) {
      paramView.setVisibility(0);
    } else {
      paramView.setVisibility(8);
    }
  }
  
  private void z0()
  {
    if ((g0()) && (this.p4))
    {
      Object localObject = this.k4;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3;
      boolean bool5;
      boolean bool6;
      if (localObject != null)
      {
        bool3 = ((u1)localObject).s(4);
        boolean bool4 = ((u1)localObject).s(6);
        if ((((u1)localObject).s(10)) && (this.l4.g())) {
          bool5 = true;
        } else {
          bool5 = false;
        }
        bool6 = bool2;
        if (((u1)localObject).s(11))
        {
          bool6 = bool2;
          if (this.l4.k()) {
            bool6 = true;
          }
        }
        boolean bool7 = ((u1)localObject).s(8);
        bool2 = bool6;
        bool1 = bool5;
        bool6 = bool3;
        bool5 = bool2;
        bool3 = bool7;
        bool2 = bool4;
      }
      else
      {
        bool5 = false;
        bool3 = false;
        bool2 = false;
        bool6 = false;
      }
      if (bool1) {
        E0();
      }
      if (bool5) {
        w0();
      }
      v0(bool2, this.f);
      v0(bool1, this.z);
      v0(bool5, this.y);
      v0(bool3, this.q);
      localObject = this.K3;
      if (localObject != null) {
        ((y0)localObject).setEnabled(bool6);
      }
    }
  }
  
  public void R(m paramm)
  {
    com.google.android.exoplayer2.util.g.e(paramm);
    this.d.add(paramm);
  }
  
  public boolean T(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    u1 localu1 = this.k4;
    if ((localu1 != null) && (f0(i)))
    {
      if (paramKeyEvent.getAction() == 0) {
        if (i == 90)
        {
          if (localu1.getPlaybackState() != 4) {
            this.l4.f(localu1);
          }
        }
        else if (i == 89) {
          this.l4.b(localu1);
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
                    U(localu1);
                  }
                }
                else {
                  V(localu1);
                }
              }
              else {
                this.l4.i(localu1);
              }
            }
            else {
              this.l4.j(localu1);
            }
          }
          else {
            W(localu1);
          }
        }
      }
      return true;
    }
    return false;
  }
  
  public void a0()
  {
    this.B4.p();
  }
  
  public void b0()
  {
    this.B4.s();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((!T(paramKeyEvent)) && (!super.dispatchKeyEvent(paramKeyEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean e0()
  {
    return this.B4.v();
  }
  
  public boolean g0()
  {
    boolean bool;
    if (getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  public u1 getPlayer()
  {
    return this.k4;
  }
  
  public int getRepeatToggleModes()
  {
    return this.v4;
  }
  
  public boolean getShowShuffleButton()
  {
    return this.B4.n(this.p3);
  }
  
  public boolean getShowSubtitleButton()
  {
    return this.B4.n(this.N4);
  }
  
  public int getShowTimeoutMs()
  {
    return this.t4;
  }
  
  public boolean getShowVrButton()
  {
    return this.B4.n(this.H3);
  }
  
  void k0()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).b(getVisibility());
    }
  }
  
  public void o0(m paramm)
  {
    this.d.remove(paramm);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.B4.O();
    this.p4 = true;
    if (e0()) {
      this.B4.W();
    }
    u0();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.B4.P();
    this.p4 = false;
    removeCallbacks(this.P3);
    this.B4.V();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.B4.Q(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void p0()
  {
    View localView = this.x;
    if (localView != null) {
      localView.requestFocus();
    }
  }
  
  public void setAnimationEnabled(boolean paramBoolean)
  {
    this.B4.X(paramBoolean);
  }
  
  @Deprecated
  public void setControlDispatcher(x0 paramx0)
  {
    if (this.l4 != paramx0)
    {
      this.l4 = paramx0;
      z0();
    }
  }
  
  public void setOnFullScreenModeChangedListener(@Nullable d paramd)
  {
    this.n4 = paramd;
    ImageView localImageView = this.O4;
    boolean bool1 = true;
    boolean bool2;
    if (paramd != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    y0(localImageView, bool2);
    localImageView = this.P4;
    if (paramd != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    y0(localImageView, bool2);
  }
  
  public void setPlayer(@Nullable u1 paramu1)
  {
    Object localObject = Looper.myLooper();
    Looper localLooper = Looper.getMainLooper();
    boolean bool1 = true;
    if (localObject == localLooper) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    com.google.android.exoplayer2.util.g.g(bool2);
    boolean bool2 = bool1;
    if (paramu1 != null) {
      if (paramu1.x() == Looper.getMainLooper()) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    com.google.android.exoplayer2.util.g.a(bool2);
    localObject = this.k4;
    if (localObject == paramu1) {
      return;
    }
    if (localObject != null) {
      ((u1)localObject).i(this.c);
    }
    this.k4 = paramu1;
    if (paramu1 != null) {
      paramu1.N(this.c);
    }
    if ((paramu1 instanceof e1))
    {
      paramu1 = ((e1)paramu1).a();
      if ((paramu1 instanceof DefaultTrackSelector)) {
        this.J4 = ((DefaultTrackSelector)paramu1);
      }
    }
    else
    {
      this.J4 = null;
    }
    u0();
  }
  
  public void setProgressUpdateListener(@Nullable f paramf)
  {
    this.m4 = paramf;
  }
  
  public void setRepeatToggleModes(int paramInt)
  {
    this.v4 = paramInt;
    Object localObject = this.k4;
    boolean bool = false;
    if (localObject != null)
    {
      int i = ((u1)localObject).getRepeatMode();
      if ((paramInt == 0) && (i != 0)) {
        this.l4.e(this.k4, 0);
      } else if ((paramInt == 1) && (i == 2)) {
        this.l4.e(this.k4, 1);
      } else if ((paramInt == 2) && (i == 1)) {
        this.l4.e(this.k4, 2);
      }
    }
    v0 localv0 = this.B4;
    localObject = this.p2;
    if (paramInt != 0) {
      bool = true;
    }
    localv0.Y((View)localObject, bool);
    D0();
  }
  
  public void setShowFastForwardButton(boolean paramBoolean)
  {
    this.B4.Y(this.y, paramBoolean);
    z0();
  }
  
  public void setShowMultiWindowTimeBar(boolean paramBoolean)
  {
    this.q4 = paramBoolean;
    H0();
  }
  
  public void setShowNextButton(boolean paramBoolean)
  {
    this.B4.Y(this.q, paramBoolean);
    z0();
  }
  
  public void setShowPreviousButton(boolean paramBoolean)
  {
    this.B4.Y(this.f, paramBoolean);
    z0();
  }
  
  public void setShowRewindButton(boolean paramBoolean)
  {
    this.B4.Y(this.z, paramBoolean);
    z0();
  }
  
  public void setShowShuffleButton(boolean paramBoolean)
  {
    this.B4.Y(this.p3, paramBoolean);
    G0();
  }
  
  public void setShowSubtitleButton(boolean paramBoolean)
  {
    this.B4.Y(this.N4, paramBoolean);
  }
  
  public void setShowTimeoutMs(int paramInt)
  {
    this.t4 = paramInt;
    if (e0()) {
      this.B4.W();
    }
  }
  
  public void setShowVrButton(boolean paramBoolean)
  {
    this.B4.Y(this.H3, paramBoolean);
  }
  
  public void setTimeBarMinUpdateInterval(int paramInt)
  {
    this.u4 = com.google.android.exoplayer2.util.o0.p(paramInt, 16, 1000);
  }
  
  public void setVrButtonListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    View localView = this.H3;
    if (localView != null)
    {
      localView.setOnClickListener(paramOnClickListener);
      boolean bool;
      if (paramOnClickListener != null) {
        bool = true;
      } else {
        bool = false;
      }
      v0(bool, this.H3);
    }
  }
  
  public void t0()
  {
    this.B4.b0();
  }
  
  void u0()
  {
    A0();
    z0();
    D0();
    G0();
    I0();
    B0();
    H0();
  }
  
  private final class b
    extends StyledPlayerControlView.l
  {
    private b()
    {
      super();
    }
    
    public void n(List<Integer> paramList, List<StyledPlayerControlView.k> paramList1, i.a parama)
    {
      int i = 0;
      Object localObject;
      for (int j = 0; j < paramList.size(); j++)
      {
        int k = ((Integer)paramList.get(j)).intValue();
        localObject = parama.e(k);
        if ((StyledPlayerControlView.L(StyledPlayerControlView.this) != null) && (StyledPlayerControlView.L(StyledPlayerControlView.this).s().m(k, (TrackGroupArray)localObject)))
        {
          j = 1;
          break label86;
        }
      }
      j = 0;
      label86:
      if (paramList1.isEmpty()) {
        StyledPlayerControlView.v(StyledPlayerControlView.this).o(1, StyledPlayerControlView.this.getResources().getString(r0.exo_track_selection_none));
      } else if (j == 0) {
        StyledPlayerControlView.v(StyledPlayerControlView.this).o(1, StyledPlayerControlView.this.getResources().getString(r0.exo_track_selection_auto));
      } else {
        while (i < paramList1.size())
        {
          localObject = (StyledPlayerControlView.k)paramList1.get(i);
          if (((StyledPlayerControlView.k)localObject).e)
          {
            StyledPlayerControlView.v(StyledPlayerControlView.this).o(1, ((StyledPlayerControlView.k)localObject).d);
            break;
          }
          i++;
        }
      }
      this.a = paramList;
      this.b = paramList1;
      this.c = parama;
    }
    
    public void r(StyledPlayerControlView.i parami)
    {
      parami.a.setText(r0.exo_track_selection_auto);
      Object localObject = ((DefaultTrackSelector)com.google.android.exoplayer2.util.g.e(StyledPlayerControlView.L(StyledPlayerControlView.this))).s();
      int i = 0;
      for (int j = 0; j < this.a.size(); j++)
      {
        int k = ((Integer)this.a.get(j)).intValue();
        if (((DefaultTrackSelector.Parameters)localObject).m(k, ((i.a)com.google.android.exoplayer2.util.g.e(this.c)).e(k)))
        {
          j = 1;
          break label104;
        }
      }
      j = 0;
      label104:
      localObject = parami.b;
      if (j != 0) {
        i = 4;
      }
      ((View)localObject).setVisibility(i);
      parami.itemView.setOnClickListener(new g(this));
    }
    
    public void t(String paramString)
    {
      StyledPlayerControlView.v(StyledPlayerControlView.this).o(1, paramString);
    }
  }
  
  private final class c
    implements u1.e, y0.a, View.OnClickListener, PopupWindow.OnDismissListener
  {
    private c() {}
    
    public void S(u1 paramu1, u1.d paramd)
    {
      if (paramd.b(new int[] { 5, 6 })) {
        StyledPlayerControlView.u(StyledPlayerControlView.this);
      }
      if (paramd.b(new int[] { 5, 6, 8 })) {
        StyledPlayerControlView.D(StyledPlayerControlView.this);
      }
      if (paramd.a(9)) {
        StyledPlayerControlView.M(StyledPlayerControlView.this);
      }
      if (paramd.a(10)) {
        StyledPlayerControlView.N(StyledPlayerControlView.this);
      }
      if (paramd.b(new int[] { 9, 10, 12, 0, 17, 18 })) {
        StyledPlayerControlView.O(StyledPlayerControlView.this);
      }
      if (paramd.b(new int[] { 12, 0 })) {
        StyledPlayerControlView.P(StyledPlayerControlView.this);
      }
      if (paramd.a(13)) {
        StyledPlayerControlView.Q(StyledPlayerControlView.this);
      }
      if (paramd.a(2)) {
        StyledPlayerControlView.a(StyledPlayerControlView.this);
      }
    }
    
    public void b(y0 paramy0, long paramLong)
    {
      if (StyledPlayerControlView.c(StyledPlayerControlView.this) != null) {
        StyledPlayerControlView.c(StyledPlayerControlView.this).setText(com.google.android.exoplayer2.util.o0.Z(StyledPlayerControlView.d(StyledPlayerControlView.this), StyledPlayerControlView.e(StyledPlayerControlView.this), paramLong));
      }
    }
    
    public void h(y0 paramy0, long paramLong, boolean paramBoolean)
    {
      StyledPlayerControlView.b(StyledPlayerControlView.this, false);
      if ((!paramBoolean) && (StyledPlayerControlView.g(StyledPlayerControlView.this) != null))
      {
        paramy0 = StyledPlayerControlView.this;
        StyledPlayerControlView.h(paramy0, StyledPlayerControlView.g(paramy0), paramLong);
      }
      StyledPlayerControlView.f(StyledPlayerControlView.this).W();
    }
    
    public void i(y0 paramy0, long paramLong)
    {
      StyledPlayerControlView.b(StyledPlayerControlView.this, true);
      if (StyledPlayerControlView.c(StyledPlayerControlView.this) != null) {
        StyledPlayerControlView.c(StyledPlayerControlView.this).setText(com.google.android.exoplayer2.util.o0.Z(StyledPlayerControlView.d(StyledPlayerControlView.this), StyledPlayerControlView.e(StyledPlayerControlView.this), paramLong));
      }
      StyledPlayerControlView.f(StyledPlayerControlView.this).V();
    }
    
    public void onClick(View paramView)
    {
      u1 localu1 = StyledPlayerControlView.g(StyledPlayerControlView.this);
      if (localu1 == null) {
        return;
      }
      StyledPlayerControlView.f(StyledPlayerControlView.this).W();
      if (StyledPlayerControlView.j(StyledPlayerControlView.this) == paramView)
      {
        StyledPlayerControlView.k(StyledPlayerControlView.this).j(localu1);
      }
      else if (StyledPlayerControlView.l(StyledPlayerControlView.this) == paramView)
      {
        StyledPlayerControlView.k(StyledPlayerControlView.this).i(localu1);
      }
      else if (StyledPlayerControlView.m(StyledPlayerControlView.this) == paramView)
      {
        if (localu1.getPlaybackState() != 4) {
          StyledPlayerControlView.k(StyledPlayerControlView.this).f(localu1);
        }
      }
      else if (StyledPlayerControlView.n(StyledPlayerControlView.this) == paramView)
      {
        StyledPlayerControlView.k(StyledPlayerControlView.this).b(localu1);
      }
      else if (StyledPlayerControlView.o(StyledPlayerControlView.this) == paramView)
      {
        StyledPlayerControlView.p(StyledPlayerControlView.this, localu1);
      }
      else if (StyledPlayerControlView.q(StyledPlayerControlView.this) == paramView)
      {
        StyledPlayerControlView.k(StyledPlayerControlView.this).e(localu1, f0.a(localu1.getRepeatMode(), StyledPlayerControlView.r(StyledPlayerControlView.this)));
      }
      else if (StyledPlayerControlView.s(StyledPlayerControlView.this) == paramView)
      {
        StyledPlayerControlView.k(StyledPlayerControlView.this).d(localu1, localu1.Q() ^ true);
      }
      else if (StyledPlayerControlView.t(StyledPlayerControlView.this) == paramView)
      {
        StyledPlayerControlView.f(StyledPlayerControlView.this).V();
        paramView = StyledPlayerControlView.this;
        StyledPlayerControlView.w(paramView, StyledPlayerControlView.v(paramView));
      }
      else if (StyledPlayerControlView.x(StyledPlayerControlView.this) == paramView)
      {
        StyledPlayerControlView.f(StyledPlayerControlView.this).V();
        paramView = StyledPlayerControlView.this;
        StyledPlayerControlView.w(paramView, StyledPlayerControlView.y(paramView));
      }
      else if (StyledPlayerControlView.z(StyledPlayerControlView.this) == paramView)
      {
        StyledPlayerControlView.f(StyledPlayerControlView.this).V();
        paramView = StyledPlayerControlView.this;
        StyledPlayerControlView.w(paramView, StyledPlayerControlView.A(paramView));
      }
      else if (StyledPlayerControlView.B(StyledPlayerControlView.this) == paramView)
      {
        StyledPlayerControlView.f(StyledPlayerControlView.this).V();
        paramView = StyledPlayerControlView.this;
        StyledPlayerControlView.w(paramView, StyledPlayerControlView.C(paramView));
      }
    }
    
    public void onDismiss()
    {
      if (StyledPlayerControlView.i(StyledPlayerControlView.this)) {
        StyledPlayerControlView.f(StyledPlayerControlView.this).W();
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean);
  }
  
  private final class e
    extends RecyclerView.Adapter<StyledPlayerControlView.i>
  {
    private final String[] a;
    private final int[] b;
    private int c;
    
    public e(String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      this.a = paramArrayOfString;
      this.b = paramArrayOfInt;
    }
    
    public int getItemCount()
    {
      return this.a.length;
    }
    
    public String m()
    {
      return this.a[this.c];
    }
    
    public void p(StyledPlayerControlView.i parami, int paramInt)
    {
      Object localObject = this.a;
      if (paramInt < localObject.length) {
        parami.a.setText(localObject[paramInt]);
      }
      localObject = parami.b;
      int i;
      if (paramInt == this.c) {
        i = 0;
      } else {
        i = 4;
      }
      ((View)localObject).setVisibility(i);
      parami.itemView.setOnClickListener(new h(this, paramInt));
    }
    
    public StyledPlayerControlView.i q(ViewGroup paramViewGroup, int paramInt)
    {
      return new StyledPlayerControlView.i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(p0.exo_styled_sub_settings_list_item, paramViewGroup, false));
    }
    
    public void r(float paramFloat)
    {
      int i = Math.round(paramFloat * 100.0F);
      int j = 0;
      int k = 0;
      int i1;
      for (int m = Integer.MAX_VALUE;; m = i1)
      {
        int[] arrayOfInt = this.b;
        if (j >= arrayOfInt.length) {
          break;
        }
        int n = Math.abs(i - arrayOfInt[j]);
        i1 = m;
        if (n < m)
        {
          k = j;
          i1 = n;
        }
        j++;
      }
      this.c = k;
    }
  }
  
  public static abstract interface f
  {
    public abstract void a(long paramLong1, long paramLong2);
  }
  
  private final class g
    extends RecyclerView.ViewHolder
  {
    private final TextView a;
    private final TextView b;
    private final ImageView c;
    
    public g(View paramView)
    {
      super();
      if (com.google.android.exoplayer2.util.o0.a < 26) {
        paramView.setFocusable(true);
      }
      this.a = ((TextView)paramView.findViewById(n0.exo_main_text));
      this.b = ((TextView)paramView.findViewById(n0.exo_sub_text));
      this.c = ((ImageView)paramView.findViewById(n0.exo_icon));
      paramView.setOnClickListener(new i(this));
    }
  }
  
  private class h
    extends RecyclerView.Adapter<StyledPlayerControlView.g>
  {
    private final String[] a;
    private final String[] b;
    private final Drawable[] c;
    
    public h(String[] paramArrayOfString, Drawable[] paramArrayOfDrawable)
    {
      this.a = paramArrayOfString;
      this.b = new String[paramArrayOfString.length];
      this.c = paramArrayOfDrawable;
    }
    
    public int getItemCount()
    {
      return this.a.length;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public void m(StyledPlayerControlView.g paramg, int paramInt)
    {
      StyledPlayerControlView.g.c(paramg).setText(this.a[paramInt]);
      if (this.b[paramInt] == null) {
        StyledPlayerControlView.g.d(paramg).setVisibility(8);
      } else {
        StyledPlayerControlView.g.d(paramg).setText(this.b[paramInt]);
      }
      if (this.c[paramInt] == null) {
        StyledPlayerControlView.g.e(paramg).setVisibility(8);
      } else {
        StyledPlayerControlView.g.e(paramg).setImageDrawable(this.c[paramInt]);
      }
    }
    
    public StyledPlayerControlView.g n(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(p0.exo_styled_settings_list_item, paramViewGroup, false);
      return new StyledPlayerControlView.g(StyledPlayerControlView.this, paramViewGroup);
    }
    
    public void o(int paramInt, String paramString)
    {
      this.b[paramInt] = paramString;
    }
  }
  
  private static class i
    extends RecyclerView.ViewHolder
  {
    public final TextView a;
    public final View b;
    
    public i(View paramView)
    {
      super();
      if (com.google.android.exoplayer2.util.o0.a < 26) {
        paramView.setFocusable(true);
      }
      this.a = ((TextView)paramView.findViewById(n0.exo_text));
      this.b = paramView.findViewById(n0.exo_check);
    }
  }
  
  private final class j
    extends StyledPlayerControlView.l
  {
    private j()
    {
      super();
    }
    
    public void n(List<Integer> paramList, List<StyledPlayerControlView.k> paramList1, i.a parama)
    {
      int i = 0;
      int k;
      for (int j = 0;; j++)
      {
        k = i;
        if (j >= paramList1.size()) {
          break;
        }
        if (((StyledPlayerControlView.k)paramList1.get(j)).e)
        {
          k = 1;
          break;
        }
      }
      if (StyledPlayerControlView.B(StyledPlayerControlView.this) != null)
      {
        ImageView localImageView = StyledPlayerControlView.B(StyledPlayerControlView.this);
        Object localObject = StyledPlayerControlView.this;
        if (k != 0) {
          localObject = StyledPlayerControlView.H((StyledPlayerControlView)localObject);
        } else {
          localObject = StyledPlayerControlView.I((StyledPlayerControlView)localObject);
        }
        localImageView.setImageDrawable((Drawable)localObject);
        localImageView = StyledPlayerControlView.B(StyledPlayerControlView.this);
        if (k != 0) {
          localObject = StyledPlayerControlView.J(StyledPlayerControlView.this);
        } else {
          localObject = StyledPlayerControlView.K(StyledPlayerControlView.this);
        }
        localImageView.setContentDescription((CharSequence)localObject);
      }
      this.a = paramList;
      this.b = paramList1;
      this.c = parama;
    }
    
    public void q(StyledPlayerControlView.i parami, int paramInt)
    {
      super.q(parami, paramInt);
      if (paramInt > 0)
      {
        StyledPlayerControlView.k localk = (StyledPlayerControlView.k)this.b.get(paramInt - 1);
        parami = parami.b;
        if (localk.e) {
          paramInt = 0;
        } else {
          paramInt = 4;
        }
        parami.setVisibility(paramInt);
      }
    }
    
    public void r(StyledPlayerControlView.i parami)
    {
      parami.a.setText(r0.exo_track_selection_none);
      int i = 0;
      for (int j = 0; j < this.b.size(); j++) {
        if (((StyledPlayerControlView.k)this.b.get(j)).e)
        {
          j = 0;
          break label59;
        }
      }
      j = 1;
      label59:
      View localView = parami.b;
      if (j != 0) {
        j = i;
      } else {
        j = 4;
      }
      localView.setVisibility(j);
      parami.itemView.setOnClickListener(new j(this));
    }
    
    public void t(String paramString) {}
  }
  
  private static final class k
  {
    public final int a;
    public final int b;
    public final int c;
    public final String d;
    public final boolean e;
    
    public k(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramString;
      this.e = paramBoolean;
    }
  }
  
  private abstract class l
    extends RecyclerView.Adapter<StyledPlayerControlView.i>
  {
    protected List<Integer> a = new ArrayList();
    protected List<StyledPlayerControlView.k> b = new ArrayList();
    @Nullable
    protected i.a c = null;
    
    public l() {}
    
    public int getItemCount()
    {
      int i;
      if (this.b.isEmpty()) {
        i = 0;
      } else {
        i = this.b.size() + 1;
      }
      return i;
    }
    
    public void m()
    {
      this.b = Collections.emptyList();
      this.c = null;
    }
    
    public abstract void n(List<Integer> paramList, List<StyledPlayerControlView.k> paramList1, i.a parama);
    
    public void q(StyledPlayerControlView.i parami, int paramInt)
    {
      if ((StyledPlayerControlView.L(StyledPlayerControlView.this) != null) && (this.c != null)) {
        if (paramInt == 0)
        {
          r(parami);
        }
        else
        {
          Object localObject1 = this.b;
          int i = 1;
          localObject1 = (StyledPlayerControlView.k)((List)localObject1).get(paramInt - 1);
          Object localObject2 = this.c.e(((StyledPlayerControlView.k)localObject1).a);
          boolean bool = ((DefaultTrackSelector)com.google.android.exoplayer2.util.g.e(StyledPlayerControlView.L(StyledPlayerControlView.this))).s().m(((StyledPlayerControlView.k)localObject1).a, (TrackGroupArray)localObject2);
          int j = 0;
          if ((bool) && (((StyledPlayerControlView.k)localObject1).e)) {
            paramInt = i;
          } else {
            paramInt = 0;
          }
          parami.a.setText(((StyledPlayerControlView.k)localObject1).d);
          localObject2 = parami.b;
          if (paramInt != 0) {
            paramInt = j;
          } else {
            paramInt = 4;
          }
          ((View)localObject2).setVisibility(paramInt);
          parami.itemView.setOnClickListener(new k(this, (StyledPlayerControlView.k)localObject1));
        }
      }
    }
    
    public abstract void r(StyledPlayerControlView.i parami);
    
    public StyledPlayerControlView.i s(ViewGroup paramViewGroup, int paramInt)
    {
      return new StyledPlayerControlView.i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(p0.exo_styled_sub_settings_list_item, paramViewGroup, false));
    }
    
    public abstract void t(String paramString);
  }
  
  public static abstract interface m
  {
    public abstract void b(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\StyledPlayerControlView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */