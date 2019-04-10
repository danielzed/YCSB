mempar:
	sudo cp /home/daniel/leveldb/build/libleveldb.a libleveldb.a
	g++ -shared -fPIC -std=c++11 -o libClient.so LevelDbJniClientN.cpp -L. libleveldb.a -lpthread -I/home/daniel/leveldb/include -I/usr/lib/jvm/java-8-openjdk-amd64/include -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux
	sudo cp libClient.so /usr/lib/libClient.so
level0par:
	sudo cp /home/daniel/leveldb-level0section/build/libleveldb.a libleveldb.a
	g++ -shared -fPIC -std=c++11 -o libClient.so LevelDbJniClientN.cpp -L. libleveldb.a -lpthread -I/home/daniel/leveldb-level0section/include -I/usr/lib/jvm/java-8-openjdk-amd64/include -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux
	sudo cp libClient.so /usr/lib/libClient.so
base:
	sudo cp /home/daniel/leveldbbase/build/libleveldb.a libleveldb.a
	g++ -shared -fPIC -std=c++11 -o libClient.so LevelDbJniClientN.cpp -L. libleveldb.a -lpthread -I/home/daniel/leveldbbase/include -I/usr/lib/jvm/java-8-openjdk-amd64/include -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux
	sudo cp libClient.so /usr/lib/libClient.so
qiulin:
	sudo cp /home/daniel/leveldb_qiulin/build/libleveldb.a libleveldb.a
	g++ -shared -fPIC -std=c++11 -o libClient.so LevelDbJniClientN.cpp -L. libleveldb.a -lpthread -I/home/daniel/leveldb_qiulin/include -I/usr/lib/jvm/java-8-openjdk-amd64/include -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux
	sudo cp libClient.so /usr/lib/libClient.so
