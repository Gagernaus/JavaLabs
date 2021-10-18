package Lab1;

public class List {
    private Object[] data;

    public List() {
        this.data = new Object[0];
    }

    public List(Object[] arrayOfData) {
        this.data = new Object[arrayOfData.length];
        for (int i = 0; i < arrayOfData.length; ++i) {
            this.data[i] = arrayOfData[i];
        }
    }

    public List(List other) {
        this.data = new Object[other.data.length];
        System.arraycopy(other.data, 0, this.data, 0, other.data.length);
    }

    public void add(Object item) {
        Object[] newData = new Object[this.data.length + 1];
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
//        for (int i = 0; i < this.data.length - 1; ++i) {
//            newData[i] = this.data[i];
//        }
        newData[this.data.length] = item;
        this.data = newData;
    }

    public void add(Object item, int index) {
        if (index <= 0) {
            Object[] newData = new Object[this.data.length + 1];
            System.arraycopy(this.data, 0, newData, 1, this.data.length);
            newData[0] = item;
            this.data = newData;
        } else if (index >= this.data.length) {
            add(item);
        } else {
            Object[] newData = new Object[this.data.length + 1];
            System.arraycopy(this.data, 0, newData, 0, index);
            newData[index] = item;
            for (int i = index + 1; i < this.data.length + 1; ++i) {
                newData[i] = this.data[i - 1];
            }
            this.data = newData;
        }
    }

    public Object get(int index) {
        if (index <= 0)
            return this.data[0];
        else if (index >= this.data.length - 1)
            return this.data[this.data.length - 1];
        else return this.data[index];
    }

    public Object remove(int index) {
        Object result;
        Object[] newData = new Object[this.data.length - 1];
        if (index <= 0) {
            result = this.data[0];
            System.arraycopy(this.data, 1, newData, 0, this.data.length - 1);
            this.data = newData;
        } else if (index >= this.data.length - 1) {
            result = this.data[this.data.length - 1];
            System.arraycopy(this.data, 0, newData, 0, this.data.length - 1);
            this.data = newData;
        } else {
            result = this.data[index];
            System.arraycopy(this.data, 0, newData, 0, index);
            System.arraycopy(this.data, index + 1, newData, index, this.data.length - index - 1);
            this.data = newData;
        }
        return result;
    }

    public Object set(Object item, int index) {
        Object result;
        if (index <= 0) {
            result = this.data[0];
            this.data[0] = item;
        } else if (index >= this.data.length - 1) {
            result = this.data[this.data.length - 1];
            this.data[this.data.length - 1] = item;
        } else {
            result = this.data[index];
            this.data[index] = item;
        }
        return result;
    }

    public boolean contains(Object item) {
//        boolean result = false;
        for (int i = 0; i < this.data.length; ++i) {
            if (this.data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object item) {
        int index = -1;
        for (int i = 0; i < this.data.length; ++i) {
            if (this.data[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int size() {
        return this.data.length;
    }

    public boolean isEmpty() {
        if (this.data.length == 0)
            return true;
        else return false;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < this.data.length; ++i) {
            result += this.data[i].toString() + " ";
        }
        return result;
    }


}
