package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zaj;
import java.lang.ref.WeakReference;

public final class zac
  extends zaa
{
  private WeakReference<ImageView> zanc;
  
  public zac(ImageView paramImageView, int paramInt)
  {
    super(null, paramInt);
    Asserts.checkNotNull(paramImageView);
    this.zanc = new WeakReference(paramImageView);
  }
  
  public zac(ImageView paramImageView, Uri paramUri)
  {
    super(paramUri, 0);
    Asserts.checkNotNull(paramImageView);
    this.zanc = new WeakReference(paramImageView);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zac)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    Object localObject = (zac)paramObject;
    paramObject = (ImageView)this.zanc.get();
    localObject = (ImageView)((zac)localObject).zanc.get();
    return (localObject != null) && (paramObject != null) && (Objects.equal(localObject, paramObject));
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  protected final void zaa(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ImageView localImageView = (ImageView)this.zanc.get();
    if (localImageView != null)
    {
      int i = 0;
      int j;
      if ((!paramBoolean2) && (!paramBoolean3)) {
        j = 1;
      } else {
        j = 0;
      }
      if ((j != 0) && ((localImageView instanceof zaj)))
      {
        int k = zaj.zach();
        int m = this.zamx;
        if ((m != 0) && (k == m)) {}
      }
      else
      {
        paramBoolean1 = zaa(paramBoolean1, paramBoolean2);
        Object localObject1 = null;
        Object localObject2 = paramDrawable;
        if (paramBoolean1)
        {
          Drawable localDrawable = localImageView.getDrawable();
          if (localDrawable != null)
          {
            localObject2 = localDrawable;
            if ((localDrawable instanceof zae)) {
              localObject2 = ((zae)localDrawable).zacf();
            }
          }
          else
          {
            localObject2 = null;
          }
          localObject2 = new zae((Drawable)localObject2, paramDrawable);
        }
        localImageView.setImageDrawable((Drawable)localObject2);
        if ((localImageView instanceof zaj))
        {
          paramDrawable = (Drawable)localObject1;
          if (paramBoolean3) {
            paramDrawable = this.zamv.uri;
          }
          zaj.zaa(paramDrawable);
          if (j != 0) {
            i = this.zamx;
          }
          zaj.zai(i);
        }
        if (paramBoolean1) {
          ((zae)localObject2).startTransition(250);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\images\zac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */