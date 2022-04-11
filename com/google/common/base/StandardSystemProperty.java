package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public enum StandardSystemProperty
{
  private final String key;
  
  static
  {
    StandardSystemProperty localStandardSystemProperty1 = new StandardSystemProperty("JAVA_VERSION", 0, "java.version");
    JAVA_VERSION = localStandardSystemProperty1;
    StandardSystemProperty localStandardSystemProperty2 = new StandardSystemProperty("JAVA_VENDOR", 1, "java.vendor");
    JAVA_VENDOR = localStandardSystemProperty2;
    StandardSystemProperty localStandardSystemProperty3 = new StandardSystemProperty("JAVA_VENDOR_URL", 2, "java.vendor.url");
    JAVA_VENDOR_URL = localStandardSystemProperty3;
    StandardSystemProperty localStandardSystemProperty4 = new StandardSystemProperty("JAVA_HOME", 3, "java.home");
    JAVA_HOME = localStandardSystemProperty4;
    StandardSystemProperty localStandardSystemProperty5 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VERSION", 4, "java.vm.specification.version");
    JAVA_VM_SPECIFICATION_VERSION = localStandardSystemProperty5;
    StandardSystemProperty localStandardSystemProperty6 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VENDOR", 5, "java.vm.specification.vendor");
    JAVA_VM_SPECIFICATION_VENDOR = localStandardSystemProperty6;
    StandardSystemProperty localStandardSystemProperty7 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_NAME", 6, "java.vm.specification.name");
    JAVA_VM_SPECIFICATION_NAME = localStandardSystemProperty7;
    StandardSystemProperty localStandardSystemProperty8 = new StandardSystemProperty("JAVA_VM_VERSION", 7, "java.vm.version");
    JAVA_VM_VERSION = localStandardSystemProperty8;
    StandardSystemProperty localStandardSystemProperty9 = new StandardSystemProperty("JAVA_VM_VENDOR", 8, "java.vm.vendor");
    JAVA_VM_VENDOR = localStandardSystemProperty9;
    StandardSystemProperty localStandardSystemProperty10 = new StandardSystemProperty("JAVA_VM_NAME", 9, "java.vm.name");
    JAVA_VM_NAME = localStandardSystemProperty10;
    StandardSystemProperty localStandardSystemProperty11 = new StandardSystemProperty("JAVA_SPECIFICATION_VERSION", 10, "java.specification.version");
    JAVA_SPECIFICATION_VERSION = localStandardSystemProperty11;
    StandardSystemProperty localStandardSystemProperty12 = new StandardSystemProperty("JAVA_SPECIFICATION_VENDOR", 11, "java.specification.vendor");
    JAVA_SPECIFICATION_VENDOR = localStandardSystemProperty12;
    StandardSystemProperty localStandardSystemProperty13 = new StandardSystemProperty("JAVA_SPECIFICATION_NAME", 12, "java.specification.name");
    JAVA_SPECIFICATION_NAME = localStandardSystemProperty13;
    StandardSystemProperty localStandardSystemProperty14 = new StandardSystemProperty("JAVA_CLASS_VERSION", 13, "java.class.version");
    JAVA_CLASS_VERSION = localStandardSystemProperty14;
    StandardSystemProperty localStandardSystemProperty15 = new StandardSystemProperty("JAVA_CLASS_PATH", 14, "java.class.path");
    JAVA_CLASS_PATH = localStandardSystemProperty15;
    StandardSystemProperty localStandardSystemProperty16 = new StandardSystemProperty("JAVA_LIBRARY_PATH", 15, "java.library.path");
    JAVA_LIBRARY_PATH = localStandardSystemProperty16;
    StandardSystemProperty localStandardSystemProperty17 = new StandardSystemProperty("JAVA_IO_TMPDIR", 16, "java.io.tmpdir");
    JAVA_IO_TMPDIR = localStandardSystemProperty17;
    StandardSystemProperty localStandardSystemProperty18 = new StandardSystemProperty("JAVA_COMPILER", 17, "java.compiler");
    JAVA_COMPILER = localStandardSystemProperty18;
    StandardSystemProperty localStandardSystemProperty19 = new StandardSystemProperty("JAVA_EXT_DIRS", 18, "java.ext.dirs");
    JAVA_EXT_DIRS = localStandardSystemProperty19;
    StandardSystemProperty localStandardSystemProperty20 = new StandardSystemProperty("OS_NAME", 19, "os.name");
    OS_NAME = localStandardSystemProperty20;
    StandardSystemProperty localStandardSystemProperty21 = new StandardSystemProperty("OS_ARCH", 20, "os.arch");
    OS_ARCH = localStandardSystemProperty21;
    StandardSystemProperty localStandardSystemProperty22 = new StandardSystemProperty("OS_VERSION", 21, "os.version");
    OS_VERSION = localStandardSystemProperty22;
    StandardSystemProperty localStandardSystemProperty23 = new StandardSystemProperty("FILE_SEPARATOR", 22, "file.separator");
    FILE_SEPARATOR = localStandardSystemProperty23;
    StandardSystemProperty localStandardSystemProperty24 = new StandardSystemProperty("PATH_SEPARATOR", 23, "path.separator");
    PATH_SEPARATOR = localStandardSystemProperty24;
    StandardSystemProperty localStandardSystemProperty25 = new StandardSystemProperty("LINE_SEPARATOR", 24, "line.separator");
    LINE_SEPARATOR = localStandardSystemProperty25;
    StandardSystemProperty localStandardSystemProperty26 = new StandardSystemProperty("USER_NAME", 25, "user.name");
    USER_NAME = localStandardSystemProperty26;
    StandardSystemProperty localStandardSystemProperty27 = new StandardSystemProperty("USER_HOME", 26, "user.home");
    USER_HOME = localStandardSystemProperty27;
    StandardSystemProperty localStandardSystemProperty28 = new StandardSystemProperty("USER_DIR", 27, "user.dir");
    USER_DIR = localStandardSystemProperty28;
    $VALUES = new StandardSystemProperty[] { localStandardSystemProperty1, localStandardSystemProperty2, localStandardSystemProperty3, localStandardSystemProperty4, localStandardSystemProperty5, localStandardSystemProperty6, localStandardSystemProperty7, localStandardSystemProperty8, localStandardSystemProperty9, localStandardSystemProperty10, localStandardSystemProperty11, localStandardSystemProperty12, localStandardSystemProperty13, localStandardSystemProperty14, localStandardSystemProperty15, localStandardSystemProperty16, localStandardSystemProperty17, localStandardSystemProperty18, localStandardSystemProperty19, localStandardSystemProperty20, localStandardSystemProperty21, localStandardSystemProperty22, localStandardSystemProperty23, localStandardSystemProperty24, localStandardSystemProperty25, localStandardSystemProperty26, localStandardSystemProperty27, localStandardSystemProperty28 };
  }
  
  private StandardSystemProperty(String paramString)
  {
    this.key = paramString;
  }
  
  public String key()
  {
    return this.key;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(key());
    localStringBuilder.append("=");
    localStringBuilder.append(value());
    return localStringBuilder.toString();
  }
  
  @NullableDecl
  public String value()
  {
    return System.getProperty(this.key);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\StandardSystemProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */