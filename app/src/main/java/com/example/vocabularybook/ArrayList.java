package com.example.vocabularybook;

public class ArrayList {
    private int size;
    private Words[] data;

    public ArrayList(int capacity) {
        data = new Words[capacity];
        size = 0;
    }
    public ArrayList() {
        this(10);
    }

    public Words[] getData() {
        return data;
    }
    public void setData(Words[] data) {
        this.data = data;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
    public int getCapacity() {
        return data.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    //扩容
    private void resize(int newCapacity) {
        Words[] newData = new Words[newCapacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //添加数据
    public void add(int index, Words e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add is fail, require index < 0 || index > size");
        }
        if(data.length == size) {
            this.resize(data.length * 2);
        }
        for(int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //删除数据
    public Words remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("add is fail, require index < 0 || index > size");
        }
        Words value = data[index];
        for(int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length / 4 && data.length / 2 != 0) {
            this.resize(data.length / 2);
        }
        return value;
    }

    //查询数据
    public Words getByIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("add is fail, require index < 0 || index > size");
        }
        return data[index];
    }

    //更新数据
    public void set(int index, Words e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("add is fail, require index < 0 || index > size");
        }
        data[index] = e;
    }
}
