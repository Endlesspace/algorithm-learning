package 多线程;

import lombok.extern.slf4j.Slf4j;


import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;


import static java.lang.Thread.sleep;

@Slf4j
public class MessageQueue {
    private Deque<Message> queue = new LinkedList<>();
    private int capacity;


    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public Message get() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    log.info("empty waiting");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message ret = queue.removeFirst();
            queue.notifyAll();
            return ret;
        }
    }

    public void put(Message msg) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                try {
                    log.info("full waiting");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(msg);
            queue.notifyAll();
        }
    }

    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(2);
        //生产者
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                queue.put(new Message(id, id));
                log.info("create id " + id);
            }, "Thread" + i).start();
        }
        //消费者
        new Thread(() -> {
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message ret = queue.get();
                log.info("消费消息,得到id为" + ret.getId() + "的消息，内容为" + ret.getValue());
            }
        }, "消费者").start();
    }
}

class Message {
    private int id;
    private int value;

    public Message(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
