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