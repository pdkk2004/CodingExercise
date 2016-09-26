package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LoggerRateLimiter {

    private static class Event {
        String message;
        int timestamp;
        
        public Event(String msg, int t) {
            this.message = msg;
            this.timestamp = t;
        }
    }
    
    private Queue<Event> queue;
    private HashMap<String, Event> map;
    
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        this.queue = new LinkedList<>();
        this.map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && timestamp - queue.peek().timestamp >= 10) {
            Event toDel = queue.poll();
            map.remove(toDel.message);
        }
        
        if (!map.containsKey(message)) {
            Event e = new Event(message, timestamp);
            map.put(message, e);
            queue.offer(e);
            return true;
        } else {
            return false;
        }
    }
}
