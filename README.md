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