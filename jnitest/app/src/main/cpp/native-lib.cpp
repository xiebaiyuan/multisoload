#include <jni.h>
#include <string>
#include "test1.h"

extern "C" JNIEXPORT jstring

JNICALL
Java_com_example_xiebaiyuan_jnitest_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    test1 t;
    return env->NewStringUTF(t.Test1Str().c_str());
}
