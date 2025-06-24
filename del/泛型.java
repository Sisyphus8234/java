package test;

class NormalGeneric<T> {
    private T data;

    public NormalGeneric(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        NormalGeneric normalGeneric = new NormalGeneric<String>("dsfsafa");
        normalGeneric.setData(111);
        System.out.println(normalGeneric.getData());
    }
}
