all:
	rm libleveldb.a
	sudo cp /home/daniel/projects/leveldb/libleveldb.a libleveldb.a
	g++ -shared -fPIC -std=c++11 -o libClient.so LevelDbJniClientN.cpp -L. libleveldb.a -lpthread -I/home/daniel/projects/leveldb/include -I/usr/lib/jvm/java-8-openjdk-amd64/include -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux
	sudo cp libClient.so /usr/lib/libClient.so
base:
	rm libleveldb.a
	sudo cp /home/daniel/leveldb/build/libleveldb.a libleveldb.a
	g++ -shared -fPIC -std=c++11 -o libClient.so LevelDbJniClientN.cpp -L. libleveldb.a -lpthread -I/home/daniel/leveldb/include -I/usr/lib/jvm/java-8-openjdk-amd64/include -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux
	sudo cp libClient.so /usr/lib/libClient.so
discrete:
	rm libleveldb.a
	sudo cp /home/daniel/projects/leveldb_improvement/libleveldb.a libleveldb.a
	g++ -shared -fPIC -std=c++11 -o libClient.so LevelDbJniClientN.cpp -L. libleveldb.a -lpthread -I/home/daniel/projects/leveldb_improvement/include -I/usr/lib/jvm/java-8-openjdk-amd64/include -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux
	sudo cp libClient.so /usr/lib/libClient.so
