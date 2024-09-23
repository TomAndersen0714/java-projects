package org.tomandersen;

// import com.example.protos.ExampleMessage;
import com.google.protobuf.util.JsonFormat;

/**
 * @author TomAndersen
 */
public class JsonToProtobufExample {
    public static void main(String[] args) throws Exception {
        // // 定义一个 JSON字符串
        // String jsonString = "{\"id\": 1, \"name\": \"John Doe\"}";
        //
        // // 创建一个空的ExampleMessage.Builder对象
        // ExampleMessage.Builder builder = ExampleMessage.newBuilder();
        //
        // // 使用JsonFormat将JSON解析为Protocol Buffers消息
        // JsonFormat.parser().ignoringUnknownFields().merge(jsonString, builder);
        //
        // // 构建最终的Protocol Buffers消息
        // ExampleMessage message = builder.build();
        //
        // // 打印转换后的消息
        // System.out.println("ID: " + message.getId());
        // System.out.println("Name: " + message.getName());
    }
}
