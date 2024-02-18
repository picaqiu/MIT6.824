package org.mit.map_reduce.common;


import lombok.Data;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Data
public class KeyValue {
    private String key;
    private String value;


    public static void main(String[] args) throws IOException {
        File file = new File("D:\\gitcodes\\MIT6.824\\map_reduce\\src\\main\\resources\\test.txt");
        String content = "this is a test";
        ByteBuffer buffer = ByteBuffer.allocate(5);
        byte[] data = content.getBytes();
        FileOutputStream outputStream = new FileOutputStream(file);
        FileChannel fileChannel = outputStream.getChannel();
        for (int i = 0; i < data.length; ) {
            buffer.put(data, i, Math.min(data.length - i, buffer.limit() - buffer.position()));
            buffer.flip();
            i += fileChannel.write(buffer);
            buffer.compact();
        }

        fileChannel.write(buffer);
        fileChannel.force(false);
        fileChannel.close();
    }
}
