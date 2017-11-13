package org.bdframe.core.hadoop.hbase;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("hbaseService") 
public class HbaseServiceImpl  {
	@Resource(name = "hbaseTemplate")  
    private HbaseTemplate hbaseTemplate;  
    // 获取表中指定行，列簇，列的值  
    public String get(String tableName, String rowName, String familyName,  
            String qualifier) {  
        return hbaseTemplate.get(tableName, rowName, familyName, qualifier,  
                new RowMapper<String>() {  
                    public String mapRow(Result result, int rowNum)  
                            throws Exception {  
                        List<Cell> ceList = result.listCells();  
                        String res = "";  
                        if (ceList != null && ceList.size() > 0) {  
                            for (Cell cell : ceList) {  
                                res = Bytes.toString(cell.getValueArray(),  
                                        cell.getValueOffset(),  
                                        cell.getValueLength());  
                            }  
                        }  
                        return res;  
                    }  
                });  
    }  
      
    
    // 将值插入表中指定的行，列簇，列中  
    public void put1(final String tableName, final String rowKey,  
            final String familyName, final String column, final String value) {  
    	hbaseTemplate.put(tableName, rowKey, familyName, column, value.getBytes());  
    }  
    
    public boolean put(final String tableName, final String rowKey,  
            final String familyName, final String column, final String value) {  
        Assert.hasLength(tableName, "必须指定表名!");  
        Assert.hasLength(rowKey, "必须指定行!");  
        Assert.hasLength(familyName, "必须指定列簇!");  
        Assert.hasLength(column, "必须指定列名!");  
        Assert.notNull(value, "要插入表中的值不能为空!");  
        return hbaseTemplate.execute(tableName, new TableCallback<Boolean>() {  
            boolean isinsert = false;  
            @Override  
            public Boolean doInTable(HTableInterface table) {  
                try {  
                    Put put = new Put(rowKey.getBytes());  
                    put.add(Bytes.toBytes(familyName), Bytes.toBytes(column),  
                            Bytes.toBytes(value));  
                    table.put(put);  
                    isinsert = true;  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
                return isinsert;  
            }  
        });  
    }  

    /*
     * 查询列族下的列的数据
     */
	public List<String> find(String tableName, String family, String cloumn) {
		List<String> rows = hbaseTemplate.find(tableName, family, cloumn, new RowMapper<String>() {
			public String mapRow(Result result, int rowNum) throws Exception {
				return Bytes.toString(result.getRow());
			}
		});
		return rows;
	}

	/*
	 * 查询指定行健的一列数据
	 */
	public String get1(String tableName, String family, String cloumn, String rowKey) {
		String context = hbaseTemplate.get(tableName, rowKey, family, cloumn,
				new RowMapper<String>() {
					public String mapRow(Result result, int rowNum) throws Exception {
						return Bytes.toString(result.value());
					}
				});
		return context;
	}
}
