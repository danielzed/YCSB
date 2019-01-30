#include <jni.h>
#include "leveldb/env.h"
#include "LevelDbJniClientN.h"
#include <leveldb/db.h>
#include <thread>
#include <cstdlib>
#include <sys/types.h>
#include <stdio.h>
leveldb::DB* db;
JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cinit(JNIEnv *, jobject)
{
leveldb::Options options;
options.create_if_missing = true;
leveldb::DB::Open(options,"./leveldb_database",&db);
}
JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_ccleanup(JNIEnv *, jobject)
{
delete db;
}
 JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cdelete(JNIEnv *, jobject, jstring)
{

}
 JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cinsert(JNIEnv *env, jobject, jstring key, jstring value)
{
std::string keystr = env->GetStringUTFChars(key, NULL);
std::string valuestr = env->GetStringUTFChars(value, NULL);
db->Put(leveldb::WriteOptions(), keystr, valuestr);
}
 JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cread(JNIEnv *env, jobject, jstring key)
{
std::string valuestr;
std::string keystr = env->GetStringUTFChars(key, NULL);
db->Get(leveldb::ReadOptions(), keystr, &valuestr);
}
 JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cupdate(JNIEnv *, jobject, jstring, jstring)
{

}
 JNIEXPORT void JNICALL Java_com_yahoo_ycsb_db_LevelDbJniClientN_cscan(JNIEnv *, jobject, jstring, jint)
{}
 
