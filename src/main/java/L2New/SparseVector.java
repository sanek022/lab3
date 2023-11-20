package L2New;

import java.util.HashMap;
import java.util.Map;

public class SparseVector implements IVector {
    int dimension;
    Map<Integer, Integer> values = new HashMap<>();

    public SparseVector(int dimension)
    {
        this.dimension = dimension;
    }


    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public int getValue(int index) {
        return values.getOrDefault(index, 0);
    }

    @Override
    public void setValue(int index, int value) {
        values.put(index, value);
    }
}
