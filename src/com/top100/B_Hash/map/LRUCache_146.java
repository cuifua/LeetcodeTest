package com.top100.B_Hash.map;

import java.util.HashMap;

/*
因为查找和增删时间复杂度都为O（1），用一个数据容器是无法做到的，所以可以用LinkedList(增删为0（1）)和HashMap(查找为0（1）)
 */
class LRUCache
{
    private HashMap<Integer, Node> map;// key -> Node(key, val)
    private DoubleList cache;// Node(k1, v1) <-> Node(k2, v2)...
    private int cap;// 最大容量

    public LRUCache(int capacity)
    {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key)
    {
        if (!map.containsKey(key))
            return -1;

        int val = map.get(key).val;//得到key的映射--value
        put(key, val);// 利用 put 方法把该数据提前
        return val;
    }

    public void put(int key, int val)
    {
        // 先把新节点 x 做出来
        Node x = new Node(key, val);

        if (map.containsKey(key))
        {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);

            // 更新 map 中对应的数据
            map.put(key, x);
        }
        else
        {
            if (cap == cache.size()) //如果缓存已满
            {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}

class Node
{
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int k, int v)
    {
        this.key = k;
        this.val = v;
    }
}

class DoubleList
{
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int size;

    public DoubleList()
    {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表头部添加节点 n，时间 O(1)
    public void addFirst(Node n)
    {
        Node headNext = head.next;
        head.next = n;
        headNext.prev = n;
        n.prev = head;
        n.next = headNext;
        size++;
    }

    // 删除链表中的 n 节点（n 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node n)
    {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        size--;
    }

    //删除链表中最后一个节点，并返回该节点，时间 O(1)
    public Node removeLast()
    {
        Node last = tail.prev;
        remove(last);
        return last;
    }

    // 返回链表长度，时间 O(1)
    public int size()
    {
        return size;
    }
}

/*
// key 映射到 Node(key, val)  // Node(k1, v1) <-> Node(k2, v2)...
HashMap<Integer, Node> map;

DoubleList cache;

int get(int key)
{
    if (key 不存在)
        return -1;
     else
     {
        将数据 (key, val) 提到开头；
        return val;
    }
}

void put(int key, int val)
{
    Node x = new Node(key, val);
    if (key 已存在)
    {
        把旧的数据删除；
        将新节点 x 插入到开头；
    }
    else
    {
        if (cache 已满)
        {
            删除链表的最后一个数据腾位置；
            删除 map 中映射到该数据的键；
        }
        将新节点 x 插入到开头；
        map 中新建 key 对新节点 x 的映射；
    }
}
*/