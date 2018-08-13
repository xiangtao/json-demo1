package big.data.json;

import big.data.json.bean.Student;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.IOException;

public class FastjsonDemo {

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
        String str = JSON.toJSONString(student);
        System.out.println("out json string = " + str);

        //从json string读入对象
        Student newVal = JSON.parseObject(str,Student.class);
        System.out.println("new Student = " + newVal);

    }


}
