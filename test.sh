sudo rm -r /mnt/f2fs/leveldb_database
./bin/ycsb load leveldbjnin -P workloads/workloada
./bin/ycsb run leveldbjnin -P workloads/workloada
