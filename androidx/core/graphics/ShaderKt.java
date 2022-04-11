package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class ShaderKt
{
  public static final void transform(Shader paramShader, l<? super Matrix, p> paraml)
  {
    j.f(paramShader, "$this$transform");
    j.f(paraml, "block");
    Matrix localMatrix = new Matrix();
    paramShader.getLocalMatrix(localMatrix);
    paraml.invoke(localMatrix);
    paramShader.setLocalMatrix(localMatrix);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\ShaderKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */