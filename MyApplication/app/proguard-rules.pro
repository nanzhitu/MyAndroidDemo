# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-ignorewarnings

# 代码混淆压缩比，在0~7之间，默认为5，一般不做修改
-optimizationpasses 5

# 混合时不使用大小写混合，混合后的类名为小写
-dontusemixedcaseclassnames

# 指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses

# 指定不去忽略非公共库的类成员
-dontskipnonpubliclibraryclassmembers

-keepattributes Signature

# 保留Annotation不混淆
-keepattributes *Annotation*,InnerClasses

#############################################
 #
 # Android开发中一些需要保留的公共部分
 #
 #############################################

 # 保留我们使用的四大组件，自定义的Application等等这些类不被混淆
 # 因为这些子类都有可能被外部调用
 -keep public class * extends android.app.Activity
 -keep public class * extends android.app.Appliction
 -keep public class * extends android.app.Service
 -keep public class * extends android.content.BroadcastReceiver
 -keep public class * extends android.content.ContentProvider
 -keep public class * extends android.app.backup.BackupAgentHelper
 -keep public class * extends android.preference.Preference
 -keep public class * extends android.view.View
 -keep public class com.android.vending.licensing.ILicensingService

 # 保留support下的所有类及其内部类
 -keep class android.support.** {*;}

 # 保留继承的
 -keep public class * extends android.support.v4.**
 -keep public class * extends android.support.v7.**
 -keep public class * extends android.support.annotation.**


 -keepclasseswithmembernames class * {
     native <methods>;
 }

 -keepclassmembers class * extends android.app.Activity { #不混淆Activity中参数类型为View的所有方法
    public void *(android.view.View);
 }

 -keepclassmembers public class * extends android.view.View {#所有View的子类及其子类的get、set方法都不进行混淆
    void set*(***);
    *** get*();
 }

 #不混淆R类里及其所有内部static类中的所有static变量字段
 -keepclassmembers class **.R$* {
     public static <fields>;
 }

  -keep class **.R$* { *; }

# 保留枚举类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 对于带有回调函数的onXXEvent、**On*Listener的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}

  #保持 Parcelable 不被混淆
   -keep class * implements android.os.Parcelable {
   public static final android.os.Parcelable$Creator *;
    }
  #保持 Serializable 不被混淆
 -keepnames class * implements java.io.Serializable

#################################################################

 # OkHttp
   -keep class okhttp3.** { *; }
   -keep interface okhttp3.** { *; }
   -dontwarn okhttp3.**

  -keep class com.squareup.okhttp.** { *; }
  -keep interface com.android.okhttp.** { *; }
  -dontwarn com.squareup.okhttp.**
 #end

  # gson
  -dontwarn com.google.gson.**
  -keep class com.google.gson.** { *; }

 #end