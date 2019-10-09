./gradlew clean assembleRelease
adb install app/build/outputs/apk/release/app-release.apk
cd ./PluginDemo
./gradlew clean assemblePlugin
adb push app/build/outputs/apk/beijing/release/app-beijing-release.apk /sdcard/Test.apk
adb shell am force-stop com.didi.virtualapk
adb shell am start -n com.didi.virtualapk/com.didi.virtualapk.MainActivity
