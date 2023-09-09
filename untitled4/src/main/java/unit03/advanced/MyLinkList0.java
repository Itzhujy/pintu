package main.java.unit03.advanced;

/**
 * 技术要点：使用尾插法创建单链表
 * 假定结点数据类型为 String 类型
 * 链表类 MyLinkList0 包含结点成员类 Node（静态内部类）
 */

public class MyLinkList0 {  //表示链表的（外部）类
    static class Node  {  //表示链表的结点
        private String data;  //结点数据域
        private Node next;  //结点的指针域（指向下一个结点）、为自身数据类型
        
        public Node(String data, Node next) {  //用于创建结点的构造方法
            this.data = data;
            this.next = next;
        }
    }

    private Node head;  //头指针（按头结点理解）
    int size;  //链表长度（大小）

    public static void main(String[] args) {
        MyLinkList0 linkList = new MyLinkList0();  //创建链表对象
        System.out.println("-----1、初始链表---");
        linkList.initList();  //链表初始化
        //追加结点
        linkList.appendNode("珠海科技学院");
        linkList.appendNode("武昌理工学院");
        linkList.appendNode("武汉科技大学");
        //打印链表的全部数据
        linkList.printAllNodeData();

        System.out.println("-----2、测试插入---");
        linkList.insertNode(2,"广州工商学院【inserted】");
        linkList.printAllNodeData();

        System.out.println("-----3、测试修改-----");
        linkList.updateNodeData(2,"武汉工商学院【updated】");
        linkList.printAllNodeData();

        System.out.println("-----4、测试删除【删除插入的数据】-----");
        linkList.remove(2);
        linkList.printAllNodeData();
    }

    //初始化链表
    public void initList(){
        size=0;
        head=new Node(null,null);  //实例化链表的成员对象 head（头指针）
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //获取指定位置的结点（除链表结点外，还可以获取 head）
    public Node getNodeByIdex(int i){  //i为位置序号
        Node node=head;   //作为循环变量的 node，初值为 head
        for(int j=-1;j<i;j++){  //i=-1时，不会进入循环体，即 getNodeByIdex(-1)=head
            node=node.next;  //结点指针后移
        }
        return node;
    }

    //在链表末尾追加结点（尾插法）
    public void appendNode(String a){
        //创建新结点：分别设置数据域为 a、指针域为 null
        Node node=new Node(a,null);
        //将新结点作为尾结点
        getNodeByIdex(size-1).next=node;
        //修改长度
        size++;
    }

    //删除i位置结点，并返回删掉的数据
    public String remove(int i){
        if(i==size-1){
            String a=getNodeByIdex(size-1).data;
            getNodeByIdex(size-1).next=null;
            return a;
        }
        Node prev=getNodeByIdex(i-1);
        String a=prev.next.data;
        prev.next=prev.next.next;
        size--;
        return  a;
    }

    //在指定位置i插入新结点
    public void insertNode(int i,String a){
        Node prev=getNodeByIdex(i-1); //获取先前结点地址
        Node node=new Node(a,prev.next);
        prev.next=node;
        size++;
    }

    //获取指定位置i结点的数据
    public String getNodeDataByIndex(int i){
        return getNodeByIdex(i).data;
    }

    //为指定位置i元素重新赋值
    public void updateNodeData(int i,String a){
        getNodeByIdex(i).data=a;
    }

    //返回链表结点个数
    public int length(){
        return size;
    }

    //清空链表
    public void clear(){
        initList();
    }

    //打印链表中各结点的数据
    public  void printAllNodeData(){
        for(int i=0;i<size;i++){
            if(i>0){
                System.out.print("->");
            }
            System.out.print(getNodeByIdex(i).data);
        }
        System.out.println();
    }
}
