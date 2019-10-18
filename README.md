#### 引入bunen错误 
```
UNEXPECTED TOP-LEVEL EXCEPTION:
com.android.dex.DexException: Multiple dex files define Landroid/support/v4/accessibilityservice/AccessibilityServiceInfoCompat$AccessibilityServiceInfoVersionImpl;
	at com.android.dx.merge.DexMerger.readSortableTypes(DexMerger.java:661)
	at com.android.dx.merge.DexMerger.getSortedTypes(DexMerger.java:616)
	at com.android.dx.merge.DexMerger.mergeClassDefs(DexMerger.java:598)
	at com.android.dx.merge.DexMerger.mergeDexes(DexMerger.java:171)
	at com.android.dx.merge.DexMerger.merge(DexMerger.java:198)
	at com.android.dx.command.dexer.Main.mergeLibraryDexBuffers(Main.java:506)
	at com.android.dx.command.dexer.Main.runMonoDex(Main.java:336)
	at com.android.dx.command.dexer.Main.runDx(Main.java:291)
	at com.android.dx.command.dexer.Main.main(Main.java:247)
	at com.android.dx.command.Main.main(Main.java:94)
	
	原因: "implementation 'com.android.support:appcompat-v7:23.4.0'"
	解决: "implementation 'com.android.support:appcompat-v7:27.0.2'"
	
```
#### 插件对widget支持调研
* 方案一: 在插件中实现widget全部逻辑. (行不通, 系统无法通过 AndroidManifest文件找到 对widget支持, 所以无法加到系统 小部件里面)
* 方案二: 在宿主AndroidManifest文件中提供相关配置, 并实现相关布局文件, 在插件中实现AppWidgetProvider相关代码. 插件service中更新widget会报找不到id的问题. 
* 方案三: 在方案二基础上, 插件service中更新widget时替换布局文件. 也会报找不到id问题.
* 方案四: 暂时没有好办法. 暂时只能在宿主里面实现widget的相关逻辑. 插件提供数据. 

#### 插件对Fragmentation的支持
* 验证可以完美支持

#### 插件对横竖屏切换的支持
* 验证插件对横竖屏的支持, 验证通过. (需要修改<插件源码>. 修改插件预留占坑的Activity启动方式)

#### 插件对java1.8的支持
* 验证插件对java1.8的支持, 最后验证宿主使用java1.8编译失败. 但是插件可以使用. 这样不妨碍我们的app开发.

#### 插件对权限申请的支持
* 验证插件对权限申请的支持,已经添加完宿主关于权限的申请. 验证没有问题. 现在还差, 去系统设置中动态修改权限后, 验证再次获取权限的逻辑.

#### 插件对butterknife支持
* 最后调研结果. 只支持直接使用R资源方式, 咱不支持R2资源绑定方式. 解决方案, 现在咱们kradio使用的是多模块R2方式, 修改kaolafm模块为主项目, 然后把其他项目修改为直接引用资源方式. 这样改动最小, 完成的可能性最大.

#### 放器支持后台启动播放和控制
* 支持不启动activity, 启动后台service调研(为了实现, 直接启动后台播放功能), 这个已经验证成功. 实现方式是在宿主里面定义一个启动service. 这个service只用来外部app调用使用, 没有其他功能. demo已经上传到git.

#### 插件数据库支持
* 验证完美支持
#### 插件支持debug
#### 插件中放置so文件是否支持. 