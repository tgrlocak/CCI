package com.dummy.extra;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * <p><b>Example Output</b><br/>
 * Produced: 0<br/>
 * Produced: 1<br/>
 * Consumed : 0<br/>
 * Produced: 2<br/>
 * Consumed : 1<br/>
 * Produced: 3<br/>
 * Consumed : 2<br/>
 * Produced: 4<br/>
 * Consumed : 3<br/>
 * Produced: 5<br/>
 * Consumed : 4<br/>
 * Produced: 6<br/>
 * Consumed : 5<br/>
 * Produced: 7<br/>
 * Consumed : 6<br/>
 * Produced: 8<br/>
 * Consumed : 7<br/>
 * Produced: 9<br/>
 * Consumed : 8<br/>
 * Consumed : 9<br/>
 * </p>
 * <p>As you see Producer Thread produced number and Consumer thread consumes it in FIFO order because blocking queue allows elements to be accessed in FIFO.</p>
 * @author tugrul.ocak
 *
 */
public class ProducerConsumerPattern {

  public static void main(String args[]) {
    //Creating shared object
    BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
    
    //Creating Producer and Consumer Thread
    Thread producer = new Thread(new Producer(sharedQueue));
    Thread consumer = new Thread(new Consumer(sharedQueue));
    
    //Starting Producer and Consumer thread
    producer.start();
    consumer.start();
  }

  static class Producer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
      this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {
        try {
          System.out.println("Produced: " + i);
          sharedQueue.put(i);
        } catch (InterruptedException e) {
          Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
  }
  
  static class Consumer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;
    
    public Consumer(BlockingQueue<Integer> sharedQueue) {
      this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
      while(true) {
        try {
          System.out.println("Consumed : " + sharedQueue.take());
        } catch (InterruptedException e) {
          Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
  }
}
