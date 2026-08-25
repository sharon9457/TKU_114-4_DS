import java.util.Arrays;
class DynmicArray<T>{
private Object[] object;
private int size;

DynmicArray(int dynmicArray){
    object = new Object[Math.max(1,dynmicArray)];
    size = 0;
}
public void add(T value){
    ensureCapacity();
    object[size] = value;
    size++;
}
public void add(int index,T value){
    if(index <0 || index > size){
        throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
    }
    ensureCapacity();
    for(int i = size;i>index;i--){
        object[i] = object[i -1];
     }
     object[index] = value;
      size++;
    }

public T get(int index){
    checkIndex(index);
    return(T) object[index];
}

public T set(int index,T value){
    checkIndex(index);
    T oldValue = (T) object[index];
    object[index] = value;
    return oldValue;
}

public T remove(int index){
    checkIndex(index);
    T removed = (T)object[index];
    for(int i = index;i<size -1;i++){
        object[i] = object[i+1];
    }
    size --;
    object[size] = null;
    return removed;
}

public int size(){
    return size;
}

public int capacity(){
    return object.length;
}

private void ensureCapacity(){
  if(size == object.length){
    object = Arrays.copyOf(object,object.length * 2);
    System.out.println("resize - >"+object.length);
  }}

private void checkIndex(int index){
    if(index <0 || index >= size){
        throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
    }
}

public String toString(){
    return Arrays.toString(Arrays.copyOf(object,size));
}
}

public class DynamicArrayPractice {
    public static void main(String[] args){
        DynmicArray values = new DynmicArray(2);
        values.add(10);
        values.add(50);
        values.add(100);

        System.out.println(values);
        System.out.println("removed="+values.remove(1));
        System.out.println(values);
        System.out.println("size="+values.size()+",capacity="+values.capacity());
    }
}
