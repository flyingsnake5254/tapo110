package com.tplink.iot.Utils;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tplink.iot.widget.HMSPickerDialog;
import com.tplink.iot.widget.HMSPickerDialog.a;
import com.tplink.iot.widget.HMSPickerDialog.b;
import com.tplink.iot.widget.TimeOffsetPickerDialog;
import com.tplink.iot.widget.TimeOffsetPickerDialog.a;
import com.tplink.iot.widget.TimeScrollPickerDialog;
import com.tplink.iot.widget.TimeScrollPickerDialog.a;

public class n0
{
  private static TimeScrollPickerDialog a;
  private static TimeOffsetPickerDialog b;
  private static HMSPickerDialog c;
  
  public static void a(FragmentManager paramFragmentManager, int paramInt, HMSPickerDialog.b paramb, String paramString)
  {
    HMSPickerDialog localHMSPickerDialog = c;
    if ((localHMSPickerDialog != null) && (localHMSPickerDialog.isAdded())) {
      return;
    }
    localHMSPickerDialog = HMSPickerDialog.c.a(paramInt);
    c = localHMSPickerDialog;
    localHMSPickerDialog.H0(paramb);
    c.show(paramFragmentManager, paramString);
  }
  
  public static void b(FragmentManager paramFragmentManager, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, TimeScrollPickerDialog.a parama, String paramString)
  {
    TimeScrollPickerDialog localTimeScrollPickerDialog = a;
    if ((localTimeScrollPickerDialog != null) && (localTimeScrollPickerDialog.isAdded())) {
      return;
    }
    localTimeScrollPickerDialog = TimeScrollPickerDialog.A0(paramInt1, paramBoolean1, paramBoolean2, paramInt2);
    a = localTimeScrollPickerDialog;
    localTimeScrollPickerDialog.B0(parama);
    a.show(paramFragmentManager, paramString);
  }
  
  public static void c(FragmentManager paramFragmentManager, int paramInt, TimeOffsetPickerDialog.a parama, String paramString)
  {
    d(paramFragmentManager, paramInt, false, parama, paramString);
  }
  
  public static void d(FragmentManager paramFragmentManager, int paramInt, boolean paramBoolean, TimeOffsetPickerDialog.a parama, String paramString)
  {
    TimeOffsetPickerDialog localTimeOffsetPickerDialog = b;
    if ((localTimeOffsetPickerDialog != null) && (localTimeOffsetPickerDialog.isAdded())) {
      return;
    }
    localTimeOffsetPickerDialog = TimeOffsetPickerDialog.A0(paramInt, paramBoolean);
    b = localTimeOffsetPickerDialog;
    localTimeOffsetPickerDialog.B0(parama);
    b.show(paramFragmentManager, paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\n0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */