package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Twitter {
    
    private Map<Integer, Set<Integer>> follows;
    
    private Map<Integer, LinkedList<Tweet>> selfFeeds;
    
    private int time;
    
    private static class Tweet implements Comparable<Tweet> {
        
        private int id;
        
        private int timestamp;
        
        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
        
        public int compareTo(Tweet o) {
            return o.timestamp - this.timestamp;
        }
    }
    
    /** Initialize your data structure here. */
    public Twitter() {
        this.time = 0;
        this.follows = new HashMap<>();
        this.selfFeeds = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        LinkedList<Tweet> feeds = selfFeeds.getOrDefault(userId, new LinkedList<>());
        feeds.addFirst(new Tweet(tweetId, time));
        selfFeeds.putIfAbsent(userId, feeds);
        time++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        TreeSet<Tweet> recentFeeds = new TreeSet<>();
        
        Set<Integer> followees = follows.getOrDefault(userId, new HashSet<>());
        followees.add(userId);
        for (int fw : followees) {
            Iterator<Tweet> feedsIter = selfFeeds.getOrDefault(fw, new LinkedList<>()).iterator();
            while (feedsIter.hasNext()) {
                Tweet f = feedsIter.next();
                if (recentFeeds.size() < 10) {
                    recentFeeds.add(f);
                } else if (recentFeeds.last().compareTo(f) > 0) {
                    recentFeeds.pollLast();
                    recentFeeds.add(f);
                } else {
                    break;
                }
            }
        }
        
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (Tweet t : recentFeeds) {
            ret.add(t.id);
        }
        return ret;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = follows.getOrDefault(followerId, new HashSet<>());
        followees.add(followeeId);
        follows.putIfAbsent(followerId, followees);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = follows.get(followerId);
        if (followees != null && followees.contains(followeeId) && followeeId != followerId) {
            followees.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
