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
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
-ignorewarnings
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*,!code/allocation/variable

# 记录生成的日志数据，在mapping目录下
-printmapping build/outputs/mapping/release/mapping.txt

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

-dontwarn javax.annotation.**

-dontwarn android.app.**
-dontwarn android.support.**
-dontwarn android.view.**
-dontwarn android.widget.**

-keepclasseswithmembernames class * {
     native <methods>;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}


-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

-keepattributes *Annotation*
-keepattributes Exceptions
-keepattributes InnerClasses
-keepattributes Signature
-keepattributes Deprecated
-keepattributes SourceFile
-keepattributes LineNumberTable
-keepattributes LocalVariable*Table
-keepattributes Synthetic
-keepattributes EnclosingMethod

# okhttp3
-dontwarn okhttp3.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
# A resource is loaded with mBuildingId relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

#eventbus
-keepattributes *Annotation*
-keepclassmembers class * {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

#retrofit2
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain service method parameters.
-keepclassmembernames,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
# Ignore annotation used for build tooling.
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement


#IJK 混淆配置
-keepclasseswithmembers class tv.danmaku.ijk.media.player.IjkMediaPlayer {
    <fields>;
    <methods>;
}


# 3D 地图 V5.0.0之前：
-keep   class com.amap.api.maps.**{*;}
-keep   class com.autonavi.amap.mapcore.*{*;}
-keep   class com.amap.api.trace.**{*;}

# 3D 地图 V5.0.0之后：
-keep   class com.amap.api.maps.**{*;}
-keep   class com.autonavi.**{*;}
-keep   class com.amap.api.trace.**{*;}

# 定位
-keep class com.amap.api.location.**{*;}
-keep class com.amap.api.fence.**{*;}
-keep class com.autonavi.aps.amapapi.model.**{*;}

# 搜索
-keep   class com.amap.api.services.**{*;}

# 2D地图
-keep class com.amap.api.maps2d.**{*;}
-keep class com.amap.api.mapcore2d.**{*;}

# 导航
-keep class com.amap.api.navi.**{*;}
-keep class com.autonavi.**{*;}


# 内置语音 V5.6.0之后
#-keep class com.alibaba.idst.nls.** {*;}
#-keep class com.google.**{*;}
#-keep class com.nlspeech.nlscodec.** {*;}


#########广告SDK 需要配置的混淆信息###########
-dontwarn com.kaolafm.ad.sdk.core.**
-keep class com.kaolafm.ad.sdk.core.** { *; }

-dontwarn com.kaolafm.ad.engine.api.**
-keep class com.kaolafm.ad.engine.api.** { *; }

-dontwarn com.androidquery.**
-keep class com.androidquery.** { *; }


#########SDK 需要配置的混淆信息###########
-dontwarn com.kaolafm.sdk.**
-keep class com.kaolafm.sdk.** { *; }

#########ClientSDK不混淆###########
-keep class com.kaolafm.sdk.client.** { *; }

-keep class **.R$* {
 *;
}

-keepclassmembers class * {
    void *(*Event);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#// natvie 方法不混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

#----------------------------------------------------------------------------

#---------------------------------webview------------------------------------
-keepclassmembers class fqcn.of.javascript.interface.for.Webview {
   public *;
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, jav.lang.String);
}

#支付宝支付
-keep class com.alipay.android.app.IAlixPay{*;}
-keep class com.alipay.android.app.IAlixPay$Stub{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback$Stub{*;}
-keep class com.alipay.sdk.app.PayTask{ public *;}
-keep class com.alipay.sdk.app.AuthTask{ public *;}
-keep public class * extends android.os.IInterface
#微信支付
-keep class com.tencent.mm.sdk.openapi.WXMediaMessage {*;}
-keep class com.tencent.mm.sdk.openapi.** implements com.tencent.mm.sdk.openapi.WXMediaMessage$IMediaObject {*;}
-keep class com.tencent.wxop.** { *; }
-dontwarn com.tencent.mm.**
-keep class com.tencent.mm.**{*;}

-keep class sun.misc.Unsafe { *; }

-keep class com.taobao.** {*;}
-keep class com.alibaba.** {*;}
-keep class com.alipay.** {*;}
-dontwarn com.taobao.**
-dontwarn com.alibaba.**
-dontwarn com.alipay.**

-keep class com.ut.** {*;}
-dontwarn com.ut.**

-keep class com.ta.** {*;}
-dontwarn com.ta.**

-keep class anet.**{*;}
-keep class org.android.spdy.**{*;}
-keep class org.android.agoo.**{*;}
-dontwarn anet.**
-dontwarn org.android.spdy.**
-dontwarn org.android.agoo.**

-dontwarn com.xiaomi.push.service.b

-keep class org.apache.http.**
-keep interface org.apache.http.**
-dontwarn org.apache.**

#okhttp3.x
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}

#sharesdk
-keep class cn.sharesdk.**{*;}
-keep class com.sina.**{*;}
-keep class **.R$* {*;}
-keep class **.R{*;}

-keep class com.mob.**{*;}
-dontwarn com.mob.**
-dontwarn cn.sharesdk.**
-dontwarn **.R$*

## nineoldandroids-2.4.0.jar
-keep public class com.nineoldandroids.** {*;}

####################zxing#####################
-keep class com.google.zxing.** {*;}
-dontwarn com.google.zxing.**
##百度定位
-keep class com.baidu.** {*;}
-keep class vi.com.** {*;}
-dontwarn com.baidu.**

## okhttp
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.{*;}
#retrofit
-dontwarn retrofit.**
-keep class retrofit.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-dontwarn okio.**

#recyclerview-animators
-keep class jp.wasabeef.** {*;}
-dontwarn jp.wasabeef.*

#multistateview
-keep class com.kennyc.view.** { *; }
-dontwarn com.kennyc.view.*

# universal-image-loader 混淆
-dontwarn com.nostra13.universalimageloader.**
-keep class com.nostra13.universalimageloader.** { *; }

#ormlite
-keep class com.j256.**
-keepclassmembers class com.j256.** { *; }
-keep enum com.j256.**
-keepclassmembers enum com.j256.** { *; }
-keep interface com.j256.**
-keepclassmembers interface com.j256.** { *; }
#umeng
# ========= 友盟   现在已经没有 使用=================
#-dontshrink
#-dontoptimize
#-dontwarn com.google.android.maps.**
#-dontwarn android.webkit.WebView
#-dontwarn com.umeng.**
#-dontwarn com.tencent.weibo.sdk.**
#-dontwarn com.facebook.**


-keep enum com.facebook.**
-keepattributes Exceptions,InnerClasses,Signature
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable

-keep public interface com.facebook.**
-keep public interface com.tencent.**
#-keep public interface com.umeng.socialize.**
#-keep public interface com.umeng.socialize.sensor.**
#-keep public interface com.umeng.scrshot.**

#-keep public class com.umeng.socialize.* {*;}
-keep public class javax.**
-keep public class android.webkit.**

-keep class com.facebook.**
#-keep class com.umeng.scrshot.**
-keep public class com.tencent.** {*;}
#-keep class com.umeng.socialize.sensor.**

-keep class com.tencent.mm.sdk.modelmsg.WXMediaMessage {*;}

-keep class com.tencent.mm.sdk.modelmsg.** implements com.tencent.mm.sdk.modelmsg.WXMediaMessage$IMediaObject {*;}

-keep class im.yixin.sdk.api.YXMessage {*;}
-keep class im.yixin.sdk.api.** implements im.yixin.sdk.api.YXMessage$YXMessageData{*;}
-keepclassmembers class * {
   public <init> (org.json.JSONObject);
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#友盟自动更新 无用
#-keep public class com.umeng.fb.ui.ThreadView {
#}
#-keep public class * extends com.umeng.**
## 以下包不进行过滤
#-keep class com.umeng.** { *; }
#友盟自动更新
#-keep public class com.umeng.fb.ui.ThreadView {
#}
#-keep public class * extends com.umeng.**
## 以下包不进行过滤
#-keep class com.umeng.** { *; }


#-ButterKnife 7.0
 -keep class butterknife.** { *; }
 -dontwarn butterknife.internal.**
 -keep class **$$ViewBinder { *; }
 -keepclasseswithmembernames class * {
  @butterknife.* <fields>;
 }
 -keepclasseswithmembernames class * {
 @butterknife.* <methods>;
 }


#AndFix
-keep class * extends java.lang.annotation.Annotation
-keepclasseswithmembernames class * {
    native <methods>;
}

#eventbus 3.0
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}


#EventBus
-keepclassmembers class ** {
    public void onEvent*(**);
}


#################gson   ##################
-keep class com.google.gson.** {*;}
#-keep class com.google.**{*;}
#这个没有去掉，是有重复的
#-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
#################gson##################
#-keep class com.google.gson.** {*;}
#-keep class com.google.**{*;}
#-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }
#-keep class com.google.gson.examples.android.model.** { *; }

-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-keep public class * implements java.io.Serializable {*;}

# support v4 ,v7 存在很多无用的方法，不混淆有 1.8万左右，混淆后 不到0.8万方法
# support-v4
#https://stackoverflow.com/questions/18978706/obfuscate-android-support-v7-widget-gridlayout-issue
#-dontwarn android.support.v4.**
#-keep class android.support.v4.app.** { *; }
#-keep interface android.support.v4.app.** { *; }
#-keep class android.support.v4.** { *; }


# support-v7
#-dontwarn android.support.v7.**
#-keep class android.support.v7.internal.** { *; }
#-keep interface android.support.v7.internal.** { *; }
#-keep class android.support.v7.** { *; }

# support design
#@link http://stackoverflow.com/a/31028536
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }
#-------------------------------------------------------------------------

# picasso
#-keep class com.squareup.picasso.** {*; }
#-dontwarn com.squareup.picasso.**

#glide 4.x
#由*	chenyongta*贡献混淆代码
#作者Github地址：https://github.com/yourtion
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# #  ######## greenDao混淆  ##########
# # -------------------------------------------
-keep class de.greenrobot.dao.** {*;}
-keepclassmembers class * extends de.greenrobot.dao.AbstractDao {
    public static Java.lang.String TABLENAME;
}
-keep class **$Properties
# #  ############### volley混淆  ###############
# # -------------------------------------------
-keep class com.android.volley.** {*;}
-keep class com.android.volley.toolbox.** {*;}
-keep class com.android.volley.Response$* { *; }
-keep class com.android.volley.Request$* { *; }
-keep class com.android.volley.RequestQueue$* { *; }
-keep class com.android.volley.toolbox.HurlStack$* { *; }
-keep class com.android.volley.toolbox.ImageLoader$* { *; }

#jpush极光推送
-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }

#activeandroid
-keep class com.activeandroid.** { *; }
-dontwarn com.ikoding.app.biz.dataobject.**
-keep public class com.ikoding.app.biz.dataobject.** { *;}
-keepattributes *Annotation*

#log4j
-dontwarn org.apache.log4j.**
-keep class  org.apache.log4j.** { *;}
#下面几行 是环信即时通信的代码混淆
-keep class com.easemob.** {*;}
-keep class org.jivesoftware.** {*;}
-dontwarn  com.easemob.**

#融云
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
 public *;
}

-keepattributes Exceptions,InnerClasses

-keep class io.rong.** {*;}

-keep class * implements io.rong.imlib.model.MessageContent{*;}

-keepattributes Signature

-keepattributes *Annotation*

-keep class sun.misc.Unsafe { *; }

#-keep class com.google.gson.examples.android.model.** { *; }

-keepclassmembers class * extends com.sea_monster.dao.AbstractDao {
 public static java.lang.String TABLENAME;
}
-keep class **$Properties
-dontwarn org.eclipse.jdt.annotation.**

-keep class com.ultrapower.** {*;}
##高徳地图
#-dontwarn com.amap.api.**
#-dontwarn com.mBuildingId.mBuildingId.**
#-dontwarn com.autonavi.**
#-keep class com.amap.api.**  {*;}
#-keep class com.autonavi.**  {*;}
#-keep class com.mBuildingId.mBuildingId.**  {*;}
#---------------------------------反射相关的类和方法-----------------------
#在这下面写反射相关的类和方法，没有就不用写！


#SuperID
#由*郭宇翔*贡献混淆代码
#作者Github地址：https://github.com/yourtion
-keep class **.R$* {*;}
-keep class com.isnc.facesdk.aty.**{*;}
-keep class com.isnc.facesdk.**{*;}
-keep class com.isnc.facesdk.common.**{*;}
-keep class com.isnc.facesdk.net.**{*;}
-keep class com.isnc.facesdk.view.**{*;}
-keep class com.isnc.facesdk.viewmodel.**{*;}
-keep class com.matrixcv.androidapi.face.**{*;}

#retrofit2.x
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

#Rxjava RxAndroid
-dontwarn rx.*
-dontwarn sun.misc.**

-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}

-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}

-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

#litepal
-dontwarn org.litepal.
-dontwarn org.litepal.
-keep class org.litepal.* { *; }
-keep enum org.litepal.*
-keep interface org.litepal. { *; }
#-keep public class  extends org.litepal. { *; }
-keepattributes Annotation
-keepclassmembers class * extends org.litepal.crud.DataSupport{*;}

#fastJson
-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.** { *; }

# Okio
-dontwarn com.squareup.**
-dontwarn okio.**
-keep public class org.codehaus.* { *; }
-keep public class java.nio.* { *; }
# Retrolambda
-dontwarn java.lang.invoke.*

#小米push
-keepclasseswithmembernames class com.xiaomi.**{*;}
-keep public class * extends com.xiaomi.mipush.sdk.PushMessageReceiver


#fresco
# Do not strip any method/class that is annotated with @DoNotStrip
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}

#########科大讯飞SDK不混淆###########
#-dontwarn class com.iflytek.**
-keep class com.iflytek.** { *; }
-keepattributes Signature

#greendao
-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
public static java.lang.String TABLENAME;
}
-keep class **$Properties

# If you do not use SQLCipher:
-dontwarn org.greenrobot.greendao.database.**
## If you do not use Rx:
#-dontwarn rx.**

-keep interface * implements com.alibaba.android.arouter.facade.template.IProvider
-keep public class com.alibaba.android.arouter.routes.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}

-keep class com.kaolafm.kradio.eb.data.** { *; }

-dontwarn org.apache.http.**
-keep class org.apache.http.** { *; }

-dontwarn com.kaolafm.kradio.k_user.request.**
-keep class com.kaolafm.kradio.k_user.request.** { *; }

-keep class com.kaolafm.kradio.k_kaolafm.subscribe.data.** { *; }
-keep class com.kaolafm.kradio.k_kaolafm.music.bean.** { *; }

-keep class com.kaolafm.kradio.db.bean.** { *; }

-keep class com.kaolafm.kradio.k_kaolafm.categories.bean.** { *; }

-keep class com.kaolafm.kradio.k_kaolafm.home.data.** { *; }
-keep class com.kaolafm.kradio.lib.common.** { *; }

# bugly混淆配置
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}

#-keep class com.kaolafm.kradio.k_kaolafm.xmly.bean.** { *; }

-dontwarn okio.**
-keep class okio.** { *; }

-dontwarn okhttp3.**
-keep class okhttp3.** { *; }

#-dontwarn com.ximalaya.ting.android.**
#-keep interface com.ximalaya.ting.android.** {*;}
#-keep class com.ximalaya.ting.android.** { *; }
#-keep public class com.kaolafm.kradio.assistant.speechvendor.iflytek.** { *; }
#实现该接口的不被混淆
-keep public class * implements com.kaolafm.kradio.lib.common.Keepable {*;}
-keep public class * implements com.kaolafm.kradio.lib.http.ConfigModule {*;}
-dontwarn com.netease.**
-keep class com.netease.** {*;}

#新版SDK
-dontwarn com.kaolafm.sdk.**
-keep class com.kaolafm.sdk.** { *; }
-keepclasseswithmembers class tv.danmaku.ijk.media.player.IjkMediaPlayer {
    <fields>;
    <methods>;
}

-dontwarn com.kaolafm.opensdk.**
-keep class com.kaolafm.opensdk.** {*;}

-dontwarn com.tencent.qqmusic.qzdownloader.downloader.strategy.**
-keep class com.tencent.qqmusic.qzdownloader.downloader.strategy.** {*;}

#flavor相关类不需要混淆
-dontwarn com.kaolafm.kradio.flavor.**
-keep class com.kaolafm.kradio.flavor.** {*;}

-dontwarn com.kaolafm.report.**
-keep class com.kaolafm.report.** { *; }
-keepclassmembernames class com.kaolafm.report.** { *; }

#东风日产SDK混淆配置
-dontwarn com.hsae.autosdk.settings.AutoSettings
-keep class com.hsae.autosdk.settings.AutoSettings { *; }

#车联天下SDK混淆配置
-dontwarn com.autosee.vr.**
-keep class com.autosee.vr.** { *; }

#changan SDK混淆配置

-dontwarn com.incall.**
-keep class com.incall.** { *; }
-dontwarn com.zhonghong.**
-keep class com.zhonghong.** { *; }

-dontwarn org.xmlpull.v1.XmlPullParser
-dontwarn org.xmlpull.v1.XmlSerializer
-keep class org.xmlpull.v1.* {*;}

#亿咖通SDK混淆配置
-dontwarn com.ecarx.sdk.**
-keep class com.ecarx.sdk.** { *; }


#亿咖通
-keepclasseswithmembernames class com.kaolafm.opensdk.api.ex.DeviceInfo { *; }

#dialogs
-keep class com.kaolafm.kradio.flavor.impl.DialogFactory { *; }
-keep class com.kaolafm.kradio.view.DialogFactory { *; }

-keep class * implements com.kaolafm.kradio.component.Component{*;}

# ProGuard configurations for NetworkBench Lens
-keep class com.networkbench.** { *; }
-dontwarn com.networkbench.**
-keepattributes Exceptions, Signature, InnerClasses
# End NetworkBench Lens

-keep class com.kaolafm.kradio.k_kaolafm.user.request.model.** { *; }


#凯翼混淆配置
-dontwarn com.kaolafm.kradio.kaiyi.**
-keep class com.kaolafm.kradio.kaiyi.** { *; }