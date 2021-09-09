package com.top100.B_Hash.map;

import java.util.HashMap;

/*
��Ϊ���Һ���ɾʱ�临�Ӷȶ�ΪO��1������һ�������������޷������ģ����Կ�����LinkedList(��ɾΪ0��1��)��HashMap(����Ϊ0��1��)
 */
class LRUCache
{
    private HashMap<Integer, Node> map;// key -> Node(key, val)
    private DoubleList cache;// Node(k1, v1) <-> Node(k2, v2)...
    private int cap;// �������

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

        int val = map.get(key).val;//�õ�key��ӳ��--value
        put(key, val);// ���� put �����Ѹ�������ǰ
        return val;
    }

    public void put(int key, int val)
    {
        // �Ȱ��½ڵ� x ������
        Node x = new Node(key, val);

        if (map.containsKey(key))
        {
            // ɾ���ɵĽڵ㣬�µĲ嵽ͷ��
            cache.remove(map.get(key));
            cache.addFirst(x);

            // ���� map �ж�Ӧ������
            map.put(key, x);
        }
        else
        {
            if (cap == cache.size()) //�����������
            {
                // ɾ���������һ������
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // ֱ����ӵ�ͷ��
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

    // ������ͷ����ӽڵ� n��ʱ�� O(1)
    public void addFirst(Node n)
    {
        Node headNext = head.next;
        head.next = n;
        headNext.prev = n;
        n.prev = head;
        n.next = headNext;
        size++;
    }

    // ɾ�������е� n �ڵ㣨n һ�����ڣ�
    // ������˫�����Ҹ�����Ŀ�� Node �ڵ㣬ʱ�� O(1)
    public void remove(Node n)
    {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        size--;
    }

    //ɾ�����������һ���ڵ㣬�����ظýڵ㣬ʱ�� O(1)
    public Node removeLast()
    {
        Node last = tail.prev;
        remove(last);
        return last;
    }

    // ���������ȣ�ʱ�� O(1)
    public int size()
    {
        return size;
    }
}

/*
// key ӳ�䵽 Node(key, val)  // Node(k1, v1) <-> Node(k2, v2)...
HashMap<Integer, Node> map;

DoubleList cache;

int get(int key)
{
    if (key ������)
        return -1;
     else
     {
        ������ (key, val) �ᵽ��ͷ��
        return val;
    }
}

void put(int key, int val)
{
    Node x = new Node(key, val);
    if (key �Ѵ���)
    {
        �Ѿɵ�����ɾ����
        ���½ڵ� x ���뵽��ͷ��
    }
    else
    {
        if (cache ����)
        {
            ɾ����������һ��������λ�ã�
            ɾ�� map ��ӳ�䵽�����ݵļ���
        }
        ���½ڵ� x ���뵽��ͷ��
        map ���½� key ���½ڵ� x ��ӳ�䣻
    }
}
*/