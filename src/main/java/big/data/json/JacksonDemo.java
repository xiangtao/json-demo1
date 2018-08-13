package big.data.json;

import big.data.json.bean.Student;
import big.data.json.bean.ds.DataSource;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * demo
 * @author taox
 */
public class JacksonDemo {

    static ObjectMapper mapper = new ObjectMapper();
    static {
        //美化输出
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    //简单bean映射
    @Test
    public void simpleObject() throws IOException {

        Student student = new Student();
        student.setName("\u0061");
        student.setAge(18);
        student.setStatus(true);
        student.setB(new byte[]{'1','2'});
        student.setI(new int[]{1,2});


        //输出json字符串
        String str = mapper.writeValueAsString(student);
        System.out.println("out json string = " + str);

        //从json string读入对象
        Student newVal = mapper.readValue(str,Student.class);
        System.out.println("new Student = " + newVal);

    }

    //集合映射
    @Test
    public  void simpleCollection() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("age", 25);
        map.put("name", "taox");
        map.put("interests", new String[]{"pc games","prog"});

        String text = mapper.writeValueAsString(map);
        System.out.println(text);

        Map<String,Object> outMap = mapper.readValue(text,Map.class);
        System.out.println(outMap);

        outMap = mapper.readValue(text,new TypeReference<Map<String, Object>>(){});

        Student student = new Student();
        student.setName("stud1");
        List<Student> list = new ArrayList<Student>();
        list.add(student);

        text = mapper.writeValueAsString(list);
        System.out.println("list out = " + text);

        //其实得到的是 List<Map>
        List<Student> students = mapper.readValue(text,List.class);
        System.out.println(students);

        //要转换成特定类型，
        // 1、使用 new TypeReference
        students = mapper.readValue(text,new TypeReference<List<Student>>(){});
        System.out.println(students);

        // 2、或者使用 JavaType
        JavaType javaType = TypeFactory.defaultInstance().constructParametricType(List.class, Student.class);
        students = mapper.readValue(text,javaType);
        System.out.println(students);
    }


    //面向对象映射
    @Test
    public  void simpleOOP() throws IOException {
        String str = readConfig();
        JavaType javaType = TypeFactory.defaultInstance().constructParametricType(List.class, DataSource.class);
        List<DataSource> dataSourceList = mapper.readValue(str,javaType);
        System.out.println(dataSourceList);

        String out = mapper.writeValueAsString(dataSourceList);
        System.out.println("out = " + out);

    }


    //unicode 字符
    @Test
    public void testUnicodeString() throws IOException {
        String json1 = "{\"name\":\"\\u0061\"}";
        System.out.println(json1);
        Map map = mapper.readValue(json1,Map.class);


        String json2 = "{\"name\":\"a\"}";
        System.out.println(json2);
        Map map2 = mapper.readValue(json2,Map.class);

        Assert.assertEquals("a",map.get("name"));
        Assert.assertEquals("a",map2.get("name"));

    }


    //-----------private -------------
    private static String readConfig() throws IOException {
        InputStream is = JacksonDemo.class.getClassLoader().getResourceAsStream("datasource-config.json");
        List<String> lines = IOUtils.readLines(is, "utf-8");
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }


}
