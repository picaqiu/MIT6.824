package org.mit.map_reduce.common;

import java.util.List;

public interface Reducer {
   String reduce(String word, List<KeyValue> values);
}
