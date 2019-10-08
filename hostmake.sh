./gradlew clean assembleRelease
adb install app/build/outputs/apk/release/app-release.apk
cd ./PluginDemo
./make.sh