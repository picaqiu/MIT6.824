package org.mit.map_reduce.common;

import java.util.List;

public interface Mapper {
    List<KeyValue> map(String file, String content);
}
