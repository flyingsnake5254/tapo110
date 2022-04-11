package kotlin.internal;

public enum RequireKotlinVersionKind
{
  static
  {
    RequireKotlinVersionKind localRequireKotlinVersionKind1 = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);
    LANGUAGE_VERSION = localRequireKotlinVersionKind1;
    RequireKotlinVersionKind localRequireKotlinVersionKind2 = new RequireKotlinVersionKind("COMPILER_VERSION", 1);
    COMPILER_VERSION = localRequireKotlinVersionKind2;
    RequireKotlinVersionKind localRequireKotlinVersionKind3 = new RequireKotlinVersionKind("API_VERSION", 2);
    API_VERSION = localRequireKotlinVersionKind3;
    $VALUES = new RequireKotlinVersionKind[] { localRequireKotlinVersionKind1, localRequireKotlinVersionKind2, localRequireKotlinVersionKind3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\internal\RequireKotlinVersionKind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */