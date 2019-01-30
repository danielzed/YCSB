#include <jni.h>
/* Header for class HelloJNI */
 
#ifndef _Included_HelloJNI
#define _Included_HelloJNI
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cinit(JNIEnv *, jobject);
 JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_ccleanup(JNIEnv *, jobject);
 JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cdelete(JNIEnv *, jobject, jstring);
 JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cinsert(JNIEnv *, jobject, jstring, jstring);
 JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cread(JNIEnv *, jobject, jstring);
 JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cupdate(JNIEnv *, jobject, jstring, jstring);
 JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cscan(JNIEnv *, jobject, jstring, jint);
 
#ifdef __cplusplus
}
#endif
#endif
