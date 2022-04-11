package com.google.firebase.annotations;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.CONSTRUCTOR})
@KeepForSdk
public @interface PublicApi {}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\annotations\PublicApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */