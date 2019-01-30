/**
 * LevelDB client binding for YCSB.
 */

package com.yahoo.ycsb.db;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;


import com.yahoo.ycsb.ByteIterator;
import com.yahoo.ycsb.DB;
import com.yahoo.ycsb.DBException;
import com.yahoo.ycsb.StringByteIterator;
import com.yahoo.ycsb.Status;

/**
 * LevelDBJni client for YCSB framework.
 */
public class LevelDbJniClientN extends DB {
  static{
    System.loadLibrary("Client");
  }
  private static final  AtomicInteger INITCOUNT = new AtomicInteger(0);

  private static byte[] mapToBytes(Map<String, String> map)
      throws IOException {
    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(byteOut);
    out.writeObject(map);
    return byteOut.toByteArray();
  }

  private static Map<String, String> bytesToMap(byte[] bytes)
      throws IOException, ClassNotFoundException {
    ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
    ObjectInputStream in = new ObjectInputStream(byteIn);
    @SuppressWarnings("unchecked")
    Map<String, String> map = (Map<String, String>) in.readObject();
    return map;
  }

  /**
   * Initialize any state for this DB. Called once per DB instance; there is
   * one DB instance per client thread.
   */
  private native void cinit();
  @Override
  public void init() throws DBException {
    INITCOUNT.incrementAndGet();
    cinit();
  }

  /**
   * Cleanup any state for this DB. Called once per DB instance; there is one
   * DB instance per client thread.
   */
  private native void ccleanup();
  @Override
  public void cleanup() throws DBException {
    if (INITCOUNT.decrementAndGet() <= 0) {
      ccleanup();
    }
  }

  /**
   * Delete a record from the database.
   *
   * @param table
   *            The name of the table
   * @param key
   *            The record key of the record to delete.
   * @return Zero on success, a non-zero error code on error. See this class's
   *         description for a discussion of error codes.
   */
  private native void cdelete(String key);
  @Override
  public Status delete(String table, String key) {
    cdelete(key);
    return Status.OK;
  }

  /**
   * Insert a record in the database. Any field/value pairs in the specified
   * values HashMap will be written into the record with the specified record
   * key.
   *
   * @param table
   *            The name of the table
   * @param key
   *            The record key of the record to insert.
   * @param values
   *            A HashMap of field/value pairs to insert in the record
   * @return Zero on success, a non-zero error code on error. See this class's
   *         description for a discussion of error codes.
   */
  private native void cinsert(String key, String values);
  @Override
  public Status insert(final String table, final String key,
      final Map<String, ByteIterator> values) {
    //stringvalues convert to String
    Map<String, String> stringValues = StringByteIterator
        .getStringMap(values);
    try{
      String value = new String(mapToBytes(stringValues));
      cinsert(key, value);
    }catch (IOException e) {
      System.out.println("Failed to insert " + key);
      e.printStackTrace();
      return Status.ERROR;
    }
    
    
    return Status.OK;
  }

  /**
   * Read a record from the database. Each field/value pair from the result
   * will be stored in a HashMap.
   *
   * @param table
   *            The name of the table
   * @param key
   *            The record key of the record to read.
   * @param fields
   *            The list of fields to read, or null for all of them
   * @param result
   *            A HashMap of field/value pairs for the result
   * @return Zero on success, a non-zero error code on error or "not found".
   */
   //do i need to store the return String?
  private native void cread(String key);
  @Override
  public Status read(final String table, final String key, final Set<String> fields,
      final Map<String, ByteIterator> result) {
    cread(key);
    return Status.OK;
  }

  /**
   * Update a record in the database. Any field/value pairs in the specified
   * values HashMap will be written into the record with the specified record
   * key, overwriting any existing values with the same field name.
   *
   * @param table
   *            The name of the table
   * @param key
   *            The record key of the record to write.
   * @param values
   *            A HashMap of field/value pairs to update in the record
   * @return Zero on success, a non-zero error code on error. See this class's
   *         description for a discussion of error codes.
   */
  private native void cupdate(String key, String value);
  @Override
  public Status update(final String table, final String key,
      final Map<String, ByteIterator> values) {
    String value = "100";
    cupdate(key, value);
    return Status.OK;
  }

  /**
   * Perform a range scan for a set of records in the database. Each
   * field/value pair from the result will be stored in a HashMap.
   *
   * @param table
   *            The name of the table
   * @param startkey
   *            The record key of the first record to read.
   * @param recordcount
   *            The number of records to read
   * @param fields
   *            The list of fields to read, or null for all of them
   * @param result
   *            A Vector of HashMaps, where each HashMap is a set field/value
   *            pairs for one record
   * @return Zero on success, a non-zero error code on error. See this class's
   *         description for a discussion of error codes.
   */
  private native void cscan(String startkey, int recordcount);
  @Override
  public Status scan(String table, String startkey, int recordcount,
      Set<String> fields, Vector<HashMap<String, ByteIterator>> result) {
    cscan(startkey, recordcount);
    return Status.OK;
  }
}
