package Lab1;

public class Map {
    private Lab1.List keys;
    private Lab1.List values;

    public Map() {
        this.keys = new Lab1.List();
        this.values = new Lab1.List();
    }

    public Map(Object[] keys, Object[] values) {
        this.keys = new Lab1.List(keys);
        this.values = new Lab1.List(values);
    }

    public Map(Lab1.List keys, Lab1.List values) {
        this.keys = new Lab1.List(keys);
        this.values = new Lab1.List(values);
    }

    public Map(Map other) {
        this.keys = new Lab1.List(other.keys);
        this.values = new Lab1.List(other.values);
    }

    public void put(Object key, Object value) {
        if (this.keys.contains(key)) {
            this.values.set(value, this.keys.indexOf(key));
        } else {
            this.keys.add(key);
            this.values.add(value);
        }
    }

    public Object get(Object key) {
        int index = this.keys.indexOf(key);
        if (index != -1) {
            return this.values.get(index);
        } else return null;
    }

    public Object get(Object key, Object byDefault) {
        int index = this.keys.indexOf(key);
        if (index != -1) {
            Object result = this.values.get(index);
            if (result != null) {
                return result;
            } else {
                this.values.set(byDefault, index);
                return byDefault;
            }
        } else {
            this.put(key, byDefault);
            return byDefault;
        }
    }

    public Object remove(Object key) {
        int index = this.keys.indexOf(key);
        if (index != -1) {
            Object result = this.values.get(index);
            this.keys.remove(index);
            this.values.remove(index);
            return result;
        } else return null;
    }

    public boolean keyContains(Object key) {
        return this.keys.contains(key);
    }

    public Lab1.List getKeys() {
        return new Lab1.List(this.keys);
    }

    public Lab1.List getValues() {
        return new Lab1.List(this.values);
    }

    public Lab1.List getEntries() {
        Lab1.List result = new Lab1.List();
        for (int i = 0; i < this.keys.size(); ++i) {
            Pair pair = new Pair();
            pair.setFirst(this.keys.get(i));
            pair.setSecond(this.values.get(i));
            result.add(pair);
        }
        return new List(result);
    }

    public int size() {
        return this.keys.size();
    }

    public boolean isEmpty() {
        return this.keys.isEmpty();
    }

}
