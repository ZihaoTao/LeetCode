import java.util.*;

class Twitter {

    private int count;
    private Map<Integer, PriorityQueue<Item>> map;
    private Map<Integer, Set<Integer>> followList;
    private Map<Integer, Set<Integer>> followeeList;
    /** Initialize your data structure here. */
    public Twitter() {
        count = 0;
        map = new HashMap<>();
        followList = new HashMap<>();
        followeeList = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        count++;
        Item item = new Item(userId, tweetId, count);
        create(userId);
        Set<Integer> set = followeeList.get(userId);
        for(int i : set) {
            map.get(i).add(item);
        }

        map.get(userId).add(item);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        create(userId);
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Item> pq = map.get(userId);
        List<Item> temp = new ArrayList<>();
        for(int i = 0; i < 10 && !pq.isEmpty(); i++) {
            Item item = pq.remove();
            list.add(item.tweetId);
            temp.add(item);
        }
        for(Item i : temp) {
            pq.add(i);
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        create(followerId);
        create(followeeId);


        if (followList.get(followerId).contains(followeeId)) return;
        followList.get(followerId).add(followeeId);
        followeeList.get(followeeId).add(followerId);
        PriorityQueue<Item> pq1 = map.get(followerId);
        PriorityQueue<Item> pq2 = map.get(followeeId);

        for (Item i : pq2) {
            if(i.userId == followeeId) pq1.add(i);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        create(followerId);
        create(followeeId);
        if (!followList.get(followerId).contains(followeeId)) return;
        followList.get(followerId).remove(followeeId);
        followeeList.get(followeeId).remove(followerId);
        PriorityQueue<Item> pq = map.get(followerId);
        PriorityQueue<Item> temp = new PriorityQueue<Item>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.count - o1.count;
            }
        });
        for(Item i : pq) {
            if(i.userId != followeeId) {
                temp.add(i);
            }
        }
        map.put(followerId, temp);
    }

    private class Item {
        int userId;
        int tweetId;
        int count;
        private Item(int userId, int tweetId, int count) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.count = count;
        }
    }

    private void create(Integer id) {
        if(!map.containsKey(id)) {
            map.put(id, new PriorityQueue<Item>(new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    return o2.count - o1.count;
                }
            }));
        }
        if(!followList.containsKey(id)) {
            followList.put(id, new HashSet<Integer>());
        }
        if(!followeeList.containsKey(id)) {
            followeeList.put(id, new HashSet<Integer>());
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