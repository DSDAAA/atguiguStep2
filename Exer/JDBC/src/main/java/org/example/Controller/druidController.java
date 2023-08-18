package org.example.Controller;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class druidController {
    @Test
    public void test() throws Exception {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        properties.list(System.out);
        DruidDataSourceFactory.createDataSource(properties);
    }
}
