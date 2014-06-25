package com.dennyac.HbaseTest;

//cc GetExample Example application retrieving data from HBase
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
//import util.HBaseHelper;


import java.io.IOException;

public class GetExample {

	public static void main(String[] args) throws IOException{
		// vv GetExample
		Configuration conf = HBaseConfiguration.create(); // co
															// GetExample-1-CreateConf
															// Create the
															// configuration.
															// conf.set("hbase.zookeeper.quorum",
															// "54.183.87.221");
		// conf.set("hbase.zookeeper.property.clientPort","2181");
		// ^^ GetExample
		// HBaseHelper helper = HBaseHelper.getHelper(conf);
		// if (!helper.existsTable("testtable")) {
		// helper.createTable("testtable", "colfam1");
		// }
		// vv GetExample
		HTable table = new HTable(conf, "denny_test"); // co
														// GetExample-2-NewTable
														// Instantiate a new
														// table reference.

		Get get = new Get(Bytes.toBytes("r1")); // co GetExample-3-NewGet
												// Create get with specific
												// row.

		get.addColumn(Bytes.toBytes("d"), Bytes.toBytes("c1")); // co
																// GetExample-4-AddCol
																// Add
																// a
																// column
																// to
																// the
																// get.

		Result result = table.get(get); // co GetExample-5-DoGet Retrieve row
										// with selected columns from HBase.

		byte[] val = result.getValue(Bytes.toBytes("d"), Bytes.toBytes("c1")); // co
																				// GetExample-6-GetValue
																				// Get
																				// a
																				// specific
																				// value
																				// for
																				// the
																				// given
																				// column.

		System.out.println("Value: " + Bytes.toString(val)); // co
																// GetExample-7-Print
																// Print out the
																// value while
																// converting it
																// back.
		// ^^ GetExample
		table.close();
	}
}