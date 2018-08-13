package big.data.json;

import big.data.json.bean.Student;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * jackson vs fastjson
 */
public class JsonCompare {

    @Test
    public void compareSer() throws Exception {
        warmUp();
        //fastjsonser();
        jacksonSer();

    }

    @Test
    public void compareDeser() throws Exception {
        warmUp();

        fastjsondeser();
        jacksondeser();

    }

    public void fastjsonser() throws Exception {
        Student student = new Student();
        student.setName("\u0061");
        student.setAge(18);
        student.setStatus(true);

        long start = System.currentTimeMillis();
        ISerializer fastjsonSerializer = new FastjsonSerializer();
        int i=0;
        while (i<1000000){
            fastjsonSerializer.ser(student);
            i++;
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    public void jacksonSer() throws Exception {

        Student student = new Student();
        student.setName("\u0061");
        student.setAge(18);
        student.setStatus(true);

        ISerializer jacksonSerializer = new JacksonSerializer();

        long start = System.currentTimeMillis();
        int i=0;
        while (i<1){
            jacksonSerializer.ser(student);
            i++;
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public void fastjsondeser() throws Exception {

        String json = "{\"name\":\"a\",\"age\":18,\"status\":true}";
        long start = System.currentTimeMillis();
        ISerializer fastjsonSerializer = new FastjsonSerializer();
        int i=0;
        while (i<1000000){
            fastjsonSerializer.deser(json);
            i++;
        }

        System.out.println(System.currentTimeMillis() - start);

    }

    public void jacksondeser() throws Exception {
        String json = "{\"name\":\"a\",\"age\":18,\"status\":true}";
        long start = System.currentTimeMillis();
        ISerializer jacksonSerializer = new JacksonSerializer();
        int i=0;
        while (i<1000000){
            jacksonSerializer.deser(json);
            i++;
        }

        System.out.println(System.currentTimeMillis() - start);


    }

    public void warmUp(){
        int i=0;
        while (i<1000){
            Student student = new Student();
            student.setName("\u0061");
            student.setAge(18);
            student.setStatus(true);
            i++;
        }
    }



    //-------
    public static interface ISerializer{
        void ser(Student student) throws Exception;
        void deser(String json)throws Exception;
    }

    public static class JacksonSerializer implements ISerializer{
        ObjectMapper mapper = new ObjectMapper();

        @Override
        public void ser(Student student) throws JsonProcessingException {
            //输出json字符串
            String str = mapper.writeValueAsString(student);
            System.out.println(str);
        }

        @Override
        public void deser(String json) throws IOException {
            Student newVal = mapper.readValue(json,Student.class);
        }
    }

    public static class FastjsonSerializer implements ISerializer{

        @Override
        public void ser(Student student) throws Exception {
            String st = JSON.toJSONString(student);

        }

        @Override
        public void deser(String json) throws Exception {
            Student student = JSON.parseObject(json,Student.class);
        }
    }
}
